//PART C
//by Eric Dolan, 250580207......note:I labelled file as PhotoFiles.txt

import java.io.*;

//class that contains the main method
//allow the user to create an “album” (well, really just a directory) with labeled photos sorted by 
//dates.....makes use of PhotInfo.Java and Picture.Java

class CreatePhotoLists
 
{
  public static void main(String[] args){

//this main method will:
//Get the filename of the photo information file from the user
//use of simpleinput and get string
//s will be the selected file
    
    String s = SimpleInput.getString("Enter File: "); 
    
//Get the name of the directory for storing the class info photos from the user
//use of GetString
//r will be the store loction
    
    String r = SimpleInput.getString("Enter Store Location: ");

//calling on methods made in PhotoList.java
//Sorts photos in file selected
//Display the list of photos on the screen as text.
//Write the labelled photos as .jpg files to the directory.
    
    PhotoList photoList = new PhotoList(s);
    photoList.sortPhotosByDate(); 
    photoList.listPhotos();
    photoList.showPhotos();
  }
}
    
    

