package Books;

import java.util.Date;

class NewlyAdded{
    public String bookName;
    public String authorName;
    public int bookId;
    boolean issued;
    Date d1;
    public  NewlyAdded(String a, int b, String c, boolean d,Date e){
        this.bookName=a;
        this.bookId=b;
        this.authorName=c;
        this.issued=d;
        this.d1=e;

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
    public static void main(String[] args){
        Date d2=new Date(2019,06,17);
        Date d4=new Date();
        System.out.println(d4.getDate());
        NewlyAdded book1 = new NewlyAdded("Book1",01,"abc",true,d2);
        System.out.println((book1.bookAvailable()?"True":"False"));


        System.out.println(book1.Fine(d4));


    }
}
