package ad.RellTrack.services;

import ad.RellTrack.models.Generos;
import ad.RellTrack.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Generos> obtenerTodos() {
        return generoRepository.findAll();
    }

    public Generos obtenerPorId(Integer id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Generos guardar(Generos genero) {
        return generoRepository.save(genero);
    }

    public void borrarPorId(Integer id) {
        generoRepository.deleteById(id);
    }

}
