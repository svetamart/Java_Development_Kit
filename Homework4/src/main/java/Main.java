import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();
        repo.addEmployee(new Employee("123456789", "John", 5));
        repo.addEmployee(new Employee("987654321", "Jane", 3));
        repo.addEmployee(new Employee("019283746", "Paul", 8));
        repo.addEmployee(new Employee("647283190", "Jim", 6));
        repo.addEmployee(new Employee("119922883", "Jane", 10));
        repo.addEmployee(new Employee("980234321", "Mary", 3));

        // Ищем сотрудников по стажу
        List<Employee> experiencedEmployees = repo.findEmployeesByExperience(3);
        System.out.println("Employees with a 3-year experience:");
        for (Employee employee : experiencedEmployees) {
            System.out.println(employee.getInfo());
        }

        // Ищем номер телефона по имени
        List<String> phoneNumbers = repo.findPhoneNumberByName("Jane");
        System.out.println("\nPhone numbers for Jane:");
        System.out.println(phoneNumbers);

        // Ищем сотрудника по табельному номеру
        Employee foundEmployee = repo.findEmployeeByEmployeeId(10);
        if (foundEmployee != null) {
            System.out.println("\nEmployee with Employee ID 10: " + foundEmployee.getInfo());
        } else {
            System.out.println("\nEmployee with Employee ID 10 not found in the directory");
        }
    }
}
