import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: false,
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})

export class RegisterComponent {

  registerForm: FormGroup;
  errorMessage: string = '';

  private apiUrl = 'http://localhost:8080/api/usuarios/register';

  constructor(
    private fb: FormBuilder,
     private http: HttpClient,
      private router: Router
    ) {
    this.registerForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      username: ['', [Validators.required, Validators.minLength(3)]],
      password: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    if (this.registerForm.valid) {
      const newUser = {
        email: this.registerForm.value.email,
        username: this.registerForm.value.username,
        password: this.registerForm.value.password,
        userType: 'USER'
      };

      this.http.post(this.apiUrl, newUser, { responseType: 'text' }).subscribe({
        next: (response) => {
          console.log('Registro exitoso:', response);
          alert('Usuario registrado con éxito.');
          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.error('Error en el registro:', error);
          this.errorMessage = error.error || 'Ocurrió un error al registrar el usuario.';
        }
      });
    }
  }
}
