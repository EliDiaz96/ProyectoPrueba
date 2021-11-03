import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { DomainBancolombiaEntity } from './domainBancolombiaEntity';

@Injectable({
  providedIn: 'root'
})
export class DomainBancolombiaService {

  private url:string="http://localhost:8080/apiDetecter";

  constructor(private http:HttpClient) { }

  getAll():Observable<DomainBancolombiaEntity[]>{
    return this.http.get<DomainBancolombiaEntity[]>(this.url);
  }

  get(nombre:string):Observable<DomainBancolombiaEntity>{
    return this.http.get<DomainBancolombiaEntity>(this.url+'/consulta/?nombre='+nombre);
  }

  create(domainBancolombiaEntity:DomainBancolombiaEntity):Observable<DomainBancolombiaEntity>{
    return this.http.post<DomainBancolombiaEntity>(this.url,domainBancolombiaEntity);
  }
}
