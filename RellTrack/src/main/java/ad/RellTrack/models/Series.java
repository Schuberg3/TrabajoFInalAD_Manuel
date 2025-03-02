package ad.RellTrack.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "series")
@PrimaryKeyJoinColumn(name = "id")
public class Series extends Contenido {

    @Schema(description = "Valor numérico que representa el ID", example = "5")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "director_id")
    @Schema(description = "Valor que representa un director", example = "Peter Jackson")
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

