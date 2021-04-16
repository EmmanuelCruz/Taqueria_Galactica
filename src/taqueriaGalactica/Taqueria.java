package taqueriaGalactica;

import java.util.Iterator;

/**
* Interfaz que define el comportamiento de una taquería.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public interface Taqueria{

	/**
	* Crea un nuevo iterador para una estructura de datos.
	* @return el iterador de la estructura.
	*/
	public Iterator creaIterador();

	/**
	* Regresa un taco elegido por un cliente.
	* @param nombre el nombre del taco a regresar.
	*/
	public Taco regresaTaco(String nombre);
	
}