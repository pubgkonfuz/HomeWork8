package General;

import game.*;

public class RPG_GAME {
    public static void start(){
        Boss boss = new Boss(700,50);
        Magic magic = new Magic(250,25, "MAG");
        Golem golem = new Golem(250,20,"Golem");
        Warrior warrior = new Warrior(250,25,"VOIN");
        Medik medik = new Medik(250,0,"MEDIK");
        Berserk berserk = new Berserk(210,23,"Bers");

        Hero[] heroes ={magic,golem,warrior,medik,berserk};
        printStatistics(boss, heroes);

        while (!isGameFinish(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static boolean isGameFinish(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won!!! ");
            return true;
        }

        boolean allHeroesDad = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDad = false;
                break;
            }
        }
        if (allHeroesDad){
            System.out.println("Boss wod!!!");
        }
        return allHeroesDad;
    }

    private static void round(Boss boss, Hero[] heroes){
        if (boss.getHealth() > 0){
            bossHits(boss, heroes);
        }

        heroesHits(boss,heroes);
        printStatistics(boss, heroes);

    }

    private static void printStatistics(Boss boss, Hero[] heroes){
        System.out.println("_________________");
        System.out.println("Boss health " + boss.getHealth() + " [" + boss.getDamage() + "]");

        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() + " health " + heroes[i].getHealth() +
                    " [" + heroes[i].getDamage() + "]");
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > boss.getDamage()){
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }else{
                heroes[i].setHealth(0);
            }
        }
    }
    private static void heroesHits(Boss boss, Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0){
                heroes[i].applySuperAbility(boss,heroes);
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

}
