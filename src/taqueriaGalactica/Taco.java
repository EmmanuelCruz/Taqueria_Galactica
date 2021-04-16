package taqueriaGalactica;

/**
* Clase abstracta que define el comportamiento y representación de un taco.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public abstract class Taco{

	/**
	* Obtiene el nombre del taco.
	* @return el nombre del taco.
	*/
	public abstract String obtenNombre();

	/**
	* Obtiene la descripción del taco.
	* @return la descripción del taco.
	*/
	public abstract String obtenDescripcion();

	/**
	* Obtiene el precio del taco.
	* @return el precio del taco.
	*/
	public abstract double obtenPrecio();

	@Override
	public String toString(){
		return "Nombre: "+this.obtenNombre()+"     "+
				"Ingredientes: "+this.obtenDescripcion()+"     "+
				"Precio: "+this.obtenPrecio();
	}

}