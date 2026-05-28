/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;

import java.util.Scanner;

/**
 *
 * @author jpma0
 */
public class GestionMantenimientoVehiculos {

    /**
     * @param args the command line arguments
     */
    
    static Scanner leer = new Scanner(System.in);
    
      //Metodo de inicio de sesion 
    public static void logIn (){
    int intentos= 0;
    boolean acceso = false;
    
    while (intentos <3){
        for (int i = 0; i < 22; i++) System.out.println();
        
        System.out.println("--------------------------------");
        System.out.println("| Transportes Los Tres Patitos |");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("********************");
        System.out.println("* Inicio de sesion *");
        System.out.println("********************");
        System.out.println("");
        System.out.print("Ingrese el Usuario: ");
        String usuario = leer.nextLine();
        System.out.print("Ingrese la contrasenia de " + usuario + ": ");
        String contraseña = leer.nextLine();
        
        if ((usuario.equals(Control.usuarios [0][0]) && contraseña.equals(Control.usuarios[0][1])) ||
            (usuario.equals(Control.usuarios[1][0]) && contraseña.equals(Control.usuarios[1][1]))){
            acceso = true;
            
        if (usuario.equals("administrador")){
            menuAdministrador();
           
        }else{
            menuOperador();
        }
        break;
        
        }else {
            intentos++;
            System.out.println("Datos incorrectos. Intento " + intentos + " de 3");
        }
    }
    if (!acceso){
        System.out.println("Ha excedido el limite de intentos. Cerrando Sistema...");
    }
    }
    
    //Metodo genera el menú del administrador
    public static void menuAdministrador(){
    int opcion=0;
     do {
          for (int i = 0; i < 20; i++) System.out.println();
            System.out.println("--------------------------------");
            System.out.println("| Transportes Los Tres Patitos |");
            System.out.println("--------------------------------");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("****************************");
            System.out.println("*    MENU ADMINISTRADOR    *");
            System.out.println("****************************");
            System.out.println("1. Menu Mantenimientos");
            System.out.println("2. Menu Vehiculos");
            System.out.println("3. Menu Boletas de Taller");
            System.out.println("4. Menu Boletas de Combustible");
            System.out.println("5. Menu Reportes");
            System.out.println("6. Cerrar Sesion");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt(); leer.nextLine();

        switch (opcion) {
                case 1: Control.subMenuMantenimientos();
                break;
                case 2: Control.subMenuVehiculos();
                break;
                case 3: Control.subMenuBolTaller();
                break;
                case 4: Control.subMenuBolCombustible();
                break;
                case 5: Control.subMenuReportes();
                break;
                case 6: System.out.println("Saliendo..."); logIn();
                break;
                default: System.out.println("Opcion invalida.");
        }
     }
     while (opcion <6);
    }
    
    //metodo genra el menú del operador
    public static void menuOperador(){
    int opcion;
    do {
        for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("--------------------------------");
        System.out.println("| Transportes Los Tres Patitos |");
        System.out.println("--------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("    ********************");
        System.out.println("    *   MENU OPERADOR  *");
        System.out.println("    ********************");
        System.out.println("1. Crear Boletas Del Taller");
        System.out.println("2. Consultar Boletas Del Taller");
        System.out.println("3. Editar Boletas Del Taller");
        System.out.println("4. Eliminar Boletas Del Taller");
        System.out.println("5. Crear Boletas Del Combustible");
        System.out.println("6. Consultar Boletas Del Combustible");
        System.out.println("7. Editar Boletas Del Combustible");
        System.out.println("8. Eliminar Boletas Del Combustible");
        System.out.println("9. Pre-cargar");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opcion: ");
        opcion = leer.nextInt(); leer.nextLine();

        switch (opcion) {
            case 1: 
            break;
            case 2: 
            break;
            case 3: 
            break;
            case 4: 
            break;
            case 5:
            break;
            case 6: 
            break;
            case 7:
            break;
            case 8:
            break;
            case 9:
            break;
            case 10:System.out.println("Saliendo..."); logIn();
            break;
            default: System.out.println("Opcion invalida.");
        }
    } while (opcion < 7);
}
    
    public static void main(String[] args) {
        // TODO code application logic here
        logIn ();
        EstrVehiculos.leerArchivoVehiculo();
    }
    
    
}
