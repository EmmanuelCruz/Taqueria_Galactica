package taqueriaGalactica;

/**
 * Interfaz que modela una sucursal donde el cliente se puede registar, 
 * remover y se le es notificado.
 * @author Karem Ramos Calpulalpan. 314068583.
 * @author Emmanuel Cruz Hernández. 314272588.
 * @version 1.0 Octubre, 2019.
 */
public interface Sucursal{
    
    /**
    * Método que registra al cliente en la sucursal.
    * @param nombre el nombre del cliente que se va a registrar.
    * @return regresa el identificador con el que fue registrado el cliente.
    */
    public int registrar(String nombre);
    
    /**
    * Método que remueve el cliente de la sucursal.
    * @param id el identificador del cliente a remover.
    * @return true si se elimino, false en otro caso.
    */
    public boolean remover(int id);
    
    /**
    * Método que notifica a los clientes.
    */
    public void notificar();
    
}
