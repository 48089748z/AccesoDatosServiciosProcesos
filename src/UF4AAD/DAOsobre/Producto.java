package UF4AAD.DAOsobre;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 48089748z on 12/04/16.
 */
@XmlRootElement(name = "producto")
public class Producto
{
    @XmlElement(name = "id", required = true)
    String id;
    @XmlElement(name = "nombre", required = true)
    String nombre;
    @XmlElement(name = "precio", required = true)
    String precio;
    @XmlElement(name = "stock", required = true)
    String stock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
