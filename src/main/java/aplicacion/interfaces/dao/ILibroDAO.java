/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.interfaces.dao;

import aplicacion.modelo.dominio.Libro;
import java.util.List;

/**
 *
 * @author Cuéllar Malén
 * @author Santos Marcelo
 */
public interface ILibroDAO {
   
    //metodos abstractos de la interfaz
    void crearLibro (Libro libro);
    List <Libro>obtener();
    void modificar (Libro libro);
    void eliminarLibro (Libro libro);
    void buscarLibro (int a);
    void ordenarLibro();
}
