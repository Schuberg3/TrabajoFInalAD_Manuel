document.getElementById("loginButton").addEventListener("click", async (event) => {
    event.preventDefault(); // Evita la recarga de la página

    const username = document.getElementById("username").value.trim();
    if (username === "") {
        document.getElementById("loginError").textContent = "Por favor, ingresa un nombre de usuario.";
        return;
    }

    try {
        const response = await fetch(`http://localhost:8080/api/usuarios/nombre/${encodeURIComponent(username)}`);
        if (!response.ok) {
            throw new Error("Usuario no encontrado.");
        }

        const usuario = await response.json();
        
        // Guardar el nombre en localStorage para usarlo después
        localStorage.setItem("usuario", usuario.username);

        // Redirigir al dashboard
        window.location.href = "../dashboard.html";

    } catch (error) {
        document.getElementById("loginError").textContent = "El usuario no existe. Intenta nuevamente.";
    }
});
