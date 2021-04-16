package taqueriaGalactica;

/**
 *Interfaz que modela un objeto sujeto.
 *@author Karem Ramos Calpulalpan. 314068583
 *@author Emmanuel Cruz Hernández. 314272588
 *@version 1.0 Octubre, 2019.
 */
public interface Sujeto{

    /**
     *Método que obtiene el estado actual del cliente.
     *@param actual el estado actual del cliente.
     */
    public void actualizar(String actual);

    /**
     *Método que elimina la subscripción del cliente.
     */
    public void eliminarSubscripcion();

}
