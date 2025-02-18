import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      const username = this.loginForm.value.username;

      if (localStorage.getItem('username')) {
        this.router.navigate(['/dashboard']);
        return;
      }

      // Guardar el username en localStorage
      localStorage.setItem('username', username);

      // Redirigir al dashboard
      this.router.navigate(['/dashboard']).catch(err => console.error('Navigation error:', err));
    };
  };

};
