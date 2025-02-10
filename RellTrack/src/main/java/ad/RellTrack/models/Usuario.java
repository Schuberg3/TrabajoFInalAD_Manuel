package ad.RellTrack.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UsuarioContenido> userCatalog;

    // Constructores
    public Usuario() {    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<UsuarioContenido> getUserCatalog() {
        return userCatalog;
    }

    public void setUserCatalog(List<UsuarioContenido> userCatalog) {
        this.userCatalog = userCatalog;
    }
}
