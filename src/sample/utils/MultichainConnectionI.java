package sample.utils;

import java.util.Map;

public interface MultichainConnectionI {

    void vote(Integer candidateId);

    Map<Integer, Integer> getResults();

}
