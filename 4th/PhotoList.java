//PART B
//by Eric Dolan, 250580207......note:I labelled file as PhotoFiles.txt
//second part of the assignment
//deals with Photo List
//will go over showing, listing,storing and sorting the photos
//use of tokenizer function 
//variables in this section are self explanitory 

import java.util.*; 
import java.io.*; 
import java.util.StringTokenizer; 
public class PhotoList 
{
  
//instance variable declarations
  
  private PhotoInfo[] photoArray; 
  private int numPhoto = 0;
  
//constructors
  
  public PhotoList(String fileName) 
  {

//String fileNamed= "PhotoFiles.txt";.....originally had but saw it was pretty useless
//want to show that i can cut down on code
//use simple reader, get line array, read fine, photo array then new photo info
   
    SimpleReader reader = new SimpleReader(fileName);
    String []lineArray = reader.readFile();
    numPhoto= reader.getFileLength(); 
    photoArray = new PhotoInfo [numPhoto];
    
//tokenizer....ran into problems of being in correct order
//have to make sure it is always id, cat, yr, mn,dy,cap,pf
    
    StringTokenizer tokenizer;
    String id;
    String category;
    int year;
    int month;
    int day;
    String caption;
    String photoFile;
 
//for loop......again a matter of order was a problem
//have 2 be consistent throughout code
 //uses tokenizer, line array and new Photo Info
    
    for(int i=0;i<numPhoto;i++)
    {
      tokenizer = new StringTokenizer(lineArray[i]);
      id=tokenizer.nextToken();
      day=Integer.valueOf(tokenizer.nextToken());
      month=Integer.valueOf(tokenizer.nextToken());
      year= Integer.valueOf(tokenizer.nextToken());
      category=tokenizer.nextToken();
      caption=tokenizer.nextToken();
      photoFile=tokenizer.nextToken();
      photoArray[i] = new PhotoInfo(id, day, month, year, category, caption, photoFile);
    }
  }
  

//method to list photos
//uses a for loop on photoArray and prints out txt file
//much like lab 10
// method listPhotos() displays the photo list on the screen as text; 
  
  public void listPhotos(){

    for (int i=0; i< photoArray.length-1; i++)
    {
      System.out.println(photoArray[i].toString()); 
    }
  }

//method showPhotos() that shows all the info photos for the class on the screen
//use of for and photoArray
  
  public void showPhotos(){
    for (int i=0; i<photoArray.length-1; i++)
    {
      photoArray[i].getPhotoPic().show();
    }
  }

//method storePhotos() that stores all the labeled photos as .jpg files in a directory 
//whose name is passed as a parameter 
//d will write each Picture object in photoArray to a file in the directory
//filename for each Picture object will be the unique identifier for that photo concatenated 
//with “_” (a single underscore) and concatenated with the photo’s category
//prints out files info selected at the end

  public void storePhotos(String directory){
    char end = directory.charAt(directory.length() - 1); 
    if (end != '/' || end != '\\') directory = directory + '/'; 
    File directoryFile = new File(directory); 
    if (!directoryFile.exists()) directoryFile.mkdirs(); 
    for (int i=0; i<photoArray.length-1; i++)
    {
      Picture pic = photoArray[i].getPhotoPic();
      PhotoInfo pictureInfo= photoArray[i];
      String id = pictureInfo.getId();
      String category = pictureInfo.getCat();
      System.out.println( directory + "/" + id + "_" + category + ".jpg"); 
    }
  }
  
//uses a bubble sort to sort photoArray by dates
//displays the photo list on the screen as text
//boolean is used to determine
//use of for and while loops to allow the sort to go through each file
  
  public void sortPhotosByDate(){
    boolean swapped = true;
    PhotoInfo temp;
    while (swapped){
      swapped = false;
      for (int i=0; i<numPhoto-1; i++)
      {
        if((photoArray[i].getYear() > photoArray[i+1].getYear()) 
             || (photoArray[i].getYear()== photoArray[i+1].getYear() && photoArray[i].getMonth() > photoArray[i+1].getMonth())
             || ((photoArray[i].getYear()== photoArray[i+1].getYear()) && (photoArray[i].getMonth() == photoArray[i+1].getMonth()) && (photoArray[i].getDay() > photoArray[i+1].getDay())))
        {
  temp=photoArray[i];
  photoArray[i]=photoArray[i+1];
  photoArray[i+1]=temp;
  swapped=true;
}
      }
}
}
}         