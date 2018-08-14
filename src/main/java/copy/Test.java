package copy;

import java.io.*;

/**
 *  * description: description
 *  * author: jiangtao
 *  * date: 2018-08-14 9:58
 *  * modify: modify
 *  
 */
public class Test {

    public static void main(String [] args){
        /*1. 初始化一些值*/
        Person person = new Person("张三", 20, 21);
        Student student = new Student(person, "三年二班");

        /*2. 直接拷贝的情况*/
        /*
         * 内存地址测试
         * 打印结果为：
         * student内存地址为：copy.Student@1540e19d
         * studentCopy1内存地址为：copy.Student@1540e19d
         * 结论：内存地址一致
         * */
        Student studentCopy1 = student;
        System.out.println("student内存地址为："+ student);
        System.out.println("studentCopy1内存地址为："+ studentCopy1);



        /*3. 浅拷贝测试*/
        Student studentCopy2 = student.clone();
        /*
        * 内存地址测试
        * 打印结果：
        * student内存地址为：copy.Student@1540e19d
        * studentCopy2内存地址为：copy.Student@677327b6
        * student中Person内存地址为：copy.Person@14ae5a5
        * studentCopy2中Person内存地址为：copy.Person@14ae5a5
        * 结论：浅拷贝对于对象中的对象是拷贝不了的
        * */
        System.out.println("student内存地址为："+ student);
        System.out.println("studentCopy2内存地址为："+ studentCopy2);
        System.out.println("student中Person内存地址为："+ student.getPerson());
        System.out.println("studentCopy2中Person内存地址为："+ studentCopy2.getPerson());


        /*4. 深拷贝测试*/
        long start = System.currentTimeMillis();
        Student studentCopy3 = student.clone();
        long end = System.currentTimeMillis();
        /*
         * 内存地址测试
         * 打印结果：
         * student内存地址为：copy.Student@1540e19d
         * studentCopy3内存地址为：copy.Student@6d6f6e28
         * student中Person内存地址为：copy.Person@14ae5a5
         * studentCopy3中Person内存地址为：copy.Person@135fbaa4
         * 耗时：0ms
         * 结论：深拷贝确实可以做到所有对象拷贝，但是太麻烦，但性能极高
         * */
        System.out.println("student内存地址为："+ student);
        System.out.println("studentCopy3内存地址为："+ studentCopy3);
        System.out.println("student中Person内存地址为："+ student.getPerson());
        System.out.println("studentCopy3中Person内存地址为："+ studentCopy3.getPerson());
        System.out.println("耗时：" + (end - start) + "ms");

        /*4. 序列化实现深拷贝测试*/
        start = System.currentTimeMillis();
        Student studentCopy4 = clone(student); //序列化方法
        end = System.currentTimeMillis();
        /*
         * 内存地址测试
         * 打印结果：
         * student内存地址为：copy.Student@1540e19d
         * studentCopy4内存地址为：copy.Student@1d81eb93
         * student中Person内存地址为：copy.Person@14ae5a5
         * studentCopy4中Person内存地址为：copy.Person@7291c18f
         * 耗时：85ms
         * 结论：序列化实现深拷贝很方便，但是性能相比较前者慢很多
         * */
        System.out.println("student内存地址为："+ student);
        System.out.println("studentCopy4内存地址为："+ studentCopy4);
        System.out.println("student中Person内存地址为："+ student.getPerson());
        System.out.println("studentCopy4中Person内存地址为："+ studentCopy4.getPerson());
        System.out.println("耗时：" + (end - start) + "ms");
    }


    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }


}
