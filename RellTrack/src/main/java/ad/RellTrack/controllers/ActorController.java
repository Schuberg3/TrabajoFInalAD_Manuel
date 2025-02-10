package ad.RellTrack.controllers;

import ad.RellTrack.models.Actores;
import ad.RellTrack.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public List<Actores> obtenerTodos() {
        return actorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Actores obtenerPorId(@PathVariable Integer id) {
        return actorService.obtenerPorId(id);
    }

    @PostMapping
    public Actores guardar(@RequestBody Actores actor) {
        return actorService.guardar(actor);
    }

    @PutMapping("/{id}")
    public Actores actualizar(@PathVariable Integer id, @RequestBody Actores actor) {
        return actorService.guardar(actor);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        actorService.borrarPorId(id);
    }

}
