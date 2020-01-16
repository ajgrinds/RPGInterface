import creatures.Enemy;
import creatures.NPC;
import creatures.Player;
import items.Weapon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello! What would you like to name the player?");
        //Scanner scan = new Scanner(System.in);
        Player player1 = new Player();
        NPC shop = new NPC("The God's Shop");
        shop.add(new Weapon("Sword", "A sword", 200, 1, 20, 1, -1, -1, 1));
        //System.out.println("Here is what " + shop.getName() + " has for sale: ");
        //System.out.println(shop);
        shop.buy(player1, 0);
        player1.equip(1);
        //System.out.println(player1.getBackpack());
        Enemy enemy1 = new Enemy("Enemy", 1, 100, 0, 10);
        System.out.println(player1.attack(enemy1));
        System.out.println(player1.getEquipped());
        System.out.println(enemy1.getCurrentHealth());
    }
}
