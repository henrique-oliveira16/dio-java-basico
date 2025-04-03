import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField campoTexto;
    private JButton calcularBotao;

    public Calculadora() {
        setTitle("Calculadora Simples");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Digite o primeiro número:");
        JTextField num1Field = new JTextField(10);
        JLabel label2 = new JLabel("Digite o operador (+, -, *, /):");
        JTextField operadorField = new JTextField(2);
        JLabel label3 = new JLabel("Digite o segundo número:");
        JTextField num2Field = new JTextField(10);
        calcularBotao = new JButton("Calcular");
        campoTexto = new JTextField(15);
        campoTexto.setEditable(false);

        add(label1);
        add(num1Field);
        add(label2);
        add(operadorField);
        add(label3);
        add(num2Field);
        add(calcularBotao);
        add(campoTexto);

        calcularBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(num1Field.getText());
                    double num2 = Double.parseDouble(num2Field.getText());
                    char operador = operadorField.getText().charAt(0);
                    double resultado = 0;

                    switch (operador) {
                        case '+': resultado = num1 + num2; break;
                        case '-': resultado = num1 - num2; break;
                        case '*': resultado = num1 * num2; break;
                        case '/': 
                            if (num2 != 0) {
                                resultado = num1 / num2;
                            } else {
                                campoTexto.setText("Erro: Divisão por zero");
                                return;
                            }
                            break;
                        default:
                            campoTexto.setText("Operador inválido!");
                            return;
                    }
                    campoTexto.setText("Resultado: " + resultado);
                } catch (Exception ex) {
                    campoTexto.setText("Entrada inválida!");
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}