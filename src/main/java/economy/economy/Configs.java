package economy.economy;

import java.util.HashMap;

public class Configs {
    public static String getMessage(String path, HashMap<String, String> replacements) {
        String message = Economy.instance.getMessagesConfig().getString(path);

        if(message == null || message.isEmpty()) {
            message = "§4Message not found (§ceconomy." + path + "§4)";
        }

        for (String s : replacements.keySet()) {
            message.replace(s, replacements.get(s));
        }

        return message;
    }
}