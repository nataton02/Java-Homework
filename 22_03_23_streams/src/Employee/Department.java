package Employee;

import java.util.ArrayList;
import java.util.List;

public class Department {
    public final String name;
    public final String code;
    public List<Employee> employees;

    public Department(String name, String code) {
        this.name = name;
        this.code = code;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
