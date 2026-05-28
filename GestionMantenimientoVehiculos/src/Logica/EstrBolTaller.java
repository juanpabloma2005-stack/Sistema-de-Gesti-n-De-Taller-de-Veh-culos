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
import javax.swing.JOptionPane;

/**
 *
 * @author jpma0
 */
public class EstrBolTaller {
    static Scanner leer = new Scanner (System.in);
    
    //Constructor del archivo
    public EstrBolTaller() {    
    }
    
     //----Definir la estructura Compleja para las especies
    public static class BolTaller {
    //--Caracteristicas 
       int id ;
       String mantenimientoB;
       String placa;
       String marca;
       String modelo;
       String kilometraje;
       int fecha;
       String mecanico;

       //--Constructor de la estructura
        public BolTaller (int id, String mantenimientoB, String placa, String marca, String modelo,String kilometraje, int fecha, String mecanico) {           
            this.id = id;
            this.mantenimientoB = mantenimientoB;
            this.placa = placa;
            this.marca = marca;
            this.modelo = modelo;
            this.kilometraje = kilometraje;
            this.fecha = fecha;
            this.mecanico = mecanico;
        }
       
       //--Metodo de trabajo (Getters) de las estructuras
        public int getIdBolT(){
            return id;
        }
        public String getMantBolT(){
            return mantenimientoB;
        }
        public String getPlacaBolT(){
            return placa;
        }
        
        public String getMarcaBolT(){
            return marca;
        }
        public String getModeloBolT(){
            return modelo;
        }
        public String getKilometrajeBolT(){
            return kilometraje;
        }
         public int getFechaBolT(){
            return fecha;
        }
          public String getMecanicoBolT(){
            return mecanico;
        }
          
        //-- Set = ESTABLECER O ASIGNAR
        //-- Metodos de Trabajo (Setters)
        public void setIdBolT(int id){
            this.id = id;
        }
        public void setMantBolT(String mantenimientoB){
            this.mantenimientoB = mantenimientoB;
        }
        public void setPlacaBolT(String placa){
            this.placa = placa;
        }  
        public void setMarcaBolT(String marca){
            this.marca = marca;
        }
        public void setModeloBolT(String modelo){
            this.modelo = modelo;
        }
        public void setKilometrajeBolT(String kilometraje){
            this.kilometraje = kilometraje;
        }
        public void setFechaBolT(int fecha){
            this.fecha = fecha;
        }
        public void setMecanicoBolT(String mecanico){
            this.mecanico = mecanico;
        }
    }      

//Fin de la estructura compleja

//Declaramos un array de 1 dimension tipo estructura complejas
static BolTaller []arrayBoletaT = new BolTaller [100];
static String[] arrayMecanicos = {
    "Juan Perez", "Miguel Jarquin", "Sonia Gomez", "Diego Garcia", "Marcos Palacios", "Josue Molina", "Alex Aragon", "Carlos Duarte", "Jennifer Murillo", "Kendal Guzman"};
    
public static void regBolTaller(){
        System.out.println("-------------------------------------");
            System.out.print("Digite la fila a llenar: ");
            int fila=leer.nextInt();
            int id = fila+1000;
            System.out.println("");
        int mantenimiento = 0;
        int existe = 0;
        do{
             System.out.println("");
             System.out.print("Digite el mantenimiento asociado: ");
             mantenimiento = leer.nextInt(); System.out.print(" - ");
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        
        System.out.println("");
        String placa = "";
        String marca = "";
        String modelo = "";
        do{
             System.out.println("");
             leer.nextLine();
             System.out.print("Digite la placa del vehiculo: ");
             placa = leer.nextLine(); System.out.print(" - ");
             marca=placa;
             modelo=placa;
             existe = EstrVehiculos.buscarPlaca(placa);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un vehiculo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        System.out.println("");
        System.out.print("Digite el kilometraje del vehiculo: ");
        String kilometraje = leer.nextLine();
        System.out.println("");
        System.out.print("Ingrese la fecha de hoy (ej:20250725): ");
        int fecha = leer.nextInt();
        System.out.println("");
        
        int mecanico = 0;
        int encontrado=0;
         do{
             System.out.println("");
              System.out.println("---- Lista de Mecanicos ----");
    for (int i = 0; i < arrayMecanicos.length; i++) {
        if (arrayMecanicos[i] != null && !arrayMecanicos[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayMecanicos[i]);
        }
    }
                 leer.nextLine();
             System.out.print("Digite El nombre del mecanico: ");
             mecanico = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarMecanico(mecanico);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un Mecanico valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(encontrado < 1);
        
        
        System.out.println("");
        System.out.println("-------------------------------------");
         
        //--Guardar en el array de Especies
        //Archivo    Array donde guardo[pocision]   //Archivo  Constructor de la de EstructuraCompleja    
        arrayBoletaT [fila-1] = new BolTaller (id, String.valueOf(mantenimiento), placa, marca, modelo, kilometraje, fecha, String.valueOf(mecanico));
        
        CrearArchivoBolTaller();
        EscribirArchivoBolTaller();
    }   
    
 public static void enlistarBolTaller()
        {
             System.out.println("-----------------------------------");
             System.out.println("|    Lista de Boletas del Taller  |");        
             System.out.println("-----------------------------------");
             //Estructura de control para recorrer
             for (int i = 0; i < arrayBoletaT.length; i++ )
                 if (arrayBoletaT [i] != null){
            System.out.println("Fila:"+ (i + 1) +
            " ID="+ arrayBoletaT [i].getIdBolT()+
            " Mantemiento=" + EstrMantenimientos.buscarNomMantenimiento(Integer.parseInt(arrayBoletaT[i].getMantBolT()))+ 
            " Placa=" + arrayBoletaT [i].getPlacaBolT()+
            " Marca=" + EstrVehiculos.buscarNomMarcaB(arrayBoletaT[i].getMarcaBolT()) + 
            " Modelo=" +  EstrVehiculos.buscarNomModeloB(arrayBoletaT[i].getModeloBolT()) + 
            " Kilometraje=" + arrayBoletaT [i].getKilometrajeBolT() + 
            " Fecha=" + arrayBoletaT [i].getFechaBolT() + 
            " Mecanico=" + buscarNomMecanico(Integer.parseInt(arrayBoletaT[i].getMecanicoBolT())));      
        }         
    }
 
 public static void modifBolTaller (){
        System.out.println("-------------------------------------");
            System.out.print("Digite la fila a modificar: ");
            int fila=leer.nextInt();
            System.out.println("");
        int mantenimiento = 0;
        int existe = 0;
        do{
             System.out.println("");
             System.out.print("Digite el mantenimiento asociado: ");
             mantenimiento = leer.nextInt(); System.out.print(" - ");
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        
        System.out.println("");
        String placa = "";
        String marca = "";
        String modelo = "";
        do{
             System.out.println("");
             leer.nextLine();
             System.out.print("Digite la placa del vehiculo: ");
             placa = leer.nextLine(); System.out.print(" - ");
             marca=placa;
             modelo=placa;
             existe = EstrVehiculos.buscarPlaca(placa) /*+ EstrVehiculos.buscarVehiculoM(marca) + EstrVehiculos.buscarVehiculoMo(modelo)*/ ;
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un vehiculo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        System.out.println("");
        System.out.print("Digite el kilometraje del vehiculo: ");
        String kilometraje = leer.nextLine();
        System.out.println("");
        System.out.print("Ingrese la fecha de hoy (ej:20250725): ");
        int fecha = leer.nextInt();
        System.out.println("");
        
        int mecanico = 0;
        int encontrado=0;
         do{
             System.out.println("");
              System.out.println("---- Lista de Mecanicos ----");
    for (int i = 0; i < arrayMecanicos.length; i++) {
        if (arrayMecanicos[i] != null && !arrayMecanicos[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayMecanicos[i]);
        }
    }
                 leer.nextLine();
             System.out.print("Digite El nombre del mecanico: ");
             mecanico = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarMecanico(mecanico);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un Mecanico valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(encontrado < 1);
        
        
        System.out.println("");
        System.out.println("-------------------------------------");
        
         arrayBoletaT[fila-1].setMantBolT(String.valueOf(mantenimiento));
         arrayBoletaT[fila-1].setPlacaBolT(placa); 
         arrayBoletaT[fila-1].setMarcaBolT(marca);
         arrayBoletaT[fila-1].setModeloBolT(modelo);  
         arrayBoletaT[fila-1].setKilometrajeBolT(kilometraje);
         arrayBoletaT[fila-1].setFechaBolT(fecha); 
         arrayBoletaT[fila-1].setMecanicoBolT(String.valueOf(mecanico));
         
        EscribirArchivoBolTaller();
    }
 //--Metodo para borrar mantenimientos
    public static void borrarBolTaller(){
    leer.nextLine();
        System.out.println("-------------------------------------");
        System.out.print(" Digite la fila a eliminar:  ");
        int fila = leer.nextInt();
        
         arrayBoletaT[fila-1] = null;
        
        EscribirArchivoBolTaller();
    }
    
     //--- Métodos y/o Estruturas para Almacenaren Archivos ---//
 
    /*Creación del Archivo*/
    public static void CrearArchivoBolTaller(){
        File miArchivo = new File("boletasTaller.txt");
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
    
 /* Limpiar el Archivo boletasCombustible */
       public static void LimpiarArchivoBolTaller()
       {
          try {
             PrintWriter escritor = new PrintWriter("boletasTaller.txt");
              System.out.println("El contenido de boletasTaller fue borrado.");
            } catch (IOException e ) {
               System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
             }
       }
              
/* Escribir en el Archivo boletasTaller */       
public static void EscribirArchivoBolTaller(){
    //--limpiar antes de escribir
    System.out.println("Limpiando el archivo.");
    LimpiarArchivoBolTaller();

    //-- Estructura para guardar 
    try{
        System.out.println("Entrando al try.");    
        FileWriter escribir = new FileWriter("boletasTaller.txt", true);
        System.out.println("FlieWriter creado.");
        //Variable para que la escriba en el archivo 
        String linea;
         for (int i = 0; i <  arrayBoletaT.length; i++) // Recorre las Filas
         {
           if (  arrayBoletaT[i] != null){
             linea = i + ";" +  arrayBoletaT[i].getIdBolT() + ";" 
                     +  arrayBoletaT[i].getMantBolT() + ";"+  arrayBoletaT[i].getPlacaBolT() + ";" 
                     +  arrayBoletaT[i].getMarcaBolT() + ";" +  arrayBoletaT[i].getModeloBolT() + ";" 
                     +  arrayBoletaT[i].getKilometrajeBolT() + ";" +  arrayBoletaT[i].getFechaBolT() + ";" 
                     +  arrayBoletaT[i].getMecanicoBolT()+ ";\n";
             escribir.write(linea); //-- Escribe en el Archivo
            }
         }
           
        
       //System.out.println("boletasTaller creada");
       //System.out.println("Linea 1 Escrita");
        escribir.write(10); //--comando para cerrar la linea
        escribir.close();//--cerra el archivo 
        System.out.println("Información guardada");
    } catch (IOException e ) {
        System.out.println("Error al guardar.");  
    }
}
       


public static void leerArchivoBolTaller(){
     
   try{
       //Apertura del archivo
       FileReader archivo = new FileReader("boletasTaller.txt");
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
                
                 if (  arrayBoletaT[fila] != null){
                arrayBoletaT[fila].setIdBolT (Integer.parseInt(segmento[1]) );
                arrayBoletaT[fila].setMantBolT(segmento[2]) ;
                arrayBoletaT[fila].setPlacaBolT (segmento[3]);
                arrayBoletaT[fila].setMarcaBolT(segmento[4]) ;
                arrayBoletaT[fila].setModeloBolT (segmento[5]);
                arrayBoletaT[fila].setKilometrajeBolT(segmento[6]);
                arrayBoletaT[fila].setFechaBolT (Integer.parseInt(segmento[7]));
                arrayBoletaT[fila].setMecanicoBolT(segmento[8]);
                 }else {
                   arrayBoletaT[fila] = new BolTaller (Integer.parseInt(segmento[1]), 
                   segmento [2], segmento[3], segmento [4],
                   segmento[5], segmento [6], Integer.parseInt(segmento[7]), segmento[8]);
                 }
                     
            }
           linea = lector.readLine();
        }
       
    } catch (IOException e ) {
     System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
    }   
}


public static int buscarMecanico(int Mecanico){
    int encontrado = 0;
        for (int i = 0; i <arrayMecanicos.length; i++){
            if(arrayMecanicos[i]!=null){
            if ( Mecanico==i){
                encontrado = 1;
                System.out.println( arrayMecanicos[i]);
                break;//metodo para finalizar eventos
            }
            }
        }
              
        if(encontrado ==0){
           System.out.println(" - Mecanico no encontrado. - "); 
       }
        return encontrado;
    }

public static String buscarNomMecanico(int Mecanico){
   String encontrado = "";
        for ( int i = 0; i < arrayMecanicos.length; i++ ){
            if (arrayMecanicos[i] != null){
                if ( Mecanico == i){
                    encontrado = arrayMecanicos[i];
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

public static String buscarNomUltKM(String Placa){
   String encontrado = "";
        for ( int i = arrayBoletaT.length-1; i>=0; i-- ){
            if (arrayBoletaT[i] != null){
                if ( Placa.equalsIgnoreCase(arrayBoletaT[i].getPlacaBolT())){
                    encontrado = arrayBoletaT[i].getKilometrajeBolT();
                    //System.out.print( arrayEspecies[i].getNomEspecie() ); 
                    break;//metodo para finalizar o romper acciones
                }
            }
        }
        if (encontrado == ""){
            encontrado = "ND"; 
        }
        return encontrado;
    }


}

