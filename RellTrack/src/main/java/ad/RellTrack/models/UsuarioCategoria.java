package ad.RellTrack.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_catalog")
public class UsuarioCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    @ManyToOne
    @JoinColumn(name = "content_id")
    private Contenido content;

    // Constructores
    public UsuarioCategoria() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
