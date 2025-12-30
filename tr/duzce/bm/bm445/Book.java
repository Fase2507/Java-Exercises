package tr.duzce.bm.bm445;
public class Book{

        String title;
        int pages;

        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            System.out.println("Name of book is "+this.title);
            return this.title;
        }
        public Book(){

        }
        Book(String title, int pages){
            this.pages = pages;
            this.title = title;

        }

        String displayInfo(){
            return this.title+" ("+this.pages+" pages)";
        }
}