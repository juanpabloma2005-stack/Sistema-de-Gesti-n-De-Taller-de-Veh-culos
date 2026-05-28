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
public class EstrReportes {
    static Scanner leer = new Scanner (System.in);
    
    //Constructor del archivo
    public EstrReportes() {
        
    }
    
     //----Definir la estructura Compleja para las especies
    public static class Reporte {
    //--Caracteristicas 
       String placaR ;
       String marcaR ;
       String modeloR ;
       String mantenimientoR ;
       int ultKM ;
       int actKM ;
       int periodicidad ;
       int difKM ;
       //boolean DIF ;
              

       //--Constructor de la estructura
        public Reporte (String placaR, String marcaR, String modeloR, String mantenimientoR, int ultKM, int actKM, int periodicidad, int difKM) {           
            this.placaR = placaR;
            this.marcaR = marcaR;
            this.modeloR = modeloR;
            this.mantenimientoR = mantenimientoR;
            this.ultKM = ultKM;
            this.actKM = actKM;
            this.periodicidad= periodicidad;
            this.difKM = difKM;
            //this.DIF = DIF;
        }
       
       //--Metodo de trabajo (Getters) de las estructuras
        public String getplacaRep(){
            return placaR;
        }
        public String getmarcaRep(){
            return marcaR;
        }
        public String getmodeloRep(){
            return modeloR;
        }
        public String getmantenimentoRRep(){
            return mantenimientoR;
        }
        public int getUltKMRep(){
            return ultKM;
        }
        public int getActKMRep(){
            return actKM;
        }
        public int getPeiodicidadRep(){
            return periodicidad;
        }
        public int getDifKMRep(){
            return difKM;
        }
       /* public boolean getDIFKMRep(){
            return DIF;
        }*/
        
        //-- Set = ESTABLECER O ASIGNAR
        //-- Metodos de Trabajo (Setters)
        public void setPlacaRRep(String placaR){
            this.placaR = placaR;
        }
        public void setMarcaRRep(String nombre){
            this.marcaR = marcaR;
        }
        public void setModeloRRep(String modeloR){
            this.modeloR = modeloR;
        }  
        public void setMantenimientoRRep(String mantenimientoR){
            this.mantenimientoR = mantenimientoR;
        }
        public void setUltKMRep(int ultKM){
            this.ultKM = ultKM;
        }
        public void setActKMRep(int actKM){
            this.actKM = actKM;
        }  
         public void setPeriodicidadRep(int id){
            this.periodicidad = periodicidad;
        }
        public void setDifKMRep(int difKM){
            this.difKM = difKM;
        }
       /* public void setDIFRep(boolean estado){
            this.DIF = DIF;
        }  */
    }      

//Fin de la estructura compleja

//Declaramos un array de 1 dimension tipo estructura complejas
static Reporte []arrayReporte = new Reporte [100];

public static void regReporte(){
    System.out.println("-------------------------------------");
    String placa= "";
    String marcaR = "";
    String modeloR = ""; 
    String mantenimientoR = "";
    String ultKm = "";
    String actKm = "";
    String periodicidad = "";
    String difKM = "";
    int existe = 0;

    System.out.println("-------------------------------------");
        System.out.print("Ingrese la fila a llenar: ");
        int fila=leer.nextInt();

     do{
             System.out.println("");
             leer.nextLine();
             System.out.print("Digite la placa del vehiculo: ");
             placa = leer.nextLine(); System.out.print(" -Marca= ");
             marcaR=placa;
             modeloR=placa;
             mantenimientoR=placa;
             ultKm=placa;
             actKm=placa;
             periodicidad=placa;
             difKM=placa;
             
             existe = EstrVehiculos.buscarPlacaReporte(placa);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un vehiculo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
    System.out.println("-------------------------------------");
            arrayReporte [fila-1]= new Reporte ( placa, marcaR, modeloR, mantenimientoR, Integer.parseInt(ultKm),
                    Integer.parseInt(actKm) , Integer.parseInt(periodicidad), Integer.parseInt(difKM)  );      

            CrearArchivoReporte();
            LimpiarArchivoReporte();
    } 
    public static void enlistarReportes(){
        System.out.println("--------------------------------");
        System.out.println("|       Lista de Reportes      |");        
        System.out.println("---------------------------------");
        for (int i = 0; i < arrayReporte.length; i++ )
                 if (arrayReporte [i] != null){
                System.out.println("Fila:"+ (i + 1) +
                " placa= " + arrayReporte[i].getplacaRep()+
                " Marca= "+EstrVehiculos.buscarNomMarcaP((arrayReporte[i].getmarcaRep())) + 
                " -Modelo= " + EstrVehiculos.buscarNomModeloP((arrayReporte[i].getmodeloRep())) + 
                " -Mantenimiento= " + EstrMantenimientos.buscarNomMantenimientoP((arrayReporte[i].getmantenimentoRRep())) + 
                " -Ultimo Kilometraje= " +  EstrBolTaller.arrayBoletaT[i].getKilometrajeBolT()+ 
                " -Kilometraje actual= " + EstrBolCombustible.arrayBolCombustible[i].getKilometrajeBolC()+ 
                " -Periodicidad= " + EstrVehiculos.EncontrarMant(arrayReporte[i].getplacaRep())+
                mantenimientoListo(arrayReporte[i].getplacaRep())+";\n"
                );
        }
        leerArchivoReporte();
    }
    public static String mantenimientoListo(String Placa){
        String DIF="";
        for (int i = 0; i < arrayReporte.length; i++ ){
            if (arrayReporte [i] != null){
                if(Placa.equalsIgnoreCase(arrayReporte[i].getplacaRep())){
                    if((Integer.parseInt(EstrBolCombustible.arrayBolCombustible[i].getKilometrajeBolC()) 
                    - Integer.parseInt(EstrBolTaller.arrayBoletaT[i].getKilometrajeBolT())) >= EstrVehiculos.EncontrarMant(arrayReporte[i].getplacaRep())){
                    DIF=" Si Toca";
                    }else{
                    DIF=" No Le Toca";
                    }
                }
            }
        }
        return DIF;
    }
    
    public static void modifReporte(){
       System.out.println("-------------------------------------");
    String placa= "";
    String marcaR = "";
    String modeloR = ""; 
    String mantenimientoR = "";
    String ultKm = "";
    String actKm = "";
    String periodicidad = "";
    String difKM = "";
    int existe = 0;

    System.out.println("-------------------------------------");
        System.out.println("Ingrese la fila a llenar: ");
        int fila=leer.nextInt();

     do{
             System.out.println("");
             leer.nextLine();
             System.out.print("Digite la placa del vehiculo: ");
             placa = leer.nextLine(); System.out.print(" -Marca= ");
             marcaR=placa;
             modeloR=placa;
             mantenimientoR=placa;
             ultKm=placa;
             actKm=placa;
             periodicidad=placa;
             difKM=placa;
             
             existe = EstrVehiculos.buscarPlacaReporte(placa);
             if(existe==0){
                 JOptionPane.showMessageDialog(null, "Debe indicar un vehiculo valido",
                         "ATENCION", JOptionPane.WARNING_MESSAGE);
             }
        }while(existe < 1);
    System.out.println("-------------------------------------");
    
    arrayReporte[fila-1].setPlacaRRep(placa); 
    arrayReporte[fila-1].setMarcaRRep(marcaR);
    arrayReporte[fila-1].setModeloRRep(modeloR); 
    arrayReporte[fila-1].setMantenimientoRRep(mantenimientoR); 
    arrayReporte[fila-1].setUltKMRep( Integer.parseInt(ultKm));
    arrayReporte[fila-1].setActKMRep(Integer.parseInt(actKm));
    arrayReporte[fila-1].setPeriodicidadRep(Integer.parseInt(periodicidad));
    arrayReporte[fila-1].setDifKMRep(Integer.parseInt(difKM));
        
    EscribirArchivoReporte();
    }
    

public static void borrarReporte(){
    leer.nextLine();
        System.out.println("-------------------------------------");
        System.out.print(" Digite la fila a eliminar:  ");
        int fila = leer.nextInt();
        
        arrayReporte[fila-1] = null;
        
        EscribirArchivoReporte();
    }
//--- Métodos y/o Estruturas para Almacenaren Archivos ---//
 
    /*Creación del Archivo*/
    public static void CrearArchivoReporte(){
        File miArchivo = new File("reportes.txt");
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
       public static void LimpiarArchivoReporte()
       {
          try {
             PrintWriter escritor = new PrintWriter("reportes.txt");
              System.out.println("El contenido de boletasTaller fue borrado.");
            } catch (IOException e ) {
               System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
             }
       }
              
/* Escribir en el Archivo boletasTaller */       
public static void EscribirArchivoReporte(){
    //--limpiar antes de escribir
    System.out.println("Limpiando el archivo.");
    LimpiarArchivoReporte();

    //-- Estructura para guardar 
    try{
        System.out.println("Entrando al try.");    
        FileWriter escribir = new FileWriter("reportes.txt", true);
        System.out.println("FlieWriter creado.");
        //Variable para que la escriba en el archivo 
        String linea;
         for (int i = 0; i <  arrayReporte.length; i++) // Recorre las Filas
         {
           if (  arrayReporte[i] != null){
             linea = i + ";" +  arrayReporte[i].getplacaRep()+ ";" 
                     +  arrayReporte[i].getmarcaRep()+ ";" + arrayReporte[i].getmodeloRep()+ ";" 
                     +  arrayReporte[i].getmantenimentoRRep()+  ";" +arrayReporte[i].getUltKMRep()+ ";" 
                     +  arrayReporte[i].getActKMRep() + ";"  +  arrayReporte[i].getPeiodicidadRep()+  ";" + arrayReporte[i].getDifKMRep() 
                     /*+  arrayReporte[i].getDIFKMRep()*/+ ";\n";
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
       


public static void leerArchivoReporte(){
     
   try{
       //Apertura del archivo
       FileReader archivo = new FileReader("reportes.txt");
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
                
                 if (  arrayReporte[fila] != null){
                arrayReporte[fila].setPlacaRRep(segmento[1]);
                arrayReporte[fila].setMarcaRRep(segmento[2]) ;
                arrayReporte[fila].setModeloRRep(segmento[3]);
                arrayReporte[fila].setMantenimientoRRep(segmento[4]) ;
                arrayReporte[fila].setUltKMRep(Integer.parseInt(segmento[5]));
                arrayReporte[fila].setActKMRep(Integer.parseInt(segmento[6]));
                arrayReporte[fila].setPeriodicidadRep(Integer.parseInt(segmento[7]));
                arrayReporte[fila].setDifKMRep(Integer.parseInt(segmento[8]));
               // arrayReporte[fila].setDIFRep(Boolean.parseBoolean(segmento[9]));
                 }else {
                   arrayReporte[fila] = new Reporte 
                ((segmento[1]),(segmento [2]), segmento[3], (segmento[4]),
                (Integer.parseInt(segmento[5])), (Integer.parseInt(segmento[6])), (Integer.parseInt(segmento[7])), 
                (Integer.parseInt(segmento[8])) /*,(Boolean.parseBoolean(segmento[9]))*/);
                 }
                     
            }
           linea = lector.readLine();
        }
       
    } catch (IOException e ) {
     System.out.println("Error al borar el contenido " +
                                      e.getMessage() );
    }   
}


}

