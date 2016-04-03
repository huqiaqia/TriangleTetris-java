package TriangleTetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

public class TriangleShapes implements MouseMotionListener,
MouseListener{
	TetrisCanvas tc = new TetrisCanvas();
	float centerX = tc.centerX;
	float centerY = tc.centerY;
	int pixelSize = tc.pixelSize, graphSize = tc.graphSize;
	float rWidth = 20.0F, rHeight = 20.0F;
	
	public void paint(Graphics g,int signal){
		int x=0;
		int y=0;
		int Ax = (int) (centerX)-(5-x)*graphSize;
		int Ay = (int)(centerY)-(10-y)*graphSize;
		if(signal==1){
		int[] xValues = { Ax , Ax - (int) graphSize,
				Ax + (int) graphSize };
		int[] yValues = { Ay , Ay + (int) graphSize,
				Ay + (int) graphSize };
		g.setColor(Color.YELLOW);
		g.fillPolygon(xValues, yValues, 3);
		g.setColor(Color.BLACK);
		g.drawPolygon(xValues, yValues, 3);
		g.drawLine(Ax, Ay, Ax, Ay + (int) graphSize);
		}
		else if(signal==2){
			int[] xValues = { Ax , Ax ,Ax + (int) graphSize
					 };
			int[] yValues = { Ay , Ay + (int) graphSize,
					Ay + (int) graphSize };
			g.setColor(Color.RED);
			g.fillPolygon(xValues, yValues, 3);
			g.setColor(Color.BLACK);
			g.drawPolygon(xValues, yValues, 3);
		}
		else if(signal==3){
			g.setColor(Color.BLUE);
			g.fillRect(Ax,Ay, graphSize, graphSize);
			g.setColor(Color.BLACK);
			g.drawRect(Ax,Ay, graphSize, graphSize);
		}
		else if(signal ==4){
			int[] xValues = { Ax - graphSize, Ax,
					Ax,Ax+graphSize};
			int[] yValues = { Ay ,Ay,
					Ay + graphSize,Ay + graphSize};
			g.setColor(Color.GREEN);
			g.fillPolygon(xValues, yValues, 4);
			g.setColor(Color.BLACK);
			g.drawPolygon(xValues, yValues, 4);
			g.drawLine(Ax,Ay, Ax, Ay+ graphSize);
		}
		else if(signal ==5){
			int[] xValues = { Ax,Ax+graphSize,
					Ax-graphSize,Ax};
			int[] yValues = { Ay, Ay,
					Ay+graphSize,Ay+graphSize};
			g.setColor(Color.ORANGE);
			g.fillPolygon(xValues, yValues, 4);
			g.setColor(Color.BLACK);
			g.drawPolygon(xValues, yValues, 4);
			g.drawLine(Ax,Ay, Ax, Ay+ graphSize);
		}
	}

	private void addMouseMotionListener(TriangleShapes triangleShapes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(SwingUtilities.isRightMouseButton(e)){
			;
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
