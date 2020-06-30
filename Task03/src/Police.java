import java.util.Date;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/30 21:12
 * @Version
 **/
public abstract class Police {
    public Date date;
    public Integer policeId;
    public String name;
    public Double pay;

    public Police() { }
    public Police(Date date, Integer policeId, String name, Double pay) {
        this.date = date;
        this.policeId = policeId;
        this.name = name;
        this.pay = pay;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPoliceId() {
        return policeId;
    }

    public void setPoliceId(Integer policeId) {
        this.policeId = policeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }
    /**
     * 增加薪资
     * @Param []
     * @return void
     **/
    public abstract double addPay();

    @Override
    public String toString() {
        return "Police{" +
                "date=" + date +
                ", policeId=" + policeId +
                ", name='" + name + '\'' +
                ", pay=" + pay +
                '}';
    }
}
