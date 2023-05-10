import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.System;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.CallableStatement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class GUI {

	private JFrame frame;
	private JTabbedPane pane;
	
	
	
	
	
	//Strings needed for logging into the DB
	private static final String DB_URL = "jdbc:mysql://localhost:3306/cop4710db";
	private static final String DB_USER = "root";
	private static final String DB_PASS = "";
	//strings for students registering
	private static String rFirstName = "";
	private static String rLastName = "";
	private static String rAddress = "";
	private static String rPhoneNum = "";
	private static String rEmail = "";
	private static String rDOB = "";
	private static String mySQLDateString = "";
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");;
	//strings for students logging in
	private static int lStuID = 0;
	private static String lFirstName = "";
	private static final String LOGIN = "SELECT * FROM student where id = ? and firstName = ?";
	//strings for CRUD operations
	static Connection connection;
	private static java.sql.CallableStatement query;//value will be updated to proper string value
	private static final String INSERT_STUDENT = "INSERT INTO student(firstName, lastName, address, phoneNum, email, dob)\r\n"
			+ "    VALUES (?,?,?,?,?,?);";
	private static final String DELETE_STUDENT = "DELETE FROM student WHERE id = ?";
	private static final String UPDATE_STUDENT = "UPDATE student SET firstName = ?, lastName = ?,"
			+ "address = ?, phoneNum = ?, email = ?, dob = ? WHERE id = ?";
	
	
	//strings for select statements
	private static final String STUDENT_ID_SELECT = "SELECT * FROM student WHERE id = ?";
	private static final String STUDENT_LASTNAME_SELECT = "SELECT * FROM student WHERE lastName = ?";
	private static final String STUDENT_BEFOREDOB_SELECT = "SELECT * FROM student where dob <= ?";
	private static final String STUDENT_AFTERDOB_SELECT = "SELECT * FROM student where dob >= ?";
	private static final String STUDENT_EMAIL_SELECT = "SELECT * FROM student where email = ?";
	private static final String STUDENT_FULLNAME_SELECT = "SELECT * FROM student where firstName = ?"
			+ " and lastName = ?";
	ResultSet results;//holds our result sets so that we can view the selected information
	private static String qFirstName = "";
	private static String qLastName = "";
	private static String qAddress = "";
	private static String qPhoneNum = "";
	private static String qEmail = "";
	private static String qDOB = "";
	private static int qStuID = 0;
	//DB connection methods
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	private String newline = System.getProperty("line.separator");
	

	private JTextField rFirstNameTField;
	private JTextField rLastNameTField;
	private JTextField rAddressTField;
	private JTextField rPhoneNumTField;
	private JTextField rEmailTField;
	private JTextField rDOBTField;
	private JTextField LStuIDTField;
	private JTextField LFirstNameTField;
	private JLabel selectLabel;
	private JComboBox selectComboBox;
	private JLabel queryLoginLable;
	private JButton insertButton;
	private JButton queryButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JLabel qInstruLabel;
	private JTextField qAddressTField;
	private JTextField qLastNameTField;
	private JTextField qFirstNameTField;
	private JTextField qPhoneNumTField;
	private JTextField qEmailTField;
	private JTextField qDOBTField;
	private JTextField qStuIDTField;
	private JLabel qStuIDLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
					connection =  getConnection();
					if(connection != null)
						System.out.println("We connected");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//closing our database connection on window close
				try {
					
					connection.close();
					System.out.println("Closed connection");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pane = new JTabbedPane();
		frame.getContentPane().add(pane);
		
		JPanel registerPanel = new JPanel();
		pane.addTab("Register", null, registerPanel, null);
		registerPanel.setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(10, 11, 70, 30);
		registerPanel.add(firstNameLabel);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(10, 52, 70, 30);
		registerPanel.add(lastNameLabel);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(10, 93, 70, 30);
		registerPanel.add(addressLabel);
		
		rFirstNameTField = new JTextField();
		rFirstNameTField.setBounds(80, 16, 96, 20);
		registerPanel.add(rFirstNameTField);
		rFirstNameTField.setColumns(10);
		
		rLastNameTField = new JTextField();
		rLastNameTField.setBounds(80, 57, 96, 20);
		registerPanel.add(rLastNameTField);
		rLastNameTField.setColumns(10);
		
		rAddressTField = new JTextField();
		rAddressTField.setBounds(80, 98, 96, 20);
		registerPanel.add(rAddressTField);
		rAddressTField.setColumns(10);
		
		JLabel phoneNumLabel = new JLabel("Phone Number: No -");
		phoneNumLabel.setBounds(197, 11, 127, 30);
		registerPanel.add(phoneNumLabel);
		
		rPhoneNumTField = new JTextField();
		rPhoneNumTField.setColumns(10);
		rPhoneNumTField.setBounds(357, 16, 114, 20);
		registerPanel.add(rPhoneNumTField);
		
		JLabel emailLabel = new JLabel("Email:");
		emailLabel.setBounds(197, 52, 70, 30);
		registerPanel.add(emailLabel);
		
		rEmailTField = new JTextField();
		rEmailTField.setColumns(10);
		rEmailTField.setBounds(357, 57, 114, 20);
		registerPanel.add(rEmailTField);
		
		JLabel dobLabel = new JLabel("DOB: (YYYY-MM-DD)");
		dobLabel.setBounds(197, 93, 150, 30);
		registerPanel.add(dobLabel);
		
		rDOBTField = new JTextField();
		rDOBTField.setColumns(10);
		rDOBTField.setBounds(357, 98, 114, 20);
		registerPanel.add(rDOBTField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//user wants to register
				
				if(rFirstNameTField.getText().length() > 0 && rLastNameTField.getText().length() > 0 &&
						rAddressTField.getText().length() > 0 && rPhoneNumTField.getText().length() > 0 
						&& rEmailTField.getText().length() > 0 && rDOBTField.getText().length() > 0) {
					//if all true then all fields have some form of value
					try {
						rFirstName = rFirstNameTField.getText();
						rLastName = rLastNameTField.getText();
						rAddress = rAddressTField.getText();
						rPhoneNum = rPhoneNumTField.getText();
						rEmail = rEmailTField.getText();
						rDOB = rDOBTField.getText();
						java.util.Date date = dateFormat.parse(rDOB);
						mySQLDateString = dateFormat.format(date);
					}
					catch (Exception E) {
						
					}
					//at this point we have all our values assigned to variables and need to
					//call our methods to attempt to insert the new student and show their ID
					try {
						query = connection.prepareCall(INSERT_STUDENT);
						query.setString(1, rFirstName);
						query.setString(2, rLastName);
						query.setString(3, rAddress);
						query.setString(4, rPhoneNum);
						query.setString(5, rEmail);
						query.setString(6, mySQLDateString);
						query.executeUpdate();
						ResultSet generatedKeys = query.getGeneratedKeys();
						if(generatedKeys.next())
							JOptionPane.showMessageDialog(null, "Your StudentID number is " + 
											generatedKeys.getInt(1) + ". Use this to login.");
					}
					catch (Exception E) {
						JOptionPane.showMessageDialog(null, "Not all values were "
								+ "properly formatted correctly");
					}
					
				}//end of if
				else {
					JOptionPane.showMessageDialog(null, "Please fill out all boxes correctly");
				}
			}
		});//end of registerButton action
		
		registerButton.setBounds(175, 160, 127, 40);
		registerPanel.add(registerButton);
		
		JPanel loginPanel = new JPanel();
		pane.addTab("Login", null, loginPanel, null);
		loginPanel.setLayout(null);
		
		JLabel LStuIDLabel = new JLabel("Student ID:");
		LStuIDLabel.setBounds(39, 34, 87, 38);
		loginPanel.add(LStuIDLabel);
		
		LStuIDTField = new JTextField();
		LStuIDTField.setBounds(173, 43, 96, 20);
		loginPanel.add(LStuIDTField);
		LStuIDTField.setColumns(10);
		
		LFirstNameTField = new JTextField();
		LFirstNameTField.setBounds(173, 83, 96, 20);
		loginPanel.add(LFirstNameTField);
		LFirstNameTField.setColumns(10);
		
		JLabel LFirstNameLabel = new JLabel("First Name:");
		LFirstNameLabel.setBounds(39, 86, 87, 14);
		loginPanel.add(LFirstNameLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//we we need to check if there is correct login values and then open up the query
				//tab for use. I think seeing if there is a value returned is the right way to check
				if(LStuIDTField.getText().length() > 0 && LFirstNameTField.getText().length() > 0) {
					//we at least have input values to use
					try {
						lStuID = Integer.parseInt(LStuIDTField.getText());
						lFirstName = LFirstNameTField.getText();
					}
					catch (Exception E) {
						
					}
					//now we have our values and need to make sure a row is returned, signifying that
					//this person is a student in our database
					try {
						query = connection.prepareCall(LOGIN);
						query.setInt(1, lStuID);
						query.setString(2, lFirstName);
						if(query.execute()) {
							//We have successfully logged in and now need to update the Query
							//panel so that the user has access to it
							updateQuery();
							JOptionPane.showMessageDialog(null, "Logged in successfully.");
						}
							
					}
					catch (Exception E) {
						JOptionPane.showMessageDialog(null, "Not all values were "
								+ "properly formatted correctly");
					}
					
					
				}//end of if statement
				else {
					JOptionPane.showMessageDialog(null, "Please fill out all boxes correctly.");
				}
			}
		});
		loginButton.setBounds(78, 160, 132, 38);
		loginPanel.add(loginButton);
		
		JLabel loginInfoLabel = new JLabel("<html><p>You will use your student ID number"
				+ " and your first name to login to access the Query tab.</p></html> ");
		loginInfoLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginInfoLabel.setVerticalAlignment(SwingConstants.TOP);
		loginInfoLabel.setBounds(325, 46, 132, 147);
		
		loginPanel.add(loginInfoLabel);
		
		JPanel queryPanel = new JPanel();
		pane.addTab("Query", null, queryPanel, null);
		queryPanel.setLayout(null);
		
		queryLoginLable = new JLabel("Please login to access Query functions");
		queryLoginLable.setEnabled(false);
		queryLoginLable.setFont(new Font("Tahoma", Font.PLAIN, 22));
		queryLoginLable.setBounds(37, 22, 389, 73);
		queryPanel.add(queryLoginLable);
		
		selectLabel = new JLabel("<html><p>Select a Select command from the"
				+ " list to perform the action.</p></html>");
		selectLabel.setBounds(41, 154, 203, 36);
		queryPanel.add(selectLabel);
		selectLabel.setVisible(false);
		
		selectComboBox = new JComboBox();
		selectComboBox.addItem("STUDENT_ID_SELECT");
		selectComboBox.addItem("STUDENT_LASTNAME_SELECT");
		selectComboBox.addItem("STUDENT_BEFOREDOB_SELECT");
		selectComboBox.addItem("STUDENT_AFTERDOB_SELECT");
		selectComboBox.addItem("STUDENT_EMAIL_SELECT");
		selectComboBox.addItem("STUDENT_FULLNAME_SELECT");
		selectComboBox.setBounds(254, 147, 217, 36);
		queryPanel.add(selectComboBox);
		
		queryButton = new JButton("Execute Query");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//we have six select statements to prepare for so a switch statement would probably
				//be better than if else
				String temp = selectComboBox.getSelectedItem().toString();
				switch(temp) {
				case("STUDENT_ID_SELECT"):
					//we just need qStuID
					if(qStuIDTField.getText().length() > 0) {
						try {
							qStuID = Integer.parseInt(qStuIDTField.getText());
						}
						catch (Exception E) {
							
						}
						try {
							query = connection.prepareCall(STUDENT_ID_SELECT);
							query.setInt(1, qStuID);
							query.execute();
							results = query.getResultSet();
							
						}
						catch (Exception E) {
							JOptionPane.showMessageDialog(null, "StudentID was not correct.");
						}
					}//end of if statement
					else {
						JOptionPane.showMessageDialog(null, "Did not put in StudentID.");
					}
					break;
				case("STUDENT_LASTNAME_SELECT"):
					//need student lastName entered
					if(qLastNameTField.getText().length() > 0) {
						try {
							qLastName = qLastNameTField.getText();
						}
						catch (Exception E) {
							
						}
						try {
							query = connection.prepareCall(STUDENT_LASTNAME_SELECT);
							query.setString(1, qLastName);
							query.execute();
							results = query.getResultSet();
							
						}
						catch (Exception E) {
							JOptionPane.showMessageDialog(null, "Last name was not correct.");
						}
					}//end of if statement
					else {
						JOptionPane.showMessageDialog(null, "Did not put in last name value.");
					}
					break;
				case("STUDENT_BEFOREDOB_SELECT"):
					//just need DOB
					if(qDOBTField.getText().length() > 0) {
						try {
							qDOB = qDOBTField.getText();
							java.util.Date date = dateFormat.parse(qDOB);
							mySQLDateString = dateFormat.format(date);
						}
						catch (Exception E) {
							
						}
						try {
							query = connection.prepareCall(STUDENT_BEFOREDOB_SELECT);
							query.setString(1, qDOB);
							query.execute();
							results = query.getResultSet();
							
						}
						catch (Exception E) {
							JOptionPane.showMessageDialog(null, "DOB was not correct.");
						}
					}//end of if statement
					else {
						JOptionPane.showMessageDialog(null, "Did not put in DOB value.");
					}
					break;
				case("STUDENT_AFTERDOB_SELECT"):
					//just need DOB
					if(qDOBTField.getText().length() > 0) {
						try {
							qDOB = qDOBTField.getText();
							java.util.Date date = dateFormat.parse(qDOB);
							mySQLDateString = dateFormat.format(date);
						}
						catch (Exception E) {
							
						}
						try {
							query = connection.prepareCall(STUDENT_AFTERDOB_SELECT);
							query.setString(1, qDOB);
							query.execute();
							results = query.getResultSet();
							
						}
						catch (Exception E) {
							JOptionPane.showMessageDialog(null, "DOB was not correct.");
						}
					}//end of if statement
					else {
						JOptionPane.showMessageDialog(null, "Did not put in DOB value.");
					}
					break;
				case("STUDENT_EMAIL_SELECT"):
					//just need email
					if(qEmailTField.getText().length() > 0) {
						try {
							qEmail = qEmailTField.getText();
						}
						catch (Exception E) {
							
						}
						try {
							query = connection.prepareCall(STUDENT_EMAIL_SELECT);
							query.setString(1, qEmail);
							query.execute();
							results = query.getResultSet();
							
						}
						catch (Exception E) {
							JOptionPane.showMessageDialog(null, "Email was not correct.");
						}
					}//end of if statement
					else {
						JOptionPane.showMessageDialog(null, "Did not put in email value.");
					}
					break;
				case("STUDENT_FULLNAME_SELECT"):
					//need firstName and lastName
					if(qFirstNameTField.getText().length() > 0 && qLastNameTField.getText().length() > 0) {
						try {
							qFirstName = qFirstNameTField.getText();
							qLastName = qLastNameTField.getText();
						}
						catch (Exception E) {
							
						}
						try {
							query = connection.prepareCall(STUDENT_FULLNAME_SELECT);
							query.setString(1, qFirstName);
							query.setString(2, qLastName);
							query.execute();
							results = query.getResultSet();
							
						}
						catch (Exception E) {
							JOptionPane.showMessageDialog(null, "DOB was not correct.");
						}
					}//end of if statement
					else {
						JOptionPane.showMessageDialog(null, "Did not put in DOB value.");
					}
					break;
				
				}//end of switch statement
				
				
				try {
					while (results.next()) {
					    // Print the values of the current row.
						String result = "ID: " + results.getInt("id") + ", First Name: " + 
					    results.getString("firstName") + ", Last Name: " + results.getString("lastName") +
					    ", Address: " + results.getString("address") + ", Phone Number: " + results.getString("phoneNum") + 
					    ", Email: " + results.getString("email") + ", DOB: " +results.getString("dob")
					    + newline;
						JOptionPane.showMessageDialog(null,result);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		        

		        
			}
		});
		queryButton.setBounds(153, 201, 177, 23);
		queryPanel.add(queryButton);
		
		insertButton = new JButton("Insert Student");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//we need to insert a student
				if(qFirstNameTField.getText().length() > 0 && qLastNameTField.getText().length() > 0 &&
						qAddressTField.getText().length() > 0 && qPhoneNumTField.getText().length() > 0 
						&& qEmailTField.getText().length() > 0 && qDOBTField.getText().length() > 0) {
					try {
						qFirstName = qFirstNameTField.getText();
						qLastName = qLastNameTField.getText();
						qAddress = qAddressTField.getText();
						qPhoneNum = qPhoneNumTField.getText();
						qEmail = qEmailTField.getText();
						qDOB = qDOBTField.getText();
						java.util.Date date = dateFormat.parse(qDOB);
						mySQLDateString = dateFormat.format(date);
						
					}
					catch (Exception E) {
						
					}
					try {
						query = connection.prepareCall(INSERT_STUDENT);
						query.setString(1, qFirstName);
						query.setString(2, qLastName);
						query.setString(3, qAddress);
						query.setString(4, qPhoneNum);
						query.setString(5, qEmail);
						query.setString(6, mySQLDateString);
						int rowsAffected = query.executeUpdate();
						JOptionPane.showMessageDialog(null, "Number of rows inserted: " + rowsAffected);
					}
					catch (Exception E) {
						JOptionPane.showMessageDialog(null, "Not all values were "
								+ "properly formatted correctly");
					}
				}//end of if statement
				else {
					JOptionPane.showMessageDialog(null, "Please fill out all boxes correctly.");
				}
			}
		});
		insertButton.setBounds(10, 120, 138, 23);
		queryPanel.add(insertButton);
		
		deleteButton = new JButton("Delete Student");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(qStuIDTField.getText().length() > 0) {
					//we have an id to delete student
					try {
						qStuID = Integer.parseInt(qStuIDTField.getText());
					}
					catch (Exception E) {
						
					}
					try {
						query = connection.prepareCall(DELETE_STUDENT);
						query.setInt(1, qStuID);
						int rowsAffected = query.executeUpdate();
						JOptionPane.showMessageDialog(null, "Number of rows deleted: " + rowsAffected);
						
					}
					catch (Exception E){
						JOptionPane.showMessageDialog(null, "Not all values were "
								+ "properly formatted correctly");
					}
					
				}//end of if statement
				else {
					JOptionPane.showMessageDialog(null, "Please add the StudentID of the "
							+ "student you want to delete.");
				}
				
				
				
			}
		});
		deleteButton.setBounds(170, 120, 138, 23);
		queryPanel.add(deleteButton);
		
		updateButton = new JButton("Update Student");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//need to get the values from the text boxes and use the student ID to find which
				//record to update in the table
				if(qFirstNameTField.getText().length() > 0 && qLastNameTField.getText().length() > 0 &&
						qAddressTField.getText().length() > 0 && qPhoneNumTField.getText().length() > 0 
						&& qEmailTField.getText().length() > 0 && qDOBTField.getText().length() > 0
						&& qStuIDTField.getText().length() > 0) {
					try {
						qFirstName = qFirstNameTField.getText();
						qLastName = qLastNameTField.getText();
						qAddress = qAddressTField.getText();
						qPhoneNum = qPhoneNumTField.getText();
						qEmail = qEmailTField.getText();
						qStuID = Integer.parseInt(qStuIDTField.getText());
						qDOB = qDOBTField.getText();
						java.util.Date date = dateFormat.parse(qDOB);
						mySQLDateString = dateFormat.format(date);
						
					}
					catch (Exception E) {
						
					}
					//updating the student
					try {
						query = connection.prepareCall(UPDATE_STUDENT);
						query.setString(1, qFirstName);
						query.setString(2, qLastName);
						query.setString(3, qAddress);
						query.setString(4, qPhoneNum);
						query.setString(5, qEmail);
						query.setString(6, mySQLDateString);
						query.setInt(7, qStuID);
						int rowsAffected = query.executeUpdate();
						JOptionPane.showMessageDialog(null, "Number of rows updated: " + rowsAffected);
					}
					catch (Exception E) {
						JOptionPane.showMessageDialog(null, "Not all values were "
								+ "properly formatted correctly");
					}
				}//end of if statement
				else {
					JOptionPane.showMessageDialog(null, "Please fill out all boxes correctly.");
				}
			}
		});
		
		
		updateButton.setBounds(333, 120, 138, 23);
		queryPanel.add(updateButton);
		
		qInstruLabel = new JLabel("<html><p>Please enter the values in these boxes similar to the register page and include a StudentID number where necessary</p></html>");
		qInstruLabel.setEnabled(false);
		qInstruLabel.setBounds(236, 42, 235, 71);
		queryPanel.add(qInstruLabel);
		
		qAddressTField = new JTextField();
		qAddressTField.setBounds(10, 68, 96, 20);
		queryPanel.add(qAddressTField);
		qAddressTField.setColumns(10);
		
		qLastNameTField = new JTextField();
		qLastNameTField.setColumns(10);
		qLastNameTField.setBounds(10, 37, 96, 20);
		queryPanel.add(qLastNameTField);
		
		qFirstNameTField = new JTextField();
		qFirstNameTField.setColumns(10);
		qFirstNameTField.setBounds(10, 6, 96, 20);
		queryPanel.add(qFirstNameTField);
		
		qPhoneNumTField = new JTextField();
		qPhoneNumTField.setColumns(10);
		qPhoneNumTField.setBounds(130, 6, 96, 20);
		queryPanel.add(qPhoneNumTField);
		
		qEmailTField = new JTextField();
		qEmailTField.setColumns(10);
		qEmailTField.setBounds(130, 37, 96, 20);
		queryPanel.add(qEmailTField);
		
		qDOBTField = new JTextField();
		qDOBTField.setColumns(10);
		qDOBTField.setBounds(130, 68, 96, 20);
		queryPanel.add(qDOBTField);
		
		qStuIDTField = new JTextField();
		qStuIDTField.setColumns(10);
		qStuIDTField.setBounds(330, 6, 96, 20);
		queryPanel.add(qStuIDTField);
		
		qStuIDLabel = new JLabel("Student ID:");
		qStuIDLabel.setBounds(236, 9, 72, 14);
		queryPanel.add(qStuIDLabel);
		selectComboBox.setVisible(false);
		qInstruLabel.setVisible(false);
		updateButton.setVisible(false);
		insertButton.setVisible(false);
		deleteButton.setVisible(false);
		queryButton.setVisible(false);
		qFirstNameTField.setVisible(false);
		qLastNameTField.setVisible(false);
		qAddressTField.setVisible(false);
		qPhoneNumTField.setVisible(false);
		qEmailTField.setVisible(false);
		qDOBTField.setVisible(false);
		qStuIDTField.setVisible(false);
		qStuIDLabel.setVisible(false);
		
		
		
		
		
	}

	protected void updateQuery() {
		//we need to change all the setVisible commands from the query tab
		queryLoginLable.setVisible(false);
		selectLabel.setVisible(true);
		selectComboBox.setVisible(true);
		updateButton.setVisible(true);
		insertButton.setVisible(true);
		deleteButton.setVisible(true);
		qInstruLabel.setVisible(true);
		queryButton.setVisible(true);
		qFirstNameTField.setVisible(true);
		qLastNameTField.setVisible(true);
		qAddressTField.setVisible(true);
		qPhoneNumTField.setVisible(true);
		qEmailTField.setVisible(true);
		qDOBTField.setVisible(true);
		qStuIDTField.setVisible(true);
		qStuIDLabel.setVisible(true);
		
	}
}
