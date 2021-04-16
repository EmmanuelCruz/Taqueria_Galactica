package taqueriaGalactica;

/**
* Clase representa de un taco galáctico.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class TacoGalactico extends Taco{

	/** Nombre del taco. */
	public String nombre;

	/** Ingredientes del taco. */
	public String descripcion;

	/** Precio del taco. */
	public double precio;

	/**
	* Crea un nuevo taco galáctico.
	* @param nombre el nombre del taco. 
	* @param descripcion los ingredientes dek taco.
	* @param precio el precio del taco-
	*/
	public TacoGalactico(String nombre, String descripcion, double precio){
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.precio=precio;
	}

	@Override
	public String obtenNombre(){
		return nombre;
	}

	@Override
	public String obtenDescripcion(){
		return descripcion;
	}

	@Override
	public double obtenPrecio(){
		return precio;
	}
}