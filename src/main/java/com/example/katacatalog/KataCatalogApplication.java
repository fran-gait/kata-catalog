package com.example.katacatalog;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KataCatalogApplication {

    public static void main(String[] args) {

        Character pepe= new Character();
        Character moni= new Character();

        pepe.toDamage(500);
        moni.toDamage(500);

        pepe.toHeal(600);

        System.out.println(pepe);
        System.out.println(moni);
    }

}
