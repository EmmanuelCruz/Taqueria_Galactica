package taqueriaGalactica;

import java.util.Iterator;

/**
* Clase que representa la taquería perteneciente al planeta Venus.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class TaqueriaVenus implements Taqueria{

	/** Lista de tacos de la taqueria. */
	public Taco[] tacos;

	/**
	* Crea una nueva taqueria de Venus.
	* @param tacos la lista de tacos de la taqueria.
	*/
	public TaqueriaVenus(Taco[] tacos){
		this.tacos=tacos;
	}

	@Override
	public Iterator creaIterador(){
		return new TaqueriaVenusIterador(tacos);
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