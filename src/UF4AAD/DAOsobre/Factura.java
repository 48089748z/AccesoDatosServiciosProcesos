package UF4AAD.DAOsobre;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by 48089748z on 12/04/16.
 */
@XmlRootElement(name = "factura")
public class Factura {
    @XmlElement(name = "nif_cliente", required = true)
    String nif_cliente;
    @XmlElement(name = "id_producto", required = true)
    String id_producto;
    @XmlElement(name = "precio_unidad", required = true)
    String precio_unidad;
    @XmlElement(name = "precio_total", required = true)
    String precio_total;
    @XmlElement(name = "iva", required = true)
    String iva;

    public String getNif_cliente() {
        return nif_cliente;
    }

    public void setNif_cliente(String nif_cliente) {
        this.nif_cliente = nif_cliente;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(String precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public String getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(String precio_total) {
        this.precio_total = precio_total;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }
}
