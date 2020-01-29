import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DELL
 * @Date 2020/1/29 12:53
 **/
public class PolandNotation {
    public static void main(String[] args) {
        String exception="30 4 + 5 x 6 -";
        List<String> list = getListString(exception);
        int res = calculator(list);
        System.out.println("计算结果为："+res);
    }

    /**
     * 将表达式通过空格进行分割，将分割后的字符串存入list集合中，并返回list
     * @param exception
     * @return
     */
    public static List<String> getListString(String exception){
        //将exception进行分割
        String[] s = exception.split(" ");
        ArrayList<String> list = new ArrayList<>();
        //将分割后的字符串放入list中
        for (String s1 : s) {
            list.add(s1);
        }
        return list;
    }
    public static int calculator(List<String> list){
        Stack<String> stack = new Stack<>();
        for (String s : list) {
            //正则表达式取出数字
            //匹配多位数
            if(s.matches("\\d+")){
                stack.push(s);
            }else{
                int num2=Integer.parseInt(stack.pop());
                int num1=Integer.parseInt(stack.pop());
                int res=0;
                switch (s){
                    case "+":
                        res=num1+num2;
                        break;
                    case "-":
                        res=num1-num2;
                        break;
                    case "x":
                        res=num1*num2;
                        break;
                    case "/":
                        res=num1/num2;
                        break;
                    default:
                        throw new RuntimeException("运算符有误！");
                }
                stack.push(""+res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
