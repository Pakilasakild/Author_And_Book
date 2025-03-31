package com.example.author_and_book.utilities;

import com.example.author_and_book.Author;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class AddAuthor {
    public static Optional<Author> showAndWait(){
        Dialog<Author> dialog = new Dialog<>();
        dialog.setTitle("Enter author details");
        dialog.setHeaderText("Enter data!");

        ButtonType createButton = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(createButton, ButtonType.CANCEL);

        TextField authorName = new TextField();
        authorName.setPromptText("Author name");

        TextField authorEmail = new TextField();
        authorEmail.setPromptText("Author email");

        TextField authorGender = new TextField();
        authorGender.setPromptText("Author gender");

        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(new Label("Author name: "), 0, 0);
        grid.add(authorName, 1, 0);
        grid.add(new Label("Author email: "), 0, 1);
        grid.add(authorEmail, 1, 1);
        grid.add(new Label("Author gender: "), 0, 2);
        grid.add(authorGender, 1, 2);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == createButton){
                    String name = authorName.getText().trim();
                    String email = authorEmail.getText().trim();
                    char gender = authorGender.getText().trim().charAt(0);
                    return new Author(name, email, gender);
            }
            return null;
        });
        return dialog.showAndWait();
    }
}
