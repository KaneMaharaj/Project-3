import javax.swing.*;
import java.util.Random;
public class CharacterBattle {
    public static void main(String[] args) {
        Random randGen = new Random();

        String Name, Name2, Move, Move2;
        int hp,hp2,attack_speed,attack_speed2,move_power,move_power2,rounds,choice,random,p1counter,p2counter;

        p1counter = 0;
        p2counter = 0;
        rounds = Integer.parseInt(JOptionPane.showInputDialog("Enter an odd number of rounds"));
        if (rounds % 2 == 0) {
            JOptionPane.showMessageDialog(null, "Even number of rounds - invalid");
        }
        else {
            for (int i = 0; i < rounds; i++) {
                JOptionPane.showMessageDialog(null, "Odd number of rounds - Valid");
                JOptionPane.showMessageDialog(null, "Enter player 1 character stats");
                Name = JOptionPane.showInputDialog(null, "Enter player 1 character name: ");
                hp = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter hit points: "));
                Move = JOptionPane.showInputDialog(null, "Enter move: ");
                move_power = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter that move's power: "));
                attack_speed = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter that move's attack speed: "));
                JOptionPane.showMessageDialog(null, "Player 1 all set!");
                JOptionPane.showMessageDialog(null, "Enter player 2 character stats");
                Name2 = JOptionPane.showInputDialog(null, "Enter player 2 character name: ");
                hp2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter hit points: "));
                Move2 = JOptionPane.showInputDialog(null, "Enter move: ");
                move_power2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter that move's power: "));
                attack_speed2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter that move's attack speed: "));

                if (attack_speed > attack_speed2) {
                    JOptionPane.showMessageDialog(null, Name + " has an higher attack speed, " + Name + " attacks first!");
                    //At first i tried != but was having the same issue
                    while ((hp > 0) || (hp2 > 0)) {
                        hp2 = hp2 - move_power;
                        JOptionPane.showMessageDialog(null, Name + " hit " + Name2 + " with " + Move + "!");
                        JOptionPane.showMessageDialog(null, Name2 + " now has " + hp2 + " health left");
                        if (hp2 <= 0) {
                            JOptionPane.showMessageDialog(null, "Player 1 wins round");
                            p1counter = p1counter + 1;
                            break;
                        }
                        else {
                            hp = hp - move_power2;
                            JOptionPane.showMessageDialog(null, Name2 + " hit " + Name + " with " + Move2 + "!");
                            JOptionPane.showMessageDialog(null, Name + " now has " + hp + " health left");
                            if (hp <= 0) {
                                JOptionPane.showMessageDialog(null, "Player 2 wins round");
                                p2counter = p2counter + 1;
                                break;
                            }
                        }
                    }
                }
                else if (attack_speed < attack_speed2) {
                    JOptionPane.showMessageDialog(null, Name2 + " has an higher attack speed, " + Name2 + " attacks first!");
                    while ((hp > 0) || (hp2 > 0)) {
                        hp = hp - move_power2;
                        JOptionPane.showMessageDialog(null, Name2 + " hit " + Name + " with " + Move2 + "!");
                        JOptionPane.showMessageDialog(null, Name + " now has " + hp + " health left");
                        if (hp <= 0) {
                            JOptionPane.showMessageDialog(null, "Player 2 wins round");
                            p2counter = p2counter + 1;
                            //even without this hp = 0 statement it didnt work
                            break;
                        }
                        else {
                            hp2 = hp2 - move_power2;
                            JOptionPane.showMessageDialog(null, Name + " hit " + Name2 + " with " + Move + "!");
                            JOptionPane.showMessageDialog(null, Name2 + " now has " + hp2 + " health left");
                            if (hp2 <= 0) {
                                JOptionPane.showMessageDialog(null, "Player 1 wins round");
                                p1counter = p1counter + 1;
                                break;
                            }
                        }
                    }
                }
                else {
                    choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Attack speeds were even, player 1, choose a number 1 or 2"));
                    random = randGen.nextInt(2) + 1;
                    if (choice != random) {
                        JOptionPane.showMessageDialog(null, "It landed on " + choice);
                        JOptionPane.showMessageDialog(null, "Player 1 attacks first!");
                        while ((hp > 0) || (hp2 > 0)) {
                            hp2 = hp2 - move_power;
                            JOptionPane.showMessageDialog(null, Name + " hit " + Name2 + " with " + Move + "!");
                            JOptionPane.showMessageDialog(null, Name2 + " now has " + hp2 + " health left");
                            if (hp2 <= 0) {
                                JOptionPane.showMessageDialog(null, "Player 1 wins round");
                                p1counter = p1counter + 1;
                                break;
                            }
                            else {
                                hp = hp - move_power2;
                                JOptionPane.showMessageDialog(null, Name2 + " hit " + Name + " with " + Move2 + "!");
                                JOptionPane.showMessageDialog(null, Name + " now has " + hp + " health left");
                                if (hp <= 0) {
                                    JOptionPane.showMessageDialog(null, "Player 2 wins round");
                                    p2counter = p2counter + 1;
                                    break;
                                }
                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "It landed on " + random);
                        JOptionPane.showMessageDialog(null, "Player 2 attacks first!");
                        while ((hp > 0) || (hp2 > 0)) {
                            hp = hp - move_power2;
                            JOptionPane.showMessageDialog(null, Name2 + " hit " + Name + " with " + Move2 + "!");
                            JOptionPane.showMessageDialog(null, Name + " now has " + hp + " health left");
                            if (hp <= 0) {
                                JOptionPane.showMessageDialog(null, "Player 2 wins round");
                                p2counter = p2counter + 1;
                                break;
                            }
                            else {
                                hp2 = hp2 - move_power2;
                                JOptionPane.showMessageDialog(null, Name + " hit " + Name2 + " with " + Move + "!");
                                JOptionPane.showMessageDialog(null, Name2 + " now has " + hp2 + " health left");
                                if (hp2 <= 0) {
                                    JOptionPane.showMessageDialog(null, "Player 1 wins round");
                                    p1counter = p1counter + 1;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        JOptionPane.showMessageDialog(null, "The Final Scores:");
        JOptionPane.showMessageDialog(null,"Player 1: " + p1counter);
        JOptionPane.showMessageDialog(null,"Player 2: " + p2counter);
        if (p1counter > p2counter){
            JOptionPane.showMessageDialog(null,"Player 1 Wins!!!");
        }
        else{
            JOptionPane.showMessageDialog(null,"Player 2 Wins!!!");
        }
    }
}
