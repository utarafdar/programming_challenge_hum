package com.hum.programming_challenge;

import com.hum.programming_challenge.questionnaire.data_sources.QuestionnaireSourceChainHandler;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;
import com.hum.programming_challenge.questionnaire.service.QuestionnaireResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgrammingChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProgrammingChallengeApplication.class, args);

        System.out.println((new QuestionnaireSourceChainHandler().populateQuestionnaires()).get(0).getQuestionnaireDescription());
        QuestionnaireResponseServiceImpl questionnaireResponseService = new QuestionnaireResponseServiceImpl();
        var questionnaire = new QuestionnaireSourceChainHandler().populateQuestionnaires().get(0);
        var questionnaireResponse = questionnaireResponseService.initialize(new QuestionnaireResponse(),
                questionnaire);
        questionnaireResponseService.updateAnswer(questionnaireResponse, questionnaire.getQuestions().get(0),"Teamwork is in my blood");
        questionnaireResponseService.updateAnswer(questionnaireResponse, questionnaire.getQuestions().get(1),"More than 3 years");
        questionnaireResponseService.updateAnswer(questionnaireResponse, questionnaire.getQuestions().get(2),"Mandatory");

        System.out.println(questionnaireResponseService.evaluateResponse(questionnaireResponse));


    }

}
