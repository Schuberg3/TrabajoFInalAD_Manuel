package ad.RellTrack.controllers;

import ad.RellTrack.models.UsuarioCategoria;
import ad.RellTrack.services.UsuarioCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarioscategoria")
public class UsuarioCategoriaController {

    @Autowired
    private UsuarioCategoriaService usuarioCategoriaService;

    @GetMapping
    public List<UsuarioCategoria> obtenerTodos() {
        return usuarioCategoriaService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public UsuarioCategoria obtenerPorId(@PathVariable Integer id) {
        return usuarioCategoriaService.obtenerPorId(id);
    }

    @PostMapping
    public UsuarioCategoria guardar(@RequestBody UsuarioCategoria usuarioCategoria) {
        return usuarioCategoriaService.guardar(usuarioCategoria);
    }

    @PutMapping("/{id}")
    public UsuarioCategoria actualizar(@PathVariable Integer id, @RequestBody UsuarioCategoria usuarioCategoria) {
        return usuarioCategoriaService.guardar(usuarioCategoria);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        usuarioCategoriaService.borrarPorId(id);
    }

}
