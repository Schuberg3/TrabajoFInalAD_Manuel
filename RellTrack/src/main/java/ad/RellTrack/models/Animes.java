package ad.RellTrack.models;

import jakarta.persistence.*;

@Entity
@Table(name = "animes")
public class Animes {

    @Id
    private Integer id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Contenido content;

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

    public Contenido getContent() {
        return content;
    }

    public void setContent(Contenido content) {
        this.content = content;
    }

    public Studios getStudio() {
        return studio;
    }

    public void setStudio(Studios studio) {
        this.studio = studio;
    }
}
