/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package contadordecalorias;
import java.io.FileWriter;
import java.util.Scanner;
import java.time.LocalDate;
import java.io.IOException;
/**
 *
 * @author baske
 */
public class ContadorDeCalorias {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean endProgram = false;

        do {
            int main = Menu.Introduccion();

            switch (main) {
                case 1:
                    FicheroDia.nuevoDia();
                        
                    break;
                case 2:
                    break;
                case 0:
                    endProgram = true;
            }

        } while (!endProgram);

    }

    
}
