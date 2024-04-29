public class PakaitinisAutomobilis extends Automobilis{
    int rida;

    public PakaitinisAutomobilis(String marke, String modelis, int metai, KuroTipas kuras, int rida) {
        super(marke, modelis, metai, kuras);
        this.rida = rida;
    }

    public int getRida() {return rida;}
    public void setRida(int rida) {this.rida = rida;}

    @Override
    public String toString(){
        return "Pakaitinio automobilio markė: " + marke + ". Modelis: " + modelis + ". Metai: " + metai
                + ". Kuro tipas: " + kuras + ". Rida: " + rida + ". ";
    }


}
