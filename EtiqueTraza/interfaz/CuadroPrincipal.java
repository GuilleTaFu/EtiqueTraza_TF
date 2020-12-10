package interfaz;

import java.awt.Color;
import java.awt.Dimension;

import javax.print.DocFlavor.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import articulos.Articulos;

public class CuadroPrincipal extends JFrame{
	private JFrame ventana;
	
	public TextBox txt;
	public labels lbl;
	public Botones btn;

	
	public CuadroPrincipal() {
		lbl=new labels();
		txt=new TextBox();
		btn=new Botones();
		
		ventana=new JFrame("EtiqueTraza V1.0");

		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(new Dimension(700, 300));
		ventana.setBackground(new Color(100,204,255));
		ventana.setBounds(200,105,800,600);
		
		java.net.URL iconURL = getClass().getResource("/Contenidos/codBarra.png");
		ImageIcon icon = new ImageIcon(iconURL);
		ventana.setIconImage(icon.getImage());		
		
		ventana.setLayout(null);
		ventana.add(lbl.lblLineaHorizontal);
		ventana.add(lbl.lblUsuario);
		ventana.add(lbl.lblIDProducto);
		ventana.add(lbl.lblCanUnidades);
		ventana.add(lbl.lblCantXCaja);
		ventana.add(lbl.lblDescripcion);
		ventana.add(lbl.lblRenglon1);
		ventana.add(lbl.lblRenglon2_1);
		ventana.add(lbl.lblRenglon2_2);
		ventana.add(lbl.lblRenglon3);
		ventana.add(lbl.lblDatosAImprimir);
		
		ventana.add(txt.cmbUsuario);
		ventana.add(txt.txtIDProducto);
		ventana.add(txt.txtCantidad);
		ventana.add(txt.txtCantXCaja);
		
		ventana.add(btn.btnImprimir);

		ventana.setVisible(true);
	}/// FIN CONSTRUCTOR
	

	
}//FIN CLASE
