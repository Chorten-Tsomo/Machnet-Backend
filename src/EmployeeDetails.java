import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeDetails {
    String name;
    int age;
    String gender;
    String department;
    int salary;

    public EmployeeDetails(String name, int age, String gender, String department, int salary){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.department=department;
        this.salary=salary;
    }

    public int getSalary(){
        return this.salary;
    }

    public String getDepartment(){
        return this.department;
    }
    public static void main (String []args){
        List<EmployeeDetails> employee = new ArrayList<EmployeeDetails>();
        employee.add(new EmployeeDetails("Chorten", 20, "Female", "IT", 3000));
        employee.add(new EmployeeDetails(" Tsomo", 21, "Lesbain", "Sports", 5000));
        employee.add(new EmployeeDetails("Sean", 19, "Male", "Dance", 3000));
        employee.add(new EmployeeDetails("Lew", 25, "Female", "Sports", 5000));
        employee.add(new EmployeeDetails("Kurama", 23, "Male",  "Arts", 4000));
        employee.add(new EmployeeDetails("Tanjiro", 16, "Gay", "Gaming", 6000));

        List<Integer> salary = employee.stream()
                .map(detail -> detail.salary)
                .collect(Collectors.toList());

        Integer totalSalary = salary.stream()
                .reduce(0,(account, details)-> account + details);

        Integer averageSalary = totalSalary/salary.size();
        System.out.println("The average salary is " + averageSalary);


        Set<String> department = employee.stream()
                .map(details -> details.department)
                .collect(Collectors.toSet());
        System.out.println("List of unique departments are:" +department);

        Map<String, Double> departmentbasedsalary = employee.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getDepartment, Collectors.averagingInt(EmployeeDetails::getSalary)));
        System.out.println(departmentbasedsalary);





    }
}
