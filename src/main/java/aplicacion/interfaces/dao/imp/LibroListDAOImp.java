/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.interfaces.dao.imp;

import aplicacion.interfaces.dao.ILibroDAO;
import aplicacion.modelo.dominio.Libro;
import aplicacion.modelo.util.ListaLibro;
import java.io.Serializable;
import java.util.List;

/**
* @author Cuéllar Malén
* @author Santos Marcelo
 */
public class LibroListDAOImp implements Serializable, ILibroDAO{
    
    private ListaLibro listaLibro;
    
    
    
    
    /**
     * Cosntructor
     */
    public LibroListDAOImp() {
        listaLibro = new ListaLibro();
    }
    
    /**
     * Crea un libro en la lista
     * @param libro 
     */
    @Override
    public void crearLibro(Libro libro) {
        listaLibro.agregarLibro(libro);
       
    }
    
    /**
     * Lista todos los libros de la lista
     * @return 
     */
    @Override
    public List<Libro> obtener() {
        return listaLibro.getLibros();
        
    }

    /**
     * Modifica un libro de la lista
     * @param libro 
     */
    @Override
    public void modificar(Libro libro) {
        listaLibro.modificar(libro);
       
    }

    /**
     * Eliman un libro de la lista
     * @param libro 
     */
    @Override
    public void eliminarLibro(Libro libro) {
        listaLibro.eliminarLibro(libro);
       
    }

    /**
     * Busca un libro pasando por parameto un entero
     * @param a 
     */
    
    @Override
    public void buscarLibro(int a) {
        
        listaLibro.buscarLibro(a);
        
    }

    
    /**
     * Ordena los libros
     */
    @Override
    public void ordenarLibro() {
        listaLibro.ordenarLibro();
     
    }

    
    

    
}
