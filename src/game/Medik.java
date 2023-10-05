package game;

public class Medik extends Hero {
    public Medik(int health, int damage, String name) {
        super(health, damage, SuperAbility.HEAL, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        int heal = 50;
        for (int i = 0; i < heroes.length; i++) {
            if (!heroes[i].getName().equals(this.getName()) && this.getHealth() > 0 && heroes[i].getHealth() > 0 && heroes[i].getHealth() < 100) {
                heroes[i].setHealth(heroes[i].getHealth() + 10);
                System.out.println(getName() + " ЛЕЧИТ " + heroes[i].getName());
                break;
            }
        }
    }
}


