package ad.RellTrack.controllers;

import ad.RellTrack.models.Contenido;
import ad.RellTrack.services.ContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @GetMapping
    public List<Contenido> obtenerTodos() {
        return contenidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Contenido obtenerPorId(@PathVariable Integer id) {
        return contenidoService.obtenerPorId(id);
    }

    @PostMapping
    public Contenido guardar(@RequestBody Contenido contenido) {
        return contenidoService.guardar(contenido);
    }

    @PutMapping("/{id}")
    public Contenido actualizar(@PathVariable Integer id, @RequestBody Contenido contenido) {
        return contenidoService.guardar(contenido);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        contenidoService.borrarPorId(id);
    }

}
