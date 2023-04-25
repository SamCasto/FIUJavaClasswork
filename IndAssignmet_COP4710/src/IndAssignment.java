import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class IndAssignment {
	
	

	//Strings needed for logging into the DB
		private static final String DB_URL = "jdbc:mysql://localhost:3306/cop4710db";
		private static final String DB_USER = "root";
		private static final String DB_PASS = "Babybear1";
		//strings for students logging in
	    private static int studentID = 0;
	    private static String firstName = "";
	    //strings for students registering
	    
	    //strings for CRUD operations
	    
	    //strings for select statements
	    
	    //DB connection methods
	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	    }
	    static Connection connection;
	    private JPasswordField firstNameTextField;

    public static void main(String[] args) throws SQLException {
    	
    	
    	
    	//all of this needs to happen during the login
        Connection connection = getConnection();
        
        Statement statement = connection.createStatement();
        
        //statement.execute("CREATE TABLE Department(id INT PRIMARY KEY, depName varchar(255))");
        
        
        statement.close();
        connection.close();
        System.out.println("we finished our processes");
    }
}
