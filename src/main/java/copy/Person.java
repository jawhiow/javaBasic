package copy;

import java.io.Serializable;

/**
 *  * description: description
 *  * author: jiangtao
 *  * date: 2018-08-14 9:55
 *  * modify: modify
 *  
 */
public class Person implements Cloneable, Serializable {

    private String name;
    private int age;
    private Integer age1;

    public Person(String name, int age, Integer age1) {
        this.name = name;
        this.age = age;
        this.age1 = age1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getAge1() {
        return age1;
    }

    public void setAge1(Integer age1) {
        this.age1 = age1;
    }

    @Override
    protected Person clone() {
        try {
            return (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
