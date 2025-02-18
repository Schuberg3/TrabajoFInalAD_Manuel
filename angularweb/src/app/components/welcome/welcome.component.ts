import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-welcome',
  standalone: false,
  templateUrl: './welcome.component.html',
  styleUrl: './welcome.component.css'
})

export class WelcomeComponent implements OnInit {
  userCatalog: any[] = [];

  constructor(
    private userService: UserService
  ) {}

  ngOnInit() {
    this.userService.userData$.subscribe({
      next: (data) => {
        if (data?.userCatalog) {
          this.userCatalog = data.userCatalog;
          console.log(data)
        } else {
          console.warn('No se han recibido datos del usuario.');
        }
      },
      error: (error) => console.error('Error al recibir datos:', error)
    });
  }

};
