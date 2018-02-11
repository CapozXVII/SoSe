
package it.univaq.disim.sose.cald.cinemainformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hallType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hallType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seatsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="hallInfo" type="{http://it.univaq.disim.sose.cald/cinemaInformation}hallInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hallType", propOrder = {
    "id",
    "number",
    "seatsNumber",
    "hallInfo"
})
public class HallType {

    protected long id;
    protected int number;
    protected int seatsNumber;
    @XmlElement(required = true)
    protected HallInfoType hallInfo;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the number property.
     * 
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     */
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Gets the value of the seatsNumber property.
     * 
     */
    public int getSeatsNumber() {
        return seatsNumber;
    }

    /**
     * Sets the value of the seatsNumber property.
     * 
     */
    public void setSeatsNumber(int value) {
        this.seatsNumber = value;
    }

    /**
     * Gets the value of the hallInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HallInfoType }
     *     
     */
    public HallInfoType getHallInfo() {
        return hallInfo;
    }

    /**
     * Sets the value of the hallInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HallInfoType }
     *     
     */
    public void setHallInfo(HallInfoType value) {
        this.hallInfo = value;
    }

}
