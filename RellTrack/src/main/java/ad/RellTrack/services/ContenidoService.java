package ad.RellTrack.services;

import ad.RellTrack.models.Contenido;
import ad.RellTrack.repositories.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> obtenerTodos() {
        return contenidoRepository.findAll();
    }

    public Contenido obtenerPorId(Integer id) {
        return contenidoRepository.findById(id).orElse(null);
    }

    public Contenido guardar(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public void borrarPorId(Integer id) {
        contenidoRepository.deleteById(id);
    }

}
