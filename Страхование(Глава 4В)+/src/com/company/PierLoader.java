package com.company;

public class PierLoader implements Runnable {
    private Tunnel tunnel;
    private String shipType;

    public PierLoader(Tunnel tunnel, String shipType ) {     // погрузчик\разгрузчик на трап
        this.tunnel = tunnel;    // shipType это тип страховки
        this.shipType =shipType;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.currentThread().setName("Валютная операция "+shipType);

                //Time to load the goods
                Thread.sleep(500);
                Strachowka ship = tunnel.get(shipType);
                if(ship!=null)
                    while (ship.countCheck()){
                        Thread.sleep(100);
                        ship.add(20);
                        System.out.println(ship.getCount() + " начисление денег. " + Thread.currentThread().getName());
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
