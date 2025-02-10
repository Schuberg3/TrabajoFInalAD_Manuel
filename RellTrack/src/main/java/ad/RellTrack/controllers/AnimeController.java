package ad.RellTrack.controllers;

import ad.RellTrack.models.Animes;
import ad.RellTrack.services.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping
    public List<Animes> obtenerTodos() {
        return animeService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Animes obtenerPorId(@PathVariable Integer id) {
        return animeService.obtenerPorId(id);
    }

    @PostMapping
    public Animes guardar(@RequestBody Animes anime) {
        return animeService.guardar(anime);
    }

    @PutMapping("/{id}")
    public Animes actualizar(@PathVariable Integer id, @RequestBody Animes anime) {
        return animeService.guardar(anime);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        animeService.borrarPorId(id);
    }

}
