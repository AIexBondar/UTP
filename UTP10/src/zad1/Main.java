/**
 *
 *  @author Weikert Robert S17092
 *
 */

package zad1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Main {

  public static void main(String[] args) {
	   MyJFrame mainF = new MyJFrame("Tasks List");
	   JTextArea outputArea = new JTextArea();
	   JPanel bottom = new JPanel();
	   JPanel top = new JPanel();
	   JPanel center = new JPanel();
	   JScrollPane scroll = new JScrollPane();
	   DefaultListModel<Task> listModel = new DefaultListModel<Task>();
	   JList<Task> tasksList = new JList<Task>(listModel);
	   Button buttonNewThread = new Button("New Thread");
	   Button buttonShowThread = new Button("Show Thread");
	   Button buttonStopThread = new Button("Stop Thread");
	   TitledBorder border;
	   
	   tasksList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	   
	   //Scroll
	   scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	   scroll.setViewportView(tasksList);
	   
	   //Buttons
	   buttonShowThread.setEnabled(false);
	   buttonStopThread.setEnabled(false);
	   
	   //List Listener - clicklable buttons & output changer
	   tasksList.addListSelectionListener(new ListSelectionListener(){
		@Override
		public void valueChanged(ListSelectionEvent e) {
			int selectedIndex = ((JList<String>)e.getSource()).getSelectedIndex();
			if(selectedIndex > -1) {
				
				buttonShowThread.setEnabled(true);
				buttonStopThread.setEnabled(true);
				
				outputArea.setText(listModel.get(selectedIndex).data);
				listModel.get(selectedIndex).setPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						outputArea.setText((String) e.getNewValue());
					}
				});
				if(listModel.get(selectedIndex).resultFuture.isDone()) {
					buttonStopThread.setEnabled(false);
					bottom.repaint();
				}
			}
		}
	   });
	   
	   //Button Listeners
	   buttonNewThread.addActionListener(e -> {
		   try {
			   new Task(15,listModel).taskStart();
		   } catch (Exception e1) {
			e1.printStackTrace();
		   }
		});
	   buttonShowThread.addActionListener(e -> {
		   int index = tasksList.getSelectedIndex();
		   if(index > -1) {
			   JOptionPane.showMessageDialog(mainF,listModel.get(index) + " Status: " + listModel.get(index).taskStatus());
		   }
		});
	   buttonStopThread.addActionListener(e -> {
		   int index = tasksList.getSelectedIndex();
		   if(index > -1) {
			 listModel.get(index).taskStop();
		   }
		});
	   
	   //Jpanels Border
	   border = new TitledBorder("Actions on tasks");
	   border.setTitleJustification(TitledBorder.LEFT);
	   border.setTitlePosition(TitledBorder.TOP);
	   
	   //Bottom Jpanel - buttons
	   bottom.add(buttonNewThread);
	   bottom.add(buttonShowThread);
	   bottom.add(buttonStopThread);
	   bottom.setBorder(border);
	   
	   //Top Jpanel - Threds List scroll
	   top.setLayout(new BoxLayout(top,BoxLayout.Y_AXIS));
	   top.add(scroll);
	   border = new TitledBorder("Tasks");
	   top.setBorder(border);
	   
	   //Center Jpanel - output Area
	   center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS));
	   center.add(outputArea);
	   border = new TitledBorder("Output area");
	   center.setBorder(border);

	   //Main Frame 
	   mainF.setLayout(new BorderLayout());
	   mainF.add(top, BorderLayout.NORTH);
	   mainF.add(center, BorderLayout.CENTER);
	   mainF.add(bottom, BorderLayout.SOUTH);
	   mainF.pack();
	   mainF.setLocationRelativeTo(null); 
	   mainF.setVisible(true);   
  }
}
