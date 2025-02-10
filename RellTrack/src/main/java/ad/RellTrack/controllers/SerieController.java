package ad.RellTrack.controllers;

import ad.RellTrack.models.Series;
import ad.RellTrack.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<Series> obtenerTodos() {
        return serieService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Series obtenerPorId(@PathVariable Integer id) {
        return serieService.obtenerPorId(id);
    }

    @PostMapping
    public Series guardar(@RequestBody Series serie) {
        return serieService.guardar(serie);
    }

    @PutMapping("/{id}")
    public Series actualizar(@PathVariable Integer id, @RequestBody Series serie) {
        return serieService.guardar(serie);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        serieService.borrarPorId(id);
    }

}
