import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-anime',
  standalone: false,
  templateUrl: './anime.component.html',
  styleUrl: './anime.component.css'
})
export class AnimeComponent implements OnInit {
  
  animes: any[] = [];
  animesFiltrados: any[] = [];
  searchTerm: string = '';
  username: string | null;

  private apiUrl = 'http://localhost:8080/api/contenido/animes';
  private apiAgregarUrl = 'http://localhost:8080/api/contenido/agregar';

  constructor(private http: HttpClient) {
    this.username = localStorage.getItem('username');
  }

  ngOnInit() {
    this.obtenerAnimes();
  }

  obtenerAnimes() {
    this.http.get<any[]>(this.apiUrl).subscribe({
      next: (data) => {
        this.animes = data;
        this.animesFiltrados = data; // Inicialmente, todos los animes se muestran
      },
      error: (error) => console.error('Error al obtener animes:', error)
    });
  }

  buscarAnimes() {
    const term = this.searchTerm.toLowerCase().trim();
    this.animesFiltrados = this.animes.filter(anime => 
      anime.title.toLowerCase().includes(term) || 
      anime.genres.some((genre: { name: string }) => genre.name.toLowerCase().includes(term))
    );
  }

  agregarACatalogo(animeId: number) {
    if (!this.username) return;

    const nuevoContenido = {
      username: this.username,
      contentId: animeId,
      rating: 5 // Puntuación por defecto
    };

    this.http.post(this.apiAgregarUrl, nuevoContenido).subscribe({
      next: () => alert('Anime agregado a tu catálogo.'),
      error: (error) => console.error('Error al agregar contenido:', error)
    });
  }
}
