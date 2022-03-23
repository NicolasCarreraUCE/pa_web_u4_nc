package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteServi;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteServi estudianteServi;
	
	@GetMapping("/buscar/{idEstudiante}")
//	@RequestMapping(path = "/buscar/{idEstudiante}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		
		Estudiante estud = this.estudianteServi.buscar(idEstudiante);
//		Estudiante estu = new Estudiante();
//		estu.setNombre("Edisopn");
//		estu.setApellido("Cayambe");
		modelo.addAttribute("estu",estud);
		return "estudiante";
	}
	
	@GetMapping("/buscar/todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiantes = this.estudianteServi.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "lista";
	}
	
	@GetMapping("/estudianteNuevo")
	public String obtenerPaguinaIngresoDatos() {
		return "estudianteNuevo";
	}
	
	@PostMapping("/insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo) {
		this.estudianteServi.insertar(estudiante);
		return "lista";
	}
}
