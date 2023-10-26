package org.example;

interface Arayuz1 {
    void metot1();

    void metot2();
}

class Sinif1 implements Arayuz1 {

    @Override
    public void metot1() {
        String sonuc = String.format("Sinif %d, metod %d", 1, 1);
        System.out.println(sonuc);
    }

    @Override
    public void metot2() {
        String sonuc = String.format("Sinif %d, metod %d", 1, 2);
        System.out.println(sonuc);
    }
}

class Sinif2 implements Arayuz1 {

    @Override
    public void metot1() {
        String sonuc = String.format("Sinif %d, metod %d", 2, 1);
        System.out.println(sonuc);
    }

    @Override
    public void metot2() {
        String sonuc = String.format("Sinif %d, metod %d", 2, 2);
        System.out.println(sonuc);
    }
}


abstract class Karisik<C extends Arayuz1> {
    private final C client;

    Karisik(C client) {
            this.client = client;
        }

    public void abstractMetod1() {
        client.metot1();
        System.out.println("Abstract çalıştı");
        }
}

class karisikSinif1 extends Karisik<Sinif1> {

    karisikSinif1(Sinif1 client) {
        super(client);
    }
}

class karisikSinif2 extends Karisik<Sinif2> {

    karisikSinif2(Sinif2 client) {
        super(client);
    }
}



public class Main {
    public static void main(String[] args) {

        karisikSinif1 karisikSinif1Instance = new karisikSinif1(new Sinif1());

        karisikSinif1Instance.abstractMetod1();

        karisikSinif2 karisikSinif2Instance = new karisikSinif2(new Sinif2());

        karisikSinif2Instance.abstractMetod1();
    }
}