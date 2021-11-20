package agenda;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author eber
 */
public class Agenda {

    public static AddressBook AddBo = new AddressBook();
    private static Integer contador = 0;
    private static ArrayList listAux = new ArrayList();

    public static void main(String[] args) {
        
        String separator = FileSystems.getDefault().getSeparator();
        String filePath = String.format(
                "datos%sContactos.csv",
                separator, separator, separator, separator
        );
        Path Pathfile = Paths.get(filePath);
        try{
            AddBo.save(filePath);
            System.out.println("empezando a leer el Contactos.csv"); 
            listAux = AddBo.load(filePath);
            list(filePath);
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void list(String filePath) {
        System.out.println(listAux);
        
    }

    public static void create(String filePath) {
        //List<AddressBook> listaContactos = new ArrayList<AddressBook>();
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Escribe el nombre");
        String nombre = lector.nextLine();
        int contador = 3; String contador_S = ""; 
        contador_S = String.valueOf(contador);
        
        
        AddBo.contactos.put(nombre, contador_S);
        
        FileWriter filewriter = null;
        try{
            filewriter = new FileWriter(filePath);
            filewriter.append("Id, nombre, apellido\n");
            //for(AddressBook u: listaContactos){
            //    filewriter.append(String.valueOf(u.getId()));
                filewriter.append(",");
                //filewriter.append(u.getPrimerNombre());
                filewriter.append(",");
                //filewriter.append(u.getApellidos());
                filewriter.append("\n");
        //    }
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            try{
                filewriter.flush();
                filewriter.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void delete(String filePath) {

    }

}
