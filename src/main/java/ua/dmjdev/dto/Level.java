package ua.dmjdev.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public enum Level {
    BEGINNER(List.of(
            Rule.TO_BE,
            Rule.ARTICLES,
            Rule.WORD_ORDER,
            Rule.PRESENT_SIMPLE,
            Rule.PREPOSITIONS,
            Rule.PRESENT_CONTINUOUS,
            Rule.THERE_IS_THERE_ARE,
            Rule.PAST_SIMPLE,
            Rule.IRREGULAR_VERBS,
            Rule.PAST_CONTINUOUS,
            Rule.SOME_ANY_NO,
            Rule.DEGREE_OF_COMPARISON,
            Rule.FUTURE_SIMPLE,
            Rule.TO_BE_GOING_TO,
            Rule.PRESENT_PERFECT,
            Rule.INFINITIVE,
            Rule.GERUND,
            Rule.MODAL_VERBS_MUST,
            Rule.MODAL_VERBS_HAVE_TO,
            Rule.RELATIVE_CLAUSES,
            Rule.MODAL_VERBS_SHOULD,
            Rule.MODAL_VERBS_MAY_MIGHT,
            Rule.MODAL_VERBS_CAN_COULD,
            Rule.ADVERBS
            )),
    INTERMEDIATE(List.of(
            Rule.CONDITIONALS,
            Rule.USED_TO,
            Rule.INDIRECT_SPEECH,
            Rule.QUESTION_TAGS,
            Rule.PAST_PERFECT,
            Rule.AGREEMENT_OF_TENSES,
            Rule.PRESENT_PERFECT_CONTINUOUS,
            Rule.PASSIVE_VOICE,
            Rule.IRREGULAR_PLURAL_FORMS
    )),
    ADVANCED(List.of(
            Rule.PUNCTUATION,
            Rule.FUTURE_PERFECT_CONTINUOUS,
            Rule.FUTURE_IN_THE_PAST
    ));


    private final Collection<Rule> rulesCollection;

    Level(Collection<Rule> rulesCollection) {
        this.rulesCollection = rulesCollection;
    }

    public Collection<Rule> getRules() {
        return this.rulesCollection;
    }

    public static Collection<Rule> getValuesByLevel(Level level) {
        return level.rulesCollection;
    }

}