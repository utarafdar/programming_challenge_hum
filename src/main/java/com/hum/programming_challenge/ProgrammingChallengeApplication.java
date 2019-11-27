package com.hum.programming_challenge;

import com.hum.programming_challenge.questionnaire.data_sources.QuestionnaireSourceChainHandler;
import com.hum.programming_challenge.questionnaire.mocked_frontend.QuestionnaireView;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;
import com.hum.programming_challenge.questionnaire.service.QuestionnaireResponseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class ProgrammingChallengeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProgrammingChallengeApplication.class, args);

        //System.out.println((new QuestionnaireSourceChainHandler().populateQuestionnaires()).get(0).getQuestionnaireDescription());

        //QuestionnaireResponseServiceImpl questionnaireResponseService = new QuestionnaireResponseServiceImpl();
        QuestionnaireResponseServiceImpl questionnaireResponseService = context.getBean(QuestionnaireResponseServiceImpl.class);
                var questionnaire = new QuestionnaireSourceChainHandler().populateQuestionnaires().get(0);
        var questionnaireResponse = questionnaireResponseService.initialize(new QuestionnaireResponse(),
                questionnaire);
        //questionnaireResponseService.updateAnswer(questionnaireResponse, questionnaire.getQuestions().get(0).getQuestionDescription(),"Teamwork is in my blood");
        //questionnaireResponseService.updateAnswer(questionnaireResponse, questionnaire.getQuestions().get(1).getQuestionDescription(),"More than 3 years");
        //questionnaireResponseService.updateAnswer(questionnaireResponse, questionnaire.getQuestions().get(2).getQuestionDescription(),"Mandatory");

        //System.out.println(questionnaireResponseService.evaluateResponse(questionnaireResponse));
        //System.out.println(questionnaireResponseService.evaluationFeedback(questionnaireResponse));

        QuestionnaireView questionnaireView = new QuestionnaireView();
        questionnaireView.runViewManager();

    }

}
