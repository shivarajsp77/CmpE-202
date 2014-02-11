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
    
    public PopUpMessage(GreenfootImage newImage)  
    {  
        this.inner = newImage;
    } 
  
    public PopUpMessage(String text)  
    {  
        this.text = text;
        inner = new GreenfootImage(text, 48, Color.black, new Color(0, 0, 0, 96));
    }  
  
    // create a gameover image the size of the world  
    public void addedToWorld(World world)  
    {  
        int wide = world.getWidth();  
        int high = world.getHeight();  
        GreenfootImage outer = new GreenfootImage(wide, high);  
        int leftX = (wide - inner.getWidth())/2;  
        int topY = (high - inner.getHeight())/2;  
        outer.drawImage(inner, leftX, topY);  
        setImage(outer);  
   }  
  
    // the following is optional  
    // remove pop-up when clicked on  
     public void act()  
    {  
        if (Greenfoot.mousePressed(this))  
        {  
             getWorld().removeObject(this);  
        }  
    }  
} 