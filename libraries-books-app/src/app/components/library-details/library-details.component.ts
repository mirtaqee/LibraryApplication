import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-library-details',
  templateUrl: './library-details.component.html',
  styleUrls: ['./library-details.component.css']
})
export class LibraryDetailsComponent implements OnInit {

  libraryList = [];
  bookList = [];
  selectedLibrary=0;

  constructor(private dataService: DataService, private router: Router) { }

  ngOnInit(): void {

    this.getLibraryList();

    if(this.dataService.selectedLibraryId > 0) { // if the library is selected, load the books - mainly required when retuned from add/update screen
      this.selectedLibrary = this.dataService.selectedLibraryId; // to show the selected library in select dropdown
      this.getBooks();
    }
    // this.libraryList = [
    //   {
    //     id: 1,
    //     desc: "Bangalore South Library",
    //     address: "Bangalore",
    //   },
    //   {
    //     id: 2,
    //     desc: "Bangalore South Library",
    //     address: "Bangalore",
    //   },
    //   {
    //     id: 3,
    //     desc: "Bangalore South Library",
    //     address: "Bangalore",
    //   },
    //   {
    //     id: 4,
    //     desc: "Bangalore South Library",
    //     address: "Bangalore",
    //   },
    //   {
    //     id: 5,
    //     desc: "Bangalore South Library",
    //     address: "Bangalore",
    //   }
    // ];

    // this.bookList = [
    //   {
    //     id: 1,
    //     title: "Title 1",
    //     author: "Author 1",
    //     publisher: "Publisher 1",
    //   },
    //   {
    //     id: 2,
    //     title: "Title 2",
    //     author: "Author 2",
    //     publisher: "Publisher 2",
    //   },
    //   {
    //     id: 3,
    //     title: "Title 3",
    //     author: "Author 3",
    //     publisher: "Publisher 3",
    //   },
    //   {
    //     id: 4,
    //     title: "Title 4",
    //     author: "Author 4",
    //     publisher: "Publisher 4",
    //   },
    //   {
    //     id: 5,
    //     title: "Title 5",
    //     author: "Author 5",
    //     publisher: "Publisher 5",
    //   }
    // ];

  }

  getLibraryList() {
    this.dataService.getLibraries().subscribe(data => {
      this.libraryList = data; // Get the list & assign it to a property
    },
    error => {

    });
  }

  getBooks() {
    this.dataService.selectedLibraryId = this.selectedLibrary;
    this.dataService.getBooks(this.selectedLibrary).subscribe(data => {
      this.bookList = data; // Get the list & assign it to a property
    },
    error => {

    });
  }

  editBook(bookObj) {
    this.dataService.bookObjToEdit = bookObj;
    this.dataService.isBookUpdate = true;
    this.router.navigate(['book']);
    console.log(bookObj);
  }

  deleteBook(id) {
    this.dataService.deleteBook(this.selectedLibrary, id).subscribe(() => {
      debugger
      this.getBooks(); // get latest books
    },
    error => {
    });
    console.log(id);
  }

  addBook() {
    this.router.navigate(['book']);  
  }
   
}
