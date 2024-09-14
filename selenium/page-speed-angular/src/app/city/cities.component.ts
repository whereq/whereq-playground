import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
    selector: 'app-root',
    templateUrl: './cities.component.html'
})

export class CitiesComponent {

    constructor(private httpClient: HttpClient) {}

    cities: String[];

    ngOnInit() {
        console.log('Start to load cities.json');

        this.httpClient.get('./assets/cities.json', {responseType: 'text'}).subscribe(
            (data) => {
                this.cities = JSON.parse(data);
            },
            (err: HttpErrorResponse) => {
                console.log(err.message);
            }
        )
    }k
}