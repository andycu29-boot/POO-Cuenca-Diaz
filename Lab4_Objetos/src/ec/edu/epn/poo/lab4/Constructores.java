package ec.edu.epn.poo.lab4;

public class Constructores {
    public static void main(String[] args) {
        Producto c = new Producto("Cuaderno", 2.50, 10, "Papelería");
        Producto e = new Producto("Esfero", 0.75, 50, "Escritura");
        System.out.println(c.nombre + " " + c.precio + " " + c.stock + " (" + c.categoria + ")");
        System.out.println(e.nombre + " " + e.precio + " " + e.stock + " (" + e.categoria + ")");
    }
}