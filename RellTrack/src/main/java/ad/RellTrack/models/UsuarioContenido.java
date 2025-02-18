package ad.RellTrack.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_catalog")
public class UsuarioContenido {

    @EmbeddedId
    private UsuarioContenidoId id;

    private int rating;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private Usuario user;

    @ManyToOne
    @MapsId("contentId")
    @JoinColumn(name = "content_id")
    private Contenido content;

    // Constructores
    public UsuarioContenido() {    }

    // Getters y Setters
    public UsuarioContenidoId getId() {
        return id;
    }

    public void setId(UsuarioContenidoId id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Contenido getContent() {
        return content;
    }

    public void setContent(Contenido content) {
        this.content = content;
    }
}
