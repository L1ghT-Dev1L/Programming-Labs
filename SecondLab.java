package com.company.SecondLab;
import ru.ifmo.se.pokemon.*;

public class SecondLab{

    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Eevee("1", 1);
        Pokemon p2 = new Sigilyph("2", 1);
        Pokemon p3 = new Flareon("3", 1);
        Pokemon p4 = new Charmander("4", 1);
        Pokemon p5 = new Charmeleon("5", 1);
        Pokemon p6 = new Charizard("6", 1);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }

}