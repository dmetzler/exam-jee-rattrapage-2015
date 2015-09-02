package org.isen.jee.exam.mastermind;

import java.util.Arrays;
import java.util.Iterator;

import org.isen.jee.exam.mastermind.api.Color;

public class MasterMindServlet {



    /**
     * Retourne une chaine de caractère concaténant les couleurs
     * passées en entrée par une virgule.
     *
     * ex : joinColors(Color.ROUGE, Color.JAUNE) => "ROUGE,JAUNE"
     *
     * @param colors
     * @return
     */
    private String joinColors(Color... colors) {

        Iterator<Color> colIt = Arrays.asList(colors).iterator();
        StringBuffer sb = new StringBuffer(colIt.next().toString());
        while (colIt.hasNext()) {
            sb.append(",").append(colIt.next().toString());
        }
        return sb.toString();

    }
}
