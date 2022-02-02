import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class TicketForm extends JFrame implements ActionListener {

  //Components of the Form
  private Container c;
  private JLabel title;
  private JLabel name;
  private JTextField tName;
  private JLabel email;
  private JTextField tEmail;
  private JLabel dob;
  private JComboBox date;
  private JComboBox month;
  private JComboBox year;
  private JLabel phoneNumber;
  private JTextField tPhoneNumber;
  private JLabel gender;
  private JRadioButton male;
  private JRadioButton female;
  private ButtonGroup genderGroup;
  private JLabel destination;
  private JComboBox destinationList;
  private JLabel boardingLocation;
  private JComboBox boardingLocationList;
  private JCheckBox term;
  private JButton submit;
  private JButton reset;
  private JTextArea tout;
  private JLabel res;
  private JTextArea resadd;

  // Date of Birth Data for ComboBox
  private String[] dates
      = { "1", "2", "3", "4", "5",
      "6", "7", "8", "9", "10",
      "11", "12", "13", "14", "15",
      "16", "17", "18", "19", "20",
      "21", "22", "23", "24", "25",
      "26", "27", "28", "29", "30",
      "31" };
  private String[] months
      = { "Jan", "Feb", "Mar", "Apr",
      "May", "Jun", "July", "Aug",
      "Sep", "Oct", "Nov", "Dec" };

  private String[] listOfYears = years();
  private String[] years () {
    ArrayList<String> listOfYears = new ArrayList<>();
    for(var i = 1950; i < 2022; i++) {
      listOfYears.add(String.valueOf(i));
    }
    String[] years = new String[listOfYears.size()];
      for(var i=0; i < years.length; i++) {
        for(var j =0; j < listOfYears.size(); j++) {
          years[i] = listOfYears.get(i);
        }
      }
    return years;
  };

  //Data for From and To Destinations;
  String[] destinations = {
      "Los Angeles, CA",
      "San Francisco, CA",
      "Chicago, IL",
      "Raleigh, NC",
      "Charlotte, NC",
      "Charleston, SC",
      "Myrtle Beach, SC",
      "Atlanta, GA",
      "Savannah, GA",
      "Miami, FL",
      "Orlando, FL",
      "New Orleans, LA",
      "Las Vegas, NV",
      "New York City, NY",
      "Houston, TX",
      "San Antonio, Texas",
      "Richmond, VA",
      "Hampton, VA"
  };
  String[] to = {
      "Los Angeles, CA",
      "San Francisco, CA",
      "Chicago, IL",
      "Raleigh, NC",
      "Charlotte, NC",
      "Charleston, SC",
      "Myrtle Beach, SC",
      "Atlanta, GA",
      "Savannah, GA",
      "Miami, FL",
      "Orlando, FL",
      "New Orleans, LA",
      "Las Vegas, NV",
      "New York City, NY",
      "Houston, TX",
      "San Antonio, Texas",
      "Richmond, VA",
      "Hampton, VA"
  };


  public TicketForm() {
    setTitle("Ced & Ken's Vibin' Ventures Travel Company");
    setBounds(300, 90, 900, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);

    c = getContentPane();
    c.setLayout(null);

    title = new JLabel("Registration Form");
    title.setFont(new Font("Arial", Font.BOLD, 24));
    title.setSize(300, 30);
    title.setLocation(300, 30);
    c.add(title);

    name = new JLabel("First and Last Name: ");
    name.setFont(new Font("Monospace", Font.PLAIN, 14));
    name.setSize(200, 20);
    name.setLocation(100,100);
    c.add(name);

    tName = new JTextField();
    tName.setFont(new Font("Arial", Font.PLAIN, 12));
    tName.setSize(150, 20);
    tName.setLocation(245, 100);
    c.add(tName);

    email = new JLabel("Email: ");
    email.setFont(new Font("Monospace", Font.PLAIN, 14));
    email.setSize(200, 20);
    email.setLocation(100, 125);
    c.add(email);

    tEmail = new JTextField();
    tEmail.setFont(new Font("Arial", Font.PLAIN, 12));
    tEmail.setSize(250, 20);
    tEmail.setLocation(150,125);
    c.add(tEmail);

    phoneNumber = new JLabel("Phone Number: ");
    phoneNumber.setFont(new Font("Monospace", Font.PLAIN, 14));
    phoneNumber.setSize(200, 20);
    phoneNumber.setLocation(100, 150);
    c.add(phoneNumber);

    tPhoneNumber = new JTextField();
    tPhoneNumber.setFont(new Font("Arial", Font.PLAIN, 12));
    tPhoneNumber.setSize(125,20);
    tPhoneNumber.setLocation(215,150);
    c.add(tPhoneNumber);

    gender = new JLabel("Gender");
    gender.setFont(new Font("Monospace", Font.PLAIN, 14));
    gender.setSize(100, 20);
    gender.setLocation(100, 175);
    c.add(gender);


    male = new JRadioButton("Male");
    male.setFont(new Font("Monospace", Font.PLAIN, 12));
    male.setSelected(true);
    male.setSize(75, 20);
    male.setLocation(200, 175);
    c.add(male);

    female = new JRadioButton("Female");
    female.setFont(new Font("Monospace", Font.PLAIN, 12));
    female.setSelected(false);
    female.setSize(80, 20);
    female.setLocation(275, 175);
    c.add(female);

    genderGroup = new ButtonGroup();
    genderGroup.add(male);
    genderGroup.add(female);

    dob = new JLabel("Date of Birth: ");
    dob.setFont(new Font("Monospace", Font.PLAIN, 14));
    dob.setSize(100, 20);
    dob.setLocation(100, 200);
    c.add(dob);

    date = new JComboBox(dates);
    date.setFont(new Font("Arial", Font.PLAIN, 12));
    date.setSize(75, 20);
    date.setLocation(200, 200);
    c.add(date);

    month = new JComboBox(months);
    month.setFont(new Font("Arial", Font.PLAIN, 12));
    month.setSize(100, 20);
    month.setLocation(275, 200);
    c.add(month);

    year = new JComboBox(listOfYears);
    year.setFont(new Font("Arial", Font.PLAIN, 12));
    year.setSize(100, 20);
    year.setLocation(375, 200);
    c.add(year);

    destination = new JLabel("Destination: ");
    destination.setFont(new Font("Monospace", Font.PLAIN, 14));
    destination.setSize(200, 20);
    destination.setLocation(100,225);
    c.add(destination);

    destinationList = new JComboBox(destinations);
    destinationList.setFont(new Font("Arial", Font.PLAIN, 12));
    destinationList.setSize(175, 20);
    destinationList.setLocation(225, 225);
    c.add(destinationList);

    boardingLocation = new JLabel("Boarding Location: ");
    boardingLocation.setFont(new Font("Monospace", Font.PLAIN, 14));
    boardingLocation.setSize(200, 20);
    boardingLocation.setLocation(100,250);
    c.add(boardingLocation);

    boardingLocationList = new JComboBox(to);
    boardingLocationList.setFont(new Font("Arial", Font.PLAIN, 12));
    boardingLocationList.setSize(175, 20);
    boardingLocationList.setLocation(225, 250);
    c.add(boardingLocationList);

    term = new JCheckBox("Is you Vibin' with us or nah?");
    term.setFont(new Font("Arial", Font.PLAIN, 14));
    term.setSize(250, 20);
    term.setLocation(150, 300);
    c.add(term);

    submit = new JButton("Submit");
    submit.setFont(new Font("Arial", Font.PLAIN, 14));
    submit.setSize(100, 20);
    submit.setLocation(150, 350);
    submit.addActionListener(this);
    c.add(submit);

    reset = new JButton("Reset");
    reset.setFont(new Font("Arial", Font.PLAIN, 14));
    reset.setSize(100, 20);
    reset.setLocation(275, 350);
    reset.addActionListener(this);
    c.add(reset);

    tout = new JTextArea();
    tout.setFont(new Font("Arial", Font.PLAIN, 15));
    tout.setSize(325, 400);
    tout.setLocation(500, 80);
    tout.setLineWrap(true);
    tout.setEditable(false);
    c.add(tout);

    res = new JLabel("");
    res.setFont(new Font("Arial", Font.PLAIN, 20));
    res.setSize(500, 25);
    res.setLocation(100, 500);
    c.add(res);

    resadd = new JTextArea();
    resadd.setFont(new Font("Arial", Font.PLAIN, 15));
    resadd.setSize(200, 75);
    resadd.setLocation(580, 175);
    resadd.setLineWrap(true);
    c.add(resadd);


    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submit) {
      if (term.isSelected()) {
        String data1;
        String data
            = "Name : "
            + tName.getText() + "\n"
            + "Email : "
            + email.getText() + "\n";
        if (male.isSelected())
          data1 = "Gender : Male"
              + "\n";
        else
          data1 = "Gender : Female"
              + "\n";
        String data2
            = "DOB : "
            + (String)date.getSelectedItem()
            + "/" + (String)month.getSelectedItem()
            + "/" + (String)year.getSelectedItem()
            + "\n";
        String data3 =
            "Destination: " + (String)destinationList.getSelectedItem();
        String data4 =
            "Boarding Location: " + (String)boardingLocationList.getSelectedItem();

        tout.setText(data + data1 + data2 + data3 + data4);
        tout.setEditable(false);
        res.setText("Thank You! We ready to Vibe!");
      }
      else {
        tout.setText("");
        resadd.setText("");
        res.setText("Please accept the"
            + " terms & conditions..");
      }
    }

    else if (e.getSource() == reset) {
      String def = "";
      tName.setText(def);
      tEmail.setText(def);
      tPhoneNumber.setText(def);
      res.setText(def);
      tout.setText(def);
      term.setSelected(false);
      date.setSelectedIndex(0);
      month.setSelectedIndex(0);
      year.setSelectedIndex(0);
      resadd.setText(def);
    }
  }
}
