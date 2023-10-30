import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findEmployeesByExperience(int targetExperience) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getExperience() == targetExperience) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<String> findPhoneNumberByName(String targetName) {
        List<String> phoneNumbers = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getName().equalsIgnoreCase(targetName)) {
                phoneNumbers.add(employee.getPhoneNumber());
            }
        }
        if (phoneNumbers.isEmpty()) {
            System.out.println("No employees found with the name: " + targetName);
        }
        return phoneNumbers;
    }

    public Employee findEmployeeByEmployeeId(int targetEmployeeId) {
        for (Employee employee : employees) {
            if (employee.getEmployeeId() == targetEmployeeId) {
                return employee;
            }
        }
        return null;
    }
}
