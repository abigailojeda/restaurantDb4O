package domain;

public class Plato {
    private String nombrePlato;
    private double precioPlato;

    public Plato(String nombrePlato, float precioPlato) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
    }

    public Plato() {

    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(double precioPlato) {
        this.precioPlato = precioPlato;
    }
}
