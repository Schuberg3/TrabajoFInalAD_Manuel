package ad.RellTrack.services;

import ad.RellTrack.models.Peliculas;
import ad.RellTrack.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Peliculas> obtenerTodos() {
        return peliculaRepository.findAll();
    }

    public Peliculas obtenerPorId(Integer id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Peliculas guardar(Peliculas pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void borrarPorId(Integer id) {
        peliculaRepository.deleteById(id);
    }

}
