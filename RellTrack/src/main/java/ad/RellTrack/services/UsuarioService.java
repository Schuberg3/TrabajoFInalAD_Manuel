package ad.RellTrack.services;

import ad.RellTrack.models.Usuario;
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
        return usuarioRepository.findByUsernameIgnoreCase(username);
    }

    public Optional<Usuario> obtenerPorEmail(String email) {
        return usuarioRepository.findByEmailIgnoreCase(email);
    }


}
