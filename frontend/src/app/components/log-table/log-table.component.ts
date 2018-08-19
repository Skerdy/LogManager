import { Component, OnInit, ViewChild , Input, OnChanges, SimpleChanges  } from '@angular/core';
import {MatTableDataSource} from '@angular/material';

export interface Log {
  data: string;
  log_type: string;
  log_message: string;
}


@Component({
  selector: 'app-log-table',
  templateUrl: './log-table.component.html',
  styleUrls: ['./log-table.component.css']
})
export class LogTableComponent implements OnInit {
  matTabledataSource;


  @Input() dataSources;

  ngOnChanges(changes: SimpleChanges) {
    this.refreshTableWithNewData(changes.dataSources.currentValue);
  }

  refreshTableWithNewData(newData : Log[]){
    console.log("Data Refreshed" );
    console.log(newData);
    this.matTabledataSource = new MatTableDataSource(newData);
  }

  displayedColumns: string[] = ['data', 'log_type', 'log_message'];
  
  constructor() { 
    
  }

  ngOnInit() {
    this.matTabledataSource = new MatTableDataSource(this.dataSources);
  }

  applyFilter(filterValue: string) {
    this.matTabledataSource = new MatTableDataSource(this.dataSources);
    console.log("Duke bere filter me string:" + filterValue);
    console.log(this.dataSources);
    this.matTabledataSource.filter = filterValue.trim().toLowerCase();
  }

  defineColor(logType){
      let color;
      switch(logType) {
        case 'Error':
        color = 'red';
        break;
        case 'Warning':
        color = 'orange';
        break;
        default : 
        color = 'green';
        break;
      }
      return color;
  }
}
