import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Inspector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inspector extends Alien
{
    private RandomPicker randomPicker;
    private GreenPicker greenPicker;
    
    public void setPickers(RandomPicker rPicker, GreenPicker gPicker)
    {
        this.randomPicker = rPicker;
        this.greenPicker = gPicker;
    }
    
    /**
     * Act - do whatever the Inspector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {       
        
    }    
    
    public void pickGumball()
    {
         int number = Greenfoot.getRandomNumber(100);
        
        if (number %2 == 0)
            randomPicker.choseColor();
        else
            greenPicker.choseColor();
    }
    
     public int validateCoin(Coin c) 
    {
        if(c instanceof Quarter )
        {
            if (c instanceof FakeQuarter)          
                return 3;
            else
                return 2;
        }
         
        return 1;
    }
}
