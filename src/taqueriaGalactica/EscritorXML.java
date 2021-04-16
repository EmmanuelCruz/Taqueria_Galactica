package taqueriaGalactica;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.Result;
import javax.xml.transform.OutputKeys;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Clase que hace la escritura de un archivo XML, en este caso 
 * de clientes usando DOM.
 * @author Cruz Hernández Emmanuel. 314272588.
 * @version Octubre 2019.
 */
public class EscritorXML{
    
    private Document documento;
    
    /**
     * Constructor para un nuevo Parser.
     * @throws ParserConfigurationException si algo sale mal
     * en la construcción de un nuevo Parser.
     */
    public EscritorXML() throws ParserConfigurationException{
        DocumentBuilderFactory cons=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=cons.newDocumentBuilder();
        documento=builder.newDocument();
    }
    
    /**
     * Crea un nuevo documento XML de Clientes en una lista.
     * @param ids la cantidad de ids registrados.
     * @param lista un objeto ArrayList de clientes.
     */
    public void creaDocumento(int ids, ArrayList<Cliente> lista){
        Element clientes=documento.createElement("clientesFrecuentes");
        //Agrega como hijo directo de documento a Clientes.
        clientes.setAttribute("cantidad",""+ids);
        documento.appendChild(clientes);
        Cliente actual;
        int longitud=lista.size();
        for(int i=0;i<longitud;i++){
        	actual=lista.get(i);
        	Element cliente=documento.createElement("cliente");
			clientes.appendChild(cliente);
			cliente.setAttribute("id",""+actual.obtenerId());
			cliente.setAttribute("nombre",""+actual.obtenerNombre());
		}
    }
    
    /**
     * Genera el archivo XMl.
     * @param nombre el nombre del archivo donde escribir.
     * @throws Exception si algo sucede mal.
     */
    public void genera(String nombre) throws TransformerConfigurationException,
				FileNotFoundException,
				IOException,
				TransformerException{
		TransformerFactory fact=TransformerFactory.newInstance();
		Transformer trans=fact.newTransformer();
	
		Source sour=new DOMSource(documento);
		File file=new File(nombre);
		FileWriter fw=new FileWriter(file);
		PrintWriter pw=new PrintWriter(fw);
		Result result=new StreamResult(pw);
	
		try{
		    trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Clientes.dtd");
		    trans.setOutputProperty(OutputKeys.INDENT, "yes");
			trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			trans.transform(sour, result);
		}catch(TransformerConfigurationException tce){
		}catch(TransformerException te){}
    }

    /**
     * Crea un nuevo documento XML de Ccomentarios en una lista.
     * @param lista un objeto ArrayList de clientes.
     */
    public void creaDocumento(ArrayList<String> lista){
        Element opiniones=documento.createElement("opiniones");
        documento.appendChild(opiniones);
        String actual;
        int longitud=lista.size();
        for(int i=0;i<longitud;i++){
            actual=lista.get(i);
            Element comentario=documento.createElement("comentario");
            opiniones.appendChild(comentario);
            comentario.setAttribute("coment",""+actual);
        }
    }
    
    /**
     * Genera el archivo XMl.
     * @param nombre el nombre del archivo donde escribir.
     * @throws Exception si algo sucede mal.
     */
    public void generaComentariosXML(String nombre) throws TransformerConfigurationException,
                FileNotFoundException,
                IOException,
                TransformerException{
        TransformerFactory fact=TransformerFactory.newInstance();
        Transformer trans=fact.newTransformer();
    
        Source sour=new DOMSource(documento);
        File file=new File(nombre);
        FileWriter fw=new FileWriter(file);
        PrintWriter pw=new PrintWriter(fw);
        Result result=new StreamResult(pw);
    
        try{
            trans.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "Comentarios.dtd");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");
            trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            trans.transform(sour, result);
        }catch(TransformerConfigurationException tce){
        }catch(TransformerException te){}
    }
}
