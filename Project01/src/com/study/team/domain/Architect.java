package com.study.team.domain;

/**
 * @ProjectName Project01
 * @ClassName Architect
 * Description
 * @Auther YunSW
 * @Date 2019/10/26 13:46
 * @Version 1.0
 **/
public class Architect extends Designer{
    private int stock;//股票

    public Architect() {

    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
