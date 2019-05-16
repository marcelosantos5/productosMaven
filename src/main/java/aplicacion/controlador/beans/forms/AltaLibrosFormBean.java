/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.interfaces.dao.ILibroDAO;
import aplicacion.interfaces.dao.imp.LibroListDAOImp;
import aplicacion.modelo.dominio.Libro;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Cuéllar Malén
 * @author Santos Marcelo
 */
@ManagedBean
@SessionScoped
public class AltaLibrosFormBean implements Serializable {

    private Libro libro;
    private List<Libro> libros;
    private ILibroDAO libroDAO;

    private int a;
    private List<Libro> listalibrosBuscados;
    boolean bandera = false;

    //actualiza y resetea lo filtos de la Tabla
    private void resetearFitrosTabla(String id) {
        DataTable table = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(id);
        table.reset();
    }

    //mensaje personalizado: aviso de que el libro fue modificado
    public void onRowEdit(RowEditEvent event) {
        Libro libromodificado = (Libro) event.getObject();
        libroDAO.modificar(libromodificado);
        FacesMessage msg = new FacesMessage("Exito", "Libro Modificado!!!!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        resetearFitrosTabla("frmAltaLibro:tblLibros");
    }

    //METODO BEAN QUE VALIDA EL LIBRO POR CODIGO Y GUARDA UN LIBRO EN LA LISTA 
    public void guardarLibro() {
        if (libroDAO.obtener().isEmpty()) {
            libroDAO.crearLibro(libro);
            System.out.println(libroDAO.obtener().get(0).toString());
            libros = libroDAO.obtener();
            resetearFitrosTabla("frmAltaLibro:tblLibros");
        } else {
            String codigo = libro.getCodigo();
            int isb = libro.getISB();
            
            
            for (Libro l : libros) {
                if (l.getCodigo().equals(codigo)|| l.getISB() == isb) {
                    bandera = true;
                    break;
                }
            }

                if (bandera == false) {
                    libroDAO.crearLibro(libro);
                    libros = libroDAO.obtener();
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "El libro se gurdó correctamente.", null));
                    resetearFitrosTabla("frmAltaLibro:tblLibros");
                } else {
                    bandera = false;
                    FacesContext context = FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El Código o ISBN del libro ya existe, por favor ingrese otro o búsquelo en la lista de libros.", null));
                    resetearFitrosTabla("frmAltaLibro:tblLibros");
                }
            }

        }
        //METODO BEAN QUE ELIMINA UN LIBRO DE LISTA
    public void eliminarLibro(Libro libro) {
        libroDAO.eliminarLibro(libro);
        System.out.println(libroDAO.obtener().get(0).toString());
        libros = libroDAO.obtener();
        resetearFitrosTabla("frmAltaLibro:tblLibros");
    }

    public void modificarLibro(Libro libro) {
        libroDAO.modificar(libro);
        System.out.println(libroDAO.obtener().get(0).toString());
        libros = libroDAO.obtener();
    }

    /**
     * cosntructor
     */
    public AltaLibrosFormBean() {
        libro = new Libro();
        libros = new ArrayList<>();
        libroDAO = new LibroListDAOImp();
    }

    /**
     * CONSTRUCTOR PARAMETRIZADO
     *
     * @param libro
     * @param libros
     * @param libroDAO
     * @param a
     */
    public AltaLibrosFormBean(Libro libro, List<Libro> libros, ILibroDAO libroDAO, int a, List<Libro> listalibrosBuscados) {
        this.libro = libro;
        this.libros = libros;
        this.libroDAO = libroDAO;
        this.a = a;
        this.listalibrosBuscados = listalibrosBuscados;
    }

    /**
     * GETTER Y SETTER
     *
     * @return
     */
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public ILibroDAO getLibroDAO() {
        return libroDAO;
    }

    public void setLibroDAO(ILibroDAO libroDAO) {
        this.libroDAO = libroDAO;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public List<Libro> getListalibrosBuscados() {
        return listalibrosBuscados;
    }

    public void setListalibrosBuscados(List<Libro> listalibrosBuscados) {
        this.listalibrosBuscados = listalibrosBuscados;
    }

}
