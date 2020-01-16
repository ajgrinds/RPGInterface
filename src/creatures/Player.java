package creatures;

import backpack.Backpack;
import items.Item;
import items.Weapon;

public class Player extends Creature{
    private int hunger;
    private int money;
    private Backpack backpack;
    private Weapon equipped;

    public Player(String name, int level, int money, int health, int hunger, int toughness, int attack,
                  Backpack backpack, Weapon equipped) {
        super(name, level, health, health, toughness, attack);
        this.money = money;
        this.hunger = hunger;
        this.backpack = backpack;
        if (!backpack.contains(equipped))
            this.backpack.add(equipped);
        this.equipped = equipped;
    }

    public Player(String name)
    {
        this(name, 1, 100, 0, 0, 0, 0,
                new Backpack(20 , new int[]{0, 0}),
                new Weapon("Sword", "The default, basic sword", 10, 1,10,
                        1, -1, -1, 0.5)
        );
    }

    public Player(String name, Weapon weapon)
    {
        this(name, 1, 100, 0, 0, 0, 0,
                new Backpack(20 , new int[]{0, 0}),
                weapon);
    }

    public Player()
    {
        this("Player", 1, 100, 0, 0, 0, 0,
                new Backpack(20, new int[]{0, 0}),
                new Weapon("Sword", "The default, basic sword", 10, 1,10,
                        1, -1, -1, 0.5)
        );
    }

    public int getMoney() { return this.money; }

    public Backpack getBackpack() { return this.backpack; }

    public void heal(int amount) {
        this.currentHealth += amount;
        if (this.currentHealth > this.maxHealth)
        {
            this.currentHealth = this.maxHealth;
        }
    }

    public void levelUp()
    {
        this.level++;
        this.maxHealth *= 1.1;
        this.attack *= 1.1;
        this.toughness *= 1.1;
        this.currentHealth = this.maxHealth;
        this.hunger = 0;
    }

    public void chargeMoney(int amount) { this.money -= amount; }

    private boolean canBuy(Item item) {
        return item.getWorth() > this.money && this.backpack.hasSpace();
    }

    public boolean buy(Item item) {
        if (this.canBuy(item)) {
            this.chargeMoney(item.getWorth());
            this.backpack.add(item);
            return true;
        } else
            return false;
    }

    public boolean reload()
    {
       if (this.equipped.getAmmoType() == -1)
       {
           this.equipped.reload();
           return true;
       }
       if (this.backpack.getAmmo()[this.equipped.getAmmoType()] == 0)
            return false;
       if (this.equipped.getMaxAmmo() - this.equipped.getCurrentAmmo() >
               this.backpack.getAmmo()[this.equipped.getAmmoType()])
        {
            this.equipped.reload(this.backpack.getAmmo()[this.equipped.getAmmoType()]);
            this.backpack.setAmmo(0, this.equipped.getAmmoType());
        }
       else {
           this.equipped.reload();
           this.backpack.changeAmmo(this.equipped.getMaxAmmo() - this.equipped.getCurrentAmmo(),
                   this.equipped.getAmmoType());
       }
       return true;
    }

    public boolean equip(Weapon weapon)
    {
        if (backpack.contains(weapon))
        {
            equipped = weapon;
            return true;
        }
        else
            return false;
    }

}
