package ad.RellTrack.services;

import ad.RellTrack.models.UsuarioCategoria;
import ad.RellTrack.repositories.UsuarioCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCategoriaService {

    @Autowired
    private UsuarioCategoriaRepository usuarioCategoriaRepository;

    public List<UsuarioCategoria> obtenerTodos() {
        return usuarioCategoriaRepository.findAll();
    }

    public UsuarioCategoria obtenerPorId(Integer id) {
        return usuarioCategoriaRepository.findById(id).orElse(null);
    }

    public UsuarioCategoria guardar(UsuarioCategoria usuarioCategoria) {
        return usuarioCategoriaRepository.save(usuarioCategoria);
    }

    public void borrarPorId(Integer id) {
        usuarioCategoriaRepository.deleteById(id);
    }

}
