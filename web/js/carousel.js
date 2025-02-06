const carouselContainer = document.querySelector(".carousel-container");
const prevBtn = document.querySelector(".prev");
const nextBtn = document.querySelector(".next");
const indicatorsContainer = document.querySelector(".carousel-indicators");

const totalItems = document.querySelectorAll(".carousel-item").length;
let currentIndex = 0;
let interval;

// Crear indicadores dinámicamente
for (let i = 0; i < totalItems; i++) {
    const indicator = document.createElement("button");
    if (i === 0) indicator.classList.add("active");
    indicator.addEventListener("click", () => goToSlide(i));
    indicatorsContainer.appendChild(indicator);
}

// Actualiza los indicadores
function updateIndicators() {
    document.querySelectorAll(".carousel-indicators button").forEach((btn, i) => {
        btn.classList.toggle("active", i === currentIndex);
    });
}

// Mueve el carousel a la posición deseada
function goToSlide(index) {
    currentIndex = (index + totalItems) % totalItems;
    carouselContainer.style.transform = `translateX(-${currentIndex * 100}%)`;
    updateIndicators();
}

// Botones de navegación
nextBtn.addEventListener("click", () => {
    goToSlide(currentIndex + 1);
    resetAutoSlide();
});

prevBtn.addEventListener("click", () => {
    goToSlide(currentIndex - 1);
    resetAutoSlide();
});

// Auto-movimiento
function startAutoSlide() {
    interval = setInterval(() => goToSlide(currentIndex + 1), 3000);
}

// Resetear auto-slide cuando el usuario interactúa
function resetAutoSlide() {
    clearInterval(interval);
    startAutoSlide();
}

// Iniciar auto-slide
startAutoSlide();
