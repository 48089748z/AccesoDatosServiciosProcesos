package UF4AAD.DAOsobre;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * Created by 48089748z on 12/04/16.
 */
@XmlRootElement(name = "empleado")
public class Empleado {
    @XmlElement(name = "id", required = true)
    String id;
    @XmlElement(name = "nombre", required = true)
    String nombre;
    @XmlElement(name = "apellido", required = true)
    String apellido;
    @XmlElement(name = "sueldo", required = true)
    String sueldo;
    @XmlElement(name = "años_trabajados", required = true)
    String años_trabajados;
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
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getSueldo() {
        return sueldo;
    }
    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
    public String getAños_trabajados() {
        return años_trabajados;
    }
    public void setAños_trabajados(String años_trabajados) {
        this.años_trabajados = años_trabajados;
    }
}
