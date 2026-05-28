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

public class EstrBolCombustible {
    static Scanner leer = new Scanner (System.in);
    
    //Constructor del archivo
    public EstrBolCombustible() {       
    }
    
     //----Definir la estructura Compleja para las especies
    public static class BolCombustible {
    //--Caracteristicas 
       int id ;
       String placa;
       String marca;
       String modelo;
       String kilometraje;
       String cantCombustible;
       String tipoCombustible;
       int fecha;
       String chofer;

       //--Constructor de la estructura
        public BolCombustible (int id, String placa, String marca, String modelo, String kilometraje, String cantCombustible, String tipoCombustible, int fecha, String chofer) {           
            this.id = id;
            this.placa = placa;
            this.marca = marca;
            this.modelo = modelo;
            this.kilometraje = kilometraje;
            this.cantCombustible = cantCombustible;
            this.tipoCombustible = tipoCombustible;
            this.fecha = fecha;
            this.chofer = chofer;
        }
       
       //--Metodo de trabajo (Getters) de las estructuras
        public int getIdBolC(){
            return id;
        }
        public String getPlacaBolC(){
            return placa;
        }
        public String getMarcaBolC(){
            return marca;
        }
        public String getModeloBolC(){
            return modelo;
        }
        public String getKilometrajeBolC(){
            return kilometraje;
        }
        public String getCantCombustibleBolC(){
            return cantCombustible;
        }
        public String getTipoCombustibleBolC(){
            return tipoCombustible;
        }
        public int getFechaBolC(){
            return fecha;
        }
         public String getChoferBolC(){
            return chofer;
        }
        
        //-- Set = ESTABLECER O ASIGNAR
        //-- Metodos de Trabajo (Setters)
        public void setIdBolC(int id){
            this.id = id;
        }
        public void setPlacaBolC(String placa){
            this.placa = placa;
        }
        
        public void setMarcaBolC(String marca){
            this.marca = marca;
        }
        public void setModeloBolC(String modelo){
            this.modelo = modelo;
        }
        public void setKilometrajeBolC(String kilometraje){
            this.kilometraje = kilometraje;
        }   
        public void setCantCombustibleBolC(String cantCombustible){
            this.cantCombustible = cantCombustible;
        }
        public void setTipoCombustibleBolC(String tipoCombustible){
            this.tipoCombustible = tipoCombustible;
        }   
        public void setFechaBolC(int fecha){
            this.fecha = fecha;
        }
        public void setChoferBolC(String chofer){
            this.chofer = chofer;
        }   
    }
//Fin de la estructura compleja

//Declaramos un array de 1 dimension tipo estructura complejas
static BolCombustible []arrayBolCombustible = new BolCombustible [100];

static String[] arrayChoferes = {
    "Alonso Mora", "Fernando Castillo", "Victoria Brenes", "Carlos Pacheco", "Andrey Lopez", "Juan Mendez","Carolina Montero", "Hernan Hidalgo"};
    
static String[] arrayCombustible = {
    "Diesel", "Regular", "Super", "Gas LPG"};
   
    
    public static void regBolCombustible(){
        System.out.println("-------------------------------------");
            System.out.print("Digite la fila a llenar:");
            int fila = leer.nextInt();
            int id = fila+10;
            System.out.println("");

        int existe = 0;    
        String placa = "";
        String marca = "";
        String modelo = "";
        do{
            leer.nextLine();
             System.out.println("");
             System.out.print("Digite la placa del vehiculo:");
             placa = leer.nextLine(); System.out.print(" - ");
             existe = EstrVehiculos.buscarPlaca(placa);
             marca=placa;
             modelo=placa;
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un vehiculo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
             
             
        }while(existe < 1);
        System.out.println("");
        System.out.print("Digite el kilometraje del vehiculo: ");
        String kilometraje = leer.nextLine();
        System.out.println("");
        System.out.print("Digite la cantidad de combustible: ");
        String cantCombustible = leer.nextLine();
        System.out.println("");
        
        
        
        int tipoCombustible = 0;
        int encontrado = 0;
         do{
             System.out.println("");
              System.out.println("---- Lista de Combustibles ----");
         for (int i = 0; i < arrayCombustible.length; i++) {
         if (arrayCombustible[i] != null && !arrayCombustible[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayCombustible[i]);
            }
         }
             System.out.print("Digite el tipo de combustible: ");
             tipoCombustible = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarCombustible(tipoCombustible);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un tipo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
             
             
        }while(encontrado < 1);

        System.out.println("");
        System.out.print("Ingrese la fecha de hoy (ej:20250725): ");
        int fecha = leer.nextInt();
        System.out.println("");

        
        int chofer = 0;
        do{
             System.out.println("");
              System.out.println("---- Lista de Choferes ----");
           for (int i = 0; i < arrayChoferes.length; i++) {
           if (arrayChoferes[i] != null && !arrayChoferes[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayChoferes[i]);
                }
            }
             System.out.print("Digite el nombre del chofer: ");
             chofer = leer.nextInt(); System.out.print(" - ");
             encontrado = buscarChofer(chofer);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un chofer valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
              }while(existe < 1);
        System.out.println("-------------------------------------");
        //--Guardar en el array de Especies
        //Archivo    Array donde guardo[pocision]   //Archivo  Constructor de la de EstructuraCompleja    
        arrayBolCombustible [fila-1] = new BolCombustible (id, placa, marca, modelo, kilometraje, cantCombustible, String.valueOf(tipoCombustible), fecha, String.valueOf(chofer));      
        
        CrearArchivoBolCombustible();
        EscribirArchivoBolCombustible();
    }

        
    public static void enlistarBolCombustible(){
        
        {
             System.out.println("---------------------------------------");
             System.out.println("|    Lista de Boletas de Combustible  |");        
             System.out.println("---------------------------------------");
             //Estructura de control para recorrer
             for (int i = 0; i < arrayBolCombustible.length; i++ )
                 if (arrayBolCombustible [i] != null){
            System.out.println("Fila:"+ (i + 1) +
            " ID= "+ arrayBolCombustible [i].getIdBolC()+
            " Placa = " + arrayBolCombustible [i].getPlacaBolC()+ 
            " Marca = " + EstrVehiculos.buscarNomMarcaB(arrayBolCombustible[i].getMarcaBolC()) + 
            " Modelo = " + EstrVehiculos.buscarNomModeloB(arrayBolCombustible[i].getModeloBolC()) + 
            " Kilometraje = " + arrayBolCombustible [i].getKilometrajeBolC()+ 
            " Cantidad de Combustible = " + arrayBolCombustible [i].getCantCombustibleBolC() + 
            " Tipo de Combustible = " + buscarNomCombustible(Integer.parseInt(arrayBolCombustible[i].getTipoCombustibleBolC()))+
            " Fecha = " + arrayBolCombustible [i].getFechaBolC() + 
            " Chofer = " + buscarNomChofer(Integer.parseInt(arrayBolCombustible[i].getChoferBolC())));              
        }
    }
    }
    
    public static void modifBolCombustible(){
              System.out.println("-------------------------------------");
            System.out.print("Digite la fila a modificar:");
            int fila = leer.nextInt();
            System.out.println("");

        int existe = 0;    
        String placa = "";
        String marca = "";
        String modelo = "";
        do{
            leer.nextLine();
             System.out.println("");
             System.out.print("Digite la placa del vehiculo:");
             placa = leer.nextLine(); System.out.println(" - ");
             existe = EstrVehiculos.buscarPlaca(placa);
             marca=placa;
             modelo=placa;
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un vehiculo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
             
             
        }while(existe < 1);
        System.out.println("");
        System.out.print("Digite el kilometraje del vehiculo: ");
        String kilometraje = leer.nextLine();
        System.out.println("");
        System.out.print("Digite la cantidad de combustible:");
        String cantCombustible = leer.nextLine();
        System.out.println("");
        
        
        
        int tipoCombustible = 0;
        int encontrado = 0;
         do{
             System.out.println("");
              System.out.println("---- Lista de Combustibles ----");
         for (int i = 0; i < arrayCombustible.length; i++) {
         if (arrayCombustible[i] != null && !arrayCombustible[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayCombustible[i]);
            }
         }
             System.out.print("Digite el tipo de combustible:");
             tipoCombustible = leer.nextInt(); System.out.println(" - ");
             encontrado = buscarCombustible(tipoCombustible);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un tipo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
             
             
        }while(encontrado < 1);

        System.out.println("");
        System.out.println("Ingrese la fecha de hoy (ej:20250725):");
        int fecha = leer.nextInt();
        System.out.println("");

        
        int chofer = 0;
        do{
             System.out.println("");
              System.out.println("---- Lista de Choferes ----");
           for (int i = 0; i < arrayChoferes.length; i++) {
           if (arrayChoferes[i] != null && !arrayChoferes[i].isEmpty()) {
            System.out.println("[" + i + "] " + arrayChoferes[i]);
                }
            }
             System.out.print("Digite el nombre del chofer: ");
             chofer = leer.nextInt(); System.out.println(" - ");
             encontrado = buscarChofer(chofer);
             if(encontrado==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un chofer valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
              }while(existe < 1);
        System.out.println("-------------------------------------");
        
        arrayBolCombustible[fila-1].setPlacaBolC(placa); 
        arrayBolCombustible[fila-1].setMarcaBolC(marca);
        arrayBolCombustible[fila-1].setModeloBolC(modelo);  
        arrayBolCombustible[fila-1].setKilometrajeBolC(kilometraje);
        arrayBolCombustible[fila-1].setCantCombustibleBolC(cantCombustible); 
        arrayBolCombustible[fila-1].setTipoCombustibleBolC(String.valueOf(tipoCombustible));
        arrayBolCombustible[fila-1].setFechaBolC(fecha);
        arrayBolCombustible[fila-1].setChoferBolC(String.valueOf(chofer));
        
        EscribirArchivoBolCombustible();
    }
   
public static void borrarBolCombustible(){
    leer.nextLine();
        System.out.println("-------------------------------------");
        System.out.print(" Digite la fila a eliminar:  ");
        int fila = leer.nextInt();
        
        arrayBolCombustible[fila-1] = null;
        
        EscribirArchivoBolCombustible();
    }

  //--- Métodos y/o Estruturas para Almacenaren Archivos ---//
 
    /*Creación del Archivo*/
    public static void CrearArchivoBolCombustible(){
        File miArchivo = new File("boletasCombustible.txt");
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
       public static void LimpiarArchivoBolCombustible()
       {
          try {
             PrintWriter escritor = new PrintWriter("boletasCombustible.txt");
              System.out.println("El contenido de boletasTaller fue borrado.");
            } catch (IOException e ) {
               System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
             }
       }
              
/* Escribir en el Archivo boletasTaller */       
public static void EscribirArchivoBolCombustible(){
    //--limpiar antes de escribir
    System.out.println("Limpiando el archivo.");
    LimpiarArchivoBolCombustible();

    //-- Estructura para guardar 
    try{
        System.out.println("Entrando al try.");    
        FileWriter escribir = new FileWriter("boletasCombustible.txt", true);
        System.out.println("FlieWriter creado.");
        //Variable para que la escriba en el archivo 
        String linea;
         for (int i = 0; i <  arrayBolCombustible.length; i++) // Recorre las Filas
         {
           if (  arrayBolCombustible[i] != null){
             linea = i + ";" +  arrayBolCombustible[i].getIdBolC() + ";" 
                     +  arrayBolCombustible[i].getPlacaBolC() + ";" +  arrayBolCombustible[i].getMarcaBolC() + ";" 
                     +  arrayBolCombustible[i].getModeloBolC() + ";" +  arrayBolCombustible[i].getKilometrajeBolC() + ";" 
                     +  arrayBolCombustible[i].getCantCombustibleBolC() + ";" +  arrayBolCombustible[i].getTipoCombustibleBolC() + ";" 
                     +  arrayBolCombustible[i].getFechaBolC() + ";" +  arrayBolCombustible[i].getChoferBolC() + ";\n";
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
       


public static void leerArchivoBolCombustible(){
     
   try{
       //Apertura del archivo
       FileReader archivo = new FileReader("boletasCombustible.txt");
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
                
                 if (  arrayBolCombustible[fila] != null){
                arrayBolCombustible[fila].setIdBolC (Integer.parseInt(segmento[1]) );
                arrayBolCombustible[fila].setPlacaBolC(segmento[2]) ;
                arrayBolCombustible[fila].setMarcaBolC(segmento[3]);
                arrayBolCombustible[fila].setModeloBolC(segmento[4]) ;
                arrayBolCombustible[fila].setKilometrajeBolC(segmento[5]);
                arrayBolCombustible[fila].setCantCombustibleBolC(segmento[6]);
                arrayBolCombustible[fila].setTipoCombustibleBolC(segmento[7]);
                arrayBolCombustible[fila].setFechaBolC(Integer.parseInt(segmento[8]));
                arrayBolCombustible[fila].setChoferBolC(segmento[9]);
                 }else {
                   arrayBolCombustible[fila] 
                           = new BolCombustible  (Integer.parseInt(segmento[1]), 
                                   segmento [2], segmento[3], segmento [4], 
                                   segmento[5], segmento [6], segmento[7],
                                   Integer.parseInt(segmento[8]), segmento [9]);
                 }
                     
            }
           linea = lector.readLine();
        }
       
    } catch (IOException e ) {
     System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
    }   
}

public static int GenId(){
    int contador = 0;
    try (BufferedReader lector = new BufferedReader(new FileReader("boletasTaller.txt"))) {
        while (lector.readLine() != null) {
            contador++;
        }
    } catch (IOException e) {
        // En caso de que el archivo no exista o haya un error, retorna 0
        return 0;
    }
    return contador;
}



//--------------------| METODOS PARA USAR EN REGISTRAR |------------------------


public static int buscarCombustible(int Combustible){
    int encontrado = 0;
        for (int i = 0; i < arrayCombustible.length; i++){
            if(arrayCombustible[i]!=null){
            if ( Combustible ==i){
                encontrado = 1;
                System.out.println(arrayCombustible[i]);
                break;//metodo para finalizar eventos
            }
            }
        }
        
        
        if(encontrado ==0){
           System.out.println(" - Combustible no encontrado o no disponible. - "); 
       }
        return encontrado;
    }

    public static String buscarNomCombustible(int Combustible){
    String encontrado = "";
        for (int i = 0; i < arrayCombustible.length; i++){
            if(arrayCombustible[i]!=null){
            if ( Combustible ==i){
                encontrado = arrayCombustible[i];
                //System.out.println(arrayCombustible[i]);
                break;//metodo para finalizar eventos
            }
            }
        }
        
        
        if(encontrado ==""){
            encontrado="" ;
        }
        return encontrado;
    }



/*---------------------------------------------------------------------*/


public static int buscarChofer(int Chofer){
    int encontrado = 0;
        for (int i = 0; i < arrayChoferes.length; i++){
            if(arrayChoferes[i]!=null){
            if ( Chofer==i){
                encontrado = 1;
                System.out.println(arrayChoferes[i]);
                break;//metodo para finalizar eventos
            }
            }
        }
        
        
        if(encontrado ==0){
           System.out.println(" - Chofer no encontrado o no disponible. - "); 
       }
        return encontrado;
    }

    public static String buscarNomChofer (int Chofer){
    String encontrado = "";
        for (int i = 0; i < arrayChoferes.length; i++){
            if(arrayChoferes[i]!=null){
            if ( Chofer ==i){
                encontrado = arrayChoferes[i];
                //System.out.println(arrayCombustible[i]);
                break;//metodo para finalizar eventos
            }
            }
        }
        
        
        if(encontrado ==""){
            encontrado="" ;
        }
        return encontrado;
    }    

    public static String buscarNomActKM(String Placa){
   String encontrado = "";
        for ( int i = arrayBolCombustible.length-1; i>=0; i-- ){
            if (arrayBolCombustible[i] != null){
                if ( Placa.equalsIgnoreCase(arrayBolCombustible[i].getPlacaBolC())){
                    encontrado = arrayBolCombustible[i].getKilometrajeBolC();
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
