package Books;

import java.util.*;

class NewlyAdded{
    public String bookName;
    public String authorName;
    public int bookId;
    boolean issued;
    Date d1;
    public  NewlyAdded(String a, int b, String c, boolean d,Date e) {
        this.bookName = a;
        this.bookId = b;
        this.authorName = c;
        this.issued = d;
        this.d1 = e;

    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Date getD1() {
        return d1;
    }

    public void setD1(Date d1) {
        this.d1 = d1;
    }

    //if book is issued
    public boolean bookAvailable(){
        if (issued == true){
            return false;
        }
        else{
            return true;
        }
    }
    //calculate fine
    public double Fine(Date d3){
        long daysDifferent;
        daysDifferent = d1.getTime()-d3.getTime();
        System.out.println(daysDifferent);
        int days =(int)(daysDifferent/(24*60*60*1000));
        System.out.println(days);
        double fine=10;
        if (days >= 10 && days<15){
            return (fine+=days*2);
        }
        else if(days >= 15 && days <30){
            return (fine+=10+(days-15)*5);
        }
        else if (days >= 30){
            return (fine+=(75+(days-30)*100));
        }
        return 0;

    }


}
public class BooksNewAdd {
    HashMap<Integer, NewlyAdded> map = new HashMap<Integer, NewlyAdded>();

    @Override
    public String toString() {
        return "BooksNewAdd{" +
                "map=" + map +
                '}';
    }
    NewlyAdded searchBook(String bookName, HashMap<Integer,NewlyAdded> bookList){
        for(int key : bookList.keySet())
        {

            if(bookList.get(key).getBookName().equalsIgnoreCase(bookName))
            {
                return bookList.get(key);
            }
        }
        return null;
    }

    public static void main(String[] args){
        BooksNewAdd m1 = new BooksNewAdd();
        Date d2=new Date(2019,06,17);
        Date d3 = new Date(2019, 01,23);
        Date d4 = new Date(2018,07,07);
        Date d5 = new Date(2019,02,27);
        Date dT=new Date();
        System.out.println(dT.getDate());
        NewlyAdded book1 = new NewlyAdded("Book1",01,"abc",true,d2);
        System.out.println((book1.bookAvailable()?"True":"False"));

        System.out.println(book1.Fine(dT));

        NewlyAdded b1 = new NewlyAdded("book2",02,"cde",false,d3);
        NewlyAdded b2 = new NewlyAdded("book3", 03, "egf", true,d4);
        NewlyAdded b3 = new NewlyAdded("book4", 04, "fgh",false,d5);
        m1.map.put(b1.bookId,b1);
        m1.map.put(b2.bookId,b2);
        m1.map.put(b3.bookId,b3);

        ArrayList<NewlyAdded> array1 = new ArrayList<NewlyAdded>();
        array1.add(book1);
        array1.add(b1);
        array1.add(b2);
        array1.add(b3);

        //Question : Sort book by author name
        Comparator<NewlyAdded> m = new Comparator<NewlyAdded>() {
            @Override
            public int compare(NewlyAdded o1, NewlyAdded o2) {
                return o1.getAuthorName().compareTo(o2.getAuthorName());
            }
        };
        Collections.sort(array1, m);

        for(NewlyAdded values: array1){
            System.out.println(values.authorName);
        }

        String giveBook;
        System.out.println("Enter a book name to search: ");
        Scanner input1 = new Scanner(System.in);
        giveBook = input1.nextLine();

        System.out.println(m1.searchBook(giveBook, m1.map));





    }
}
