//Lab Activity 5
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.*;

public class LabActivity5QuizAppAWT {
    
    //Array of Questions
        public String[] questions = {
            "What does the acronym \"CPU\" stand for in computing?",
            "Which of the following is an example of an input device?",
            "Which of the following is an example of an output device?",
        };
        
       //Array of Choices 
        public String[][] choices = {
            {"A. Central Power Unit", "B. Computer Processing Utility", "C. Central Processing Unit", "D. Core Performance Upgrade"},
            {"A. Keyboard", "B. Printer", "C. Monitor", "D. Speaker"},
            {"A. Scanner", "B. Keyboard", "C. Mouse", "D. Printer"},            
        };
        
        //Array of Correct Answers
        public int[] correctAnswers = {2, 0, 3};
 
        public int i = 0;
        public int score = 0;
    
        public LabActivity5QuizAppAWT(){
            
            
            //Main Frame
            Frame mainFrame = new Frame();
            mainFrame.setTitle("Quiz App");
            mainFrame.setLayout(new GridBagLayout());          
            
            //Questions
            //Multiple constraints are created to avoid issues resetting properties
            GridBagConstraints questionConstraints = new GridBagConstraints();
            
            Label question = new Label(questions[0]);
            Font textFont = new Font ("Arial", Font.BOLD, 16);
            question.setFont(textFont);
            questionConstraints.anchor = GridBagConstraints.NORTH;
            questionConstraints.weightx = 0;
            questionConstraints.weighty = 1;
            questionConstraints.gridx = 0;
            questionConstraints.gridy = 0;
            questionConstraints.gridwidth = 2;
            mainFrame.add(question, questionConstraints);        
         
        //Choice 1    
            GridBagConstraints choice1Constraints = new GridBagConstraints();

            CheckboxGroup cbg = new CheckboxGroup();
            Checkbox choice1 = new Checkbox(choices[0][0], cbg, false);
            Color myColor = new Color(18,132,227);
            choice1.setForeground(myColor);
            choice1Constraints.anchor = GridBagConstraints.NORTHWEST;
            choice1Constraints.weightx = 1;
            choice1Constraints.weighty = 2;
            choice1Constraints.gridx = 0;
            choice1Constraints.gridy = 1;
            mainFrame.add(choice1, choice1Constraints);
        
            //Choice 2
            GridBagConstraints choice2Constraints = new GridBagConstraints();
            
            Checkbox choice2 = new Checkbox(choices[0][1], cbg, false);
            choice2.setForeground(myColor);
            choice2Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
            choice2Constraints.weightx = 0.5;
            choice2Constraints.weighty = 1;
            choice2Constraints.gridx = 1;
            choice2Constraints.gridy = 1;
            mainFrame.add(choice2, choice2Constraints);
         
            //Choice 3
            GridBagConstraints choice3Constraints = new GridBagConstraints();

            Checkbox choice3 = new Checkbox(choices[0][2], cbg, false);
            choice3.setForeground(myColor);
            choice3Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
            choice3Constraints.weightx = 0.5;
            choice3Constraints.weighty = 2;
            choice3Constraints.gridx = 0;
            choice3Constraints.gridy = 2;
            mainFrame.add(choice3, choice3Constraints);
            
            //Choice 4
            GridBagConstraints choice4Constraints = new GridBagConstraints();

            Checkbox choice4 = new Checkbox(choices[0][3], cbg, false);
            choice4.setForeground(myColor);
            choice4Constraints.anchor = GridBagConstraints.FIRST_LINE_START;
            choice4Constraints.weightx = 0.5;
            choice4Constraints.weighty = 1;
            choice4Constraints.gridx = 1;
            choice4Constraints.gridy = 2;
            mainFrame.add(choice4, choice4Constraints);      
            
            
            
            //Next Button
            GridBagConstraints buttonConstraints = new GridBagConstraints();

            Button nextButton = new Button("Next");
            Font buttonFont = new Font (null,Font.BOLD,12);
            nextButton.setFont(buttonFont);
            buttonConstraints.fill = GridBagConstraints.BOTH;
            buttonConstraints.anchor = GridBagConstraints.NORTH;
            buttonConstraints.weightx = 0;
            buttonConstraints.weighty = 1;
            buttonConstraints.gridx = 0;
            buttonConstraints.gridy = 4;
            buttonConstraints.gridwidth = 2;
            mainFrame.add(nextButton, buttonConstraints);
            
            GridBagConstraints captionConstraints = new GridBagConstraints();
            
            //Bottom Caption 
            Label caption = new Label("Please select an answer.");
            
            captionConstraints.anchor = GridBagConstraints.NORTH;
            captionConstraints.weightx = 0;
            captionConstraints.weighty = 1;
            captionConstraints.gridx = 0;
            captionConstraints.gridy = 3;
            captionConstraints.gridwidth = 2;
            
           //Button Action
            nextButton.addActionListener(new ActionListener(){
                @Override
                
                 public void actionPerformed(ActionEvent e){
                        int userAnswer = -1;
                        if (choice1.getState() == true){
                            userAnswer = 0;
                            if (userAnswer == correctAnswers[i]){
                                score++;
                            }
                            i++;
                        mainFrame.remove(caption);
                        mainFrame.revalidate();
                        mainFrame.repaint();
                        }
                        if (choice2.getState() == true){
                            userAnswer = 1;
                            if (userAnswer == correctAnswers[i]){
                                score++;
                            }
                            i++;
                        mainFrame.remove(caption);
                        mainFrame.revalidate();
                        mainFrame.repaint();
                        }
                        if (choice3.getState() == true){
                            userAnswer = 2;
                            if (userAnswer == correctAnswers[i]){
                                score++;
                            }
                            i++;
                        mainFrame.remove(caption);
                        mainFrame.revalidate();
                        mainFrame.repaint();
                        }
                        if (choice4.getState() == true) {
                            userAnswer = 3;
                            if (userAnswer == correctAnswers[i]){
                                score++;
                            }
                            i++;
                        mainFrame.remove(caption);
                        mainFrame.revalidate();
                        mainFrame.repaint();
                        }
                        if (userAnswer == -1){                           
                            //Error if no choice
                            
                            mainFrame.add(caption, captionConstraints);
                            mainFrame.revalidate();
                            mainFrame.repaint();
                        }
                        
                        //Questions and Choices Change Handling
                        if(i <3){
                            question.setText(questions[i]);
                            choice1.setLabel(choices[i][0]);
                            choice2.setLabel(choices[i][1]);
                            choice3.setLabel(choices[i][2]); 
                            choice4.setLabel(choices[i][3]);
                            cbg.setSelectedCheckbox(null);
                        }
                        mainFrame.revalidate();
                        mainFrame.repaint();
                        
                        //Question and Answer Disabling
                        if(i >=3){
                            nextButton.setEnabled(false);
                            choice1.setEnabled(false);
                            choice2.setEnabled(false);
                            choice3.setEnabled(false);
                            choice4.setEnabled(false);
                            
                        //Result    
                            question.setText("Quiz Completed! Your Score: " + score + " out of 3");
                            cbg.setSelectedCheckbox(null);
                            mainFrame.revalidate();
                            mainFrame.repaint();
                        }

                        }
                     
                });
                
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(500, 300);
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
            
    }

    public static void main(String[] args) {
        LabActivity5QuizAppAWT qa = new LabActivity5QuizAppAWT();
    }
    
    }
   
