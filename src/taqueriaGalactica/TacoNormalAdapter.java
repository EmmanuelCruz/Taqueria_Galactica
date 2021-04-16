package taqueriaGalactica;

/**
* Clase que sirve como un adaptador para que un taco normal se pueda comportar como un Taco.
* @author Emmanuel Cruz Hernández. 314272588.
* @author Karem Ramos Calpulalpan. 314068583.
* @version 1.0 Octubre, 2019.
*/
public class TacoNormalAdapter extends Taco{

	/** Taco normal. */
	public TacoNormal taco;

	/**
	* Crea un nuevo adaptador para un taco normal.
	* @param taco el taco a adaptar.
	*/
	public TacoNormalAdapter(TacoNormal taco){
		this.taco=taco;
	}

	@Override
	public String obtenNombre(){
		return "Taco de "+taco.obtenCarne();
	}

	@Override
	public String obtenDescripcion(){
		return "Tortilla de "+taco.obtenTortilla()+
				", "+(taco.obtenSalsa()?"con ":"sin ")+"salsa"+
				", "+(taco.obtenVerdura()?"con ":"sin ")+"verdura";
	}

	@Override
	public double obtenPrecio(){
		return taco.obtenPrecio();
	}
}