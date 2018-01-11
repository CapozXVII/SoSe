
package it.univaq.disim.sose.cald.restaurantInserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per tableType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="tableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="seatsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "seatsNumber"
})
public class TableType {

    protected int number;
    protected int seatsNumber;

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

}
