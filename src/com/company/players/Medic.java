package com.company.players;

import com.company.SuperAbility;
import com.company.boss.Boss;

import java.util.Random;

public class Medic extends Hero {
    public Medic(int health, int damage) {
        super(health, damage, SuperAbility.HEAL);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int isAbilityAvailable = new Random().nextInt(2);
        if (isAbilityAvailable == 1){
            for (int i = 0; i < heroes.length; i++) {
                if (this != heroes[i] && heroes[i].getHealth() > 0){
                    int randomHeal = new Random().nextInt(70);
                    heroes[i].setHealth(heroes[i].getHealth() + randomHeal);
                    System.out.println("Medic healed " + heroes[i].getClass().getSimpleName() + "on " + randomHeal);
                    break;
                }
            }
        }else {
            System.out.println("Medic didn't heal.");
        }
    }
}