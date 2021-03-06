import { Component, OnInit, NgModule, ViewChild  } from '@angular/core';
import { LogTableComponent, Log } from './components/log-table/log-table.component'

import { ApiService } from  './services/api.service';


import * as Stomp from 'stompjs';

import * as socketJs from 'sockjs-client';


 interface LogObject {
  id : string ;
  date : string ;
  type : string ;
  message : string ;
}


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {

  

  title = 'Log Manager';
  logs;

  dataSource : Log[] =  [
  ];

  dataSourceNew : Log[] = [
  ] ;



  @ViewChild('LogTable') logTable : LogTableComponent;
  
  private serverUrl = 'http://localhost:4200/server/logListener';
  private stompClient;
 
  constructor(private  apiService:  ApiService){
   this.initializeWebSocketConnection();
  }


  ngOnInit() {
    this.getLogsFromFile();
  }


  ngAfterViewInit() {
    
  }

  public  getLogsFromDb(){
    this.apiService.getLogsFromDB().subscribe((data:  Array<LogObject>) => {
        this.logs  =  data;

        for(let log  of this.dataSource){
          this.dataSourceNew.push(log);
        }
        for(var i = 0; i<data.length; i++) { 
          let newLog : Log = {data: data[i].date, log_type: data[i].type, log_message : data[i].message };  
          this.dataSourceNew.push(newLog);
         
        }
        this.dataSource = this.dataSourceNew; 
        this.dataSource = this.dataSourceNew;
        this.dataSourceNew = [];   
        console.log(data);
    });
  }

    public  getLogsFromFile(){
      this.apiService.getLogsFromFile().subscribe((data:  Array<LogObject>) => {
          this.logs  =  data;

          for(let log  of this.dataSource){
            this.dataSourceNew.push(log);
          }
        
          
          
          for(var i = 0; i<data.length; i++) { 
            let newLog : Log = {data: data[i].date, log_type: data[i].type, log_message : data[i].message };  
            this.dataSourceNew.push(newLog);
           
          }
          this.dataSource = this.dataSourceNew; 
          this.dataSource = this.dataSourceNew;
          this.dataSourceNew = [];   
          console.log(data);
      });
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
          console.log(message.body);
        }
      });
    });
  }



  clearPreviousData(){
    this.dataSource = [];
  }

  onValChange(value){
    console.log(value)
    this.clearPreviousData();
    if(value === "db"){
    
      this.getLogsFromDb();
    }
    else if (value ==="file"){
      this.getLogsFromFile();
    }
}
}


