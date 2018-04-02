package com.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    // максимально могут иметь доступ 4 человека
    static Semaphore semaphore = new Semaphore(4); //Ограничиваем доступ только 4-ьом патокам

    static class auctionThread extends Thread { // Добваляем класс банкомата

        String name = "";

        auctionThread(String name) { // опредедяем имя потоков
            this.name = name;
        }

        public void run() {

            try {

                System.out.println(name + " : фиксация блокировки");
                System.out.println(name + " : доступный Семафор может разрешить сейчас дуступ: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : получил разрешение!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : выполняет операцию " + i
                                + ", доступный Семафор может разрешить сейчас дуступ: "
                                + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // функция release() вызывается после успешно выполеной ф-и acquire()
                    System.out.println(name + " : освободил доступ.");
                    semaphore.release();
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

        auctionThread t1 = new auctionThread("A");
        t1.start();

        auctionThread t2 = new auctionThread("B");
        t2.start();

        auctionThread t3 = new auctionThread("C");
        t3.start();

        auctionThread t4 = new auctionThread("D");
        t4.start();

        auctionThread t5 = new auctionThread("E");
        t5.start();

        auctionThread t6 = new auctionThread("F");
        t6.start();

    }
}