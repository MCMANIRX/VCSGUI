


/*Air Ride Editor v1.0.5
 * by DIP
 * thisispadding@gmail.com
 * 4/7/18
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GUI extends JPanel

implements ActionListener, PropertyChangeListener, ChangeListener {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -5283293878142201906L; 






	public static void main(String[] args) {
		/* try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); 
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						/sexy theme. uses JTatoo library.
		 */
		 int i;
		 for(i=0; i<1; ++i) {
	    	
	    		new filefind();
		 }  //will be
	    	
	    }
	   
    private JLabel l1 = new JLabel("HP"); //param labels
    private JLabel l2 = new JLabel("Scale");
   
    private JLabel l3= new JLabel("Top Speed");
 
    private JLabel l4 = new JLabel("Glide");
    private JLabel l5 = new JLabel("Offense");
    private JLabel l6 = new JLabel("Defense");
    private JLabel l7 = new JLabel("Charge Speed");
    private JLabel l8 = new JLabel("Boost Strength (Full Charge)");
    private JLabel l8half= new JLabel("Charge Release (README!)");
    private JLabel l9= new JLabel("Bouncy Bouncy!");
    private JLabel l10 = new JLabel("Base Air Accel");
    private JLabel l11 = new JLabel("Ease of Turn");
    private JLabel l12 = new JLabel("Low-Speed Ground Turn");
    private JLabel l13 = new JLabel("High-Speed Ground Turn");
    private JLabel l14 = new JLabel("Air Turning");



    
    private JLabel space = new JLabel("");
    private JLabel tm1= new JLabel("Created By DIP"); //<- a beautiful human being
    private JLabel tm2 = new JLabel("thisispadding@gmail.com");
    private JLabel main = new JLabel("Input numbers in the boxes");
    private JFrame frame = new JFrame();								//displayed text
    
    public static File names; //filename
    

    float parm1;		//floats
    float parm2;
    float parm3;
    float parm4;
    float parm5;
    float parm6;
    float parm7;
    float parm8;
    float parm8half;
    float parm9;
    float parm10;
    float parm11;
    float parm12;
    float parm13;
    float parm14;
    
  
 
   DefaultFormatter format = new DefaultFormatter();
   JFormattedTextField p1 = new JFormattedTextField(format);
   JFormattedTextField p2 = new JFormattedTextField(format);
  
    JFormattedTextField p3 = new JFormattedTextField(format);
    JFormattedTextField p4 = new JFormattedTextField(format);
    JFormattedTextField p5 = new JFormattedTextField(format);		//value fields to display/edit
    JFormattedTextField p6 = new JFormattedTextField(format);
    JFormattedTextField p7 = new JFormattedTextField(format);
    JFormattedTextField p8 = new JFormattedTextField(format);
    JFormattedTextField p8half = new JFormattedTextField(format);

    JFormattedTextField p9 = new JFormattedTextField(format);
    JFormattedTextField p10 = new JFormattedTextField(format);
    JFormattedTextField p11 = new JFormattedTextField(format);
    JFormattedTextField p12 = new JFormattedTextField(format);
    JFormattedTextField p13 = new JFormattedTextField(format);
    JFormattedTextField p14 = new JFormattedTextField(format);







 


    public GUI() {

    	   format.setOverwriteMode(false);	//annoying bullcrap stopper
    	
    	names = filefind.selectedfile; //getting name of file
        // the clickable button
        JButton button = new JButton("Insert Values");	
        JButton button2 = new JButton(new AbstractAction("Borked for now") {
        	
        	 public void actionPerformed( ActionEvent e ) {	//button2's effect. trying to make a direct import button
        		//new iso();
             }
         });
        
        
        button.addActionListener(this);
     
        String namesStr = names.getName(); //display name in GUI
        JLabel name = new JLabel(namesStr);
       
  
        p1.setColumns(10);
        p2.setColumns(10);
        p3.setColumns(10);
        p4.setColumns(10);
        p5.setColumns(10);
        p6.setColumns(10);
        p7.setColumns(10);
        p8.setColumns(10);
        p8half.setColumns(10);
        p9.setColumns(10);
        p10.setColumns(10);
        p11.setColumns(11);
        p12.setColumns(12);
        p13.setColumns(13);
        p14.setColumns(14);		//this did something. i forgot what kek


        
       RandomAccessFile hex = null; //this reads from offsets in the selectedfile
    		  try {
				hex = new RandomAccessFile(names, "r"); //the selected file is going to be "r"ead.
				
				 hex.seek(0x9C); //goes to offset for param
				 parm1 = hex.readFloat(); //sets parm to float at offset
				
				
				p1.setValue(parm1); //sets first textfield to parm1, for relative and easy editing
				
				
				 hex.seek(0x38);
				 parm2 = hex.readFloat();
		
				;
				p2.setValue(parm2);
				
				 hex.seek(0xc0);
				 parm3 = hex.readFloat();
				
			
				p3.setValue(parm3);
				
				 hex.seek(0x338);
				 parm4 = hex.readFloat();
			
				
				p4.setValue(parm4);
				
				
				 hex.seek(0x3C);
				 parm5 = hex.readFloat();
			
				
				p5.setValue(parm5);
				
				
				 hex.seek(0xBC);
				 parm6 = hex.readFloat();
			
				
				p6.setValue(parm6);
				
				 hex.seek(0xCC);
				 parm7 = hex.readFloat();
			
				
				p7.setValue(parm7);
				
				 hex.seek(0xE4);
				 parm8 = hex.readFloat();
			
				p8.setValue(parm8);
				
				 hex.seek(0xD4);
				 parm8half = hex.readFloat();
	
			
				p8half.setValue(parm8half);
				
				
				
				
				hex.seek(0x270);
				 parm9 = hex.readFloat();
				
		
			
				
				p9.setValue(parm9);
				
				hex.seek(0x16C);
				
				 parm10 = hex.readFloat();
					
					p10.setValue(parm10);
				
					hex.seek(0x110);
					
					 parm11 = hex.readFloat();
						
						p11.setValue(parm11);
						
						hex.seek(0x27C);
						
						 parm12 = hex.readFloat();
							
							p12.setValue(parm12);
							
							hex.seek(0x280);
							
							 parm13 = hex.readFloat();
								
								p13.setValue(parm13);
								
								hex.seek(0x180);
								
								 parm14 = hex.readFloat();
									
									p14.setValue(parm14);
						
					
		
				
		
				
				 
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        
        
        p1.addPropertyChangeListener("value", this);
      
        
      
    
        JPanel panel = new JPanel(); //object to append all GUI elements to
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 2, 3, 3));
      
       
        panel.add(space);		//layout
        panel.add(tm1);
        panel.add(space);
        panel.add(space);
        panel.add(tm2);
      panel.add(name);
        panel.add(space);
        panel.add(main);
        panel.add(l2);
        panel.add(p2);
        panel.add(l1);
        panel.add(p1);
       
        panel.add(l3);
        panel.add(p3);
        panel.add(l4);
        panel.add(p4);
        panel.add(l5);
        panel.add(p5);
        panel.add(l6);
        panel.add(p6);
        panel.add(l7);
        panel.add(p7);
        panel.add(l8);
        panel.add(p8);
        panel.add(l8half);
        panel.add(p8half);
        panel.add(l9);
        panel.add(p9);
        panel.add(l10);
        panel.add(p10);
        panel.add(l11);
        panel.add(p11);
        panel.add(l12);
        panel.add(p12);
        panel.add(l13);
        panel.add(p13);
        panel.add(l14);
        panel.add(p14);
  
  
        
      
 
        panel.add(button2);
        panel.add(button);
        panel.add(space);
      
       
      
        com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Black", "INSERT YOUR LICENSE KEY HERE", "my company");
        
        // more sexy theme
        
       
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Air Ride Editor"); //name of window
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);  // *** this will center your app ***

       try {
		hex.close(); //for rebuilding in GCR while program is open
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        
        
    }

    
    public void actionPerformed(ActionEvent e) {
    	
   
    write(names); //starts method "write", importing FIle "names"

      
    }

    // create one Frame
   

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		 
	}
	
	
	public void write(File names){
		RandomAccessFile raf = null;
		 try {
			 
			 
			 raf = new RandomAccessFile(names, "rw"); //reads and writes to/from file
			 ///   System.out.println(names);
				
				
				
				
				
		        float p1rm  = Float.parseFloat(p1.getText());	//gets the float from the Text field
		       float p2rm = Float.parseFloat(p2.getText());
		       
		        float p3rm  = Float.parseFloat(p3.getText());
		        float p4rm  = Float.parseFloat(p4.getText());
		        
		        float p5rm  = Float.parseFloat(p5.getText());
		        float p6rm  = Float.parseFloat(p6.getText());
		        float p7rm  = Float.parseFloat(p7.getText());
		        float p8rm  = Float.parseFloat(p8.getText());
		        float p8halfrm  = Float.parseFloat(p8half.getText());

		        float p9rm  = Float.parseFloat(p9.getText());
		        float p10rm  = Float.parseFloat(p10.getText());
		        float p11rm  = Float.parseFloat(p11.getText());
		        float p12rm  = Float.parseFloat(p12.getText());
		        float p13rm  = Float.parseFloat(p13.getText());
		        float p14rm  = Float.parseFloat(p13.getText());






		        

			
			   raf.seek(0xc0);	//goes to offset
			   raf.writeFloat(p3rm); //writes the float stored from the text field
			
				
			

			raf.seek(0x38);		
	    raf.writeFloat(p2rm);
		
	
	
	   raf.seek(0x9c);
	   raf.writeFloat(p1rm);
	  
	   
	   raf.seek(0x338);
	   raf.writeFloat(p4rm);
	   
	   raf.seek(0x3C);
	   raf.writeFloat(p5rm);
	   
	   raf.seek(0xBC);
	   raf.writeFloat(p6rm);
	
	
	   raf.seek(0xCC);
	   raf.writeFloat(p7rm);
	   
	   raf.seek(0xE4);
	   raf.writeFloat(p8rm);
	   
	   
	   raf.seek(0xD4);
	   raf.writeFloat(p8halfrm);
	   
	   raf.seek(0x270);
	   raf.writeFloat(p9rm);
	
	   raf.seek(0x16C);
	   raf.writeFloat(p10rm);
	   

	   raf.seek(0x110);
	   raf.writeFloat(p11rm);
	   

	   raf.seek(0x27C);
	   raf.writeFloat(p12rm);
	   
	   raf.seek(0x280);
	   raf.writeFloat(p13rm);
	   
	   raf.seek(0x180);
	   raf.writeFloat(p14rm);
	   
	   raf.seek(0x360);

	 //  raf.writeUTF("hacked!"); //writes a signature to the file. might wanna disable that.

	
	
		raf.close(); //close for rebuilding

	
	
	   

		 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
