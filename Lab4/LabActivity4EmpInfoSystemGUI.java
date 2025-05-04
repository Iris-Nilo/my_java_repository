// Lab Activity 4
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;

// LabActivity4EmpInfoSystemGUI
public class LabActivity4EmpInfoSystemGUI{
    public LabActivity4EmpInfoSystemGUI(){

        //Main Frame
        Frame mainFrame = new Frame();
        mainFrame.setTitle("Lab Activity 4");
        mainFrame.setLayout(new GridBagLayout());
        
        //First Name Label
        //Multiple constraints are created to avoid issues resetting properties
        GridBagConstraints label1Constraints = new GridBagConstraints();
        
        Label label1 = new Label("First Name");
        label1Constraints.fill = GridBagConstraints.BOTH;
        label1Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        label1Constraints.weightx = 1;
        label1Constraints.weighty = 0.1;
        label1Constraints.gridx = 0;
        label1Constraints.gridy = 0;
        mainFrame.add(label1, label1Constraints);
        
        //First Name User Input
        GridBagConstraints tField1Constraints = new GridBagConstraints();
        
        TextField tField1 = new TextField();
        tField1Constraints.fill = GridBagConstraints.BOTH;
        tField1Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        tField1Constraints.weightx = 1;
        tField1Constraints.weighty = 1;
        tField1Constraints.gridx = 1;
        tField1Constraints.gridy = 0;
        tField1Constraints.gridwidth = 2;
        mainFrame.add(tField1, tField1Constraints);
        
        //Last Name Label
        GridBagConstraints label2Constraints = new GridBagConstraints();
        
        Label label2 = new Label("Last Name");
        label2Constraints.fill = GridBagConstraints.BOTH;
        label2Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        label2Constraints.weightx = 1;
        label2Constraints.weighty = 0.9;
        label2Constraints.gridx =0;
        label2Constraints.gridy = 1;
        mainFrame.add(label2, label2Constraints);
        
        //Last Name User Input
        GridBagConstraints tField2Constraints = new GridBagConstraints();
        
        TextField tField2 = new TextField();
        tField2Constraints.fill = GridBagConstraints.BOTH;
        tField2Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        tField2Constraints.weightx = 1;
        tField2Constraints.weighty = 1;
        tField2Constraints.gridx = 1;
        tField2Constraints.gridy = 1;
        tField2Constraints.gridwidth = 2;
        mainFrame.add(tField2, tField2Constraints);
        
        //Employee Age Label
        GridBagConstraints label3Constraints = new GridBagConstraints();
        
        Label label3 = new Label("Age");
        label3Constraints.fill = GridBagConstraints.BOTH;
        label3Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        label3Constraints.weightx = 1;
        label3Constraints.weighty = 0.9;
        label3Constraints.gridx =0;
        label3Constraints.gridy = 2;
        mainFrame.add(label3, label3Constraints);
        
        //Employee Age User Input
        GridBagConstraints tField3Constraints = new GridBagConstraints();
        
        TextField tField3 = new TextField();
        tField3Constraints.fill = GridBagConstraints.BOTH;
        tField3Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        tField3Constraints.weightx = 1;
        tField3Constraints.weighty = 1;
        tField3Constraints.gridx = 1;
        tField3Constraints.gridy = 2;
        tField3Constraints.gridwidth = 2;
        mainFrame.add(tField3, tField3Constraints);
        
        //Employee Hours Worked Label
        GridBagConstraints label4Constraints = new GridBagConstraints();
        
        Label label4 = new Label("Hours Worked");
        label4Constraints.fill = GridBagConstraints.BOTH;
        label4Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        label4Constraints.weightx = 1;
        label4Constraints.weighty = 0.9;
        label4Constraints.gridx =0;
        label4Constraints.gridy = 3;
        mainFrame.add(label4, label4Constraints);
        
        //Employee Hours Worked Input
        GridBagConstraints tField4Constraints = new GridBagConstraints();
        
        TextField tField4 = new TextField();
        tField4Constraints.fill = GridBagConstraints.BOTH;
        tField4Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        tField4Constraints.weightx = 1;
        tField4Constraints.weighty = 1;
        tField4Constraints.gridx = 1;
        tField4Constraints.gridy = 3;
        tField4Constraints.gridwidth = 2;
        mainFrame.add(tField4, tField4Constraints);
        
        //Employee Hourly Rate Label
        GridBagConstraints label5Constraints = new GridBagConstraints();
        
        Label label5 = new Label("Hourly Rate");
        label5Constraints.fill = GridBagConstraints.BOTH;
        label5Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        label5Constraints.weightx = 1;
        label5Constraints.weighty = 0.9;
        label5Constraints.gridx =0;
        label5Constraints.gridy = 4;
        mainFrame.add(label5, label5Constraints);
        
        //Employee Hourly Rate User Input
        GridBagConstraints tField5Constraints = new GridBagConstraints();
        
        TextField tField5 = new TextField();
        tField5Constraints.fill = GridBagConstraints.BOTH;
        tField5Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
        tField5Constraints.weightx = 1;
        tField5Constraints.weighty = 1;
        tField5Constraints.gridx = 1;
        tField5Constraints.gridy = 4;
        tField5Constraints.gridwidth = 2;
        mainFrame.add(tField5, tField5Constraints);
        
        //Submit Button
        GridBagConstraints submitConstraints = new GridBagConstraints();
        
        Button submitButton = new Button("Submit");
        submitConstraints.fill = GridBagConstraints.HORIZONTAL;
        submitConstraints.gridx = 1;
        submitConstraints.gridy = 5;
        submitConstraints.insets = new Insets(10, 0, 0, 50);
        mainFrame.add(submitButton, submitConstraints);       
        
        //Output Label
        GridBagConstraints outputConstraints = new GridBagConstraints();
        
        Label output = new Label("Output:");
        outputConstraints.fill = GridBagConstraints.BOTH;
        outputConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        outputConstraints.weightx = 1;
        outputConstraints.weighty = 0.9;
        outputConstraints.gridx =0;
        outputConstraints.gridy = 6;
        outputConstraints.insets = new Insets(150, 0, 0, 0);
        mainFrame.add(output,  outputConstraints);
        
        //Output Display
        GridBagConstraints tOutputConstraints = new GridBagConstraints();

        TextArea tOutput = new TextArea(2, 5);
        tOutputConstraints.fill = GridBagConstraints.BOTH;
        tOutputConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
        tOutputConstraints.weightx = 1;
        tOutputConstraints.weighty = 2;
        tOutputConstraints.gridx = 0;
        tOutputConstraints.gridy = 8;
        tOutputConstraints.gridwidth = 3;
        mainFrame.add(tOutput, tOutputConstraints);
        tOutput.setEditable(false);
        
        //Button Action
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                boolean exceptionRaised = false;
                int fieldCounter = 0;
                if (tField1.getText().length()>0){
                    fieldCounter++;
                }
                
                if (tField2.getText().length()>0){
                    fieldCounter++;
                }
                if (tField3.getText().length()>0){
                    fieldCounter++;
                }
                if (tField4.getText().length()>0){
                    fieldCounter++;
                }
                if (tField5.getText().length()>0){
                    fieldCounter++;
                }
                
                //Handling errors
                if(fieldCounter != 5){
                    exceptionRaised = true;
                     tOutput.setText("Error: All fields must be filled out.");
                }
                if(exceptionRaised == false){
                        boolean ageFlag = false;
                        try {
                        Integer.parseInt(tField3.getText());
                        } catch (NumberFormatException d) {
                            ageFlag = true;
                            exceptionRaised = true;
                            tOutput.setText("Error: Age must be a valid integer.");
                        }
                        try{
                            Double.parseDouble(tField4.getText());
                            Double.parseDouble(tField5.getText());
                        } catch (NumberFormatException d) {
                            exceptionRaised = true;
                            if (ageFlag == true){
                            tOutput.setText("Error: Age must be a valid integer\nError: Hours worked and hourly rate must be valid numbers.");
                        }
                            else{
                             tOutput.setText("Error: Hours worked and hourly rate must be valid numbers.");
                            }
                        }
                }
                
                
                if(exceptionRaised == false){
                    //Calculations here and Output
                    String firstName = tField1.getText();
                    String lastName = tField2.getText();                    
                    int age = Integer.parseInt(tField3.getText());
                    double hoursWorked = Double.parseDouble(tField4.getText());
                    double hourlyRate = Double.parseDouble(tField5.getText());
                    tOutput.setText("Full Name: " + firstName + " " + lastName);
                    tOutput.append("\nAge: " + age + " years old");
                    tOutput.append("\nDaily Salary: PHP " + Math.round((hoursWorked * hourlyRate)*100.0)/100.0); //Round to two decimal places 
                }
                }
        }); 
        mainFrame.setVisible(true);
        mainFrame.setSize(500, 500);
        mainFrame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    public static void main(String[] args){
        LabActivity4EmpInfoSystemGUI lw = new LabActivity4EmpInfoSystemGUI();
    }   
}