
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;

/**
 *
 * @author jpma0
 */
public class Control {
    
    static Scanner leer= new Scanner(System.in);
       //Array con usuarios y contraseñas quemadas
    static  String usuarios [][]={
        {"administrador","admin2025"},
        {"operador","operador2025"}         
    };
    
    
    public static void subMenuMantenimientos(){
        int opcion=0;
        do{
         for (int i = 0; i < 5; i++) System.out.println();            
        System.out.println("****************************");
        System.out.println("*    MENU Mantenimientos   *");
        System.out.println("****************************");
        System.out.println("1. Crear Mantenimientos");
        System.out.println("2. Consultar Mantenimientos");
        System.out.println("3. Editar Mantenimientos");
        System.out.println("4. Eliminar Mantenimientos");   
        System.out.println("5. volver");   
        System.out.print("Seleccione una opcion: ");
        opcion=leer.nextInt(); leer.nextLine();
        
            switch(opcion){
                case 1: EstrMantenimientos.regMantemientos();
                break;
                case 2: EstrMantenimientos.enlistarMantenimientos();
                break;
                case 3: EstrMantenimientos.modifMantenimiento();
                break;
                case 4: EstrMantenimientos.borraMantenimiento();
                break;
                case 5: System.out.println("Saliendo...");
                break;
                default: System.out.println("Opcion invalida.");
            }
        }while(opcion<5);
    }
    
     public static void subMenuVehiculos(){
        int opcion=0;
        do{
        for (int i = 0; i < 5; i++) System.out.println();            
        System.out.println("***********************");
        System.out.println("*    MENU Vehiculos   *");
        System.out.println("***********************");
        System.out.println("1. Crear Vehiculo");
        System.out.println("2. Consultar Vehiculo");
        System.out.println("3. Editar Vehiculo");
        System.out.println("4. Eliminar Vehiculo");   
        System.out.println("5. volver");   
        System.out.print("Seleccione una opcion: ");
        opcion=leer.nextInt(); leer.nextLine();
        
            switch(opcion){
                case 1: EstrVehiculos.regVehiculo();
                break;
                case 2: EstrVehiculos.enlistarVehiculos();
                break;
                case 3: EstrVehiculos.modifVehiculo();
                break;
                case 4: EstrVehiculos.borraVehiculo();
                break;
                case 5: System.out.println("Saliendo...");
                break;
                default: System.out.println("Opcion invalida.");
            }
        }while(opcion<5);        
    }

        
    public static void subMenuBolTaller(){
        int opcion=0;
        do{
        for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("****************************");
        System.out.println("*    MENU Boletas Taller   *");
        System.out.println("****************************");
        System.out.println("1. Crear Boletas Taller");
        System.out.println("2. Consultar Boletas Taller");
        System.out.println("3. Editar Boletas Taller");
        System.out.println("4. Eliminar Boletas Taller");   
        System.out.println("5. volver");   
        System.out.print("Seleccione una opcion: ");
        opcion=leer.nextInt(); leer.nextLine();
        
            switch(opcion){
                case 1: EstrBolTaller.regBolTaller();
                break;
                case 2: EstrBolTaller.enlistarBolTaller();
                break;
                case 3: EstrBolTaller.modifBolTaller();
                break;
                case 4: EstrBolTaller.borrarBolTaller();
                break;
                case 5: System.out.println("Saliendo...");
                break;
                default: System.out.println("Opcion invalida.");
            }
        }while(opcion<5);               
    }
    
    public static void subMenuBolCombustible(){
        int opcion=0;
        do{
        for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("*********************************");
        System.out.println("*    MENU Boletas Combustible   *");
        System.out.println("*********************************");
        System.out.println("1. Crear Boletas Combustible");
        System.out.println("2. Consultar Boletas Combustible");
        System.out.println("3. Editar Boletas Combustible");
        System.out.println("4. Eliminar Boletas Combustible");   
        System.out.println("5. volver");   
        System.out.print("Seleccione una opcion: ");
        opcion=leer.nextInt(); leer.nextLine();
        
            switch(opcion){
                case 1: EstrBolCombustible.regBolCombustible();
                break;
                case 2: EstrBolCombustible.enlistarBolCombustible();
                break;
                case 3: EstrBolCombustible.modifBolCombustible();
                break;
                case 4: EstrBolCombustible.borrarBolCombustible();
                break;
                case 5: System.out.println("Saliendo...");
                break;
                default: System.out.println("Opcion invalida.");
            }
        }while(opcion<5);               
    }
        
    public static void subMenuReportes(){
int opcion=0;
        do{
         for (int i = 0; i < 5; i++) System.out.println();
        System.out.println("**********************");
        System.out.println("*    MENU Reportes   *");
        System.out.println("**********************");
        System.out.println("1. Crear Reporte");
        System.out.println("2. Consultar Reporte");
        System.out.println("3. Editar Reporte");
        System.out.println("4. Eliminar Reporte");   
        System.out.println("5. volver");   
        System.out.print("Seleccione una opcion: ");
        opcion=leer.nextInt(); leer.nextLine();
        
            switch(opcion){
                case 1: EstrReportes.regReporte();
                break;
                case 2: EstrReportes.enlistarReportes();
                break;
                case 3: EstrReportes.modifReporte();
                break;
                case 4: EstrReportes.borrarReporte();
                break;
                case 5: System.out.println("Saliendo...");
                break;
                default: System.out.println("Opcion invalida.");
            }
        }while(opcion<5);               
    }


}
