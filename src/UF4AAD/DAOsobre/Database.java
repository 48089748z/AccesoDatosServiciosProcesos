package UF4AAD.DAOsobre;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by 48089748z on 12/04/16.
 */
@XmlRootElement(name = "database")
public class Database
{
    @XmlElement(name = "clientes", required = true)
    protected List<Cliente> clientes;

    @XmlElement(name = "empleados", required = true)
    protected List<Empleado> empleados;

    @XmlElement(name = "facturas", required = true)
    protected List<Factura> facturas;

    @XmlElement(name = "catalogo", required = true)
    protected List<Producto> productos;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
