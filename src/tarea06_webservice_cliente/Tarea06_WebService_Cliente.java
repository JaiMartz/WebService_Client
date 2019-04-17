
package tarea06_webservice_cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorwebservices.Moneda;
import servidorwebservices.Pais;
import servidorwebservices.Zona;

/**
 *
 * @author Jairo
 */
public class Tarea06_WebService_Cliente {

    private boolean exit = false;
    public static void main(String[] args) {
        // TODO code application logic here
    Tarea06_WebService_Cliente programa = new Tarea06_WebService_Cliente();
    
        System.out.println("********************************************************\n" +
            "\n" +
            "* PSP - Tarea Individual 6 - Web Services              *\n" +
            "\n" +
            "********************************************************\n" +
            "\n" +
            "* Jairo Martínez Garrido                               *\n" +
            "\n" +
            "********************************************************\n" +
            "\n" +
            "* 76652856C                                            *\n" +
            "\n" +
            "******************************************************** ");

    programa.iniciar();
    }
    /**
     * Inicia la ejecución del programa.
     */
    public void iniciar(){
        try{
            while(!exit){
            System.out.println("\t\t");
            mostrarMenu();
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            String comando = entrada.readLine();

                if(!comando.isEmpty()){
                    switch(comando){
                        case "1":
                            mostrarZonasGeo();
                            break;
                        case "2":
                            mostrarMonedas();
                            break;
                        case "3":
                            mostrarPaises();
                            break;
                        case "4":
                            mostrarPaisZonaGeo(entrada);
                            break;
                        case "5":
                            mostrarPaisMoneda(entrada);
                            break;
                        case "6":
                            consultarPais(entrada);
                            break;
                        case "7":
                            exit  = true;
                            break;
                        default:
                            System.out.println("Comando no reconocido.");

                    }
                }
            }
        }catch(IOException ex){
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
    }
    
    /**
     * Imprime un menú de consola.
     */
    public void mostrarMenu(){
        System.out.println("Selecione opcion: ");
        System.out.println("1 - Listar Zonas Geográficas.");
        System.out.println("2 - Listar Monedas.");
        System.out.println("3 - Listar Países.");
        System.out.println("4 - Listar Países por zona geográfica.");
        System.out.println("5 - Listar Países por moneda.");
        System.out.println("6 - Consultar país.");
        System.out.println("7 - Salir");
        System.out.println(">");
    }
    
    /**
     * Muestra las zonas gegográficas.
     */
    public void mostrarZonasGeo(){
        
        List<Zona> zonas = getZonas();

        for(Zona zona: zonas){
            System.out.println(String.format("%d: %s",zona.getId(),
                    zona.getNombre()));
        }
    }
    /**
     * Muestra las diferentes monedas.
     */
    private void mostrarMonedas(){
        List<Moneda> monedas = getMonedas();

        for(Moneda moneda: monedas){
            System.out.println("Codigo: "+moneda.getCodigo()+" Nombre: "+moneda.getNombre());
        }
    }
    /**
     * Muestra los diferentes paises del mundo.
     */
    private void mostrarPaises(){
        List<Pais> paises = getPaises();

        for(Pais pais: paises){
            System.out.println("Nombre: "+pais.getNombre()+" Codigo divisa: "+pais.getCodigoDivisa());
        }
    }
    
    /**
     * Muestra los paises de una zona geográfica.
     * @param entrada Variable que recoge el parámetro por el que filtrará la búsqueda.
     */
    public void mostrarPaisZonaGeo(BufferedReader entrada){
       
        try {
            System.out.println("Escriba el nombre de la zona geografica: ");
            String nombre = entrada.readLine();
            
            long codigo = Long.parseLong(nombre);
            List<Pais> paisesZona = getPaisesZona(codigo);
            
             for(Pais pais : paisesZona){
               if(pais!= null){
                System.out.println("ID: "+pais.getId());
                System.out.println("Nombre: "+pais.getNombre());
                }
             }
        } catch (IOException ex) {
            Logger.getLogger(Tarea06_WebService_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**
 * Muestra paises filtrados por la moneda que usan.
 * @param entrada Variable que recoge el parámetro por el que filtrará la búsqueda.
 */
    public void mostrarPaisMoneda(BufferedReader entrada){
        try {
            System.out.println("Escriba el nombre de la moneda: ");
            String nombre = entrada.readLine();
            
            List<Pais> paises = getPaisesMoneda(nombre);
            for(Pais pais : paises ){
                if(pais != null){
                    System.out.println("ID: "+pais.getId());
                    System.out.println("Nombre: "+pais.getNombre());
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Tarea06_WebService_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Muestra los datos del país que se consulta.
     * @param entrada Variable que recoge el parámetro por el que filtrará la búsqueda.
     */
    public void consultarPais(BufferedReader entrada){
        try {
            List<Pais> paises = getPaises();
            System.out.println("Introduzca el nombre del pais a consultar: ");
            String nombre = entrada.readLine();

            for(Pais pais : paises){
                if(pais != null){
                    if(pais.getNombre().equals(nombre)){
                        System.out.println("Pais: "+pais.getNombre()+" Zona: "+pais.getIdArea()
                            +" Moneda: "+pais.getCodigoDivisa()+" Bandera: "+pais.getCodigoBandera()+" NIC: "+pais.getCodigoNic());                          
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Tarea06_WebService_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //WEB SERVICES
    
    private static Moneda getMonedaByCodigo(java.lang.String arg0) {
        servidorwebservices.PaisesWebServiceService service = new servidorwebservices.PaisesWebServiceService();
        servidorwebservices.PaisesWebService port = service.getPaisesWebServicePort();
        return port.getMonedaByCodigo(arg0);
    }

    private static java.util.List<servidorwebservices.Moneda> getMonedas() {
        servidorwebservices.PaisesWebServiceService service = new servidorwebservices.PaisesWebServiceService();
        servidorwebservices.PaisesWebService port = service.getPaisesWebServicePort();
        return port.getMonedas();
    }

    private static java.util.List<servidorwebservices.Pais> getPaises() {
        servidorwebservices.PaisesWebServiceService service = new servidorwebservices.PaisesWebServiceService();
        servidorwebservices.PaisesWebService port = service.getPaisesWebServicePort();
        return port.getPaises();
    }

    private static java.util.List<servidorwebservices.Pais> getPaisesMoneda(java.lang.String arg0) {
        servidorwebservices.PaisesWebServiceService service = new servidorwebservices.PaisesWebServiceService();
        servidorwebservices.PaisesWebService port = service.getPaisesWebServicePort();
        return port.getPaisesMoneda(arg0);
    }

    private static java.util.List<servidorwebservices.Pais> getPaisesZona(long arg0) {
        servidorwebservices.PaisesWebServiceService service = new servidorwebservices.PaisesWebServiceService();
        servidorwebservices.PaisesWebService port = service.getPaisesWebServicePort();
        return port.getPaisesZona(arg0);
    }

    private static Zona getZonaById(long arg0) {
        servidorwebservices.PaisesWebServiceService service = new servidorwebservices.PaisesWebServiceService();
        servidorwebservices.PaisesWebService port = service.getPaisesWebServicePort();
        return port.getZonaById(arg0);
    }

    private static java.util.List<servidorwebservices.Zona> getZonas() {
        servidorwebservices.PaisesWebServiceService service = new servidorwebservices.PaisesWebServiceService();
        servidorwebservices.PaisesWebService port = service.getPaisesWebServicePort();
        return port.getZonas();
    }
    
}
