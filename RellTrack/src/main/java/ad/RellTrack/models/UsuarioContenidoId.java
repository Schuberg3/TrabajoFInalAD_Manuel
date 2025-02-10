package ad.RellTrack.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioContenidoId implements Serializable {

    private Integer userId;
    private Integer contentId;

    public UsuarioContenidoId() {}

    public UsuarioContenidoId(Integer userId, Integer contentId) {
        this.userId = userId;
        this.contentId = contentId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioContenidoId that = (UsuarioContenidoId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(contentId, that.contentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, contentId);
    }
}

