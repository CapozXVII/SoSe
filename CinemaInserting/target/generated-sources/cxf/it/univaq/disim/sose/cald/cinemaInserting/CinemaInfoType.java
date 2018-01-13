
package it.univaq.disim.sose.cald.cinemaInserting;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per cinemaInfoType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="cinemaInfoType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cap" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="telephoneNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="hall" type="{http://it.univaq.disim.sose.cald/cinemaInserting}hallType" maxOccurs="unbounded"/&gt;
 *         &lt;element name="films" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="discount" type="{http://it.univaq.disim.sose.cald/cinemaInserting}discountType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cinemaInfoType", propOrder = {
    "name",
    "address",
    "cap",
    "city",
    "telephoneNumber",
    "hall",
    "films",
    "discount"
})
public class CinemaInfoType {

    protected String name;
    @XmlElement(required = true)
    protected String address;
    protected int cap;
    @XmlElement(required = true)
    protected String city;
    protected String telephoneNumber;
    @XmlElement(required = true)
    protected List<HallType> hall;
    @XmlElement(required = true)
    protected String films;
    protected DiscountType discount;

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
     */
    public int getCap() {
        return cap;
    }

    /**
     * Imposta il valore della proprietà cap.
     * 
     */
    public void setCap(int value) {
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
     * Gets the value of the hall property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hall property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHall().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HallType }
     * 
     * 
     */
    public List<HallType> getHall() {
        if (hall == null) {
            hall = new ArrayList<HallType>();
        }
        return this.hall;
    }

    /**
     * Recupera il valore della proprietà films.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilms() {
        return films;
    }

    /**
     * Imposta il valore della proprietà films.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilms(String value) {
        this.films = value;
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

}
