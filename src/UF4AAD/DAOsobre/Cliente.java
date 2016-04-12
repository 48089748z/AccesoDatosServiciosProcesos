package UF4AAD.DAOsobre;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by 48089748z on 12/04/16.
 */
@XmlRootElement(name = "cliente")
public class Cliente
{
    @XmlElement(name = "nif", required = true)
    String nif;
    @XmlElement(name = "nombre", required = true)
    String nombre;
    @XmlElement(name = "apellido", required = true)
    String apellido;
    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
