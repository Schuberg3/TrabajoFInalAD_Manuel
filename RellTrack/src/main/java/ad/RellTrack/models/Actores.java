package ad.RellTrack.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "actors")
public class Actores {

    @Schema(description = "Valor numérico que representa el ID", example = "5")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(description = "Valor de texto que representa el nombre del actor", example = "Tom Hollan")
    private String name;

    // Constructores
    public Actores() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
