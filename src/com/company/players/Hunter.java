package com.company.players;

import com.company.SuperAbility;
import com.company.boss.Boss;

import java.util.Random;

public class Hunter extends Hero {
    public Hunter(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int isAbilityAvailable = new Random().nextInt(2);
        if (isAbilityAvailable == 1){
            int randomDamage = new Random().nextInt(16);
            setDamage(getDamage() + randomDamage);
            System.out.println("Hunter's damage upped for: " + randomDamage);
        }
        else {
            System.out.println("Hunter loosed his super ability");
        }
    }
}
