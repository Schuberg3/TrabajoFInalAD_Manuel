console.log("probando si funciona")
document.addEventListener("DOMContentLoaded", async () => {
    const username = localStorage.getItem("usuario");

    if (!username) {
        window.location.href = "login.html"; // Si no hay usuario logeado, volver al login
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/api/uContenido/catalogo/${encodeURIComponent(username)}`);

        if (!response.ok) {
            throw new Error("Error al obtener el catálogo del usuario.");
        }

        const catalogo = await response.json();
        console.log(catalogo)
        mostrarCatalogo(catalogo);
    } catch (error) {
        console.error("Error:", error);
        document.getElementById("catalogo").innerHTML = "<p>No se pudo cargar el catálogo.</p>";
    }
});

function mostrarCatalogo(catalogo) {
    const contenedor = document.getElementById("catalogo");
    contenedor.innerHTML = "<h2>Tu Catálogo</h2>";

    if (catalogo.length === 0) {
        contenedor.innerHTML += "<p>Aún no has añadido contenido a tu catálogo.</p>";
        return;
    }

    catalogo.forEach(contenido => {
        console.log(contenido)
        const div = document.createElement("div");
        let codigo;

        div.classList.add("catalogo-item");

        codigo = `
            <div class="">
            <img src="../public/img/portada/${contenido.imgUrl}.jpg" alt="${contenido.title}">
            <h3>${contenido.title}</h3>
            <p>Temporadas: ${contenido.seasons.length}</p>
            </div>
            <div class="generos">   
        `;

        contenido.genres.forEach(genre => {
            codigo += ` <p>${genre.name}</p> `
        });

        codigo += ` </div> `;
        div.innerHTML = codigo;
        contenedor.appendChild(div);

    });

}
