package com.example.author_and_book;

import com.example.author_and_book.utilities.AddAuthor;
import com.example.author_and_book.utilities.AddBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

public class AuthorBookController {
    @FXML
    public Button btn_add_author;
    @FXML
    public Button btn_add_book;
    @FXML
    public TableView author_table_view;
    @FXML
    public TableColumn author_name_column;
    @FXML
    public TableColumn author_email_column;
    @FXML
    public TableColumn author_gender_column;
    @FXML
    public TableView book_table_view;
    @FXML
    public TableColumn book_name_column;
    @FXML
    public TableColumn author_column;
    @FXML
    public TableColumn book_price_column;
    @FXML
    public TableColumn book_qty_column;
    static ObservableList<Author> authors = FXCollections.observableArrayList();
    ObservableList<Book> books = FXCollections.observableArrayList();

    public void initialize(){
        Author author = new Author("Arturas", "art152@yahoo.com", 'm');
        authors.add(author);
        books.add(new Book("Arturo Dienorastis", author, 15.99, 5));

        author_name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        author_email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
        author_gender_column.setCellValueFactory(new PropertyValueFactory<>("gender"));

        author_table_view.setItems(authors);

        book_name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        author_column.setCellValueFactory(new PropertyValueFactory<>("author"));
        book_price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
        book_qty_column.setCellValueFactory(new PropertyValueFactory<>("qty"));

        book_table_view.setItems(books);
    }

    public static ObservableList<Author> getAuthors() {
        return authors;
    }

    @FXML
    private void addAuthor(){
        Optional<Author> newAuthor = AddAuthor.showAndWait();
        newAuthor.ifPresent(author -> {
            authors.add(author);
        });
    }
    @FXML
    private void addBook(){
        Optional<Book> newBook = AddBook.showAndWait();
        newBook.ifPresent(book -> {
            books.add(book);
        });
    }
}
