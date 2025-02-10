package ad.RellTrack.controllers;

import ad.RellTrack.models.Peliculas;
import ad.RellTrack.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Peliculas> obtenerTodos() {
        return peliculaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Peliculas obtenerPorId(@PathVariable Integer id) {
        return peliculaService.obtenerPorId(id);
    }

    @PostMapping
    public Peliculas guardar(@RequestBody Peliculas pelicula) {
        return peliculaService.guardar(pelicula);
    }

    @PutMapping("/{id}")
    public Peliculas actualizar(@PathVariable Integer id, @RequestBody Peliculas pelicula) {
        return peliculaService.guardar(pelicula);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        peliculaService.borrarPorId(id);
    }

}
