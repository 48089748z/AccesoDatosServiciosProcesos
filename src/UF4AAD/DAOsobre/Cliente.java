package UF4AAD.DAOsobre;

import UF1AAD.PokemonsJAXB.Nombre;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigInteger;

/**
 * Created by 48089748z on 12/04/16.
 */
@XmlRootElement(name = "cliente")
public class Cliente
{
    @XmlElement(name = "nif", required = true)
    protected String nif;
    @XmlElement(name = "nombre", required = true)
    protected String nombre;
    @XmlElement(name = "apellido", required = true)
    protected String apellido;

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
