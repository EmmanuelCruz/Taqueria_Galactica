package taqueriaGalactica;

/**
* Clase representa de un taco normal de la tierra.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class TacoNormal{

	/** Tipo de carne del taco. */
	public String tipoCarne;

	/** Verifica si el taco tiene salsa. */
	public boolean tieneSalsa;

	/** Tipo de tortilla. */
	public String tipoTortilla;

	/** Verifica si el taco tiene verdura. */
	public boolean tieneVerdura;

	/** Precio del taco. */
	public double precio;

	/**
	* Crea un nuevo taco normal de la tierra.
	* @param carne el tipo de carne del taco.
	* @param salsa el verificador que indica si el taco tiene salsa.
	* @param tortilla el tipo del tortilla del taco.
	* @param precio el precio del taco.
	*/
	public TacoNormal(String carne, boolean salsa, String tortilla, boolean verdura, double precio){
		this.tipoCarne=carne;
		this.tieneSalsa=salsa;
		this.tipoTortilla=tortilla;
		this.tieneVerdura=verdura;
		this.precio=precio;
	}

	/**
	* Regresa el tipo de carne del taco.
	* @return el tipo de carne del taco-
	*/
	public String obtenCarne(){
		return tipoCarne;
	}

	/**
	* Verifica si el taco tiene salsa.
	* @return true si el taco tiene salsa, false en otro caso.
	*/
	public boolean obtenSalsa(){
		return tieneSalsa;
	}

	/**
	* Regresa el tipo de tortilla del taco.
	* @return el tipo de tortilla del taco-
	*/
	public String obtenTortilla(){
		return tipoTortilla;
	}

	/**
	* Verifica si el taco tiene verdura.
	* @return true si el taco tiene verdura, false en otro caso.
	*/
	public boolean obtenVerdura(){
		return tieneVerdura;
	}

	/**
	* Regresa el precio del taco.
	* @return el precio del taco.
	*/
	public double obtenPrecio(){
		return precio;
	}
}