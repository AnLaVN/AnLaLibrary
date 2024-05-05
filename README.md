<h1 align="center">AnLa Java Library :)))</h1>
<p align="center">
	<img src="https://user-images.githubusercontent.com/90229487/210226067-12f868ef-36cc-45b1-9cce-3c3297f13d25.png" width = "40%">
	<br>
	<a href="https://anlavn.github.io/AL-Library/AL-Library_JavaDoc/English/"><strong>Java Doc English</strong></a>
	&nbsp;<b>·</b>&nbsp;
	<a href="https://anlavn.github.io/AL-Library/AL-Library_JavaDoc/Vietnamese/"><strong>Java Doc Tiếng Việt</strong></a>
	<br><br>
	<a href="https://www.apache.org/licenses/LICENSE-2.0"><img src="https://img.shields.io/github/license/exadel-inc/CompreFace" alt="GitHub license"/></a>
	<a href="https://pypi.org/project/face-recognition/"><img src="https://img.shields.io/badge/Python-Face%20Recognition-blue" alt="Face Recognition"></a>
	<a href="https://opencv.org/releases/"><img src="https://img.shields.io/badge/OpenCV-Face%20Detection-brightgreen" alt="Face Detection"></a>
	<a href="https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html"><img src="https://img.shields.io/badge/JDK-17+-orange" alt="JDK"></a>
	<a href="#42-maven-central-repository"><img src="https://img.shields.io/maven-central/v/io.github.AnLaVN/AL-Library_VN"></a>
	<br><br>
	<img src="https://img.shields.io/github/repo-size/AnLaVN/AL-Library">
	<img src="https://img.shields.io/github/languages/code-size/AnLaVN/AL-Library">
	<img src="https://img.shields.io/github/downloads/AnLaVN/AL-Library/total">
	<a href="https://github.com/AnLaVN/AL-Library/releases"><img src="https://img.shields.io/github/v/release/AnLaVN/AL-Library"></a>
	<a href="https://github.com/AnLaVN/AL-Library/releases"><img src="https://img.shields.io/github/release-date/AnLaVN/AL-Library"></a>
	<a href="https://github.com/AnLaVN/AL-Library/commits/Releases"><img src="https://img.shields.io/github/commit-activity/w/AnLaVN/AL-Library"></a>
	<a href="https://github.com/AnLaVN/AL-Library/commits/Releases"><img src="https://img.shields.io/github/last-commit/AnLaVN/AL-Library"></a>
	<br><br>
</p>



# 1. Overview / Tổng quan
### Tiếng Việt
> AL-Library là một dự án cá nhân và miễn phí. Về cơ bản, nó là một thư viện bao hàm nhiều thư viện khác giúp việc sử dụng dễ dàng hơn.
>
> Thư viện cung cấp các phương thức để bạn có thể làm việc cơ bản trong Java như: hỗ trợ các Thành phần Swing, Băm mật mã học, dịch vụ gửi email SMTP, trò chuyện với ChatGPT bot, nhận diện khuôn mặt, nhận dạng khuôn mặt... và hơn thế nữa... Dành lời cảm ơn to lớn đến với [Raven](https://github.com/DJ-Raven), người đàn ông tuyệt vời cùng các dự án Java Swing UI của anh ấy.
>
> Nếu bạn gặp bất kì vấn đề gì hoặc có mong muốn gì, đừng ngần ngại mà hãy [liên hệ tôi](https://github.com/AnLaVN), tôi sẽ phản hồi sớm nhất có thể.
### English
> AL-Library is a personal and free project. It's basically a library that includes many other libraries that make it easier to use.
>
> The library provides methods for you to do basic work in Java such as: Swing Components support, Cryptographic Hashing, SMTP email service, chat with ChatGPT bot, face detection, face recognition... and more... Big thanks to [Raven](https://github.com/DJ-Raven) who great man with his Java Swing UI projects.
> 
> If you have any problems or have any wishes, do not hesitate to [contact me](https://github.com/AnLaVN), I will respond as soon as possible.



# 2. Features / Tính năng
<details>
	<summary>anlavn.ai - Provide AI related libraries / Cung cấp các thư viện liên quan đến AI</summary>
	<ol>
		<li><a href="#311-yourgpt">YourGPT</a></li>
	</ol>
</details>
<details>
	<summary>anlavn.file - Provides file related libraries / Cung cấp các thư viện liên quan đến tập tin</summary>
	<ol>
		<li><a href="#321-excel">Excel</a></li>
		<li><a href="#322-log">Log</a></li>
		<li><a href="#323-nativelibrary">NativeLibrary</a></li>
		<li><a href="#324-objectdata">ObjectData</a></li>
		<li><a href="#325-properties">Properties</a></li>
		<li><a href="#326-raw">Raw</a></li>
		<li><a href="#327-zip">Zip</a></li>
	</ol>
</details>
<details>
	<summary>anlavn.hash - Provides cryptographic hash function related libraries / Cung cấp các thư viện liên quan đến hàm băm mật mã học</summary>
	<ol>
		<li><a href="#331-aes">AES</a></li>
		<li><a href="#332-bcrypt">BCrypt</a></li>
		<li><a href="#333-md5">MD5</a></li>
		<li><a href="#334-sha256">SHA256</a></li>
	</ol>
</details>
<details>
	<summary>anlavn.net - Provide Internet related libraries / Cung cấp các thư viện liên quan đến Internet</summary>
	<ol>
		<li><a href="#341-docnet">DocNet</a></li>
		<li><a href="#342-email">Email</a></li>
		<li><a href="#343-license">License</a></li>
		<li><a href="#344-network">Network</a></li>
		<li><a href="#345-randomorg">RandomORG</a></li>
	</ol>
</details>
<details>
	<summary>anlavn.opencv - Provide OpenCV related libraries / Cung cấp các thư viện liên quan đến OpenCV</summary>
	<ol>
		<li><a href="#351-facedetection">FaceDetection</a></li>
		<li><a href="#352-facerecognition">FaceRecognition</a></li>
	</ol>
</details>
<details>
	<summary>anlavn.ui - Provide UI related libraries / Cung cấp các thư viện liên quan đến UI</summary>
	<ol>
		<li><a href="#361-avatarpanel">AvatarPanel</a> (Add to Palette from JAR)</li>
		<li><a href="#362-chatbox">ChatBox</a> (Add to Palette from JAR)</li>
		<li><a href="#363-combobox">ComboBox</a> (Add to Palette from JAR)</li>
		<li><a href="#364-imagepanel">ImagePanel</a> (Add to Palette from JAR)</li>
		<li><a href="#365-liquidprogress">LiquidProgress</a> (Add to Palette from JAR)</li>
		<li><a href="#366-mode">Mode</a></li>
		<li><a href="#367-notification">Notification</a></li>
		<li><a href="#368-progressbar">ProgressBar</a> (Add to Palette from JAR)</li>
		<li><a href="#369-scrollbar">ScrollBar</a></li>
		<li><a href="#3610-datechooser">DateChooser</a></li>
		<li><a href="#3611-timepicker">TimePicker</a></li>
		<li><a href="#3612-jnafilechooser">JnaFileChooser</a></li>
	</ol>
</details>
<details>
	<summary>Java Doc</summary>
	<ol>
		<li><a href="https://anlavn.github.io/AL-Library/AL-Library_JavaDoc/English/">English</a></li>
		<li><a href="https://anlavn.github.io/AL-Library/AL-Library_JavaDoc/Vietnamese/">Tiếng Việt</a></li>
	</ol>
</details>



# 3. Quick Guide / Hướng dẫn nhanh
[See details in project example / Xem chi tiết trong dự án mẫu](https://github.com/AnLaVN/AL-Library/tree/Releases/AL-Library_Example)

### PayOS
- Tích hợp thư viện cổng thanh toán điện tử [PayOS](https://payos.vn)

⚠️ ***Tính năng này chỉ dành cho phiên bản Tiếng Việt / This feature is only for Vietnamese version*** ⚠️

---

## 3.1 AI - Provide AI related libraries / Cung cấp các thư viện liên quan đến AI

### 3.1.1 YourGPT
- Lớp YourGPT hỗ trợ chạy mô hình ngôn ngữ lớn bằng cách sử dụng các tệp nhị phân dựng sẵn của llama.cpp.
- The YourGPT class supports to run the Large language model using prebuilt binaries of llama.cpp.

``` java
import anlavn.ai.YourGPT;

YourGPT.loadModule();       // Load module default.
YourGPT.params.put("--host", "localhost");
YourGPT.params.put("--port", "3000");
YourGPT.params.put("-ngl", "25");
YourGPT.params.put("-c", "2048");
YourGPT.start();            // Start YGPT process with previous parameters.
Thread.sleep(60000);        // Wait 60s.
YourGPT.destroy();          // Forcibly destroy YGPT process.
```
See more / Xem thêm [ExampleYourGPT](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ai/ExampleYourGPT.java)

---

## 3.2 FILE - Provides file related libraries / Cung cấp các thư viện liên quan đến tập tin

### 3.2.1 Excel
- Lớp Excel hỗ trợ đọc/ghi dữ liệu từ/vào tệp excel.
- The Excel class support to read/write data from/to excel file.

``` java
import anlavn.file.Excel;
		
//Write
ArrayList<Object[]> myData = new ArrayList<>();         //declare array to store data to write to Excel file
myData.add(new Object[]{4, 68.11, "AnLaVN", true});     //add data
myData.add(new Object[]{3, 69.11, "AnLaVN", false});    //add data
Excel.WriteExcel("myExcel.xlsx", "mySheet", myData.iterator()); //convert to Iterator and write to Excel file
		
//Read
Iterator<Object[]> myExcel = Excel.ReadExcel("myExcel.xlsx", "mySheet");    //declare Iterator to store data from Excel file
while (myExcel.hasNext()) { //loop to take every row from Iterator
	Object[] row = myExcel.next();  //get row data
	System.out.println(row[0]+" | "+row[1]+" | "+row[2]+" | "+row[3]);  //print it
}
```
See more / Xem thêm [ExampleExcel](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/file/ExampleExcel.java)

---

### 3.2.2 Log
- Lớp Log hỗ trợ xuất thông tin ra tệp nhật ký và màn hình console.
- The Log class supports to print to console and output log file.

``` java
import anlavn.file.Log;

Log.add("Your text");   //write text to log file, will auto create as Logs folder.
System.out.println("File path: " + Log.getFilePath());  //print path of log file.
Log.closeFile();    //close file if your dont use anymore.
```
See more / Xem thêm [ExampleLog](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/file/ExampleLog.java)

---

### 3.2.3 NativeLibrary
- Lớp NativeLibrary hỗ trợ tải các thư viện động. 
- The NativeLibrary class supports to loading dynamic libraries. 

``` java
import anlavn.file.NativeLibrary;

NativeLibrary.load("path/YourLib.dll");
```
See more / Xem thêm [ExampleNativeLibrary](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/file/ExampleNativeLibrary.java)

---

### 3.2.4 ObjectData
- Lớp ObjectData hỗ trợ ghi và đọc dữ liệu của đối tượng vào tệp tại vị trí được chỉ định.
- The ObjectData class supports write and read object data to file at specific location.

``` java
import anlavn.file.ObjectData;

ObjectData.writeData("myFile.dat", new myObject("AnLaVN", 19)); //write new object to myFile.dat
myObject myobj = (myObject) ObjectData.readData("myFile.dat");  //read object from myFile.dat, store in myobj variable
System.out.println("My name: " + myobj.getName());  //print value of object
System.out.println("My age: " + myobj.getAge());
```

The myObject class.
``` java
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
```
See more / Xem thêm [ExampleObjectData](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/file/ExampleObjectData.java)

---

### 3.2.5 Properties
- Lớp Properties hỗ trợ để lấy giá trị của các thuộc tính tại vị trí được chỉ định.
- The Properties class supports to get value of properties at specific location.

``` java
import anlavn.file.Properties;

String lang = "EN"; //"VN" if you want using vietnamese languages, "EN" if you want english
Properties proper = new Properties("src/example/anlavn/file/myProperties_" + lang + ".properties");    //load properties file
System.out.println("Properties of hello key: " + proper.getString("hello"));    //print value of key in file
```
The myProperties_VN.properties file ![image](https://user-images.githubusercontent.com/90229487/209496791-a1abfc66-77e0-48e5-94ce-2b83cb68c703.png)  
The myProperties_EN.properties file ![image](https://user-images.githubusercontent.com/90229487/209496563-fbad72f0-ecdf-4edd-bf37-238f63a2f94b.png)  
See more / Xem thêm [ExampleProperties](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/file/ExampleProperties.java)

---

### 3.2.6 Raw
- Lớp Raw hỗ trợ ghi và đọc chuỗi dữ liệu Thô vào tệp tại vị trí được chỉ định.
- The Raw class supports write and read string data to file at specific location.

``` java
import anlavn.file.Raw;

Raw raw = new Raw("myFile.txt");    //create myFile.txt
raw.writeData("your text"); //write data to file
System.out.println(raw.readData()); //read data from file
raw.closeFile();    //close file if you dont use anymore
```
See more / Xem thêm [ExampleRaw](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/file/ExampleRaw.java)

---

### 3.2.7 Zip
- Lớp Zip hỗ trợ giải nén tệp zip vào thư mục của bạn.
- The Zip class supports to extract a zip file to your directories.

``` java
import anlavn.file.Zip;

Zip.extract("myFileZip.zip", "ZipFolder");  //Extract myFileZip.zip to ZipFolder directory
```
See more / Xem thêm [ExampleZip](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/file/ExampleZip.java)

---


## 3.3 HASH - Provides cryptographic hash function related libraries / Cung cấp các thư viện liên quan đến hàm băm mật mã học

### 3.3.2 AES
- Lớp AES hỗ trợ mã hóa và giải mã một Chuỗi, sử dụng khóa bảo mật. 
- The AES class supports encryption and decryption a String, using a security key.

``` java
import anlavn.hash.AES;

String 	orgStr = "This is original string.", //declare original string need to hash
	myKey  = "This is key to hash ",     //declare my security key to hash string
	hashStr= AES.Encrypt(orgStr, myKey); //hash original string with security key
System.out.println("Hash AES of orgStr: " + hashStr);   //print hash string
System.out.println("My original string: " + AES.Decrypt(hashStr, myKey));   //decrypt hash string and print it
```
See more / Xem thêm [ExampleAES](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/hash/ExampleAES.java)

---

### 3.3.2 BCrypt
- Lớp BCrypt hỗ trợ băm mật khẩu Blowfish kiểu OpenBSD cho Java.
- The BCrypt class supports to OpenBSD-style Blowfish password hashing for Java.

``` java
import anlavn.hash.BCrypt;

String orgStr = "This is original string.",               	//declare original string need to hash
      hashStr = BCrypt.Encrypt(orgStr, BCrypt.genSalt());   //hash original string, only supports encryption.
System.out.println("Hash BCrypt of orgStr: " + hashStr);	//print hash string
System.out.println("is orgStr match: " + BCrypt.Check(orgStr, hashStr));  //check if original string is match with hash string
```
See more / Xem thêm [ExampleBCrypt](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/hash/ExampleBCrypt.java)

---

### 3.3.3 MD5
- Lớp MD5 chỉ hỗ trợ mã hóa đối tượng, giải mã nó là bất khả thi.
- The MD5 class only supports object encryption, decryption it is impossible.

``` java
import anlavn.hash.MD5;
	
String	orgStr = "This is original string.", //declare original string need to hash
	hashStr= MD5.Encrypt(orgStr); 		//hash original string, only supports encryption, decryption it is impossible.
System.out.println("Hash MD5 of orgStr: " + hashStr);   //print hash string
```
See more / Xem thêm [ExampleMD5](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/hash/ExampleMD5.java)

---

### 3.3.4 SHA256
- Lớp SHA256 chỉ hỗ trợ mã hóa đối tượng, giải mã nó là bất khả thi.
- The SHA256 class only supports object encryption, decryption it is impossible.

``` java
import anlavn.hash.SHA;
import anlavn.hash.SHA.Types;
	
String orgStr = "This is original string.", //declare original string need to hash
      hashStr = SHA.Encrypt(Types.SHA_256, orgStr); //hash original string, only supports encryption, decryption it is impossible.
System.out.println("Hash SHA256 of orgStr: " + hashStr);   //print hash string
```
See more / Xem thêm [ExampleSHA](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/hash/ExampleSHA.java)

---


## 3.4 NET - Provide Internet related libraries / Cung cấp các thư viện liên quan đến Internet

### 3.4.1 DocNet
- Lớp DocNet hỗ trợ đọc tài liệu trực tuyến từ URL.
- The DocNet class supports to read an online document from URL.

``` java
import anlavn.net.DocNet;

DocNet docnet = new DocNet("https://raw.githubusercontent.com/AnLaVN/AL-Library/Releases/LICENSE.md"); //set address of network document
System.out.println(docnet.readAllLine());   //read all line in network document
docnet.saveAs();    //save document to file in local
```
See more / Xem thêm [ExampleDocNet](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/net/ExampleDocNet.java)

---

### 3.4.2 Email
- Lớp Email hỗ trợ tạo một SMTP để gửi email.
- The Email class supports create a SMTP to send email.

``` java
import anlavn.net.Email;

Email mail = new Email("youremail@domain.com", "yourpass");  //setup your SMTP service
        
mail.setEmail("Tittle Email", "<h1>Chào cậu, đây là email gửi từ bình an</h1>");    //setup your email content
mail.addSetTO("yourfriend1@gmail.com", "yourfriend12@gmail.com");                   //setup set type TO
mail.addSetTO(new HashSet<>(Arrays.asList("yourfriend1@gmail.com", "yourfriend12@gmail.com")));
mail.addSetCC("yourfriend13@fpt.edu.vn");
mail.addSetAttachments("C:/path/to/your/file.png", "C:/path/to/your/meme.gif");
mail.sendEmail();
```
See more / Xem thêm [ExampleEmail](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/net/ExampleEmail.java)

---

### 3.4.3 License
- Lớp License hỗ trợ đánh dấu bản quyền cho dự án.
- The License class supports marks the copyright for the project.

``` java
import anlavn.net.License;

static { 
	// Check the license authority before run code. The program will continue if enough permissions. Else stop/delete the program.
    License.check("&glwyD16e6JTgk6XuNYEj&D9WzOfqTMaJsmRNZ4+LNGIfSXH6QBbiYKVh/9a+SqDk=");
}
```

Using [License Creator](https://github.com/AnLaVN/AL-Library/tree/Releases/License_Creator) tool to generate LicenseKey and [LicenseFile](https://github.com/AnLaVN/LICENSE/blob/Releases/AL-Library_License.properties)

See more / Xem thêm [ExampleLicense](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/net/ExampleLicense.java)

---

### 3.4.4 Network
- Lớp Network hỗ trợ lấy thông tin mạng: Thông tin WLAN, địa chỉ IPv4.
- The Network class supports get network information: WLAN information, address IPv4.

``` java
import anlavn.net.Network;
import static anlavn.net.Network.Key.*;
	
System.out.println("My IPv4: " + Network.myIPv4());             //print my public ip, not local ip
System.out.println("My Wlan: " + Network.myWLAN().get(SSID));   //print wlan ssid name
```
See more / Xem thêm [ExampleNetwork](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/net/ExampleNetwork.java)

---

### 3.4.5 RandomORG
- Lớp RandomORG hỗ trợ tạo số thực sự ngẫu nhiên từ random.org
- The RandomORG class supports to create true random numbers from random.org

``` java
import anlavn.net.RandomORG;
	
System.out.println(RandomORG.getInteger(0, 10, 10));            //get a truly random integer from 0 to 10 in decimal
System.out.println(RandomORG.getSequence(0, 10));               //get truly random order integer from 0 to 10
System.out.println(RandomORG.getString(10, true, true, true));  //get a truly random string with digit, upper, lower case and length equal 10
System.out.println(RandomORG.getQuota());                       //get number quota bits remaining of your IP address.
```
See more / Xem thêm [ExampleRandomORG](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/net/ExampleRandomORG.java)

---


## 3.5 OpenCV - Provide OpenCV related libraries / Cung cấp các thư viện liên quan đến OpenCV

### 3.5.1 FaceDetection
- Lớp FaceDetection hỗ trợ nhận diện khuôn mặt bằng thư viện thị giác máy tính lớn nhất thế giới - OpenCV.
- The FaceDetection class supports to face detection using the world’s largest computer vision library - OpenCV.

``` java
import anlavn.opencv.FaceDetection;
	
FaceDetection.loadModule(); //load module to detect
FaceDetection.setDetectPanel(myPanel, 20);  //set JPanel where will display video capture from camera with rounded corners

//set how the rectangle display when detect a face,
FaceDetection.setDetectFace(true, Color.GREEN, 2);  //this line mean will detect face and display with green rectangle and thickness 2px
//FaceDetection.setDetectFace(false, Color.GREEN, 2); //this line mean will not detect face and not display any rectangle no matter what color and how thick it is 

FaceDetection.startDetection(0);  //start capture video from camera 0 and detect face, if you was setDetectFace(true, ..., ...)
//FaceDetection.endDetection();   //end capture video
```
See more / Xem thêm [ExampleFaceDetection](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/opencv/ExampleFaceDetection.java)

---

### 3.5.2 FaceRecognition
- Lớp FaceRecognition hỗ trợ nhận dạng khuôn mặt trong java, sử dụng chương trình python được biên dịch.
- The FaceRecognition class supports to face recognition in java, using python program compiled.

⚠️ ***Tính năng này chỉ dành cho hệ điều hành Windows / This feature is only for Windows operating system*** ⚠️

``` java
import anlavn.opencv.FaceRecognition;

FaceRecognition.loadModule();  //check module for recognition, download automatically if you don't have one
//set image for original face and test face using URL.
//network connection is required to use the module regardless if you have set image from URL or not
FaceRecognition.setImageOrginal("https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTNU14t4OtvdSZf-rTJAQWI6LdTIw5nYCYT1V3SfHgWja6cYMbG");
FaceRecognition.setImageTesting("https://nld.mediacdn.vn/2021/1/5/d9db633fe9c98429ec9025ca0950f241-16098228091571816318835.jpg");
FaceRecognition.setRequirementPercent(60.0);//set a percentage requirement for face recognition, the higher the stricter

System.out.println(FaceRecognition.Recognition());//recognition face and get result
System.out.println(FaceRecognition.getPercent());//get percent was recognition
System.out.println(FaceRecognition.isMatch());//get value if match, true if percent was recognition higher or equal with percentage requirement
```
See more / Xem thêm [ExampleFaceRecognition](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/opencv/ExampleFaceRecognition.java)

---


## 3.6 UI - Provide UI related libraries / Cung cấp các thư viện liên quan đến UI
	
### 3.6.1 AvatarPanel
- Lớp AvatarPanel hỗ trợ hiển thị một hình ảnh đại diện được cắt tròn.
- The AvatarPanel class supports display a cropped avatar picture.

``` java
import anlavn.ui.AvatarPanel;

AvatarPanel avatar = new AvatarPanel();
avatar.setPic("myImage.png"); //set picture for panel from file
avatar.setPic("https://i.pinimg.com/564x/b7/d2/62/b7d262d9ab6397f959a2030f65947b4f.jpg"); //set picture for panel from url
```
See more / Xem thêm [ExampleAvatarPanel](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleAvatarPanel.java)

---

### 3.6.2 ChatBox
- Lớp ChatBox hỗ trợ hiển thị hộp tin nhắn như messenger.
- The ChatBox class supports display a message box like messenger.

``` java
import anlavn.ui.ChatBox;
	
ChatBox chat = new ChatBox();
chat.addRightBubble("this is right side text"); //add bubble text in right side
chat.addLeftBubble("this is left side text"); //add bubble text in left side
chat.addNotifiBox("this is notification text"); //add notification text in center
```
See more / Xem thêm [ExampleChatBox](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleChatBox.java)

---

### 3.6.3 ComboBox
- Lớp ComboBox hỗ trợ tạo comboBox đẹp mắt với chế độ sáng và tối.
- The ComboBox class supports to create a beautiful comboBox with light and dark mode.

``` java
import anlavn.ui.ComboBox;

ComboBox comboBox = new ComboBox();
comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "item 1", "item2" })); //use as normal combobox
```
See more / Xem thêm [ExampleComboBox](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleComboBox.java)

---

### 3.6.4 ImagePanel
- Lớp ImagePanel hỗ trợ hiển thị hình ảnh có thể thay đổi kích thước.
- The ImagePanel class supports displaying resizable images.
``` java
import anlavn.ui.ImagePanel;

ImagePanel image = new ImagePanel();
image.setPic("myImage.png"); //set picture for panel from file
```
See more / Xem thêm [ExampleImagePanel](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleImagePanel.java)

---

### 3.6.5 LiquidProgress
- Lớp LiquidProgress hỗ trợ xuất thanh tiến trình dạng chất lỏng hiện đại.
- The LiquidProgress supports to export modern liquid progress.

``` java
import anlavn.ui.LiquidProgress;

LiquidProgress liquidProgress = new LiquidProgress();
liquidProgress1.setValue(50);
```
See more / Xem thêm [ExampleLiquidProgress](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleLiquidProgress.java)

---

### 3.6.6 Mode
- Lớp Mode hỗ trợ thay đổi chế độ từ sáng sang tối, component từ nimbus sang giao diện windows.
- The Mode class supports change mode from light to dark, component from nimbus to windows look and feel.

``` java
import anlavn.ui.Mode;
	
Mode.setMode(true); //set true is dark mode, false is light
Mode.setModeComponent(yourComponent); //set the component will apply mode change
```
See more / Xem thêm [ExampleMode](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleMode.java)

---

### 3.6.7 Notification
- Lớp Notification hỗ trợ tạo thông báo popup.
- The Notification class supports to create a animation popup notification.
``` java
import anlavn.ui.Notification;
	
//setup the notification will popup
Notification noti = new Notification(this, Notification.Type.WARNING, Notification.Location.TOP_CENTER, "Notification");
noti.showNotification(); //show popup Notification
```
See more / Xem thêm [ExampleNotification](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleNotification.java)

---

### 3.6.8 ProgressBar
- Lớp ProgressBar hỗ trợ xuất thanh tiến trình hiện đại.
- The ProgressBar supports to export modern progress bar.

``` java
import anlavn.ui.ProgressBar;
	
ProgressBar progressBar1 = new ProgressBar();
progressBar1.setValue(50);
```
See more / Xem thêm [ExampleProgressBar](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleProgressBar.java)

---

### 3.6.9 ScrollBar
- Lớp ScrollBar hỗ trợ xuất thanh cuộn hiện đại.
- The ScrollBar class supports export modern scroll bar.

``` java
import anlavn.ui.ScrollBar;

yourJScrollPanel.setVerticalScrollBar(new ScrollBar());
```
See more / Xem thêm [ExampleScrollBar](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleScrollBar.java)

---

### 3.6.10 DateChooser
- Lớp DateChooser hỗ trợ hiển thị bộ chọn ngày ở dạng hiện đại.
- The DateChooser class supports to show modern form date chooser.

``` java
import anlavn.ui.datechooser.DateChooser;

DateChooser dateChooser = new DateChooser();
dateChooser.setReferenceLabel(yourLabel); //set JLabel where will display day was choose
dateChooser.showPopup();  //show day chooser as popup
```
See more / Xem thêm [ExampleDateChooser](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleDateChooser.java)

---

### 3.6.11 TimePicker
- Lớp TimePicker hỗ trợ hiển thị bộ chọn thời gian hiện đại.
- The TimePicker class supports to show modern time picker.

``` java
import anlavn.ui.timechooser.TimePicker;

TimePicker timePicker = new TimePicker();
timePicker.setDisplayTextLabel(yourLabel); //set JLabel where will display day was choose
//show time picker as popup as position
timePicker.showPopup(this,
	(getWidth() - timePicker.getPreferredSize().width) / 2,
	(getHeight() - timePicker.getPreferredSize().height) / 2);
```
See more / Xem thêm [ExampleTimePicker](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleTimePicker.java)

---

### 3.6.12 JnaFileChooser
- JnaFileChooser là một trình bao bọc xung quanh trình chọn tệp và trình duyệt thư mục gốc của Windows nằm trong Swing JFileChooser
- JnaFileChooser is a wrapper around the native Windows file chooser and folder browser that falls back to the Swing JFileChooser.

``` java
import anlavn.ui.filechooser.JnaFileChooser;
	
JnaFileChooser SelectPic = new JnaFileChooser();
SelectPic.addFilter("Image", "jpeg", "jpg", "png"); //add file filter for file chooser
if(SelectPic.showOpenDialog(this)){ //if choose file
	System.out.println(SelectPic.getSelectedFile().getAbsolutePath());	//get absolute path of choose file
}
```
See more / Xem thêm [ExampleJnaFileChooser](https://github.com/AnLaVN/AL-Library/blob/Releases/AL-Library_Example/src/example/anlavn/ui/ExampleJnaFileChooser.java)

---

# 4. Download / Tải xuống

## 4.1 External JAR
<p align="center">
	<a href="https://github.com/AnLaVN/AL-Library/releases"><img src="https://img.shields.io/github/v/release/AnLaVN/AL-Library"></a><br><br>
</p>


## 4.2 Maven Central Repository
<p align="center">
	<img src="https://img.shields.io/maven-central/v/io.github.AnLaVN/AL-Library_VN"><br><br>
</p>

- AL-Library Vietnamses Version
```xml
<dependency>
	<groupId>io.github.AnLaVN</groupId>
	<artifactId>AL-Library_VN</artifactId>
	<version>5.70.10</version>
</dependency>
```

- AL-Library English Version 
```xml
<dependency>
	<groupId>io.github.AnLaVN</groupId>
	<artifactId>AL-Library_EN</artifactId>
	<version>5.70.10</version>
</dependency>
```

## 4.3 Repository Link
- [mvnrepository.com](https://mvnrepository.com/artifact/io.github.AnLaVN)
  - [AL-Library_EN / mvnrepository.com](https://mvnrepository.com/artifact/io.github.AnLaVN/AL-Library_EN)
  - [AL-Library_VN / mvnrepository.com](https://mvnrepository.com/artifact/io.github.AnLaVN/AL-Library_VN)
	
- [search.maven.org](https://search.maven.org/search?q=g:io.github.AnLaVN)
  - [AL-Library_EN / search.maven.org](https://search.maven.org/artifact/io.github.AnLaVN/AL-Library_EN)
  - [AL-Library_VN / search.maven.org](https://search.maven.org/artifact/io.github.AnLaVN/AL-Library_VN)
	
- [repo1.maven.org](https://repo1.maven.org/maven2/io/github/AnLaVN)
  - [AL-Library_EN / repo1.maven.org](https://repo1.maven.org/maven2/io/github/AnLaVN/AL-Library_EN)
  - [AL-Library_VN / repo1.maven.org](https://repo1.maven.org/maven2/io/github/AnLaVN/AL-Library_VN)
