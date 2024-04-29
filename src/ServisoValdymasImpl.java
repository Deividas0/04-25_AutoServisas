import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServisoValdymasImpl implements ServisoValdymas {

    private String klientaiIrJuAuto = "C:\\MokymoDarbai\\AutoServisas\\KlientaiIrJuAuto.csv";
    private String pakaitiniaiAutomobiliai = "C:\\MokymoDarbai\\AutoServisas\\PakaitiniaiAutomobiliai.csv";
    private String suremontuotuAutomobiliuIstorija = "C:\\MokymoDarbai\\AutoServisas\\SuremontuotuAutomobiliuIstorija.csv";
    BufferedWriter bw;
    BufferedReader br;
    Klientas klientas = new Klientas();
    List<Klientas> klientuSarasas = new ArrayList<>();
    List<PakaitinisAutomobilis> spargalke = new ArrayList<>();


    public void valdymas() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Pasirinkite kokį veiksmą norite atlikti: ");
        System.out.println("1. Patikrinti sąrašą klientų su jų turimais automobiliais.");
        System.out.println("2. Patikrinti laisvų pakaitinių automobilių sąrašą.");
        System.out.println("3. Priskirti klientui pakaitini automobilį.");

        switch (sc.nextInt()) {
            case 1:
                try {
                    br = new BufferedReader(new FileReader(klientaiIrJuAuto));
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                        String[] lineValues = line.split(",");
                        if (lineValues.length == 8) {
                            Klientas naujasKlientas = new Klientas((Integer.parseInt(lineValues[0])), lineValues[1], lineValues[2], lineValues[3], null);
                            Automobilis naujasAuto = new Automobilis(lineValues[4], lineValues[5], Integer.parseInt(lineValues[6]), KuroTipas.valueOf(lineValues[7]));

                            if (klientuSarasas.contains(naujasKlientas)) {
                                int i = 0;
                                for (Klientas a : klientuSarasas) {
                                    if (a.equals(naujasKlientas)) {
                                        a.klientoAutomobiliuSarasas.add(naujasAuto);
                                    }
                                }
                            } else {
                                naujasKlientas.klientoAutomobiliuSarasas.add((naujasAuto));
                                klientuSarasas.add(naujasKlientas);
                            }
                        }
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                valdymas();

            case 2:
                String line;
                br = new BufferedReader(new FileReader(pakaitiniaiAutomobiliai));
                while ((line = br.readLine()) != null) {
                    String[] lineValues = line.split(",");
                    if (lineValues[4] != null) {
                        spargalke.add(new PakaitinisAutomobilis(lineValues[0], lineValues[1], Integer.parseInt(lineValues[2]), KuroTipas.valueOf(lineValues[3]), Integer.parseInt(lineValues[4])));
                    }
                }
                int i = 1;
                for (PakaitinisAutomobilis a : spargalke) {
                    System.out.println(i + ". " + a);
                    i++;
                }
                System.out.println();
            case 3:
                System.out.println("Pasirinkite kuriam klientui norite priskirti pakaitinį automobilį: ");
                i = 1;
                for (Klientas a : klientuSarasas) {
                    System.out.println(i + ". " + a);
                    i++;
                }
                int klientas = sc.nextInt();
                klientuSarasas.get(klientas - 1);
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
        return List.of();
    }

    @Override
    public Automobilis grazintiKlientuiSuremontuota(Klientas klientas) {
        return null;
    }
}
