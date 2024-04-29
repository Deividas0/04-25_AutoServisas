import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klientas {
    int id;
    String vardas;
    String pavarde;
    String email;
    Automobilis pakaitinisAuto;

    List<Automobilis> klientoAutomobiliuSarasas = new ArrayList<>();

    public Klientas(int id, String vardas, String pavarde, String email, Automobilis pakaitinisAuto) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.email = email;
        this.pakaitinisAuto = pakaitinisAuto;
    }
    public int getId() {return id;}
    public String getVardas() {return vardas;}
    public String getPavarde() {return pavarde;}
    public String getEmail() {return email;}
    public Automobilis getPakaitinisAuto() {return pakaitinisAuto;}

    public void setId(int id) {this.id = id;}
    public void setVardas(String vardas) {this.vardas = vardas;}
    public void setPavarde(String pavarde) {this.pavarde = pavarde;}
    public void setEmail(String email) {this.email = email;}
    public void setPakaitinisAuto(Automobilis pakaitinisAuto) {this.pakaitinisAuto = pakaitinisAuto;}

    public Klientas(){

    }
    @Override
    public boolean equals(Object object){
        Klientas klientas = (Klientas) object;
        if(klientas.id == this.id)
            return true;
        return false;
    }
    @Override
    public String toString(){
        return "Kliento vardas: " + getVardas() + ". Pavardė: " + getPavarde() + ". El. pašto adresas: " + getEmail() +
                ". Pakaitinis automobilis: " + getPakaitinisAuto() + ". \n";
    }

}









//4. Sukurti klasę klientas, kuris turi Id, Varda, pavarde, el.pasto adresa, pakaitinis automobilis,
//bei sarasa automobiliu kuriuos klientas turi.