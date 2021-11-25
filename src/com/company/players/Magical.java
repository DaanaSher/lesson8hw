package com.company.players;

import com.company.SuperAbility;
import com.company.boss.Boss;

import java.util.Random;

public class Magical extends Hero {
    public Magical(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int isAbilityAvailable = new Random().nextInt(2);
        if (isAbilityAvailable == 1){
            for (int i = 0; i < heroes.length; i++) {
                if (!heroes[i].getClass().getSimpleName().equals("Medic")){
                    int randomHero = new Random().nextInt(heroes.length - 1);
                    int randomDamage = new Random().nextInt(13);
                    heroes[randomHero].setDamage(heroes[randomHero].getDamage()
                            + randomDamage);
                    System.out.println("Magical boosted " + heroes[randomHero].getClass().getSimpleName() + " on " + randomDamage);
                    break;
                }
            }
        }
        else {
            System.out.println("Magical loosed his super ability.");
        }
    }
}
