package ad.RellTrack.models;

import jakarta.persistence.*;

@Entity
@Table(name = "seasons")
public class Temporadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int seasonNumber;

    @ManyToOne
    @JoinColumn(name = "content_id")
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
