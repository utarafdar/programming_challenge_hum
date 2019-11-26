package com.hum.programming_challenge.questionnaire.service;

import com.hum.programming_challenge.questionnaire.model.Question;
import com.hum.programming_challenge.questionnaire.model.Questionnaire;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;

import java.util.List;

public interface QuestionnaireResponseService {
    Questionnaire findQuestionnaire(List<Questionnaire> questionnaires, String description);
    QuestionnaireResponse initialize(QuestionnaireResponse questionnaireResponse, Questionnaire questionnaire);
    QuestionnaireResponse updateAnswer(QuestionnaireResponse questionnaireResponse, String question, String option);
    int evaluateResponse(QuestionnaireResponse questionnaireResponse);
    String evaluationFeedback(QuestionnaireResponse questionnaireResponse);
    String evaluationFeedback(QuestionnaireResponse questionnaireResponse, int result);
}
