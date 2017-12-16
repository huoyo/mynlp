package com.mayabot.nlp.segment.analyzer;

import com.mayabot.nlp.segment.MyTerm;
import com.mayabot.nlp.segment.MyAnalyzer;
import com.mayabot.nlp.utils.Characters;

/**
 * 过滤标点符号
 */
public class MyAnalyzerFilterPunctuation extends WrapMyAnalyzerFilter {

    @Override
    boolean accept(MyTerm term) {
        return !Characters.isPunctuation(term.word.charAt(0));
    }

    public MyAnalyzerFilterPunctuation(MyAnalyzer myAnalyzer) {
        super(myAnalyzer);
    }
}
