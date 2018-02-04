
package it.univaq.disim.sose.cald.restaurantInserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per restaurantInfoType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="restaurantInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telephoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="style" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cuisine" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="menu" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="discount" type="{http://it.univaq.disim.sose.cald/restaurantInserting}discountType" minOccurs="0"/&gt;
 *         &lt;element name="max_seats" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "restaurantInfoType", propOrder = {
    "name",
    "address",
    "cap",
    "city",
    "telephoneNumber",
    "style",
    "cuisine",
    "menu",
    "discount",
    "maxSeats"
})
public class RestaurantInfoType {

    protected String name;
    @XmlElement(required = true)
    protected String address;
    @XmlElement(required = true)
    protected String cap;
    @XmlElement(required = true)
    protected String city;
    protected String telephoneNumber;
    @XmlElement(required = true)
    protected String style;
    @XmlElement(required = true)
    protected String cuisine;
    @XmlElement(required = true)
    protected String menu;
    protected DiscountType discount;
    @XmlElement(name = "max_seats")
    protected int maxSeats;

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Recupera il valore della proprietà address.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Imposta il valore della proprietà address.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Recupera il valore della proprietà cap.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCap() {
        return cap;
    }

    /**
     * Imposta il valore della proprietà cap.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCap(String value) {
        this.cap = value;
    }

    /**
     * Recupera il valore della proprietà city.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Imposta il valore della proprietà city.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Recupera il valore della proprietà telephoneNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Imposta il valore della proprietà telephoneNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelephoneNumber(String value) {
        this.telephoneNumber = value;
    }

    /**
     * Recupera il valore della proprietà style.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStyle() {
        return style;
    }

    /**
     * Imposta il valore della proprietà style.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStyle(String value) {
        this.style = value;
    }

    /**
     * Recupera il valore della proprietà cuisine.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuisine() {
        return cuisine;
    }

    /**
     * Imposta il valore della proprietà cuisine.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuisine(String value) {
        this.cuisine = value;
    }

    /**
     * Recupera il valore della proprietà menu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMenu() {
        return menu;
    }

    /**
     * Imposta il valore della proprietà menu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMenu(String value) {
        this.menu = value;
    }

    /**
     * Recupera il valore della proprietà discount.
     * 
     * @return
     *     possible object is
     *     {@link DiscountType }
     *     
     */
    public DiscountType getDiscount() {
        return discount;
    }

    /**
     * Imposta il valore della proprietà discount.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscountType }
     *     
     */
    public void setDiscount(DiscountType value) {
        this.discount = value;
    }

    /**
     * Recupera il valore della proprietà maxSeats.
     * 
     */
    public int getMaxSeats() {
        return maxSeats;
    }

    /**
     * Imposta il valore della proprietà maxSeats.
     * 
     */
    public void setMaxSeats(int value) {
        this.maxSeats = value;
    }

}
