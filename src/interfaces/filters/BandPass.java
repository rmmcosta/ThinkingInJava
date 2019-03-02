package interfaces.filters;

public class BandPass extends Filter {
    double lowCutoff, highCutoff;

    public BandPass(double l, double h){
        lowCutoff = l;
        highCutoff = h;
    }
}
