import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HomeComponent } from './home.component';
export class WebSocket_Home {
    //private userSubject: BehaviorSubject<User>;
    routed :Router
    webSocketEndPoint: string = 'http://localhost:9090/ws';
    topic: string = "/topic/registration";
    stompClient: any;
    http : HttpClient;
    homeComponent: HomeComponent;
   
    constructor(homeComponent: HomeComponent){
        this.homeComponent = homeComponent;
    }

    
    
    _connect() {
        console.log("Initialize WebSocket Connection");
        let ws = new SockJS(this.webSocketEndPoint);
        this.stompClient = Stomp.over(ws);
        const _this = this;
        _this.stompClient.connect({}, function (frame) {
            _this.stompClient.subscribe(_this.topic, function (sdkEvent) {
                _this.onMessageReceived(sdkEvent);
            });
            //_this.stompClient.reconnect_delay = 2000;
        }, this.errorCallBack);
        
    };


    

     _disconnect() {
        if (this.stompClient !== null) {
            this.stompClient.disconnect();
        }
        console.log("Disconnected");
    }

    // on error, schedule a reconnection attempt
    errorCallBack(error) {
        console.log("errorCallBack -> " + error)
        setTimeout(() => {
            this._connect();
        }, 5000);
    }
  

      /**
	 * Send message to sever via web socket
	 * @param {*} message 
	 */
  
    
    _sendregest(message) {
        console.log("calling logout api via web socket");
        this.stompClient.send("/app/regest", {}, JSON.stringify(message));
    }


 

    onMessageReceived(message) {
        console.log("Message Recieved from Server :: " + message);
        this.homeComponent.handleMessage(JSON.stringify(message.body));
       location.reload();
          }

    }
