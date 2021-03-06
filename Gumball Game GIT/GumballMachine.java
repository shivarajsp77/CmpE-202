import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    private Inspector inspector;
    private RandomPicker rPicker;
    private GreenPicker gPicker;
    private int coinInserted;
    private  GreenfootSound coinSound;
        
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
                
    }

    public void act()
    {
       if (Greenfoot.mousePressed(this))
        {
           
            if (coinInserted == 2) //Quarter
            {
                
                coinSound = new GreenfootSound("Quarter.wav");
                coinSound.play();
                Greenfoot.delay(70);
                inspector.pickGumball();
            }
            else if (coinInserted == 3) // Fake Quarter
            {
              getWorld().addObject(new PopUpMessage("This is a Fake Quarter"), inspector.getX(), inspector.getY()); 
              coinSound = new GreenfootSound("FakeCoin.wav");
              coinSound.play();
            }
            else if (coinInserted == 1) 
            {
                 getWorld().addObject(new PopUpMessage("Please insert a Quarter!"), inspector.getX(), inspector.getY());//Show messsage!
                 coinSound = new GreenfootSound("Penny.wav");
                 coinSound.play();
            }
            else 
            {
                 getWorld().addObject(new PopUpMessage("Insert coin for a Gumball!"), this.getX(), this.getY());//Show messsage!
                 coinSound = new GreenfootSound("InsertQuarter.mp3");
                 coinSound.play();
            }
            
            coinInserted=0;
        } 
    }
      
    
        
    public void setInspector(Inspector inspector)
    {      
        this.inspector = inspector;
    }
    
        
    public void validateCoin(Coin c)
    {
        coinInserted = inspector.validateCoin(c);
        
        getWorld().removeObject(c);
        getWorld().addObject(new PopUpMessage("Have a Coin"), this.getX(), this.getY());
        
    }
    
     public void setPickers(RandomPicker rPicker, GreenPicker gPicker)
    {
        this.rPicker = rPicker;
        this.gPicker = gPicker;
    }
}
