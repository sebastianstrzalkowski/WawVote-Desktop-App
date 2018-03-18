package sample.utils;

import pl.waw.wawvote.utils.MultichainAPI;

import java.util.Map;
import java.util.stream.Collectors;

public class MultichainConnection implements MultichainConnectionI {
    MultichainAPI api = new MultichainAPI();
    private static String SERVER_IP = "192.168.137.127";
    private static String SERVER_PORT = "5747";
    private static String STREAM_NAME = "stream1";

    public MultichainConnection() {
        api.connectToExisitingNode(SERVER_IP, SERVER_PORT);
        api.subscribeList(STREAM_NAME);
    }

    @Override
    public void vote(Integer candidateId) {
        api.addToChain(STREAM_NAME, "key1", candidateId);
    }

    @Override
    public Map<Integer, Long> getResults() {
        Map<Integer, Long> counters = api.getAllDataFromChain("stream1").stream()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting()));

        return counters;
    }
}
