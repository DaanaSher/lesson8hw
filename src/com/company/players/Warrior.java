package com.company.players;

import com.company.SuperAbility;
import com.company.boss.Boss;

import java.util.Random;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbility(Hero[] heroes, Boss boss) {
        int isAbilityAvailable = new Random().nextInt(2);
        if (isAbilityAvailable == 1){
            int bossDamage = boss.getDamage();
            boss.setHealth(boss.getHealth() - bossDamage);
            System.out.println("Warrior reverted boss damage.");
        }
        else {
            System.out.println("Warrior loosed his super ability.");
        }
    }
}