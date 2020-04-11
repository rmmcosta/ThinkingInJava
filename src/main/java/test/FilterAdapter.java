package test;

import java.lang.reflect.Array;

public class FilterAdapter implements Processor {
    private Filter _filter;

    public FilterAdapter(Filter filter) {
        _filter = filter;
    }

    @Override
    public String getName() {
        return _filter.getName();
    }

    @Override
    public Object process(Object input) {
        return _filter.process((Waveform) input).toString();
    }
}

class FilterAdapterMain {
    public static void main(String[] args) {
        final String message = "Coiso e tal";
        Processor[] myObjs = {new DownCase(), new UpperCase(), new Split(), new FilterAdapter(new LowPass(3.3)), new FilterAdapter(new LowPass(4.0))};
        for (Processor p : myObjs) {
            if (p instanceof FilterAdapter) {
                Apply.process(p, new Waveform());
            } else {
                Apply.process(p, message);
            }

        }
    }
}
