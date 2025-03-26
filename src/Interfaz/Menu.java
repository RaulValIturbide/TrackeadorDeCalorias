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
                System.out.println("\n0-Salir");
                System.out.print(">>");
                usuario = teclado.nextInt();
                if(rangoCorrecto(usuario,0,2)){
                    correcto = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Error: Introduzca un valor numerico");
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
    
    public static void mostrarCaloriasTotales(){
        System.out.println("El numero de calorias consumidas hoy es de:");
        System.out.println(FicheroCalData.totalCalorias() + " calorias en total");
        System.out.println("Presione enter para volver al menú.");
        teclado.nextLine();
        teclado.nextLine();

    }
    
    
    
    
    
}
