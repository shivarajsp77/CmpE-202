import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    protected GumballMachine gumballMachine;
    
    public Coin(GumballMachine gumballMachine)
    {
        this.gumballMachine = gumballMachine;
    }
    
    public void act() 
    {
        int mouseX, mouseY ;
        
        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX=mouse.getX();  
            mouseY=mouse.getY();  
            setLocation(mouseX, mouseY);             
            check(mouseX,mouseY);
        } 
    }    
    
 public void check(int mouseX,int mouseY){
        int x = gumballMachine.getX();
        int y = gumballMachine.getY();
        
            if(mouseX>x-10 && mouseX<x+10 && mouseY>y-10 && mouseY<y+10){                
                gumballMachine.validateCoin(this);
                
            }
    }
    
    public GumballMachine getGumballMachine(){
        return gumballMachine;
    }
}
