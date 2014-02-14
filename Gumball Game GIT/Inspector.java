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
         int x=0;
         int y=0;
         String image =null;
        if (number %2 == 0)
        {    String color = randomPicker.choseColor();
             image = color;
             x = randomPicker.getX();
             y = randomPicker.getY();
            //Show messsage  
            
             //animateImage();             
        }    
        else
        {
            greenPicker.choseColor();
            image = "green-bumball.png";
            x=greenPicker.getX();
            y=greenPicker.getY();            
        }
        Greenfoot.playSound("someone_crunching.mp3");
        animate(image,x,y);
        
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
    
    public void animate(String image,int x,int y){
        PopUpMessage popImg = new PopUpMessage(image,x);
        getWorld().addObject(popImg, x, y);     
        
    }
    public void animateImage(){
    }
    {
        try
        {
            
            GreenfootImage image = new GreenfootImage("green-bumball.png");
            
            for (int i= 0; i<3 ; i++)
            {
                PopUpMessage message = new PopUpMessage("green-bumball.png",1);
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
