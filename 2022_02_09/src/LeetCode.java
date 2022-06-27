import java.util.List;

/**
 * @author yunshuaiwei
 * @className LeetCode
 * @description: TODO
 * @date 2022/6/27 11:19
 */
public class LeetCode {
    /**
     * @author yunshuaiwei
     * @description TODO
     * @date 11:19 2022/6/27
     * @Param [A, B, C]
     * @Return void
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        func(A.size(), A, B, C);
    }

    private void func(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
        } else {
            func(n - 1, A, C, B);
            C.add(A.remove(A.size() - 1));
            func(n - 1, B, A, C);
        }
    }
}
