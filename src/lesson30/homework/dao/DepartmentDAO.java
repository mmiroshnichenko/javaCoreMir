package lesson30.homework.dao;

import lesson30.homework.entity.Department;
import lesson30.homework.entity.DepartmentType;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {
    private static Set<Department> departments = new HashSet<>();

    public static Department add(Department department) throws Exception {
        if (departments.add(department)) {
            return department;
        }

        throw new Exception("Error: " + department + " already exist in base");
    }

    public static Department getDepartmentByType(DepartmentType departmentType) throws Exception {
        for (Department department : departments) {
            if (department.getType().equals(departmentType)) {
                return department;
            }
        }

        throw new Exception("Error: department with type:" + departmentType + " has not found");
    }
}
