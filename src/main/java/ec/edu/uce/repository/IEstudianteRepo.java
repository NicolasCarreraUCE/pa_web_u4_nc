package ec.edu.uce.repository;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;

public interface IEstudianteRepo {
	Estudiante buscar(Integer id);
	List<Estudiante> buscarTodos();
	void insertar(Estudiante estudiante);
	void actualizar(Estudiante estudiante);
	void eliminar(Integer id);
}
