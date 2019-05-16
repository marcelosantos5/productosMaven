/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.util;

import aplicacion.modelo.dominio.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Cuéllar Malén
 * @author Santos Marcelo
 */
public class ListaLibro implements Serializable{
    private List<Libro> libros;
    private List<Libro> librosOrd;
    private Libro libroaux=new Libro() ;
    
    
    
     /**
     * metodo para modificar un libro
     * @param libro 
     */
    public void modificar (Libro libro){
      for (int i=0; i<libros.size();i++) {
          if (libros.get(i).getCodigo().equals(libro.getCodigo())){
             libros.set(i, libro);
                           
          }
      } 
    }
    

   /**
     * Permite agregar un objeto tipo libro
     * a libro
     * @param libro 
     */
    public void agregarLibro (Libro libro){
        Libro libroAuxiliar = new Libro();
        
        libroAuxiliar.setTitulo(libro.getTitulo());
        libroAuxiliar.setISB(libro.getISB());
        libroAuxiliar.setAutores(libro.getAutores());
        libroAuxiliar.setCantPaginas(libro.getCantPaginas());
        libroAuxiliar.setCodigo(libro.getCodigo());
        libroAuxiliar.setFechaEdicion(libro.getFechaEdicion());
        libroAuxiliar.setTematica(libro.getTematica());
        
        libros.add(libroAuxiliar);
    }
    
    
      /**
     * Permite borrar un objeto tipo libro del Array
     * a libro
     * @param libro 
     */
    public void eliminarLibro (Libro libro){
          for (int i = 0; i <libros.size();i++){
            if(libros.get(i).getISB()== libro.getISB()){
                libros.remove(i);
            }
        }
        
    }
  
     /**
     * ordena los libros de forma creciente
     */
    public void ordenarLibro(){
        libros.sort(Comparator.comparing(Libro::getTitulo));
        libros.forEach(lib -> System.out.println(lib));   
    }
    
    
     /**
     * Busca un libro en el array
     * @param a
     * @return 
     */
    public Libro buscarLibro (int a){
         
        boolean encontrado = false;
        for (int i =0;i < libros.size();i++){
            
            if (libros.get(i).getISB()==a){
                encontrado = true;
                libroaux=libros.get(i);
            }
        }
        if (encontrado == false ){
            libroaux=null;
        }
        return libroaux;
    }
        
    /**
     * constructor
     */
    
    public ListaLibro() {
        libros = new ArrayList<Libro>();
        
    }

    
    /**
     * GETTER Y SETTER
     * @return 
     */
     public Libro getLibroaux() {
        return libroaux;
    }

    public void setLibroaux(Libro libroaux) {
        this.libroaux = libroaux;
    }

    
    public List<Libro> getLibrosOrd() {
        return librosOrd;
    }

    public void setLibrosOrd(List<Libro> librosOrd) {
        this.librosOrd = librosOrd;
    }
    
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    
    
    
}






