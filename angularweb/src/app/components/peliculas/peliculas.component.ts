import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-peliculas',
  standalone: false,
  templateUrl: './peliculas.component.html',
  styleUrl: './peliculas.component.css'
})
export class PeliculasComponent implements OnInit {

  peliculas: any[] = [];
  peliculasFiltradas: any[] = [];
  searchTerm: string = '';
  username: string | null;

  private apiUrl = 'http://localhost:8080/api/contenido/peliculas';
  private apiAgregarUrl = 'http://localhost:8080/api/contenido/agregar';

  constructor(private http: HttpClient) {
    this.username = localStorage.getItem('username');
  }

  ngOnInit() {
    this.obtenerPeliculas();
  }

  obtenerPeliculas() {
    this.http.get<any[]>(this.apiUrl).subscribe({
      next: (data) => {
        this.peliculas = data;
        this.peliculasFiltradas = data;
      },
      error: (error) => console.error('Error al obtener películas:', error)
    });
  }

  buscarPeliculas() {
    const term = this.searchTerm.toLowerCase().trim();
    this.peliculasFiltradas = this.peliculas.filter(peli => 
      peli.title.toLowerCase().includes(term) || 
      peli.genres.some((genre: { name: string }) => genre.name.toLowerCase().includes(term))
    );
  }

  agregarACatalogo(peliId: number) {
    if (!this.username) return;

    const nuevoContenido = {
      username: this.username,
      contentId: peliId,
      rating: 5
    };

    this.http.post(this.apiAgregarUrl, nuevoContenido).subscribe({
      next: () => alert('Película agregada a tu catálogo.'),
      error: (error) => console.error('Error al agregar contenido:', error)
    });
  }
}
