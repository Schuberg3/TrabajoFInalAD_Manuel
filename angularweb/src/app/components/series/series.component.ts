import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-series',
  standalone: false,
  templateUrl: './series.component.html',
  styleUrl: './series.component.css'
})
export class SeriesComponent implements OnInit {
  series: any[] = []; // Lista original de series
  seriesFiltradas: any[] = []; // Lista filtrada según el buscador
  searchTerm: string = ''; // Término de búsqueda
  username: string | null;

  private apiUrl = 'http://localhost:8080/api/contenido/series';
  private apiAgregarUrl = 'http://localhost:8080/api/contenido/agregar';

  constructor(private http: HttpClient) {
    this.username = localStorage.getItem('username');
  }

  ngOnInit() {
    this.obtenerSeries();
  }

  obtenerSeries() {
    this.http.get<any[]>(this.apiUrl).subscribe({
      next: (data) => {
        this.series = data;
        this.seriesFiltradas = data; // Inicialmente, todas las series se muestran
      },
      error: (error) => console.error('Error al obtener series:', error)
    });
  }

  buscarSeries() {
    const term = this.searchTerm.toLowerCase().trim();
    this.seriesFiltradas = this.series.filter(serie => 
      serie.title.toLowerCase().includes(term) || 
      serie.genres.some((genre: { name: string }) => genre.name.toLowerCase().includes(term))
    );
  }

  agregarACatalogo(serieId: number) {
    if (!this.username) return;

    const nuevoContenido = {
      username: this.username,
      contentId: serieId,
      rating: 5 // Puntuación por defecto
    };

    this.http.post(this.apiAgregarUrl, nuevoContenido).subscribe({
      next: () => alert('Serie agregada a tu catálogo.'),
      error: (error) => console.error('Error al agregar contenido:', error)
    });
  }
}
