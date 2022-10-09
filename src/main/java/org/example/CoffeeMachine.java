package org.example;

import java.util.Scanner;

public class CoffeeMachine {

    int water = 400;
    int milk = 540;
    int beans = 120;
    int cups = 9;
    int money = 550;

    public static void main(String[] args) {

        CoffeeMachine cm = new CoffeeMachine();
        cm.initInteractiveMode();
    }

    private void initInteractiveMode(){
        //print();

        Scanner scanner = new Scanner(System.in);
        boolean ifContinue = false;
        while(!ifContinue) {
            System.out.println();
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            //  System.out.print("> ");
            String action = scanner.next();
            ifContinue = modifyState(action, scanner);
        }
        scanner.close();
    }

    private boolean modifyState(String action, Scanner scanner) {
        switch (action) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                String typeOfCoffee = scanner.next();
                switch (typeOfCoffee) {
                    case "1":
                        buyCoffee(250, 0, 16, 4);
                        break;
                    case "2":
                        buyCoffee(350, 75, 20, 7);
                        break;
                    case "3":
                        buyCoffee(200, 100, 12, 6);
                        break;
                }

                System.out.println();
                //print();
                break;

            case "fill":
                System.out.println("Write how many ml of water do you want to add: ");
                System.out.print("> ");
                this.water += scanner.nextInt();

                System.out.println("Write how many ml of milk do you want to add: ");
                System.out.print("> ");
                this.milk += scanner.nextInt();

                System.out.println("Write how many grams of coffee beans do you want to add:");
                System.out.print("> ");
                this.beans += scanner.nextInt();

                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                System.out.print("> ");
                this.cups += scanner.nextInt();

                System.out.println();
                //print();
                break;

            case "take":
                System.out.println("I gave you " + this.money);
                System.out.println();
                this.money = 0;
                System.out.println();
                //print();
                break;

            case "remaining":
                System.out.println();
                print();
                break;

            case "exit":
                return true;

            default:
                break;
        }

        return false;
    }

    private void buyCoffee(int water, int milk, int beans, int moneyCost) {
        if (this.water >= water && this.milk >= milk && this.beans >= beans) {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= water;
            this.milk -= milk;
            this.beans -= beans;
            this.money += moneyCost;
            this.cups -= 1;
        } else {
            System.out.println("Sorry, not enough " + (this.water - water < 0 ? "water" : this.milk - milk < 0 ? "milk": this.beans - beans < 0 ? "beans": this.cups - cups < 0 ? "cups" : "") + "!");
        }
    }


    private void print() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " ml of water");
        System.out.println(this.milk + " ml of milk");
        System.out.println(this.beans + " g of coffee beans");
        System.out.println(this.cups + " disposable cups");
        System.out.println("$" + this.money + " of money");
    }
}
