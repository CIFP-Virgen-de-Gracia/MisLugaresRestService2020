package com.example.mislugaresrest.model;

import javax.persistence.*;

// Le decimos a Spring que es una Entidad y la tabla.
@Entity
@Table(name = "lugares")
public class Lugar {

    // Analizamos los atributos de la tabla
    // Indicamos los campos
    // ID, columna id de la tabla productos y es autoincrementable
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //columna nombre, no nulo, longitud de 50
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    //columna tipo, no nulo, longitud de 30
    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    //columna fecha, no nulo, longitud de 20
    @Column(name = "fecha", nullable = false, length = 20)
    private String fecha;

    //columna latitud
    @Column(name = "latitud")
    private Float latitud;

    //columna latitud
    @Column(name = "longitud")
    private Float longitud;

    //columna imagen
    @Lob
    @Column(name = "imagen")
    private String imagen;


    public Lugar() {

    }

    /**
     * Constructor de la clase Lugar
     *
     * @param id       Identificador, ID
     * @param nombre   Nombre de Lugar
     * @param tipo     Tipo de Lugar
     * @param fecha    Fecha de Lugar
     * @param latitud  Latitud del Lugar
     * @param longitud Longitud de Lugar
     * @param imagen   Imagen de Lugar
     */
    public Lugar(Long id, String nombre, String tipo, String fecha, Float latitud, Float longitud, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Float getLatitud() {
        return latitud;
    }

    public void setLatitud(Float latitud) {
        this.latitud = latitud;
    }

    public Float getLongitud() {
        return longitud;
    }

    public void setLongitud(Float longitud) {
        this.longitud = longitud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
