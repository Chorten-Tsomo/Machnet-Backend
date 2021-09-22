public class Room {

    int roomnumber;
    String roomtype;
    float roomarea;
    boolean acMachine;

    public void setData(int rommno, String type, float area, boolean ac){
        roomnumber=rommno;
        roomtype=type;
        roomarea=area;
        acMachine=ac;

    }

    public void displayData(){
        System.out.println("The room number is " +roomnumber);
        System.out.println("It is " +roomtype);
        System.out.println("It's area is " +roomarea);
        System.out.println("With ac:" +acMachine);
    }


    public static void main(String []args){
        Room roomdetails = new Room();
        roomdetails.setData(1,"Single", 330.32f, true);
        roomdetails.displayData();
    }

}
