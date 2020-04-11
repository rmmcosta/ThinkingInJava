package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CountriesUI extends JFrame {
    public CountriesUI() throws HeadlessException {
        JTextArea textArea = new JTextArea(20, 35);
        textArea.setEditable(false);
        JButton btnAdd = new JButton("add Countries");
        JButton btnClear = new JButton("clear");
        add(new JScrollPane(textArea));
        add(btnAdd);
        add(btnClear);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map<String, String> countriesAndCapitals = new HashMap<String, String>();
                countriesAndCapitals.putAll(CountriesFromJson.getCountriesAndCapitals());
                for (Map.Entry<String, String> country : countriesAndCapitals.entrySet()) {
                    textArea.append(String.format("%s:%s\n", country.getKey(), country.getValue()));
                }
            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new CountriesUI());
    }
}
