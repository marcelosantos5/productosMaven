/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cuéllar Malén
 * @author Santos Marcelo
 */
public class Libro implements Serializable {
    private String codigo;
    private int ISB;
    private String titulo;
    private int cantPaginas;
    private String autores;
    private Date fechaEdicion;
    private String tematica;

    
   //GETTERS AND SETTER
    
    public int getISB() {
        return ISB;
    }

    public void setISB(int ISB) {
        this.ISB = ISB;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
       
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCantPaginas() {
        return cantPaginas;
    }

    public void setCantPaginas(int cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public Date getFechaEdicion() {
        return fechaEdicion;
    }

    public void setFechaEdicion(Date fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }
    /**
     * constructores
     * @param codigo
     * @param titulo
     * @param cantPaginas
     * @param autores
     * @param fechaEdicion 
     * @param ISB
     */
    
    //CONSTRUCTORES PARAMETRIZADO
    public Libro(String codigo, int ISB, String titulo, int cantPaginas, String autores, Date fechaEdicion) {
        this.codigo = codigo;
        this.ISB = ISB;
        this.titulo = titulo;
        this.cantPaginas = cantPaginas;
        this.autores = autores;
        this.fechaEdicion = fechaEdicion;
    }

    public Libro(String tematica) {
        this.tematica = tematica;
    }
    
    //CONSTRUCTOR VACIO
    public Libro() {
    }

    
    //METODO TO STRING: asocia al objeto un texo representativo
    @Override
    public String toString() {
        return "Libro{" + "codigo=" + codigo + ", ISB=" + ISB + ", titulo=" + titulo + ", cantPaginas=" + cantPaginas + ", autores=" + autores + ", fechaEdicion=" + fechaEdicion + ", tematica=" + tematica + '}';
    }
 
    
}
