package laboratorio_clases;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BilleteraParque billetera = new BilleteraParque(100); 

        boolean salir = false;
        while (!salir) {
            System.out.println();
            System.out.println("==Administrador de billeteras para parques temáticos==");
            System.out.println();
            System.out.println("1. Agregar tickets");
            System.out.println("2. Establecer tickets");
            System.out.println("3. Comprar premio");
            System.out.println("4. Establecer festivo");
            System.out.println("5. Salir");
            System.out.println();
            System.out.println("Tu billetera tiene " + billetera.getTickets() + " boletos");
            System.out.print("\nIngrese la opción: ");

            int opcion;
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                sc.next(); 
                System.out.println("Opción inválida. Intente de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("\n¿Cuántos boletos se agregan? ");
                    if (sc.hasNextInt()) {
                        int add = sc.nextInt();
                        billetera.agregarTickets(add);
                    } else {
                        sc.next();
                        System.out.println("Cantidad inválida.");
                    }
                    break;

                case 2:
                    System.out.print("\nEstablecer saldo de tickets en: ");
                    if (sc.hasNextInt()) {
                        int nuevo = sc.nextInt();
                        billetera.setTickets(nuevo); 
                    } else {
                        sc.next();
                        System.out.println("Cantidad inválida.");
                    }
                    break;

                case 3:
                    int precioCamiseta = 150;
                    int precioSombrero = 350;
                    int precioTenis = 600;

                    if (BilleteraParque.isFestivo()) {
                        System.out.println("\n¡Precios de vacaciones!");
                        precioCamiseta = precioCamiseta / 2;
                        precioSombrero = precioSombrero / 2;
                        precioTenis = precioTenis / 2;
                    }

                    System.out.println();
                    System.out.println("1. Camiseta (" + precioCamiseta + " tickets)");
                    System.out.println("2. Sombrero (" + precioSombrero + " tickets)");
                    System.out.println("3. Tenis (" + precioTenis + " tickets)");
                    System.out.print("\n¿Qué premio desea comprar? ");

                    int elegido;
                    if (sc.hasNextInt()) {
                        elegido = sc.nextInt();
                    } else {
                        sc.next();
                        System.out.println("Opción inválida.");
                        break;
                    }

                    if (elegido >= 1 && elegido <= 3) {
                        int precio;
                        String nombre;
                        if (elegido == 1) {
                            precio = precioCamiseta;
                            nombre = "camiseta";
                        } else if (elegido == 2) {
                            precio = precioSombrero;
                            nombre = "sombrero";
                        } else {
                            precio = precioTenis;
                            nombre = "tenis";
                        }

                        if (billetera.removerTickets(precio)) {
                            System.out.println("\nCompré un " + nombre + " por " + precio + " entradas");
                        } else {
                            System.out.println("\nNo hay suficientes boletos para comprar ese premio");
                        }
                    } else {
                        System.out.println("Opción de premio inválida.");
                    }

                    break;

                case 4:
                    BilleteraParque.toggleFestivo();
                    if (BilleteraParque.isFestivo()) {
                        System.out.println("\nAhora es un día festivo.");
                    } else {
                        System.out.println("\nYa no es un día festivo.");
                    }
                    break;

                case 5:
                    System.out.println("\nSaliendo del programa...");
                    salir = true;
                    break;

                default:
                    System.out.println("\nOpción inválida. Intente de nuevo.");
                    break;
            }
        }

        sc.close();
    }
}
