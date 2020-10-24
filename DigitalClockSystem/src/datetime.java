import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

class welcome extends JFrame implements ActionListener{
	//declaring the components
	JButton b1,b2,b3;
	JFrame f1,f2,f3;
	JLabel l;
	
	public welcome() {
		b1=new JButton("SYSTEM TIME");//creating a button instances
		b1.setFont(b1.getFont().deriveFont(30.0f));//setting bounds and fonts
		b1.setBounds(150,400,300,100);
		b2=new JButton();
		
		b2.setIcon(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\DigitalClockSystem\\pix.png"));
		//adding image to the button
		
		b2.setBounds(30,90,400,500);
		b3=new JButton(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\DigitalClockSystem\\digital.png"));
		b3.setBounds(30,90,450,270);
		
		//creating label instance with label name
		
		l=new JLabel("Helloo!!click on me to see the time");
		l.setBounds(10,20,1000,100);
		l.setFont(l.getFont().deriveFont(30.0f));
		
		//creating frame instances
		f1=new JFrame("Welcome");
		f2=new JFrame("Helloo");
		f3=new JFrame("DIGITAL CLOCK");
		
		//adding buttons to frame
		
		f1.add(b1);
		f1.add(b3);
		
		//adding action listeners to the buttons
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		//setting frame layout,size and visibility
		
		f1.setLayout(null);
		f1.setVisible(true);
		f1.setSize(600,600);
		f1.setDefaultCloseOperation(3);
		
		f2.setLayout(null);
		f2.setVisible(false);
		f2.setSize(600,600);
		f2.setDefaultCloseOperation(3);
		
		//adding components to frame
		
		f2.add(l);
		f2.add(b2);
		
		//creating object reference date label of class ClockLabel;
		ClockLabel dateLable=new ClockLabel("date");
		
		//creating object reference time label of class ClockLabel;
		ClockLabel timeLable=new ClockLabel("time");
				
		//creating object reference day label of class ClockLabel;
		ClockLabel dayLable=new ClockLabel("day");
		
		//adding components to the frame
		f3.add(dateLable);
		f3.add(timeLable);
		f3.add(dayLable);
		f3.getContentPane().setBackground(Color.black);
		
		//setting frame layout,visibility,size and title
		f3.setLayout(new FlowLayout());
		f3.setVisible(false);
		f2.setSize(600,300);
		f3.setTitle("System Clock");
		f3.setLayout(new GridLayout(3,1));
		f3.setDefaultCloseOperation(3);		
		}
	
	//public event function
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b1)
		{
			f1.setVisible(false);
			f2.setVisible(true);
		}
		
		if(e.getSource()==b2)
		{
			f1.setVisible(false);
			f2.setVisible(false);
			f3.setVisible(true);
		}
	}
}
//main class
public class datetime {
	public static void main(String[] args) {
		welcome w=new welcome();//creating the instance for welcome class
	}
}

//declaring ClockLabel class

class ClockLabel extends JLabel implements ActionListener{
	
	//declaring variables
	
	String type;
	SimpleDateFormat sdf;
	
	//creating the constructor of the class ClockLabel
	
	public ClockLabel(String type)
	{
		this.type=type;
		setForeground(Color.green);
		
		//switch statements for assigning date,day,and current time
		
		switch(type) {
		
		case "date":sdf=new SimpleDateFormat(" MMMM dd yyyy");
		   setFont(new Font("sans-serif",Font.PLAIN,22));
		   setHorizontalAlignment(SwingConstants.LEFT);
		   break;
		   
		case "time":sdf=new SimpleDateFormat("hh:mm:ss a");
		   setFont(new Font("sans-serif",Font.PLAIN,60));
		   setHorizontalAlignment(SwingConstants.CENTER);
		   break;
		   
		case "day":sdf=new SimpleDateFormat("EEEE");
		   setFont(new Font("sans-serif",Font.PLAIN,28));
		   setHorizontalAlignment(SwingConstants.RIGHT);
		   break;
		   
		default :sdf=new SimpleDateFormat();
		         break;
		}
		
		Timer t=new Timer(1000,this);
		t.start();
	}
	
	//action event function
	
	  public void actionPerformed(ActionEvent ae) {
		    Date d = new Date();
		    setText(sdf.format(d));
		  }
}
	