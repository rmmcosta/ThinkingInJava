package exceptions;

class DynamicFieldsException extends Exception {

}

public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[]{null, null};
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private Object setField(String key, Object value) throws DynamicFieldsException {
        if (value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNum = hasField(key);
        if (fieldNum == -1) {
            fieldNum = makeField(key);
        }
        Object result = null;
        try {
            result = getField(key);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        fields[fieldNum][1] = value;
        return result;
    }

    private int makeField(String key) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = key;
                return i;
            }
        }
        Object[][] tmp = new Object[fields.length + 1][2];
        for (int i = 0; i < tmp.length; i++) {
            if (i < fields.length) {
                tmp[i] = fields[i];
            } else {
                tmp[i] = new Object[]{key, null};
            }
        }
        fields = tmp;
        return (tmp.length - 1);
    }

    private Object getField(String key) throws NoSuchFieldException {
        return fields[getFieldNumber(key)][1];
    }

    private int getFieldNumber(String key) throws NoSuchFieldException {
        int fieldNum = hasField(key);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int hasField(String key) {
        for (int i = 0; i < fields.length; i++) {
            if (key.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try {
            df.setField("d", "A value for d");
            //System.out.println(df);
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", 11);
            System.out.println("df:" + df);
            System.out.println(df.setField("number3","new value 12")+", new value: " + df.getField("number3"));
            System.out.println("df.getField(\"d\"): " + df.getField("d"));
            Object field = df.setField("d", null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (DynamicFieldsException e) {
            e.printStackTrace();
        }
    }
}

