import { Component, OnDestroy,OnInit} from '@angular/core';
import { first } from 'rxjs/operators';
import { User, userloggin } from '@app/_models';
import { UserService } from '@app/_services';
import { Router,ActivatedRoute } from '@angular/router';
import { WebSocket_Home } from './WebSocket_Home';





@Component({ templateUrl: 'home.component.html' })

export class HomeComponent  {
    loading = false;
    users: User[];
    userslog: userloggin[];
    webSocket_home:WebSocket_Home;
    refresh: any;
    constructor(private userService: UserService) {

      
      
      
     }

    ngOnInit() {
      this.webSocket_home=new WebSocket_Home(new HomeComponent(this.userService));
      this.connect();
        this.loading = true;
        this.userService.getAll().pipe(first()).subscribe(users => {
            this.loading = false;
            this.users = users;

        });


        this.loading = true;
        this.userService.getlogin().pipe(first()).subscribe(userslog => {
            this.loading = false;
            this.userslog = userslog;
        });

      
 
    }




    connect(){
        this.webSocket_home._connect();
      }
    
     public  disconnect(){
        this.webSocket_home._disconnect();
      }
    
  
     
    
      public handleMessage(message){
       this.refresh = message;
      }

     

   

}