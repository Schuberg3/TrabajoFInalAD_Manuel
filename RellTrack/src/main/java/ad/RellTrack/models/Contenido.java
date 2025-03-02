package ad.RellTrack.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "content")
@Inheritance(strategy = InheritanceType.JOINED)
public class Contenido {

    @Schema(description = "Valor numérico que representa el ID", example = "5")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(description = "Valor de texto que represetna el título del contenido", example = "Lo que el viento se llevó")
    private String title;
    @Schema(description = "Valor de fecha que representa la fecha en la que se estrenó dicho contenido", example = "2012-12-02")
    private Date releaseDate;
    @Column(name = "img_url")
    @Schema(description = "Valor de texto que representa el nombre de la imagen de portada del contenido", example = "imagen-01.jpg")
    private String imgUrl;

    @OneToMany(mappedBy = "content", cascade = CascadeType.ALL)
    @Schema(description = "Lista de temporadas que tiene una serie (No implementado)", example = "5")
    private List<Temporadas> seasons;

    @ManyToMany
    @JoinTable(
            name = "content_genres",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @Schema(description = "Lista de géneros de los que vá dicho contenido", example = "['comedia', 'romance', 'accion']")
    private List<Generos> genres;

    @ManyToMany
    @JoinTable(
            name = "content_actors",
            joinColumns = @JoinColumn(name = "content_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    @Schema(description = "Lista de Actores que participan en el contenido", example = "['Tom Holland', 'Dwayn Jonson']")
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
