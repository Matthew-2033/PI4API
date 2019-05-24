package AcademiaGestaoWebApi.Models;

public class DensidadeCorporal {

    private String autor;

    private double DensidadeCorporal;

    public DensidadeCorporal() {

    }

    public DensidadeCorporal(String autor, double DensidadeCorporal) {
        this.autor = autor;
        this.DensidadeCorporal = DensidadeCorporal;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getDensidadeCorporal() {
        return DensidadeCorporal;
    }

    public void setDensidadeCorporal(double DensidadeCorporal) {
        this.DensidadeCorporal = DensidadeCorporal;
    }
}
