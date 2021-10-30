
package predictions.clientSOAP;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prediction complex type.
 * 
 * <p>The following schema fragment specifies the expected         content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prediction"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="what" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="who" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prediction", propOrder = {
    "id",
    "what",
    "who"
})
public class Prediction {

    protected int id;
    protected String what;
    protected String who;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the what property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWhat() {
        return what;
    }

    /**
     * Sets the value of the what property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWhat(String value) {
        this.what = value;
    }

    /**
     * Gets the value of the who property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWho() {
        return who;
    }

    /**
     * Sets the value of the who property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWho(String value) {
        this.who = value;
    }

}
