import { Component, OnInit } from '@angular/core';
import { DomainBancolombiaService } from './domainBancolombia.service';
import { DomainBancolombiaEntity } from './domainBancolombiaEntity';


@Component({
  selector: 'app-dominios',
  templateUrl: './dominios.component.html',
  styleUrls: ['./dominios.component.css']
})
export class DominiosComponent implements OnInit {
  titulo: string = "Lista de dominios";
  values = " ";
  dominios: DomainBancolombiaEntity[] = [];
  nombreDominio: DomainBancolombiaEntity[] = [];

  constructor(private domainBancolombiaService: DomainBancolombiaService) { }

  ngOnInit(): void {

  }

  onClickMe(data: any) {
    this.domainBancolombiaService.get(data).subscribe(
      //e =>console.log(e)
      (e: DomainBancolombiaEntity) => {
        if (e != null) {
          if (e.nombre == null) {
            this.values = "El dominio no se encuentra registrado. ";
          } else {
            this.values = "El dominio " + e.nombre + " se encuentra registrado. ";
          }
        } else {
          this.values = "El dominio no se encuentra registrado. ";
        }

      }
    );
  }
}
