package taqueriaGalactica;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Clase que modela una sucursal de la Taquería Galáctica en México. 
 * @author Karem Ramos Calpulalpan. 314068583
 * @author Emmanuel Cruz Hernández. 314272588
 * @version 1.0 Octubre, 2019.
 */
public class SucursalMexico implements Sucursal{

    /** Lista de tacos que ofrece la sucursal de México. */
    public ListaTacos lista;

    /** Ganancias de la sucursal México. */
    public double ganancias;

    /** Lista de clientes frecuentes. */
    public ArrayList<Cliente> clientesFrecuentes;

    /** Nombre de la sucursal. */
    public String nombreSucursal;

    /** Estado de la sucursal. */
    public String estado;

    /** Cantidad de id's registrados. */
    public int ids;

    /** Catálogo con los nombres de los tacos disponibles. */
    public String[] catalogo;
    
    /** Lista de tacos elegidos en una orden. */
    public ArrayList<Taco> orden;

    /** Lista de opiniones de los clientes. */
    public ArrayList<String> opiniones;

    /**
     * Método que inicializa la sucursal.
     * @param nombre el nombre de la sucursal.
     */
    public SucursalMexico(String nombre){
    	this.lista = new ListaTacos();
    	this.ganancias = 0.0;
    	try{
    		LectorXML lector=new LectorXML();
    		clientesFrecuentes = lector.readArrayList("src/BaseDeDatos/Clientes.xml",this);
    		ids=lector.readCantidad("src/BaseDeDatos/Clientes.xml");
                opiniones=lector.readComents("src/BaseDeDatos/Comentarios.xml");
    	} catch(Exception e){
    		System.out.println("Error: Algo salió mal con la lectura del la base.");
    	}
    	this.nombreSucursal = nombre;
    	this.estado = "";
        ArrayList<Taco> l=lista.daListaTacos();
        catalogo=new String[l.size()];
        Iterator it=l.iterator();
        int recorredor=0;
        while(it.hasNext()){
            catalogo[recorredor]=((Taco) it.next()).obtenNombre();
            recorredor++;
        }
        orden=new ArrayList<>();
    }

    /**
     * Agrega un nuevo taco a la orden de tacos.
     * @param taco el taco a agregar a la orden.
     */
    public void agregaOrden(Taco taco){
        orden.add(taco);
        ganancias=this.totalPago();
    }
    
    /**
     * Elimina un taco de orden de tacos.
     * @param taco el taco a eliminar de la orden.
     */
    public void eliminaOrden(Taco taco){
        orden.remove(taco);
        ganancias=this.totalPago();
    }

    @Override
    public int registrar(String nombre){
    	ids++;
    	Cliente c=new Cliente(ids, nombre, this);
    	clientesFrecuentes.add(c);
    	try{
            EscritorXML escritor=new EscritorXML();
            escritor.creaDocumento(ids, clientesFrecuentes);
            escritor.genera("src/BaseDeDatos/Clientes.xml");
        } catch(Exception e){
            System.out.println("La base de datos de clientes no se actualizó. Cambios no realizados.");
        }
    	return ids;
    }

    @Override
    public boolean remover(int id){
    	Cliente elim=null;
    	Iterator t=clientesFrecuentes.iterator();
    	while(t.hasNext()){
    		elim=(Cliente)t.next();
    		if(elim.id==id){
    			clientesFrecuentes.remove(elim);
                        try{
                            EscritorXML escritor=new EscritorXML();
                            escritor.creaDocumento(ids, clientesFrecuentes);
                            escritor.genera("src/BaseDeDatos/Clientes.xml");
                        } catch(Exception e){
                            System.out.println("La base de datos de clientes no se actualizó. Cambios no realizados.");
                        }
    			return true; 
    		}
    	}
    	return false;
    }

    /**
    * Verifica si existe el cliente con identificador id.
    * @param id el identificador a buscar.
    * @return true si el elemento existe, false en otro caso.
    */
    public boolean buscar(int id){
        Cliente elim=null;
        Iterator t=clientesFrecuentes.iterator();
        while(t.hasNext()){
            elim=(Cliente)t.next();
            if(elim.id==id){
                return true; 
            }
        }
        return false;
    }
    
    /**
    * Regresa el nombre del cliente con identificador id.
    * @param id el identificador a buscar.
    * @return El nombre del cliente con identificador id.
    */
    public String obtenNombreCliente(int id){
        Cliente elim=null;
        Iterator t=clientesFrecuentes.iterator();
        while(t.hasNext()){
            elim=(Cliente)t.next();
            if(elim.id==id){
                return elim.obtenerNombre(); 
            }
        }
        return "";
    }

    /**
    * Registra una nueva opinión a la lista de comentarios.
    * @param coment el comentario del cliente.
    */
    public void registraComentario(String coment){
        opiniones.add(coment);
        try{
            EscritorXML escritor=new EscritorXML();
            escritor.creaDocumento(opiniones);
            escritor.genera("src/BaseDeDatos/Comentarios.xml");
        } catch(Exception e){
            System.out.println("La base de datos de comentarios no se actualizó. Cambios no realizados.");
        }
    }

    @Override
    public void notificar(){
    	Iterator t=clientesFrecuentes.iterator();
    	Cliente c=null;
    	Random rn=new Random();
    	String nombre="";
    	while(t.hasNext()){
    		int i=rn.nextInt(catalogo.length);
    		c=(Cliente) t.next();
    		c.actualizar("No olvides ir pronto por un taco "+catalogo[i]+" a tu Taquería Galáctica más cercana.");
    	}
    }
    
    public double totalPago(){
        Iterator t=orden.iterator();
        double precio=0;
        Taco taco=null;
        while(t.hasNext()){
            taco=(Taco) t.next();
            precio+=taco.obtenPrecio();
        }
        return precio;
    }
}
