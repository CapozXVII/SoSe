
package it.univaq.disim.sose.cald.cinemaInserting;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="hallInfo" type="{http://it.univaq.disim.sose.cald/cinemaInserting}hallInfoType" maxOccurs="unbounded"/&gt;
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
    protected List<HallInfoType> hallInfo;

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
     * Gets the value of the hallInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hallInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHallInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HallInfoType }
     * 
     * 
     */
    public List<HallInfoType> getHallInfo() {
        if (hallInfo == null) {
            hallInfo = new ArrayList<HallInfoType>();
        }
        return this.hallInfo;
    }

}
