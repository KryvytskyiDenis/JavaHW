package Task1;


import java.util.concurrent.atomic.AtomicInteger;

//класс второго склада
public class StorageB {
    //используя класс AtomicInteger обеспечим доступ к кол-ву посылок на складе
    static AtomicInteger countParcel = new AtomicInteger(5);//начально кол-во посылок - 5.
    static void setCountParcel(){
        System.out.printf("На складе B: %d посылок.\n",countParcel.get());
    }
}
