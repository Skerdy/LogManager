import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LogService } from './services/log.service';
import {    MatButtonModule,
  MatCardModule,
  MatPaginatorModule,
  MatRadioModule,
  MatSlideToggleModule,
  MatSortModule,
  MatTableModule, 
  MatInputModule } from '@angular/material';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogTableComponent } from './components/log-table/log-table.component';

@NgModule({
  declarations: [
    AppComponent,
    LogTableComponent ,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MatCardModule,
    MatPaginatorModule,
    MatRadioModule,
    MatSlideToggleModule,
    MatSortModule,
    MatTableModule,
    MatInputModule,
    BrowserAnimationsModule,
    NoopAnimationsModule
  ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }

