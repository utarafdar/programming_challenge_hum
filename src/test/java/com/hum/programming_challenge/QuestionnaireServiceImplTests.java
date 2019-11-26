package com.hum.programming_challenge;

import com.hum.programming_challenge.questionnaire.model.Question;
import com.hum.programming_challenge.questionnaire.model.Questionnaire;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;
import com.hum.programming_challenge.questionnaire.service.QuestionnaireResponseServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class QuestionnaireServiceImplTests {

    @Autowired
    QuestionnaireResponseServiceImpl questionnaireResponseServiceImpl;

    @Autowired
    QuestionnaireResponse questionnaireResponse;

    @Autowired
    Questionnaire questionnaire;

    @Test
    void findQuestionnaireTestReturnValue(){
        assertNotNull(questionnaireResponseServiceImpl.findQuestionnaire(getQuestionnaireMockList(),
                "Java programming role questionnaire"));
    }

    @Test
    void findQuestionnaireTestReturnNull(){
        assertNull(questionnaireResponseServiceImpl.findQuestionnaire(getQuestionnaireMockList(),
                "Python programming role questionnaire"));
    }


    @Test
    void initializeQuestionnaireResponseAllQuestionAddedTest(){
        questionnaireResponse = questionnaireResponseServiceImpl.initialize(questionnaireResponse, getQuestionnaireMockObject());
        // for each question from questionnaire, check if response contains the question description
        //questionnaireResponse.getResponse().remove("Do you enjoy working in a team?");
        questionnaire.getQuestions().forEach(question ->
            assertTrue(questionnaireResponse.getResponse()
                    .containsKey(question.getQuestionDescription())));
        }

    @Test
    void updateAnswerTest(){

        questionnaireResponse = questionnaireResponseServiceImpl.updateAnswer(getMockResponseObject(getQuestionnaireMockObject()),
                "Do you enjoy working in a team?","Yes, I do");
        assertEquals(questionnaireResponse.getResponse().get("Do you enjoy working in a team?"), "Yes, I do");

    }

    @Test
    void evaluateResponseTest(){
        assertEquals(questionnaireResponseServiceImpl.evaluateResponse(getMockResponseObject(getQuestionnaireMockObject())), 8);
    }

    @Test
    void evaluationFeedbackTest(){
        assertEquals(questionnaireResponseServiceImpl.evaluationFeedback(getMockResponseObject(getQuestionnaireMockObject()),
                11),"Excellent!");
    }

    @Test
    void evaluationFeedbackTestResultZero(){
        assertEquals(questionnaireResponseServiceImpl.evaluationFeedback(getMockResponseObject(getQuestionnaireMockObject()),
                0),"Unfortunately, we don’t match!");
    }


    @Test
    void initializeQuestionnaireResponseAllAnswersSetToDefaultTest(){
        // for every question test if the response = "not answered"
        questionnaireResponse = questionnaireResponseServiceImpl.initialize(questionnaireResponse, getQuestionnaireMockObject());
        //questionnaireResponse.getResponse().put("Do you enjoy working in a team?","not really");
        questionnaireResponse.getResponse().forEach((question, response) -> assertEquals("not answered", response));
    }



    /*
    Creating a mock questionnaire list here. Instead of getting the questionnaire from source handler chain.
    Because here we dont want to test the working of source handler chain. Its done in a separate test class.
     */
    private List<Questionnaire> getQuestionnaireMockList(){

        List<Questionnaire> questionnaires= new ArrayList<>();

        questionnaires.add(getQuestionnaireMockObject());

        return questionnaires;
    }

    // mocking a single questionnaire object
    private Questionnaire getQuestionnaireMockObject(){

        questionnaire.setQuestionnaireDescription("Java programming role questionnaire");

        Question question1 = new Question();
        Question question2 = new Question();
        Question question3 = new Question();

        question1.setQuestionDescription("Do you enjoy working in a team?");
        question1.setOptionPointsMap(new HashMap<>() {
            {
                put("Teamwork is in my blood", 5);
                put("Yes, I do", 3);
                put("I prefer to work alone", 0);
            }
        });
        question2.setQuestionDescription("How long have you been working with Java?");
        question2.setOptionPointsMap(new HashMap<>() {
            {
                put("Never", 0);
                put("Less than 1 year", 1);
                put("Less than 2 years", 3);
                put("More than 3 years", 5);
            }
        });
        question3.setQuestionDescription("How do you feel about automated tests?");
        question3.setOptionPointsMap(new HashMap<>() {
            {
                put("Mandatory", 3);
                put("Waste of time", 0);
            }
        });

        questionnaire.setQuestions(new ArrayList<>(){
            {
                add(question1);
                add(question2);
                add(question3);
            }
        });

        questionnaire.setEvaluationFeedbackMap(new TreeMap<>((Collections.reverseOrder())){
            {
                put(0, "Unfortunately, we don’t match!");
                put(6, "That looks good!");
                put(10, "Excellent!");
            }
        });
        return questionnaire;
    }

    private QuestionnaireResponse getMockResponseObject(Questionnaire questionnaire){
        questionnaireResponse.setQuestionnaire(questionnaire);

        questionnaireResponse.setResponse(new HashMap<>() {
            {
                put("Do you enjoy working in a team?","not answered");
                put("How long have you been working with Java?","More than 3 years");
                put("How do you feel about automated tests?","Mandatory");
            }
        });

        return  questionnaireResponse;
    }

}
