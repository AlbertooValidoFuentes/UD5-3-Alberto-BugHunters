import com.digitalcastaway.biblioteca.Biblioteca;
import com.digitalcastaway.biblioteca.Persona;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblio = new Biblioteca("Alejandría");

        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la biblioteca de Alejandría");
        System.out.println("Introduzca su nombre");
        String username = sc.nextLine();

        Persona usuario = new Persona(username);

        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción");
            System.out.println("1. Ver catálogo");
            System.out.println("2. Tomar prestado un libro concreto");
            System.out.println("3. Tomar prestado un libro aleatorio");
            System.out.println("4. Ver libros que tiene prestados");
            System.out.println("5. Devolver un libro");
            System.out.println("Q. Salir");

            String opcion = sc.nextLine();



            switch(opcion) {
                case "1":
                    biblio.showCatalog();
                    break;
                case"2":
                    System.out.println("Seleccione uno de los libros");
                    biblio.showCatalog();
                    int posicion = sc.nextInt();
                    usuario.obtenerLibro(posicion, biblio);
                    break;
                case "3":
                    System.out.println("Obteniendo libro aleatorio");
                    String titulo = usuario.obtenerLibroAleatorio(biblio);

                    System.out.println("Ha obtenido el título: " + titulo);
                    break;
                case "4":
                    System.out.println(usuario);
                    break;
                case"5":
                    System.out.println("Introduzca el título del libro que quiere devolver");
                    System.out.println(usuario);
                    int libroParaDevolver = sc.nextInt();
                    String tituloLibro = usuario.obtenerTituloLibro(libroParaDevolver);
                    usuario.devolverLibro(tituloLibro, biblio);
                    break;
                case "Q":
                    salir = true;
            }
        }
    }
}
