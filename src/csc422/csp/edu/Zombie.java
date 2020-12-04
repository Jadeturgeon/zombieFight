import java.util.ArrayList;
 
//12/4/2020 
//CSC 422 
//zombie war application

public abstract class Zombie extends Character
{
    public Zombie(int startingHealth, int damageValue)
    {
        super(startingHealth, damageValue);
    }

    public static ArrayList<Character> createRandomZombies() throws Exception
    {
        ArrayList<Character> list = new ArrayList<>();

        //(min + (int) (Math.random() * ((max - min) + 1)))
        int number = (int) (Math.random() * 13);
        number += 3;

        while (number >= 0)
        {
            //create a random zombie
            int type = (int) (Math.random() * 2) + 1;

            switch (type)
            {
                case 1:
                    list.add(new Tank(150, 20));
                    break;
                case 2:
                    list.add(new CommonInfect(30, 5));
                    break;
                default:
                    throw new Exception("not implemented");
            }
            number--;
        }
        return list;
    }
}
