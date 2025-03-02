package ad.RellTrack.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class Usuario {

    @Schema(description = "Valor numérico que representa el ID", example = "5")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Schema(description = "Valor de texto que representa el nombre de usuario del usuario", example = "Schuberg")
    private String username;
    @Schema(description = "Valor de texto que representa la contraseña de un usuario", example = "*********")
    private String password;
    @Schema(description = "Valor de texto que representa el correo del usuario", example = "ejemplo@gmail.com")
    private String email;
    @Schema(description = "Valor de texto que representa el tipo de usuario que es", example = "USER || ADMIN")
    private String userType;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @Schema(description = "Lista de contenido que representa el catálogo del usuario")
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
