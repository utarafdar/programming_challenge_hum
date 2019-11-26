package com.hum.programming_challenge.questionnaire.service;

import com.hum.programming_challenge.questionnaire.model.Question;
import com.hum.programming_challenge.questionnaire.model.Questionnaire;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class QuestionnaireResponseServiceImpl implements QuestionnaireResponseService {

    @Override
    public QuestionnaireResponse initialize(QuestionnaireResponse questionnaireResponse, Questionnaire questionnaire) {

        /*
        consider value
        initialise all the answers to not answered

         */

        questionnaireResponse.setQuestionnaire(questionnaire);

        questionnaireResponse.setResponse(new HashMap<>() {
            {
                questionnaire.getQuestions().forEach(question -> put(question,"not answered"));
            }
        });

        // for each question in the questionnaire set the answer to not answered
      //  questionnaire.getQuestions().forEach(question -> questionnaireResponse.getResponse().put(question,"not answered"));



        return questionnaireResponse;
    }

    @Override
    public QuestionnaireResponse updateAnswer(QuestionnaireResponse questionnaireResponse, Question question, String option) {
        questionnaireResponse.getResponse().put(question, option);
        return questionnaireResponse;
    }

    @Override
    public int evaluateResponse(QuestionnaireResponse questionnaireResponse) {
        int result =0;
        Questionnaire questionnaire = questionnaireResponse.getQuestionnaire();

        // get question from entry set
        // check condition for question not found or not anwered

      // questionnaireResponse.getResponse().forEach((key,value)-> key.getOptionPointsMap().get(value));


        for (Map.Entry<Question, String> entry : questionnaireResponse.getResponse().entrySet()) {
           result = result + entry.getKey().getOptionPointsMap().get(entry.getValue());
        }

        return result;
    }
}
