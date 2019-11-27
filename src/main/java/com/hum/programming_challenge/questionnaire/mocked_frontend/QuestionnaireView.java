package com.hum.programming_challenge.questionnaire.mocked_frontend;

import com.hum.programming_challenge.questionnaire.mocked_questionnaire_controller.MockedQuestionnaireController;
import com.hum.programming_challenge.questionnaire.model.Question;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;

import java.util.Scanner;

/*
Since manipulating java object in the front end requires frameworks like thymeleaf, to save time and effort,
 I am displaying the questionnaire on console. The communication between the the view and the controller are done with
 method calls to the mocked controller (ideally these need to be done by httpResponse, the method calls mock the
 communication as a httpResponse)
 */


public class QuestionnaireView {

    private Scanner scanner;

    public void runViewManager(){

        /*
        First request - initialize questionnaire, this should be ideally a http request to the server.
        Here it is replaced by a normal method call.

        When initialize questionnaire is requested, the server responds with a QuestionnaireResponse object.
        here the method call returns QuestionnaireResponse object.
         */
        MockedQuestionnaireController mockedQuestionnaireController = new MockedQuestionnaireController();

        QuestionnaireResponse questionnaireResponse = mockedQuestionnaireController.getInitialQuestionnairePopulatedJava
                ("Java programming role questionnaire");
        /*
        Display individual questions, read answers and repeat until last question reached.
        Also provide option to move to previous question or next question
        */

        int currentQuestionNumber =0;
        String navigation ="";
        int numberOfQuestions = questionnaireResponse.getQuestionnaire().getQuestions().size();

        while (currentQuestionNumber < numberOfQuestions){

            Question question = questionnaireResponse.getQuestionnaire().getQuestions().get(currentQuestionNumber);

            String optionChosen = displayQuestion(questionnaireResponse, question);

            mockedQuestionnaireController.updateResponse(question.getQuestionDescription(), optionChosen, questionnaireResponse);


            if (currentQuestionNumber == 0){
                //dont display previous option
                System.out.println(" Press N for next question");
                navigation = readInputNavigateQuestion();
            }

            else if (currentQuestionNumber==numberOfQuestions-1){
                System.out.println("Press Y to submit questionnaire, P for previous question");
                navigation = readInputNavigateQuestion();
            }

            else {

                System.out.println("Press N for next question, P for previous question");
                navigation = readInputNavigateQuestion();
            }

            if (navigation.equals("N") || navigation.equals("Y"))
                currentQuestionNumber++;


            if (navigation.equals("P")){
                if(currentQuestionNumber!=0)
                currentQuestionNumber--;
            }



           if (currentQuestionNumber==numberOfQuestions){

               displayResult(mockedQuestionnaireController.evaluateQuestionnaire(questionnaireResponse));
           }

        }



    }

    private String displayQuestion(QuestionnaireResponse questionnaireResponse, Question question){

        System.out.println("************* Select option from the list ************");
        System.out.println(question.getQuestionDescription() + "\n");

        question.getOptionPointsMap().forEach(((option, point) -> System.out.println(option)));

        return readInputNavigateQuestion();
    }

    private void displayResult(String result){

        System.out.println("\n" + result);

    }

    private String readInputNavigateQuestion() {

        if( scanner == null) {
            scanner = new Scanner(System.in);
        }

        String selection = "";

        try {
            selection = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Illegal input");
        }

        return selection;
    }

}
