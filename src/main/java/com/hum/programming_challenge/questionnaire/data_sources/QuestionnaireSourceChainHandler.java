package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionnaireSourceChainHandler {
    public List<Questionnaire> populateQuestionnaires() {
        QuestionnaireSourceChain chain = new SourceChainFromDataBase();
        chain.addNextInChain(new SourceChainFromCsvFile());
        chain.addNextInChain(new DefaultNoSourceChainFound());
        /*

        Using Chain of Responsibility design pattern.

        Extendable to use more data sources, for example if csv file is not present,
        read from database or extend chain for even more data sources.

        Each object in chain attempts to handle data retrieval based on request,
        and if it can't pass along to next item in chain.

        All chain objects must follow interface `ProductSource` to ensure methods and data format.
        The internal logic can widely vary.

        */
        return chain.handleSourcing();

}


}
