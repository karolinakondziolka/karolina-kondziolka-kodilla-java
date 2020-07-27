package com.kodilla.patterns.prototyp.library;

import com.kodilla.patterns.prototype.Board;
import com.kodilla.patterns.prototype.library.Book;
import com.kodilla.patterns.prototype.library.Library;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {

    @Test
    public void testGetBooks(){

        //Given
        Library library = new Library("Biblioteczka");
        LocalDate publicationDate = null;

        Book book1 = new Book("Harry Potter i kamien filozoficzny", "J.K.Rowling", publicationDate.of(2010,12,12));
        Book book2 = new Book("Harry Potter i komnata tajemnic", "J.K.Rowling", publicationDate.of(2011,11,23));
        Book book3 = new Book("Harry Potter i wiezien Azkabanu", "J.K.Rowling", publicationDate.of(2013,07,10));
        Book book4 = new Book("Harry Potter i czara ognia", "J.K.Rowling", publicationDate.of(2014,05,30));
        Book book5 = new Book("Harry Potter i zakon feniksa", "J.K.Rowling", publicationDate.of(2015,02,15));

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);
        library.getBooks().add(book5);

        Library clonedLibrary = null;

        try{
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Mała biblioteczka");
        } catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        Library deepClonedLibrary = null;
        try{
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Kolejna biblioteka");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book3);
        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(4, library.getBooks().size());
        Assert.assertEquals(4, clonedLibrary.getBooks().size());
        Assert.assertEquals(5, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());



    }
}
