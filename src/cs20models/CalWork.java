/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cs20models;

/**
 *
 * @author Zach
 */
public class CalWork {
    
    public int firstNum;
    public int secNum;
    public int finNum;
    public int sign; // 0 = add  1 = sub  2 = multi 3 = divide  4 = none
    public String state;
    
    public CalWork(){
        this.firstNum = 0;
        this.secNum = 0;
        this.state = "first";
    }
    
    public void setFirst(String num ){
        String number = Integer.toString(this.firstNum);
        String newNumber = number + num;
        this.firstNum = Integer.parseInt(newNumber);
    }
    public void setSecond(String num){
        String number = Integer.toString(this.secNum);
        String newNumber = number + num;
        this.secNum = Integer.parseInt(newNumber);
    }
    public void setState(String state){
        this.state = state;
    }
    
    public void setfinal(){
         int signType = this.sign;
        
        switch (signType){
            
            case(0): 
                this.finNum = this.firstNum + this.secNum;
                break;
                
            case(1):
                this.finNum = this.firstNum - this.secNum;
                break;  
                
            case(2):
                this.finNum = this.firstNum * this.secNum;
                break;
            
            case(3):
                this.finNum = this.firstNum / this.secNum;
        }
    }
    
    public void setSign( int signType ){
        if (signType == 0){
            this.sign = 0;
            this.state = "second";
        }else if (signType == 1){
            this.sign = 1;
            this.state = "second";
        }else if (signType == 2){
            this.sign = 2;
            this.state = "second";
        }else if (signType == 3){ 
            this.sign = 3;
            this.state = "second";
        }
    } 
    
    
    public int getSign(){
        return this.sign;
    }
    public int getFinal(){
        return this.finNum;
    }
    public int getFirst(){
        return this.firstNum;
    }
    public int getSecond(){
        return this.secNum;
    }
    public String getState(){
        return this.state;
    }
}
