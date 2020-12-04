//12/4/2020
//CSC 422
//zombie war application

import java.util.ArrayList;

public abstract class Survivor extends Character
{

    public Survivor(int startingHealth, int damageValue)
    {
        super(startingHealth, damageValue);
    }

    public static ArrayList<Character> createRandomSurvivors() throws Exception
    {
        ArrayList<Character> list = new ArrayList<>();

        //(min + (int) (Math.random() * ((max - min) + 1)))
        int number = (int) (Math.random() * 15);
        number += 6;

        while (number >= 0)
        {
            //create a random zombie
            int type = (int) (Math.random() * 3) + 1;

            switch (type)
            {
                case 1:
                    list.add(new Soldier(100, 10));
                    break;
                case 2:
                    list.add(new Teacher(50, 5));
                    break;
                case 3:
                    list.add(new Child(20, 2));
                    break;
                default:
                    throw new Exception("not implemented");
            }
            number--;
        }
        return list;
    }
}
