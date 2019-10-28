import java.util.Objects;

/**
 * @ProjectName 2019_10_28
 * @ClassName Person
 * Description
 * @Auther YunSW
 * @Date 2019/10/28 15:41
 * @Version 1.0
 **/
public class Person {
    String name;
    int age;

    public Person() {
    }

    public Person(String naem, int age) {
        this.name = naem;
        this.age = age;
    }

    public String getNaem() {
        return name;
    }

    public void setNaem(String naem) {
        this.name = naem;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

//    @Override
//    public int hashCode() {
//
//        return Objects.hash(name, age);
//    }
}
