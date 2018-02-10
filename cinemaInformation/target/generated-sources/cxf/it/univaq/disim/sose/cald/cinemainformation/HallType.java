
package it.univaq.disim.sose.cald.cinemainformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per hallType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="hallType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
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
    "number",
    "seatsNumber",
    "hallInfo"
})
public class HallType {

    protected int number;
    protected int seatsNumber;
    @XmlElement(required = true)
    protected HallInfoType hallInfo;

    /**
     * Recupera il valore della proprietà number.
     * 
     */
    public int getNumber() {
        return number;
    }

    /**
     * Imposta il valore della proprietà number.
     * 
     */
    public void setNumber(int value) {
        this.number = value;
    }

    /**
     * Recupera il valore della proprietà seatsNumber.
     * 
     */
    public int getSeatsNumber() {
        return seatsNumber;
    }

    /**
     * Imposta il valore della proprietà seatsNumber.
     * 
     */
    public void setSeatsNumber(int value) {
        this.seatsNumber = value;
    }

    /**
     * Recupera il valore della proprietà hallInfo.
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
     * Imposta il valore della proprietà hallInfo.
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
