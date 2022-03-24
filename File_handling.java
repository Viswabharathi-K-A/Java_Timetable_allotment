import java.io.*;
import java.util.*;

abstract class write_file{
    abstract void write_files(String a, String b);
}


interface read_file{
    void read_files();
}


 class create_file{
     create_file(String a){
    try{
        File obj = new File(a);
        if(!obj.exists()){
            obj.createNewFile();
            System.out.println("File created");
        }
        else{
            System.out.println("File already exists");
        }
    }
    catch(IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
}
 }


 class write_exam_timetable extends write_file{
    void write_files(String a, String b){
    try{
        FileWriter obj1 = new FileWriter("time_table.txt",true);
        obj1.write(a+"\t"+b+"\n");
        obj1.close();
}
    catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
}


class write_register_student extends write_file{
    void write_files(String a, String b){
    try{
        FileWriter obj1 = new FileWriter("Stu_details.txt",true);
        obj1.write(a+"\t"+b+"\n");
        obj1.close();
}
    catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
}


 class read_time_table implements read_file{
    public  void read_files(){
    schedulescreen q1 =new schedulescreen();  // schedulescreen is a class defined in the schedulescreen.java swing file   
    try{
        FileReader obj1 = new FileReader("time_table.txt");
        Scanner myReader = new Scanner(obj1);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            // System.out.println(data);
           q1.jTextArea1.append(data+"\n");
            
    }
    myReader.close();
    q1.setVisible(true);
 } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
}  
 } 
 
 class read_register_student{
    public boolean read_files(String a, String b){
    int c = 0;    
    try{
        FileReader obj1 = new FileReader("Stu_details.txt");
        Scanner myReader = new Scanner(obj1);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String word[]=data.split("\t");
            if(word[0].equals(a) && word[1].equals(b))
            {
               c =1;
               break; 
            }
            
            //System.out.println(data);        
    }
    myReader.close();
 } 
 catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    if(c==1){
        return true;
    }
    else{
        return false;
    }
}  
 }


class File_handling{
    public static void main(String[] args){
              
}
}