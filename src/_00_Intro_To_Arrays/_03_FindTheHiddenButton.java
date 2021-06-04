package _00_Intro_To_Arrays;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jointheleague.graphical.robot.Robot;

/* Run the FindHiddenButton.jar to see the finished product. */

public class _03_FindTheHiddenButton implements ActionListener{
    JFrame window;
    JPanel panel;

    // 1. create an array of JButtons. Don't initialize it yet.
    JButton[] buttons;
    // 2. create an integer variable called hiddenButton
    int hiddenButton;
    public static void main(String[] args) {
        new _03_FindTheHiddenButton().start();
    }

    public void start() {
        window = new JFrame("Find the Button");
        panel = new JPanel();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Ask the user to enter a positive number and convert it to an int
        String userint = JOptionPane.showInputDialog("Enter a positive number");
        int b = Integer.parseInt(userint);
        // 4. Initialize the array of JButtons to be the size of the int
        //    created in step 3
        buttons = new JButton[b];
        // 5. Make a for loop to iterate through the JButton array
        	for (int i = 0; i < buttons.length; i++) {
            // 6. initialize each JButton in the array
        		buttons[i] = new JButton();
        		buttons[i].setPreferredSize(new Dimension(90,50));
            // 7. add the ActionListener to each JButton
        		buttons[i].addActionListener(this);
            // 8. add each JButton to the panel
        		panel.add(buttons[i]);
        	}
        // 9 add the panel to the window
        	window.add(panel);
        // 10. call setExtendedState(JFrame.MAXIMIZED_BOTH) on your JFrame object.
        	window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        	window.setPreferredSize(new Dimension(1000,600));
        // 11. set the JFrame to visible.
        	window.setVisible(true);
        	window.pack();
        // 12. Give the user the instructions for the game.
        	//JOptionPane.showMessageDialog(null, "instructions");
        // 13. initialize the hiddenButton variable to a random number less than
        //     the int created in step 3
        	Random rand = new Random();
    		int rand_int = rand.nextInt(b);
        	hiddenButton = rand_int;
        // 14. Set the text of the JButton located at hiddenButton to read "ME"
        	buttons[hiddenButton].setText("ME");
        // 15. Use Thread.sleep(100); to pause the program.
        	try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        // 16. Set the text of the JButton located at hiddenButton to be blank.
        	buttons[hiddenButton].setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton)e.getSource();

        // 17. if the hiddenButton is clicked, tell the user that they win.
        if(buttons[hiddenButton] == buttonClicked) {
        	JOptionPane.showMessageDialog(null, "WOW YOU WON");
        }
        // 18. else tell them to try again
        else {
        	JOptionPane.showMessageDialog(null, "try again");
        }
    }
}
