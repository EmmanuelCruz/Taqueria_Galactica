package taqueriaGalactica;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.DOMException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Collection;
import java.util.ArrayDeque;

/**
 * Hace la lectura de un XML de un menú de tacos.
 * @author Cruz Hernández Emmanuel. 314272588.
 * @version 0.1 Septiembre 2019.
 */
public class LectorXML{

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los tacos.
     * @return una lista de tacos con los tacos leídos.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public ArrayList<Taco> readArrayList(String fileName) throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	ArrayList<Taco> lista=new ArrayList<Taco>();
	NodeList taqueria=doc.getElementsByTagName("taco");
	Node nodo;
	Element elemento;

	String nombre;
	String descripcion;
	double precio;
	int len=taqueria.getLength();
	for(int i=0;i<len;i++){
	    nodo=taqueria.item(i);
	    elemento=(Element)nodo;
	    nombre=String.valueOf(elemento.getAttribute("nombre"));
	    descripcion=String.valueOf(elemento.getAttribute("descripcion"));
	    precio=Double.valueOf(elemento.getAttribute("precio"));
	    
	    Taco nuevo=new TacoGalactico(nombre, descripcion, precio);
	    lista.add(nuevo);
	}
	return lista;
    }

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los tacos.
     * @return un arrreglo de tacos con los tacos leídos.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public Taco[] readArray(String fileName) throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	NodeList tacos=doc.getElementsByTagName("taco");
	Node nodo;
	Element elemento;
	Taco[] lista=new Taco[tacos.getLength()];

	String nombre;
	String descripcion;
	double precio;
	for(int i=0;i<lista.length;i++){
	    nodo=tacos.item(i);
	    elemento=(Element)nodo;
	    nombre=String.valueOf(elemento.getAttribute("nombre"));
	    descripcion=String.valueOf(elemento.getAttribute("descripcion"));
	    precio=Double.valueOf(elemento.getAttribute("precio"));
	    
	    Taco nuevo=new TacoGalactico(nombre,descripcion,precio);
	    lista[i]=nuevo;
	}
	return lista;
    }

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los tacos.
     * @return un arrreglo de tacos con los tacos leídos.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public Hashtable<String,Taco> readHashtable(String fileName) throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	NodeList tacos=doc.getElementsByTagName("taco");
	Node nodo;
	Element elemento;
	Hashtable<String,Taco> lista=new Hashtable<>();

	String nombre;
	String descripcion;
	double precio;
	int len=tacos.getLength();
	for(int i=0;i<len;i++){
	    nodo=tacos.item(i);
	    elemento=(Element)nodo;
	    nombre=String.valueOf(elemento.getAttribute("nombre"));
	    descripcion=String.valueOf(elemento.getAttribute("descripcion"));
	    precio=Double.valueOf(elemento.getAttribute("precio"));
	    
	    Taco nuevo=new TacoGalactico(nombre, descripcion, precio);
	    lista.put(nombre,nuevo);
	}
	return lista;
    }

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los tacos.
     * @return una lista ligada de tacos con los tacos leídos.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public LinkedList<Taco> readLinkedList(String fileName) throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	LinkedList<Taco> lista=new LinkedList<>();
	NodeList taqueria=doc.getElementsByTagName("taco");
	Node nodo;
	Element elemento;

	String nombre;
	String descripcion;
	double precio;
	int len=taqueria.getLength();
	for(int i=0;i<len;i++){
	    nodo=taqueria.item(i);
	    elemento=(Element)nodo;
	    nombre=String.valueOf(elemento.getAttribute("nombre"));
	    descripcion=String.valueOf(elemento.getAttribute("descripcion"));
	    precio=Double.valueOf(elemento.getAttribute("precio"));
	    
	    Taco nuevo=new TacoGalactico(nombre, descripcion, precio);
	    lista.add(nuevo);
	}
	return lista;
    }

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los tacos.
     * @return una cola de arreglo de tacos con los tacos leídos.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public ArrayDeque<TacoNormal> readQueue(String fileName) throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	ArrayDeque<TacoNormal> lista=new ArrayDeque<>();
	NodeList taqueria=doc.getElementsByTagName("taco");
	Node nodo;
	Element elemento;

	String carne;
	String tortilla;
	boolean salsa;
	boolean verdura;
	double precio;
	int len=taqueria.getLength();
	for(int i=0;i<len;i++){
	    nodo=taqueria.item(i);
	    elemento=(Element)nodo;
	    carne=String.valueOf(elemento.getAttribute("carne"));
	    tortilla=String.valueOf(elemento.getAttribute("tortilla"));
	    salsa=Boolean.valueOf(elemento.getAttribute("salsa"));
	    verdura=Boolean.valueOf(elemento.getAttribute("verdura"));
	    precio=Double.valueOf(elemento.getAttribute("precio"));
	    
	    TacoNormal nuevo=new TacoNormal(carne, salsa, tortilla, verdura, precio);
	    lista.add(nuevo);
	}
	return lista;
    }

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los clientes.
     * @param sucursal la sucursal a la que pertenecen los clientes.
     * @return una lista de clientes con los clientes leídos.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public ArrayList<Cliente> readArrayList(String fileName, Sucursal sucursal)
    			throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	ArrayList<Cliente> lista=new ArrayList<>();
	NodeList clientesFrecuentes=doc.getElementsByTagName("cliente");
	Node nodo;
	Element elemento;

	int id;
	String nombre;
	int len=clientesFrecuentes.getLength();
	for(int i=0;i<len;i++){
	    nodo=clientesFrecuentes.item(i);
	    elemento=(Element)nodo;
	    id=Integer.valueOf(elemento.getAttribute("id"));
	    nombre=String.valueOf(elemento.getAttribute("nombre"));
	    
	    Cliente nuevo=new Cliente(id,nombre, sucursal);
	    lista.add(nuevo);
	}
	return lista;
    }

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los clientes.
     * @return la cantidad de ids registrados en la base de clientes.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public int readCantidad(String fileName)
    			throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	NodeList clientesFrecuentes=doc.getElementsByTagName("clientesFrecuentes");
	Node nodo;
	Element elemento;

	int cantidad;

	nodo=clientesFrecuentes.item(0);
	elemento=(Element)nodo;
	cantidad=Integer.valueOf(elemento.getAttribute("cantidad"));
	return cantidad;
    }

    /**
     * Hace la lectura de un archivo XML.
     * @param fileName el nombre del archivo donde están los comentarios.
     * @return una lista de ccomentarios con los ccomentarios leídos.
     * @throws Exception si algo sale mal con la configuración del Parser.
     */
    public ArrayList<String> readComents(String fileName)
    			throws ParserConfigurationException,
					 SAXException, IOException,
					 DOMException{
	File archivo=new File(fileName);
	DocumentBuilderFactory fab=DocumentBuilderFactory.newInstance();
	DocumentBuilder cons=fab.newDocumentBuilder();
	Document doc=cons.parse(archivo);
	doc.normalizeDocument();

	ArrayList<String> lista=new ArrayList<>();
	NodeList opiniones=doc.getElementsByTagName("comentario");
	Node nodo;
	Element elemento;

	String comentario;
	int len=opiniones.getLength();
	for(int i=0;i<len;i++){
	    nodo=opiniones.item(i);
	    elemento=(Element)nodo;
	    comentario=String.valueOf(elemento.getAttribute("coment"));
	    
	    lista.add(comentario);
	}
	return lista;
    }

}
