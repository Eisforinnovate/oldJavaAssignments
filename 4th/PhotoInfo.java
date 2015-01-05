//PART A//
//by Eric Dolan, 250580207
//photo info about an individual photo in order to create and label photo//
//attributes of an obj in this class will be a unique identifier of photo, category photo delongs to
//date photo was take, caption, name of file with photo (.jpg file)
//class contains methods below//
//variables in this section are self explanitory


//fields....stating whether it is public or private as well as stating whether it is string, int..
//or Picture.....done as reference for future reference 

class PhotoInfo 
{
  private String id;       
  private int day;        
  private int month;    
  private int year;   
  private String cat;
  private String cap;
  private String picFile;
  private Picture photoPic;
 
  
//connstructors....here i used this statements to claim values with refencences usedin the above fields
   
  public PhotoInfo( String ident, int nday, int nmonth, int nyear, String cat, String cap, String picFile )
  {
    this.id = ident;
    this.day = nday;
    this.month = nmonth;
    this.year = nyear;
    this.cat = cat;
    this.cap= cap;
    this.picFile = picFile;

    
//Here i am creating a picture with stated parameters from the file i would be choosing (yr,month, day)
//using drawstring method on photopictures 
//Returns DrawString for the text of specified iterator at specified location
    
    String date = year + " " + month + " " + day;
    Picture picture1 = new Picture (picFile);
    photoPic= new Picture (picture1.getWidth() + 20, picture1.getHeight()+70);
    photoPic.copyPictureTo(picture1,10,0);
    photoPic.drawString(cat,0, picture1.getHeight()+20,20);
    photoPic.drawString (cap,0,picture1.getHeight()+60,20);
    photoPic.drawString(date,0,picture1.getHeight()+40,20);
}
    

//methods
//this secontion I grab references (ie id etc) and then return each
//I first state all I will return
//I create a method and return for each character stated in point above (ie id, picfile etc)
  
    public String toString()
    {
  return cap + (id + "," + picFile + "," + day + "," + month + "," + year);
    }
    public String getId()
    {
      return id;
    }
    public String getCat()
    {
      return cat;
    }
    public int getDay()
    {
      return day;
    }
     public int getMonth()
    {
      return month ;
    }
      public int getYear()
    {
      return year;
    }
      public String getCap()
    {
      return cap;
    }
    public Picture getPhotoPic()
    {
      return photoPic;
}
    
//Additional test
//this was used to make sure it was working
//allows user to pic a file
// gets info for selected file
//prints slected info for file
//labels selected photo
//not req'd. did as additonal precaution for functionality reasons 
    
public static void main (String[] args) 
    {
      int day= 04;
      int month=12;
      int year=2012;
      String picFile = FileChooser.pickAFile();
      PhotoInfo picture1 = new PhotoInfo ("Test" , day, month, year, "My Photos :)", "Rub My Tummy Cooldog", picFile);
      System.out.println(picture1.getDay());
      System.out.println(picture1.toString());
      Picture picLabel = picture1.getPhotoPic();
      picLabel.show();
}
}

