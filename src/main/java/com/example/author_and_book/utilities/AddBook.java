package com.example.author_and_book.utilities;

import com.example.author_and_book.Author;
import com.example.author_and_book.AuthorBookController;
import com.example.author_and_book.Book;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class AddBook {
    public static Optional<Book> showAndWait() {
        Dialog<Book> dialog = new Dialog<>();
        dialog.setTitle("Enter book details");
        dialog.setHeaderText("Enter data!");

        ButtonType createButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        TextField bookName = new TextField();
        bookName.setPromptText("Book name");

        ComboBox<Author> comboBox = new ComboBox<>(AuthorBookController.getAuthors());

        TextField bookPrice = new TextField();
        bookPrice.setPromptText("Book price");

        TextField bookQty = new TextField();
        bookQty.setPromptText("Book quantity");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(new Label("Book name: "), 0, 0);
        grid.add(bookName, 1, 0);
        grid.add(new Label("Authors: "), 0, 1);
        grid.add(comboBox, 1, 1);
        grid.add(new Label("Book price"), 0, 2);
        grid.add(bookPrice, 1, 2);
        grid.add(new Label("Book quantity"), 0, 3);
        grid.add(bookQty, 1, 3);
        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton) {
                try {
                    String name = bookName.getText().trim();
                    double price = Double.parseDouble(bookPrice.getText().trim());
                    int qty = Integer.parseInt(bookQty.getText().trim());
                    Author author = comboBox.getValue();
                    return new Book(name, author, price, qty);
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Enter correct numbers");
                    alert.showAndWait();
                }
            }
            return null;
        });
        return dialog.showAndWait();
    }
}
