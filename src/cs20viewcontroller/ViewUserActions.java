/*
 * The controller classes (like the ViewUserActions class) provides actions
 * that the user can trigger through the view classes.  Those actions are 
 * written in this class as private inner classes (i.e. classes 
 * declared inside another class).
 *
 * You can use all the public instance variables you defined in AllModelsForView, 
 * DrawnView, and ViewOutputs as though they were part of this class! This is 
 * due to the magic of subclassing (i.e. using the extends keyword).
 */
package cs20viewcontroller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ViewUserActions is a class that contains actions users can trigger.
 *
 * User actions are written as private inner classes that implements the
 * ActionListener interface. These actions must be "wired" into the DrawnView in
 * the ViewUserActions constructor, or else they won't be triggered by the user.
 *
 * Actions that the user can trigger are meant to manipulate some model classes
 * by sending messages to them to tell them to update their data members.
 *
 * Actions that the user can trigger can also be used to manipulate the GUI by
 * sending messages to the view classes (e.g. the DrawnView class) to tell them
 * to update themselves (e.g. to redraw themselves on the screen).
 *
 * @author cheng
 */
public class ViewUserActions extends ViewOutputs {
    //Work Class
    public class Work implements ActionListener {
        
        public int number;

        public Work (int number){
            this.number = number;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if (calwork.getState().equals("first")){
                String newNumber = Integer.toString(this.number);
                calwork.setFirst(newNumber);
                updateDisplay();
            }else if (calwork.getState().equals("second")){
                String newNumber = Integer.toString(this.number);
                calwork.setSecond(newNumber);
                updateDisplay();
            }
            
        }
    }
    
    //Sign Class
    public class Sign implements ActionListener{
        
        public int sign;
        
        public Sign(int type){
            this.sign = type;
        }
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            calwork.setSign(sign);
            signDisplay();
        }
    }
    //Equals Class
    public class Equals implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            calwork.setfinal();
            calwork.setState("end");
            finDisplay();
        }
    }
    
    public class Clear implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ae) {
            calwork.firstNum = 0;
            calwork.secNum = 0;
            calwork.state = "first";
            calwork.setSign(4);
            clearDisplay();
        }
    }

    public ViewUserActions() {
        //Numbers
        numOne.addActionListener(new Work(1));
        numTwo.addActionListener(new Work(2));
        numThree.addActionListener(new Work(3));
        numFour.addActionListener(new Work(4));
        numFive.addActionListener(new Work(5));
        numSix.addActionListener(new Work(6));
        numSeven.addActionListener(new Work(7));
        numEight.addActionListener(new Work(8));
        numNine.addActionListener(new Work(9));
        numZero.addActionListener(new Work(0));
        //Buttons
        addButton.addActionListener(new Sign(0));
        subButton.addActionListener(new Sign(1));
        multiButton.addActionListener(new Sign(2));
        divideButton.addActionListener(new Sign(3));
        equalsButton.addActionListener(new Equals());
        clearButton.addActionListener(new Clear());
    }
}
