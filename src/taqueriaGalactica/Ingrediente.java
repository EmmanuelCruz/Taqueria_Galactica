package taqueriaGalactica;

/**
* Ingrediente extra que puede tener un taco galáctico.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public abstract class Ingrediente extends Taco{

	@Override
	public abstract String obtenNombre();

	@Override
	public abstract String obtenDescripcion();

	@Override
	public abstract double obtenPrecio();
}