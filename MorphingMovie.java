public class MorphingMovie
{
  public static void main (String[] args)
  {
//picking the 1st 2 images for the 21 movie sequence 
    String pic1 = FileChooser.pickAFile();
    Picture startPicture = new Picture(pic1);
    int startWidth = startPicture.getWidth();
    int startHeight = startPicture.getHeight();
    
    String pic2 = FileChooser.pickAFile();
    Picture endPicture = new Picture(pic2);
    int endWidth = endPicture.getWidth();
    int endHeight = endPicture.getHeight();
    
    //boolean if and else loop.....needed to verify size....otherwise SimpleOutput insults user :p
    boolean cont= true;
    if(startWidth !=endWidth || startHeight != endHeight)
    {
      SimpleOutput.showInformation("Files aren't the same size! Try again!");
    }
    else
    {
      int numStages; 
      numStages = SimpleInput.getIntNumber("Enter Integer Number: ");
      String directoryName= SimpleInput.getString ("Name directory");
 
      //1st movie name directory and sequence
      Picture[] pictureSequence;
      pictureSequence = new Picture[numStages + 2];
      pictureSequence[0] = startPicture;
      pictureSequence[pictureSequence.length - 1] = endPicture;
      //1st movie for loops
      for (int k = 1; k <pictureSequence.length-1; k++)
      {
        Picture intermediate = new Picture(startWidth, startHeight);
        intermediate.morphStage(startPicture, endPicture, numStages,k);
        pictureSequence[k] = intermediate;
      }
      FrameSequencer frameSequencer = new FrameSequencer(directoryName);
      for (int i = 0; i < pictureSequence.length; i ++)
      {
        frameSequencer.addFrame(pictureSequence[i]);
      }
      //To play 1st movie      
      MoviePlayer movie1 = new MoviePlayer(directoryName);
      movie1.playMovie(numStages);
      //2nd movie naming directory 
      String directoryName2= SimpleInput.getString ("Name directory For 2nd"); 
      FrameSequencer frameSequencer2 = new FrameSequencer(directoryName2);
       //2nd movie sequence      
      for (int k = 0; k < pictureSequence.length; k++)
      {
        frameSequencer2.addFrame(pictureSequence[k]);
      }
      for (int k=pictureSequence.length -1; k>0; k--)
      {
        frameSequencer2.addFrame(pictureSequence[k]);
      }
      //To Play 2nd movie       
      MoviePlayer movie2 = new MoviePlayer(directoryName2);
      movie2.playMovie(numStages);
    }
  }
}
//use the ironman mask and v mask for this one, i think its cool in colour variation 