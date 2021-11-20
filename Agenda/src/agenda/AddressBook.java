package agenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author eber
 */
public class AddressBook {
    HashMap<String, String> contactos = new HashMap<>();
    private String numero; private String nombre;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList load(String filePath){
        BufferedReader reader = null;
        PrintStream printS = new PrintStream(System.out);
        ArrayList listAux = new ArrayList();
        try{
            List<AddressBook> listaContactos = new ArrayList<AddressBook>();
            String line = "";
            reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            
            while((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                
                if(fields.length > 0){
                    AddressBook AB = new AddressBook();
                    AB.setNumero(fields[0]);
                    AB.setNombre(fields[1]);
                    listaContactos.add(AB);
                }
            }
            for(AddressBook AB: listaContactos){
                System.out.printf("[Numero=%s, Nombre=%s]\n", AB.getNumero(), AB.getNombre());
                printS = printS.printf("[Numero=%s, Nombre=%s]\n", AB.getNumero(), AB.getNombre());
                listAux.add(String.valueOf(printS));
            }
            
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try{
                reader.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        return listAux;
    }
    
    public void save(String filePath){
        List<AddressBook> listaContactos = new ArrayList<>();
        
        // usuarios demo 
        AddressBook AB = new AddressBook();
        AB.setNumero("1");
        AB.setNombre("Jack");
        listaContactos.add(AB);
        
        AB.setNumero("2");
        AB.setNombre("Pedro");
        listaContactos.add(AB);
        
        FileWriter filewriter = null;
        try{
            filewriter = new FileWriter(filePath);
            filewriter.append("Numero, nombre\n");
            for(AddressBook A: listaContactos){
                filewriter.append(String.valueOf(A.getNumero()));
                filewriter.append(",");
                filewriter.append(A.getNombre());
                filewriter.append("\n");
            }
        }catch (IOException e){
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
    
    
}
