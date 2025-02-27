package ad.RellTrack.controllers;

import ad.RellTrack.models.Animes;
import ad.RellTrack.models.Contenido;
import ad.RellTrack.models.Peliculas;
import ad.RellTrack.models.Series;
import ad.RellTrack.services.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/contenido")
public class AdminContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public String mostrarPanelAdministracion(Model model) {
        model.addAttribute("animes", contenidoService.obtenerAnimes());
        model.addAttribute("series", contenidoService.obtenerSeries());
        model.addAttribute("peliculas", contenidoService.obtenerPeliculas());
        return "admin";
    }

    @PostMapping("/agregar/anime")
    public String agregarAnime(@ModelAttribute Animes anime) {
        contenidoService.guardar(anime);
        return "redirect:/admin/contenido";
    }

    @PostMapping("/agregar/serie")
    public String agregarSerie(@ModelAttribute Series serie) {
        contenidoService.guardar(serie);
        return "redirect:/admin/contenido";
    }

    @PostMapping("/agregar/pelicula")
    public String agregarPelicula(@ModelAttribute Peliculas pelicula) {
        contenidoService.guardar(pelicula);
        return "redirect:/admin/contenido";
    }

    @GetMapping("/editar/{id}")
    public String editarContenido(@PathVariable Integer id, Model model) {
        model.addAttribute("contenido", contenidoService.obtenerPorId(id));
        return "editar_contenido";
    }

    @PostMapping("/editar")
    public String actualizarContenido(@ModelAttribute Contenido contenido) {
        contenidoService.actualizarContenido(contenido);
        return "redirect:/admin/contenido";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarContenido(@PathVariable Integer id, Model model) {
        model.addAttribute("contenido", contenidoService.obtenerPorId(id));
        return "confirmar_eliminar";
    }

    @PostMapping("/eliminar")
    public String confirmarEliminarContenido(@RequestParam("id") Integer id) {
        contenidoService.borrarPorId(id);
        return "redirect:/admin/contenido";
    }
}

