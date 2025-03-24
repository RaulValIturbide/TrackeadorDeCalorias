/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contadordecalorias;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
/**
 *
 * @author baske
 */
public class FicheroDia {

    public static Scanner teclado = new Scanner(System.in);
    
    
    public static void nuevoDia() {
        try {
            
            FileWriter fichero = new FileWriter(sacarDia());            
            fichero.write(nuevoAlimento());
            fichero.close();
            
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
    
    private static String sacarDia(){
    LocalDate reloj = LocalDate.now();
    String dia = String.valueOf(reloj.getDayOfMonth());
    String mes = String.valueOf(reloj.getMonthValue());
    String anio = String.valueOf(reloj.getYear());
    String fecha = dia +"-"+mes+"-"+anio+".txt";
    
    return fecha;
    }
    
    private static String[] introducirDatos(){
        String[] data = new String[8];
        data[0] = "Alimento consumido:";
        data[1] = "Cantidad consumida en gramos";
        data[2] = "Caloria del alimento por cada 100 gramos";
        data[3] = "Total calorias:";
        System.out.println(data[0]);
        System.out.print(">>");
        data[4] = teclado.nextLine();
        System.out.println(data[1]);
        System.out.print(">>");
        data[5] = String.valueOf(teclado.nextInt());
        System.out.println(data[2]);
        System.out.print(">>");
        data[6] = String.valueOf(teclado.nextInt());
        data[7] = calculoCalorico(data[5],data[6]);
        
        return data;
    }
    
    private static String calculoCalorico(String gramos, String calorias){
        double caloriaNum = Integer.parseInt(calorias);
        double gramosNum =  Integer.parseInt(gramos);
        
        double resultado = (gramosNum/100) * caloriaNum;
        
        return String.valueOf(resultado);
        
    }
    
}
