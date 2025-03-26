/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;
import Alimentacion.FicheroDia;
import Interfaz.Menu;
import java.util.Scanner;

/**
 *
 * @author baske
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
        boolean endProgram = false;
        do {
            Menu.limpiarPantalla();
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
