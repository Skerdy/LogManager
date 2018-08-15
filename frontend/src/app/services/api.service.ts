import { Injectable } from '@angular/core';
import { HttpClient} from  '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  API_URL  =  'http://localhost:4200/server';
  constructor(private  httpClient:  HttpClient) { }

  getLogsFromDB(){
    return  this.httpClient.get(`${this.API_URL}/api/v1/logs`);
   }

   getLogsFromFile(){
    return  this.httpClient.get(`${this.API_URL}/api/v1/logs/file`);
   }
}
