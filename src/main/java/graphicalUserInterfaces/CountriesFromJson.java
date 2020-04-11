package graphicalUserInterfaces;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CountriesFromJson {

    public static void main(String[] args) {
        //JSON parser object to parse read file
        parseCountries();
    }

    public static Map<String, String> getCountriesAndCapitals() {
        Map<String, String> countriesAndCapitals = new HashMap<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("/home/ricardo/IdeaProjects/Github/ThinkingInJava/src/main/java/graphicalUserInterfaces/countries.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray countries = (JSONArray) obj;
            //System.out.println(countries);

            //Iterate over countries array
            countries.forEach(country -> countriesAndCapitals.put(
                    (String) ((JSONObject) country).get("CountryName"),
                    (String) ((JSONObject) country).get("CapitalName"))
            );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return countriesAndCapitals;
    }

    public static void parseCountries() {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("/home/ricardo/IdeaProjects/Github/ThinkingInJava/src/main/java/graphicalUserInterfaces/countries.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray countries = (JSONArray) obj;
            //System.out.println(countries);

            //Iterate over employee array
            countries.forEach(country -> parseCountryObject((JSONObject) country));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void parseCountryObject(JSONObject country) {
        //Get employee object within list
        //JSONObject employeeObject = (JSONObject) country.get("employee");

        //Get country name
        String countryName = (String) country.get("CountryName");
        System.out.println(countryName);

        //Get capital name
        String capitalName = (String) country.get("CapitalName");
        System.out.println(capitalName);

    }

    @Test
    public void testGetCountries() {
        Map<String,String> countries = getCountriesAndCapitals();
        assertTrue(countries.size() > 0);
        assertEquals("Lisbon",countries.get("Portugal"));
        System.out.println(countries.get("Portugal"));
    }
}
