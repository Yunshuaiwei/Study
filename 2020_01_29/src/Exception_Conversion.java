import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DELL
 * @Date 2020/1/29 17:11
 **/
public class Exception_Conversion {
    public static void main(String[] args) {
        String exception="1+((2+3)*4)-5";
        List<String> s = exceptionList(exception);
        System.out.println("中缀表达式："+s);
        List<String> list = parseSuffixExpresionList(s);
        System.out.println("后缀表达式："+list);
    }
    public static List<String> parseSuffixExpresionList(List<String> ls){
        //符号栈
        Stack<String> s1 = new Stack<>();
        //存放中间结果
        ArrayList<String> s2 = new ArrayList<>();
        for (String item : ls) {
            if(item.matches("\\d+")){
                s2.add(item);
            }else if(item.equals("(")){
                s1.push(item);
            }else if(item.equals(")")){
                //如果为右括号，则依次弹出s1中的元素压入s2，直到遇到左括号为止
                while(!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将'('从s1栈弹出，即消除括号
            }else{
                //当item的优先级小于栈顶元素的优先级，将s1栈顶元素弹出加入到s2中
                while(!s1.empty()&&Operation.getPriority(s1.peek())>=Operation.getPriority(item)){
                    s2.add(s1.pop());
                }
                //最后将item压入s1中
                s1.push(item);
            }
        }
        //将s1中剩余的元素加入s2中
        while(!s1.empty()){
            s2.add(s1.pop());
        }
        return s2;
    }
    /**
     * 将表达式中数字和符号依次存入ArrayList中
     * @param str
     * @return
     */
    public static List<String> exceptionList(String str){
        List<String> list = new ArrayList<>();
        int i=0;
        char c;
        String s="";
        while(i<str.length()){
            c = str.substring(i, i + 1).charAt(0);
            if(c=='+'||c=='-'||c=='*'||c=='/'||c=='('||c==')'){
                list.add(c+"");
            }else{
                //考虑多位数
                s+=c;
                if(i==str.length()-1){
                    list.add(s);
                }else{
                    char c1 = str.substring(i+1, i + 2).charAt(0);
                    if(c1=='+'||c1=='-'||c1=='*'||c1=='/'||c1=='('||c1==')'){
                        list.add(s);
                    }
                }
                s="";
            }
            i++;
        }
        return list;
    }
}

/**
 * 得到运算符的优先级
 */
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    public static int getPriority(String operation){
        int res=0;
        switch (operation){
            case "+":
                res=ADD;
                break;
            case "-":
                res=SUB;
                break;
            case "*":
                res=MUL;
                break;
            case "/":
                res=DIV;
                break;
            default:
                break;
        }
        return res;
    }
}
