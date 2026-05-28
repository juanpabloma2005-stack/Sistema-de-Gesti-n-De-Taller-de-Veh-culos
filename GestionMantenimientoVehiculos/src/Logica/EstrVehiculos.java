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
public class EstrVehiculos {
    static Scanner leer = new Scanner (System.in);
    //Constructor del archivo
    public EstrVehiculos() {
        
    }
    
     //----Definir la estructura Compleja para los vehiculos 
    public static class Vehiculo {
    //--Caracteristicas 
       int id ;
       String placa ;
       String marca ; 
       String modelo ;
       String año ; 
       String mantenimiento1 ;
       int periodo1;
       String mantenimiento2 ;
       int periodo2;
       String mantenimiento3 ;
       int periodo3;
       

       //--Constructor de la estructura
        public Vehiculo (int id, String placa, String marca, String modelo, String año, String mantenimiento1, int periodo1, String mantenimiento2, int periodo2, String mantenimiento3, int periodo3) {           
            this.id = id;
            this.placa = placa;
            this.marca = marca;
            this.modelo = modelo;
            this.año = año;
            this.mantenimiento1 = mantenimiento1;
            this.periodo1 = periodo1;
            this.mantenimiento2 = mantenimiento2;
            this.periodo2 = periodo2;
            this.mantenimiento3 = mantenimiento3;
            this.periodo3 = periodo3;
        }
       
       //--Metodo de trabajo (Getters) de las estructuras
        public int getIdVehiculo(){
            return id;
        }
        public String getPlacaVehiculo(){
            return placa;
        }
        public String getMarcaVehiculo(){
            return marca;
        }
        public String getModeloVehiculo(){
            return modelo;
        }
        public String getAñoVehiculo(){
            return año;
        }
        public String getMant1Vehiculo(){
            return mantenimiento1;
        }
        public int getPeriodo1Vehiculo(){
            return periodo1;
        }
        public String getMant2Vehiculo(){
            return mantenimiento2;
        }
         public int getPeriodo2Vehiculo(){
            return periodo2;
        }
        public String getMant3Vehiculo(){
            return mantenimiento3;
        }
         public int getPeriodo3Vehiculo(){
            return periodo3;
        }
        
        
        //-- Set = ESTABLECER O ASIGNAR
        //-- Metodos de Trabajo (Setters)
        public void setIdVehiculo(int id){
            this.id = id;
        }
        public void setPlacaVehiculo(String placa){
            this.placa = placa;
        }
        public void setMarcaVehiculo(String marca){
            this.marca = marca;
        }   
        public void setModelVehiculo(String modelo){
            this.modelo = modelo;
        }
        public void setAñoVehiculo(String año){
            this.año = año;
        }
        public void setMant1Vehi(String mantenimiento1){
            this.mantenimiento1 = mantenimiento1;
        }
        public void setPeriodo1(int periodo1){
            this.periodo1 = periodo1;
        }
        public void setMant2Vehi(String mantenimiento2){
            this.mantenimiento2 = mantenimiento2;
        }
        public void setPeriodo2(int periodo2){
            this.periodo2 = periodo2;
        }
        public void setMant3Vehi(String mantenimiento3){
            this.mantenimiento3 = mantenimiento3;
        }
        public void setPeriodo3(int periodo3){
            this.periodo3 = periodo3;
        }
    }      

//Fin de la estructura compleja

//Declaramos un array de 1 dimension tipo estructura complejas
static Vehiculo []arrayVehiculo = new Vehiculo [100];
static String[] arrayMarcas = {
    "Honda", "Toyota", "Hyundai", "Chevrolet", "Ferrari", "Lotus", "BMW", "Mazda", "Mercedes", "Nissan"};
    
    
    static String[] arrayModelos = {
    "CR-V", "Yaris", "Elantra", "Santa Fe", "SP38", "Evija", "M8", "CX-5", "AMG GT", "Kics"};
   

public static void regVehiculo(){
        System.out.println("-------------------------------------");  
        System.out.print(" Digite la fila a llenar: ");
        int fila = leer.nextInt();
        int id = fila+100;
        System.out.println("");
        leer.nextLine();
        System.out.print(" Digite La Placa Del Vehiculo: ");
        String placa = leer.nextLine();
        leer.nextLine();
        
        int marca = 0;
        int encontrado=0;
         do{
             System.out.println("");
              System.out.println("---- Lista de Marcas ----");
    for (int i = 0; i < arrayMarcas.length; i++) {
        if (arrayMarcas[i] != null && !arrayMarcas[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayMarcas[i]);
        }
    }
             System.out.print("Digite La Marca Del Vehiculo: ");
             marca = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarMarca(marca);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar una marca valida",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(encontrado < 1);
        
        
        
        leer.nextLine();
        int modelo=0;
        do{
           System.out.println("");
           System.out.println("---- Lista de Modelos ----");
    for (int i = 0; i < arrayModelos.length; i++) {
        if (arrayModelos[i] != null && !arrayModelos[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayModelos[i]);
        }
    }
       System.out.print("Digite El Modelo Del Vehiculo: ");
             modelo = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarModelo(modelo);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un Modelo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(encontrado < 1);
        
       
        leer.nextLine();
         System.out.println("");
        System.out.print(" Digite El Anio Del Vehiculo: "); 
        String año = leer.nextLine();
        leer.nextLine();
        int mantenimiento1 = 0;
        int existe = 0;
        do{
             System.out.println("");
             System.out.print("Digite el mantenimiento asociado: ");
             mantenimiento1 = leer.nextInt(); System.out.print(" - ");
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento1);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        System.out.print(" Digite El periodo del primer mantenimiento: "); 
        int periodo1 = leer.nextInt();
        leer.nextLine();
        int mantenimiento2 = 0;
        
        do{
             System.out.println("");
             System.out.print("Digite el  segundo mantenimiento asociado (o 100 si no hay ninguno asociado): ");
             mantenimiento2 = leer.nextInt(); System.out.print(" - ");
             if (mantenimiento2==100) break;
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento2);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        int periodo2=0;
        if(mantenimiento2!=100){
        System.out.print(" Digite El periodo del segundo mantenimiento: "); 
        periodo2 = leer.nextInt();
        leer.nextLine();
        }else{
            periodo2=periodo2;
        }
        
        int mantenimiento3 = 0;
        do{
             System.out.println("");
             System.out.print("Digite el tercer mantenimiento asociado (o 100 si no hay ninguno asociado): ");
             mantenimiento3 = leer.nextInt(); System.out.print(" - ");
              if (mantenimiento3==100) break;
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento3);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        int periodo3=0;
        if(mantenimiento3!=100){
        System.out.print(" Digite El periodo del tercer mantenimiento: "); 
        periodo3 = leer.nextInt();
        leer.nextLine();
        }else{
           periodo3=periodo3;
        }
        System.out.println("-------------------------------------");
        
        arrayVehiculo[fila-1] = new Vehiculo (id, placa, String.valueOf(marca), String.valueOf(modelo), año, String.valueOf(mantenimiento1), 
                periodo1, String.valueOf(mantenimiento2), periodo2, String.valueOf(mantenimiento3), periodo3);
    
        CrearArchivoVehiculo();
        EscribirArchivoVehiculo();
}   


public static void enlistarVehiculos()
        {
             System.out.println("--------------------------------");
             System.out.println("|       Lista de Vehiculos      |");        
             System.out.println("---------------------------------");
             //Estructura de control para recorrer
             for (int i = 0; i < 100; i++ )
                 if (arrayVehiculo[i] != null){
            System.out.println("Fila:"+ (i + 1) +
            " ID="+ arrayVehiculo[i].getIdVehiculo()+
            " Placa=" + arrayVehiculo[i].getPlacaVehiculo()+ 
            " Marca=" + buscarNomMarca(Integer.parseInt(arrayVehiculo[i].getMarcaVehiculo()))+
            " Modelo="+ buscarNomModelo(Integer.parseInt(arrayVehiculo[i].getModeloVehiculo()))+
            " Anio=" + arrayVehiculo[i].getAñoVehiculo()+ 
            " Mantenimiento1=" + EstrMantenimientos.buscarNomMantenimiento(Integer.parseInt(arrayVehiculo[i].getMant1Vehiculo()))+ 
            " Periodo=" + arrayVehiculo[i].getPeriodo1Vehiculo() +
            " Mantenimiento2=" + EstrMantenimientos.buscarNomMantenimiento(Integer.parseInt(arrayVehiculo[i].getMant2Vehiculo()))+
            " Periodo=" + arrayVehiculo[i].getPeriodo2Vehiculo() + 
            " Mantenimiento3=" + EstrMantenimientos.buscarNomMantenimiento(Integer.parseInt(arrayVehiculo[i].getMant3Vehiculo()))+
            " Periodo=" + arrayVehiculo[i].getPeriodo3Vehiculo()
            );      
        }
             leerArchivoVehiculo();
    }

public static void modifVehiculo(){
System.out.println("-------------------------------------");  
        System.out.print(" Digite la fila a modificar: ");
        int fila = leer.nextInt();
        System.out.println("");
        leer.nextLine();
        System.out.print(" Digite La Placa Del Vehiculo: ");
        String placa = leer.nextLine();
        leer.nextLine();
        
        int marca = 0;
        int encontrado=0;
         do{
             System.out.println("");
              System.out.println("---- Lista de Marcas ----");
    for (int i = 0; i < arrayMarcas.length; i++) {
        if (arrayMarcas[i] != null && !arrayMarcas[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayMarcas[i]);
        }
    }
             System.out.print("Digite La Marca Del Vehiculo: ");
             marca = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarMarca(marca);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar una marca valida",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(encontrado < 1);
        leer.nextLine();
        int modelo=0;
        do{
           System.out.println("");
           System.out.println("---- Lista de Modelos ----");
    for (int i = 0; i < arrayModelos.length; i++) {
        if (arrayModelos[i] != null && !arrayModelos[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayModelos[i]);
        }
    }
       System.out.print("Digite El Modelo Del Vehiculo: ");
             modelo = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarModelo(modelo);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un Modelo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(encontrado < 1);
        
       
        leer.nextLine();
         System.out.println("");
        System.out.print(" Digite El Anio Del Vehiculo: "); 
        String año = leer.nextLine();
        leer.nextLine();
        int mantenimiento1 = 0;
        int existe = 0;
        do{
             System.out.println("");
             System.out.print("Digite el mantenimiento asociado: ");
             mantenimiento1 = leer.nextInt(); System.out.print(" - ");
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento1);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        System.out.print(" Digite El periodo del " + mantenimiento1 + ": "); 
        int periodo1 = leer.nextInt();
        leer.nextLine();
        int mantenimiento2 = 0;
        
        do{
             System.out.println("");
             System.out.print("Digite el  segundo mantenimiento asociado (o 100 si no hay ninguno asociado): ");
             mantenimiento2 = leer.nextInt(); System.out.print(" - ");
             if (mantenimiento2==100) break;
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento2);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        int periodo2=0;
        if(mantenimiento2!=100){
        System.out.print(" Digite El periodo del " + mantenimiento2 + ": "); 
        periodo2 = leer.nextInt();
        leer.nextLine();
        }else{
            periodo2=periodo2;
        }
        
        int mantenimiento3 = 0;
        do{
             System.out.println("");
             System.out.print("Digite el tercer mantenimiento asociado (o 100 si no hay ninguno asociado): ");
             mantenimiento3 = leer.nextInt(); System.out.print(" - ");
              if (mantenimiento3==100) break;
             existe = EstrMantenimientos.buscarMantenimiento(mantenimiento3);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un mantenimiento valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
        int periodo3=0;
        if(mantenimiento3!=100){
        System.out.print(" Digite El periodo del " + mantenimiento3 + ": "); 
        periodo3 = leer.nextInt();
        leer.nextLine();
        }else{
           periodo3=periodo3;
        }
        System.out.println("-------------------------------------");
        
        arrayVehiculo[fila-1].setPlacaVehiculo(placa);
        arrayVehiculo[fila-1].setMarcaVehiculo(String.valueOf(marca));
        arrayVehiculo[fila-1].setModelVehiculo(String.valueOf(modelo));
        arrayVehiculo[fila-1].setAñoVehiculo(año);
        arrayVehiculo[fila-1].setMant1Vehi(String.valueOf(mantenimiento1));
        arrayVehiculo[fila-1].setPeriodo1(periodo1);
        arrayVehiculo[fila-1].setMant2Vehi(String.valueOf(mantenimiento2));
        arrayVehiculo[fila-1].setPeriodo2(periodo2);
        arrayVehiculo[fila-1].setMant3Vehi(String.valueOf(mantenimiento3));
        arrayVehiculo[fila-1].setPeriodo3(periodo3);

        EscribirArchivoVehiculo();
}

 public static void borraVehiculo(){
    leer.nextLine();
        System.out.println("-------------------------------------");
        System.out.print(" Digite la fila a eliminar:  ");
        int fila = leer.nextInt();
        
        arrayVehiculo[fila-1] = null;
        
        EscribirArchivoVehiculo();
    }

 //--- Métodos y/o Estruturas para Almacenaren Archivos ---//
 
    /*Creación del Archivo*/
    public static void CrearArchivoVehiculo(){
        File miArchivo = new File("vehiculos.txt");
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
    
 /* Limpiar el Archivo Vehiculos */
       public static void LimpiarArchivoVehiculo()
       {
          try {
             PrintWriter escritor = new PrintWriter("vehiculos.txt");
              System.out.println("El contenido de vehiculos fue borrado.");
            } catch (IOException e ) {
               System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
             }
       }
              
/* Escribir en el Archivo vehiculos */       
public static void EscribirArchivoVehiculo(){
    //--limpiar antes de escribir
    System.out.println("Limpiando el archivo.");
    LimpiarArchivoVehiculo();

    //-- Estructura para guardar 
    try{
        System.out.println("Entrando al try.");    
        FileWriter escribir = new FileWriter("vehiculos.txt", true);
        System.out.println("FlieWriter creado.");
        //Variable para que la escriba en el archivo 
        String linea;
         for (int i = 0; i <  arrayVehiculo.length; i++) // Recorre las Filas
         {
           if (  arrayVehiculo[i] != null){
             linea = i + ";" +  arrayVehiculo[i].getIdVehiculo() + ";" 
                     +  arrayVehiculo[i].getPlacaVehiculo() + ";"+  arrayVehiculo[i].getMarcaVehiculo() + ";" 
                     +  arrayVehiculo[i].getModeloVehiculo() + ";" +  arrayVehiculo[i].getAñoVehiculo() + ";" 
                     +  arrayVehiculo[i].getMant1Vehiculo() + ";" +  arrayVehiculo[i].getPeriodo1Vehiculo() + ";" 
                     +  arrayVehiculo[i].getPeriodo2Vehiculo() + ";" + arrayVehiculo[i].getPeriodo3Vehiculo() + ";\n";
             escribir.write(linea); //-- Escribe en el Archivo
            }
         }
           
        
       
        escribir.write(10); //--comando para cerrar la linea
        escribir.close();//--cerra el archivo 
        System.out.println("Información guardada");
    } catch (IOException e ) {
        System.out.println("Error al guardar.");  
    }
}
       


        public static void leerArchivoVehiculo(){
     
   try{
       //Apertura del archivo
       FileReader archivo = new FileReader("vehiculos.txt");
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
                
                 if (  arrayVehiculo[fila] != null){
                arrayVehiculo[fila].setIdVehiculo(Integer.parseInt(segmento[1]) );
                arrayVehiculo[fila].setPlacaVehiculo(segmento[2]) ;
                arrayVehiculo[fila].setMarcaVehiculo(segmento[3]);
                arrayVehiculo[fila].setModelVehiculo(segmento[4]) ;
                arrayVehiculo[fila].setAñoVehiculo(segmento[5]);
                arrayVehiculo[fila].setMant1Vehi(segmento[6]);
                arrayVehiculo[fila].setPeriodo1(Integer.parseInt(segmento[7]));
                arrayVehiculo[fila].setMant2Vehi(segmento[8]);
                arrayVehiculo[fila].setPeriodo2(Integer.parseInt(segmento[9]));
                arrayVehiculo[fila].setMant3Vehi(segmento[10]);
                arrayVehiculo[fila].setPeriodo2(Integer.parseInt(segmento[11]));
                 }else {
                   arrayVehiculo[fila] = new Vehiculo 
        ((Integer.parseInt(segmento[1])), segmento [2], (segmento[1]), segmento [4],
                   segmento[5], segmento [6], Integer.parseInt(segmento[7]), segmento[8],
         Integer.parseInt(segmento [9]), segmento[10], Integer.parseInt(segmento [11]));
                 }
                     
            }
           linea = lector.readLine();
        }
       
    } catch (IOException e ) {
     System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
    }   
}


    public static int buscarMarca(int Marca){
    int encontrado = 0;
        for (int i = 0; i <arrayMarcas.length; i++){
            if(arrayMarcas[i]!=null){
                if(Marca==i){
                encontrado = 1;
                System.out.println( arrayMarcas[i]);
                break;//metodo para finalizar eventos
                }
            }
            
        }
        
        
        if(encontrado ==0){
           System.out.println(" - Marca no encontrada o no disponible. - "); 
       }
        return encontrado;
    }

        public static String buscarNomMarca(int Marca){
        String encontrado = "";
        for ( int i = 0; i < arrayMarcas.length; i++ ){
            if (arrayMarcas[i] != null){
                if ( Marca == i){
                    encontrado = arrayMarcas[i];
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

        public static String buscarNomMarcaP(String Placa){
        String encontrado = "";
        for ( int i = 0; i < arrayMarcas.length; i++ ){
            if (arrayMarcas[i] != null){
                if ( Placa.equalsIgnoreCase(arrayVehiculo[i].getPlacaVehiculo())){
                    encontrado = arrayMarcas[i];
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

        
    public static int buscarModelo(int Modelo){
    int encontrado = 0;
        for (int i = 0; i <arrayModelos.length; i++){
            if(arrayMarcas[i]!=null){
                if(Modelo==i){
                encontrado = 1;
                System.out.println( arrayModelos[i]);
                break;//metodo para finalizar eventos
                }
            }
        }
              
        if(encontrado ==0){
           System.out.println(" - Modelo no encontrada o no disponible. - "); 
       }
        return encontrado;
    }
    
  public static String buscarNomModelo(int Modelo){
        String encontrado = "";
        for ( int i = 0; i < arrayModelos.length; i++ ){
            if (arrayModelos[i] != null){
                if ( Modelo == i){
                    encontrado = arrayModelos[i];
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
  
  public static String buscarNomModeloP(String Placa){
        String encontrado = "";
        for ( int i = 0; i < arrayModelos.length; i++ ){
            if (arrayModelos[i] != null){
                if ( Placa.equalsIgnoreCase(arrayVehiculo[i].getPlacaVehiculo())){
                    encontrado = arrayModelos[i];
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

  public static int buscarPlaca(String Placa){
        int encontrado = 0;
        for (int i = 0; i <arrayVehiculo.length; i++){
            if(arrayVehiculo[i]!=null){
            if (Placa.equalsIgnoreCase(arrayVehiculo[i].getPlacaVehiculo())){
                encontrado = 1;
                System.out.println( buscarNomMarca(Integer.parseInt(arrayVehiculo[i].getMarcaVehiculo())) + " - " +
                        buscarNomModelo(Integer.parseInt(arrayVehiculo[i].getModeloVehiculo())));
                break;//metodo para finalizar eventos
            }
            }
        }
        
        if(encontrado ==0){
           System.out.println(" - Vehiculo no encontrado. - "); 
       }
        return encontrado;
    }
  
  public static String buscarNomMarcaB(String Placa){
        String encontrado = "";
        for (int i = 0; i <arrayVehiculo.length; i++){
            if(arrayVehiculo[i]!=null){
                 if (Placa.equalsIgnoreCase(arrayVehiculo[i].getPlacaVehiculo())){
                encontrado = buscarNomMarca(Integer.parseInt(arrayVehiculo[i].getMarcaVehiculo()));
                break;//metodo para finalizar eventos
                }
            }
        }
        
       if (encontrado == ""){
            encontrado = "x"; 
        }
        return encontrado;
    }
  
  public static String buscarNomModeloB(String Placa){
        String encontrado = "";
        for (int i = 0; i <arrayVehiculo.length; i++){
            if(arrayVehiculo[i]!=null){
                 if (Placa.equalsIgnoreCase(arrayVehiculo[i].getPlacaVehiculo())){
                encontrado = buscarNomModelo(Integer.parseInt(arrayVehiculo[i].getModeloVehiculo()));
                break;//metodo para finalizar eventos
                }
            }
        }
        
       if (encontrado == ""){
            encontrado = "x"; 
        }
        return encontrado;
    }
  
  public static int buscarPlacaReporte(String Placa){
        int encontrado = 0;
        for (int i = arrayVehiculo.length-1; i>=0;  i--){
            if(arrayVehiculo[i]!=null){
            if (Placa.equalsIgnoreCase(arrayVehiculo[i].getPlacaVehiculo())){
                encontrado = 1;
                System.out.println( buscarNomMarca(Integer.parseInt(arrayVehiculo[i].getMarcaVehiculo())) + " -Modelo= " +
                buscarNomModelo(Integer.parseInt(arrayVehiculo[i].getModeloVehiculo())) + " -Mantenimiento= " + 
                EstrMantenimientos.buscarNomMantenimiento(Integer.parseInt(EstrBolTaller.arrayBoletaT[i].getMantBolT())) + " -Ultimo Kilometraje= " +
                EstrBolTaller.arrayBoletaT[i].getKilometrajeBolT()+ " -Kilometraje actual= " +
                EstrBolCombustible.arrayBolCombustible[i].getKilometrajeBolC()+ " -Periodicidad= " + 
                   EncontrarMant(Placa)   
                );
                break;//metodo para finalizar eventos
            }
            }
        }
        
        if(encontrado ==0){
           System.out.println(" - Vehiculo no encontrado. - "); 
       }
        return encontrado;
    }
  
    public static int EncontrarMant(String Placa){
      int encontrado=0;
        for (int i = 0; i <arrayVehiculo.length; i++){
            if(arrayVehiculo[i]!=null){
                if(Placa.equalsIgnoreCase(arrayVehiculo[i].getPlacaVehiculo())){
                    if(arrayVehiculo[i].getMant1Vehiculo().equalsIgnoreCase(EstrBolTaller.arrayBoletaT[i].getMantBolT())){
                    encontrado=arrayVehiculo[i].getPeriodo1Vehiculo();
                }else if (arrayVehiculo[i].getMant2Vehiculo().equalsIgnoreCase(EstrBolTaller.arrayBoletaT[i].getMantBolT())){
                   encontrado=arrayVehiculo[i].getPeriodo2Vehiculo(); 
                }else{
                    encontrado=arrayVehiculo[i].getPeriodo3Vehiculo();
                }
            }
      
        }
    }
        return encontrado;
}
}