import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  
  isEditBook:Boolean = false;
  isLoading:Boolean = false;
  book = {
    id: 0,
    title: "",
    author: "",
    publisher: ""
  };

  constructor(private dataService: DataService, private router: Router) { }

  ngOnInit(): void {
    if(this.dataService.isBookUpdate) {
      this.isEditBook = true;
      this.book = this.dataService.bookObjToEdit;
    } 
  }

  addBook() {
    if(!this.validateFields()) { // validate fields
      return; // stop execution in case of validation issues
    }

    this.isLoading = true;
    this.dataService.addBook(this.dataService.selectedLibraryId, this.book).subscribe(data => {
      this.isLoading = false;
      this.goBack();
    },
    error => {

    });
  }

  updateBook() {
    this.isLoading = true;
    this.dataService.updateBook(this.dataService.selectedLibraryId, this.book).subscribe(data => {
      this.isLoading = false;
      this.goBack();
    },
    error => {

    });  
  }

  goBack() {
    this.clear();
    this.router.navigate(['/']);  
  }

  clear() {
    this.dataService.isBookUpdate = false;
    this.isEditBook = false;
    this.dataService.bookObjToEdit = {};  
  }

  validateFields() {
    if(this.book.id && this.book.title && this.book.author && this.book.publisher) {
      return true;
    }
    else {
      return false;
    }
  }

}
