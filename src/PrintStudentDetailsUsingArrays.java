import java.util.*;
import java.util.stream.Collectors;
import java.util.ArrayList;


public class PrintStudentDetailsUsingArrays {

    String name;
    int semester;
    int age;
    String gender;

    public PrintStudentDetailsUsingArrays(String name, int semester, int age, String gender){
        this.name=name;
        this.semester = semester;
        this.age=age;
        this.gender=gender;

    }

    @Override
    public String toString(){
        return "[name=" +name + ",semester=" +semester + ",age=" + age + ",gender=" +gender +"]";

    }
    public static void main (String [] args) {
        List<PrintStudentDetailsUsingArrays> arraylist = new ArrayList<PrintStudentDetailsUsingArrays>();
        arraylist.add(new PrintStudentDetailsUsingArrays("Chorten", 6, 21, "Female"));
        arraylist.add(new PrintStudentDetailsUsingArrays("Tsomo", 4, 20, "Lesbain"));
        arraylist.add(new PrintStudentDetailsUsingArrays("Sean", 4, 19, "Male"));
        arraylist.add(new PrintStudentDetailsUsingArrays("Lew", 3, 20, "Male"));
        arraylist.add(new PrintStudentDetailsUsingArrays("Jeremy", 3, 20, "Gay"));

        List<String> name = arraylist.stream()
                .map(details -> details.name)
                .collect(Collectors.toList());
        System.out.println(name);


        List<PrintStudentDetailsUsingArrays> detail = arraylist.stream()
                .filter(details -> details.name.startsWith("J") && details.semester == 3)
                .collect(Collectors.toList());

        System.out.println(detail);





    }
}
