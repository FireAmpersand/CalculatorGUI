package cs20viewcontroller;

/**
 * Write methods in this class for displaying data in the DrawnView.
 *
 * You can use all the public instance variables you defined in AllModelsForView
 * and DrawnView as though they were part of this class! This is due to the
 * magic of subclassing (i.e. using the extends keyword).
 *
 * The methods for displaying data in the DrawnView are written as methods in
 * this class.
 *
 * Make sure to use these methods in the ViewUserActions class though, or else
 * they will be defined but never used!
 *
 * @author cheng
 */
public class ViewOutputs extends DrawnView {

    public void updateDisplay() {
        if (calwork.getState().equals("first")) {
            String number = Integer.toString(calwork.firstNum);
            display.setText(number);
        } else if (calwork.getState().equals("second")) {
            String oldNumber = Integer.toString(calwork.firstNum);

            String sign = "";
            if (calwork.sign == 0) {
                sign = "+";
            } else if (calwork.sign == 1) {
                sign = "-";
            }else if (calwork.sign == 2){
                sign = "*";
            }else if (calwork.sign == 3){
                sign = "/";
            }

            String number = Integer.toString(calwork.secNum);
            display.setText(oldNumber + sign + number);
        } else if (calwork.state.equals("end")) {
            String number = Integer.toString(calwork.finNum);
            display.setText(number);
        }
    }

    public void signDisplay() {
        if (calwork.sign == 0) {
            String number = Integer.toString(calwork.getFirst());
            display.setText(number + "+");
        } else if (calwork.sign == 1) {
            String number = Integer.toString(calwork.getFirst());
            display.setText(number + "-");
        }else if (calwork.sign == 2){
            String number = Integer.toString(calwork.getFirst());
            display.setText(number + "*");
        }else if (calwork.sign == 3){
            String number = Integer.toString(calwork.getFirst());
            display.setText(number + "/");
        }
    }

    public void finDisplay() {
        String number = Integer.toString(calwork.getFinal());
        answerBox.setText(number);
    }

    public void clearDisplay() {
        display.setText("");
        answerBox.setText("");
    }
}
