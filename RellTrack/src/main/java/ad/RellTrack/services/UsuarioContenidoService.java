package ad.RellTrack.services;

import ad.RellTrack.models.Contenido;
import ad.RellTrack.models.Usuario;
import ad.RellTrack.models.UsuarioContenido;
import ad.RellTrack.repositories.UsuarioContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioContenidoService {

    @Autowired
    private UsuarioContenidoRepository usuarioContenidoRepository;

    public List<UsuarioContenido> obtenerTodos() {
        return usuarioContenidoRepository.findAll();
    }

    public UsuarioContenido obtenerPorId(Integer id) {
        return usuarioContenidoRepository.findById(id).orElse(null);
    }

    public UsuarioContenido guardar(UsuarioContenido usuarioContenido) {
        return usuarioContenidoRepository.save(usuarioContenido);
    }

    public void borrarPorId(Integer id) {
        usuarioContenidoRepository.deleteById(id);
    }

    public List<Contenido> obtenerPorUsuario(Usuario usuario) {
        return usuarioContenidoRepository.findByUser(usuario)
                .stream()
                .map(UsuarioContenido::getContent)
                .collect(Collectors.toList());
    }

}
