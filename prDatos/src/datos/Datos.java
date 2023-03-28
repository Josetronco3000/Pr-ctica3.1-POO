package datos;
import java.util.ArrayList;
import java.util.List;
import static java.lang.Double.parseDouble;

public class Datos {
    private List<Double> numreales;
    private List<String> errores;
    private double min;
    private double max;

    Datos(String[] d, double min, double max){
        numreales = new ArrayList<Double>();
        errores = new ArrayList<String>();
        for(String s: d){
            try{
                double num = Double.parseDouble(s);
                numreales.add(num);
            }catch (NumberFormatException e){
                errores.add(s);
            }
        }
        this.min = min;
        this.max = max;
    }

    public double calcMedia(){
        double suma = 0;
        double n = 0.0;
        double media = 0.0;
        for(int i = 0; i < numreales.size(); i++){
            if((numreales.get(i) >= min) && (numreales.get(i) <= max)){
                suma = suma + numreales.get(i);
                n++;
            }
        }
        if(n == 0.0){
            throw new DatosException("No hay datos en el rango especificado");
        }else{
            media = suma/n;
            return media;
        }
    }
    public double calcDesvTipica(){
        double media = calcMedia();
        double desvTipica;
        double n = 0;
        double sumatorio = 0;
        for(int i = 0; i < numreales.size(); i++){
            if((numreales.get(i) >= min) && (numreales.get(i) <= max)){
                n++;
                sumatorio = Math.pow((numreales.get(i) - media), 2);
            }
        }
        desvTipica = Math.sqrt((1/n)*sumatorio);
        return desvTipica;
    }

    public void setRango(String datos){
        int n = datos.indexOf(";");

    }

    public List<Double> getDatos(){
        return numreales;
    }

    public List<String> getErrores(){
        return errores;
    }

    @Override
    public String toString(){
        return ("Min: " + this.min + ", " + "Max: " + this.max + ", "+
                 getDatos() + ", " + getErrores() + ", " + "Media: " + calcMedia() + ", " + "DesvTipica: " + calcDesvTipica());
    }
}
