/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 21:21
 * @Version
 **/
public class ArmedPolice extends Police{
    public String armyName;
    public String militaryRank;


    public ArmedPolice(){}
    public ArmedPolice(String armyName, String militaryRank) {
        super();
        this.armyName = armyName;
        this.militaryRank = militaryRank;
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    public String getMilitaryRank() {
        return militaryRank;
    }

    public void setMilitaryRank(String militaryRank) {
        this.militaryRank = militaryRank;
    }

    @Override
    public double addPay() {
        double p=this.pay;
        p=(p+p*0.3);
        this.pay=p;
        return p;
    }
    /**
     * 计算薪资
     * @Param [date]
     * @return double
     **/
    public float payrollComputation(int date){
        int count=(2020-date)/2;
        float res=0;
        for (int i = 0; i < count; i++) {
            res+=addPay();
        }
        return res;
    }

    @Override
    public String toString() {
        return super.toString()+'\n'+"ArmedPolice{" +
                "armyName='" + armyName + '\'' +
                ", militaryRank='" + militaryRank + '\'' +
                '}';
    }
}
