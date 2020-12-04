package csc422.csp.edu;

//12/4/2020 
//CSC 422 
//zombie war application

public class Child extends Survivor
{
    public Child(int startingHealth, int damageValue)
    {
        super(startingHealth, damageValue);
        type = "child";
    }
}
