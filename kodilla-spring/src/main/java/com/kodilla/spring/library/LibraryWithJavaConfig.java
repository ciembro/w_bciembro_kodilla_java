package com.kodilla.spring.library;

import java.util.ArrayList;
import java.util.List;

public class LibraryWithJavaConfig {

    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public LibraryWithJavaConfig(final LibraryDbController libraryDbController) {
    this.libraryDbController = libraryDbController;
    }

    public LibraryWithJavaConfig(){
        //do nothing
    }
    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
