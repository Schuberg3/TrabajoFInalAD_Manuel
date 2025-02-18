import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  standalone: false,
  templateUrl: './dashboard.component.html',
  styleUrl: './dashboard.component.css'
})

export class DashboardComponent implements OnInit {
  username: string | null = '';

  constructor(
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit() {
    this.username = localStorage.getItem('username');
    
    if (!this.username) {
      // Si no hay username, redirigir al login
      this.router.navigate(['/login']);
      return;
    };

    // Llamar al servicio para obtener los datos
    this.userService.getUserData(this.username).subscribe({
      next: () => console.log('Datos del usuario cargados correctamente.'),
      error: (error) => console.error('Error al obtener datos del usuario:', error)
    });
  };

};
