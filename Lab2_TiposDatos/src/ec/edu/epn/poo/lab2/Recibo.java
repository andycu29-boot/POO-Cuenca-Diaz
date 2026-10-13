package ec.edu.epn.poo.lab2;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Recibo {
    public static void main(String[] args) {
        final double IVA = 0.15;
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        System.out.print("Código de factura: ");
        int codigo = sc.nextInt();

        // Primer producto
        sc.nextLine(); // Consumir el Enter pendiente
        System.out.print("Producto: ");
        String producto = sc.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = sc.nextInt();

        System.out.print("Precio unitario: ");
        double precio = sc.nextDouble();

        // Segundo producto
        sc.nextLine(); // Consumir el Enter pendiente antes de leer el nombre
        System.out.print("Segundo producto: ");
        String producto2 = sc.nextLine();

        System.out.print("Cantidad segundo producto: ");
        int cantidad2 = sc.nextInt();

        System.out.print("Precio unitario segundo producto: ");
        double precio2 = sc.nextDouble();

        double subtotal = cantidad * precio;
        double subtotal2 = cantidad2 * precio2;

        double subtotalGeneral = subtotal + subtotal2;
        double iva = subtotalGeneral * IVA;
        double total = subtotalGeneral + iva;

        System.out.println();
        System.out.println("=========== RECIBO ===========");

        // %08d: código con ceros a la izquierda hasta completar 8 dígitos
        System.out.printf(Locale.forLanguageTag("es-EC"),
                "Factura: %08d%n", codigo);

        System.out.printf(Locale.forLanguageTag("es-EC"),
                "%-14s %4s %10s%n",
                "Producto", "Cant", "Subtotal");

        System.out.printf(Locale.forLanguageTag("es-EC"),
                "%-14.14s %4d %,.2f%n",
                producto, cantidad, subtotal);

        System.out.printf(Locale.forLanguageTag("es-EC"),
                "%-14.14s %4d %,.2f%n",
                producto2, cantidad2, subtotal2);

        System.out.println("------------------------------");

        System.out.printf(Locale.forLanguageTag("es-EC"),
                "%-19s %10.2f%n", "IVA 15 %", iva);

        System.out.printf(Locale.forLanguageTag("es-EC"),
                "%-19s %,.2f%n", "TOTAL", total);

        NumberFormat moneda = NumberFormat.getCurrencyInstance(
                Locale.forLanguageTag("es-EC"));

        System.out.println("Total a pagar: " + moneda.format(total));

        sc.close();
    }
}