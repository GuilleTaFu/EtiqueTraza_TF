package interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class labels {
	private JLabel lbletiqDescrip;
	private JLabel lbletiqUsuario;
	private JLabel lbletiqCantTexto;
	private JLabel lblCodBarra;
	public JLabel lblRenglon1,lblRenglon2_1,lblRenglon2_2,lblRenglon3;
	public JLabel lblLineaHorizontal,lblUsuario,lblIDProducto,lblCanUnidades,lblCantXCaja,lblDescripcion;
	public JLabel lblDatosAImprimir;
	
	
	public labels() {
		lblRenglon1=new JLabel("");
		lblRenglon1.setBounds(200, 50, 400, 50);
		lblRenglon1.setOpaque(true);
		lblRenglon1.setBackground(Color.white);
		lblRenglon1.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblRenglon2_1=new JLabel("");
		lblRenglon2_1.setBounds(200, 100, 300, 50);
		lblRenglon2_1.setOpaque(true);
		lblRenglon2_1.setBackground(Color.white);
		lblRenglon2_1.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblRenglon2_2=new JLabel("");
		lblRenglon2_2.setBounds(500, 100, 100, 50);
		lblRenglon2_2.setOpaque(true);
		lblRenglon2_2.setBackground(Color.white);
		lblRenglon2_2.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblRenglon3=new JLabel("");
		lblRenglon3.setBounds(200, 150, 400, 50);
		lblRenglon3.setOpaque(true);
		lblRenglon3.setBackground(Color.white);
		lblRenglon3.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblDatosAImprimir=new JLabel("Se imprimiran: ...");
		lblDatosAImprimir.setBounds(200, 200, 400, 50);
		lblDatosAImprimir.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		lblDatosAImprimir.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblLineaHorizontal= new JLabel("");
		lblLineaHorizontal.setBorder(BorderFactory.createMatteBorder(5, 1, 5, 1, Color.GRAY));
		lblLineaHorizontal.setBounds(3,295,775,3);
		
		lblUsuario=new JLabel("USUARIO");
		lblUsuario.setBounds(20,300,300,40);
		lblUsuario.setForeground(new Color(0,0,102));
		lblUsuario.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblIDProducto=new JLabel("COD. ARTICULO");
		lblIDProducto.setBounds(20, 355, 300, 40);
		lblIDProducto.setForeground(new Color(0,0,102));
		lblIDProducto.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblDescripcion=new JLabel("");
		lblDescripcion.setBounds(480, 355, 300, 40);
		lblDescripcion.setForeground(new Color(0,0,102));
		lblDescripcion.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblCanUnidades=new JLabel("CANTIDAD");
		lblCanUnidades.setBounds(20, 405, 300, 40);
		lblCanUnidades.setForeground(new Color(0,0,102));
		lblCanUnidades.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lblCantXCaja=new JLabel("CANT. POR CAJA");
		lblCantXCaja.setBounds(20, 455, 300, 40);
		lblCantXCaja.setForeground(new Color(0,0,102));
		lblCantXCaja.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
		
		lbletiqDescrip=new JLabel();
		
		lbletiqUsuario=new JLabel();
		lbletiqCantTexto=new JLabel();
		lblCodBarra=new JLabel();
	}
	
	public JLabel getLbletiqDescrip() {
		return lbletiqDescrip;
	}

	public void setLbletiqDescrip(JLabel lbletiqDescrip) {
		this.lbletiqDescrip = lbletiqDescrip;
	}

	public JLabel getLbletiqUsuario() {
		return lbletiqUsuario;
	}

	public void setLbletiqUsuario(JLabel lbletiqUsuario) {
		this.lbletiqUsuario = lbletiqUsuario;
	}

	public JLabel getLbletiqCantTexto() {
		return lbletiqCantTexto;
	}

	public void setLbletiqCantTexto(JLabel lbletiqCantTexto) {
		this.lbletiqCantTexto = lbletiqCantTexto;
	}

	public JLabel getLblCodBarra() {
		return lblCodBarra;
	}

	public void setLblCodBarra(JLabel lblCodBarra) {
		this.lblCodBarra = lblCodBarra;
	}
	
}
