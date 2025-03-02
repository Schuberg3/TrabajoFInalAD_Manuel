package ad.RellTrack.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "user_catalog")
public class UsuarioContenido {

    @Schema(description = "Valor numérico que representa el ID, el cual es una clave compuesta")
    @EmbeddedId
    private UsuarioContenidoId id;

    @Schema(description = "Valor numérico que representa la puntuación que el usuario dá a un contenido", example = "5")
    private int rating;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    @Schema(description = "Valor de tipo Usuario que represetna el usuario que al que se le asigna dicho contenido")
    private Usuario user;

    @ManyToOne
    @MapsId("contentId")
    @JoinColumn(name = "content_id")
    @Schema(description = "Valor de tipo Contenido que representa el contenido que ha visto el usuario")
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
