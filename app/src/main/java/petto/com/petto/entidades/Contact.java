package petto.com.petto.entidades;

import java.io.Serializable;

public class Contact implements Serializable {

    private String name;
    private String info;
    private String descripcion;
    private String imagen;

    public Contact(String name, String descripcion, String imagen) {
        this.name = name;
        this.descripcion = descripcion;
        this.imagen = imagen;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}