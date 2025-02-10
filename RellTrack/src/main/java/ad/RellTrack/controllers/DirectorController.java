package ad.RellTrack.controllers;

import ad.RellTrack.models.Directores;
import ad.RellTrack.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/directores")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Directores> obtenerTodos() {
        return directorService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Directores obtenerPorId(@PathVariable Integer id) {
        return directorService.obtenerPorId(id);
    }

    @PostMapping
    public Directores guardar(@RequestBody Directores director) {
        return directorService.guardar(director);
    }

    @PutMapping("/{id}")
    public Directores actualizar(@PathVariable Integer id, @RequestBody Directores director) {
        return directorService.guardar(director);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        directorService.borrarPorId(id);
    }

}
