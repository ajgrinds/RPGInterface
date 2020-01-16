package creatures;

public abstract class Creature {
    String name;
    int maxHealth;
    int currentHealth;
    int level;
    int toughness;
    int attack;

    public Creature(String name, int level, int currentHealth, int maxHealth, int toughness, int attack)
    {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.level = level;
        this.toughness = toughness;
        this.attack = attack;
    }

    public boolean isDead() { return currentHealth <= 0; }
    public String getName() { return name; }
    public int getMaxHealth() { return maxHealth; }
    public int getCurrentHealth() { return currentHealth; }
    public int getLevel() { return level; }
    public int getToughness() { return toughness; }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean damage(int amount)
    {
        this.currentHealth -= amount;
        return this.isDead();
    }
}
