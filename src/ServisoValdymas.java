import java.util.ArrayList;
import java.util.List;

public interface ServisoValdymas {
    List<RemontuotinasAutomobilis> remontuotiniAuto = new ArrayList<>();

    void registruotiNaujaAutomobiliRemontui(Automobilis automobilis);        // (Automobilis automobilis)
    Automobilis suteiktiPakaitini();                           // išrenka random automobili iš pakaitinių automobilių sąrašo.
    List<RemontuotinasAutomobilis> gautiVisąRemontuojamuAutoSarasa();                         // grąžina remontuotiniAuto sąrašą.
    Automobilis grazintiKlientuiSuremontuota(Klientas klientas); // (Automobilis automobilis) iraso automobili i SuremontuotuAutomobiliuIstorija.CSV
}
