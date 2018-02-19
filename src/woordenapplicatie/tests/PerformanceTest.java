package woordenapplicatie.tests;

import org.junit.Test;
import woordenapplicatie.gui.OperationManager;

import static org.junit.Assert.*;

public class PerformanceTest {

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

    @Test
    public void TienDuizendWoorden(){
        OperationManager manager = new OperationManager();
        manager.concordatieAction(textGenerator(10000));
    }

    @Test
    public void milWoorden(){
        OperationManager manager = new OperationManager();
        manager.concordatieAction(textGenerator(1000000));
    }

    public String textGenerator(int amount){
        int count = amount/68;
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < count; i++){
            text.append(DEFAULT_TEXT);
        }
        return String.valueOf(text);
    }

}