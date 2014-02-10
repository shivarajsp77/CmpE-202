import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballMachine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballMachine extends Actor
{
    private Inspector inspector;
    private int coinInserted;
        
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
                
    }

    public void act()
    {
       if (Greenfoot.mousePressed(this))
        {
            System.out.println("Gumball Machine clicked");
           
            if (coinInserted == 2) //Quarter
            {
                inspector.pickGumball();
            }
            else if (coinInserted == 3) // Fake Quarter
            {
                //Show message !!
            }
            else 
            {
                //Show messsage!
            }
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
    }
}
