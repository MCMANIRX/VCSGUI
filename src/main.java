
/*Air Ride Editor v1.0.5
 * by DIP
 * thisispadding@gmail.com
 * 4/7/18
 */
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatter;

public class main extends JPanel

		implements ActionListener, PropertyChangeListener, ChangeListener {

	/**
	* 
	*/

	JPanel panel;
	JPanel panel2;
	private static final long serialVersionUID = -5283293878142201906L;

	public static File tsv;		//param list
	public static File names; // star filename
	private static Param[] p;


	public static void main(String[] args) {

		String[][] ffso = {
			{"Select param .tsv file","tsv spreadsheet","tsv"},
			{"Select Air Ride .dat file", "Air-Ride .dat Archives","dat"},};

		new filefind(ffso[0][0],ffso[0][1],ffso[0][2]);
		tsv = filefind.selectedfile;

		new filefind(ffso[1][0],ffso[1][1],ffso[1][2]);
		names = filefind.selectedfile;

		new main();

	

	}

	private JLabel space = new JLabel("");
	private JLabel tm1 = new JLabel("Created By DIP"); // <- a beautiful human being
	private JLabel tm2 = new JLabel("thisispadding@gmail.com");
	private JLabel main = new JLabel("Input numbers in the boxes");
	private JFrame frame = new JFrame(); // displayed text
	private static JPanel panelContainer;


	DefaultFormatter format = new DefaultFormatter();
	static int panel_cnt;
	static int panel_idx;
	public main()  {

		format.setOverwriteMode(false); // annoying bullcrap stopper

		// the clickable button
		JButton button = new JButton("Write Values");
		JButton button2 = new JButton(new AbstractAction("Next Page") {

			public void actionPerformed(ActionEvent e) { // button2's effect. trying to make a direct import button
				// new iso();
			}
		});

		button.addActionListener(this);

		String namesStr = names.getName(); // display name in GUI
		JLabel name = new JLabel(namesStr);

			 try {
				p = ParamReader.readParams(names,tsv);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int p_amt = p.length;
		//panel = new JPanel(); // object to append all GUI elements to





		 panelContainer = new JPanel(new CardLayout());



		 panel_idx = 0;
		 panel_cnt = 0;
		int param_cnt = 0;
		int width = 20;

		ArrayList<JPanel> panels = new ArrayList<JPanel>();
		panels.add(new JPanel());

		panels.get(panel_idx).setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panels.get(panel_idx).setLayout(new GridLayout(0, 2, 3, 3));

		panels.get(panel_idx).add(space); // layout
		panels.get(panel_idx).add(tm1);
		panels.get(panel_idx).add(space);
		panels.get(panel_idx).add(space);
		panels.get(panel_idx).add(tm2);
		panels.get(panel_idx).add(name);
		panels.get(panel_idx).add(space);
		panels.get(panel_idx).add(main);

		for (Param pee : p) {

			if(param_cnt%width==0 && param_cnt>0) {

				JButton nextButton = new JButton("Next Page");
				JButton prevButton = new JButton("Previous Page");


						nextButton.addActionListener(new AbstractAction() {
				
							public void actionPerformed(ActionEvent e) {
								CardLayout cl = (CardLayout) (panelContainer.getLayout());
								cl.next(panelContainer);
				
								nextButton.setEnabled(panel_idx != panel_cnt - 1);
							}
						});
				
						// Action for Previous Button
						prevButton.addActionListener(new AbstractAction() {
				
							public void actionPerformed(ActionEvent e) {
								CardLayout cl = (CardLayout) (panelContainer.getLayout());
								cl.previous(panelContainer);
				
								prevButton.setEnabled(panel_idx != 0);
							}
						});

				panels.get(panel_idx).add(prevButton);	
				panels.get(panel_idx).add(nextButton);
				panels.get(panel_idx).add(space);

				panels.get(panel_idx).add(new JButton(new AbstractAction("Write Values") {

						public void actionPerformed(ActionEvent e) { 
							write(names);
						}}));

				panel_cnt++;
				panel_idx++;
				panels.add(new JPanel());
				panels.get(panel_idx).setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
				panels.get(panel_idx).setLayout(new GridLayout(0, 2, 3, 3));
			}



			JFormattedTextField p1 = new JFormattedTextField(format);
			p1.setValue(pee.type.equals("float") ? Float.intBitsToFloat((int) pee.value) : (int)pee.value);
			p1.addPropertyChangeListener("value", this);
			JLabel l1 = new JLabel(pee.desc);
			panels.get(panel_idx).add(l1);
			panels.get(panel_idx).add(p1);
			param_cnt++;


		}

		//extremely lazy :p
		
		if(param_cnt%width!=0) {

			
		JButton nextButton = new JButton("Next Page");
		JButton prevButton = new JButton("Previous Page");


				nextButton.addActionListener(new AbstractAction() {
		
					public void actionPerformed(ActionEvent e) {
						CardLayout cl = (CardLayout) (panelContainer.getLayout());
						cl.next(panelContainer);
		
						nextButton.setEnabled(panel_idx != panel_cnt - 1);
					}
				});
		
				// Action for Previous Button
				prevButton.addActionListener(new AbstractAction() {
		
					public void actionPerformed(ActionEvent e) {
						CardLayout cl = (CardLayout) (panelContainer.getLayout());
						cl.previous(panelContainer);
		
						prevButton.setEnabled(panel_idx != 0);
					}
				});

		panels.get(panel_idx).add(prevButton);	
		panels.get(panel_idx).add(nextButton);

		panels.get(panel_idx).add(new JButton(new AbstractAction("Write Values") {

				public void actionPerformed(ActionEvent e) { 
					write(names);
				}}));


		}
		panels.get(panel_idx).add(space);

		int y = 0;
		for(JPanel ipc : panels)
			panelContainer.add(ipc, "Page"+y++);

		// set up the frame and display it
		frame.add(panelContainer, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Air Ride Editor"); // name of window
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null); // *** this will center your app ***



	}

	public void actionPerformed(ActionEvent e) {


	}

	// create one Frame

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {

	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub

	}
static int p_idx = 0;
	public void __write(Component comp,RandomAccessFile raf)
	{
		try {
	  if(comp instanceof JFormattedTextField)
	  {


                    
                    JTextField textField = (JTextField) comp;
                    String text = textField.getText().trim();
                    raf.seek(p[p_idx].offset);
                    System.out.printf("Writing 0x%x to 0x%x...\n",p[p_idx].value, p[p_idx].offset,p_idx);
                        if(p[p_idx].type.equals("float"))
                            
                            raf.writeFloat(Float.parseFloat(text));
                        else
                            raf.writeInt((int)Float.parseFloat(text));
                        // Do something with the parsed float value
						++p_idx;
	  }if (comp instanceof Container)
                    {
                        Component[] comps = ((Container)comp).getComponents();
                        for(int x = 0, y = comps.length; x < y; x++)
                        {
                            __write(comps[x],raf);
                        }
                    }} catch (IOException ex) {
              }
	}
	public void write(File names) {
		RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(names, "rw"); // reads and writes to/from file

			__write(panelContainer,raf);
                            } catch (IOException ex) {
                                        }
				
			

                    try {
                        raf.close(); // close for rebuilding
                    } catch (IOException ex) {}
	}
}
