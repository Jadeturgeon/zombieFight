package csc422.csp.edu;

//12/4/2020 
//CSC 422 
//zombie war application

public class CommonInfect extends Zombie
{
    public CommonInfect(int startingHealth, int damageValue)
    {
        super(startingHealth, damageValue);
        type = "common infect";
    }
}
