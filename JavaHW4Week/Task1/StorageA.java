package Task1;

import java.util.concurrent.atomic.AtomicInteger;

//класс певрого склада
public class StorageA {
    //используя класс AtomicInteger обеспечим доступ к кол-ву посылок на складе
    static AtomicInteger countParcel = new AtomicInteger(1);//начально кол-во посылок - 1.

    static void setCountParcel(){
        System.out.printf("На складе A: %d посылок.\n",countParcel.get());
    }
}