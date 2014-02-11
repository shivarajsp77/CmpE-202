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
        {    String color = randomPicker.choseColor();
            GreenfootImage image = new GreenfootImage(color);
            getWorld().addObject(new PopUpMessage(image), randomPicker.getX(), randomPicker.getY());//Show messsage  
             //animateImage();             
        }    
        else
        {
            greenPicker.choseColor();
            GreenfootImage image = new GreenfootImage("green-bumball.png");
            getWorld().addObject(new PopUpMessage(image), greenPicker.getX(), greenPicker.getY());
        }
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
    
    public void animateImage()
    {
        try
        {
            
            GreenfootImage image = new GreenfootImage("green-bumball.png");
            
            for (int i= 0; i<3 ; i++)
            {
                PopUpMessage message = new PopUpMessage(image);
                getWorld().addObject(message, randomPicker.getX()+(i*10), randomPicker.getY()+(i*10));//Show messsage  
                //Thread.sleep(1000);
                
                if(i!=2)
                {   
                getWorld().removeObject(message);
                
                image.scale(image.getWidth() - 50, image.getHeight() - 50); 
                //Thread.sleep(1000);
                }
            }

        }
        catch(Exception e)
        {
            ;
        }
    }
}
