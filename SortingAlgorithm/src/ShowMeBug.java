import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 上海云简科技笔试题
 *
 * @author yunshuaiwei
 * @version 1.0
 * @date 2023/3/28 11:33
 */
public class ShowMeBug {
    public static final int GROSS_INDEX = 0;
    public static final int NET_INDEX = 1;
    public static final int TAX_INDEX = 2;

    // 本题面试官已设置测试用例
    public double[][] solution(double[] reimbursementAmounts, double receiptNetAmount, double receiptTaxAmount) {
        // 结果集
        double[][] res = new double[reimbursementAmounts.length][3];
        //去税金额和税金的比例
        if (receiptTaxAmount != 0) {
            double proportion = receiptNetAmount / receiptTaxAmount;
            for (int i = 0; i < reimbursementAmounts.length; i++) {
                double tax = reimbursementAmounts[i] / (proportion + 1);
                double withoutTax = reimbursementAmounts[i] - tax;

                res[i][0] = reimbursementAmounts[i];
                res[i][1] = new BigDecimal(withoutTax).setScale(2, RoundingMode.HALF_UP).doubleValue();
                res[i][2] = new BigDecimal(tax).setScale(2, RoundingMode.HALF_UP).doubleValue();
            }
        } else {
            double total = 0;
            for (double num : reimbursementAmounts) {
                total += num;
            }
            for (int i = 0; i < reimbursementAmounts.length; i++) {
                double proportion = reimbursementAmounts[i] / total;
                double withoutTax = proportion * receiptNetAmount;
                res[i][0] = reimbursementAmounts[i];
                res[i][1] = new BigDecimal(withoutTax).setScale(2, RoundingMode.HALF_UP).doubleValue();
                res[i][2] = 0;
            }
        }
        return res;
    }
}
