
package it.univaq.disim.sose.cald.enjoyReservation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seatsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tableInfo" type="{http://it.univaq.disim.sose.cald/enjoyReservation}hallInfoType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tableType", propOrder = {
    "number",
    "seatsNumber",
    "tableInfo"
})
public class TableType {

    protected int number;
    protected int seatsNumber;
    @XmlElement(required = true)
    protected HallInfoType tableInfo;

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
     * Gets the value of the tableInfo property.
     * 
     * @return
     *     possible object is
     *     {@link HallInfoType }
     *     
     */
    public HallInfoType getTableInfo() {
        return tableInfo;
    }

    /**
     * Sets the value of the tableInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link HallInfoType }
     *     
     */
    public void setTableInfo(HallInfoType value) {
        this.tableInfo = value;
    }

}
