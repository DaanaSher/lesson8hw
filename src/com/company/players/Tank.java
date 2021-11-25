package com.company.players;

import com.company.SuperAbility;
import com.company.boss.Boss;

import java.util.Random;

public class Tank extends Hero{
    public Tank(int health, int damage) {
        super(health, damage, SuperAbility.TANK_ABILITY);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int isAbilityAvailable = new Random().nextInt(2);
        if (isAbilityAvailable == 1){
            int halfBossDamage = boss.getDamage()/5;
            boss.setDamage(halfBossDamage);
            System.out.println("Tank used his super ability");
        }else {
            System.out.println("Tank loosed his super ability.");
        }
    }
}
