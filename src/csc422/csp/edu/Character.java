package csc422.csp.edu;

import java.util.ArrayList;
import java.util.Set;

//12/4/2020 
//CSC 422 

//zombie war application
public abstract class Character
{
    //properties
    protected String type;
    private int attackDamage;
    private boolean isAlive;
    private int currentHealth;

    //default constructor used for subtypes
    //though this class cannot instantiate
    //should be the only one needed for all
    public Character(int startingHealth, int damageValue)
    {
        currentHealth = startingHealth;
        attackDamage = damageValue;
    }

    public String getType()
    {
        return type;
    }

    //methods
    public int getCurrentHealth()
    {
        return currentHealth;
    }

    public void setCurrentHealth(int newHealth)
    {
        this.currentHealth = newHealth;
    }

    public int getDamage()
    {
        return attackDamage;
    }

    public void setDamage(int damage)
    {
        this.attackDamage = damage;
    }

    public boolean getIsAlive()
    {
        return currentHealth > 0;
    }


    @Override
    public String toString()
    {
        return getType();
    }

    public void inflictDamage(Character target)
    {
        int damage = this.getDamage();
        int targetHealth = target.getCurrentHealth();
        target.setCurrentHealth(targetHealth - damage);
    }
}

