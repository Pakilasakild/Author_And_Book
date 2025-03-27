module com.example.author_and_book {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.author_and_book to javafx.fxml;
    exports com.example.author_and_book;
}