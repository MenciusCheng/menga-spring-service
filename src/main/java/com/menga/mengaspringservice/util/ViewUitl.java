package com.menga.mengaspringservice.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marvel on 2019/6/26.
 */
public class ViewUitl {

    public static String lineToBr(String text) {
        String[] lines = text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            sb.append(lines[i]);
            if (i != lines.length - 1) {
                sb.append("<br />").append("\n");
            }
        }

        return sb.toString();
    }
}
