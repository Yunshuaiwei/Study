package com.study.team.service;

/**
 * @ProjectName Project01
 * @ClassName Status
 * Description
 * @Auther YunSW
 * @Date 2019/10/26 13:29
 * @Version 1.0
 **/
public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME=name;
    }
    public static final Status FREE=new Status("FREE");
    public static final Status BUSY=new Status("BUSY");
    public static final Status COCATION=new Status("VOCATION");

    public String getNAME() {
        return NAME;
    }
}
