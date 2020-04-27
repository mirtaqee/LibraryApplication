import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  isBookUpdate: Boolean = false;
  selectedLibraryId;
  bookObjToEdit;

  constructor(private http: HttpClient) { }

  getLibraries(): Observable<any> {
    return this.http.get<any[]>('http://localhost:8080/libraries');
  }

  getBooks(librayId): Observable<any> {
    return this.http.get<any[]>('http://localhost:8080/libraries/' + librayId + '/books');
  }

  addBook(libraryId, book): Observable<any> {
    return this.http.post<any[]>('http://localhost:8080/libraries/' + libraryId + '/books', book);
  }

  deleteBook(libraryId, bookId): Observable<any> {
    return this.http.delete<any[]>('http://localhost:8080/libraries/' + libraryId + '/books/' + bookId);
  }

  updateBook(libraryId, book): Observable<any> {
    return this.http.put<any[]>('http://localhost:8080/libraries/' + libraryId + '/books', book);
  }

}
