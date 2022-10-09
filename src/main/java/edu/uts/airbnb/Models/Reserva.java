package edu.uts.airbnb.Models;
import javax.persistence.*;

@Entity
@Table(name = "Reverva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "idPropiedad")
    private long idPropiedad;

    @Column(name = "Total")
    private long Total;

    @Column(name = "Abono")
    private long Abono;

    @Column(name = "TipoPago")
    private int tipoPago;

    @Column (name = "Telefono")
    private long telefono;

    @Column (name = "CantHuespedes")
    private int cantHuespedes;

    public Reserva () {

    }

    public Reserva(long id, long idPropiedad, long total, long abono, int tipoPago, long telefono, int cantHuespedes) {
        this.id = id;
        this.idPropiedad = idPropiedad;
        Total = total;
        Abono = abono;
        this.tipoPago = tipoPago;
        this.telefono = telefono;
        this.cantHuespedes = cantHuespedes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(long idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public long getTotal() {
        return Total;
    }

    public void setTotal(long total) {
        Total = total;
    }

    public long getAbono() {
        return Abono;
    }

    public void setAbono(long abono) {
        Abono = abono;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public int getCantHuespedes() {
        return cantHuespedes;
    }

    public void setCantHuespedes(int cantHuespedes) {
        this.cantHuespedes = cantHuespedes;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idPropiedad=" + idPropiedad +
                ", Total=" + Total +
                ", Abono=" + Abono +
                ", tipoPago=" + tipoPago +
                ", telefono=" + telefono +
                ", cantHuespedes=" + cantHuespedes +
                '}';
    }
}
