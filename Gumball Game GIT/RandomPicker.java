import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RandomPicker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomPicker extends Picker
{
    /**
     * Act - do whatever the RandomPicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       
    }    
    
    public String choseColor()
    {
        String[] color = {"red-gumball.png","blue-gumball.png","green-bumball.png"};
        int idx = Greenfoot.getRandomNumber(color.length);

        return (color[idx]);
    }
}

