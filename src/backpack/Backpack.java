package backpack;

import items.Item;
import items.Weapon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Backpack {
    private int size;
    private int[] ammo;
    private ArrayList<Item> inside;

    public Backpack(int size, int[] ammo) {
        this.size = size;
        this.inside = new ArrayList<>();
        this.ammo = ammo;
    }

    public boolean contains(Item item) {
        return inside.contains(item);
    }

    public Item remove(Item item) throws InvalidItemException {
        if (!this.contains(item)) {
            throw new InvalidItemException(item.getName() + " not in backpack");
        } else {
            return inside.remove(inside.indexOf(item));
        }
    }

    public boolean hasSpace() { return this.inside.size() < this.size; }

    public boolean add(Item item) {
        if (this.inside.size() >= this.size) {
            return false;
        } else {
            this.inside.add(item);
            return true;
        }
    }

    public Item get(int index) { return this.inside.get(index); }

    public int[] getAmmo() { return ammo; }

    public void setAmmo(int ammo, int type) { this.ammo[type] = ammo; }

    public void changeAmmo(int ammo, int type) { this.ammo[type] += ammo; }

    public ArrayList<Item> getInside() { return inside; }

    public List<Item> getWeapons()
    {
        return this.inside.stream().filter(item -> item instanceof Weapon).collect(Collectors.toList());
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Item x: inside)
        {
            str.append(x.toString()).append("\n\n");
        }
        return str.toString();
    }
}

class InvalidItemException extends RuntimeException {
    InvalidItemException(String s)
    {
        super(s);
    }
}
