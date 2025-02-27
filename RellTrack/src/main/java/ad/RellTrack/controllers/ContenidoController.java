package ad.RellTrack.controllers;

import ad.RellTrack.models.*;
import ad.RellTrack.models.dto.AgregarContenido;
import ad.RellTrack.services.ContenidoService;
import ad.RellTrack.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/contenido")
public class ContenidoController {

    @Autowired
    private ContenidoService contenidoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Contenido> obtenerTodos() {
        return contenidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Contenido obtenerPorId(@PathVariable Integer id) {
        return contenidoService.obtenerPorId(id);
    }

    @GetMapping("/animes")
    public List<Animes> obtenerAnimes() {
        return contenidoService.obtenerAnimes();
    }

    @GetMapping("/series")
    public List<Series> obtenerSeries() {
        return contenidoService.obtenerSeries();
    }

    @GetMapping("/peliculas")
    public List<Peliculas> obtenerPeliculas() {
        return contenidoService.obtenerPeliculas();
    }

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarContenido(@RequestBody AgregarContenido request) {
        Optional<Usuario> usuarioOpt = usuarioService.obtenerPorUsername(request.getUsername());

        if (usuarioOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuario no encontrado.");
        }

        Usuario usuario = usuarioOpt.get();
        Contenido contenido = contenidoService.obtenerPorId(Math.toIntExact(request.getContentId()));

        if (contenido == null) {
            return ResponseEntity.badRequest().body("Contenido no encontrado.");
        }

        if (usuarioService.contenidoYaAgregado(usuario, contenido)) {
            return ResponseEntity.badRequest().body("Este contenido ya está en tu catálogo.");
        }

        usuarioService.agregarContenido(usuario, contenido, request.getRating());
        return ResponseEntity.ok("Contenido agregado con éxito.");
    }

    @PostMapping("/guardar")
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
