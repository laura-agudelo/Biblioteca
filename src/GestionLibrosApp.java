import java.util.List;

public class GestionLibrosApp {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();

        // Crear libros
        libroDAO.crear(new Libro(0, "Cien años de soledad", "Gabriel García Márquez", 1967));
        libroDAO.crear(new Libro(0, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));

        // Leer todos los libros
        List<Libro> libros = libroDAO.leerTodos();
        System.out.println("Libros en la biblioteca:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }

        // Leer un libro específico
        Libro libro = libroDAO.leer(1);
        System.out.println("\nLibro con ID 1: " + libro);

        // Actualizar un libro
        libroDAO.actualizar(new Libro(1, "Cien años de soledad", "Gabriel García Márquez", 1968));
        System.out.println("\nLibro con ID 1 después de la actualización: " + libroDAO.leer(1));

        // Eliminar un libro
        libroDAO.eliminar(2);
        System.out.println("\nLibros después de eliminar el ID 2:");
        libros = libroDAO.leerTodos();
        for (Libro l : libros) {
            System.out.println(l);
        }
    }
}
