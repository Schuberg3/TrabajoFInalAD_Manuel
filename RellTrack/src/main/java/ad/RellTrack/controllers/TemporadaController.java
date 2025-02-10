package ad.RellTrack.controllers;

import ad.RellTrack.models.Temporadas;
import ad.RellTrack.services.TemporadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/temporadas")
public class TemporadaController {

    @Autowired
    private TemporadaService temporadaService;

    @GetMapping
    public List<Temporadas> obtenerTodos() {
        return temporadaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Temporadas obtenerPorId(@PathVariable Integer id) {
        return temporadaService.obtenerPorId(id);
    }

    @PostMapping
    public Temporadas guardar(@RequestBody Temporadas temporada) {
        return temporadaService.guardar(temporada);
    }

    @PutMapping("/{id}")
    public Temporadas actualizar(@PathVariable Integer id, @RequestBody Temporadas temporada) {
        return temporadaService.guardar(temporada);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        temporadaService.borrarPorId(id);
    }

}
