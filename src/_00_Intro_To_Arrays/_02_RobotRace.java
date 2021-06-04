package _00_Intro_To_Arrays;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class _02_RobotRace {
	// 1. make a main method
	public static void main(String[] args) {
	// 2. create an array of 5 robots.
		Robot[] robot = new Robot[5];
	// 3. use a for loop to initialize the robots.
		for (int i = 0; i < robot.length; i++) {
			robot[i] = new Robot();
		}
	// 4. make each robot start at the bottom of the screen, side by side, facing up
		robot[0].setY(500);
		robot[0].setX(100);
		robot[1].setY(500);
		robot[1].setX(250);
		robot[2].setY(500);
		robot[2].setX(400);
		robot[3].setY(500);
		robot[3].setX(550);
		robot[4].setY(500);
		robot[4].setX(700);
	// 5. use another for loop to iterate through the array and make each robot move
	// a random amount less than 50.
		for (int i = 0; i < robot.length; i++) {
			robot[i].setSpeed(20);
		}
		Random rand = new Random();
		int rand_int = rand.nextInt(50);
		for (int i = 0; i < robot.length; i++) {
			robot[i].move(rand_int);
			System.out.println(i);
		}
	// 6. use a while loop to repeat step 5 until a robot has reached the top of the
	// screen.
		boolean gamerun = true;
		int winningrobot = -1;
		while (gamerun == true) {
			for (int i = 0; i < robot.length; i++) {
				rand_int = rand.nextInt(50);
				robot[i].move(rand_int);
				if (robot[i].getY()<0) {
					gamerun = false;
					winningrobot = i+1;
					break;
				}
			}
		}
	// 7. declare that robot the winner and throw it a party!
		JOptionPane.showMessageDialog(null, winningrobot);
	// 8. try different races with different amounts of robots.

	// 9. make the robots race around a circular track.
	}
}
