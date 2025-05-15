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

import com.autocinema.pe.entity.Sede;
import com.autocinema.pe.repository.SedeRepository;
import com.autocinema.pe.service.SedeService;

@Controller
@RequestMapping("/sedes")

public class SedeController {

	 @Autowired
	    private SedeService sedeService;

	 @Autowired
	    private SedeRepository sedeRepository;

	    @GetMapping
	    public String listarSede(Model model) {
	        List<Sede> listaSede = sedeService.listarSede();
	        model.addAttribute("listaSede", listaSede);
	        model.addAttribute("sede", new Sede());
	        return "sedes";
	    }

	    @GetMapping("/buscar")
	    public String buscarSedePorId(@RequestParam(name = "id", required = false) Long id, Model model) {
	        List<Sede> sede;

	        if (id != null) {
	            Optional<Sede> sedes = sedeRepository.findById(id);
	            sede = sedes.map(Collections::singletonList).orElse(Collections.emptyList());
	        } else {
	            sede = sedeRepository.findAll();
	        }

	        model.addAttribute("sede", new Sede());
	        model.addAttribute("listaSede", sede);
	        return "sedes";
	    }

	    @PostMapping("/guardar")
	    public String guardarSede(@ModelAttribute Sede sede) {
	        sedeService.crearActualizarSede(sede);
	        return "redirect:/sedes";
	    }

	    @GetMapping("/editar/{id}")
	    public String editarSede(@PathVariable Long id, Model model) {
	        Sede sede = sedeService.getIdSede(id);
	        model.addAttribute("sede", sede);
	        model.addAttribute("listaSede", sedeService.listarSede());
	        return "sedes";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminarSede(@PathVariable Long id) {
	        sedeService.eliminarSede(id);
	        return "redirect:/sedes";
	    }
	}
