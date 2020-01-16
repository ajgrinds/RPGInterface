package items;

public abstract class Item {
    String name;
    String description;
    int size;
    int worth;
    int rarity;
    boolean equipable;
    private String[] rarities = {"Normal", "Common", "Uncommon", "Rare", "Epic", "Legendary"};
    // 0 is normal, 1 is common, 2 is uncommon, 3 is rare, 4 is epic and 5 is legendary

    public Item(String name, String description, int rarity, int size, int worth, boolean equipable) throws InvalidRarityException {
        this.name = name;
        this.description = description;
        this.size = size;
        this.worth = worth;
        this.equipable = equipable;
        if (rarity < 0 || rarity > 5)
        {
            throw new InvalidRarityException("Rarity " + rarity + " must be between 0 and 5 for item " + name);
        }
        this.rarity = rarity;
    }

    public boolean equals(Item that)
    {
        return this.name.equals(that.getName()) && this.description.equals(that.getDescription()) &&
                this.size == that.getSize() && this.worth == that.getWorth() &&
                this.getRarity().equals(that.getRarity());
    }

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public int getSize() { return this.size; }
    public int getWorth() { return this.worth; }
    public String getRarity() { return rarities[this.rarity]; }
    public boolean getEquipable() { return this.equipable; }
}


class InvalidRarityException extends RuntimeException
{
    InvalidRarityException(String s)
    {
        super(s);
    }
}