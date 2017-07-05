/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Janela {
      public static void main(String[] args) {
          JButton botao = new JButton();
	JFrame janela = new JFrame("Meu primeiro frame em Java");
		Painel meuPainel = new Painel();		
		janela.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		janela.add(meuPainel);
		janela.setSize(600,400);
		janela.setVisible(true);
                JOptionPane.showMessageDialog(null, "Teste");
                janela.add(botao);
    }

    public void jTextFieldApelidoEnvioManualActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }
}
