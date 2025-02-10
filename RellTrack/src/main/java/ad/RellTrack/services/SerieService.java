package ad.RellTrack.services;

import ad.RellTrack.models.Series;
import ad.RellTrack.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Series> obtenerTodos() {
        return serieRepository.findAll();
    }

    public Series obtenerPorId(Integer id) {
        return serieRepository.findById(id).orElse(null);
    }

    public Series guardar(Series serie) {
        return serieRepository.save(serie);
    }

    public void borrarPorId(Integer id) {
        serieRepository.deleteById(id);
    }

}
