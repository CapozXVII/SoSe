
package it.univaq.disim.sose.cald.restaurantinserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per restaurantUpdateResponse complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="restaurantUpdateResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accepted" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restaurantUpdateResponse", propOrder = {
    "accepted"
})
public class RestaurantUpdateResponse {

    protected boolean accepted;

    /**
     * Recupera il valore della proprietà accepted.
     * 
     */
    public boolean isAccepted() {
        return accepted;
    }

    /**
     * Imposta il valore della proprietà accepted.
     * 
     */
    public void setAccepted(boolean value) {
        this.accepted = value;
    }

}
