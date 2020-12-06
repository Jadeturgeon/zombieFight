//ZombieWar.java

import java.util.Random;

public class ZombieWar {
   
   private static final int MAX = 6;
   private static final Random random = new Random();
   
   
   private Character[] survivors;
   private Character[] zombies;
   private int childNum;
   private int teacherNum;
   private int soldierNum;
   private int cInfectedNum;
   private int tankNum;
   
   
   public ZombieWar() {
       //number of surviors and of zombies
       childNum = random.nextInt(MAX);
      
       // how many Teachers? Soldiers? Commoninfected? Tanks? 
       teacherNum = random.nextInt(MAX);
      
       
       soldierNum = random.nextInt(MAX);
      
      
       cInfectedNum = random.nextInt(MAX);
      
      
       tankNum = random.nextInt(MAX);
      
       // (childNum + teacherNum + soldierNum) Who survived?
       getSurvivor();
      
       // Zombies Effected
       getZombie();
      
       
       print();
   }
   
   
   private void getSurvivor() {
       survivors = new Survivor[childNum + teacherNum + soldierNum];
       int i = 0;
      
       // How many Children 
       for (i = 0; i < childNum; i++)
           survivors[i] = new Child();
      
       // How many Teachers effected
       for (; i < childNum + teacherNum; i++)
           survivors[i] = new Teacher();
      
       // Soldiers total 
       for (; i < childNum + teacherNum + soldierNum; i++)
           survivors[i] = new Soldier();
   }
   

   private void getZombie() {
       zombies = new Zombie[cInfectedNum + tankNum];
       int i = 0;
      
       //number of Common Infected
       for (i = 0; i < cInfectedNum; i++)
           zombies[i] = new CommonInfected();
      
       // Number of Tanks
       for (; i < cInfectedNum + tankNum; i++)
           zombies[i] = new Tank();
   }
   
   
   private void print() {
       // Print Outcome
       System.out.println("We have " + survivors.length + " survivors trying to make it to safety (" + childNum
               + " children, " + teacherNum + " teachers, " + soldierNum + " soldiers)");
       System.out.println("But there are " + zombies.length + " zombies waiting for them (" + cInfectedNum
               + " common infected, " + tankNum + " tanks)");
   }
   
   
   private int getCharacterIndex(Character c, int index) {
       if (c instanceof CommonInfected)
           return (index % cInfectedNum);
       else if (c instanceof Tank)
           return (index % tankNum);
       else if (c instanceof Child)
           return (index % childNum);
       else if (c instanceof Teacher)
           return (index % teacherNum);
       else if (c instanceof Soldier)
           return (index % soldierNum);
       else
           return -1;
   }
   


   private static int safeCount(Character[] characters) {
       int safe = 0;
       for (Character c : characters) {
           
           if (!c.isDead())
               safe += 1;
       }
      
       // Who Survived
       return safe;
   }
   
   
   private void attack(Character[] attacker, Character[] attackee) {
       for (int i = 0; i < attacker.length; i++) {
           
           Character c1 = attacker[i];
         
           for (int j = 0; j < attackee.length; j++) {
               
               Character c2 = attackee[j];
               
               
               if (!c1.isDead() && !c2.isDead()) {
                   c1.attack(c2); 
                  
                   
                   if (c2.isDead())
                       System.out.println("\t" + c1 + " " + getCharacterIndex(c1, i) + " killed " + c2 + " " + getCharacterIndex(c2, j));
               }
           }
       }
   }
   
   
   private void war() {
       while ((safeCount(survivors) > 0) && (safeCount(zombies) > 0)) {
           //Survivor must attack zombie
           attack(survivors, zombies);
         
           //verse zombie attacks survivors
           attack(zombies, survivors);
       }
      
       
       warResult();
   }
   
   
   private void warResult() {
       // Who survived? Count
       int survivorCount = safeCount(survivors);
       if (survivorCount == 0)
           System.out.println("None of the survivors made it.");
       else
           System.out.println("It seems " + survivorCount + " have made it to safety.");
   }
   
   public static void main(String[] args) {
      
      
       ZombieWar zombieWar = new ZombieWar();
      
       
       zombieWar.war();
   }
}

