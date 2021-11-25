package com.company.players;

import com.company.SuperAbility;
import com.company.boss.Boss;

import java.util.Random;

public class Golem extends Hero {
    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.REVERT_HALF_BOSS_DAMAGE);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int isAbilityAvailable = new Random().nextInt(2);
        if (isAbilityAvailable == 1){
            int halfBossDamage = boss.getDamage()/2;
            boss.setHealth(boss.getHealth() - (getDamage() + halfBossDamage));
            System.out.println("Golem reverted half boss damage.");
        } else {
            System.out.println("Golem loosed his super ability.");
        }
    }
}