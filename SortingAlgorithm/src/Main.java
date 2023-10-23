import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/27 23:46
 */
public class Main {


    public static void main(String[] args) {
        BigDecimal[] nums = new BigDecimal[]{
                new BigDecimal("100.24"),
                new BigDecimal("120.54"),
                new BigDecimal("96.12"),
                new BigDecimal("130.00"),
                new BigDecimal("70.84"),
                new BigDecimal("200.96"),
                new BigDecimal("136.40"),
                new BigDecimal("290.10")
        };
        //去税金额
        BigDecimal totalWithoutTax = new BigDecimal("870.25");
        //税金
        BigDecimal totalTax = new BigDecimal("274.95");
        List<BigDecimal[]> result = method(nums, totalWithoutTax, totalTax);
        for (BigDecimal[] bigDecimals : result) {
            System.out.println(Arrays.toString(bigDecimals));
        }
    }

    /**
     * nums：报销金额数组
     * totalWithoutTax：发票上的去税金额
     * totalTax：发票上的税金
     *
     * @author yunshuaiwei
     * @date 2023/3/28 10:24
     **/
    public static List<BigDecimal[]> method(BigDecimal[] nums, BigDecimal totalWithoutTax, BigDecimal totalTax) {
        List<BigDecimal[]> list = new ArrayList<>();
        BigDecimal totalAmount = totalTax.add(totalWithoutTax);
        //去税金额与税金的比例
        BigDecimal proportion = totalWithoutTax.divide(totalTax, RoundingMode.CEILING);

        //报销金额总和
        BigDecimal totalNums = new BigDecimal("0");
        //去税金额总和
        BigDecimal sumWithoutTax = new BigDecimal("0");
        //税金总和
        BigDecimal sumTax = new BigDecimal("0");
        for (BigDecimal num : nums) {
            //税金
            BigDecimal tax = num.divide(proportion.add(new BigDecimal("1")), RoundingMode.CEILING);
            //去税金额
            BigDecimal withoutTax = num.subtract(tax);
            totalNums = totalNums.add(num);
            sumWithoutTax = sumWithoutTax.add(withoutTax);
            sumTax = sumTax.add(tax);
            list.add(new BigDecimal[]{num, withoutTax, tax});
        }
        //补充值
        if (totalNums.compareTo(totalAmount) < 0) {
            list.add(new BigDecimal[]{totalAmount.subtract(totalNums), totalWithoutTax.subtract(sumWithoutTax), totalTax.subtract(sumTax)});
        }
        return list;
    }

    /**
     * nums：报销金额数组
     * totalWithoutTax：发票上的去税金额
     * totalTax：发票上的税金
     *
     * @author yunshuaiwei
     * @date 2023/3/27 23:46
     **/
    public static List<BigDecimal[]> method1(BigDecimal[] nums, BigDecimal totalWithoutTax, BigDecimal totalTax) {
        List<BigDecimal[]> list = new ArrayList<>(nums.length);
        BigDecimal total = totalWithoutTax.add(totalTax).setScale(2, RoundingMode.HALF_UP);
        //去税金额所占比例
        BigDecimal proportion = totalWithoutTax.divide(total, RoundingMode.CEILING);
        for (BigDecimal num : nums) {
            BigDecimal withoutTax = proportion.multiply(num).setScale(2, RoundingMode.HALF_UP);
            BigDecimal tax = num.subtract(withoutTax).setScale(2, RoundingMode.HALF_UP);
            list.add(new BigDecimal[]{num, withoutTax, tax});
        }
        return list;
    }

    public static List<int[]> calculateTax(int[] expenses, int totalWithoutTax, int totalTax) {
        // 总价
        int total = totalWithoutTax + totalTax;
        // 比例
        double proportion = (double) totalTax / totalWithoutTax;
        // 结果
        List<int[]> result = new ArrayList<>();
        // 当前报销金额的总和
        int sumExpenses = 0;
        // 当前去税金额的总和
        int sumWithoutTax = 0;
        // 当前税金的总和
        int sumTax = 0;
        // 循环计算
        for (int expense : expenses) {
            int withoutTax = (int) (expense / (1 + proportion));
            int tax = expense - withoutTax;
            // 计算合计
            sumExpenses += expense;
            sumWithoutTax += withoutTax;
            sumTax += tax;
            // 添加结果
            result.add(new int[]{expense, withoutTax, tax});
        }
        // 最后一个报销金额做补充
        if (sumExpenses < total) {
            // 计算补充
            int lastExpense = total - sumExpenses;
            int lastWithoutTax = totalWithoutTax - sumWithoutTax;
            int lastTax = totalTax - sumTax;
            // 添加结果
            result.add(new int[]{lastExpense, lastWithoutTax, lastTax});
        }
        return result;
    }
}
