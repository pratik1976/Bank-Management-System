package bank.management.system1;

import java.sql.*;

public class cons {
//There are 5 steps in JDBC connectivity
    //Step1: Register the Driver
    //Step2: Create Connection
    //Step3: Create statement
    //Step4: Execute Query
    //Step5: Close Connnection
    
    Connection c; //Global Object S2
    Statement s;  //S3
    public cons(){
        //exception handling because mysql is external entity, there are chances of error. Error will be at run time not at compile time
        try{
            //Step1:
         //   Class.forName(com.mysql.cj.jdbc.Driver); 
            //Step2:
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem1", "root","root");
            
            //Step3:
            s = c.createStatement();
            
            
        }catch(Exception e){
            
        }
    }
 
}
