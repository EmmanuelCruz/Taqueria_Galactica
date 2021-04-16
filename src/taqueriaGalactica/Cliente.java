package taqueriaGalactica;

/**
 *Clase que modela el cliente de una sucursal.
 *@author Karem Ramos Calpulalpan. 314068583
 *@author Emmanuel Cruz Hernández. 314272588
 *@version 1.0 Octubre, 2019.
 */
public class Cliente implements Sujeto{
    
    /** Número que identidica al cliente. */
    public int id;

    /** Nombre del cliente. */
    public String nombre;

    /** Estado actual del cliente. */
    public String estadoActual;

    /** Tipo de sucursal. */
    public Sucursal sucursal;

    /**
     *Método constructor.
     * @param id el identificador del cliente.
     *@param nombre del cliente.
     *@param tipo de sucursal.
     */
    public Cliente(int id, String nombre, Sucursal sucursal){
    	this.nombre = nombre;
    	this.estadoActual = "";
    	this.sucursal = sucursal;
    	this.id=id;
    }

    @Override
    public void actualizar(String actual){
    	this.estadoActual=actual;
    	System.out.println("Notificación para "+nombre+": "+estadoActual);
    }

    /**
     *Método que muestra el nombre del cliente.
     *@return el nombredel cliente.
     */
    public String obtenerNombre(){
    	return nombre;
    }

    /**
     *Método que muestra el id del cliente.
     *@return el id del cliente.
     */
    public int obtenerId(){
        return id;
    }

    @Override
    public void eliminarSubscripcion(){
    	sucursal=null;
    }

    /**
     *Método que regresa el estado del cliente.
     *@return el estado del cliente.
     */
    public String obtenerEstado(){
    	return estadoActual;
    }

    @Override
    public String toString(){
    	return "ID: "+id+"\tNombre: "+nombre;
    }

}
