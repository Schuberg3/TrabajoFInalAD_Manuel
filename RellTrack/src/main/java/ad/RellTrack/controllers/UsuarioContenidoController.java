package ad.RellTrack.controllers;

import ad.RellTrack.models.Contenido;
import ad.RellTrack.models.Usuario;
import ad.RellTrack.models.UsuarioContenido;
import ad.RellTrack.services.UsuarioContenidoService;
import ad.RellTrack.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/uContenido")
public class UsuarioContenidoController {

    @Autowired
    private UsuarioContenidoService usuarioContenidoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioContenido> obtenerTodos() {
        return usuarioContenidoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public UsuarioContenido obtenerPorId(@PathVariable Integer id) {
        return usuarioContenidoService.obtenerPorId(id);
    }

    @GetMapping("/catalogo/{username}")
    public ResponseEntity<List<Map<String, Object>>> obtenerCatalogoUsuario(@PathVariable String username) {
        Optional<Usuario> usuario = usuarioService.obtenerPorUsername(username);

        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        List<UsuarioContenido> userCatalog = usuarioContenidoService.obtenerPorUsuario(usuario.get());

        // Convertimos `userCatalog` en una lista de Map para incluir rating + contenido
        List<Map<String, Object>> catalogoCompleto = userCatalog.stream().map(item -> {
            Map<String, Object> data = new HashMap<>();
            data.put("rating", item.getRating());
            data.put("content", item.getContent());
            return data;
        }).collect(Collectors.toList());

        return ResponseEntity.ok(catalogoCompleto);
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
