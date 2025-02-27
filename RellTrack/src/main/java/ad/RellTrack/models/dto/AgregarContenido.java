package ad.RellTrack.models.dto;

public class AgregarContenido {
    private String username;
    private Integer contentId;
    private int rating;

    public AgregarContenido() {    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

//En mi API, contenido es una clase padre y series, pelis y animes heredan de contenido. Contenido tiene unas propiedades comunes (imgUrl, releaseDate, title y una lista de géneros). Luego, cada subclase tiene algo, por ejemplo, animes tiene studio, series y pelis tienen director.
//El formulario de thymeleaf para agregar un nuevo contenido, así como el de modificarlos, debe cumplir correctamente todos estos datos y añadirlo a las tablas pertinentes.
