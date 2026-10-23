package ec.edu.epn.poo.lab3;

import java.util.Locale;
import java.util.Scanner;

public class CajaRegistradora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        final double IVA = 0.15;

        // Catálogo en arreglos paralelos
        String[] nombres = {"Cuaderno", "Esfero", "Borrador", "Regla", "Carpeta"};
        double[] precios = {2.50, 0.75, 0.40, 1.20, 3.10};
        int[] stock = {10, 50, 30, 0, 8};
        int[] carrito = new int[nombres.length];

        int opcion;
        do {
            System.out.println("\n=== CAJA REGISTRADORA ===");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Agregar producto");
            System.out.println("3. Ver recibo");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            
            // TODO 1: Validar opción
            while (!sc.hasNextInt()) {
                System.out.print("No es un entero. Opción: ");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    // TODO 2: Mostrar catálogo
                    System.out.printf("%-4s %-10s %7s %6s%n", "Cód", "Producto", "Precio", "Stock");
                    for (int i = 0; i < nombres.length; i++) {
                        System.out.printf(Locale.US, "%-4d %-10s %7.2f %6d%n", i + 1, nombres[i], precios[i], stock[i]);
                    }
                }
                case 2 -> {
                    // TODO 3: Pedir y validar código
                    int codigo;
                    do {
                        System.out.print("Código (1 a 5): ");
                        while (!sc.hasNextInt()) {
                            System.out.print("No es un entero. Código (1 a 5): ");
                            sc.next();
                        }
                        codigo = sc.nextInt();
                        if (codigo < 1 || codigo > nombres.length) {
                            System.out.println("Fuera de rango.");
                        }
                    } while (codigo < 1 || codigo > nombres.length);

                    // TODO 4: Pedir cantidad y gestionar stock
                    System.out.print("Cantidad: ");
                    while (!sc.hasNextInt()) {
                        System.out.print("No es un entero. Cantidad: ");
                        sc.next();
                    }
                    int cantidad = sc.nextInt();
                    
                    if (cantidad > 0) {
                        int indice = codigo - 1;
                        if (stock[indice] >= cantidad) {
                            carrito[indice] += cantidad;
                            stock[indice] -= cantidad;
                            System.out.println("Agregado: " + cantidad + " x " + nombres[indice]);
                        } else {
                            System.out.println("Stock insuficiente (disponible: " + stock[indice] + ")");
                        }
                    }
                }
                case 3 -> {
                    // TODO 5: Mostrar recibo y subtotal
                    System.out.println("------------ RECIBO ------------");
                    double subtotal = 0;
                    for (int i = 0; i < carrito.length; i++) {
                        if (carrito[i] > 0) {
                            double totalFila = carrito[i] * precios[i];
                            System.out.printf(Locale.US, "%-10s %2d x %4.2f %7.2f%n", nombres[i], carrito[i], precios[i], totalFila);
                            subtotal += totalFila;
                        }
                    }
                    System.out.println("--------------------------------");

                    // TODO 6: Descuentos, IVA y total
                    double descuento = 0;
                    if (subtotal >= 100) {
                        descuento = subtotal * 0.10;
                    } else if (subtotal >= 50) {
                        descuento = subtotal * 0.05;
                    }
                    
                    double baseImponible = subtotal - descuento;
                    double ivaCalculado = baseImponible * IVA;
                    double total = baseImponible + ivaCalculado;
                    
                    System.out.printf(Locale.US, "%-20s %7.2f%n", "Subtotal", subtotal);
                    System.out.printf(Locale.US, "%-20s %7.2f%n", "Descuento", descuento);
                    System.out.printf(Locale.US, "%-20s %7.2f%n", "IVA 15 %", ivaCalculado);
                    System.out.printf(Locale.US, "%-20s %7.2f%n", "TOTAL", total);
                }
                case 0 -> System.out.println("Gracias por su compra.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }
}