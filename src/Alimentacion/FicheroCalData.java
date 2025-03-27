/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alimentacion;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
/**
 *
 * @author baske
 */
public class FicheroCalData {

    //Ruta desde la que se ejecuta en el powerShell
    static String ruta = "..\\Data\\CalData\\" + FicheroDia.sacarDia();
    //Ruta desde la que se ejecuta en el netbeans
    static String rutaAlt = ".\\Data\\CalData\\" + FicheroDia.sacarDia();

    public static void crearDatosCalDia(String calorias) {

        try {
            FileWriter escritor = new FileWriter(ruta, true);
            escritor.write(calorias + "\n");
            escritor.close();

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    
    /**
     * Este metodo pretende leer las calorias de cada alimento que se encuentran guardadas en un txt de calData y sumarlas para calcular el total del txt
     * que al separarse por dias será el de hoy
     * @return devuelve un String que es un numero con la suma de las calorias totales
     */
    public static String totalCalorias() {
        String Parrafo = "";
        try {
            FileReader lector = new FileReader(ruta);
            int data = lector.read();

            while (data != -1) {
                Parrafo += (char) data;
                data = lector.read();
            }
            lector.close();
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException e){
            System.out.println("Excepcion máxima con el lector");
        }
        System.out.println("");//Salto de linea

        double caloriasTotales = 0;//Donde se guardaran las calorias totales en forma de double
        String[] linea = Parrafo.split("\n"); //Este metodo lo usamos para separar el contenido del parrafo por saltos de linea

        //Este for se asegura de eliminar el "\n" y de sumar las cantidades transformandolas en un numero a caloriasTotales
        for (String frase : linea) {
            frase = frase.replace(",",".");//Tenemos que reemplazar las comas por puntos para que no haya un error al leer los datos
            frase = frase.trim();
            caloriasTotales += Double.parseDouble(frase);
        }

        String dataFinale = String.valueOf(caloriasTotales);//Lo almacenamos en forma de String para imprimirlo en el bloc de notas

        return dataFinale;
    }
}


