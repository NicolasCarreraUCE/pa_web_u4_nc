package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Estudiante;

public interface IEstudianteServi {
	Estudiante buscar(Integer id);
	List<Estudiante> buscarTodos();
	void insertar(Estudiante estudiante);
	void actualizar(Estudiante estudiante);
	void eliminar(Integer id);
}
