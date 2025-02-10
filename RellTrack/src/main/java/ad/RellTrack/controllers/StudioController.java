package ad.RellTrack.controllers;

import ad.RellTrack.models.Studios;
import ad.RellTrack.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/studios")
public class StudioController {

    @Autowired
    private StudioService studioService;

    @GetMapping
    public List<Studios> obtenerTodos() {
        return studioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Studios obtenerPorId(@PathVariable Integer id) {
        return studioService.obtenerPorId(id);
    }

    @PostMapping
    public Studios guardar(@RequestBody Studios studio) {
        return studioService.guardar(studio);
    }

    @PutMapping("/{id}")
    public Studios actualizar(@PathVariable Integer id, @RequestBody Studios studio) {
        return studioService.guardar(studio);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        studioService.borrarPorId(id);
    }

}
