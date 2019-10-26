package com.study.team.service;

import com.study.team.domain.Employee;
import com.study.team.domain.Equipment;
import com.study.team.domain.Programmer;

import static com.study.team.service.Date.*;

/**
 * @ProjectName Project01
 * @ClassName NameListService
 * Description 负责将Date中的数据封装到Employee[]数组当中
 * @Auther YunSW
 * @Date 2019/10/26 13:54
 * @Version 1.0
 **/
public class NameListService {
    private Employee[] employees;

    /**
     * 给数组元素进行初始化
     */
    public NameListService(){
        employees=new Employee[EMPLOYEES.length];
        for (int i = 0; i <employees.length ; i++) {
            //获取员工类型
            int type=Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的4个基本信息
            int id=Integer.parseInt(EMPLOYEES[i][0]);
            String name=EMPLOYEES[i][2];
            int age=Integer.parseInt(EMPLOYEES[i][3]);
            double salary=Double.parseDouble(EMPLOYEES[i][4]);

            switch (type){
                case EMPLOYEE:
                    employees[i]=new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    Equipment equipment=createEquipment(i);
                    employees[i]=new Programmer();
                    break;
                case DESIGNER:
                    break;
                case ARCHITECT:
                    break;
            }
        }
    }
    /*
     * @Author YunSW
     * @Description 获取指定index上的员工的设备
     * @Date 14:18 2019/10/26
     * @Param [i]
     * @return com.study.team.domain.Equipment
     **/
    private Equipment createEquipment(int index) {
        int type=Integer.parseInt(EQUIPMENTS[index][0]);
        switch (type){
            case PC://21
                //return new PC(EQUIPMENTS[index][1],EQUIPMENTS[index][2]);
            case NOTEBOOK:
                break;
            case PRINTER:
                break;
        }
        return null;
    }

    public Employee[] getAllEmployees(){
        return null;
    }
    public Employee[] getEmployees(int id){
        return null;
    }
}
