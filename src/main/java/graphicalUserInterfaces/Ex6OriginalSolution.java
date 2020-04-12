package graphicalUserInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex6OriginalSolution extends JFrame {
    private JTextArea input = new JTextArea(5, 60),
            output = new JTextArea(5, 60);
    private JTextField expression = new JTextField(40);
    private JButton match = new JButton("Match");
    private JLabel inputLabel = new JLabel("Input"),
            outputLabel = new JLabel("Output"),
            expressionLabel = new JLabel("Expression");
    private JPanel panel1 = new JPanel(),
            panel2 = new JPanel(),
            panel3 = new JPanel();

    public Ex6OriginalSolution() throws HeadlessException {
        panel1.add(inputLabel);
        panel1.add(new JScrollPane(input));
        add(panel1);
        panel2.add(expressionLabel);
        panel2.add(expression);
        panel2.add(match);
        add(panel2);
        panel3.add(outputLabel);
        panel3.add(new JScrollPane(output));
        add(panel3);
        match.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("");
                Pattern pattern = Pattern.compile(expression.getText());
                Matcher matcher = pattern.matcher(input.getText());
                while (matcher.find()) {
                    if(matcher.group().isEmpty()){
                        continue;
                    }
                    output.append(String.format("Match \"%s\" at positions %d - %d\n",
                            matcher.group(), matcher.start(), matcher.end()-1));
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingConsole.runFrame(new Ex6OriginalSolution(), 700, 400, new GridLayout(3, 1));
    }
}
