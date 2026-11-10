import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookService } from '../../services/book';
import { Book } from '../../models/book';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './book-list.html', 
  styleUrl: './book-list.css'    
})
export class BookListComponent implements OnInit {
  books: Book[] = [];
  

  currentBook: Book = {
    titulo: '',
    autor: '',
    anioPublicacion: new Date().getFullYear(),
    genero: ''
  };

  isEditing: boolean = false;

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.loadBooks();
  }


  loadBooks(): void {
    this.bookService.getBooks().subscribe({
      next: (data) => (this.books = data),
      error: (err) => console.error('Error al cargar libros:', err)
    });
  }


  saveBook(): void {
    if (this.isEditing && this.currentBook.id) {
      this.bookService.updateBook(this.currentBook.id, this.currentBook).subscribe({
        next: () => {
          this.loadBooks();
          this.resetForm();
        },
        error: (err) => console.error('Error al actualizar libro:', err)
      });
    } else {
      this.bookService.createBook(this.currentBook).subscribe({
        next: () => {
          this.loadBooks();
          this.resetForm();
        },
        error: (err) => console.error('Error al crear libro:', err)
      });
    }
  }


  editBook(book: Book): void {
    this.currentBook = { ...book };
    this.isEditing = true;
  }


  deleteBook(id?: number): void {
    if (id && confirm('¿Estás seguro de eliminar este libro?')) {
      this.bookService.deleteBook(id).subscribe({
        next: () => this.loadBooks(),
        error: (err) => console.error('Error al eliminar libro:', err)
      });
    }
  }

  resetForm(): void {
    this.currentBook = {
      titulo: '',
      autor: '',
      anioPublicacion: new Date().getFullYear(),
      genero: ''
    };
    this.isEditing = false;
  }
}