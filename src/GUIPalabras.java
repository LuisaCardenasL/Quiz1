
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Luisa Maria Cardenas Lopez - 1823494
 */
public class GUIPalabras extends JFrame{
    private JLabel lTexto;
    private JTextArea taMostrar;
    private JTextField tfBuscar;
    private JScrollPane barra;
    private JButton bBuscar, bMostrar, bReemplazar;
    private JPanel pOpciones;
    private ArrayList<String> palabrasAlmacenadas;
    
    /**
     * Constructor de la clase
     */
    public GUIPalabras()
    {
        initComponents();
        //contruccion del frame
        setTitle("Quiz 1");
        setSize(700,400);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void initComponents(){
        lTexto = new JLabel("Palabra a buscar:");
        
        tfBuscar = new JTextField();
        
        taMostrar = new JTextArea(400,350);
        barra = new JScrollPane(taMostrar);
        
        bBuscar = new JButton("Buscar");
        bMostrar = new JButton("Mostrar");
        bReemplazar = new JButton("Reemplazar");
        
        palabrasAlmacenadas = new ArrayList<String>();
        
        pOpciones = new JPanel(new GridLayout(1,5,1,1));
        
        pOpciones.add(lTexto);
        pOpciones.add(tfBuscar);
        pOpciones.add(bBuscar);
        pOpciones.add(bMostrar);
        pOpciones.add(bReemplazar);
        
        //escuchas
        ManejadoraEventos evento = new ManejadoraEventos();
        bBuscar.addActionListener(evento);
        bMostrar.addActionListener(evento);
        bReemplazar.addActionListener(evento);
        
        add(pOpciones, BorderLayout.NORTH);
        add(barra, BorderLayout.CENTER);
        
        //carga archivo
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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUIPalabras obj = new GUIPalabras();
    }
    
    //clase interna manejadora de eventos    
    class ManejadoraEventos implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(ae.getSource() == bBuscar){
                taMostrar.setText(" ");
                
                String buscar = "";
                int buscarPalabras = 0;
                ArrayList<String> contarPalabras;
                
                buscar = tfBuscar.getText();
                contarPalabras = new ArrayList<>();
                
                for(int i = 0; i < palabrasAlmacenadas.size(); i++){
                    if(buscar.equals(palabrasAlmacenadas.get(i))){
                        buscarPalabras++;
                        System.out.println("entre");
                    }
                }
                
                taMostrar.setText("La cantidad de veces que aparece la palabra " + buscar + " es: " + buscarPalabras);
                
                tfBuscar.setText(" ");
            }
            
            if(ae.getSource() == bMostrar){
                taMostrar.setText(" ");
                tfBuscar.setText(" ");
                
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
                
                taMostrar.setText(mostrar + separador + "\n\n" + "Total Palabras " + totalPalabras + "\n" + "Total Caracteres: " + totalLetras);
                
            }
            if(ae.getSource() == bReemplazar){
                taMostrar.setText(" ");
                
                String reemplazar = tfBuscar.getText();
                
                for (int i = 0; i < palabrasAlmacenadas.size(); i++){
                }
            }
        }

        
    }//fin clase Manejadora
}// fin clase GUI
