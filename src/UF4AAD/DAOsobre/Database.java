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
    protected List<Cliente> arrayClientes;

    @XmlElement(name = "empleados", required = true)
    protected List<Empleado> arrayEmpleados;

    @XmlElement(name = "facturas", required = true)
    protected List<Factura> arrayFacturas;

    @XmlElement(name = "catalogo", required = true)
    protected List<Producto> arrayProductos;

    public List<Cliente> getArrayClientes() {
        return arrayClientes;
    }

    public void setArrayClientes(List<Cliente> arrayClientes) {
        this.arrayClientes = arrayClientes;
    }

    public List<Empleado> getArrayEmpleados() {
        return arrayEmpleados;
    }

    public void setArrayEmpleados(List<Empleado> arrayEmpleados) {
        this.arrayEmpleados = arrayEmpleados;
    }

    public List<Factura> getArrayFacturas() {
        return arrayFacturas;
    }

    public void setArrayFacturas(List<Factura> arrayFacturas) {
        this.arrayFacturas = arrayFacturas;
    }

    public List<Producto> getArrayProductos() {
        return arrayProductos;
    }

    public void setArrayProductos(List<Producto> arrayProductos) {
        this.arrayProductos = arrayProductos;
    }
}
