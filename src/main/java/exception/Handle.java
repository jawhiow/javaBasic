package exception;

/**
 *  * description: description
 *  * author: jiangtao
 *  * date: 2018-07-27 8:37
 *  * modify: modify
 *  
 */
public class Handle {

    public void handleChecked(){
        try {
            throw new CheckedExceptionA();
        } catch (CheckedExceptionA checkedExceptionA) {
            checkedExceptionA.printStackTrace();
        }
    }

    public void handleUnChecked(){
        throw new UnCheckedExceptionB();
    }
}
