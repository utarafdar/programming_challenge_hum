package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Question;
import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.*;

/*
This class sets default questions when questions from csv or database are not found
This makes the application flexible to get data from other sources, chain of responsibility model is used
 */

public class DefaultNoSourceChainFound implements QuestionnaireSourceChain {

    @Override
    public void addNextInChain(QuestionnaireSourceChain nextChain) {
    }

    // return empty list when no source found
    @Override
    public List<Questionnaire> handleSourcing() {
        List<Questionnaire> questionnaires= new ArrayList<>();

        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setQuestionnaireDescription("Java programming role questionnaire");

        // setting some default questions
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

        // add these default questions to questionnaire
        questionnaire.setQuestions(new ArrayList<>(){
            {
                add(question1);
                add(question2);
                add(question3);
            }
        });

        /* set evaluation values
         using tree map to store the range of evaluation values because the keys are ordered, hence It will be easier
         to reverse sort and check if the result lies in the range*/

        questionnaire.setEvaluation(new TreeMap<>(){
            {
                put(0, "Unfortunately, we don’t match!");
                put(6, "That looks good!");
                put(10, "Excellent!");
            }
        });

        questionnaires.add(questionnaire);

        return questionnaires;
    }
}
