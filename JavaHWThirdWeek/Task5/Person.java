package Task5;

public class Person implements Runnable {
    private int numPerson;

    Person(int numPerson) {
        this.numPerson = numPerson;
    }

    @Override
    public void run() {
        System.out.printf("Игрок %d пришел на игру.\n", numPerson);

        //ожидаем игроков
        PlayFootball.START.countDown();
    }
}
