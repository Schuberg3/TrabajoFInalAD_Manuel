package ad.RellTrack.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "animes")
@PrimaryKeyJoinColumn(name = "id")
public class Animes extends Contenido {

    @Schema(description = "Valor numérico que representa el ID", example = "5")
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    @Schema(description = "Valor de texto que representa el estudio donde se ha animado dicho anime", example = "MAPPA")
    private Studios studio;

    // Constructores
    public Animes() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Studios getStudio() {
        return studio;
    }

    public void setStudio(Studios studio) {
        this.studio = studio;
    }
}
