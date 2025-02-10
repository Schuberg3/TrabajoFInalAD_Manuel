package ad.RellTrack.services;

import ad.RellTrack.models.Actores;
import ad.RellTrack.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actores> obtenerTodos() {
        return actorRepository.findAll();
    }

    public Actores obtenerPorId(Integer id) {
        return actorRepository.findById(id).orElse(null);
    }

    public Actores guardar(Actores actore) {
        return actorRepository.save(actore);
    }

    public void borrarPorId(Integer id) {
        actorRepository.deleteById(id);
    }

}
