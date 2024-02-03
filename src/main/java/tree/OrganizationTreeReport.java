package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huanghao
 * @version 1.0
 * company: ANSO
 * copyright: Copyright (c) 2022
 * modified by:
 * @date 2024/2/3 10:54
 */
public class OrganizationTreeReport {
    public static void main(String[] args) {
        // 假设这是你的组织结构数据
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John", 0));
        employees.add(new Employee(2, "Alice", 1));
        employees.add(new Employee(3, "Bob", 1));
        employees.add(new Employee(4, "Charlie", 2));
        employees.add(new Employee(5, "David", 3));
        employees.add(new Employee(6, "Eva", 3));

        // 构建树状结构
        Map<Integer, List<Employee>> managerToEmployeesMap = new HashMap<>();
        for (Employee employee : employees) {
            if (!managerToEmployeesMap.containsKey(employee.getManagerId())) {
                managerToEmployeesMap.put(employee.getManagerId(), new ArrayList<>());
            }
            managerToEmployeesMap.get(employee.getManagerId()).add(employee);
        }

        // 生成报表
        generateReport(managerToEmployeesMap, 0, 0);
    }

    public static void generateReport(Map<Integer, List<Employee>> managerToEmployeesMap, int managerId, int level) {
        if (!managerToEmployeesMap.containsKey(managerId)) {
            return;
        }

        List<Employee> employees = managerToEmployeesMap.get(managerId);
        for (Employee employee : employees) {
            // 打印缩进，以表示层级关系
            for (int i = 0; i < level; i++) {
                System.out.print("\t");
            }
            // 打印员工信息
            System.out.println(employee.getName());

            // 递归打印下属员工
            generateReport(managerToEmployeesMap, employee.getId(), level + 1);
        }
    }
}
