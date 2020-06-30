import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 21:31
 * @Version
 **/
public class TestPolice {
    public static void main(String[] args) {
        ArmedPolice police = new ArmedPolice();
        police.setPoliceId(10034);
        police.setName("成龙");
        police.setPay((double) 3000);
        police.setArmyName("武警第七旅");
        police.setMilitaryRank("第三警察主管");
        police.setDate(new Date(2004,4,1));
        System.out.println(police);
        float v = police.payrollComputation(2004);
        System.out.println("加薪后的薪资为："+v);
    }
}
