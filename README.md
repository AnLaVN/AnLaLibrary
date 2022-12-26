<h1 align="center">A Super, Ultra, Ultimate Library Java Application :)))</h1>
<p align="center">
  <img src="https://user-images.githubusercontent.com/90229487/193866183-451ebfc8-b0f7-4679-9442-653cc0f0be12.png" height = "500px">
  <br>
  <a href="https://anlavn.github.io/AnLaLibrary___JavaDoc___EN/"><strong>Java Doc English</strong></a>
  &nbsp;<b>·</b>&nbsp;
  <a href="https://anlavn.github.io/AnLaLibrary___JavaDoc___VN/"><strong>Java Doc Tiếng Việt</strong></a>
  <br><br>
  <a href="https://www.apache.org/licenses/LICENSE-2.0">
    <img src="https://img.shields.io/github/license/exadel-inc/CompreFace" alt="GitHub license" />
  </a>
</p>



# 1. Overview / Tổng quan
### English
> AL-Library is a personal and free project. It's basically a library that includes many other libraries that make it easier to use.
>
> The library provides methods for you to do basic work in Java such as: Database Connection, Swing Components support, Cryptographic Hashing, SMTP email service, file upload and download from the Cloud, chat with ChatGPT bot, face detection, face recognition... and more...
### Tiếng Việt
> AL-Library là một dự án cá nhân và miễn phí. Về cơ bản, nó là một thư viện bao hàm nhiều thư viện khác giúp việc sử dụng dễ dàng hơn.
>
> Thư viện cung cấp các phương thức để bạn có thể làm việc cơ bản trong Java như: Kết nối Database, hỗ trợ các Thành phần Swing, Băm mật mã học, dịch vụ gửi email SMTP, tải lên và tải về tệp từ Đám mây, trò chuyện với ChatGPT bot, nhận diện khuôn mặt, nhận dạng khuôn mặt... và hơn thế nữa...



# 2. Features / Tính năng
* [FILE](#31-file---provides-file-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-tập-tin)
  * [Log](#311-log)
  * [NativeLibrary](#312-nativelibrary)
  * [ObjectData](#313-objectdata)
  * [Properties](#314-properties)
  * [Raw](#315-raw)
* [HASH](#32-hash---provides-cryptographic-hash-function-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-hàm-băm-mật-mã-học)
  * [AES](#321-aes)
  * [MD5](#322-md5)
  * [SHA256](#323-sha256)
* [JDBC](#33-jdbc---provide-database-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-cơ-sở-dữ-liệu)
  * [SQL](#331-sql)
* [NET](#34-net---provide-internet-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-internet)
  * [Cloud](#341-cloud)
  * [DocNet](#342-docnet)
  * [Network](#343-network)
* [OpenAI](#35-openai---provide-openai-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-openai)
  * [ChatGPT](#351-chatgpt)
* [OpenCV](#36-opencv---provide-opencv-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-opencv)
  * [FaceDetection](#361-facedetection)
    * [FaceDetection Module](https://github.com/AnLaVN/AL-Library/releases/download/v3.61.21/FaceDetection.exe)
  * [FaceRecognition](#362-facerecognition)
    * [FaceRecognition Module](https://github.com/AnLaVN/AL-Library/releases/download/v3.61.21/FaceRecognition.exe)
* [SMTP](#37-smtp---provide-smtp-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-smtp)
  * [SendMail](#371-sendmail)
* [UI](#38-ui---provide-ui-related-libraries--cung-cấp-các-thư-viện-liên-quan-đến-ui)
  * [AvatarPanel](#381-avatarpanel) (Add to Palette from JAR)
  * [ChatBox](#382-chatbox) (Add to Palette from JAR)
  * [ComboBox](#383-combobox) (Add to Palette from JAR)
  * [ImgPanel](#384-imgpanel) (Add to Palette from JAR)
  * [Mode](#385-mode)
  * [Notification](#386-notification)
  * [ScrollBar](#387-scrollBar)
  * [DateChooser.DateChooser](#388-datechooserdatechooser)
  * [TimePicker.TimePicker](#389-timepickertimepicker)
  * [WinFileChooser.JnaFileChooser](#3810-winfilechooserjnafilechooser)
* Java Doc
  * [English](https://anlavn.github.io/AnLaLibrary___JavaDoc___EN/)
  * [Tiếng Việt](https://anlavn.github.io/AnLaLibrary___JavaDoc___VN/)



# 3. Quick start Guide / Hướng dẫn nhanh


## 3.1 FILE - Provides file related libraries / Cung cấp các thư viện liên quan đến tập tin

### 3.1.1 Log
```` java
  import com.AnLa.FILE.Log;
    
  Log.add("Your text");   //write text to log file, will auto create as Log folder.
  System.out.println("File path: " + Log.getFilePath());  //print path of log file.
  Log.closeFile();    //close file if your dont use anymore.
````
 
### 3.1.2 NativeLibrary
```` java
  import com.AnLa.FILE.NativeLibrary;
  
  NativeLibrary.load("path/YourLib.dll");
````

### 3.1.3 ObjectData
  The main class.
```` java
  import com.AnLa.FILE.ObjectData;
  
  ObjectData.writeData("myFile.dat", new myObject("AnLaVN", 19)); //write new object to myFile.dat
  myObject myobj = (myObject) ObjectData.readData("myFile.dat");  //read object from myFile.dat, store in myobj variable
  System.out.println("My name: " + myobj.getName());  //print value of object
  System.out.println("My age: " + myobj.getAge());
````
  The myObject class.
```` java
  import java.io.Serializable;
  //Make sure your class have 'implements Serializable'
  public class myObject implements Serializable{
      private String name;
      private int age;

      public myObject() {}
      public myObject(String name, int age) {
          this.name = name;
          this.age = age;
      }
      public String getName() {   return name;    }
      public int getAge()     {   return age;     }
  }
````

### 3.1.4 Properties
  The main class
```` java
  import com.AnLa.FILE.Properties;
  
  String lang = "EN"; //"VN" if you want using vietnamese languages, "EN" if you want english
  Properties proper = new Properties("src/FILE/myProperties_" + lang + ".properties");    //load properties file
  System.out.println("Properties of hello key: " + proper.getString("hello"));    //print value of key in file
````
  The myProperties_VN.properties file ![image](https://user-images.githubusercontent.com/90229487/209496791-a1abfc66-77e0-48e5-94ce-2b83cb68c703.png)<br>
  The myProperties_EN.properties file ![image](https://user-images.githubusercontent.com/90229487/209496563-fbad72f0-ecdf-4edd-bf37-238f63a2f94b.png)
  
### 3.1.5 Raw
  The main class
```` java
  import com.AnLa.FILE.Raw;
  
  Raw raw = new Raw("src/FILE/myFile.txt");    //create myFile.txt in src/FILE/ folder
  raw.writeData("your text"); //write data to file
  System.out.println(raw.readData()); //read data from file
  raw.closeFile();    //close file if you dont use anymore
````


## 3.2 HASH - Provides cryptographic hash function related libraries / Cung cấp các thư viện liên quan đến hàm băm mật mã học

### 3.2.1 AES
```` java
  import com.AnLa.HASH.AES;
  
  String orgStr = "This is original string.", //declare original string need to hash
         myKey  = "This is key to hash ",     //declare my security key to hash string
         hashStr= AES.Encrypt(orgStr, myKey); //hash original string with security key
  System.out.println("Hash AES of orgStr: " + hashStr);   //print hash string
  System.out.println("My original string: " + AES.Decrypt(hashStr, myKey));   //encrypt hash string and print it
````

### 3.2.2 MD5
```` java
  import com.AnLa.HASH.MD5;
  
  String orgStr = "This is original string.", //declare original string need to hash
         hashStr= MD5.Encrypt(orgStr); //hash original string, only supports encryption, decryption it is impossible.
  System.out.println("Hash MD5 of orgStr: " + hashStr);   //print hash string
````

### 3.2.3 SHA256
```` java
  import com.AnLa.HASH.SHA256;
  
  String orgStr = "This is original string.", //declare original string need to hash
         hashStr= SHA256.Encrypt(orgStr); //hash original string, only supports encryption, decryption it is impossible.
  System.out.println("Hash SHA256 of orgStr: " + hashStr);   //print hash string
````


## 3.3 JDBC - Provide database related libraries / Cung cấp các thư viện liên quan đến cơ sở dữ liệu

### 3.3.1 SQL
  The main class
```` java
  import com.AnLa.JDBC.SQL;
  import java.sql.*;

  SQL sql = new SQL(DB_url, DB_username, DB_password);    //setup to your database information
  sql.Connect();  //connect to your database (if exists)
        
  ResultSet rs = sql.Query("select * from myTable");      //query all from table
  while(rs.next()){
    System.out.println("ID: " + rs.getString("ID") + " - " + rs.getString("Name"));//get value
  }
        
  System.out.println("-------------------------------------------------------------------------");

  int ID = 1;
  sql.Update("delete from myTable where ID = ?", ID); //query delete from table with parameters ID
  rs = sql.Query("select * from myTable");            //query all from table
  while(rs.next()){
    System.out.println("ID: " + rs.getString("ID") + " - " + rs.getString("Name"));//get value
  }
````
  The sql file
```` sql
  USE MASTER
  DROP DATABASE  IF EXISTS myDatabase 
  CREATE DATABASE myDatabase
  USE myDatabase

  CREATE TABLE myTable(
    ID int PRIMARY KEY NOT NULL,
    NAME NVARCHAR(50)
  );

  INSERT INTO myTable VALUES
    (1, 'AnLaVN'),
    (2, N'Bình An')
````


## 3.4 NET - Provide Internet related libraries / Cung cấp các thư viện liên quan đến Internet

### 3.4.1 Cloud
```` java
  import com.AnLa.NET.Cloud;
  
  Cloud cloud = new Cloud("cloudinary://985969511487375:1zJ0Tonfsk5m3-asd9PotnkhiTc@anlavn");//setup your cloudinary api
  String url = cloud.FileUpload("myImage.png");   //get url after upload image file
  System.out.println("Link of my file: " + url);  //print url
  //cloud.FileDeleteByURL(url);                   //delete file using url
````

### 3.4.2 DocNet
```` java
  import com.AnLa.NET.DocNet;
  
  DocNet docnet = new DocNet("https://raw.githubusercontent.com/AnLaVN/AL-Library/Releases/LICENSE"); //set address of network document
  System.out.println(docnet.readAllLine());   //read all line in network document
````

### 3.4.3 Network
```` java
  import com.AnLa.NET.Network;
  
  System.out.println("My IPv4: " + Network.myIPv4());//print my public ip, not local ip
  System.out.println("My Wlan: " + Network.myWLAN().get("SSID"));//print wlan ssid name
````


## 3.5 OpenAI - Provide OpenAI related libraries / Cung cấp các thư viện liên quan đến OpenAI

### 3.5.1 ChatGPT
```` java
  import com.AnLa.OpenAI.ChatGPT;
  
  ChatGPT cgpt = new ChatGPT("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");  //connect to OpenAI service using API key
  String Result = cgpt.Chat("Who is mr bean?", ChatGPT.Model.Davinci, 128); //get result from request, calling model Davinci with max 128 token
  System.out.println(Result); //print result
````


## 3.6 OpenCV - Provide OpenCV related libraries / Cung cấp các thư viện liên quan đến OpenCV

### 3.6.1 FaceDetection
  [See details in project example / Xem chi tiết trong dự án mẫu]()
```` java
  import com.AnLa.OpenCV.FaceDetection;
  
  FaceDetection.loadDetect(); //load module to detect
  FaceDetection.setDetectPanel(myPanel, 20);  //set JPanel where will display video capture from camera with rounded corners
  
  //set how the rectangle display when detect a face,
  FaceDetection.setDetectFace(true, Color.GREEN, 2);  //this line mean will detect face and display with green rectangle and thickness 2px
  //FaceDetection.setDetectFace(false, Color.GREEN, 2); //this line mean will not detect face and not display any rectangle no matter what color and how thick it is 
  
  FaceDetection.startDetection(0);  //start capture video from camera 0 and detect face, if you was setDetectFace(true, ..., ...)
  //FaceDetection.endDetection();   //end capture video
````

### 3.6.2 FaceRecognition
```` java
  import com.AnLa.OpenCV.FaceRecognition;
  
  //set image for original face and test face using URL.
  //network connection is required to use the module regardless if you have set image from URL or not
  FaceRecognition.setImageOrginal("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTNU14t4OtvdSZf-rTJAQWI6LdTIw5nYCYT1V3SfHgWja6cYMbG");
  FaceRecognition.setImageTesting("https://nld.mediacdn.vn/2021/1/5/d9db633fe9c98429ec9025ca0950f241-16098228091571816318835.jpg");
  FaceRecognition.setRequirementPercent(60.0);//set a percentage requirement for face recognition, the higher the stricter
        
  System.out.println(FaceRecognition.Recognition());//get result of face recognition
  System.out.println(FaceRecognition.getPercent());//get percent was recognition
  System.out.println(FaceRecognition.isMatch());//get value if match, true if percent was recognition higher or equal with percentage requirement
````


## 3.7 SMTP - Provide SMTP related libraries / Cung cấp các thư viện liên quan đến SMTP

### 3.7.1 SendMail
```` java
  import com.AnLa.SMTP.SendMail;
  
  SendMail sm = new SendMail("yourEmail@domain.com", "applicationPass");//setup your SMTP service, at here is GMail SMTP
  sm.setEmail("Tittle Email", "<h1>hello, this is test email</h1>");  //set up your email
  sm.sendMailTo("yourFriend@domain.com"); //set email for your friend
````


## 3.8 UI - Provide UI related libraries / Cung cấp các thư viện liên quan đến SMTP
  [See details in project example / Xem chi tiết trong dự án mẫu]()
  
### 3.8.1 AvatarPanel
  [ExampleAvatarPanel]()
```` java
  import com.AnLa.UI.AvatarPanel;

  AvatarPanel avatar = new AvatarPanel();
  avatar.setPic("myImage.png"); //set picture for panel from file
  avatar.setPic("https://i.pinimg.com/564x/b7/d2/62/b7d262d9ab6397f959a2030f65947b4f.jpg"); //set picture for panel from url
````

### 3.8.2 ChatBox
   [ExampleChatBox]()
```` java
  import com.AnLa.UI.ChatBox;
  
  ChatBox chat = new ChatBox();
  chat.addRightBubble("this is right side text"); //add bubble text in right side
  chat.addLeftBubble("this is left side text"); //add bubble text in left side
  chat.addNotifiBox("this is notification text"); //add notification text in center
````

### 3.8.3 ComboBox
  [ExampleComboBox]()
```` java
  import com.AnLa.UI.ComboBox;

  ComboBox comboBox = new ComboBox();
  comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "item 1", "item2" })); //use as normal combobox
````

### 3.8.4 ImagePanel
  [ExampleImagePanel]()
```` java
  import com.AnLa.UI.ImagePanel;

  ImagePanel image = new ImagePanel();
  image.setPic("myImage.png"); //set picture for panel from file
````

### 3.8.5 Mode
  [ExampleMode]()
```` java
  import com.AnLa.UI.Mode;
  
  Mode.setMode(true); //set true is dark mode, false is light
  Mode.setModeComponent(yourComponent); //set the component will apply mode change
````

### 3.8.6 Notification
  [ExampleNotification]()
```` java
  import com.AnLa.UI.Notification;
  
  //setup the notification will popup
  Notification noti = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Notification");
  noti.showNotification(); //show popup Notification
````

### 3.8.7 ScrollBar
  [ExampleScrollBar]()
```` java
import com.AnLa.UI.ScrollBar;

yourJScrollPanel.setVerticalScrollBar(new ScrollBar());
````

### 3.8.8 DateChooser.DateChooser
  [ExampleDateChooser]()
```` java
  import com.AnLa.UI.DateChooser.DateChooser;

  DateChooser dateChooser = new DateChooser();
  dateChooser.setReferenceLabel(yourLabel); //set JLabel where will display day was choose
  dateChooser.showPopup();  //show day chooser as popup
````

### 3.8.9 TimePicker.TimePicker
  [ExampleTimePicker]()
```` java
  import com.AnLa.UI.TimePicker.TimePicker;

  TimePicker timePicker = new TimePicker();
  timePicker.setDisplayTextLabel(yourLabel); //set JLabel where will display day was choose
  //show time picker as popup as position
  timePicker.showPopup(this,
              (getWidth() - timePicker.getPreferredSize().width) / 2,
              (getHeight() - timePicker.getPreferredSize().height) / 2);
````

### 3.8.10 WinFileChooser.JnaFileChooser
  [ExampleJnaFileChooser]()
```` java
  import com.AnLa.UI.WinFileChooser.JnaFileChooser;
  
  JnaFileChooser SelectPic = new JnaFileChooser();
  SelectPic.addFilter("Image", "jpeg", "jpg", "png"); //add file filter for file chooser
  if(SelectPic.showOpenDialog(this)){ //if choose file
  //get absolute path of choose file and print it
    System.out.println(SelectPic.getSelectedFile().getAbsolutePath());
  }
````


## 4. Download / Tải xuống
* [Releases Version](https://github.com/AnLaVN/AnLaLibrary/releases)
* [FaceDetection Module](https://github.com/AnLaVN/AL-Library/releases/download/v3.61.21/FaceDetection.exe)
* [FaceRecognition Module](https://github.com/AnLaVN/AL-Library/releases/download/v3.61.21/FaceRecognition.exe)
