package ad.RellTrack.controllers;

import ad.RellTrack.models.UsuarioContenido;
import ad.RellTrack.services.UsuarioContenidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarioscategoria")
public class UsuarioContenidoController {

    @Autowired
    private UsuarioContenidoService usuarioContenidoService;

    @GetMapping
    public List<UsuarioContenido> obtenerTodos() {
        return usuarioContenidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public UsuarioContenido obtenerPorId(@PathVariable Integer id) {
        return usuarioContenidoService.obtenerPorId(id);
    }

    @PostMapping
    public UsuarioContenido guardar(@RequestBody UsuarioContenido usuarioContenido) {
        return usuarioContenidoService.guardar(usuarioContenido);
    }

    @PutMapping("/{id}")
    public UsuarioContenido actualizar(@PathVariable Integer id, @RequestBody UsuarioContenido usuarioContenido) {
        return usuarioContenidoService.guardar(usuarioContenido);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        usuarioContenidoService.borrarPorId(id);
    }

}
