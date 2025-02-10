package ad.RellTrack.models;

import jakarta.persistence.*;

@Entity
@Table(name = "animes")
@PrimaryKeyJoinColumn(name = "id")
public class Animes extends Contenido {

    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "studio_id")
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
