import { Injectable } from '@angular/core';
import * as io from 'socket.io-client';

import * as Stomp from 'stompjs';

import * as socketJs from 'sockjs-client';

let URL = "http://localhost:8080/logListener";

  
@Injectable({
  providedIn: 'root'
})
export class LogService {

  private socket; 
  private socketJs;
  private stomp;
  

  constructor() {
    let that = this;
   // var allowedOrigins = "domain_1:* domain_2:*";
    this.socketJs = socketJs(URL);

   

    /*this.stomp.connect({} , frame => {
      console.log("Stomp Connected");
      this.stomp.subscribe ('/chat', data => {
        console.log("Erdhi nje mesazh");
        console.log(JSON.parse(data));
      })

      this.stomp.send("/app/send/message", {}, "Mesazh Skerdi New");
      console.log("U dergua nje mesazh");
    });*/
 

    console.log("U be konstruktori i Log Service");
    
    //this.socket = io(URL);
    
    this.socketJs.onopen = function(){
      console.log('open');
      that.socketJs.send('/app/send/message', 'Mesazh Skerdi New');
      console.log('u dergua mesazhi');

    this.stomp = Stomp.over(that.socketJs);

    this.stomp.connect({ }, function(frame) {
      that.stomp.subscribe("/chat", (message) => {
        if(message.body) {
          console.log("Erdhi nje mesazh");
          console.log(message.body);
        }
      });

      that.stomp.send("/app/send/message", {}, "Mesazh Skerdi New");
      console.log("U dergua nje mesazh");
    });


     that.socketJs.send('/app/send/message', {}, 'Mesazh Skerdi New');
    }

    

    this.socketJs.onmessage = function(e) {
      console.log("U mor nje mesazh nga server");
      console.log('message', e.data);
    };

    //this.socket.on('message', (data) => {
    //  console.log("U mor nje mesazh nga server");
   // })
  }

 

}
