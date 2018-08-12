import { Component, OnInit, NgModule, ViewChild  } from '@angular/core';
//import { LogService} from './services/log.service';
import { LogTableComponent, Log } from './components/log-table/log-table.component'

import * as Stomp from 'stompjs';

import * as socketJs from 'sockjs-client';

import * as $ from 'jquery';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {

  title = 'Log Manager';

  dataSource : Log[] =  [
  ];

  dataSourceNew : Log[] = [
  ] ;



  @ViewChild('LogTable') logTable : LogTableComponent;
  
  private serverUrl = 'http://localhost:8080/logListener';
  private stompClient;
 
  constructor(){
   this.initializeWebSocketConnection();
  }


  ngOnInit() {
      
  }


  ngAfterViewInit() {
    
  }



  initializeWebSocketConnection(){
    let ws =  socketJs(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/logEndPoint", (message) => {
        

        if(message.body) {
          console.log(message);
          let messageJson = JSON.parse(message.body);

          let newLog : Log = {data: messageJson.date, log_type: messageJson.type, log_message : messageJson.message };

          for(let log  of that.dataSource){
            that.dataSourceNew.push(log);
          }
        
          that.dataSourceNew.push(newLog);
          that.dataSource = that.dataSourceNew;
          that.dataSourceNew = [];
          console.log(that.dataSource.length);
          //$(".chat").append("<div class='message'>"+message.body+"</div>")
          console.log(message.body);
        }
      });
    });
  }

  sendMessage(message){
    this.stompClient.send("/app/send/message" , {}, message);
    $('#input').val('');
  }

 refreshDataSet(){

  console.log( this.dataSource);
  console.log( this.dataSourceNew);

    //this.logTable.refreshDataSet(this.dataSourceNew);
    //this.dataSource = [
   //   {data: 12, log_type: 'dfaksd', log_message: 12}
   // ]
  }
}


