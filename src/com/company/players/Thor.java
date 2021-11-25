package com.company.players;

import com.company.SuperAbility;
import com.company.boss.Boss;

import java.util.Random;

public class Thor extends Hero{
    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.STUN);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int isAbilityAvailable = new Random().nextInt(2);
        if (isAbilityAvailable == 1) {
            boss.setDamage(0);
            System.out.println("Thor stunned the boss.");
        }else{
            System.out.println("Thor loosed his super ability.");
        }
    }
}
