package aed2.dominio.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Codigo {
    public static boolean validate (String valor) {
        Pattern pattern = Pattern.compile("^[aA-zZ]{3}[0-9]{3}$");
        Matcher matcher = pattern.matcher(valor);
        boolean found = matcher.find();
        return found;
    }
}
