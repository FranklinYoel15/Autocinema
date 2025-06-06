package com.autocinema.pe.Controller;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.autocinema.pe.entity.Funciones;
import com.autocinema.pe.repository.FuncionesRepository;
import com.autocinema.pe.service.FuncionesService;
import com.autocinema.pe.service.PeliculaService;
import com.autocinema.pe.service.SalaService;

@Controller
@RequestMapping("/funciones")

public class FuncionesController {

	 @Autowired
	    private FuncionesService funcionesService;

	    @Autowired
	    private PeliculaService peliculaService;

	    @Autowired
	    private SalaService salaService;
	    @Autowired
	    private FuncionesRepository funcionesRepository;

	    @GetMapping
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("funciones", new Funciones());
	        model.addAttribute("listaPelicula", peliculaService.listarPelicula());
	        model.addAttribute("listaSala", salaService.listarSala());
	        return "funciones";
	    }


	    @GetMapping("/buscar")
	    public String buscarFuncionesPorId(@RequestParam(name = "id", required = false) Long id,
	                                    Model model) {
	        List<Funciones> funciones;

	        if (id != null) {
	            Optional<Funciones> funcion = funcionesRepository.findById(id);
	            funciones = funcion.map(Collections::singletonList).orElse(Collections.emptyList());
	        } else {
	            funciones = funcionesRepository.findAll();
	        }

	        model.addAttribute("funciones", new Funciones());
	        model.addAttribute("listaFunciones", funciones);
	        model.addAttribute("listaPelicula", peliculaService.listarPelicula());
	        model.addAttribute("listaSala", salaService.listarSala());
	        return "funciones";
	    }

	    @PostMapping("/guardar")
	    public String guardarFunciones(@ModelAttribute Funciones funciones) {
	        funcionesService.crearActualizarFunciones(funciones);
	        return "redirect:/funciones";
	    }

	    @GetMapping("/editar/{id}")
	    public String editarFunciones(@PathVariable Long id, Model model) {
	        model.addAttribute("funciones", funcionesService.getIdFunciones(id));
	        model.addAttribute("listaFunciones", funcionesService.listarFunciones());
	        model.addAttribute("listaPelicula", peliculaService.listarPelicula());
	        model.addAttribute("listaSala", salaService.listarSala());
	        return "funciones";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminarFunciones(@PathVariable Long id) {
	        funcionesService.eliminarFunciones(id);
	        return "redirect:/funciones";
	    }
	}