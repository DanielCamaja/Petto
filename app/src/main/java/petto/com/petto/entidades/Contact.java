package petto.com.petto.entidades;

import java.io.Serializable;

public class Contact implements Serializable {

    private String name;
    private String info;
    private String descripcion;
    private int imagenId;
    private int imagenCorreo;


    public Contact() {
    }

    public Contact(String name, String info,String descripcion, int imagenId, int imagenDetalle) {
        this.name = name;
        this.info = info;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
        this.imagenCorreo = imagenDetalle;

    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenId() {
        return imagenId;
    }

    public void setImagenId(int imagenId) {
        this.imagenId = imagenId;
    }

    public int getImagenCorreo() {
        return imagenCorreo;
    }

    public void setImagenCorreo(int imagenCorreo) {
        this.imagenCorreo = imagenCorreo;
    }
}
