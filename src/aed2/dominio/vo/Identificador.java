package aed2.dominio.vo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Identificador {
    public static boolean validate (String valor) {
        Pattern pattern_one = Pattern.compile("^(FR|DE|UK|ES|OT){1}\\d{1}.[0-9]{3}.[0-9]{3}#\\d{1}$");
        Pattern pattern_two = Pattern.compile("^(FR|DE|UK|ES|OT){1}\\d{3}.[0-9]{3}#\\d{1}$");
        Matcher m1 = pattern_one.matcher(valor);
        Matcher m2 = pattern_two.matcher(valor);
        boolean found = m1.find() || m2.find();
        return found;
    }
}
