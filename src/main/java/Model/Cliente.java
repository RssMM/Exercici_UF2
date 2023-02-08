package Model;

import jakarta.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idCliente;

    @Column
    private String nombre;

    @Column
    private boolean vip;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "direccion", column = @Column(name = "direccion")),
            @AttributeOverride( name = "ciudad", column = @Column(name = "ciudad")),
            @AttributeOverride( name = "provincia", column = @Column(name = "provincia")),
            @AttributeOverride( name = "codigoPostal", column = @Column(name = "codigoPostal"))
    })
    private Direccion direccioEnvio;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride( name = "direccion", column = @Column(name = "direccion1")),
            @AttributeOverride( name = "ciudad", column = @Column(name = "ciudad1")),
            @AttributeOverride( name = "provincia", column = @Column(name = "provincia1")),
            @AttributeOverride( name = "codigoPostal", column = @Column(name = "codigoPostal1"))
    })
    private Direccion direccionFacturacion;

    public Cliente() {
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccioEnvio() {
        return direccioEnvio;
    }

    public void setDireccioEnvio(Direccion direccioEnvio) {
        this.direccioEnvio = direccioEnvio;
    }

    public Direccion getDireccionFacturacion() {
        return direccionFacturacion;
    }

    public void setDireccionFacturacion(Direccion direccionFacturacion) {
        this.direccionFacturacion = direccionFacturacion;
    }

    public Cliente(String nombre, boolean vip) {
        this.nombre = nombre;
        this.vip = vip;
    }

}

