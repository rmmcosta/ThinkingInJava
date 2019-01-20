package interfaces.interfaceprocessor;

import interfaces.filters.Filter;
import interfaces.filters.LowPass;
import interfaces.filters.Waveform;

class FilterAdapter implements Processor{
    Filter filter;
    public FilterAdapter(Filter f){
        filter = f;
    }
    public Waveform process(Object s){
        return filter.process((Waveform) s);
    };
    public String name(){
        return filter.name();
    }
}

public class FilterProcessor {
    public static void main(String[] args){
        Waveform w = new Waveform();
        System.out.println(w);
        Apply.process(new FilterAdapter(new LowPass()),w);
    }
}
