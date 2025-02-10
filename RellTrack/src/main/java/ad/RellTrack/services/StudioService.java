package ad.RellTrack.services;

import ad.RellTrack.models.Actores;
import ad.RellTrack.models.Studios;
import ad.RellTrack.repositories.ActorRepository;
import ad.RellTrack.repositories.StudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    public List<Studios> obtenerTodos() {
        return studioRepository.findAll();
    }

    public Studios obtenerPorId(Integer id) {
        return studioRepository.findById(id).orElse(null);
    }

    public Studios guardar(Studios studio) {
        return studioRepository.save(studio);
    }

    public void borrarPorId(Integer id) {
        studioRepository.deleteById(id);
    }

}
