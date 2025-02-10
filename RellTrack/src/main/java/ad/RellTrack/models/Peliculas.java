package ad.RellTrack.models;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Contenido content;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Directores director;

    // Constructores
    public Peliculas() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contenido getContent() {
        return content;
    }

    public void setContent(Contenido content) {
        this.content = content;
    }

    public Directores getDirector() {
        return director;
    }

    public void setDirector(Directores director) {
        this.director = director;
    }
}
