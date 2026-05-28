/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author jpma0
 */

//Metodo principal de la clase
public class EstrMantenimientos {

    static Scanner leer = new Scanner (System.in);
    
    //Constructor del archivo
    public EstrMantenimientos() {
        
    }
    
     //----Definir la estructura Compleja para los mantenimientos
    public static class Mantenimiento {
    //--Caracteristicas 
       int id ;
       String nombre;
       char estado;

       //--Constructor de la estructura
        public Mantenimiento (int id, String nombre, char estado) {           
            this.id = id;
            this.nombre = nombre;
            this.estado = estado;
        }
       
       //--Metodo de trabajo (Getters) de las estructuras
        public int getIdMant(){
            return id;
        }
        public String getNomMant(){
            return nombre;
        }
        public char getEstadoMant(){
            return estado;
        }
        
        //-- Set = ESTABLECER O ASIGNAR
        //-- Metodos de Trabajo (Setters)
        public void setIdMant(int id){
            this.id = id;
        }
        public void setNombreMant(String nombre){
            this.nombre = nombre;
        }
        public void setEstadoMant(char estado){
            this.estado = estado;
        }   
    }      

//Fin de la estructura compleja

//Declaramos un array de 1 dimension tipo estructura complejas
static Mantenimiento []arrayMantenimiento = new Mantenimiento [100];

public static void regMantemientos(){
        System.out.println("-------------------------------------");  
        System.out.print(" Digite la fila a llenar: ");
        int fila = leer.nextInt();
        System.out.println("");
        leer.nextLine();
        System.out.print(" Digite El Identificardor Del Mantenimiento: ");
        int id = leer.nextInt();
        System.out.println("");
        leer.nextLine();
        System.out.print(" Digite El Nombre Del Mantenimiento: ");
        String nombre = leer.nextLine();
        leer.nextLine();
        System.out.print(" Digite Si El Mantenimiento Esta Activo (A-I): "); 
        char estado = leer.next().charAt(0);
        System.out.println("-------------------------------------");
        
        arrayMantenimiento[fila-1] = new Mantenimiento (id, nombre, estado);
        
        CrearArchivoMantenimiento();
       EscribirArchivoMantenimiento();
    }   
    
 public static void enlistarMantenimientos()
        {
             System.out.println("--------------------------------");
             System.out.println("|    Lista de Mantenimientos    |");        
             System.out.println("---------------------------------");
             //Estructura de control para recorrer
             for (int i = 0; i < 100; i++ )
                 if (arrayMantenimiento[i] != null){
            System.out.println("Fila:"+ (i + 1) +" ID="+ arrayMantenimiento[i].getIdMant()+
            " Nombre=" + arrayMantenimiento[i].getNomMant()+ " Estado=" + arrayMantenimiento[i].getEstadoMant());      
        }         
    }
 
 public static void modifMantenimiento (){
        leer.nextLine();
        System.out.println("-------------------------------------");
        System.out.print(" Digite la fila a modificar:  ");
        int fila = leer.nextInt();
        System.out.println("");
        leer.nextLine();
        System.out.print(" Digite El Nombre Del Mantenimiento: ");
        String nombre = leer.nextLine();
        leer.nextLine();
        System.out.print(" Digite El Estado Del Mantenimiento: ");
        char estado = leer.next().charAt(0);
        System.out.println("-------------------------------------");
        //servicio.modificarEspecie( fila-1, nombre); 
        
        arrayMantenimiento[fila-1].setNombreMant(nombre);
        arrayMantenimiento[fila-1].setEstadoMant(estado);    
        
        EscribirArchivoMantenimiento();
    }
 //--Metodo para borrar mantenimientos
    public static void borraMantenimiento(){
    leer.nextLine();
        System.out.println("-------------------------------------");
        System.out.print(" Digite la fila a eliminar:  ");
        int fila = leer.nextInt();
        
        arrayMantenimiento[fila-1] = null;
        
        EscribirArchivoMantenimiento();
    }
    
    
    //Creación del Archivo
    public static void CrearArchivoMantenimiento(){
        File miArchivo = new File("Mantenimiento.txt");
            try{
                if ( miArchivo.createNewFile() ){ 
                    System.out.println("-------------------");
                    System.out.println(" Archivo fue Creado ");
                    System.out.println("-------------------");
            } else {
                    System.out.println("-------------------");
                    System.out.println(" Archivo Ya Exstía ");
                    System.out.println("-------------------");    
            } 
                
            } catch(IOException e){
               System.out.println(" Error al Crear Archivo "); 
                 //System.out.println(e. toString () ) ;
                }
            }
    
 /* Limpiar el Archivo Especie */
       public static void LimpiarArchivoMantenimiento()
       {
          try {
             PrintWriter escritor = new PrintWriter("Mantenimiento.txt");
              System.out.println("El contenido de Mantenimiento fue borrado.");
            } catch (IOException e ) {
               System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
             }
       }
              
// Escribir en el Archivo Mantenimiento      
public static void EscribirArchivoMantenimiento(){
    //--limpiar antes de escribir
    System.out.println("Limpiando el archivo.");
    LimpiarArchivoMantenimiento();

    //-- Estructura para guardar 
    try{
        System.out.println("Entrando al try.");    
        FileWriter escribir = new FileWriter("Mantenimiento.txt", true);
        System.out.println("FlieWriter creado.");
        //Variable para que la escriba en el archivo 
        String linea;
         for (int i = 0; i < arrayMantenimiento.length; i++) // Recorre las Filas
         {
           if ( arrayMantenimiento[i] != null){              
             linea = i + ";" + arrayMantenimiento[i].getIdMant() + ";" 
                     + arrayMantenimiento[i].getNomMant() + ";" + arrayMantenimiento[i].getEstadoMant()+";\n";
             escribir.write(linea); //-- Escribe en el Archivo
            }
         }
           
        
       //System.out.println("Especie creada");
       //System.out.println("Linea 1 Escrita");
        escribir.write(10); //--comando para cerrar la linea
        escribir.close();//--cerra el archivo 
        System.out.println("Información guardada");
    } catch (IOException e ) {
        System.out.println("Error al guardar.");  
    }
}
       


public static void leerArchivoMantenimiento(){
     
   try{
       //Apertura del archivo
       FileReader archivo = new FileReader("Mantenimiento.txt");
       // Carga en memoria para la lectura
       BufferedReader lector = new BufferedReader (archivo);
       int fila = 0;
       //Carga de la linea en texto
       String linea = lector.readLine();// lee la primera linea del archivo
       //segmentar la linea en los espacios de la matriz
       String segmento[];
       //--- Recorrido linea por el archivo, para escribir en la matriz de Epecies
        while (linea !=null){
            segmento = linea.split(";");
            if (!"".equals(segmento)){
                fila = Integer.parseInt(segmento [0]);
                
                 if ( arrayMantenimiento[fila] != null){
               arrayMantenimiento[fila].setIdMant (Integer.parseInt(segmento[1]) );
               arrayMantenimiento[fila].setNombreMant(segmento[2]) ;
               arrayMantenimiento[fila].setEstadoMant(segmento[3].charAt(0)) ;
                 }else {
                  arrayMantenimiento[fila] = new Mantenimiento(Integer.parseInt(segmento[1]), segmento [2], segmento [3].charAt(0));
                 }
                     
            }
           linea = lector.readLine();
        }
       
    } catch (IOException e ) {
     System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
    }   
}
public static int buscarMantenimiento(int ID){
        int encontrado = 0;
        for (int i = 0; i <arrayMantenimiento.length; i++){
            if(arrayMantenimiento[i]!=null){
            if (ID ==  arrayMantenimiento[i].getIdMant() && arrayMantenimiento[i].getEstadoMant()=='A' ){
                encontrado = 1;
                System.out.println( arrayMantenimiento [i].getNomMant());
                break;//metodo para finalizar eventos
            }
            }
        }
        
        if(encontrado ==0){
           System.out.println(" - Mantenimiento no encontrada o no disponible. - "); 
       }
        return encontrado;
    }

        public static String buscarNomMantenimiento(int ID){
        String encontrado = "";
        for ( int i = 0; i < arrayMantenimiento.length; i++ ){
            if (arrayMantenimiento[i] != null){
                if ( ID == arrayMantenimiento[i].getIdMant()  ){
                    encontrado = arrayMantenimiento[i].getNomMant();
                    //System.out.print( arrayEspecies[i].getNomEspecie() ); 
                    break;//metodo para finalizar o romper acciones
                }
            }
        }
        if (encontrado == ""){
            encontrado = ""; 
        }
        return encontrado;
    }    
        
public static String buscarNomMantenimientoP(String Placa){
        String encontrado = "";
        for ( int i = 0; i < arrayMantenimiento.length; i++ ){
            if (arrayMantenimiento[i] != null){
                if ( Placa.equalsIgnoreCase(EstrVehiculos.arrayVehiculo[i].getPlacaVehiculo())){
                    encontrado = arrayMantenimiento[i].getNomMant();
                    //System.out.print( arrayEspecies[i].getNomEspecie() ); 
                    break;//metodo para finalizar o romper acciones
                }
            }
        }
        if (encontrado == ""){
            encontrado = ""; 
        }
        return encontrado;
    }    
        
}