package ad.RellTrack.services;

import ad.RellTrack.models.Animes;
import ad.RellTrack.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    public List<Animes> obtenerTodos() {
        return animeRepository.findAll();
    }

    public Animes obtenerPorId(Integer id) {
        return animeRepository.findById(id).orElse(null);
    }

    public Animes guardar(Animes anime) {
        return animeRepository.save(anime);
    }

    public void borrarPorId(Integer id) {
        animeRepository.deleteById(id);
    }

}
