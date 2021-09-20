import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AppModel} from './app.model';

@Injectable({
  providedIn: 'root'
})
export class AppInformationService {

  constructor(private readonly http: HttpClient) {
  }

  getAppInformation(): Observable<AppModel> {
    return this.http.get<AppModel>('/api');
  }
}
