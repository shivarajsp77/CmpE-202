import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;  
/**
 * Write a description of class PopUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopUpMessage extends Actor  
{  
    String text;  
    GreenfootImage inner;
    
    
    /** How many images should be used in the animation of the explostion */
    private final static int IMAGE_COUNT= 50;
    
    /** 
     * The images in the explosion. This is static so the images are not
     * recreated for every object (improves performance significantly).
     */
    private static GreenfootImage[] images;
    
    /** Current size of the explosion */
    private int size=0;
    
    /** How much do we increment the index in the explosion animation. */
    private int increment=1; 
    boolean gumballImage =false;
    public PopUpMessage(String newImage,int x)  
    {  
        initialiseImages(newImage);
        setImage(images[0]); 
        
        gumballImage = true;
        
    } 
    
    public synchronized static void initialiseImages(String newImage)
    {
        if(images == null) {
            GreenfootImage baseImage = new GreenfootImage(newImage);
            int maxSize = baseImage.getWidth();
            int delta = maxSize / (IMAGE_COUNT+1);
            int size = 0;
            images = new GreenfootImage[IMAGE_COUNT];
            for(int i=0; i < IMAGE_COUNT; i++) {
                size = size + delta;
                images[i] = new GreenfootImage(baseImage);
                images[i].scale(size, size);
            }
        }
    }
    
    
    public PopUpMessage(String text)  
    {  
        this.text = text;
        inner = new GreenfootImage(text, 48, Color.yellow, new Color(110, 150, 60, 126));
    }  
  
    // create a gameover image the size of the world  
    public void addedToWorld(World world)  
    {  
        if(!gumballImage){
            int wide = world.getWidth();  
            int high = world.getHeight();  
            GreenfootImage outer = new GreenfootImage(wide, high);  
            int leftX = (wide - inner.getWidth())/2;  
            int topY = (high - inner.getHeight())/2;  
            outer.drawImage(inner, leftX, topY);  
            setImage(outer);  
       }
   }  
  
    // the following is optional  
    // remove pop-up when clicked on  
     public void act()  
    {   
        if(gumballImage){
                setImage(images[size]);
        
                size += increment;
                if(size>=IMAGE_COUNT) {
                    increment = -increment;
                    size += increment;
                }
                
                if(size <= 0) {
                    getWorld().removeObject(this);
                }
        }
        
        if (Greenfoot.mousePressed(this))  
        {  
             getWorld().removeObject(this);  
        }  
    }  
} 