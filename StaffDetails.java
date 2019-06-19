package Staff;
class Worker{
    public int staffId;
    public String staffName;
    public String staffDepartment;
    public double salary;
    public Worker(String staffName, String staffDepartment, int staffId,int salary){
        this.staffId=staffId;
        this.staffName=staffName;
        this.staffDepartment=staffDepartment;
        this.salary=salary;
    }
    String getStaffName(){
        return staffName;
    }
    String getStaffDepartment(){
        return staffDepartment;
    }
    int getStaffId(){
        return staffId;
    }
    double getsalary(){
        return salary;
    }
}

public class StaffDetails {
    public static void main(String[] args){
        Worker w1 = new Worker("xyz","Manager",02,2000);
        System.out.println(w1.getsalary());
        System.out.println(w1.getStaffDepartment());
        System.out.println(w1.getStaffId());



    }
}
