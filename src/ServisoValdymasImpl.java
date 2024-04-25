import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServisoValdymasImpl implements ServisoValdymas {

    private String klientaiIrJuAuto = "C:\\MokymoDarbai\\AutoServisas\\KlientaiIrJuAuto.txt";
    private String pakaitiniaiAutomobiliai = "C:\\MokymoDarbai\\AutoServisas\\PakaitiniaiAutomobiliai.txt";
    private String suremontuotuAutomobiliuIstorija = "C:\\MokymoDarbai\\AutoServisas\\SuremontuotuAutomobiliuIstorija.txt";
    BufferedWriter bw;
    BufferedReader br;
    Klientas klientas = new Klientas();
    List<Klientas> klientuSarasas = new ArrayList<>();


    public void valdymas() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pasirinkite kokį veiksmą norite atlikti: ");
        System.out.println("1. Patikrinti sąrašą klientų su jų turimais automobiliais.");

        switch (sc.nextInt()) {
            case 1:
                try {
                    br = new BufferedReader(new FileReader(klientaiIrJuAuto));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        String[] lineValues = line.split(",");
                        if (lineValues.length == 8) {
                            Klientas naujasKlientas = new Klientas((Integer.parseInt(lineValues[0])),lineValues[1],lineValues[2],lineValues[3],null);
                            Automobilis naujasAuto = new Automobilis(lineValues[4],lineValues[5],Integer.parseInt(lineValues[6]),KuroTipas.valueOf(lineValues[7]));

                            if(klientuSarasas.contains(naujasKlientas)){
                                int i=0;
                                for(Klientas a: klientuSarasas){
                                    if(a.equals(naujasKlientas)){
                                        a.klientoAutomobiliuSarasas.add(naujasAuto);
                                    }
                                }
                            }else {
                                naujasKlientas.klientoAutomobiliuSarasas.add((naujasAuto));
                                klientuSarasas.add(naujasKlientas);
                            }
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                System.out.println(klientuSarasas);
                System.out.println(klientas.klientoAutomobiliuSarasas);
        }

    }


    @Override
    public void registruotiNaujaAutomobiliRemontui(Automobilis automobilis) {
    }

    @Override
    public Automobilis suteiktiPakaitini() {
        return null;
    }

    @Override
    public List<RemontuotinasAutomobilis> gautiVisąRemontuojamuAutoSarasa() {
        return remontuotiniAuto;
    }

    @Override
    public Automobilis grazintiKlientuiSuremontuota(Klientas klientas) {
        return null;
    }
}
