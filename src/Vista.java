import java.util.Scanner;

public class Vista {
    Controlador c = new Controlador();
    Scanner scn = new Scanner(System.in);

    public void mostrarMenu() {
            while (true) {
                c.crearVerificarCSV();
                System.out.println("M E N Ú");
                System.out.println("Ingresa el número de opción: ");
                System.out.println("1. Ingresar nuevo ítem.\n2. Buscar por ID.");
                int opcion = scn.nextInt();
                switch (opcion) {
                    case 1:
                    System.out.println("Ingresa la información que se le solicita a continuación acerca del producto:");
                    System.out.print("Ingresa el id: ");
                    int id_producto = scn.nextInt();
                    scn = new Scanner(System.in);
                    System.out.print("Ingresa el nombre: ");
                    String nombre = scn.nextLine();
                    System.out.print("Ingresa la cantidad: ");
                    int cantidad_disponible = scn.nextInt();
                    System.out.print("Ingresa la cantidad vendida: ");
                    int cantidad_vendidos = scn.nextInt();
                    scn = new Scanner(System.in);
                    System.out.print("Ingresa el estado (disponible, reservado, vendido): ");
                    String estado = scn.nextLine();
                    System.out.print("Ingresa el precio: Q");
                    double precio = scn.nextDouble();
                    scn = new Scanner(System.in);
                    System.out.print("Ingresa la categoría (Pantalones, blusa o camisa, collar): ");
                    String categoria = scn.nextLine();
                    System.out.print("Ingresa la talla: ");
                    String talla = scn.nextLine();
                    if (categoria.equalsIgnoreCase("pantalones")){
                        System.out.print("Ingresa el tipo (lona, jogger, pants...etc): ");
                        String tipo = scn.nextLine();
                        c.ingresarProducto(id_producto, nombre, cantidad_disponible, cantidad_vendidos, estado, precio, categoria, talla, tipo, null, null);
                    } else if (categoria.equalsIgnoreCase("blusa") || categoria.equalsIgnoreCase("camisa")) {
                        System.out.print("Ingresa el color: ");
                        String color = scn.nextLine();
                        c.ingresarProducto(id_producto, nombre, cantidad_disponible, cantidad_vendidos, estado, precio, categoria, talla, null, color, null);
                    } else if (categoria.equalsIgnoreCase("collar")){
                        System.out.print("Ingresa el material: ");
                        String material = scn.nextLine();
                        c.ingresarProducto(id_producto, nombre, cantidad_disponible, cantidad_vendidos, estado, precio, categoria, talla, null, null, material);
                    }
                        break;
                    case 2:
                    System.out.print("Ingresa el id del producto que deseas buscar: ");
                    int idProducto = scn.nextInt();
                    c.buscarProducto(idProducto);
                        break;
                    case 3:
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, Ingresa una opción válida :)");
                        break;
                }
            }
    }
}
