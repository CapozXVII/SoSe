package it.univaq.disim.sose.cald.accountmanager.business.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.univaq.disim.sose.cald.accountmanager.CheckSessionFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.CheckSessionRequest;
import it.univaq.disim.sose.cald.accountmanager.CheckSessionResponse;
import it.univaq.disim.sose.cald.accountmanager.UserLoginFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserLoginRequest;
import it.univaq.disim.sose.cald.accountmanager.UserLoginResponse;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutRequest;
import it.univaq.disim.sose.cald.accountmanager.UserLogoutResponse;
import it.univaq.disim.sose.cald.accountmanager.UserSignupFault_Exception;
import it.univaq.disim.sose.cald.accountmanager.UserSignupRequest;
import it.univaq.disim.sose.cald.accountmanager.UserSignupResponse;
import it.univaq.disim.sose.cald.accountmanager.business.AccountManagerService;
import it.univaq.disim.sose.cald.accountmanager.business.Utility;
import it.univaq.disim.sose.cald.accountmanager.business.model.User;

@Service
public class JDBCAccountManagerServiceImpl implements AccountManagerService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(JDBCAccountManagerServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	public UserSignupResponse userSignup(UserSignupRequest parameters) throws UserSignupFault_Exception {
		UserSignupResponse response = new UserSignupResponse();
		Connection con = null;
		PreparedStatement stInsertUser = null, stInsertSession = null;
		
		try {
			con = dataSource.getConnection();
			stInsertUser = con.prepareStatement(
				"INSERT INTO users (name,surname,email,password,username) VALUES (?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		
			stInsertUser.setString(1, parameters.getName());
			stInsertUser.setString(2, parameters.getSurname());
			stInsertUser.setString(3, parameters.getEmail());
			stInsertUser.setString(4, parameters.getPassword());
			stInsertUser.setString(5, parameters.getUsername());
		
		if(stInsertUser.executeUpdate() == 1) {
			int idUtente = 0;
			try (ResultSet keys = stInsertUser.getGeneratedKeys()) {
				if (keys.next()) {
					idUtente = keys.getInt(1);
				}
				
				stInsertSession = con.prepareStatement("INSERT INTO sessions (token,user) VALUES (?,?)");
				
				String token = Utility.generateToken();
				
				stInsertSession.setString(1, token);
				stInsertSession.setInt(2, idUtente);
				
				if(stInsertSession.executeUpdate() == 1) {
					response.setToken(token);
				}
				else {
					response.setToken(null);
				}
			}
		} else {
			response.setToken(null);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserSignupFault_Exception("Something was wrong with User Signup");
		} finally {
			if (stInsertUser != null) {
				try {
					stInsertUser.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
		return response;
	}

	@Override
	public UserLoginResponse userLogin(UserLoginRequest parameters) throws UserLoginFault_Exception {
		UserLoginResponse response = new UserLoginResponse();
		String sql = "SELECT * FROM users WHERE email = ?";
		String sqlSession = "INSERT into sessions(token, user) VALUES(?,?)";
		LOGGER.info(sql);
		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st1 = null;
		ResultSet rs = null;
		
		try {
			User user = new User();
			
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			
			st.setString(1, parameters.getEmail());
			rs = st.executeQuery();
			rs.last();
			int num_rows = rs.getRow();
			rs.first();
			if(num_rows != 0 && parameters.getPassword().equals(rs.getString("password"))) {
				user.setId(rs.getLong("user_id"));
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				user.setSurname(rs.getString("surname"));
				user.setUsername(rs.getString("username"));
				
				String token = Utility.generateToken();
				
				st1 = con.prepareStatement(sqlSession);
				st1.setString(1, token);
				st1.setLong(2, user.getId());
				
				if(st1.executeUpdate() == 1) {
					response.setToken(token);
				} else {
					response.setToken(null);
				}
			} else {
				response.setToken(null);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserLoginFault_Exception("Something was wrong with User Login");
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
		return response;
	}

	@Override
	public CheckSessionResponse checkSession(CheckSessionRequest parameters) throws CheckSessionFault_Exception {
		CheckSessionResponse response = new CheckSessionResponse();
		String sql = "SELECT * FROM sessions WHERE token = ?";
		LOGGER.info(sql);
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {			
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			
			st.setString(1, parameters.getToken());
			rs = st.executeQuery();
			
			rs.last();
			int num_rows = rs.getRow();
			
			if(num_rows != 0) {
				response.setResponse(true);
			} else {
				response.setResponse(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new CheckSessionFault_Exception("Something was wrong with Checking Session");
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
		return response;
	}

	@Override
	public UserLogoutResponse userLogout(UserLogoutRequest parameters) throws UserLogoutFault_Exception {
		UserLogoutResponse response = new UserLogoutResponse();
		String sql = "DELETE FROM sessions WHERE token = ?";
		LOGGER.info(sql);
		Connection con = null;
		PreparedStatement st = null;
		
		try {			
			con = dataSource.getConnection();
			st = con.prepareStatement(sql);
			
			st.setString(1, parameters.getToken());
			if(st.executeUpdate() == 1) {
				response.setResponse("Logout Success");
			} else {
				response.setResponse("Logout Wrong");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UserLogoutFault_Exception("Something was wrong with User Logout");
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {}
			}
		}
		return response;
	}

}
