package graphicalUserInterfaces;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CountriesFromJsonTest {
    static Map<String,String> countries;
    @BeforeAll
    public static void setUp() {
        countries = graphicalUserInterfaces.CountriesFromJson.getCountriesAndCapitals();
    }
    @Test
    public void portugalCapital(){
        assertEquals("Lisbon",countries.get("Portugal"));
    }

    @Test
    public void countriesNotEmpty() {
        assertTrue(countries.size() > 0);
    }

}