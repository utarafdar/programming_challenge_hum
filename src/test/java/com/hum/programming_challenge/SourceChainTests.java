package com.hum.programming_challenge;

import com.hum.programming_challenge.questionnaire.data_sources.QuestionnaireSourceChainHandler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@SpringBootTest
class SourceChainTests {

    @Autowired
    QuestionnaireSourceChainHandler questionnaireSourceChainHandler;

    // checking if data source does not return empty list of questionnaires
    @Test
    void sourceChainReturnNotEmpty(){
        assertThat(questionnaireSourceChainHandler.populateQuestionnaires().isEmpty(), is(false));
    }
}
