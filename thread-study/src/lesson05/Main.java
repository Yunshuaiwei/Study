package lesson05;

/**
 * @author DELL
 * @Date 2020/3/23 8:33
 **/
public class Main {

}
class Country{
    private static Country COUNTRY=new Country();
    private Country(){

    }
    public static Country getInstance(){
        return COUNTRY;
    }

    /**
     * 懒汉式
     * @return
     */
    public static Country getInstance2(){
        if(COUNTRY==null){
            COUNTRY=new Country();
        }
        return COUNTRY;
    }
}