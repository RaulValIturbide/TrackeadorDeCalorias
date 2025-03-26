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

/*
*TO DO: Hay que tener en cuenta que depende de si queremos iniciar el programa en el propio ide o en el cmd debemos cambiar la ruta tanto en FicheroCalData como en FicheroDia ya que la ruta es diferente
*TO DO: Estaría genial que pudiesemos generar las carpetas "Data" "Dias" y "CalData" en el caso de que estas no existieran de manera automática
*TO DO: Añadir un nuevo case en el menu principal que nos permita recorrer toda la comida que hemos tomado hoy
*TO DO: Añadir un nuevo case en el que el usuario elija una cantidad calorica diaria para tomar algo asi como "Elegir objetivo calorico", este tal vez deberia estar en un submenú de "ajustes",
*       se comparará la cantidad de calorias que lleva el usuario con el objetivo calorico y se le dirá cuantas calorias le faltan para alcanzarlo
*/
    
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
                    Menu.mostrarCaloriasTotales();
                    break;
                case 0:
                    System.out.println("Muchas gracias, vuelva pronto");
                    endProgram = true;
            }

        } while (!endProgram);

    }

    
}
