package TriangleTetris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TetrisCanvas extends Canvas implements MouseMotionListener,
		MouseListener {
	float centerX, centerY;
	int pixelSize, graphSize;
	float rWidth = 20.0F, rHeight = 20.0F;
	private boolean entered = false;
	GameStatus gs = new GameStatus();
	int level = gs.level;
	int lines = gs.lines;
	int scores = gs.scores;
	Image ImageBuffer = null;
	Graphics GraImage = null;
	int signal = 0;


	public TetrisCanvas() {
		addMouseListener(this);
	}

	void initial() {
		Dimension d = getSize();
		int maxX = d.width - 1, maxY = d.height - 1;
		pixelSize = (int) Math.max(rWidth / maxX, rHeight / maxY);
		graphSize = (int) Math.min(maxX / rWidth, maxY / rHeight);
		centerX = maxX / 2;
		centerY = maxY / 2;
	}

	int iX(float x) {
		return Math.round(centerX + x);
	}

	int iY(float y) {
		return Math.round(centerY - y);
	}

	float fx(int x) {
		return (x - centerX) * pixelSize;
	}

	float fy(int y) {
		return (centerY - y) * pixelSize;
	}

	public void update(Graphics g) {
		ImageBuffer = createImage(this.getWidth(), this.getHeight());
		GraImage = ImageBuffer.getGraphics();
		paint(GraImage);
		GraImage.dispose();
		g.drawImage(ImageBuffer, 0, 0, this);
	}

	public void paint(Graphics g,int i) {
		initial();
		int Ax = iX(-graphSize * 10), Ay = iY(graphSize * 10);
		int width = (int) graphSize * 10, height = (int) graphSize * 20;
		g.setColor(Color.lightGray);
		g.fillRect(Ax, Ay, width, height);
		g.drawRect(Ax, Ay, width, height);
		addMouseMotionListener(this);
		int Ex = iX(graphSize * 4), Ey = iY(graphSize * 10);
		int predictWidth = (int) graphSize * 4, predictHeight = (int) graphSize * 4;
		g.drawRect(Ex, Ey, predictWidth, predictHeight);
		if(i==1){
		int[] xValues = { Ex + 2 * (int) graphSize, Ex + (int) graphSize,
				Ex + 3 * (int) graphSize };
		int[] yValues = { Ey + (int) graphSize, Ey + 2 * (int) graphSize,
				Ey + 2 * (int) graphSize };
		g.setColor(Color.YELLOW);
		g.fillPolygon(xValues, yValues, 3);
		g.setColor(Color.BLACK);
		g.drawLine(Ex + 2 * (int) graphSize, Ey + (int) graphSize, Ex + 2
				* (int) graphSize, Ey + 2 * (int) graphSize);
		g.drawLine(Ex + 2 * (int) graphSize, Ey + (int) graphSize, Ex
				+ (int) graphSize, Ey + 2 * (int) graphSize);
		g.drawLine(Ex + (int) graphSize, Ey + 2 * (int) graphSize, Ex + 3
				* (int) graphSize, Ey + 2 * (int) graphSize);
		g.drawLine(Ex + 2 * (int) graphSize, Ey + (int) graphSize, Ex + 3
				* (int) graphSize, Ey + 2 * (int) graphSize);
			signal = 1;
		
		}
		else if(i==2){
		signal =2;
		int[] xValues = { Ex + 2 * (int) graphSize, Ex +2* (int) graphSize,
				Ex + 3 * (int) graphSize };
		int[] yValues = { Ey + (int) graphSize, Ey + 2 * (int) graphSize,
				Ey + 2 * (int) graphSize };
		g.setColor(Color.RED);
		g.fillPolygon(xValues, yValues, 3);
		g.setColor(Color.BLACK);
		g.drawPolygon(xValues, yValues, 3);
			
		}
		else if(i==3){
			signal = 3;
			g.setColor(Color.BLUE);
			g.fillRect(Ex+graphSize, Ey+graphSize, graphSize, graphSize);
			g.setColor(Color.BLACK);
			g.drawRect(Ex+graphSize, Ey+graphSize, graphSize, graphSize);
		}
		else if(i==4){
			signal = 4;
			int[] xValues = { Ex + graphSize, Ex +2*graphSize,
					Ex + 2* graphSize,Ex+3*graphSize};
			int[] yValues = { Ey +  graphSize, Ey +  graphSize,
					Ey + 2 *graphSize,Ey + 2 *graphSize};
			g.setColor(Color.GREEN);
			g.fillPolygon(xValues, yValues, 4);
			g.setColor(Color.BLACK);
			g.drawPolygon(xValues, yValues, 4);
			g.drawLine(Ex +2*graphSize, Ey +  graphSize, Ex +2*graphSize, Ey + 2 *graphSize);
		}
		else if(i==5){
			signal = 5;
			int[] xValues = { Ex + 2*graphSize, Ex +3*graphSize,
					Ex +  graphSize,Ex+2*graphSize};
			int[] yValues = { Ey +  graphSize, Ey +  graphSize,
					Ey + 2 *graphSize,Ey + 2 *graphSize};
			g.setColor(Color.ORANGE);
			g.fillPolygon(xValues, yValues, 4);
			g.setColor(Color.BLACK);
			g.drawPolygon(xValues, yValues, 4);
			g.drawLine(Ex +2*graphSize, Ey +  graphSize, Ex +2*graphSize, Ey + 2 *graphSize);
		}

		if (entered) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("Time New Roman", Font.BOLD, 35));
			g.drawString("PAUSE", Ax + width / 2 - 50, Ay + height / 2);
			g.drawRoundRect((width / 2) + Ax - 65, Ay + (height / 2) - 38, 150,
					50, 30, 30);
		}

		g.setColor(Color.red);
		g.fillRect((int) (centerX + 5 * graphSize),
				(int) (centerY + 7 * graphSize), (int) graphSize * 3,
				(int) graphSize);
		g.setColor(Color.darkGray);
		g.setFont(new Font("Time New Roman", Font.BOLD, (int) graphSize));
		g.drawString("Level: " + level, (int) (centerX + 2 * graphSize),
				(int) centerY);
		g.drawString("Lines: " + lines, (int) (centerX + 2 * graphSize),
				(int) (centerY + 2 * graphSize));
		g.drawString("Scores: " + scores, (int) (centerX + 2 * graphSize),
				(int) (centerY + 4 * graphSize));
		g.drawString("QUIT ", (int) (centerX + 5 * graphSize),
				(int) (centerY + 8 * graphSize));
		g.drawRect((int) (centerX + 5 * graphSize),
				(int) (centerY + 7 * graphSize), (int) graphSize * 3,
				(int) graphSize);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int left = (int) (centerX + 5 * graphSize), top = (int) (centerY + 7 * graphSize);
		int right = left + (int) graphSize * 3, down = top + (int) graphSize;
		if (e.getX() > left && e.getX() < right && e.getY() > top
				&& e.getY() < down) {
			System.exit(0);
		}
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
		initial();
		int left = iX(-graphSize * 10), top = iY(graphSize * 10);
		int right = left + (int) graphSize * 10, down = top + (int) graphSize
				* 20;
		if (e.getX() > left && e.getX() < right && e.getY() > top
				&& e.getY() < down) {
			entered = true;
			repaint();
		} else {
			entered = false;
			repaint();
		}
	}
}
