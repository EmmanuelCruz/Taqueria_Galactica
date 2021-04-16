package taqueriaGalactica;

import java.util.Iterator;
import java.util.Queue;

/**
* Clase que representa la taquería perteneciente al planeta Tierra.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class TaqueriaTierra implements Taqueria{

	/** Lista de tacos de la taqueria. */
	public Queue<Taco> tacos;

	/**
	* Crea una nueva taqueria de Tierra.
	* @param tacos la lista de tacos de la taqueria.
	*/
	public TaqueriaTierra(Queue<Taco> tacos){
		this.tacos=tacos;
	}

	@Override
	public Iterator creaIterador(){
		return tacos.iterator();
	}

	@Override
	public Taco regresaTaco(String nombre){
		Iterator it=this.creaIterador();
		Taco recorredor=null;
		while(it.hasNext()){
			recorredor=(Taco) it.next();
			if(recorredor.obtenNombre().equals(nombre))
				return recorredor;
		}
		return null;
	}
}