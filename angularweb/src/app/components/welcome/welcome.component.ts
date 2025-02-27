import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-welcome',
  standalone: false,
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})
export class WelcomeComponent implements OnInit {
  userCatalog: any[] = [];
  listaContenido: any[] = [];
  mostrarFormulario = false;
  formAgregar: FormGroup;
  username: string | null;

  private apiUrl = 'http://localhost:8080/api/contenido';
  private apiAgregarUrl = 'http://localhost:8080/api/contenido/agregar';
  private apiBorrarContenido = 'http://localhost:8080/api/uContenido';

  constructor(
    private fb: FormBuilder,
    private userService: UserService,
    private http: HttpClient) {
    this.formAgregar = this.fb.group({
      tipo: ['', Validators.required],
      contenido: ['', Validators.required],
      rating: [5, [Validators.required, Validators.min(1), Validators.max(10)]]
    });

    this.username = localStorage.getItem('username');
  }

  ngOnInit() {
    if (!this.username) {
      console.error('No hay usuario logeado.');
      return;
    }

    // 🔹 Cargar el catálogo del usuario
    this.userService.userData$.subscribe({
      next: (data) => {
        if (data) {
          this.userCatalog = data.userCatalog;
        }
      },
      error: (error) => console.error('Error al recibir datos del usuario:', error)
    });
  }

  abrirFormularioAgregar() {
    this.mostrarFormulario = true;
  }

  cerrarFormularioAgregar() {
    this.mostrarFormulario = false;
    this.formAgregar.reset();
    this.listaContenido = [];
  }

  obtenerListaContenido() {
    const tipo = this.formAgregar.value.tipo;
    if (!tipo) {
      this.listaContenido = [];
      return;
    }

    let url = `${this.apiUrl}/${tipo.toLowerCase()}s`;

    this.http.get<any[]>(url).subscribe({
      next: (data) => {
        this.listaContenido = data;
      },
      error: (error) => console.error(`Error al obtener ${tipo}:`, error)
    });
  }

  agregarContenido() {
    if (this.formAgregar.valid && this.username) {
      const nuevoContenido = {
        username: this.username,
        contentId: this.formAgregar.value.contenido,
        rating: this.formAgregar.value.rating
      };

      this.http.post(this.apiAgregarUrl, nuevoContenido).subscribe({
        next: () => {
          alert('Contenido agregado con éxito.');
          this.cerrarFormularioAgregar();

          const contenidoAgregado = this.listaContenido.find(item => item.id === nuevoContenido.contentId);
          
          if (contenidoAgregado) {
            const nuevoItem = {
              id: { userId: this.username, contentId: nuevoContenido.contentId },
              rating: nuevoContenido.rating,
              content: contenidoAgregado
            };

            this.userCatalog.push(nuevoItem);
          }
        },
        error: (error) => console.error('Error al agregar contenido:', error)
      });
    }
  }

  confirmDelete(userId: number, contentId: number) {
    const confirmacion = confirm('¿Estás seguro de que deseas eliminar este contenido de tu catálogo?');
    if (confirmacion) {
        this.deleteContent(userId, contentId);
    }
}


  deleteContent(userId: number, contentId: number) {
    this.http.delete(`api/uContenido?userId=${userId}&contentId=${contentId}`).subscribe({
      next: () => {
        // Filtrar la lista en la UI sin recargar la página
        this.userCatalog = this.userCatalog.filter(item => item.id.contentId !== contentId);
      },
      error: err => console.error('Error al eliminar contenido:', err)
    });
}



  // eliminarContenido() {
  //   TODO: Implementar lógica
  // }

  // modificarContenido() {
  //   TODO: Implementar lógica
  // }

}