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
		
		Thread r1 = new Thread( ()-> {
			robot[0].setSpeed(20);
			Random rand = new Random();
			int rand_int = rand.nextInt(50);
			for (int i = 0; i < robot.length; i++) {
				robot[0].move(rand_int);
				System.out.println(i);
			}
		});
		Thread r2 = new Thread( ()-> {
			robot[1].setSpeed(20);
			Random rand = new Random();
			int rand_int = rand.nextInt(50);
			for (int i = 0; i < robot.length; i++) {
				robot[1].move(rand_int);
				System.out.println(i);
			}
		});
		Thread r3 = new Thread( ()-> {
			robot[2].setSpeed(20);
			Random rand = new Random();
			int rand_int = rand.nextInt(50);
			for (int i = 0; i < robot.length; i++) {
				robot[2].move(rand_int);
				System.out.println(i);
			}
		});
		Thread r4 = new Thread( ()-> {
			robot[3].setSpeed(20);
			Random rand = new Random();
			int rand_int = rand.nextInt(50);
			for (int i = 0; i < robot.length; i++) {
				robot[3].move(rand_int);
				System.out.println(i);
			}
		});
		Thread r5 = new Thread( ()-> {
			robot[4].setSpeed(20);
			Random rand = new Random();
			int rand_int = rand.nextInt(50);
			for (int i = 0; i < robot.length; i++) {
				robot[4].move(rand_int);
				System.out.println(i);
			}
		});
		
		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();
	// 6. use a while loop to repeat step 5 until a robot has reached the top of the
	// screen.
		boolean gamerun = true;
		int winningrobot = 0;
		while (gamerun == true) {
			for (int i = 0; i < robot.length; i++) {
				if (robot[i].getY()<0) {
					gamerun = false;
					winningrobot = i;
					break;
				} else {
					r1.start();
					r2.start();
					r3.start();
					r4.start();
					r5.start();
				}
			}
		}
	// 7. declare that robot the winner and throw it a party!
		JOptionPane.showMessageDialog(null, winningrobot);
	// 8. try different races with different amounts of robots.

	// 9. make the robots race around a circular track.
	}
}
