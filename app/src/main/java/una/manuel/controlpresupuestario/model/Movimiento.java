package una.manuel.controlpresupuestario.model;

import java.util.Date;

/**
 * Created by toshiba1 on 07/04/2018.
 */

public class Movimiento {
    private long idMovimiento;
    private  String descripcion;
    private Date fecha;
    private Categoria categoria;

    public Movimiento(long idMovimiento, String descripcion, Date fecha, Categoria categoria) {
        this.idMovimiento = idMovimiento;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
