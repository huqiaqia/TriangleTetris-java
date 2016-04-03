package TriangleTetris;

import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class TetrisMain extends Frame {
	
	Random rand = new Random();

	public static void main(String[] args) {
		new TetrisMain();
	}

	TetrisMain(){
		super("Triangle Tetris");
		
		addWindowListener(new WindowAdapter(){
			public void WindowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setSize (800,600);
		
		TetrisCanvas TC = new TetrisCanvas();
		add("Center", TC);
		
		int signal = TC.signal;
		TriangleShapes TS = new TriangleShapes();
		
		
		
		show();
	}}
