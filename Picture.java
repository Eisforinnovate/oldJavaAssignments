import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */

public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture (Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  //
//morph stage.......tried to space appropriately...diff TAs told me 2 do it diff ways....tried my best to adapt to std
  public void morphStage(Picture startPicture, Picture endPicture, int numStages, int k)
  {
    Pixel pixelObj = null;
    Color colorObj = null;
  
    int redStartValue = 0;
    int greenStartValue = 0;
    int blueStartValue = 0;
  
    int redEndValue = 0;
    int greenEndValue = 0;
    int blueEndValue = 0;
  
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
  
    Pixel[] pixelArray = this.getPixels();
 
    for (int y = 0; y < this.getHeight(); y++) 
    {  
      for (int x = 0; x < this.getWidth(); x++) 
      {
        //In order to get the pixels
        pixelObj = this.getPixel(x,y);
        Pixel startPixel = startPicture.getPixel(x,y);
      
        //In order to get another for end pixel
        Pixel endPixel = endPicture.getPixel(x,y);
      
      
        //To get the pixels in the start picture
        redStartValue = startPixel.getRed(); 
        greenStartValue = startPixel.getGreen();
        blueStartValue = startPixel.getBlue();
      
        //To get pixels in the end picture
        redEndValue = endPixel.getRed(); 
        greenEndValue =endPixel.getGreen(); 
        blueEndValue = endPixel.getBlue(); 
      
        //Formula provided in Assignment 3 for RGB
        redValue = (redStartValue + ((redEndValue - redStartValue) / (numStages + 1)) * k);
        pixelObj.setRed(redValue);
      
        greenValue = (greenStartValue + ((greenEndValue - greenStartValue) / (numStages + 1)) * k); 
        pixelObj.setGreen(greenValue);
      
        blueValue = (blueStartValue + ((blueEndValue - blueStartValue) / (numStages + 1)) * k);
        pixelObj.setBlue(blueValue);
      }
    }
  }
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }

} // end of class Picture, put all new methods before this
 