import creatures.Player;
import items.Weapon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello! What would you like to name the player?");
        Scanner scan = new Scanner(System.in);
        Player player1 = new Player(scan.nextLine());
        Shop shop = new Shop("The God's Shop");
        shop.add(new Weapon("Sword", "A sword", 200, 1, 10, 1, -1, -1, 0.5));
        System.out.println(shop);
        shop.buy(player1, shop.getForSale().get(0));
        System.out.println(player1.getBackpack());
    }
}
