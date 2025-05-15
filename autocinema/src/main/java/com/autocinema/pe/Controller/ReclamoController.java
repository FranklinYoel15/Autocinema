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

import com.autocinema.pe.entity.Reclamos;
import com.autocinema.pe.repository.ReclamoRepository;
import com.autocinema.pe.service.ReclamoService;


@Controller
@RequestMapping("/reclamos")
public class ReclamoController {
	@Autowired
    private ReclamoService reclamoService;

 @Autowired
    private ReclamoRepository reclamoRepository;

    // Mostrar lista y formulario
    @GetMapping
    public String listarUsuario(Model model) {
        List<Reclamos> lista = reclamoService.listarReclamo();
        model.addAttribute("listaReclamo", lista);
        model.addAttribute("reclamo", new Reclamos());
        return "reclamos";
    }

    @GetMapping("/buscar")
    public String buscarReclamoPorId(@RequestParam(name = "id", required = false) Long id, Model model) {
        List<Reclamos> reclamo;

        if (id != null) {
            Optional<Reclamos> reclamos = reclamoRepository.findById(id);
            reclamo = reclamos.map(Collections::singletonList).orElse(Collections.emptyList());
        } else {
            reclamo = reclamoRepository.findAll();
        }

        model.addAttribute("reclamo", new Reclamos());
        model.addAttribute("listaReclamo", reclamo);
        return "reclamos";
    }

    // Guardar o actualizar usuario
    @PostMapping("/guardar")
    public String guardarReclamo(@ModelAttribute("reclamos") Reclamos reclamo) {
        reclamoService.crearActualizarReclamo(reclamo);
        return "redirect:/reclamos";
    }

    // Cargar datos en formulario para editar
    @GetMapping("/editar/{id}")
    public String editarReclamo(@PathVariable Long id, Model model) {
        Reclamos reclamo = reclamoService.getIdReclamo(id);
        model.addAttribute("reclamo", reclamo);
        model.addAttribute("listaReclamo", reclamoService.listarReclamo());
        return "reclamos";
    }

    // Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarReclamo(@PathVariable Long id) {
        reclamoService.eliminarReclamo(id);
        return "redirect:/reclamos";
    }

}
