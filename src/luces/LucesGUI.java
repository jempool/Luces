package luces;

import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LucesGUI extends JFrame{
	
	private Container contenedor;
	private JLabel titulo;
	private static final int GRIDSIZE = 3;
	private LuminosButton botones[][];
	private JPanel marco;
	
	public LucesGUI(){
		initGUI();
		pack();
		
		setTitle("Luces");
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true); 	
	}
	
	private void initGUI(){
		contenedor = this.getContentPane();
		contenedor.setLayout(new BorderLayout());
		
		titulo = new JLabel("Marco de Luces");
		contenedor.add(titulo, BorderLayout.NORTH);
		
		botones = new LuminosButton[GRIDSIZE][GRIDSIZE];
		
		marco = new JPanel();
		marco.setLayout(new GridLayout(3,3)); 
		EscuchaEventoAction Escucha = new EscuchaEventoAction();
		
		for(int i=0; i<GRIDSIZE; i++){
			for(int j=0; j<GRIDSIZE; j++){
				botones[i][j] = new LuminosButton(i,j);
				/*aqui*/botones[i][j].addActionListener(Escucha);
				marco.add(botones[i][j]);
			}
		}
		
		contenedor.add(marco,BorderLayout.CENTER);
	}
	
	private class EscuchaEventoAction implements ActionListener{
		public void actionPerformed(ActionEvent e){
			LuminosButton lBoton=(LuminosButton)e.getSource();
			int row = lBoton.getFila();
			int col = lBoton.getColumna();
			cambiarLuces(row,col);
			}
	}
	
	private void cambiarLuces(int row, int col){
		botones[row][col].cambiarOnOff();
		//esquina superior izquierda
		if(row==0 && col==0){
		botones[row][col+1].cambiarOnOff();
		botones[row+1][col].cambiarOnOff();
		botones[row+1][col+1].cambiarOnOff();
		}
		else{
			//esquina superior derecha
			if(row==0 && col==(GRIDSIZE-1)){
			botones[row][col-1].cambiarOnOff();
			botones[row+1][col].cambiarOnOff();
			botones[row+1][col-1].cambiarOnOff();
			}
			else{
				//esquina inferior izquierda
				if(row==(GRIDSIZE-1) && col==0){
				botones[row-1][col].cambiarOnOff();
				botones[row-1][col+1].cambiarOnOff();
				botones[row][col+1].cambiarOnOff();
				}
				else{
					//esquina inferior derecha
					if(row==(GRIDSIZE-1) && col==(GRIDSIZE-1)){
					botones[row-1][col].cambiarOnOff();
					botones[row-1][col-1].cambiarOnOff();
					botones[row][col-1].cambiarOnOff();
					}
					else{
						//boton central rejilla
						if(row==1 && col==1){
						botones[row-1][col].cambiarOnOff();
						botones[row+1][col].cambiarOnOff();
						botones[row][col-1].cambiarOnOff();
						botones[row][col+1].cambiarOnOff();
						}
						else{
							//boton central lateral derecho
							if(row==1 && col==2){
							botones[row-1][col].cambiarOnOff();
							botones[row+1][col].cambiarOnOff();
							}
							else{
								//boton central lateral izquierdo
								 if(row==1 && col==0){
								 botones[row-1][col].cambiarOnOff();
								 botones[row+1][col].cambiarOnOff();
								 }
								 else{
									//boton central lateral superior
									 if(row==0 && col==1){
									botones[row][col-1].cambiarOnOff();
									botones[row][col+1].cambiarOnOff();
									 }
									else{
										 //boton central lateral inferior
										 if(row==2 && col==1){
										 botones[row][col+1].cambiarOnOff();
										 botones[row][col-1].cambiarOnOff();
										 }
									}
								 }
							}
						}
					}
				}	
			}
		}
	}
	
}
