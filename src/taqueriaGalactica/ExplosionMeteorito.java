package taqueriaGalactica;

/**
* Clase que representa el ingrediente explosión de meteorito.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class ExplosionMeteorito extends Ingrediente{

	/** Taco al cual se agrega el ingrediente extra. */
	public Taco taco;

	/**
	* Crea un nuevo ingrediente para un taco.
	* @param taco el taco al cual agregar el ingrediente extra.
	*/
	public ExplosionMeteorito(Taco taco){
		this.taco=taco;
	}

	@Override
	public String obtenNombre(){
		return taco.obtenNombre();
	}

	@Override
	public String obtenDescripcion(){
		return taco.obtenDescripcion()+", explosión de meteorito";
	}

	@Override
	public double obtenPrecio(){
		return taco.obtenPrecio()+20.50;
	}
}