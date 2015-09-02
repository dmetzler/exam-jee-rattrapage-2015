package org.isen.jee.exam.mastermind;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.isen.jee.exam.mastermind.harness.JettyHarness;
import org.junit.Test;

public class MasterMindServletTest extends JettyHarness {

    /**
     * En implémentant la méthode `doPut()` faire en sorte que la servlet
     * initialise les pions à deviner par la requête suivante :
     * <p/>
     * PUT http://localhost:9090/game pins: ROUGE,VERT,BLEU,ORANGE
     *
     * La servlet doit retourner la liste des pions.
     *
     * @throws Exception
     */
    @Test
    public void itCanSetThePinsToGuess() throws Exception {
        Map<String, String> params = buildParams("ROUGE,JAUNE,VERT,BLEU");
        assertEquals("ROUGE,JAUNE,VERT,BLEU", put(getServletUri(), params));
    }

    /**
     * En implémentant la méthode `doPost()` faire en sorte que la servlet teste
     * une combinaison et renvoie le nombre de pion bien placés ainsi que le
     * nombre de pions de bonne couleur mais mal placés :
     *
     * POST http://localhost:9090/game pins: ROUGE,VERT,BLEU,ORANGE
     *
     * @throws Exception
     */
    @Test
    public void itCanTryAGuess() throws Exception {

        Map<String, String> params = buildParams("ROUGE,JAUNE,VERT,BLEU");
        assertEquals("ROUGE,JAUNE,VERT,BLEU", put(getServletUri(), params));

        params.put("pins", "ROUGE,VERT,BLEU,ORANGE");
        assertEquals("1-2", post(getServletUri(), params));
    }

    private Map<String, String> buildParams(String pins) {
        Map<String, String> params = new HashMap<>();
        params.put("pins", pins);
        return params;
    }

    private String getServletUri() {
        return getBaseUri() + "/game";
    }
}
