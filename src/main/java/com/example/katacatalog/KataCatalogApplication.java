package com.example.katacatalog;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KataCatalogApplication {

    public static void main(String[] args) {

        Character pepe= new Character();
        Character moni= new Character();

        pepe.attack(500);
        moni.attack(500);

        pepe.heal(600);

        System.out.println(pepe);
        System.out.println(moni);
    }

}
