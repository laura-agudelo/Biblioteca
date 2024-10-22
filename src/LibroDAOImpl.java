import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private List<Libro> libros = new ArrayList<>();
    private int idCounter = 1; // Para generar IDs automáticamente

    @Override
    public void crear(Libro libro) {
        libro = new Libro(idCounter++, libro.getTitulo(), libro.getAutor(), libro.getAnioPublicacion());
        libros.add(libro);
    }

    @Override
    public Libro leer(int id) {
        return libros.stream().filter(libro -> libro.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Libro> leerTodos() {
        return new ArrayList<>(libros);
    }

    @Override
    public void actualizar(Libro libroActualizado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libroActualizado.getId()) {
                libros.set(i, libroActualizado);
                return;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        libros.removeIf(libro -> libro.getId() == id);
    }
}
