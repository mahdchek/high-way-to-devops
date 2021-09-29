import { Component } from '@angular/core';
import {AppInformationService} from './app.service';
import {PersonneModel} from './personne.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
   appName: string;
   version: string;
   personnes: Array<PersonneModel>;


  constructor(private service: AppInformationService) {
    this.service.getAppInformation().subscribe( data => {
      this.appName = data.appName;
      this.version = data.version;
    });
    this.service.getAllPersonnes().subscribe( personnes => {
      this.personnes = personnes;
    });
  }
}
