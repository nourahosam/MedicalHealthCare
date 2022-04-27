/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.util.Scanner;

/**
 *
 * @author usfng
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int num1, num2, choice;
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter 1st number:");
        num1 = sc.nextInt();

        System.out.print("Please enter 2nd number:");
        num2 = sc.nextInt();

        System.out.println("For adding enter 1.\nFor Subtracting enter 2");
        choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("The result is " + new Calculator().add(num1, num2));
        } else if (choice == 2) {
            System.out.println("The result is " + new Calculator().sub(num1, num2));
        }
    }
}
