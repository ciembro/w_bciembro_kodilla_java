package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryWithAdnotations {

    private final List<String> books = new ArrayList<>();

//    ----wstrzykiwanie do wlasciwosci klasy---
    @Autowired
    private LibraryDbController libraryDbController;

//    ----wstrzykiwanie za pomoca konstruktora---
//    ---adnotacja, gdy mamy wiecej niz 1 konstruktor
//    @Autowired
//    public Library(final LibraryDbController libraryDbController) {
//        this.libraryDbController = libraryDbController;
//    }

//    ---- wstrzykiwanie za pomoca metody---
//    @Autowired
//    public void setLibraryDbController(LibraryDbController libraryDbController) {
//        this.libraryDbController = libraryDbController;
//    }

    public LibraryWithAdnotations(){
        //do nothing
    }
    public void saveToDb() {
        libraryDbController.saveData();
    }

    public void loadFromDb() {
        libraryDbController.loadData();
    }
}
