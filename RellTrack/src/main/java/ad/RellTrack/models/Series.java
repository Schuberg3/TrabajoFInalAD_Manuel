package ad.RellTrack.models;

import jakarta.persistence.*;

@Entity
@Table(name = "series")
@PrimaryKeyJoinColumn(name = "id")
public class Series extends Contenido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Directores director;

    // Constructores
    public Series() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Directores getDirector() {
        return director;
    }

    public void setDirector(Directores director) {
        this.director = director;
    }
}

