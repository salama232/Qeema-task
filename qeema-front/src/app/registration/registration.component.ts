import { Component, Injectable, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { first } from 'rxjs/operators';
import { UserService } from '@app/_services';
import { HomeComponent }  from '@app/home';
import { WebSocket_Reg } from './WebSocket_Reg';
import { User, userloggin } from '@app/_models';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
})

// @Injectable({ providedIn: 'root' })
export class RegistrationComponent implements OnInit {
  registrationForm: FormGroup;
  loading = false;
  submitted = false;
  returnUrl: string;
  error = '';
  registration: any;
  webSocket_Reg : WebSocket_Reg;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private UserService: UserService,
     ) {
     
   }

  ngOnInit() {
   
    this.webSocket_Reg = new WebSocket_Reg(new RegistrationComponent(this.formBuilder,this.router,this.UserService));
    this.connect();
    this.registrationForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required]
  });

  }
  get f() { return this.registrationForm.controls; }


  onSubmit() {
    this.submitted = true;
    this.sendMessage();
    // stop here if form is invalid
    if (this.registrationForm.invalid) {
        return;
    }

    this.loading = true;
    this.UserService.register(this.registrationForm.value)//(this.f.email.value,this.f.username.value,this.f.password.value)
        .pipe(first())
        .subscribe(
            data => {
                this.router.navigate(['/login']);
            },
            error => {
                this.error = error;
                this.loading = false;
            });
    
}


connect(){
  this.webSocket_Reg._connect();
}

disconnect(){
  this.webSocket_Reg._disconnect();
}

sendMessage(){
  this.webSocket_Reg._sendregest(this.registrationForm.value);
}

handleMessage(message){
  this.registration = message;
}





}
