package taqueriaGalactica;

import java.util.Iterator;
import java.util.ArrayList;

/**
* Clase que representa la taquería perteneciente al planeta Marte.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class TaqueriaMarte implements Taqueria{

	/** Lista de tacos de la taqueria. */
	public ArrayList<Taco> tacos;

	/**
	* Crea una nueva taqueria de Marte.
	* @param tacos la lista de tacos de la taqueria.
	*/
	public TaqueriaMarte(ArrayList<Taco> tacos){
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