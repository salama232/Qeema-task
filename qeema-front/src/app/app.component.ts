import { Component, Injectable, Output } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './_services';
import { User } from './_models';
import { UserService } from '@app/_services';
import { first } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { WebSocket_app } from './WebSocket_app';

@Component({ selector: 'app', templateUrl: 'app.component.html' })
@Injectable({ providedIn: 'root' })

export class AppComponent {
    currentUser: User;
    returnedData$ : Observable<any>;
    registration: any;
    name: string;
    loading = false;
    submitted = false;
    users: User[];
    returnUrl: string;
    error = '';
    webSocket_app:WebSocket_app;


    ngOnInit() {
        this.webSocket_app=new WebSocket_app(new AppComponent(this.router,this.authenticationService,this.UserService));
        this.connect();
      }
  
    constructor(
        private router: Router,
        private authenticationService: AuthenticationService,
        private UserService: UserService

    ) 
    {
        this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
    }

    connect(){
        this.webSocket_app._connect();
      }
    
     public  disconnect(){
        this.webSocket_app._disconnect();
      }
     
    sendMessage(message){
       
        this.webSocket_app._sendregest(message);

      }
    
      
      handleMessage(message){
        this.registration = message;
      }

    logoutd() {
        this.loading = true;
        
        this.UserService.logout(this.currentUser.email)
            .pipe(first())
            .subscribe();
            this.sendMessage(this.currentUser.email);
            this.disconnect();
     this.authenticationService.logout();
      this.router.navigate(['/login']);
      

          } 


      

          


}