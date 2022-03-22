package ec.edu.uce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ec.edu.uce.modelo.Estudiante;
import ec.edu.uce.service.IEstudianteServi;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

	@Autowired
	private IEstudianteServi estudianteServi;
	
	@GetMapping("/buscar/{idEstudiante}")
	public String obtenerUsuario(@PathVariable("idEstudiante") Integer idEstudiante, Model modelo) {
		
		Estudiante estud = this.estudianteServi.buscar(idEstudiante);
//		Estudiante estu = new Estudiante();
//		estu.setNombre("Edisopn");
//		estu.setApellido("Cayambe");
		modelo.addAttribute("estu",estud);
		return "estudiante";
	}
}
