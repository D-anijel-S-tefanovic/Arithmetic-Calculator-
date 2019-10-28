package arithmeticcalculator;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class represent view of the calculator and main role is to serve as a 
 * user interface. It holds 3 major components: labels,text-fields and buttons 
 * which are positioned on canvas.
 * 
 * @author Danijel Stefanovic 000789046
 */
public class MathCalculator extends Application {
    
    //Declare data types for GUI components and their references variables
    TextField userInput, countTrue, countWrong, outcome; 
    Label randomQuestion;
    
    //Variable that contains random question from MathConcept class
    String random="";
    
    //Declare data type and reference variable to access object 
    MathConcept math = new MathConcept();
    
    /**
     * Calls method from MatConcept class to generate question
     */
    public void outputQuestion() {
        
        random=math.generateQuestion();       
    
    }
    
    /**
     * Method activates whenever button for submission is pressed
     * @param e Represents an event (button click)
     */
    private void answerHandler(ActionEvent e) {
        
        //Convert user's input into a number 
        double newNum = Double.parseDouble(userInput.getText());
        
        //Round answer to be whole number 
        newNum = Math.floor(newNum);
        
        //Populate output label with message
        outcome.setText(math.checkAnswer(newNum));
        //Convert number into text
        countTrue.setText(Integer.toString(math.getTrue()));
        //Convert number into text
        countWrong.setText(Integer.toString(math.getWrong()));
    
    }
    
    /**
     * Method activates whenever button for reseting is pressed
     * @param e Represents an event (button click)
     */
    private void resetHandler(ActionEvent e){
        
        //Call method from MathConcept class
        math.resetCalculator();
        
        //Generate question
        math.generateQuestion();
        //Store it into label
        randomQuestion.setText(math.resetCalculator());
        
        //Reset to empty field in listed sections below 
        userInput.setText("");
        outcome.setText("");
        countTrue.setText("");
        countWrong.setText("");
       
    }
   
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 300); //Set the size here
        stage.setTitle("HELLO, good luck in calculating :)"); //Set the window title here
        stage.setScene(scene);
        
        //Set font type and size for components 
        Font fontOne = new Font("Arial",20);
        Font fontTwo = new Font("Arial",15);
      
        //Create the GUI components
        
        //Create and customize title
        Label titleForUser = new Label("Refresh your basic arithmetic skills!");
        titleForUser.setFont(fontOne);
        
        //Create and customize instruction
        Label instructionToUser = new Label("Please enter answer in empty field");
        instructionToUser.setFont(fontTwo);
        
        //Generate question
        outputQuestion();
        
        //Set the question and customize it
        randomQuestion = new Label(random);
        randomQuestion.setFont(fontTwo);
        
        //Set box for user input and customize it
        userInput = new TextField("");
        userInput.setPrefColumnCount(4);
        
        //Create and customize feedback
        Label outcomeTitle = new Label("Feedback:");
        outcomeTitle.setFont(fontTwo);
        
        //Set the field for feedback and customize it
        outcome = new TextField();
        outcome.setPrefColumnCount(20);
        
        //Create and customize title for the right section
        Label trueTitle = new Label ("Right:");
        trueTitle.setFont(fontTwo);
        
        //Set the field for the right section and customize it 
        countTrue = new TextField();
        countTrue.setPrefColumnCount(5);
        
        //Create and customize title for the wrong section
        Label wrongTitle = new Label("Wrong:");
        wrongTitle.setFont(fontTwo);
        
        //Set the field for the wrong section and customize it 
        countWrong = new TextField();
        countWrong.setPrefColumnCount(5);
        
        //Create submitt button
        Button submitAns = new Button("Submit Answer");
   
        //Create reset button 
        Button resetAns = new Button("Reset Answer");

        //Create warning how to proceed with number division 
        Label hint = new Label("HINT: For division purposes, please round your \n"
                + "answer to be a whole number!");

        //Add components to the root
        
        //Gather all components into one function
        
        root.getChildren().addAll(titleForUser, instructionToUser, userInput, 
                                  randomQuestion, outcomeTitle, outcome,   
                                  trueTitle, countTrue, wrongTitle, countWrong, 
                                  submitAns, resetAns, hint);
        
        //Configure the components position (X - width adn Y - height)
        
        titleForUser.setLayoutY(5);
        instructionToUser.setLayoutY(50);
        
        randomQuestion.setLayoutX(57);
        randomQuestion.setLayoutY(105);
        
        userInput.setLayoutX(120);
        userInput.setLayoutY(100);
        
        outcomeTitle.setLayoutY(253);
        outcome.setLayoutX(72);
        outcome.setLayoutY(250);
        
        trueTitle.setLayoutX(408);
        trueTitle.setLayoutY(102);
        countTrue.setLayoutX(450);
        countTrue.setLayoutY(100);
        
        wrongTitle.setLayoutX(400);
        wrongTitle.setLayoutY(152);
        countWrong.setLayoutX(450);
        countWrong.setLayoutY(150);
        
        submitAns.setLayoutX(80);
        submitAns.setLayoutY(150);
        
        resetAns.setLayoutX(84);
        resetAns.setLayoutY(200);
        
        hint.setLayoutX(348);
        hint.setLayoutY(250);

        //Add Event Handlers
        
        submitAns.setOnAction(this::answerHandler);
        
        resetAns.setOnAction(this::resetHandler);
        
        //Show the stage
        
        stage.show();
    
    }
    
    /**
     * A method to test the object 
     * @param args unused
     */
    public static void main(String[] args) {
       
       launch(args);
   
    }

}
    
    