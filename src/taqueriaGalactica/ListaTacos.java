package taqueriaGalactica;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.ArrayDeque;

/**
* Clase que representa la lista de tacos de las sucursales de la tierra.
* @author Karem Ramos Calpulalpan. 314068583
* @author Emmanuel Cruz Hernández. 314272588
* @version 1.0 Octubre 2019.
*/
public class ListaTacos{

	/** Taqueria saturno. */
	public Taqueria saturno;

	/** Taqueria tierra. */
	public Taqueria tierra;

	/** Taqueria mercurio. */
	public Taqueria mercurio;

	/** Taqueria venus. */
	public Taqueria venus;

	/** Taqueria marte. */
	public Taqueria marte;

	/**
	* Crea una nueva lista de tacos.
	*/
	public ListaTacos(){
		try{
			LectorXML lector=new LectorXML();
			LinkedList<Taco> ligada=lector.readLinkedList("src/BaseDeDatos/TaqueriaSaturno.xml");
			Hashtable<String,Taco> tabla=lector.readHashtable("src/BaseDeDatos/TaqueriaMercurio.xml");
			Taco[] arreglo=lector.readArray("src/BaseDeDatos/TaqueriaVenus.xml");
			ArrayList<Taco> lista=lector.readArrayList("src/BaseDeDatos/TaqueriaMarte.xml");
			ArrayDeque<TacoNormal> queue=lector.readQueue("src/BaseDeDatos/TaqueriaTierra.xml");

			ArrayDeque<Taco> listaAdaptada=new ArrayDeque<>();
			Iterator iterador=queue.iterator();
			while(iterador.hasNext())
				listaAdaptada.add(new TacoNormalAdapter((TacoNormal) iterador.next()));

			saturno=new TaqueriaSaturno(ligada);
			tierra=new TaqueriaTierra(listaAdaptada);
			mercurio=new TaqueriaMercurio(tabla);
			venus=new TaqueriaVenus(arreglo);
			marte=new TaqueriaMarte(lista);
		} catch(Exception e){
			System.out.println("ALGO SALIÓ MAL EN LA LECTURA DE LA BASE");
			return;
		}
	}

	/**
	* Regresa una lista con todos los tacos de la taquería.
	* @return la lista de los tacos en una cadena.
	*/
	public ArrayList<Taco> daListaTacos(){
		Iterator iSaturno=saturno.creaIterador();
		Iterator iTierra=tierra.creaIterador();
		Iterator iMercurio=mercurio.creaIterador();
		Iterator iVenus=venus.creaIterador();
		Iterator iMarte=marte.creaIterador();
		ArrayList<Taco> lista=new ArrayList<>();
                this.daListaTacos(iMercurio, lista);
                this.daListaTacos(iVenus, lista);
                this.daListaTacos(iTierra, lista);
                this.daListaTacos(iMarte, lista);
                this.daListaTacos(iSaturno, lista);
		return lista;
	}

	/**
	* Agrega todos los tacos de la lista de una taquería.
	* @param iterador la lista donde se guardan los tacos de una taquería en una cadena.
        * @param lista la lista donde guardar los tacos de la taquería.
	*/
	private void daListaTacos(Iterator iterador, ArrayList<Taco> lista){
		while(iterador.hasNext())
			lista.add((Taco) iterador.next());
	}

}