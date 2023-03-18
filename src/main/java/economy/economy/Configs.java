package economy.economy;

import java.util.HashMap;

public class Configs {
    public static String getMessage(String string, HashMap<String, String> replacements) {
        String message = Economy.instance.getMessagesConfig().getString(string);

        if(message == null || message.isEmpty()) {
            message = "";
        }

        for (String s : replacements.keySet()) {
            message.replace(s, replacements.get(s));
        }

        return message;
    }
}
