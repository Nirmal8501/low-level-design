//package BehaviouralPatterns.Iterator;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//class Book {
//    String name;
//
//    public Book(String name){
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//}
//
//class BookCollection {
//    List<Book> books = new ArrayList<>();
//
//    public void addBook(Book book){
//        books.add(book);
//    }
//
//    public List<Book> getAllBooks(){
//        return books;
//    }
//
//    public Iterator<Book> getIterator(){
//        return new BookIterator(this.books);
//    }
//
//    private class BookIterator implements Iterator<Book> {
//        private final List<Book> books;
//
//        int position = 0;
//
//        public BookIterator(List<Book> books){
//            this.books = books;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return position < books.size();
//        }
//
//        @Override
//        public Book next() {
//            return books.get(position++);
//        }
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        BookCollection books = new BookCollection();
//        books.addBook(new Book("C++"));
//        books.addBook(new Book("Java"));
//        books.addBook(new Book("Python"));
//
//        Iterator<Book> bookIterator = books.getIterator();
//        while (bookIterator.hasNext()){
//            System.out.println(bookIterator.next());
//        }
//    }
//}
