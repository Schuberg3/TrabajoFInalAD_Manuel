import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-navbar',
  standalone: false,
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})

export class NavbarComponent implements OnInit {

  esAdmin: boolean = false;
  username: string | null = null;

  constructor(
    private router: Router,
    private us: UserService
  ) {}

  ngOnInit() {
    this.username = localStorage.getItem('username');

    if (this.username) {
      this.us.getUserData(this.username).subscribe({
        next: (data) => {
          if (data.userType === 'ADMIN') {
            this.esAdmin = true;
          }
        },
        error: (error) => console.error('Error al obtener datos del usuario:', error)
      });
    }
  };

  logout() {
    localStorage.removeItem('username');
    this.router.navigate(['/login']);
  };

  abrirAdministracion() {
    window.location.href = "http://localhost:8080/admin/contenido";
  };  

};
