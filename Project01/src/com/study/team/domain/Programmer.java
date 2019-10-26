package com.study.team.domain;

import com.study.team.service.Status;

/**
 * @ProjectName Project01
 * @ClassName Programmer
 * Description
 * @Auther YunSW
 * @Date 2019/10/26 13:25
 * @Version 1.0
 **/
public class Programmer extends Employee {
    private int memberId;//开发团队的id
    private Status status;
    private Equipment equipment;

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Programmer() {

    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
