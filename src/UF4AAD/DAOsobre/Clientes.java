package UF4AAD.DAOsobre;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;


/**
 * Created by 48089748z on 12/04/16.
 */

    import javax.xml.bind.annotation.XmlAccessorType;
    import javax.xml.bind.annotation.XmlElement;
    import javax.xml.bind.annotation.XmlRootElement;
    import javax.xml.bind.annotation.XmlType;
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {"cliente"})
    @XmlRootElement(name = "clientes")
    public class Clientes
    {
        @XmlElement(name = "cliente", required = true)
        protected ArrayList<Cliente> cliente;
        public ArrayList<Cliente> getClientes()
        {
            if (cliente == null) {cliente = new ArrayList<Cliente>();}
            return this.cliente;
        }
        public Clientes(){}

}
