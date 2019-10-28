package arithmeticcalculator;

/**
 * This class describes how calculator generates the random question, 
 * calculates the answer and checks if the answer on that question matches with 
 * the user's input.
 * 
 * @author Danijel Stefanovic 000789046
 */
public class MathConcept {

//Declare variables   

/** Variable that keeps loop running **/
private int a = 5;
/** Variables for storing user score **/
private int correct, incorrect;
/** Variable for storing program calculation **/
private double result;
/** Variable for storing random question **/
private String question ;

/**
 * Generates random question with one of 4 basic arithmetic operators 
 * @return The random question 
 */
public String generateQuestion() {
    
    //Random choice of 1st and 2nd number 
    int x = (int) (Math.random() * 100);
    int y = (int) (Math.random() * 100);
    
    //WHILE a not equals to 101 loop will run and generate question
    while(a!=101) {
       
        //Based on this random choice one of the options below will appear on canvas 
        a = (int)(Math.random() * 100);
        
        if(a==0) {
            
            //Contains program calculation
            result = x + y;
            
            //Contains question which will appear on canvas 
            question = (x + " + " + y + " = ");
            
            //Break statement
            a=101;
        }
        
        else if(a==1) {
        
            //Contains program calculation
            result=x-y;
            
            //Contains question which will appear on canvas 
            question = ( x + " - " + y + " = ");
            
            //Break statement 
            a=101;
        }
        
        else if(a==2) {
        
            //Contains program calculation
            result = x * y;
            
            //Contains question which will appear on canvas
            question = (x + " * " + y + " = ");
            
            //Contains question which will appear on canvas
            a=101;
        }
        
        else if(a==3) {
        
            //Contains program computation nad rounds result to be whole number 
            result = Math.floor(x / y);
           
            //Contains question which will appear on canvas
            question = (x + " / " + y + " = ");
           
            //Contains question which will appear on canvas
            a=101;
          
        }      
    }
    
    //Keeps loop running after first iteration
    a=5;
    
    return(question);

}

/**
 * Checks if the user input is matching with program calculation or not
 * @param calc User input 
 * @return Feedback whether is correct or not 
 */
public String checkAnswer(double calc) {
    
    //IF user input is equal to computer result 
    if(calc==result) {
        
        //Increment by 1
        correct +=1;
        
        String comment = "Congratulations, your answer is correct!";
        
        return comment;
    
    }
    //IF not 
    else {
        
        //Increment by 1
        incorrect +=1;
       
        String comment = "Sorry, wrong answer.Please try again!";
        
        return comment;
    
    }

}

/**
 * 
 * @return Number of user's correct answers
 */
public int getTrue() {
    
    return correct;
}

/**
 * 
 * @return Number of user's wrong answers  
 */
public int getWrong() {
    
    return incorrect;
}

/**
 * Resets number of user's input to 0 and generates different random question
 * @return Method for generating random question 
 */
public String resetCalculator() {    
    
    correct = 0;
    
    incorrect = 0;
    
    return(generateQuestion());
} 


}