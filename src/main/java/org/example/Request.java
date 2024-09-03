package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Request {
    private final String actionCode;
    private final Map<String, String> params = new HashMap<>();

    public Request(String command) {
        String[] commandList = command.split("\\?", 2);

        actionCode = commandList[0];

        if (commandList.length == 1) return;

        String[] paramsList = commandList[1].split("&");

        ArrayList<String> paramsId = new ArrayList<>();

        for (String paramsRow : paramsList) {
            String[] paramsStr = paramsRow.split("=", 2);
            String key = paramsStr[0];
            if (paramsStr[1].startsWith("%&")) {
                paramsId.add(paramsStr[Integer.parseInt(paramsRow) - 1]);
                params.put(key, Arrays.toString(paramsId.toArray()));
            } else {
                String value = paramsStr[1];
                params.put(key, value);
            }
        }
    }


    public String getActionCode() {
        return actionCode;
    }

    public String getParams(String key) {
        return params.get(key);
    }
}