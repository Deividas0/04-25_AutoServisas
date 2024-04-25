public class VersloKlientas extends Klientas{
    public String imonesPavadinimas;
    public String pvmMoketojoKodas;

    public VersloKlientas(int id, String vardas, String pavarde, String email, Automobilis pakaitinisAuto,
                          String imonesPavadinimas, String pvmMoketojoKodas) {
        super(id, vardas, pavarde, email, pakaitinisAuto);
    }

    public String getImonesPavadinimas() {return imonesPavadinimas;}
    public String getPvmMoketojoKodas() {return pvmMoketojoKodas;}

    public void setImonesPavadinimas(String imonesPavadinimas) {this.imonesPavadinimas = imonesPavadinimas;}
    public void setPvmMoketojoKodas(String pvmMoketojoKodas) {this.pvmMoketojoKodas = pvmMoketojoKodas;}
}










// 5. Sukurti klasę verslo klientas kuri papildytų klasę klientas su Imones pavadinimas, PVM Moketojo kodas(String)