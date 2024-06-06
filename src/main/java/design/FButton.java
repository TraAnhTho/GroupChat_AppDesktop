package design;

/*
 *  Jangan lupa SUBSCRIBE https://www.youtube.com/@FOSALGO/videos
 *  Tetap Semangat...!!! Semua orang Bisa Belajar Coding
 *  Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *
 * @author AnhTho
 */
public class FButton extends JButton {

	private boolean over;
	private Color fill;
	private Color line;

	private Color fillOriginal;
	private Color fillOver;
	private Color fillClick;
	private Color lineOriginal;
	private Color lineOver;
	private int strokeWidth;

	public FButton() {
		fillOriginal = new Color(175, 215, 130);
		fillOver = new Color(41, 128, 185);
		fillClick = new Color(10, 75, 124);
		lineOriginal = new Color(236, 240, 241);
		lineOver = new Color(189, 195, 199);
		strokeWidth = 2;
		fill = fillOriginal;
		line = lineOriginal;
		setOpaque(false);
		setBorder(null);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBackground(fillOriginal);
		setForeground(Color.white);
		// tambahkan mouse event
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				fill = fillOriginal;
				line = lineOriginal;
				over = false;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				fill = fillOver;
				line = lineOver;
				over = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (over) {
					fill = fillOver;
					line = lineOver;
				} else {
					fill = fillOriginal;
					line = lineOriginal;
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				fill = fillClick;
			}

		});
	}

	public Color getFillOriginal() {
		return fillOriginal;
	}

	public void setFillOriginal(Color fillOriginal) {
		this.fillOriginal = fillOriginal;
	}

	public Color getFillOver() {
		return fillOver;
	}

	public void setFillOver(Color fillOver) {
		this.fillOver = fillOver;
	}

	public Color getFillClick() {
		return fillClick;
	}

	public void setFillClick(Color fillClick) {
		this.fillClick = fillClick;
	}

	public Color getLineOriginal() {
		return lineOriginal;
	}

	public void setLineOriginal(Color lineOriginal) {
		this.lineOriginal = lineOriginal;
	}

	public Color getLineOver() {
		return lineOver;
	}

	public void setLineOver(Color lineOver) {
		this.lineOver = lineOver;
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (!isOpaque()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			int s = strokeWidth;
			int w = getWidth() - (2 * s);
			int h = getHeight() - (2 * s);
			// gambar background
			g2d.setColor(fill);
			g2d.fillRoundRect(s, s, w, h, h, h);
			// gambar border
			g2d.setStroke(new BasicStroke(s));
			g2d.setColor(line);
			g2d.drawRoundRect(s, s, w, h, h, h);
		}
		super.paintComponent(g);
	}

}
