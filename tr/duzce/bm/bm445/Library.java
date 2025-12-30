package tr.duzce.bm.bm445;

class Library{

    String name;
    int year;
    Book[] books;

    public Library(String name, int year, Book[] books){
        this.books = books;
        this.name = name;
        this.year = year;

    }

    public void displayInfo(){
        System.out.println("the "+this.year+" "+this.name);
        System.out.println("Books available: ");
        for(Book b: this.books){
            System.out.println(b.displayInfo());
        }
    }

}