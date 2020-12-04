package csc422.csp.edu;

import java.util.ArrayList;

public abstract class Character {

    private int currentHealth;
    private int attackDamage;
    private boolean isAlive;

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void inflictDamage(Character target){
        // Code here
    }

    // Abstract Method
    public abstract void acquireTargets(ArrayList<Character> targets);

}
