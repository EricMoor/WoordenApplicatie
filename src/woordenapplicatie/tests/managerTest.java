package woordenapplicatie.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import woordenapplicatie.gui.OperationManager;

public class managerTest {

    public static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Heb je dan geen hoedje meer\n" +
            "Maak er één van bordpapier\n" +
            "Eén, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van, hoedje van\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier\n" +
            "\n" +
            "En als het hoedje dan niet past\n" +
            "Zetten we 't in de glazenkas\n" +
            "Een, twee, drie, vier\n" +
            "Hoedje van papier";


    OperationManager manager = new OperationManager();

    @Test
    public void aantalWoordenTest(){
        String result = manager.aantalWoorden(DEFAULT_TEXT);
        String expected = "Aantal unieke woorden: 28\n" +
                "Aantal woorden: 68";
        Assert.assertEquals(expected,result);
    }

    @Test
    public void sorteerWoordenTest(){
        String result = manager.sorteerAction(DEFAULT_TEXT);
        String expected = "één\n" +
                "zetten\n" +
                "we\n" +
                "vier\n" +
                "van\n" +
                "twee\n" +
                "past\n" +
                "papier\n" +
                "niet\n" +
                "meer\n" +
                "maak\n" +
                "je\n" +
                "in\n" +
                "hoedje\n" +
                "het\n" +
                "heb\n" +
                "glazenkas\n" +
                "geen\n" +
                "eén\n" +
                "er\n" +
                "en\n" +
                "een\n" +
                "drie\n" +
                "de\n" +
                "dan\n" +
                "bordpapier\n" +
                "als\n" +
                "'t\n";
        Assert.assertEquals(expected,result);
    }

    @Test
    public void frequentieWoordenTest(){
        String result = manager.frequentieAction(DEFAULT_TEXT);
        String expected = "glazenkas: 1\n" +
                "de: 1\n" +
                "heb: 1\n" +
                "eén: 1\n" +
                "maak: 1\n" +
                "één: 1\n" +
                "we: 1\n" +
                "het: 1\n" +
                "niet: 1\n" +
                "zetten: 1\n" +
                "in: 1\n" +
                "past: 1\n" +
                "en: 1\n" +
                "als: 1\n" +
                "er: 1\n" +
                "'t: 1\n" +
                "meer: 1\n" +
                "geen: 1\n" +
                "je: 1\n" +
                "bordpapier: 1\n" +
                "dan: 2\n" +
                "papier: 4\n" +
                "een: 5\n" +
                "drie: 6\n" +
                "twee: 6\n" +
                "vier: 6\n" +
                "van: 9\n" +
                "hoedje: 10\n";
        Assert.assertEquals(expected,result);
    }

    @Test
    public void concordatieWoordenTest(){
        String result = manager.concordatieAction(DEFAULT_TEXT);
        String expected = "=[5, 10, 15]\n" +
                "glazenkas=[17]\n" +
                "de=[17]\n" +
                "heb=[6]\n" +
                "drie=[1, 3, 8, 11, 13, 18]\n" +
                "eén=[8]\n" +
                "maak=[7]\n" +
                "één=[7]\n" +
                "we=[17]\n" +
                "een=[1, 3, 11, 13, 18]\n" +
                "dan=[6, 16]\n" +
                "twee=[1, 3, 8, 11, 13, 18]\n" +
                "het=[16]\n" +
                "vier=[1, 3, 8, 11, 13, 18]\n" +
                "niet=[16]\n" +
                "zetten=[17]\n" +
                "hoedje=[2, 4, 6, 9, 12, 14, 16, 19]\n" +
                "van=[2, 4, 7, 9, 12, 14, 19]\n" +
                "in=[17]\n" +
                "past=[16]\n" +
                "en=[16]\n" +
                "als=[16]\n" +
                "er=[7]\n" +
                "'t=[17]\n" +
                "meer=[6]\n" +
                "geen=[6]\n" +
                "je=[6]\n" +
                "papier=[4, 9, 14, 19]\n" +
                "bordpapier=[7]\n";
        Assert.assertEquals(expected,result);
    }
}
