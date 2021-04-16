package taqueriaGalactica;

import java.util.Iterator;
import java.util.Hashtable;
import java.util.Collection;

/**
* Clase que representa la taquería perteneciente al planeta Mercurio.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class TaqueriaMercurio implements Taqueria{

	/** Lista de tacos de la taqueria. */
	public Hashtable<String,Taco> tacos;

	/**
	* Crea una nueva taqueria de Mercurio.
	* @param tacos la lista de tacos de la taqueria.
	*/
	public TaqueriaMercurio(Hashtable<String,Taco> tacos){
		this.tacos=tacos;
	}

	@Override
	public Iterator creaIterador(){
		Collection valores=tacos.values();
		return valores.iterator();
	}

	@Override
	public Taco regresaTaco(String nombre){
		return tacos.get(nombre);
	}
}