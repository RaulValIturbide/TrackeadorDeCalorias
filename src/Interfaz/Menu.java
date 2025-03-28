package Interfaz;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import Alimentacion.FicheroCalData;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author baske
 */
public class Menu {
    public static Scanner teclado = new Scanner(System.in);
    
    /**
     * La primera pagina que se encuentra el usuario
     * @return devolverá un numero
     */
    public static int Introduccion(){
        boolean correcto = false;
        int usuario = 0;
        
        do {

            try {
                System.out.println("Que deseas hacer?");
                System.out.println("1-Introducir datos");
                System.out.println("2-Consultar calorias consumidas hoy");
                System.out.println("3-Consultar los alimentos registrados hoy");
                System.out.println("\n0-Salir");
                System.out.print(">>");
                usuario = teclado.nextInt();
                if(rangoCorrecto(usuario,0,4)){
                    correcto = true;
                }
            } catch (InputMismatchException ex) {
                limpiarPantalla();
                System.out.println("Error: Introduzca un valor numerico");
                limpiarBuffer();    
                limpiarBuffer();
            }
        } while (!correcto);
        
        return usuario;
    }
    
    public static void limpiarBuffer(){
        teclado.nextLine();
    }
  public static void limpiarPantalla() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
    
    }

    public static void volverMenu() {
        System.out.println("Presione enter para volver al menu.");
        teclado.nextLine();
        teclado.nextLine();
    }
    
    /**
     * Este metodo pretende ser usado para que el usuario no seleccione un numero fuera del rango
     * @param usuario el numero que ha introducido el usuario
     * @param rangoMin el numero min que debe usar el usuario (inclusive)
     * @param rangoMax el numero max que debe usar el usuari (inclusive)
     * @return nos devolverá true si cumple el rango o false si no lo hace
     */
    private static boolean rangoCorrecto(int usuario,int rangoMin,int rangoMax){
        boolean correcto = false;
        if(usuario < rangoMin || usuario > rangoMax){
           correcto = false;
        }else{
            correcto = true;
        }
        return correcto;
        }
    
    /**
     * Metodo para mostrar las calorias por pantalla, si devuelve null se entiende que no existe ningún dato realizado en el dia de hoy por lo que se lanza
     * el mensaje pertinente
     */
    public static void mostrarCaloriasTotales() {
        if (FicheroCalData.totalCalorias() == null) {
            System.out.println("No hay datos de ninguna comida realizada hoy.\nPruebe a introducir un alimento primero.\n");
            System.out.println("Presione enter para volver al menu.");
            teclado.nextLine();//buffer
            teclado.nextLine();
        } else {
            System.out.println("El numero de calorias consumidas hoy es de:");
            System.out.println(FicheroCalData.totalCalorias() + " calorias en total");
            System.out.println("Presione enter para volver al menu.");
            teclado.nextLine();//buffer
            teclado.nextLine();
        }


    }
    
    
    
    
    
}
