package ad.RellTrack.services;

import ad.RellTrack.models.Directores;
import ad.RellTrack.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    public List<Directores> obtenerTodos() {
        return directorRepository.findAll();
    }

    public Directores obtenerPorId(Integer id) {
        return directorRepository.findById(id).orElse(null);
    }

    public Directores guardar(Directores director) {
        return directorRepository.save(director);
    }

    public void borrarPorId(Integer id) {
        directorRepository.deleteById(id);
    }

}
