import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controlador {
    // Creación del archivo CSV con títulos en la primera fila, por cada columna
    public void crearVerificarCSV() {
        File inventarioTienda = new File("inventarioTienda.csv");
        if (!inventarioTienda.exists()) {
            try {
                inventarioTienda.createNewFile();
                System.out.println("Todo listo para empezar...");

                // Agregar títulos a la primera fila
                FileWriter fw = new FileWriter(inventarioTienda, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("id_producto,nombre,cantidad_disponible,cantidad_vendidos,estado,precio,categoria,talla,tipo,color,material");
                bw.newLine();
                bw.close();

            } catch (IOException e) {
                System.out.println("Error encontrado: " + e.getMessage());
            }
        }
    }

    // Se me olvidó ingresar este método en el análisis pero ingresarProductos permitirá ingresar los ítems que desee el usuario.
    public void ingresarProducto(int id_producto, String nombre, int cantidad_disponible, int cantidad_vendidos, String estado, double precio, String categoria, String talla, String tipo, String color, String material) {
        String archivo = "inventarioTienda.csv";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(id_producto + "," + nombre + "," + cantidad_disponible + "," + cantidad_vendidos + "," + estado + "," + precio + "," + categoria + "," + talla + "," + tipo + "," + color + "," + material);
            writer.newLine();
            System.out.println(nombre + " agregado con éxito.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }    

    public void buscarProducto(int idProducto) {
        String archivo = "inventarioTienda.csv";
        String datoBuscado = String.valueOf(idProducto);
    
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length > 0 && datos[0].equalsIgnoreCase(datoBuscado)) {
                    System.out.println(linea);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listarProductos(){
        int contadorPantalones = 0;
        int contadorBlusa = 0;
        int contadorCamisa = 0;
        int contadorCollar = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("inventarioTienda.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                for (String dato : columnas) {
                    if (dato.equals("Pantalones")) {
                        contadorPantalones++;
                    } else if (dato.equals("Blusa")) {
                        contadorBlusa++;
                    } else if (dato.equals("Camisa")) {
                        contadorCamisa++;
                    } else if (dato.equals("Collar")) {
                        contadorCollar++;
                    }
                }
            }
            System.out.println("Listado de items:");
            System.out.println("Pantalones: " + contadorPantalones);
            System.out.println("Blusa: " + contadorBlusa);
            System.out.println("Camisa: " + contadorCamisa);
            System.out.println("Collar: " + contadorCollar);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }

    public void ventasTienda(){
        try (BufferedReader br = new BufferedReader(new FileReader("inventarioTienda.csv"))) {
            String linea;
            int columna4 = 0;
            int columna6 = 0;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 6) {
                    columna4 += Integer.parseInt(columnas[3]);
                    columna6 += Integer.parseInt(columnas[5]);
                }
            }
            int resultado = columna4 * columna6;
            System.out.println("Resultado de la multiplicación: " + resultado);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}