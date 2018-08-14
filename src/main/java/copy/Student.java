package copy;

import java.io.Serializable;

/**
 *  * description: description
 *  * author: jiangtao
 *  * date: 2018-08-14 9:57
 *  * modify: modify
 *  
 */
public class Student implements Cloneable, Serializable {

    private Person person;

    private String className;

    public Student(Person person, String className) {
        this.person = person;
        this.className = className;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    protected Student clone() {
        try {
            Student student = (Student) super.clone();
            student.setPerson(this.getPerson().clone());
            return student;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }


}
