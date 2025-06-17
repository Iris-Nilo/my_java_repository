import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;



public class CalculatorGUI extends JFrame{
    
    //Display
    private JTextArea displayArea;
    //Numbers
    private JButton zero, one, two, three, four, five, six, seven, eight, nine;
    //Operations
    private JButton 
            percent, division, multiplication, subtraction, addition,  decimal,
            equals, clearEntry, reciprocal, negate, square, squareRoot, backSpace, clear;
    //Variables
    private String currentInput;
    private String currentOperator;
    private String negativeConversion;
    private char lastInput;  
    private int partsCount = 0;
    private double result =0.0;
    private String displayResult;
    //Arrays
    private String [] operators = { "÷", "x", "-", "+"};
    private String[] specials = {"/", "^2", "\u221A", "%"};
    private String[] parts;
    private String[] exponentCount;
    private String[] reciprocalCount;
    private String[] rootCount;   
    //Booleans
    private boolean specialsFlag = false;   
    private boolean lastSpecials = false;
    //History Components
    private JTable table;
    private DefaultTableModel tableModel;
    private ArrayList<String> historyData = new ArrayList<>();   
    //Additional Colors
    private Color lightGray = new Color(238,238,238);
    private Color eerieBlack = new Color(28, 28, 28);
    private Color darkLiver = new Color(80, 80, 80);
    private Color vividGamboge = new Color(255, 149, 0);


      public CalculatorGUI(){
//----------------GUI------------------          
          JFrame mainFrame = new JFrame();
          mainFrame.setSize(400, 770);
         
          mainFrame.getContentPane().setBackground(lightGray);
          mainFrame.setTitle("Calculator");
          mainFrame.setLayout(new GridBagLayout());
          

//----------------Panel Constraints------------------     
          GridBagConstraints panelConstraints = new GridBagConstraints();
          panelConstraints.weightx = 1;
          panelConstraints.fill = GridBagConstraints.HORIZONTAL;
          panelConstraints.gridwidth = GridBagConstraints.REMAINDER;
          panelConstraints.ipady = 30; 

//----------------History Button Panel------------------             
          JPanel historyPanel = new JPanel();
          historyPanel.setBackground(lightGray);
          
          //History Button
          JButton historyButton = new JButton("HISTORY");
          historyButton.setForeground(Color.WHITE);
          historyButton.setBackground(eerieBlack);
          historyButton.setFont(new Font("Arial", Font.PLAIN, 20));
          historyPanel.add(historyButton);
          mainFrame.add(historyPanel, panelConstraints);

          
          
//----------------Display Panel------------------               
          JPanel displayPanel = new JPanel(); 
          displayPanel.setBackground(lightGray);
          
          //Output TextField
          displayArea = new JTextArea();
          displayArea.setEditable(false);
          displayArea.setForeground(darkLiver);
          displayArea.setFont(new Font("Arial", Font.BOLD, 22));
          displayArea.setBackground(lightGray);
          displayArea.setBorder(null);
          
          displayPanel.add(displayArea);
          mainFrame.add(displayPanel, panelConstraints);
          
          currentInput = "";
          displayArea.setText(currentInput);


//----------------Buttons Panel------------------     
          JPanel buttonsPanel = new JPanel();
          buttonsPanel.setBackground(lightGray);
          buttonsPanel.setLayout(new GridBagLayout());
          
//----------------Buttons------------------     

          
          //Row 1 Buttons
          GridBagConstraints btnConstraints = new GridBagConstraints();
          percent = new JButton("%");
          percent.setForeground(Color.WHITE);
          percent.setBackground(eerieBlack);
          btnConstraints.ipady =60;
          btnConstraints.gridx= 0;
          btnConstraints.gridy = 0;
          btnConstraints.fill = GridBagConstraints.BOTH;
          btnConstraints.weightx = 1.0;
          btnConstraints.weighty = 1.0;
          btnConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
          buttonsPanel.add(percent, btnConstraints);
          
          clearEntry = new JButton("CE");
          clearEntry.setForeground(Color.WHITE);
          clearEntry.setBackground(eerieBlack);
          btnConstraints.gridx = 1;
          btnConstraints.gridy = 0;
          buttonsPanel.add(clearEntry, btnConstraints);
          
          clear = new JButton("C");
          clear.setForeground(Color.WHITE);
          clear.setBackground(eerieBlack);
          btnConstraints.gridx = 2;
          btnConstraints.gridy = 0;
          buttonsPanel.add(clear, btnConstraints);

          backSpace = new JButton("DEL");
          backSpace.setForeground(Color.WHITE);
          backSpace.setBackground(eerieBlack);
          btnConstraints.gridx = 3;
          btnConstraints.gridy = 0;
          buttonsPanel.add(backSpace, btnConstraints);
       
          //Row 2 Buttons
          reciprocal = new JButton("1/x");
          reciprocal.setForeground(Color.WHITE);
          reciprocal.setBackground(darkLiver);
          btnConstraints.gridx= 0;
          btnConstraints.gridy=1;
          buttonsPanel.add(reciprocal, btnConstraints);
          
          square = new JButton("^2");
          square.setForeground(Color.WHITE);
          square.setBackground(darkLiver);
          btnConstraints.gridx = 1;
          btnConstraints.gridy = 1;
          buttonsPanel.add(square, btnConstraints);
          
          squareRoot = new JButton("\u221Ax");
          squareRoot.setForeground(Color.WHITE);
          squareRoot.setBackground(darkLiver);
          btnConstraints.gridx = 2;
          btnConstraints.gridy = 1;
          buttonsPanel.add(squareRoot, btnConstraints);
          
          division = new JButton("÷");
          division.setForeground(Color.WHITE);
          division.setBackground(vividGamboge);
          btnConstraints.gridx = 3;
          btnConstraints.gridy = 1;
          buttonsPanel.add(division, btnConstraints);
          
          //Row 3 Buttons   
          seven = new JButton("7");
          seven.setForeground(Color.WHITE);
          seven.setBackground(darkLiver);
          btnConstraints.gridx = 0;
          btnConstraints.gridy = 2;
          buttonsPanel.add(seven, btnConstraints);
          
          eight = new JButton("8");
          eight.setForeground(Color.WHITE);
          eight.setBackground(darkLiver);
          btnConstraints.gridx = 1;
          btnConstraints.gridy = 2;
          buttonsPanel.add(eight, btnConstraints);
          
          nine = new JButton("9");
          nine.setForeground(Color.WHITE);
          nine.setBackground(darkLiver);
          btnConstraints.gridx = 2;
          btnConstraints.gridy = 2;
          buttonsPanel.add(nine, btnConstraints);
          
          multiplication = new JButton("x");
          multiplication.setForeground(Color.WHITE);
          multiplication.setBackground(vividGamboge);
          btnConstraints.gridx = 3;
          btnConstraints.gridy = 2;
          buttonsPanel.add(multiplication, btnConstraints);
          
          //Row 4 Buttons   
          four = new JButton("4");
          four.setForeground(Color.WHITE);
          four.setBackground(darkLiver);
          btnConstraints.gridx = 0;
          btnConstraints.gridy = 3;
          buttonsPanel.add(four, btnConstraints);

          five = new JButton("5");
          five.setForeground(Color.WHITE);
          five.setBackground(darkLiver);
          btnConstraints.gridx = 1;
          btnConstraints.gridy = 3;
          buttonsPanel.add(five, btnConstraints);

          six = new JButton("6");
          six.setForeground(Color.WHITE);
          six.setBackground(darkLiver);
          btnConstraints.gridx = 2;
          btnConstraints.gridy = 3;
          buttonsPanel.add(six, btnConstraints);

          subtraction = new JButton("-");
          subtraction.setForeground(Color.WHITE);
          subtraction.setBackground(vividGamboge);
          btnConstraints.gridx = 3;
          btnConstraints.gridy = 3;
          buttonsPanel.add(subtraction, btnConstraints);
          
          //Row 5 Buttons   
          one = new JButton("1");
          one.setForeground(Color.WHITE);
          one.setBackground(darkLiver);
          btnConstraints.gridx = 0;
          btnConstraints.gridy = 4;
          buttonsPanel.add(one, btnConstraints);

          two = new JButton("2");
          two.setForeground(Color.WHITE);
          two.setBackground(darkLiver);
          btnConstraints.gridx = 1;
          btnConstraints.gridy = 4;
          buttonsPanel.add(two, btnConstraints);

          three = new JButton("3");
          three.setForeground(Color.WHITE);
          three.setBackground(darkLiver);
          btnConstraints.gridx = 2;
          btnConstraints.gridy = 4;
          buttonsPanel.add(three, btnConstraints);

          addition = new JButton("+");
          addition.setForeground(Color.WHITE);
          addition.setBackground(vividGamboge);
          btnConstraints.gridx = 3;
          btnConstraints.gridy = 4;
          buttonsPanel.add(addition, btnConstraints);
          
          //Row 6 Buttons   
          negate = new JButton("+/-");
          negate.setForeground(Color.WHITE);
          negate.setBackground(darkLiver);
          btnConstraints.gridx = 0;
          btnConstraints.gridy = 5;
          buttonsPanel.add(negate, btnConstraints);

          zero = new JButton("0");
          zero.setForeground(Color.WHITE);
          zero.setBackground(darkLiver);
          btnConstraints.gridx = 1;
          btnConstraints.gridy = 5;
          buttonsPanel.add(zero, btnConstraints);

          decimal = new JButton(".");
          decimal.setForeground(Color.WHITE);
          decimal.setBackground(darkLiver);
          btnConstraints.gridx = 2;
          btnConstraints.gridy = 5;
          buttonsPanel.add(decimal, btnConstraints);
          
          equals = new JButton("=");
          equals.setForeground(Color.WHITE);
          equals.setBackground(vividGamboge);
          btnConstraints.gridx = 3;
          btnConstraints.gridy = 5;
          buttonsPanel.add(equals, btnConstraints);
                    
          mainFrame.add(buttonsPanel, panelConstraints);
 
//----------------Adding Listeners to Buttons------------------          
          //Numbers Listener
          NumbersListener numberListener = new NumbersListener();
          zero.addActionListener(numberListener);
          one.addActionListener(numberListener);
          two.addActionListener(numberListener);
          three.addActionListener(numberListener);
          four.addActionListener(numberListener);
          five.addActionListener(numberListener);
          six.addActionListener(numberListener);
          seven.addActionListener(numberListener);
          eight.addActionListener(numberListener);
          nine.addActionListener(numberListener);
          
          //Operations Listener
          AllButtonsListener allButtonListener = new AllButtonsListener();
          division.addActionListener(allButtonListener);
          multiplication.addActionListener(allButtonListener);
          subtraction.addActionListener(allButtonListener);
          addition.addActionListener(allButtonListener);
          
          //Special Buttons
          square.addActionListener(allButtonListener);
          reciprocal.addActionListener(allButtonListener);
          squareRoot.addActionListener(allButtonListener);
          percent.addActionListener(allButtonListener);
          
          clearEntry.addActionListener(allButtonListener);
          backSpace.addActionListener(allButtonListener);
          clear.addActionListener(allButtonListener);
          negate.addActionListener(allButtonListener);
          decimal.addActionListener(allButtonListener);
          
          //Equals Listener
          EqualsListener equalListener = new EqualsListener();
          equals.addActionListener(equalListener);
          
          //History Button Listener
          historyButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  
                  history historyWindow = history.getInstance();
                  if (historyWindow != null) {
                      if (historyWindow.isVisible()) {
                          historyWindow.setVisible(false);
                         tableModel.setRowCount(0);
                      } else if (!historyWindow.isVisible()){
                          historyWindow.setVisible(true);
                          for (String entry : historyData) {
                          Object[] rowData = {entry};
                          tableModel.addRow(rowData);
                      }

                      }
                  }                 
                  else{
                      history newWindow = new history();
                      newWindow.setVisible(true);
                      for (String entry : historyData) {
                          Object[] rowData = {entry};
                          tableModel.addRow(rowData);
                      }
                  } 
                  
              }
          });

                   
//----------------Main Frame Settings------------------
          mainFrame.setVisible(true);
          mainFrame.setLocationRelativeTo(null);
          mainFrame.setResizable(false);
          mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }

      public class history extends JFrame{
          private static history instance = null;
          public history(){
              
              setSize(400, 450);
              setLocationRelativeTo(null);
              setResizable(false);
              setTitle("Calculator History");
              setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

              JPanel panel = new JPanel();
              Container contentPane = getContentPane();
              contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
              contentPane.add(Box.createVerticalStrut(5));
              this.getContentPane().add(panel); 
              

              //Table
              tableModel = new DefaultTableModel();
              tableModel.addColumn("History");
              table = new JTable(tableModel);
              
              table.setEnabled(false);
      
              
              JScrollPane scrollPane = new JScrollPane(table);
              contentPane.add(Box.createHorizontalStrut(140));
              contentPane.add(scrollPane);

              setVisible(true);
              setLocation(1140,130);
              
              instance = this;
          
          } 
          
          @Override
          public void dispose(){
              instance = null;
              super.dispose();
          }
             
          public static history getInstance(){
              return instance;
          }
      
      }

//----------------Listeners------------------      

      //Numbers Listener (0-9)
        private class NumbersListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            String command = evt.getActionCommand();            
            currentInput = displayArea.getText();      
                            if (!currentInput.isEmpty()){
                lastInput = currentInput.charAt(currentInput.length()-1);
                for (int j = 0; j < operators.length; j++){
                    if (currentInput.contains(operators[j])){
                        currentOperator = operators[j];
                    }
            }
          }
            if (!currentInput.isEmpty()){
                if (currentOperator != "x"){
                        parts = currentInput.split("\\" + currentOperator);
                    }
                    else{
                        parts = currentInput.split(currentOperator);
                    }
                partsCount = parts.length;
                
                if (partsCount >1){
                    if(!parts[1].contains("^2")){
                        displayArea.setText(currentInput + command);
                        }
                }
                
                else if (currentOperator != null){
                    if (currentOperator.contains(String.valueOf(lastInput))){
                        displayArea.setText(currentInput + command);
                    }

                }
                else{
                    if (!parts[0].contains("^2")){
                        displayArea.setText(currentInput + command);
                    }
                }
            }

            else{
                displayArea.setText(currentInput + command);
            }

            }
        }
        


        //All Buttons Listener
        private class AllButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            history historyWindow = history.getInstance();
            String command = evt.getActionCommand();
            currentInput = displayArea.getText();
                     
                if (!currentInput.isEmpty()){
                lastInput = currentInput.charAt(currentInput.length()-1);
                for (int j = 0; j < operators.length; j++){
                    if (currentInput.contains(operators[j])){
                        currentOperator = operators[j];
                    }
            }
          }
//--------------------------------------------------For clicking "%"---------------------------------------------------                      
                if (command == "%" && !currentInput.isEmpty()) {
                if (currentOperator == null) {
                    for (int x =0 ; x < specials.length; x++){
                        if (currentInput.contains(specials[x])){
                            specialsFlag = true;
                        }                                      
                    }
                        if (!currentInput.contains("%") && specialsFlag == false){
                        displayArea.setText("%" + currentInput); 
                    }
                        specialsFlag = false;
                } 
                else if (!Arrays.asList(operators).contains(String.valueOf(lastInput))) {
                    if (currentOperator != "x"){
                        parts = currentInput.split("\\" + currentOperator);
                    }
                    else{
                        parts = currentInput.split(currentOperator);
                    }
                    for (int x =0 ; x < specials.length; x++){
                        if (parts[1].contains(specials[x])){
                            specialsFlag = true;
                        
                        }}                               
                   
                    if (!parts[1].contains("%") && specialsFlag == false ){
                    displayArea.setText(parts[0].trim() + currentOperator + "%" + parts[1].trim()); 
                    }
                    currentOperator = null;
                    specialsFlag = false;
                }
            }
                
//--------------------------------------------------For clicking "^2"---------------------------------------------------                    
              else  if (command == "^2" && !currentInput.isEmpty()) {
                if (currentOperator == null) {
                    for (int x = 0; x < specials.length; x++) {
                        if (currentInput.contains(specials[x])) {
                            if (!currentInput.contains("^2")){
                            specialsFlag = true;
                            }
                        }
                    }
                    if (specialsFlag == false) {
                        displayArea.setText(currentInput + "^2");
                    }
                    specialsFlag = false;
                } else if (!Arrays.asList(operators).contains(String.valueOf(lastInput))) {
                    if (currentOperator != "x") {
                        parts = currentInput.split("\\" + currentOperator);
                    } else {
                        parts = currentInput.split(currentOperator);
                    }
                    for (int x = 0; x < specials.length; x++) {
                        if (parts[1].contains(specials[x])) {
                            if (!parts[1].contains("^2")){
                            specialsFlag = true;
                            }
                        }
                    }

                    if (specialsFlag == false) {
                        displayArea.setText(parts[0].trim() + currentOperator + parts[1].trim() + "^2");
                    }
                    currentOperator = null;
                    specialsFlag = false;
                }
            }
                
//--------------------------------------------------For clicking "1/x"---------------------------------------------------                        
                else if (command == "1/x" && !currentInput.isEmpty()){                    
                if (currentOperator == null){
                    for (int x = 0; x < specials.length; x++) {
                        if (currentInput.contains(specials[x])) {
                            if(!currentInput.contains("1/")){
                                specialsFlag = true;   
                            }
                        }
                    }
                    if (specialsFlag == false) {
                        displayArea.setText("1/" + currentInput);
                    }
                    specialsFlag = false;
                }
                else if(!Arrays.asList(operators).contains(String.valueOf(lastInput))){
                    if (currentOperator != "x") {
                        parts = currentInput.split("\\" + currentOperator);
                    } else {
                        parts = currentInput.split(currentOperator);
                    }
                    for (int x = 0; x < specials.length; x++) {
                        if (parts[1].contains(specials[x])) {
                            if(!parts[1].contains("1/")){
                                specialsFlag = true;  
                            }
                        }
                    } 
                    if (specialsFlag == false) {
                    displayArea.setText(parts[0].trim() + currentOperator + "1/" + parts[1].trim());
                    } 
                    currentOperator = null;
                    specialsFlag = false;
                }
            }
//--------------------------------------------------For clicking "+/-"---------------------------------------------------             
                else if (command == "+/-" && !currentInput.isEmpty()) {
                    
                if (currentOperator == null) {
                    if (!currentInput.contains("−")){
                        displayArea.setText("−" + currentInput);
                    }
                } else if (!Arrays.asList(operators).contains(String.valueOf(lastInput))) {
                    if(currentOperator != "x"){
                        parts = currentInput.split("\\" + currentOperator);
                    } else{
                        parts = currentInput.split(currentOperator);
                    }
                    if (!parts[1].contains("−")){
                    displayArea.setText(parts[0].trim() + currentOperator + "−" + parts[1].trim());
                    
                    }
                    currentOperator = null;

                }
                    
                }            
//--------------------------------------------------For clicking "CE"---------------------------------------------------             
            else   if (command == "CE") {
                        displayArea.setText("");                     
                        currentOperator = null;
                        Character lastInput = null;
                        currentInput = null;
                        lastSpecials = false;
            }
//--------------------------------------------------For clicking "C"---------------------------------------------------               
           else if (command == "C") {
                        displayArea.setText("");
                    historyData.removeAll(historyData);
                    if (historyWindow != null){
                        if(historyWindow.isVisible()){
                            tableModel.setRowCount(0);
                        }
                    }
                    currentOperator = null;
                    specialsFlag = false;
                    Character lastInput = null;
                    currentInput = null;
                    lastSpecials = false;
            }
//--------------------------------------------------For clicking "DEL"---------------------------------------------------              
           else  if (command == "DEL") {
                    if (currentInput.length() > 0) {
                        displayArea.setText(currentInput.substring(0, currentInput.length() - 1));
                        if (currentOperator != null){
                        if(currentInput.contains(currentOperator)){
                            currentOperator = null;
                        }
                        }
                    lastSpecials = false;
                    }
            }
 
//--------------------------------------------------For clicking "."---------------------------------------------------            
            else if (command == "." && String.valueOf(lastInput) != ".") {

                    if (currentInput.isEmpty()) {
                        displayArea.setText("0.");
                    } else if (currentInput.contains(".")) {
                        if (currentOperator != null) {
                            if (currentOperator != "x"){
                                parts = currentInput.split("\\" + currentOperator);
                            }
                            else{
                            parts = currentInput.split(currentOperator);
                            }
                            if (parts.length > 1 && !parts[1].contains(".")) {
                                    displayArea.setText(parts[0] + currentOperator + parts[1] + ".");
                            } else if (parts.length ==1){
                                displayArea.setText(parts[0] + currentOperator + "0.");
                            }
                        } 
                    } else {
                        displayArea.setText(currentInput + ".");
                    }
                          
                    currentOperator = null;
            } 
//--------------------------------------------------For clicking "\u221Ax"---------------------------------------------------              
            else if (command  == "\u221Ax" &&!currentInput.isEmpty()){

                    if (currentOperator == null) {
                        for (int x = 0; x < specials.length; x++) {
                            if (currentInput.contains(specials[x]) && !currentInput.contains("\u221A")) {
                                    specialsFlag = true;
                            }
                        }
                        if (specialsFlag == false) {
                            displayArea.setText("\u221A" + currentInput);
                        }
                        specialsFlag = false;
                    } else if (!Arrays.asList(operators).contains(String.valueOf(lastInput))) {
                        if (currentOperator != "x") {
                            parts = currentInput.split("\\" + currentOperator);
                        } else {
                            parts = currentInput.split(currentOperator);
                        }                       
                        for (int x = 0; x < specials.length; x++) {
                            if (parts[1].contains(specials[x]) && !parts[1].contains("\u221A")) {
                                    specialsFlag = true;
                            }
                        }
                        if (specialsFlag == false){
                            displayArea.setText(parts[0].trim() + currentOperator + "\u221A" + parts[1].trim());
                        }
                        currentOperator = null;
                        specialsFlag = false;

                }
            }
            
            else{
                    for (int i = 0; i <specials.length; i++){
                    if(specials[i].contains(String.valueOf(lastInput))){
                        if (!specials[i].contains("^2")) {
                        lastSpecials = true;
                        }
                    }
                }
     
           if (!Arrays.asList(operators).contains(String.valueOf(lastInput)) && !currentInput.isEmpty() && !String.valueOf(lastInput).contains("^")&& lastSpecials == false && currentOperator == null && !String.valueOf(lastInput).contains(".")&& !String.valueOf(lastInput).contains("−")){

                displayArea.append(command); 
                lastSpecials = false;
            }
           else if(Arrays.asList(operators).contains(String.valueOf(lastInput)) && !String.valueOf(lastInput).contains("^")&& currentOperator != null&& lastSpecials == false && String.valueOf(lastInput) != "−"){
                        
                     currentInput = currentInput.substring(0, currentInput.length() - 1);
                     displayArea.setText(currentInput + command);
                      lastSpecials = false;    
               }
           
           
           
//----------------------------When another operator is clicked, it performs the initial operation----------------------------------                     
          else if (currentOperator != String.valueOf(lastInput) && currentOperator !=null && !String.valueOf(lastInput).contains(".") &&  !String.valueOf(lastInput).contains("^") && lastSpecials == false && !String.valueOf(lastInput).contains("−")){
                     if (currentOperator == "+") {
                        if (command == "+") {
                                add();
                                displayArea.append("+");
                                currentOperator = null;
                        }
                        else if (command == "-") {
                            add();
                            displayArea.append("-");
                            currentOperator = null;
                        }
                        else if (command == "÷") {
                            add();
                            displayArea.append("÷");
                            currentOperator = null;
                        }
                        else if (command == "x") {
                            add();
                            displayArea.append("x");
                            currentOperator = null;
                        }                       
                     }
                    else if (currentOperator == "-") {
                        if (command == "+") {
                            minus();
                            displayArea.append("+");
                            currentOperator = null;
                        }
                        else if (command == "-") {
                            minus();
                            displayArea.append("-");
                            currentOperator = null;
                        }
                        else if (command == "÷") {
                            minus();
                            displayArea.append("÷");
                            currentOperator = null;
                        }
                        else if (command == "x") {
                            minus();
                            displayArea.append("x");
                            currentOperator = null;
                        }
                    }
                    else if (currentOperator == "÷") {
                        if (command == "+") {
                            divide();
                            displayArea.append("+");
                            currentOperator = null;
                        }
                        else if (command == "-") {
                            divide();
                            displayArea.append("-");
                            currentOperator = null;
                        }
                        else if (command == "÷") {
                            divide();
                            displayArea.append("÷");
                            currentOperator = null;
                        }
                        else if (command == "x") {
                            divide();
                            displayArea.append("x");
                            currentOperator = null;
                        }
                    }
                    else if (currentOperator == "x") {
                        if (command == "+") {
                            multiply();
                            displayArea.append("+");
                            currentOperator = null;
                        }
                        else if (command == "-") {
                            multiply();
                            displayArea.append("-");
                            currentOperator = null;
                        }
                        else if (command == "÷") {
                            multiply();
                            displayArea.append("÷");
                            currentOperator = null;
                        }
                        else if (command == "x") {
                            multiply();
                            displayArea.append("x");
                            currentOperator = null;
                        }
                    }
         } 

        lastSpecials = false;
            }

        }
      
    }
        
//--------------------------------------------------Equals Listener---------------------------------------------------        
        private class EqualsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            
            currentInput = displayArea.getText();
                     
                if (!currentInput.isEmpty()){
                lastInput = currentInput.charAt(currentInput.length()-1);
                for (int j = 0; j < operators.length; j++){
                    if (currentInput.contains(operators[j])){
                        currentOperator = operators[j];
                    }
                    
            }
          }

                for (int i = 0; i <specials.length; i++){
                    if(specials[i].contains(String.valueOf(lastInput))){
                        if(!specials[i].contains("^2")){

                            lastSpecials = true;

                        }
                        
                    }
                }

                if (currentOperator != null){
               if(!currentOperator.contains(String.valueOf(lastInput)) && lastSpecials == false &&  !String.valueOf(lastInput).contains("^") && !String.valueOf(lastInput).contains("−")){
                   calculations();
                  
                   String result = displayArea.getText();
                 
               } 
                }
                else if (lastSpecials == false &&  !String.valueOf(lastInput).contains("^")&& !String.valueOf(lastInput).contains("−")){
                    calculations();
                   
                   String result = displayArea.getText();
                 
                }

                lastSpecials = false;
                currentOperator = null;
        }
    }

//--------------------------------Calculation Methods----------------------------------------------------------------------

     //Addition Method
    private void add() {      
            
            String newSign = currentInput.replace("−", "-");
            parts = newSign.split("\\+");

            double firstNum = 0.0;
            double secondNum = 0.0;
            double lowerNumber1;
            double lowerNumber2;
            double result;
            double newNumber;
            
            //----------------If there is percentage------------------
            if (parts[0].contains("%") || parts[1].contains("%")) {
                
                    if(parts[0].contains("%") && parts[1].contains("%")) {

                    String newFirstNum = parts[0].replace("%", "");
                    firstNum = Double.parseDouble(newFirstNum) / 100.0;

                    String newSecondNum = parts[1].replace("%", "");
                    secondNum = Double.parseDouble(newSecondNum) / 100.0;

                }
                   else if (parts[0].contains("%")) {
                        String newFirstNum = parts[0].replace("%", "");
                        firstNum = Double.parseDouble(newFirstNum) / 100.0;


                    } 
                    else if (parts[1].contains("%")) {
                    String newsecondNum = parts[1].replace("%", "");
                    secondNum = Double.parseDouble(newsecondNum) / 100.0;

                    }
             
        } 
            //----------------If there is square------------------  
            if (parts[0].contains("^2") || parts[1].contains("^2")){
                        if (parts[0].contains("^2") && parts[1].contains("^2")) {
                            exponentCount = parts[0].split("\\^");
                            String number1 = exponentCount[0];
                            double newNumber1 = Double.parseDouble(number1);

                            for (int x = 0; x < (exponentCount.length - 1); x++) {
                                result = Math.pow(-newNumber1, 2);
                                newNumber1 = result;
                            }
                            firstNum = newNumber1;
                            
                            exponentCount = parts[1].split("\\^");
                            String number2 = exponentCount[0];
                            double newNumber2 = Double.parseDouble(number2);

                            for (int x = 0; x < (exponentCount.length - 1); x++) {
                                result = Math.pow(-newNumber2, 2);
                                newNumber2 = result;
                            }
                            secondNum = newNumber2;
                            
                        } else if (parts[0].contains("^2")) {
                            exponentCount = parts[0].split("\\^");
                            String number = exponentCount[0];
                            newNumber = Double.parseDouble(number);         
                            
                            for (int x = 0; x < (exponentCount.length - 1); x++) {
                                result = Math.pow(-newNumber, 2);
                                newNumber = result;
                            }
                            firstNum = newNumber;

                        } else if (parts[1].contains("^2")) {
                            exponentCount = parts[1].split("\\^");
                            String number = exponentCount[0];
                            newNumber = Double.parseDouble(number);

                            for (int x = 0; x < (exponentCount.length - 1); x++) {
                                result = Math.pow(-newNumber, 2);
                                newNumber = result;
                            }
                            secondNum = newNumber;
                        }
                        
            }             
            //----------------If there is square root------------------  
            if (parts[0].contains("\u221A") || parts[1].contains("\u221A")){
                                if (parts[0].contains("\u221A") && parts[1].contains("\u221A")) {
                                    rootCount = parts[0].split("\u221A");
                                    newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                                    for (int x = 0; x < (rootCount.length - 1); x++) {
                                        result = Math.sqrt(newNumber);
                                        newNumber = result;
                                    }
                                    if(rootCount[0].contains("-")){
                                        negativeConversion = "-" + newNumber;
                                        firstNum = Double.parseDouble(negativeConversion);
                                    }
                                    else{
                                    firstNum = newNumber;
                                    }  
                                    rootCount = parts[1].split("\u221A");
                                    newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                                    for (int x = 0; x < (rootCount.length - 1); x++) {
                                        result = Math.sqrt(newNumber);
                                        newNumber = result;
                                    }
                                    if(rootCount[0].contains("-")){
                                        negativeConversion = "-" + newNumber;
                                        secondNum = Double.parseDouble(negativeConversion);
                                    }
                                    else{
                                    secondNum = newNumber;
                                    }  
                                          
                                } else if (parts[0].contains("\u221A")){
                                        rootCount = parts[0].split("\u221A");
                                        newNumber = Double.parseDouble(rootCount[rootCount.length-1]);

                                        for (int x = 0; x < (rootCount.length - 1); x++) {
                                            result = Math.sqrt(newNumber);
                                            newNumber = result;
                                        }     
                                            if(rootCount[0].contains("-")){
                                        negativeConversion = "-" + newNumber;
                                        firstNum = Double.parseDouble(negativeConversion);
                                    }
                                    else{
                                    firstNum = newNumber;
                                    }  
                                            
                                } else if (parts[1].contains("\u221A")){
                                    rootCount = parts[1].split("\u221A");
                                    newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                                    for (int x = 0; x < (rootCount.length - 1); x++) {
                                        result = Math.sqrt(newNumber);
                                        newNumber = result;
                                    }
                                    if(rootCount[0].contains("-")){
                                        negativeConversion = "-" + newNumber;
                                        secondNum = Double.parseDouble(negativeConversion);
                                    }
                                    else{
                                    secondNum = newNumber;
                                    }  
                                }
                }
        //----------------If there is reciprocal------------------  
                if (parts[0].contains("1/") || parts[1].contains("1/")) {
                    if (parts[0].contains("1/") && parts[1].contains("1/")) {
                        reciprocalCount = parts[0].split("/");
                        lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);

                        if(!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")){
                            lowerNumber1  = Double.parseDouble("-" + lowerNumber1);
                        }
                        for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                            result = 1 / lowerNumber1;
                            lowerNumber1 = result;

                        }
                        firstNum = lowerNumber1;


                        reciprocalCount = parts[1].split("/");
                        lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                        if(!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")){
                            lowerNumber2  = Double.parseDouble("-" + lowerNumber2);
                        }
                        for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                            result = 1 / lowerNumber2;
                            lowerNumber2 = result;

                        }
                        secondNum = lowerNumber2;
                    } else if (parts[0].contains("1/")) {
                        
                        reciprocalCount= parts[0].split("/");
                        lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length-1]);
   
                        if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")) {
                            lowerNumber1 = Double.parseDouble("-" + lowerNumber1);
                        }
                        for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                            result = 1 / lowerNumber1;                           
                            lowerNumber1 = result;

                        }
                        firstNum = lowerNumber1;
                        
                    } else if (parts[1].contains("1/")) {
                        reciprocalCount = parts[1].split("/");
                        lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                        if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")) {
                            lowerNumber2 = Double.parseDouble("-" + lowerNumber2);
                        }
                        for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                            result = 1 / lowerNumber2;
                            lowerNumber2 = result;

                        }
                        secondNum = lowerNumber2;
                    }
                }       

                    if (firstNum == 0.0 || secondNum == 0.0){
                            if (firstNum == 0.0 && secondNum == 0.0){
                                firstNum = Double.parseDouble((parts[0]));
                                secondNum = Double.parseDouble(parts[1].trim());
                            }
                            else if (firstNum == 0.0){
                                firstNum = Double.parseDouble((parts[0]));
                            }
                            else if (secondNum == 0.0){
                                secondNum = Double.parseDouble(parts[1].trim());
                            }
                    }
                    displayResult = String.valueOf(firstNum + secondNum);
                    if (displayResult.contains("-")){ 
                        displayResult = displayResult.replace("-", "−");
                    }
                    
                    historyData.add(currentInput + "=" + displayResult);
                    history historyWindow = history.getInstance();
                    if (historyWindow != null) {
                        if (historyWindow.isVisible()) {
                            Object[] rowData = {currentInput + "=" + displayResult};
                            tableModel.addRow(rowData);
                        }
                    }
                    displayArea.setText(displayResult);                    
    }
    //Subtraction Method
    private void minus() {
        parts = currentInput.split("-");
        parts[0] = parts[0].replace("−", "-");
        parts[1] = parts[1].replace("−", "-");
 

        double firstNum = 0.0;
        double secondNum = 0.0;
        double lowerNumber1;
        double lowerNumber2;
        double result;
        double newNumber;
        //----------------If there is percentage------------------
        if (parts[0].contains("%") || parts[1].contains("%")) {

            if (parts[0].contains("%") && parts[1].contains("%")) {

                String newFirstNum = parts[0].replace("%", "");
                firstNum = Double.parseDouble(newFirstNum) / 100.0;

                String newSecondNum = parts[1].replace("%", "");
                secondNum = Double.parseDouble(newSecondNum) / 100.0;


            } else if (parts[0].contains("%")) {

                String newFirstNum = parts[0].replace("%", "");
                firstNum = Double.parseDouble(newFirstNum) / 100.0;

            } else if (parts[1].contains("%")) {

                String newsecondNum = parts[1].replace("%", "");
                secondNum = Double.parseDouble(newsecondNum) / 100.0;

            }

        }
        //----------------If there is square------------------  
        if (parts[0].contains("^2") || parts[1].contains("^2")) {
            if (parts[0].contains("^2") && parts[1].contains("^2")) {
                exponentCount = parts[0].split("\\^");
                String number1 = exponentCount[0];
                double newNumber1 = Double.parseDouble(number1);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber1, 2);
                    newNumber1 = result;
                }
                firstNum = newNumber1;

                exponentCount = parts[1].split("\\^");
                String number2 = exponentCount[0];
                double newNumber2 = Double.parseDouble(number2);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber2, 2);
                    newNumber2 = result;
                }
                secondNum = newNumber2;

            } else if (parts[0].contains("^2")) {
                exponentCount = parts[0].split("\\^");
                String number = exponentCount[0];
                newNumber = Double.parseDouble(number);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber, 2);
                    newNumber = result;
                }
                firstNum = newNumber;

            } else if (parts[1].contains("^2")) {
                exponentCount = parts[1].split("\\^");
                String number = exponentCount[0];
                newNumber = Double.parseDouble(number);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber, 2);
                    newNumber = result;
                }
                secondNum = newNumber;
            }

        }
        //----------------If there is square root------------------  
        if (parts[0].contains("\u221A") || parts[1].contains("\u221A")) {
            if (parts[0].contains("\u221A") && parts[1].contains("\u221A")) {
                rootCount = parts[0].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    firstNum = Double.parseDouble(negativeConversion);
                } else {
                    firstNum = newNumber;
                }
                rootCount = parts[1].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    secondNum = Double.parseDouble(negativeConversion);
                } else {
                    secondNum = newNumber;
                }

            } else if (parts[0].contains("\u221A")) {
                rootCount = parts[0].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    firstNum = Double.parseDouble(negativeConversion);
                } else {
                    firstNum = newNumber;
                }

            } else if (parts[1].contains("\u221A")) {
                rootCount = parts[1].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    secondNum = Double.parseDouble(negativeConversion);
                } else {
                    secondNum = newNumber;
                }
            }
        }
        //----------------If there is reciprocal------------------  
        if (parts[0].contains("1/") || parts[1].contains("1/")) {
            if (parts[0].contains("1/") && parts[1].contains("1/")) {
                reciprocalCount = parts[0].split("/");
                lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")) {
                    lowerNumber1 = Double.parseDouble("-" + lowerNumber1);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber1;
                    lowerNumber1 = result;

                }
                firstNum = lowerNumber1;

                reciprocalCount = parts[1].split("/");
                lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")) {
                    lowerNumber2 = Double.parseDouble("-" + lowerNumber2);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber2;
                    lowerNumber2 = result;

                }
                secondNum = lowerNumber2;

            } else if (parts[0].contains("1/")) {

                reciprocalCount = parts[0].split("/");
                lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")) {
                    lowerNumber1 = Double.parseDouble("-" + lowerNumber1);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber1;
                    lowerNumber1 = result;

                }
                firstNum = lowerNumber1;

            } else if (parts[1].contains("1/")) {
                reciprocalCount = parts[1].split("/");
                lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")) {
                    lowerNumber2 = Double.parseDouble("-" + lowerNumber2);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber2;
                    lowerNumber2 = result;

                }
                secondNum = lowerNumber2;
            }
        }

        if (firstNum == 0.0 || secondNum == 0.0) {
            if (firstNum == 0.0 && secondNum == 0.0) {
                firstNum = Double.parseDouble((parts[0]));
                secondNum = Double.parseDouble(parts[1].trim()); 
            } 
            else if (firstNum == 0.0) {
                firstNum = Double.parseDouble((parts[0]));
            } else if (secondNum == 0.0) {
                secondNum = Double.parseDouble(parts[1].trim());
            } 
        }
        
        displayResult = String.valueOf(firstNum - secondNum);
                    if (displayResult.contains("-")){ 
                        displayResult = displayResult.replace("-", "−");
                    }
        historyData.add(currentInput + "=" + displayResult);
        history historyWindow = history.getInstance();
        if (historyWindow != null) {
            if (historyWindow.isVisible()) {
                Object[] rowData = {currentInput + "=" + displayResult};
                tableModel.addRow(rowData);
            }
        }
        displayArea.setText(displayResult);
   
    }
    //Division Method    
    private void divide() {
        String newSign = currentInput.replace("−", "-");
        parts = newSign.split("÷");
        
        double firstNum = 0.0;
        double secondNum = 0.0;
        double lowerNumber1 = 0.0;
        double lowerNumber2 = 0.0;
        double result = 0.0;
        double newNumber;
        //----------------If there is percentage------------------
        if (parts[0].contains("%") || parts[1].contains("%")) {

            if (parts[0].contains("%") && parts[1].contains("%")) {

                String newFirstNum = parts[0].replace("%", "");
                firstNum = Double.parseDouble(newFirstNum) / 100.0;

                String newSecondNum = parts[1].replace("%", "");
                secondNum = Double.parseDouble(newSecondNum) / 100.0;

            } else if (parts[0].contains("%")) {

                String newFirstNum = parts[0].replace("%", "");
                firstNum = Double.parseDouble(newFirstNum) / 100.0;

            } else if (parts[1].contains("%")) {
                String newsecondNum = parts[1].replace("%", "");
                secondNum = Double.parseDouble(newsecondNum) / 100.0;

            }

        }
        //----------------If there is square------------------  
        if (parts[0].contains("^2") || parts[1].contains("^2")) {
            if (parts[0].contains("^2") && parts[1].contains("^2")) {
                exponentCount = parts[0].split("\\^");
                String number1 = exponentCount[0];
                double newNumber1 = Double.parseDouble(number1);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber1, 2);
                    newNumber1 = result;
                }
                firstNum = newNumber1;

                exponentCount = parts[1].split("\\^");
                String number2 = exponentCount[0];
                double newNumber2 = Double.parseDouble(number2);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber2, 2);
                    newNumber2 = result;
                }
                secondNum = newNumber2;

            } else if (parts[0].contains("^2")) {
                exponentCount = parts[0].split("\\^");
                String number = exponentCount[0];
                newNumber = Double.parseDouble(number);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber, 2);
                    newNumber = result;
                }
                firstNum = newNumber;

            } else if (parts[1].contains("^2")) {
                exponentCount = parts[1].split("\\^");
                String number = exponentCount[0];
                newNumber = Double.parseDouble(number);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber, 2);
                    newNumber = result;
                }
                secondNum = newNumber;
            }

        }
        //----------------If there is square root------------------  
        if (parts[0].contains("\u221A") || parts[1].contains("\u221A")) {
            if (parts[0].contains("\u221A") && parts[1].contains("\u221A")) {
                rootCount = parts[0].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    firstNum = Double.parseDouble(negativeConversion);
                } else {
                    firstNum = newNumber;
                }
                rootCount = parts[1].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    secondNum = Double.parseDouble(negativeConversion);
                } else {
                    secondNum = newNumber;
                }

            } else if (parts[0].contains("\u221A")) {
                rootCount = parts[0].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    firstNum = Double.parseDouble(negativeConversion);
                } else {
                    firstNum = newNumber;
                }

            } else if (parts[1].contains("\u221A")) {
                rootCount = parts[1].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    secondNum = Double.parseDouble(negativeConversion);
                } else {
                    secondNum = newNumber;
                }
            }
        }
        //----------------If there is reciprocal------------------  
        if (parts[0].contains("1/") || parts[1].contains("1/")) {
            if (parts[0].contains("1/") && parts[1].contains("1/")) {
                reciprocalCount = parts[0].split("/");
                lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")) {
                    lowerNumber1 = Double.parseDouble("-" + lowerNumber1);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber1;
                    lowerNumber1 = result;

                }
                firstNum = lowerNumber1;

                reciprocalCount = parts[1].split("/");
                lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")) {
                    lowerNumber2 = Double.parseDouble("-" + lowerNumber2);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber2;
                    lowerNumber2 = result;

                }
                secondNum = lowerNumber2;

            } else if (parts[0].contains("1/")) {

                reciprocalCount = parts[0].split("/");
                lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")) {
                    lowerNumber1 = Double.parseDouble("-" + lowerNumber1);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber1;
                    lowerNumber1 = result;

                }
                firstNum = lowerNumber1;

            } else if (parts[1].contains("1/")) {
                reciprocalCount = parts[1].split("/");
                lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")) {
                    lowerNumber2 = Double.parseDouble("-" + lowerNumber2);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber2;
                    lowerNumber2 = result;

                }
                secondNum = lowerNumber2;
            }
        }

        if (firstNum == 0.0 || secondNum == 0.0) {
            if (firstNum == 0.0 && secondNum == 0.0) {
                firstNum = Double.parseDouble((parts[0]));
                secondNum = Double.parseDouble(parts[1].trim());
            } else if (firstNum == 0.0) {
                firstNum = Double.parseDouble((parts[0]));
            } else if (secondNum == 0.0) {
                secondNum = Double.parseDouble(parts[1].trim());
            }
        }
        displayResult = String.valueOf(firstNum / secondNum);
                    if (displayResult.contains("-")){ 
                        displayResult = displayResult.replace("-", "−");
                    }
                    
        historyData.add(currentInput + "=" + displayResult);
        history historyWindow = history.getInstance();
        if(historyWindow !=null){
            if (historyWindow.isVisible()) {
                Object[] rowData = {currentInput + "=" + displayResult};
                tableModel.addRow(rowData);
            }            
        }
        displayArea.setText(displayResult);
    }
    //Multiplication Method
    private void multiply() {
        String newSign = currentInput.replace("−", "-");
        parts = newSign.split("x");
        
        double firstNum = 0.0;
        double secondNum = 0.0;
        double lowerNumber1 = 0.0;
        double lowerNumber2 = 0.0;
        double result = 0.0;
        double newNumber;
        //----------------If there is percentage------------------
        if (parts[0].contains("%") || parts[1].contains("%")) {

            if (parts[0].contains("%") && parts[1].contains("%")) {

                String newFirstNum = parts[0].replace("%", "");
                firstNum = Double.parseDouble(newFirstNum) / 100.0;

                String newSecondNum = parts[1].replace("%", "");
                secondNum = Double.parseDouble(newSecondNum) / 100.0;


            } else if (parts[0].contains("%")) {

                String newFirstNum = parts[0].replace("%", "");
                firstNum = Double.parseDouble(newFirstNum) / 100.0;

            } else if (parts[1].contains("%")) {
                String newsecondNum = parts[1].replace("%", "");
                secondNum = Double.parseDouble(newsecondNum) / 100.0;

            }

        }
        //----------------If there is square------------------  
        if (parts[0].contains("^2") || parts[1].contains("^2")) {
            if (parts[0].contains("^2") && parts[1].contains("^2")) {
                exponentCount = parts[0].split("\\^");
                String number1 = exponentCount[0];
                double newNumber1 = Double.parseDouble(number1);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber1, 2);
                    newNumber1 = result;
                }
                firstNum = newNumber1;

                exponentCount = parts[1].split("\\^");
                String number2 = exponentCount[0];
                double newNumber2 = Double.parseDouble(number2);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber2, 2);
                    newNumber2 = result;
                }
                secondNum = newNumber2;

            } else if (parts[0].contains("^2")) {
                exponentCount = parts[0].split("\\^");
                String number = exponentCount[0];
                newNumber = Double.parseDouble(number);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber, 2);
                    newNumber = result;
                }
                firstNum = newNumber;

            } else if (parts[1].contains("^2")) {
                exponentCount = parts[1].split("\\^");
                String number = exponentCount[0];
                newNumber = Double.parseDouble(number);

                for (int x = 0; x < (exponentCount.length - 1); x++) {
                    result = Math.pow(-newNumber, 2);
                    newNumber = result;
                }
                secondNum = newNumber;
            }

        }
        //----------------If there is square root------------------  
        if (parts[0].contains("\u221A") || parts[1].contains("\u221A")) {
            if (parts[0].contains("\u221A") && parts[1].contains("\u221A")) {
                rootCount = parts[0].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    firstNum = Double.parseDouble(negativeConversion);
                } else {
                    firstNum = newNumber;
                }
                rootCount = parts[1].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    secondNum = Double.parseDouble(negativeConversion);
                } else {
                    secondNum = newNumber;
                }

            } else if (parts[0].contains("\u221A")) {
                rootCount = parts[0].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    firstNum = Double.parseDouble(negativeConversion);
                } else {
                    firstNum = newNumber;
                }

            } else if (parts[1].contains("\u221A")) {
                rootCount = parts[1].split("\u221A");
                newNumber = Double.parseDouble(rootCount[rootCount.length - 1]);

                for (int x = 0; x < (rootCount.length - 1); x++) {
                    result = Math.sqrt(newNumber);
                    newNumber = result;
                }
                if (rootCount[0].contains("-")) {
                    negativeConversion = "-" + newNumber;
                    secondNum = Double.parseDouble(negativeConversion);
                } else {
                    secondNum = newNumber;
                }
            }
        }
        //----------------If there is reciprocal------------------  
        if (parts[0].contains("1/") || parts[1].contains("1/")) {
            if (parts[0].contains("1/") && parts[1].contains("1/")) {
                reciprocalCount = parts[0].split("/");
                lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")) {
                    lowerNumber1 = Double.parseDouble("-" + lowerNumber1);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber1;
                    lowerNumber1 = result;

                }
                firstNum = lowerNumber1;

                reciprocalCount = parts[1].split("/");
                lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")) {
                    lowerNumber2 = Double.parseDouble("-" + lowerNumber2);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber2;
                    lowerNumber2 = result;

                }
                secondNum = lowerNumber2;

            } else if (parts[0].contains("1/")) {

                reciprocalCount = parts[0].split("/");
                lowerNumber1 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[0].contains("-")) {
                    lowerNumber1 = Double.parseDouble("-" + lowerNumber1);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber1;
                    lowerNumber1 = result;

                }
                firstNum = lowerNumber1;

            } else if (parts[1].contains("1/")) {
                reciprocalCount = parts[1].split("/");
                lowerNumber2 = Double.parseDouble(reciprocalCount[reciprocalCount.length - 1]);
                if (!String.valueOf(reciprocalCount[reciprocalCount.length - 1]).contains("-") && parts[1].contains("-")) {
                    lowerNumber2 = Double.parseDouble("-" + lowerNumber2);
                }
                for (int x = 0; x < (reciprocalCount.length - 1); x++) {
                    result = 1 / lowerNumber2;
                    lowerNumber2 = result;

                }
                secondNum = lowerNumber2;
            }
        }

        if (firstNum == 0.0 || secondNum == 0.0) {
            if (firstNum == 0.0 && secondNum == 0.0) {
                firstNum = Double.parseDouble((parts[0]));
                secondNum = Double.parseDouble(parts[1].trim());
            } else if (firstNum == 0.0) {
                firstNum = Double.parseDouble((parts[0]));
            } else if (secondNum == 0.0) {
                secondNum = Double.parseDouble(parts[1].trim());
            }
        }
        displayResult = String.valueOf(firstNum * secondNum);
                    if (displayResult.contains("-")){ 
                        displayResult = displayResult.replace("-", "−");
                    }

        historyData.add(currentInput + "=" + displayResult);
        history historyWindow = history.getInstance();
        if(historyWindow != null){
            if (historyWindow.isVisible()) {
                Object[] rowData = {currentInput + "=" + displayResult};
                tableModel.addRow(rowData);
            }
        }
        displayArea.setText(displayResult);   
    }    
    
    
    //Square Method
    private void squareNumber(){
        String newSign = currentInput.replace("−", "-");
        parts = newSign.split("\\^");
        double number = Double.parseDouble(parts[0].trim());
         result = 0.0;
        
        for (int x = 0; x < (parts.length-1); x++){
                result = Math.pow(-number, 2);
                number = result;
        }
        displayResult = String.valueOf(number);
        if (displayResult.contains("-")) {
            displayResult = displayResult.replace("-", "−");
        }
            historyData.add(currentInput + "=" + displayResult);
            history historyWindow = history.getInstance();
            if(historyWindow != null){
                if (historyWindow.isVisible()) {
                    Object[] rowData = {currentInput + "=" + displayResult};
                    tableModel.addRow(rowData);
                }
            }
            displayArea.setText(String.valueOf(number));
       
    }    
    //Reciprocal Method
    private void reciprocal() {
        String newSign = currentInput.replace("−", "-");
        parts = newSign.split("/");
        
        double lowerNumber = Double.parseDouble(parts[parts.length- 1]);
        double result;
        
        for (int x = 0; x < (parts.length - 1); x++) {
            result = 1 / lowerNumber;
            lowerNumber = result;
        }

        if (currentInput.contains("−")) {
            if (String.valueOf(currentInput.charAt(0)).contains("−")){
            negativeConversion = "−" + lowerNumber;
            }
            else{
                negativeConversion = String.valueOf(lowerNumber).replace("-","−");
            }
            historyData.add(currentInput + "=" + negativeConversion);
            history historyWindow = history.getInstance();
            if(historyWindow != null){
                if (historyWindow.isVisible()) {
                    Object[] rowData = {currentInput + "=" + negativeConversion};
                    tableModel.addRow(rowData);
                }
            }
            displayArea.setText(String.valueOf(negativeConversion));
            
        } else {
            historyData.add(currentInput + "=" + lowerNumber);
            history historyWindow = history.getInstance();
            if(historyWindow != null){
                if (historyWindow.isVisible()) {
                    Object[] rowData = {currentInput + "=" + lowerNumber};
                    tableModel.addRow(rowData);
                }
            }
            displayArea.setText(String.valueOf(lowerNumber));
        }
        
    }    
    
    //Square Root Method
    private void squareRootM() {
        if (!currentInput.contains("−")){
        parts = currentInput.split("\u221A");
        double number = Double.parseDouble(parts[parts.length-1]);
        result = 0.0;
        
        for (int x = 0; x < (parts.length - 1); x++) {
            result = Math.sqrt(number);
            number = result;
        }        

            historyData.add(currentInput + "=" + number);
            history historyWindow = history.getInstance();
            if(historyWindow != null){
                if (historyWindow.isVisible()) {
                    Object[] rowData = {currentInput + "=" + number};
                    tableModel.addRow(rowData);
                }
            }
            displayArea.setText(String.valueOf(number));
        } 
        else {
            
            parts = currentInput.split("\u221A");
            if(parts[parts.length-1].contains("−")){
                parts[parts.length-1] = parts[parts.length-1].replace("−", "-");
            }
            double number = Double.parseDouble(parts[parts.length-1]);
            result = 0.0;

            for (int x = 0; x < (parts.length - 1); x++) {
                result = Math.sqrt(number);
                number = result;
            }
            
            if (String.valueOf(currentInput.charAt(0)).contains("−")){
                negativeConversion = "−" + number;
                historyData.add(currentInput + "=" + negativeConversion);
                history historyWindow = history.getInstance();
                if(historyWindow != null){
                    if (historyWindow.isVisible()) {
                        Object[] rowData = {currentInput + "=" + negativeConversion};
                        tableModel.addRow(rowData);
                    }
                }
                displayArea.setText(String.valueOf(negativeConversion));
            }
            else{
                historyData.add(currentInput + "=" + number);
                history historyWindow = history.getInstance();
                if(historyWindow != null){
                    if (historyWindow.isVisible()) {
                        Object[] rowData = {currentInput + "=" + number};
                        tableModel.addRow(rowData);
                    }
                }
                displayArea.setText(String.valueOf(number));
            }
        } 
    }   
    //Percent Method
    private void percentage(){
        String newSign = currentInput.replace("−", "-");
        parts = newSign.split("%");
        double number = Double.parseDouble(parts[1].trim());
        result = (-number) / 100.0;

        for (int x = 0; x < (parts.length - 1); x++) {
            result = number / 100;
            number = result;
        }
        if (String.valueOf(currentInput.charAt(0)).contains("−")) {
            negativeConversion = "−" + number;
            historyData.add(currentInput + "=" + negativeConversion);
            history historyWindow = history.getInstance();
            if(historyWindow != null){
                if (historyWindow.isVisible()) {
                    Object[] rowData = {currentInput + "=" + negativeConversion};
                    tableModel.addRow(rowData);
                }
            }
            displayArea.setText(String.valueOf(negativeConversion));
        } else {
            displayResult = String.valueOf(number);
        if (displayResult.contains("-")) {
            displayResult = displayResult.replace("-", "−");
        }
            historyData.add(currentInput + "=" + displayResult);
            history historyWindow = history.getInstance();
            if(historyWindow != null){
                if (historyWindow.isVisible()) {
                    Object[] rowData = {currentInput + "=" + displayResult};
                    tableModel.addRow(rowData);
                }
            }
            displayArea.setText(String.valueOf(displayResult));
        }

    }   

//--------------------------------------------------Calculations Method---------------------------------------------------        
private void calculations(){
    if (currentInput.contains("+")) {
        add();
    } else if (currentInput.contains("-")) {
        minus();
    } else if (currentInput.contains("x")) {
        multiply();
    } else if (currentInput.contains("÷")) {
        divide();
    } else if (currentInput.contains("^2")) {
        squareNumber();
    } else if (currentInput.contains("1/")) {
        reciprocal();
    } else if (currentInput.contains("\u221A")) {
        squareRootM();
    } else if (currentInput.contains("%")) {
        percentage();
    }
    currentOperator = null;
}


    public static void main(String args[]) {
        CalculatorGUI calculator = new CalculatorGUI();

    }
}
//negative
// −