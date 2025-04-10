package cafe.Datos;

import java.util.List;

import cafe.Dominio.Cafe;


public interface IClienteDAO {
     List<Cafe> listarProductos();
    boolean buscarCafePorId(Cafe cafe);
    boolean agregarCafe(Cafe cafe);
    boolean modificarCafe(Cafe cafe);
    boolean eliminarCafe(Cafe cafe);
    
}
