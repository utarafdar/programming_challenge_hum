package com.hum.programming_challenge.questionnaire.service;

import com.hum.programming_challenge.questionnaire.model.Question;
import com.hum.programming_challenge.questionnaire.model.Questionnaire;
import com.hum.programming_challenge.questionnaire.model.QuestionnaireResponse;

public interface QuestionnaireResponseService {
    QuestionnaireResponse initialize(QuestionnaireResponse questionnaireResponse, Questionnaire questionnaire);
    QuestionnaireResponse updateAnswer(QuestionnaireResponse questionnaireResponse, Question question, String option);
    int evaluateResponse(QuestionnaireResponse questionnaireResponse);
}
