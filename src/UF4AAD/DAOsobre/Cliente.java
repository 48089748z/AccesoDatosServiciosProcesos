package UF4AAD.DAOsobre;
import javax.xml.bind.annotation.*;


/**
 * Created by 48089748z on 12/04/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "nif",
        "nombre",
        "apellido"
})
@XmlRootElement(name = "cliente")
public class Cliente
{
    @XmlElement(name = "nif", required = true)
    protected String nif;
    @XmlElement(name = "nombre", required = true)
    protected String nombre;
    @XmlElement(name = "apellido", required = true)
    protected String apellido;

    public Cliente(){}
    public Cliente(String nif, String nombre, String apellido)
    {
        this.nif = nif;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public String getNif() {return nif;}
    public void setNif(String nif) {this.nif = nif;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
