import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LibraryDetailsComponent } from './components/library-details/library-details.component';
import { AddBookComponent } from './components/add-book/add-book.component';

const routes = [
  { path: '', component: LibraryDetailsComponent },
  { path: 'book', component: AddBookComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
