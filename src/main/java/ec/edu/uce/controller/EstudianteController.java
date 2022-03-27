package ec.edu.uce.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteServi;

@Controller
@RequestMapping("/estudiantes/")
public class EstudianteController {

	@Autowired
	private IEstudianteServi estudianteServi;
	
	@GetMapping("buscar/{idEstudiante}")
//	@RequestMapping(path = "/buscar/{idEstudiante}", method = RequestMethod.GET)
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		
		Estudiante estud = this.estudianteServi.buscar(idEstudiante);
//		Estudiante estu = new Estudiante();
//		estu.setNombre("Edisopn");
//		estu.setApellido("Cayambe");
		modelo.addAttribute("estu",estud);
		return "estudiante";
	}
	
	@GetMapping("todos")
	public String buscarEstudianteTodos(Model modelo) {
		List<Estudiante> listaEstudiantes = this.estudianteServi.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "lista";
	}
	
	@GetMapping("estudianteNuevo")
	public String obtenerPaguinaIngresoDatos(Estudiante estudiante) {
		return "estudianteNuevo";
	}
	
	@PostMapping("insertar")
	public String insertarEstudiante(Estudiante estudiante, BindingResult result, Model modelo, RedirectAttributes redirectAttributes) {
		this.estudianteServi.insertar(estudiante);
//		redirectAttributes.addFlashAttribute(redirectAttributes);
		return "redirect:todos"; // redirecciona a otra paguina
	}
	
	// buscando el estudiante
	@GetMapping("estudianteActualiza/{idEstudiante}")
	public String obtenerPaguinaActualizarDatos(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante, Model modelo) {
		Estudiante estu = this.estudianteServi.buscar(idEstudiante);
		modelo.addAttribute("estu", estu);
		return "estudianteActualiza";
	}
	
	// actualizo el estudiante
	@PutMapping("actualizar/{idEstudiante}")
	public String actualizarEstudiantes(@PathVariable("idEstudiante") Integer idEstudiante, Estudiante estudiante) {
		estudiante.setId(idEstudiante);
		this.estudianteServi.actualizar(estudiante);
		return "index";
	}
	
	@DeleteMapping("borrar/{idEstudiante}")
	public String eliminarEstudiante(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		this.estudianteServi.eliminar(idEstudiante);
		List<Estudiante> listaEstudiantes = this.estudianteServi.buscarTodos();
		modelo.addAttribute("estudiantes", listaEstudiantes);
		return "lista";
	}
}
