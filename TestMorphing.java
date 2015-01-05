public class TestMorphing
{
  public static void main(String[] args)
  {
    //choose 2 pictures for first sequences
    String flower1 = FileChooser.pickAFile();
    Picture startPicture = new Picture(flower1);
    int startWidth = startPicture.getWidth();
    int startHeight = startPicture.getHeight();
       
    String flower2 = FileChooser.pickAFile();
    Picture endPicture = new Picture(flower2);
    int endWidth = endPicture.getWidth();
    int endHeight = endPicture.getHeight();

    //if and else statement with conditions and SimpleOutputs   
    if(startWidth != endWidth || startHeight != endHeight)
      {
      SimpleOutput.showInformation("Your files aren't the same size! FIXXX IT!!! Now try again FOO!!");
    }
    else
    {
      //int rate = SimpleInput.getIntNumber("Input stage Number: "); was originally used but realized it wasn't necessary. 
      //Already declared the desired number of intermediates//
      //morph picture sequence parameters along with original, ending and intermediate show msgs
      Picture intermediate = new Picture(startWidth, startHeight);
      intermediate.morphStage(startPicture, endPicture, 3, 1);
      intermediate.show();
        
      Picture intermediate1 = new Picture(startWidth, startHeight);
      intermediate1.morphStage(startPicture, endPicture, 3, 2);
      intermediate1.show();
        
      Picture intermediate2 = new Picture(startWidth, startHeight);
      intermediate2.morphStage(startPicture, endPicture, 3, 3);
      intermediate2.show();
        
      startPicture.show();
      endPicture.show();
    }
    //second part, 2 new pics of same size....9 intermediates//
    //originally called eisone bc was going to use my face....didn't have at MC comps, so figured Ironman was just as good
    String eisone = FileChooser.pickAFile();
    startPicture = new Picture(eisone);
    startWidth = startPicture.getWidth();
    startHeight = startPicture.getHeight();
       
    String vistwo = FileChooser.pickAFile();
    endPicture = new Picture(vistwo);
    endWidth = endPicture.getWidth();
    endHeight = endPicture.getHeight();
       
    //if and else for 9 intermediates, start and end pictures 
    if(startWidth != endWidth || startHeight != endHeight)
    {
      SimpleOutput.showInformation("Your files aren't the same size!Try again FOO!");
    }
    else
    {
      //int rate = SimpleInput.getIntNumber("Input stage Number: "); again realized I could cut down on user's activity by getting rid of this.....just wanted to show that after trial and error I realized this and the one above
      //morph picture....realized later could have done loop....TA at time suggested I just do this to simplify the process.....still works so :)//
      Picture intermediate = new Picture(startWidth, startHeight);
      intermediate.morphStage(startPicture, endPicture, 9, 1);
      intermediate.show();
        
      Picture intermediate1 = new Picture(startWidth, startHeight);
      intermediate1.morphStage(startPicture, endPicture, 9, 2);
      intermediate1.show();
        
      Picture intermediate2 = new Picture(startWidth, startHeight);
      intermediate2.morphStage(startPicture, endPicture, 9, 3);
      intermediate2.show();
        
      Picture intermediate3 = new Picture(startWidth, startHeight);
      intermediate3.morphStage(startPicture, endPicture, 9, 4);
      intermediate3.show();
        
      Picture intermediate4 = new Picture(startWidth, startHeight);
      intermediate4.morphStage(startPicture, endPicture, 9, 5);
      intermediate4.show();
        
      Picture intermediate5 = new Picture(startWidth, startHeight);
      intermediate5.morphStage(startPicture, endPicture, 9, 6);
      intermediate5.show();
        
      Picture intermediate6 = new Picture(startWidth, startHeight);
      intermediate6.morphStage(startPicture, endPicture, 9, 7);
      intermediate6.show();
        
      Picture intermediate7 = new Picture(startWidth, startHeight);
      intermediate7.morphStage(startPicture, endPicture, 9, 8);
      intermediate7.show();
        
      Picture intermediate8 = new Picture(startWidth, startHeight);
      intermediate8.morphStage(startPicture, endPicture, 9, 9);
      intermediate8.show();
        
      startPicture.show();
      endPicture.show();
    }
  }
}
//Shows 5 frames for flowers and 11 for Iron Man to V