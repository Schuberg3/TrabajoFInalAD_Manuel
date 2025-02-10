package ad.RellTrack.controllers;

import ad.RellTrack.models.Generos;
import ad.RellTrack.services.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Generos> obtenerTodos() {
        return generoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Generos obtenerPorId(@PathVariable Integer id) {
        return generoService.obtenerPorId(id);
    }

    @PostMapping
    public Generos guardar(@RequestBody Generos genero) {
        return generoService.guardar(genero);
    }

    @PutMapping("/{id}")
    public Generos actualizar(@PathVariable Integer id, @RequestBody Generos genero) {
        return generoService.guardar(genero);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        generoService.borrarPorId(id);
    }

}
