package csc422.csp.edu;

public class Tank extends Zombie
{
    public Tank(int startingHealth, int damageValue)
    {
        super(startingHealth, damageValue);
        type = "tank";
    }
}
