package items;

import creatures.Creature;

public class Weapon extends Item {
    private int damage;
    private int range;
    private int currentAmmo;
    private int maxAmmo;
    private int ammoType;
    private double accuracy;

    public Weapon(String name, String description, int worth, int rarity, int damage, int range, int ammo, int ammoType,
                  double accuracy) throws InvalidRarityException
    {
        super(name, description, rarity, 1, worth, true);
        this.damage = damage;
        this.range = range;
        this.currentAmmo = ammo;
        this.maxAmmo = ammo;
        this.accuracy = accuracy;
        this.ammoType = ammoType;
    }

    public Weapon(String name, String description) throws InvalidRarityException
    {
        this(name, description, 0, 1, 10, 1, -1, -1, 0.5);
    }

    public int getAmmoType() { return ammoType; }

    public int getCurrentAmmo() { return currentAmmo; }

    public int getMaxAmmo() { return maxAmmo; }

    public boolean shoot(Creature creature) throws ReloadException {
        if (this.ammoType != -1) {
            if (this.currentAmmo == 0)
                throw new ReloadException("Need to reload " + this.name);
            else
                this.currentAmmo -= 1;
        }
        if (Math.random() > accuracy)
        {
            creature.damage(Math.max((int) (damage - (creature.getToughness() * 0.5)), 1));
            return true;
        }
        else
            return false;
    }

    public void reload(int amount)
    {
        currentAmmo += amount;
        if (currentAmmo > maxAmmo)
            currentAmmo = maxAmmo;
    }

    public void reload() { currentAmmo = maxAmmo;}

    public String toString() {
        String str = this.name;
        str += "\n" + this.description;
        if (this.ammoType == -1)
            str += "\nDamage: " + this.damage + " Worth: " + this.worth + " Rarity: " + this.getRarity();
        else
            str += "\nDamage: " + this.damage + " Current ammo: " + this.currentAmmo + " Max ammo: " + this.maxAmmo +
                " Worth: " + this.worth + " Rarity: " + this.getRarity();
        return str;
    }

}

class ReloadException extends RuntimeException {
    ReloadException(String s)
    {
        super(s);
    }
}
