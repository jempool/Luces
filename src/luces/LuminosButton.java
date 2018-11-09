package luces;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;


public class LuminosButton extends JButton{
	private static final int MAXSIZE = 50;
	private int row=0, col=0;
		
		public LuminosButton(int row, int col){
			this.row=row;
			this.col=col;
			setBackground(Color.BLACK);
			Dimension size = new Dimension(MAXSIZE, MAXSIZE);
			setPreferredSize(size);			
		}
		
		public int getFila(){
			return row;
		}
		public int getColumna(){
			return col;
		}
		public void encender(){
			setBackground(Color.RED);
		}
		public void apagar(){
			setBackground(Color.BLACK);			
		}
		public boolean isOn(){		
			boolean estado;
			Color color = getBackground();
			estado = color.equals(Color.RED);
			return estado;
		}
		public void cambiarOnOff(){
			if(isOn()){
				apagar();
			}
			else{
				encender();
			}
		}
	}
