package com.study.team.domain;

import sun.security.krb5.internal.crypto.Des;

/**
 * @ProjectName Project01
 * @ClassName Designer
 * Description
 * @Auther YunSW
 * @Date 2019/10/26 13:40
 * @Version 1.0
 **/
public class Designer extends Programmer {
    private double bonus;//奖金
    public Designer(){
        super();
    }
    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
