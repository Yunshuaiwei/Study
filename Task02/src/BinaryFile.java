/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 22:19
 * @Version
 **/
public class BinaryFile {
    private Integer x;
    private Integer y;
    private String operator;

    public BinaryFile(Integer x, Integer y, String operator) {
        if (!operator.equals("+") && !operator.equals("-") &&
                !operator.equals("*") && !operator.equals("/")) {
            throw new RuntimeException("运算符错误！");
        }
        this.x = x;
        this.y = y;
        this.operator = operator;
    }

    /**
     * 根据运算符计算当前类所表示的表达式的值
     *
     * @return double
     * @Param []
     **/
    public Integer computers() {
        if (this.operator.equals("+")) {
            return this.x + this.y;
        } else if (this.operator.equals("-")) {
            return this.x - this.y;
        } else if (this.operator.equals("*")) {
            return this.x * this.y;
        } else {
            if (this.y == 0) {
                throw new ArithmeticException("by/zero");
            } else {
                return this.x / this.y;
            }
        }
    }
}
