package com.hum.programming_challenge.questionnaire.service;

import com.hum.programming_challenge.questionnaire.model.Question;
import com.hum.programming_challenge.questionnaire.model.Questionnaire;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

@Component
public class QuestionnaireResponseServiceImpl implements QuestionnaireResponseService {

    /*finding the questionnaire from the list for which the user wants to respond
     if there was a database implementation, the questionnaire could be directly retrieved from the DB
    */
    @Override
    public Questionnaire findQuestionnaire(List<Questionnaire> questionnaires, String description){
        return questionnaires.stream()
                .filter(questionnaire -> questionnaire.getQuestionnaireDescription().equals(description))
                .findAny()
                .orElse(null);
    }

    @Override
    public QuestionnaireResponse initialize(QuestionnaireResponse questionnaireResponse, Questionnaire questionnaire) {

        /*
        Populate the questions. Initialise all the answers too the questions as "not answered".
        Whenever the user answers a question, the answer can be updated with user answer.
         */

        questionnaireResponse.setQuestionnaire(questionnaire);

        questionnaireResponse.setResponse(new HashMap<>() {
            {
                questionnaire.getQuestions().forEach(question -> put(question.getQuestionDescription(),"not answered"));
            }
        });

        return questionnaireResponse;
    }

    @Override
    public QuestionnaireResponse updateAnswer(QuestionnaireResponse questionnaireResponse, String question, String option) {
        questionnaireResponse.getResponse().put(question, option);
        return questionnaireResponse;
    }

    // when only result is needed
    @Override
    public int evaluateResponse(QuestionnaireResponse questionnaireResponse) {
        int result =0;
        Questionnaire questionnaire = questionnaireResponse.getQuestionnaire();

        // for each responded question, find the question from questionnaire, where eventually points can be found
        for (Map.Entry<String, String> entry : questionnaireResponse.getResponse().entrySet()) {

            // get the question object reference from questionnaire
             Question questionResponded=questionnaire.getQuestions().stream()
                    .filter(question -> question.getQuestionDescription().equals(entry.getKey()))
                    .findAny()
                    .orElse(null);

             // calculate point only if question answered is valid
            if (questionResponded != null){
                // check if the answer exists in the options, otherwise do not add points (to handle unanswered questions)
                if (questionResponded.getOptionPointsMap().containsKey(entry.getValue()))
                result = result + questionResponded.getOptionPointsMap().get(entry.getValue());
            }

        }

        return result;
    }

    // when feedback is needed
    @Override
    public String evaluationFeedback(QuestionnaireResponse questionnaireResponse) {
        int result = evaluateResponse(questionnaireResponse);
        // find the feedback based on the result from the questionnaire evaluationFeedbackMap
        return  evaluationFeedback(questionnaireResponse, result);
    }

    /*
    TreeMap is used to store evaluation feedback. The tree map is sorted in reverse order (based on points).
    when points greater than the lower limit of the range, the value of that point is returned.
    TreeMap is used to handle the feedback based on the range of points scored, since TreeMap can be sorted based on keys.
     */

    @Override
    public String evaluationFeedback(QuestionnaireResponse questionnaireResponse, int result) {
        for (Map.Entry<Integer, String> entry : questionnaireResponse.getQuestionnaire().
                getEvaluationFeedbackMap().entrySet()) {
            if (result > entry.getKey())
                return entry.getValue();
        }

        // return feedback of least score if score lesser than last entry
        TreeMap<Integer, String> lastScore = (TreeMap<Integer, String>) questionnaireResponse.getQuestionnaire().getEvaluationFeedbackMap();
        return lastScore.lastEntry().getValue();
    }
}
