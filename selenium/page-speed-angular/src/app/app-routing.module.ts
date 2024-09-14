import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { CountriesComponent } from './country/countries.component';
import { CitiesComponent } from './city/cities.component';

const routes: Routes = [{
  path: 'countries', 
  component: CountriesComponent
}, {
  path: 'cities',
  component: CitiesComponent
}]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
