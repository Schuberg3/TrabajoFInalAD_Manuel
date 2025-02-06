package ad.RellTrack.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "content")
public class Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Date releaseDate;
    private String imgUrl;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
    private List<Temporadas> seasons;

    @ManyToMany
    @JoinTable(
            name = "content_genres",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Generos> genres;

    @ManyToMany
    @JoinTable(
            name = "content_actors",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actores> actors;

    // Constructores
    public Contenido() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Temporadas> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Temporadas> seasons) {
        this.seasons = seasons;
    }

    public List<Generos> getGenres() {
        return genres;
    }

    public void setGenres(List<Generos> genres) {
        this.genres = genres;
    }

    public List<Actores> getActors() {
        return actors;
    }

    public void setActors(List<Actores> actors) {
        this.actors = actors;
    }
}
