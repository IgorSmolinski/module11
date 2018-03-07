package prototype;

import com.igor.patterns.prototype.Book;
import com.igor.patterns.prototype.Library;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {

    @Test
    public void testGetBook(){
        //Given
        Library library = new Library("Filia nr.1");
        Book book = new Book("Prometeusz", "Scott", LocalDate.of(1983,12,01));
        Book book2 = new Book("WiedźMikołaj", "Pratchett", LocalDate.of(1994,8,04));
        Book book3 = new Book("Inferno", "Brown", LocalDate.of(2016,4,16));
        Book book4 = new Book("Ubik", "Dick", LocalDate.of(1985,10,30));
        library.getBooks().add(book);
        library.getBooks().add(book2);
        library.getBooks().add(book3);
        library.getBooks().add(book4);

        //making a shallow copy
        Library cloneLibrary =null;
        try{
            cloneLibrary=library.shallowCopy();
            cloneLibrary.setName("Filia nr.2");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //making a deep copy
        Library deepCloneLibrary = null;
        try {
            deepCloneLibrary = library.deepCopy();
            library.setName("Filia nr 3");
        }catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //When
        library.getBooks().remove(book4);
        //Then
        Assert.assertEquals(3, library.getBooks().size());
        Assert.assertEquals(3,cloneLibrary.getBooks().size());
        Assert.assertEquals(4,deepCloneLibrary.getBooks().size());


    }

}
