import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { first } from 'rxjs/operators';
import { environment } from '@environments/environment';
import { userloggin ,User} from '@app/_models';
import {  } from '@app/_models';
@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/api/all/Registration`);
    }
    getlogin()
    {
        return this.http.get<userloggin[]>(`${environment.apiUrl}/api/all/login`);
    }

    register(user: User) {
        return this.http.post(`${environment.apiUrl}/api/Registration`, user);
     }

    logout(email : String) {
      
      return this.http.delete(`${environment.apiUrl}/api/log/`+email);

    }
}