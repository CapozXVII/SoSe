
package it.univaq.disim.sose.cald.clients.restaurantInformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for tableInfoType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tableInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reservationTime" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="reservationName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tableInfoType", propOrder = {
    "reservationTime",
    "reservationName"
})
public class TableInfoType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reservationTime;
    @XmlElement(required = true)
    protected String reservationName;

    /**
     * Gets the value of the reservationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReservationTime() {
        return reservationTime;
    }

    /**
     * Sets the value of the reservationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReservationTime(XMLGregorianCalendar value) {
        this.reservationTime = value;
    }

    /**
     * Gets the value of the reservationName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationName() {
        return reservationName;
    }

    /**
     * Sets the value of the reservationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationName(String value) {
        this.reservationName = value;
    }

}
