package ad.RellTrack.controllers;

import ad.RellTrack.models.Usuario;
import ad.RellTrack.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable Integer id) {
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Usuario> obtenerPorUsername(@PathVariable String nombre) {
        return usuarioService.obtenerPorUsername(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PostMapping
    public Usuario guardar(@RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registrarUsuario(@RequestBody Usuario usuario) {
        // Verificar si el username o email ya están en uso
        if (usuarioService.existePorUsername(usuario.getUsername()) || usuarioService.existePorEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().body("El usuario o email ya existen.");
        }

        // Establecer el tipo de usuario como "user" por defecto
        usuario.setUserType("user");

        // Guardar el usuario en la BD
        usuarioService.guardar(usuario);

        return ResponseEntity.ok("Usuario registrado con éxito.");
    }

    @PutMapping("/{id}")
    public Usuario actualizar(@PathVariable Integer id, @RequestBody Usuario usuario) {
        return usuarioService.guardar(usuario);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id) {
        usuarioService.borrarPorId(id);
    }

}
