package ad.RellTrack.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "seasons")
public class Temporadas {

    @Schema(description = "Valor numérico que representa el ID", example = "5")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(description = "Valor numérico que representa el número de temporada", example = "5")
    private int seasonNumber;

    @ManyToOne
    @JoinColumn(name = "content_id")
    @Schema(description = "Valor numérico que representa el ID del contenido al cual pertenece dicha temporada", example = "5")
    private Contenido content;

    // Constructores
    public Temporadas() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Contenido getContent() {
        return content;
    }

    public void setContent(Contenido content) {
        this.content = content;
    }
}
