document.getElementById("registerForm").addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = document.getElementById("email").value.trim();
    const username = document.getElementById("username").value.trim();
    const password = document.getElementById("password").value.trim();

    if (!email || !username || !password) {
        document.getElementById("loginError").textContent = "Todos los campos son obligatorios.";
        return;
    }

    const usuario = { email, username, password };

    try {
        const response = await fetch("http://localhost:8080/api/usuarios/register", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(usuario)
        });

        if (!response.ok) {
            throw new Error(await response.text());
        }

        alert("Registro exitoso. Redirigiendo al login...");
        window.location.href = "login.html"; // Redirige al login

    } catch (error) {
        document.getElementById("loginError").textContent = error.message;
    }
});
