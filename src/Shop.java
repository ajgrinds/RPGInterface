import creatures.Player;
import items.Item;

import java.util.ArrayList;

public class Shop {
    private String name;
    private ArrayList<Item> forSale;

    public Shop(String name)
    {
        this(name, new ArrayList<>());
    }


    public Shop(String name, ArrayList<Item> forSale)
    {
        this.name = name;
        this.forSale = forSale;
    }

    public ArrayList<Item> getForSale() { return forSale; }
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
        for (Item x: forSale)
        {
            str.append(x.toString()).append("\n\n");
        }
        return str.toString();
    }
}
