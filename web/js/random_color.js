document.addEventListener("DOMContentLoaded", () => {
    const colors = [
        "#FFADAD", // Rojo pastel
        "#FFD6A5", // Naranja pastel
        "#FDFFB6", // Amarillo pastel
        "#CAFFBF", // Verde pastel
        "#9BF6FF", // Azul pastel
        "#A0C4FF", // Índigo pastel
        "#BDB2FF", // Violeta pastel
        "#FFC6FF"  // Rosa pastel
    ];

    // Selecciona un color aleatorio
    const randomColor = colors[Math.floor(Math.random() * colors.length)];

    // Asigna el color a la variable CSS
    document.documentElement.style.setProperty("--random-color", randomColor);
});
