package ad.RellTrack.services;

import ad.RellTrack.models.Contenido;
import ad.RellTrack.models.Usuario;
import ad.RellTrack.models.UsuarioContenido;
import ad.RellTrack.models.UsuarioContenidoId;
import ad.RellTrack.repositories.UsuarioContenidoRepository;
import ad.RellTrack.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioContenidoRepository usuarioContenidoRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean existePorUsername(String username) {
        return usuarioRepository.findByUsernameIgnoreCase(username).isPresent();
    }

    public boolean existePorEmail(String email) {
        return usuarioRepository.findByEmailIgnoreCase(email).isPresent();
    }

    public void borrarPorId(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> obtenerPorUsername(String username) {
        return Optional.ofNullable(usuarioRepository.findByUsername(username));
    }

    public Optional<Usuario> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmailIgnoreCase(email);
    }

    public boolean contenidoYaAgregado(Usuario usuario, Contenido contenido) {
        return usuarioContenidoRepository.existsByUserAndContent(usuario, contenido);
    }

    public void agregarContenido(Usuario usuario, Contenido contenido, int rating) {
        UsuarioContenido nuevo = new UsuarioContenido();
        nuevo.setId(new UsuarioContenidoId(usuario.getId(), contenido.getId()));
        nuevo.setUser(usuario);
        nuevo.setContent(contenido);
        nuevo.setRating(rating);

        usuarioContenidoRepository.save(nuevo);
    }


}
