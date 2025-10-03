package br.edu.ifpr.pgua.eic.tads.models;

public class Notas {
    private double n1, n2, n3, n4;

    public Notas(double n1, double n2, double n3, double n4) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
    }

    public double getN1() { return n1; }
    public double getN2() { return n2; }
    public double getN3() { return n3; }
    public double getN4() { return n4; }

    @Override
    public String toString() {
        return n1 + "," + n2 + "," + n3 + "," + n4;
    }

    public static Notas fromString(String s) {
        String[] partes = s.split(",");
        return new Notas(
            Double.parseDouble(partes[0]),
            Double.parseDouble(partes[1]),
            Double.parseDouble(partes[2]),
            Double.parseDouble(partes[3])
        );
    }
}