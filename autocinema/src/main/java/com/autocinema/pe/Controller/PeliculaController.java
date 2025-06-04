package com.autocinema.pe.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.autocinema.pe.entity.Categoria;
import com.autocinema.pe.entity.Pelicula;
import com.autocinema.pe.repository.CategoriaRepository;
import com.autocinema.pe.repository.PeliculaRepository;





@Controller
@RequestMapping("/peliculas")
public class PeliculaController {

	 @Autowired
	    private PeliculaRepository peliculaRepository;

	    @Autowired
	    private CategoriaRepository categoriaRepository;

	    @GetMapping
	    public String listarPeliculas(Model model) {
	        model.addAttribute("peliculas", peliculaRepository.findAll());
	        return "peliculas";
	    }

	    @GetMapping("/nuevo")
	    public String mostrarFormulario(Model model) {
	        model.addAttribute("pelicula", new Pelicula());
	        model.addAttribute("categorias", categoriaRepository.findAll());
	        return "registro";
	    }

	    @PostMapping("/guardar")
	    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {

	        String nombreCategoria = pelicula.getCategoria();
	        Categoria categoria = categoriaRepository.findByNombre(nombreCategoria);

	        pelicula.setCategoria(categoria.getNombre());
	        peliculaRepository.save(pelicula);

	        return "redirect:/peliculas";
	    }


	    @GetMapping("/editar/{id}")
	    public String editar(@PathVariable Long id, Model model) {
	        model.addAttribute("pelicula", peliculaRepository.findById(id).orElse(null));
	        model.addAttribute("categorias", categoriaRepository.findAll());
	        return "registro";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminar(@PathVariable Long id) {
	        peliculaRepository.deleteById(id);
	        return "redirect:/peliculas";
	    }
	}