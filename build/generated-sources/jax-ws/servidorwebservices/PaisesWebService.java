
package servidorwebservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PaisesWebService", targetNamespace = "http://servidorwebservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PaisesWebService {


    /**
     * 
     * @param arg0
     * @return
     *     returns servidorwebservices.Zona
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getZonaById", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetZonaById")
    @ResponseWrapper(localName = "getZonaByIdResponse", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetZonaByIdResponse")
    @Action(input = "http://servidorwebservices/PaisesWebService/getZonaByIdRequest", output = "http://servidorwebservices/PaisesWebService/getZonaByIdResponse")
    public Zona getZonaById(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0);

    /**
     * 
     * @return
     *     returns java.util.List<servidorwebservices.Pais>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPaises", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetPaises")
    @ResponseWrapper(localName = "getPaisesResponse", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetPaisesResponse")
    @Action(input = "http://servidorwebservices/PaisesWebService/getPaisesRequest", output = "http://servidorwebservices/PaisesWebService/getPaisesResponse")
    public List<Pais> getPaises();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<servidorwebservices.Pais>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPaisesZona", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetPaisesZona")
    @ResponseWrapper(localName = "getPaisesZonaResponse", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetPaisesZonaResponse")
    @Action(input = "http://servidorwebservices/PaisesWebService/getPaisesZonaRequest", output = "http://servidorwebservices/PaisesWebService/getPaisesZonaResponse")
    public List<Pais> getPaisesZona(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0);

    /**
     * 
     * @return
     *     returns java.util.List<servidorwebservices.Moneda>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMonedas", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetMonedas")
    @ResponseWrapper(localName = "getMonedasResponse", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetMonedasResponse")
    @Action(input = "http://servidorwebservices/PaisesWebService/getMonedasRequest", output = "http://servidorwebservices/PaisesWebService/getMonedasResponse")
    public List<Moneda> getMonedas();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<servidorwebservices.Pais>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPaisesMoneda", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetPaisesMoneda")
    @ResponseWrapper(localName = "getPaisesMonedaResponse", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetPaisesMonedaResponse")
    @Action(input = "http://servidorwebservices/PaisesWebService/getPaisesMonedaRequest", output = "http://servidorwebservices/PaisesWebService/getPaisesMonedaResponse")
    public List<Pais> getPaisesMoneda(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @return
     *     returns java.util.List<servidorwebservices.Zona>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getZonas", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetZonas")
    @ResponseWrapper(localName = "getZonasResponse", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetZonasResponse")
    @Action(input = "http://servidorwebservices/PaisesWebService/getZonasRequest", output = "http://servidorwebservices/PaisesWebService/getZonasResponse")
    public List<Zona> getZonas();

    /**
     * 
     * @param arg0
     * @return
     *     returns servidorwebservices.Moneda
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMonedaByCodigo", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetMonedaByCodigo")
    @ResponseWrapper(localName = "getMonedaByCodigoResponse", targetNamespace = "http://servidorwebservices/", className = "servidorwebservices.GetMonedaByCodigoResponse")
    @Action(input = "http://servidorwebservices/PaisesWebService/getMonedaByCodigoRequest", output = "http://servidorwebservices/PaisesWebService/getMonedaByCodigoResponse")
    public Moneda getMonedaByCodigo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}