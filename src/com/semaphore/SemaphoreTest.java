package com.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    // максимально могут иметь доступ 4 человека
    static Semaphore semaphore = new Semaphore(4); //Ограничиваем доступ только 4-ьом патокам

    static class auctionThread extends Thread {

        String name = "";

        auctionThread(String name) { // опредедяем имя потоков
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : фиксация блокировки");
                System.out.println(name + " : сейчас свободных доступов: "
                        + semaphore.availablePermits());

                semaphore.acquire(); // даёт разрешение
                System.out.println(name + " : получил разрешение!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : выполняет операцию " + i
                                + ", доступный Семафор может разрешить сейчас дуступ: "
                                + semaphore.availablePermits());

                        // sleep 3 second
                        Thread.sleep(3000);

                    }

                } finally {

                    // функция release() вызывается после успешно выполеной ф-и acquire()
                    System.out.println(name + " : освободил доступ.");
                    semaphore.release(); //освобождает доступ к ресурсу
                    System.out.println(name + " : сейчас свободных доступов: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }

    }

    public static void main(String[] args) {

        System.out.println("Всего свободных доступов: "
                + semaphore.availablePermits());

        auctionThread t1 = new auctionThread("Гость 1");
        t1.start();

        auctionThread t2 = new auctionThread("Гость 2");
        t2.start();

        auctionThread t3 = new auctionThread("Гость 3");
        t3.start();

        auctionThread t4 = new auctionThread("Гость 4");
        t4.start();

        auctionThread t5 = new auctionThread("Гость 5");
        t5.start();

        auctionThread t6 = new auctionThread("Гость 6");
        t6.start();

    }
}