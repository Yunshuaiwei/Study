import java.util.Scanner;

/**
 * @author DELL
 * @Date 2020/2/4 17:57
 **/
public class HashTableTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        String key="";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("add: 添加雇员");
            System.out.println("dis: 显式雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit:退出");
            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入姓名");
                    String name=scanner.next();
                    Employee emp = new Employee(id, name);
                    hashTable.add(emp);
                    break;
                case "dis":
                    hashTable.display();
                    break;
                case "find":
                    System.out.println("请输入查找的id");
                    int i=scanner.nextInt();
                    hashTable.findEmployee(i);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
