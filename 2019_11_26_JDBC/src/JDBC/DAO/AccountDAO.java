package JDBC.DAO;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/22 20:22
 * @Version
 **/
public class AccountDAO {
    private int id;
    private String name;
    private Double money;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "AccountDAO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
