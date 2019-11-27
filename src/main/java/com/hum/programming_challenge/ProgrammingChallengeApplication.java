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
        QuestionnaireView questionnaireView = new QuestionnaireView();
        questionnaireView.runViewManager();

    }

}
