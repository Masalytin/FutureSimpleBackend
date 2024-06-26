package ua.dmjdev.dto;

import java.util.ArrayList;
import java.util.List;

public enum EnglishLevel {
    BEGINNER(List.of(
            Rule.PRONOUNS,
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
            Rule.MODAL_VERBS_SHOULD,
            Rule.MODAL_VERBS_MAY_MIGHT,
            Rule.MODAL_VERBS_CAN_COULD,
            Rule.ADVERBS
    )),
    INTERMEDIATE(List.of(
            Rule.CONDITIONALS,
            Rule.USED_TO,
            Rule.QUESTION_TAGS,
            Rule.PAST_PERFECT,
            Rule.AGREEMENT_OF_TENSES,
            Rule.PRESENT_PERFECT_CONTINUOUS,
            Rule.PASSIVE_VOICE
    )),
    ADVANCED(List.of(
            Rule.PUNCTUATION,
            Rule.FUTURE_PERFECT_CONTINUOUS,
            Rule.FUTURE_IN_THE_PAST
    ));


    private final List<Rule> rulesList;

    EnglishLevel(List<Rule> rulesList) {
        this.rulesList = rulesList;
    }

    public List<Rule> getRules() {
        return this.rulesList;
    }

    public List<Rule> getCurrentAndLessLevelsRules() {
        List<Rule> result = new ArrayList<>();
        for (EnglishLevel englishLevel : EnglishLevel.values()) {
            if (englishLevel.ordinal() <= this.ordinal()) {
                result.addAll(englishLevel.getRules());
            }
        }
        return result;
    }
}