package com.digitalcastaway.biblioteca;

import java.util.ArrayList;

public class Persona extends Usuario {
    private String nombre;
    private ArrayList<String> librosPrestados;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.librosPrestados = new ArrayList<String>();
    }

    @Override
    public void obtenerLibro(int posicion, Biblioteca biblioteca) {
        librosPrestados.add(biblioteca.prestarLibro(posicion));
    }

    @Override
    public String obtenerLibroAleatorio(Biblioteca biblioteca) {
        librosPrestados.add(biblioteca.prestarLibroAleatorio());
        return biblioteca.prestarLibroAleatorio();
    }

    @Override
    public void devolverLibro(String titulo, Biblioteca biblioteca) {
        biblioteca.devolverLibro(titulo);

        int posicion = librosPrestados.indexOf(titulo);

        biblioteca.devolverLibro(librosPrestados.remove(posicion));
    }

    public String obtenerTituloLibro(int posicion) {
        return librosPrestados.get(posicion);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Nombre='" + nombre + '\'' +
                " tiene los siguientes libros de la biblioteca: \n");

        int contador = 0;
        for ( String titulo: librosPrestados) {
            output.append(contador).append(" --> ").append(titulo).append("\n");
            contador ++;

        }
        return output.toString();
    }
}
