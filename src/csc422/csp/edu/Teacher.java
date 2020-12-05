package csc422.csp.edu;

//12/4/2020 
//CSC 422 
//zombie war application

public class Teacher extends Survivor
{
    public Teacher(int startingHealth, int damageValue)
    {
        super(startingHealth, damageValue);
        type = "teacher";
    }
}
