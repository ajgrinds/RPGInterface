package creatures;

import backpack.Backpack;
import items.Item;

import java.util.ArrayList;

public class NPC extends Creature {
    private Backpack forSale;

    public NPC(String name, int level, int health, int toughness, Backpack backpack)
    {
        super(name, level, health, health, toughness, 0);
        this.forSale = backpack;
    }

    public NPC(String name)
    {
        this(name, 1, 100, 10, new Backpack(100, new int[2]));
    }

    public Backpack getForSale() { return forSale; }
    public void add(Item item)
    {
        forSale.add(item);
    }
    public boolean buy(Player player, Item item)
    {
        if (player.buy(item))
        {
            forSale.remove(item);
            return true;
        }
        return false;
    }

    public boolean buy(Player player, int index)
    {
        return buy(player, this.forSale.get(index));
    }
    public String toString()
    {
        StringBuilder str = new StringBuilder();
        str.append(this.name).append("'s Shop:");
        for (int i = 0; i < forSale.getInside().size(); i++)
        {
            str.append(i + 1).append(". ").append(forSale.get(i).toString()).append("\n");
        }
        return str.toString();
    }
}
