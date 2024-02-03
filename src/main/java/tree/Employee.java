package tree;
/**
*
*
* @author huanghao
* @date  2024/2/3 10:53
* @version 1.0
* company: ANSO
* copyright: Copyright (c) 2022
* modified by:
*/
public class Employee {
    private int id;
    private String name;
    private int managerId;

    public Employee(int id, String name, int managerId) {
        this.id = id;
        this.name = name;
        this.managerId = managerId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getManagerId() {
        return managerId;
    }
}
