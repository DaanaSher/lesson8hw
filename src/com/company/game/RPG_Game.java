package com.company.game;

import com.company.boss.Boss;
import com.company.players.*;

public class RPG_Game {
    private static int roundCounter = 1;

    public static void start(){
        Boss boss = new Boss(700,50);
        Hunter hunter = new Hunter(250, 20);
        Magical magical = new Magical(240, 20);
        Medic medic = new Medic(230, 0);
        Warrior warrior = new Warrior(250, 25);
        Golem golem = new Golem(250, 10);
        Thor thor = new Thor(250, 20);
        Tank tank = new Tank(300, 10);
        Hero heroes[] = {hunter, medic, warrior, golem, thor, tank, magical};
        printStatistics(heroes, boss);

        while (!isFinish(heroes, boss)){
            roundCounter++;
            round(heroes, boss);
        }
    }

    private static void printStatistics(Hero heroes[], Boss boss){
        System.out.println("---");
        System.out.println("Round: " + roundCounter);
        System.out.println("Boss health: " + boss.getHealth());
        for (Hero hero : heroes){
            System.out.println(hero.getClass().getSimpleName() + "health: " + hero.getHealth());
        }
        System.out.println("---");
    }

    private static void bossHits(Hero heroes[], Boss boss){
        for (Hero hero : heroes){
            if (hero.getHealth() > 0){
                hero.setHealth(hero.getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHits(Hero heroes[], Boss boss){
        for (Hero hero : heroes){
            if (boss.getHealth() > 0 && hero.getHealth() > 0){
                boss.setHealth(boss.getHealth() - hero.getDamage());
            }
        }
    }

    private static boolean isFinish(Hero heroes[], Boss boss){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes){
            if (hero.getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead){
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void round(Hero heroes[], Boss boss){
        if (boss.getHealth() > 0){
            bossHits(heroes, boss);
        }

        heroesHits(heroes, boss);
        applyAbility(heroes, boss);
        printStatistics(heroes, boss);
    }

    private static void applyAbility(Hero heroes[], Boss boss){
        for (Hero hero : heroes){
            if (hero.getHealth() > 0){
                hero.applySuperAbility(heroes, boss);
            }
        }
    }
}