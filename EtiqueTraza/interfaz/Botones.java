package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Botones {
	public JButton btnImprimir;
	
	public Botones() {
		btnImprimir=new JButton();
		String imIcono="Contenidos\\printer.png";
		btnImprimir.setIcon(new ImageIcon(imIcono));
		btnImprimir.setBounds(650,450,120,80);
		btnImprimir.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  
			  }
			  
		});			
	
	}
}
