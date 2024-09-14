import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';


@Component({
    selector: 'app-root',
    templateUrl: './countries.component.html'
})

export class CountriesComponent {

    constructor(private httpClient: HttpClient) {}

    countries: String[];

    ngOnInit() {
        console.log('Start to load countries.json');

        this.httpClient.get('./assets/countries.json', {responseType: 'text'}).subscribe(
            (data) => {
                this.countries = JSON.parse(data);
            },
            (err: HttpErrorResponse) => {
                console.log(err.message);
            }
        )
    }
}