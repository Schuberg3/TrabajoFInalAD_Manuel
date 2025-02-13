document.addEventListener("DOMContentLoaded", async () => {
    const usuario = localStorage.getItem("usuario");

    if (!usuario) {
        window.location.href = "login.html"; // Si no hay usuario, volver al login
        return;
    }

    // Detectar cambios en el contenido de #dashboard
    const observer = new MutationObserver(() => {
        const userNameElement = document.getElementById("user-name");
        if (userNameElement) {
            userNameElement.innerHTML = usuario;
            observer.disconnect(); // Deja de observar cuando encuentra el elemento
        }
    });

    observer.observe(document.getElementById("dashboard"), { childList: true, subtree: true });
});
