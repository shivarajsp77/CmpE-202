 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GumballWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GumballWorld extends World
{

    /**
     * Constructor for objects of class GumballWorld.
     * 
     */
    public GumballWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        GumballMachine gumballmachine = new GumballMachine();
        addObject(gumballmachine, 367, 237);
        addObject( new Penny(gumballmachine), 57, 71 ) ;
        addObject( new Quarter(gumballmachine), 68, 156 ) ;
        addObject( new FakeQuarter(gumballmachine), 66, 248 ) ;
        
        //Creating Inspector
        Inspector inspector = new Inspector();
        addObject(inspector, 533, 291);
        gumballmachine.setInspector(inspector);
        
        
        //Create Random Picker
        RandomPicker randompicker = new RandomPicker();
        addObject(randompicker, 643, 104);
        randompicker.setLocation(655, 94);
        
        //Create Green Picker      
        GreenPicker greenpicker = new GreenPicker();
        addObject(greenpicker, 686, 454);
        greenpicker.setLocation(669, 456);
        
        inspector.setPickers(randompicker, greenpicker);
                
        
    }
}
