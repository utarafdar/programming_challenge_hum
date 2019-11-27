package com.hum.programming_challenge.questionnaire.mocked_questionnaire_controller;

import com.hum.programming_challenge.questionnaire.data_sources.QuestionnaireSourceChainHandler;
import com.hum.programming_challenge.questionnaire.model.Questionnaire;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;
import com.hum.programming_challenge.questionnaire.service.QuestionnaireResponseServiceImpl;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/*
Ideally this has to be a RestController. Since no HttpRequests are sent, view makes normal method calls to this controller
The controller makes update request and sends back the updated models to the view. this controller can be assumed as a rest controller.
 */


@Controller
public class MockedQuestionnaireController {

    private QuestionnaireResponseServiceImpl questionnaireResponseServiceImpl = new QuestionnaireResponseServiceImpl();

    // assuming "questionnaire type" is fetched from http response
    public QuestionnaireResponse getInitialQuestionnairePopulatedJava(String questionnaireType){

        /* get list of questionnaires
         find questionnaire "Java programming role questionnaire"*/

        Questionnaire questionnaire = questionnaireResponseServiceImpl.findQuestionnaire(new QuestionnaireSourceChainHandler().populateQuestionnaires(),
                questionnaireType);

        // set initial responses and send the response
        return questionnaireResponseServiceImpl.initialize(new QuestionnaireResponse(), questionnaire);

    }

    // assuming question and response are fetched from the http response
    public QuestionnaireResponse updateResponse(String question, String response, QuestionnaireResponse questionnaireResponse){
        return questionnaireResponseServiceImpl.updateAnswer(questionnaireResponse, question, response);

    }

    // getting final evaluation result on final submit of the questionnaire

    public String evaluateQuestionnaire(QuestionnaireResponse questionnaireResponse){
        return questionnaireResponseServiceImpl.evaluationFeedback(questionnaireResponse);
    }



}
