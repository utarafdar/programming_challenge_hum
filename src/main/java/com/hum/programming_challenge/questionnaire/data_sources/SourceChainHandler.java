package com.hum.programming_challenge.questionnaire.data_sources;

import com.hum.programming_challenge.questionnaire.model.Questionnaire;

import java.util.List;

public class SourceChainHandler {
    public List<Questionnaire> populateQuestionnaires() {
        QuestionnaireSource chain = new SourceFromCsvFile();
        chain.addNextInChain(new DefaultNoSourceFound());
        /*

        Using Chain of Responsibility design pattern.

        Extendable to use more data sources, for example if csn file is not present,
        read from database or extend chain for even more data sources.

        Each object in chain attempts to handle data retrieval based on request,
        and if it can't pass along to next item in chain.

        Can add more methods to get data without the calling method (`StoreManager`, here)
        knowing how it is getting data.

        All chain objects must follow interface `ProductSource` to ensure methods and data format.
        The internal logic can widely vary.

        */
        return chain.handleSourcing();

}


}
