package ad.RellTrack.services;

import ad.RellTrack.models.Temporadas;
import ad.RellTrack.repositories.TemporadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemporadaService {

    @Autowired
    private TemporadaRepository temporadaRepository;

    public List<Temporadas> obtenerTodos() {
        return temporadaRepository.findAll();
    }

    public Temporadas obtenerPorId(Integer id) {
        return temporadaRepository.findById(id).orElse(null);
    }

    public Temporadas guardar(Temporadas temporada) {
        return temporadaRepository.save(temporada);
    }

    public void borrarPorId(Integer id) {
        temporadaRepository.deleteById(id);
    }

}
