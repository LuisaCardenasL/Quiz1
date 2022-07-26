
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * Clase en la que debe implementar los métodos para cada una de las funcionalidades
solicitadas en el quiz.
 */

/**
 *
 * @author COLOQUE SU NOMBRE AQUI
 */
public class AnalisisPalabras {
    private ArrayList<String> palabrasAlmacenadas;
    
    
    public AnalisisPalabras()
    {
        palabrasAlmacenadas = new ArrayList<>();
    }
    
    public void leerArchivo (){
        String acumuladorArchivo = "";
        String linea; //la que voy a leer y la que voy a partir
        
        try {
            Scanner lector = new Scanner(new File("archivo.txt"));
            while (lector.hasNext()) 
            {
                linea = lector.nextLine();
                acumuladorArchivo += linea + "\n";
                String[] fila = linea.split(" ");
                for (int i = 0; i<fila.length; i++){
                    palabrasAlmacenadas.add(fila[i]);
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo leer el archivo");
        }
    }
    
    public String  mostrarPalabras(){
        String mostrar = "";
        String separador = "_________________";
        int totalPalabras = 0;
        int totalLetras = 0;
                
        for(int i = 0; i < palabrasAlmacenadas.size(); i++){
            mostrar += palabrasAlmacenadas.get(i) + "\t" + palabrasAlmacenadas.get(i).chars().count() +"\n";
        }
                
        totalPalabras = palabrasAlmacenadas.size();
                
        for(int i = 0; i < palabrasAlmacenadas.size(); i++){
            totalLetras += palabrasAlmacenadas.get(i).chars().count();
        }
        
        return mostrar + separador + "\n\n" + "Total Palabras " + totalPalabras + "\n" + "Total Caracteres: " + totalLetras;
                
    }
    
    public void buscarPalabras(){
        String buscar = "";
        int buscarPalabras = 0;
                
        for(int i = 0; i < palabrasAlmacenadas.size(); i++){
            if(buscar.equals(palabrasAlmacenadas.get(i))){
            buscarPalabras++;
            System.out.println("entre");
            }
        }
    }
}
