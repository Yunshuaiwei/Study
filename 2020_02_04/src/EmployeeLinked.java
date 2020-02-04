/**
 * 存储雇员信息的链表
 *
 * @author DELL
 * @Date 2020/2/4 18:30
 **/
public class EmployeeLinked {
    private Employee head;

    /**
     * 添加雇员，尾插
     *
     * @param emp
     */
    public void add(Employee emp) {
        if (this.head == null) {
            head = emp;
            return;
        }
        Employee cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = emp;
    }

    /**
     * 打印所有信息
     * @param no
     */
    public void display(int no) {
        if (this.head == null) {
            System.out.println("第"+no+"条链表为空！");
            return;
        }
        Employee cur = this.head;
        System.out.println("第"+no+"条链表信息为：");
        while (cur != null) {
            System.out.println(cur.toString());
            cur = cur.next;
        }
    }

    /**
     * 根据id查找雇员
     * @param id
     * @return
     */
    public Employee findEmployee(int id){
        if(this.head==null){
            return null;
        }
        Employee cur=this.head;
        while(cur.id!=id){
            cur=cur.next;
        }
        return cur;
    }
}
