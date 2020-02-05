/**
 * @author DELL
 * @Date 2020/2/4 18:27
 **/
public class HashTable {
    EmployeeLinked[] employeeLinkedArray;
    //链表的长度
    private int size;

    public HashTable(int size) {
        this.size = size;
        employeeLinkedArray = new EmployeeLinked[size];
        for (int i = 0; i < size; i++) {
            employeeLinkedArray[i] = new EmployeeLinked();
        }
    }

    /**
     * 添加员工
     *
     * @param emp
     */
    public void add(Employee emp) {
        int employeeLinkedIndex = hashFun(emp.id);
        employeeLinkedArray[employeeLinkedIndex].add(emp);
    }

    /**
     * 散列函数，使用取模法实现
     *
     * @param id
     * @return
     */
    public int hashFun(int id) {
        return id % size;
    }

    /**
     * 遍历哈希表
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            employeeLinkedArray[i].display(i + 1);
        }
    }

    /**
     * 根据id查找雇员
     *
     * @param id
     */
    public void findEmployee(int id) {
        int i = hashFun(id);
        Employee employee = employeeLinkedArray[i].findEmployee(id);
        if (employee == null) {
            System.out.println("没有找到！");
        } else {
            System.out.println(employee.toString());
        }
    }

    /**
     * 根据id删除雇员
     *
     * @param id
     */
    public void deleteEmployee(int id) {
        int i = hashFun(id);
        boolean delete = employeeLinkedArray[i].delete(id);
        if (delete) {
            System.out.println("删除成功！");
        } else {
            System.out.println("没有此员工！");
        }
    }
}
