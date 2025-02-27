package ad.RellTrack.services;

import ad.RellTrack.models.Animes;
import ad.RellTrack.models.Contenido;
import ad.RellTrack.models.Peliculas;
import ad.RellTrack.models.Series;
import ad.RellTrack.repositories.AnimeRepository;
import ad.RellTrack.repositories.ContenidoRepository;
import ad.RellTrack.repositories.PeliculaRepository;
import ad.RellTrack.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    // Obtener TODOS los contenidos (general)
    public List<Contenido> obtenerTodos() {
        return contenidoRepository.findAll();
    }

    // Obtener por ID detectando el tipo de contenido
    public Contenido obtenerPorId(Integer id) {
        Optional<Animes> anime = animeRepository.findById(id);
        if (anime.isPresent()) return anime.get();

        Optional<Series> serie = serieRepository.findById(id);
        if (serie.isPresent()) return serie.get();

        Optional<Peliculas> pelicula = peliculaRepository.findById(id);
        return pelicula.orElse(null);
    }

    // Guardar contenido según su tipo
    public Contenido guardar(Contenido contenido) {
        if (contenido instanceof Animes) {
            return animeRepository.save((Animes) contenido);
        } else if (contenido instanceof Series) {
            return serieRepository.save((Series) contenido);
        } else if (contenido instanceof Peliculas) {
            return peliculaRepository.save((Peliculas) contenido);
        }
        return contenidoRepository.save(contenido);
    }

    // Actualizar contenido según su tipo
    public void actualizarContenido(Contenido contenido) {
        if (contenido instanceof Animes) {
            animeRepository.save((Animes) contenido);
        } else if (contenido instanceof Series) {
            serieRepository.save((Series) contenido);
        } else if (contenido instanceof Peliculas) {
            peliculaRepository.save((Peliculas) contenido);
        } else {
            contenidoRepository.save(contenido);
        }
    }

    // Eliminar contenido según su tipo
    public void borrarPorId(Integer id) {
        if (animeRepository.existsById(id)) {
            animeRepository.deleteById(id);
        } else if (serieRepository.existsById(id)) {
            serieRepository.deleteById(id);
        } else if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
        } else {
            contenidoRepository.deleteById(id);
        }
    }

    // Obtener cada tipo de contenido por separado
    public List<Animes> obtenerAnimes() {
        return animeRepository.findAll();
    }

    public List<Series> obtenerSeries() {
        return serieRepository.findAll();
    }

    public List<Peliculas> obtenerPeliculas() {
        return peliculaRepository.findAll();
    }
}
