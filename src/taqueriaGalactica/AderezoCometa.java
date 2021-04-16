package taqueriaGalactica;

/**
* Clase que representa el ingrediente aderezo de cometa.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class AderezoCometa extends Ingrediente{

	/** Taco al cual se agrega el ingrediente extra. */
	public Taco taco;

	/**
	* Crea un nuevo ingrediente para un taco.
	* @param taco el taco al cual agregar el ingrediente extra.
	*/
	public AderezoCometa(Taco taco){
		this.taco=taco;
	}

	@Override
	public String obtenNombre(){
		return taco.obtenNombre();
	}

	@Override
	public String obtenDescripcion(){
		return taco.obtenDescripcion()+", aderezo de cometa";
	}

	@Override
	public double obtenPrecio(){
		return taco.obtenPrecio()+10;
	}
}