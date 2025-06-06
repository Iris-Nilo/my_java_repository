//Lab Activity 6
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LabActivity6SwingToDoList extends JFrame {
                
                private JTable table;
                private DefaultTableModel tableModel;
                
                public LabActivity6SwingToDoList(){
                    
                    setSize(550, 450);
                    setLocationRelativeTo(null);
                    setTitle("To-Do List Viewer");                  
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    JPanel panel = new JPanel();
                    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
                    JButton addTask = new JButton("Add Task");
                   
                    buttonPanel.add(addTask);
                    panel.add(buttonPanel);
                    this.add(panel);
                   
                    //Button Action
                    addTask.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){
                            toDoForm newWindow = new toDoForm();
                            newWindow.setVisible(true);
                    }
                });
                     
                    Container contentPane = getContentPane();
                    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
                    contentPane.add(Box.createVerticalStrut(5));
                    this.getContentPane().add(panel);                  
                    contentPane.add(addTask);
                 
                    //Table
                     tableModel = new DefaultTableModel();
                     tableModel.addColumn("Task Name");
                     tableModel.addColumn("Task Description");
                     tableModel.addColumn("Status");
                     table = new JTable(tableModel);
                    
                    JScrollPane scrollPane = new JScrollPane(table);
                    contentPane.add(Box.createHorizontalStrut(140));
                    contentPane.add(scrollPane);
            
                    setVisible(true);
                                        
                }

                //Pop up Window
                public class toDoForm extends JFrame{
                    
                    public toDoForm(){
                        
                        setSize(450, 400);
                        setLocationRelativeTo(null);
                        setTitle("Add New Task");
                        
                        //GridBagLayout
                        setLayout (new GridBagLayout());
                        GridBagConstraints gbc = new GridBagConstraints();
                        gbc.insets = new Insets (5, 15, 5, 5);
                        
                        //Task Name Label
                        JLabel taskName = new JLabel ("Task Name:");                        
                        gbc.gridx = 0;
                        gbc.gridy = 0;
                        gbc.anchor = GridBagConstraints.WEST;
                        add(taskName, gbc);
                        
                        //Task Name TextField
                        JTextField taskNameField = new JTextField (30);
                        gbc.gridwidth = 0;
                        gbc.gridx = 0;
                        gbc.gridy = 1;
                        gbc.anchor = GridBagConstraints.WEST;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        add(taskNameField, gbc);
                        
                        //Task Description Label
                        JLabel taskDesc = new JLabel("Task Description:");
                        gbc.gridx = 0;
                        gbc.gridy = 2;
                        gbc.anchor = GridBagConstraints.WEST;
                        add(taskDesc, gbc);

                        //Task Description Area
                        JTextArea taskDescArea = new JTextArea (1,30);
                        taskDescArea.setLineWrap(true);
                        taskDescArea.setWrapStyleWord(true);
                        JScrollPane scrollPane = new JScrollPane(taskDescArea);
                        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                        gbc.gridx = 0;
                        gbc.gridy = 3;
                        gbc.anchor = GridBagConstraints.WEST;
                        add(scrollPane, gbc);
                        taskDescArea.setText("");
                                                
                        //Task Status Label
                        JLabel statusLabel= new JLabel("Status:");
                        gbc.gridx = 0;
                        gbc.gridy = 4;
                        gbc.anchor = GridBagConstraints.WEST;
                        add(statusLabel, gbc);
                        
                        //Task Status DropDown List

                        String [] statusChoices= {"Not Started", "Ongoing", "Completed"};
                        JComboBox<String> statusComboBox = new JComboBox<>(statusChoices);
                        
                        Dimension preferredSize = statusComboBox.getPreferredSize();
                        statusComboBox.setPreferredSize(new Dimension(350, preferredSize.height));
                        //Change Font
                        Font textFont = new Font("Arial", Font.PLAIN, 12);
                        statusComboBox.setFont(textFont);
                        //Change Box Color
                        Color boxColor = new Color (229, 243, 253);
                        statusComboBox.setBackground(boxColor);
                        
                        gbc.gridx = 0;
                        gbc.gridy = 5;
                        gbc.anchor = GridBagConstraints.WEST;
                        gbc.fill = GridBagConstraints.HORIZONTAL;
                        add(statusComboBox, gbc);
                        
                        statusComboBox.setSelectedItem("Not Started");
                        
                        //Save Task Button
                        JButton saveTask = new JButton("Save Task");
                        add(saveTask); 
                        
                        //Button Action 
                        saveTask.addActionListener(new ActionListener() {                            
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                                     
                                //Handling Error
                                boolean exceptionRaised = false;
                                int fieldCounter = 0;

                                if (taskNameField.getText().length() > 0) {
                                    fieldCounter++;
                                }
                                if (taskDescArea.getText().length() > 0) {
                                    fieldCounter++;
                                }
                                                              
                                //Input Error Window
                                if(fieldCounter != 2){
                                        exceptionRaised = true;
                                        JOptionPane.showMessageDialog(saveTask, "Please fill in Task Name and Status.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                }
                                if (exceptionRaised == false){                               
                                    String fTaskName = taskNameField.getText();
                                    String fTaskDescArea = taskDescArea.getText();
                                    String fStatusChosen = (String) statusComboBox.getSelectedItem();
                                    
                                    tableModel.addRow(new Object[] {fTaskName, fTaskDescArea, fStatusChosen});
                                    dispose();
                                }
                          
                             }
                        });                        
                        setVisible(true);
                    }
                }                  
                    public static void main(String[] args) {
                            LabActivity6SwingToDoList mainFrame = new LabActivity6SwingToDoList();
                      }
        }
