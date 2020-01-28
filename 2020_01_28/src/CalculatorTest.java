import java.util.Stack;

/**
 * @author DELL
 * @Date 2020/1/28 15:53
 **/
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator cal= new Calculator();
        Calculator cal2= new Calculator();
        cal.expression("70+20*6-4");
        cal2.expression("7*2*2-5+1-5+3-4");
    }
}
class Calculator{
    private int index;//用于扫描
    private int num1;
    private int num2;
    private int operation;
    private int res;
    private char ch;//将每次扫描到的char保存到ch
    private String keepNum="";//用于拼接多位数
    /**
     * 处理表达式
     * @param str
     */
    public void expression(String str){
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operationStack = new Stack<>();
        while(true){
            //得到str的每一个字符
            ch=str.substring(index,index+1).charAt(0);
            //如果ch为运算符
            if(isOperation(ch)){
                if(operationStack.empty()){
                    operationStack.push(ch);
                }else{
                    //当前符号优先级小于栈顶符号优先级
                    if(priority(ch)<=priority(operationStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        operation=operationStack.pop();
                        res = cal(num1, num2, operation);
                        numStack.push(res);
                        operationStack.push(ch);
                    }else{
                        //当前符号优先级大于栈顶符号优先级
                        operationStack.push(ch);
                    }
                }
            }else{
                //如果为数字，则如数栈
//                numStack.push(ch-48);
                keepNum+=ch;
                //若ch已经为最后一位，则直接入数栈
                if(index==str.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //判断下一位是否为数字，若为数字则继续扫描，若为运算符则入栈
                    if (isOperation(str.substring(index + 1, index + 2).charAt(0))) {
                        //若后一位为操作符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
            if(index>=str.length()){
                break;
            }
        }
        while(true){
            if(operationStack.empty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            operation=operationStack.pop();
            res = cal(num1, num2, operation);
            numStack.push(res);
        }
        //最后的结果
        int res=numStack.pop();
        System.out.printf("%s的结果为：%d",str,res);
        System.out.println();
    }
    /**
     * 确定运算符的优先级，假设运算符只有'*''/''+''-'
     * @param operation
     * @return
     */
    public int priority(int operation){
        if(operation=='*'||operation=='/'){
            return 1;
        }else if(operation=='+'||operation=='-'){
            return 0;
        }else{
            return -1;
        }
    }

    /**
     * 判断字符是否为操作符
     * @param val
     * @return
     */
    public boolean isOperation(int val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param operation
     * @return
     */
    public int cal(int num1,int num2,int operation){
        int res=0;
        switch (operation){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            default:
                break;
        }
        return res;
    }
}