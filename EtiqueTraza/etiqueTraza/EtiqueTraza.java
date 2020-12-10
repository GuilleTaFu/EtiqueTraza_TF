package etiqueTraza;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import articulos.Articulos;
import articulos.modiArticulo;
import auxiliares.RellenarCeros;
import etiquetas.EtTraza;
import interfaz.CuadroPrincipal;

public class EtiqueTraza {

	public Articulos arti;
	public CuadroPrincipal cuadro;
	public EtTraza etTraza;
	public infoTxt config;
	public modiArticulo modArti;
	public SalidaSole salSole;
	
	RellenarCeros ceros=new RellenarCeros();
	
	public EtiqueTraza() {
		
		try {
			config=new infoTxt();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		salSole=new SalidaSole();
		salSole.setLargoCol1(config.getCol1());
		salSole.setLargoCol2(config.getCol2());
		salSole.setLargoCol3(config.getCol3());
		salSole.setPathSalida(config.getSalPath());
		salSole.setNombreSalida(config.getSalNombre());
		salSole.setTitCol1(config.getSoltit1());
		salSole.setTitCol2(config.getSoltit2());
		salSole.setTitCol3(config.getSoltit3());
		salSole.setTxtCol1(config.getSolcli());
		
		cuadro=new CuadroPrincipal();

		//// CLICK DEL BOTON IMPRIMIR
		cuadro.btn.btnImprimir.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e) {
				  validaCodigo(cuadro.txt.txtIDProducto.getText());
				  if(arti.getEncontro()) {     /// SE VALIDA EL CODIGO

					  if(cuadro.txt.txtCantidad.getText()!="" && cuadro.txt.txtCantXCaja.getText()!="") {  //SI EL TXT CANTIDAD ES MAYOR QUE CERO
						  etTraza=new EtTraza();
						  etTraza.setImpresora(config.getImpDir());
						  etTraza.setImpText(config.getBatCuerpo());
						  etTraza.EtiqTraza(arti.getIdArticulo(),arti.getDescripcion(),Integer.parseInt(cuadro.txt.txtCantidad.getText()),cuadro.txt.cmbUsuario.getSelectedItem().toString(),Integer.parseInt(cuadro.txt.txtCantXCaja.getText()),arti.getNroEtiqueta(),arti.getUbicacion());
						  modArti=new modiArticulo(arti.getIdArticulo(),arti.getDescripcion(),arti.getNroEtiqueta(),cuadro.txt.cmbUsuario.getSelectedItem().toString(),Integer.parseInt(cuadro.txt.txtCantidad.getText()),Integer.parseInt(cuadro.txt.txtCantXCaja.getText()));
						  salSole.setTxtCol2(arti.getIdSole());
						  salSole.setTxtCol3(cuadro.txt.txtCantidad.getText());
						  salSole.guardar();

					  }
				  }
			  }
			  
		});	
	
		/// CONTROL DEL TEXTBOX ID ARTICULO
		cuadro.txt.txtIDProducto.addKeyListener(new KeyAdapter(){
			   public void keyTyped(KeyEvent e){   ////PASA TODO A MAYUSC y SI SUPERA 23 DIGITOS PIERDE EL FOCO
				   cuadro.txt.txtIDProducto.setText(cuadro.txt.txtIDProducto.getText().toUpperCase());
				   if(cuadro.txt.txtIDProducto.getText().length()>22) {
					   validaCodigo(cuadro.txt.txtIDProducto.getText());
					   cuadro.txt.txtCantidad.requestFocus();
					   

				   }
			   }
		});

		cuadro.txt.txtIDProducto.addFocusListener(new FocusListener() {
			   public void focusLost(FocusEvent e) {

				   validaCodigo(cuadro.txt.txtIDProducto.getText());
				   if(arti.getEncontro()) {
					   cuadro.lbl.lblRenglon1.setText(arti.getDescripcion());
					   cuadro.txt.txtIDProducto.setBackground(new Color(255,255,255));	
					   cuadro.txt.txtCantidad.requestFocus();
					   cuadro.lbl.lblRenglon2_2.setText("Cant: " + arti.getCantxcaja());
					   cuadro.lbl.lblRenglon2_1.setText((String) cuadro.txt.cmbUsuario.getSelectedItem());
				   }
			   }

			@Override
			public void focusGained(FocusEvent e) {
				cuadro.txt.txtIDProducto.getSelectedText();
				cuadro.txt.txtIDProducto.setBackground(new Color(253,197,188));		

			}
			});
		
		/// CONTROL DEL TEXTBOX CANTIDAD
				cuadro.txt.txtCantidad.addFocusListener(new FocusListener() {
					   public void focusLost(FocusEvent e) {
						   if(cuadro.txt.txtCantidad.getText().length()>0) {
							   cuadro.txt.txtCantidad.setBackground(new Color(255,255,255));	
							   cuadro.lbl.lblRenglon2_2.setText("Cant: " + cuadro.txt.txtCantXCaja.getText());
							   cuadro.btn.btnImprimir.requestFocus();
							   cuadro.lbl.lblDatosAImprimir.setText("Se imprimiran: "+Integer.parseInt(cuadro.txt.txtCantidad.getText())/Integer.parseInt(cuadro.txt.txtCantXCaja.getText())+" etiquetas");
						   }
						   }

					@Override
					public void focusGained(FocusEvent e) {
						cuadro.txt.txtCantidad.setBackground(new Color(253,197,188));		

					}
					});
		
		/// CONTROL DEL TEXTBOX CANTIDADXCAJA
		cuadro.txt.txtCantXCaja.addFocusListener(new FocusListener() {
			   public void focusLost(FocusEvent e) {
				   cuadro.txt.txtCantXCaja.setBackground(new Color(255,255,255));	
				   cuadro.lbl.lblRenglon2_2.setText("Cant: " + cuadro.txt.txtCantXCaja.getText());
				   cuadro.lbl.lblDatosAImprimir.setText("Se imprimiran: "+Integer.parseInt(cuadro.txt.txtCantidad.getText())/Integer.parseInt(cuadro.txt.txtCantXCaja.getText())+" etiquetas");
				   cuadro.btn.btnImprimir.requestFocus();
				   
			   }

			@Override
			public void focusGained(FocusEvent e) {
				cuadro.txt.txtCantXCaja.setBackground(new Color(253,197,188));		

			}
			});
	}
	private void validaCodigo(String valorTextBox) {
		String codFinal=valorTextBox.toUpperCase();
		//Validación SI se ingresó con el lector de codigos.
		// El length es igual a 23 dígitos. Se eliminan 10 dig. de la derecha y lo ceros de
		//la izq.
		
		if(codFinal.length()>13) {
			codFinal=codFinal.substring(0, 13);
		}
		codFinal=ceros.llenar(codFinal, 13, "I");

		
		arti=new Articulos(codFinal);
		if(arti.getEncontro()) { 
			cuadro.txt.txtCantXCaja.setText(String.valueOf(arti.getCantxcaja()));
			cuadro.lbl.lblDescripcion.setText(arti.getDescripcion());
			cuadro.txt.txtCantidad.setEnabled(true);
			cuadro.txt.txtCantXCaja.setEnabled(true);
		}else {	arti.porProveedor(valorTextBox);
					if(arti.getEncontro()) {
					cuadro.txt.txtCantXCaja.setText(String.valueOf(arti.getCantxcaja()));
					cuadro.lbl.lblDescripcion.setText(arti.getDescripcion());
					cuadro.txt.txtCantidad.setEnabled(true);
					cuadro.txt.txtCantXCaja.setEnabled(true);
				}
		}if(!arti.getEncontro()) {
			cuadro.lbl.lblDescripcion.setText("NO SE ENCONTRÓ");
			cuadro.txt.txtCantidad.setEnabled(false);
			cuadro.txt.txtCantXCaja.setEnabled(false);
		}
	
	}/// FIN METODO validaCodigo
	
	public EtiqueTraza(String idArticulo,String Usuario, Integer cantidad) {
		System.out.println("Sobrecarga");  
	//// TO DO FALTA PROGRAMAR LA OPCION PARA SER LLAMADO DESDE OTRA CLASE
	}

	public void traerArticulo(String codFinal) {
		arti=new Articulos(codFinal);
	}
	
	public static void main(String[] args) {
		new EtiqueTraza();

	}

}/// FIN CLASE
