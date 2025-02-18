import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: false,
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})

export class NavbarComponent {

  constructor(
    private router: Router
  ) {}

  logout() {
    localStorage.removeItem('username'); // Eliminar usuario del localStorage
    this.router.navigate(['/login']); // Redirigir al login
  };

};
