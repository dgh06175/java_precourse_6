package christmas.domain;

import christmas.exception.DateException;
import christmas.exception.MenuException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputParser {
    private static final String DIVIDER = ",";
    private static final String MENU_COUNT_DIVIDER = "-";
    private static final String MENU_REGEX = String.format("[가-힣a-zA-Z]+%s\\d+", MENU_COUNT_DIVIDER);
    private static final String INPUT_MENU_REGEX = String.format("(%s)+(%s ?%s)*", MENU_REGEX, DIVIDER, MENU_REGEX);
    public int parseDate(String inputDate) {
        validateInputDate(inputDate);
        return Integer.parseInt(inputDate);
    }

    public Map<String, Integer> parseOrder(String inputOrder) {
        validateInputMenu(inputOrder);
        return Arrays.stream(inputOrder.split(DIVIDER))
                .map(item -> item.split(MENU_COUNT_DIVIDER))
                .collect(Collectors.toMap(
                        splitItem -> splitItem[0],
                        splitItem -> Integer.parseInt(splitItem[1]),
                        (existing, replacement) -> existing
                ));
    }

    private void validateInputDate(String inputDate) {
        if (Integer.parseInt(inputDate) <= 0) {
            throw new DateException();
        }
    }

    private void validateInputMenu(String inputOrder) {
        if(!Pattern.matches(INPUT_MENU_REGEX, inputOrder)) {
            throw new MenuException();
        }
    }
}
