
package Alimentacion;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.InputMismatchException;
import Exception.MenorACeroException;
/**
 *
 * @author baske
 */
public class FicheroDia {

    public static Scanner teclado = new Scanner(System.in);
        //Ruta desde la que se ejecuta en el powerShell
       static String ruta = "..\\Data\\Dias\\" + sacarDia();
        //Ruta desde la que se ejecuta en el netbeans
       static String rutaAlt = ".\\Data\\Dias\\"+sacarDia();
    
    public static void nuevoDia() {

        try {          
            FileWriter fichero = new FileWriter(ruta,true);        
            fichero.write(separacion());
            fichero.write(nuevoAlimento());
            fichero.close();
            System.out.println("Alimento introducido con éxito.\nPresione enter para volver al menú.");
            teclado.nextLine();
            
        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
    
    private static String nuevoAlimento(){
         String[] aData = introducirDatos();
         String alimentoCompleto="";
         for(int i = 0; i < 4; i++){
             alimentoCompleto += aData[i]+ "\n" + aData[i+4] + "\n";
            }
         
         return alimentoCompleto;
    }
    
    protected static String sacarDia(){
    LocalDate reloj = LocalDate.now();
    String dia = String.valueOf(reloj.getDayOfMonth());
    String mes = String.valueOf(reloj.getMonthValue());
    String anio = String.valueOf(reloj.getYear());
    String fecha = dia +"-"+ mes +"-"+ anio + ".txt";
    
    return fecha;
    }
    private static String separacion(){
        return "\n\tNuevo Alimento:\n";
    }
    
    /**
     * Este metodo comprueba que se introduzca un numero acorde a lo que el programa necesita, es decir, un tipo entero y superior a 0
     * @param frase La pregunta que necesita realizar
     * @return  devolverá un numero entero
     */
    private static int comprobar(String frase){
                boolean correcto = false;
        int gramosTemp = 0;
        while (!correcto) {
            try {
                System.out.println(frase);
                System.out.print(">> ");
                gramosTemp = teclado.nextInt();
                if(gramosTemp > 0){
                correcto = true;
                }else{
                    throw new MenorACeroException("Introduzca un valor mayor a 0");
                }
            } catch (InputMismatchException e) {
                System.out.println("Introduzca un valor numerico");
                teclado.nextLine(); //Liberar buffer
            }catch(MenorACeroException ex){
                System.out.println(ex.getMessage());
            }
        }
        return gramosTemp;
    }
    
    private static String[] introducirDatos(){
        String[] data = new String[8];
       
        //Frases del Programa
        data[0] = "Alimento consumido:";
        data[1] = "Cantidad consumida en gramos";
        data[2] = "Caloria del alimento por cada 100 gramos";
        data[3] = "Total calorias:";
        
        //Inicio de recopilación de información
        System.out.println(data[0]);
        System.out.print(">> ");
        data[4] = teclado.nextLine(); // Leer nombre del alimento

        data[5] = String.valueOf(comprobar(data[1])); // Leer cantidad en gramos
        teclado.nextLine(); // Limpiar buffer

        data[6] = String.valueOf(comprobar(data[2])); // Leer calorías por 100g
        teclado.nextLine(); // Limpiar buffer

        // Cálculo de calorías totales
        data[7] = calculoCalorico(data[5], data[6]);
        
        FicheroCalData.crearDatosCalDia((data[7]));
        
        return data;
    }
    
    /**
     * Este metodo calcula la cantidad de calorias a través de un calculo matemático básico
     * @param gramos la cantidad de gramos que el usuario ha consumido del alimento
     * @param calorias la cantidad de calorias que hay en 100 gramos del alimento (info nutricional)
     * @return devuelve el valor en tipo String
     */
    private static String calculoCalorico(String gramos, String calorias){
        double caloriaNum = Integer.parseInt(calorias);
        double gramosNum =  Integer.parseInt(gramos);
        
        double resultado = (gramosNum/100) * caloriaNum;
        String resultadoFormateado = String.format("%.2f", resultado);
        return resultadoFormateado;
        
    }
    
}
