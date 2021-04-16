package taqueriaGalactica;

import java.util.Iterator;

/**
* Clase que implementa el comportamiento de un Iterador para arreglos de tipo Taco.
* @author Karem Ramos Calpulalpan. 314068583
* @author Emmanuel Cruz Hernández. 314272588
* @version 1.0 Octubre 2019.
*/
public class TaqueriaVenusIterador implements Iterator{

	/** Lista de tacos. */
	public Taco[] items;

	/** Posición del iterador. */
	public int posicion;

	/**
	* Crea un nuevo iterador para un arreglo de tacos.
	* @param items la estructura de arreglo a iterar.
	*/
	public TaqueriaVenusIterador(Taco[] items){
		this.items=items;
		posicion=-1;
	}

	@Override
	public boolean hasNext(){
		if(posicion+1 >= items.length || items[posicion+1]==null)
			return false;
		return true;
	}

	@Override
	public Taco next(){
		posicion++;
		return items[posicion];
	}
}