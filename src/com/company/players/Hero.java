package com.company.players;

import com.company.SuperAbility;
import com.company.players.GameEntity;

public abstract class Hero extends GameEntity implements IHavingSuperAbility{

    private SuperAbility ability;

    public Hero(int health, int damage, SuperAbility ability) {
        super(health, damage);
        this.ability = ability;
    }
}
