
package it.univaq.disim.sose.cald.cinemainserting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per filmType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="filmType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id_film" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="cast" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="plot" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "filmType", propOrder = {
    "idFilm",
    "name",
    "director",
    "cast",
    "duration",
    "type",
    "plot"
})
public class FilmType {

    @XmlElement(name = "id_film")
    protected Long idFilm;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String director;
    @XmlElement(required = true)
    protected String cast;
    protected int duration;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(required = true)
    protected String plot;

    /**
     * Recupera il valore della proprietà idFilm.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdFilm() {
        return idFilm;
    }

    /**
     * Imposta il valore della proprietà idFilm.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdFilm(Long value) {
        this.idFilm = value;
    }

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
     * Recupera il valore della proprietà director.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirector() {
        return director;
    }

    /**
     * Imposta il valore della proprietà director.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirector(String value) {
        this.director = value;
    }

    /**
     * Recupera il valore della proprietà cast.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCast() {
        return cast;
    }

    /**
     * Imposta il valore della proprietà cast.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCast(String value) {
        this.cast = value;
    }

    /**
     * Recupera il valore della proprietà duration.
     * 
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Imposta il valore della proprietà duration.
     * 
     */
    public void setDuration(int value) {
        this.duration = value;
    }

    /**
     * Recupera il valore della proprietà type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Imposta il valore della proprietà type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Recupera il valore della proprietà plot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlot() {
        return plot;
    }

    /**
     * Imposta il valore della proprietà plot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlot(String value) {
        this.plot = value;
    }

}
