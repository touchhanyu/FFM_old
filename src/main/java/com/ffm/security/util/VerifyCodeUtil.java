package com.ffm.security.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class VerifyCodeUtil {
	private static int WIDTH = 115;
	private static int HEIGHT = 34;
	private static int LINENUM = 20;// 干扰线个数
	private static int NUMCOUNT = 4;// 验证码字符个数
	private static String IMAGETYPE = "png";
	private static Color[] COLORS = new Color[] { Color.red, Color.orange, Color.yellow, Color.green, Color.blue,
			Color.cyan, Color.magenta, Color.black };

	public static String generate(OutputStream os) {
		BufferedImage bi = new BufferedImage(VerifyCodeUtil.WIDTH, VerifyCodeUtil.HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bi.getGraphics();
		graphics.setColor(Color.lightGray);
		graphics.fillRect(0, 0, VerifyCodeUtil.WIDTH, VerifyCodeUtil.HEIGHT);
		graphics.setFont(new Font("Consolas", Font.BOLD, 30));
		Random random = new Random();
		for (int i = 0; i < VerifyCodeUtil.LINENUM; i++) {
			graphics.setColor(COLORS[random.nextInt(COLORS.length)]);
			int w = random.nextInt(WIDTH);
			int h = random.nextInt(HEIGHT);
			int x = random.nextInt(25);
			int y = random.nextInt(25);
			int a = random.nextBoolean() ? 1 : -1;
			int b = random.nextBoolean() ? 1 : -1;
			graphics.drawLine(w, h, w + a * x, h + b * y);
		}
		String code = "";
		for (int i = 0; i < VerifyCodeUtil.NUMCOUNT; i++) {
			String str = VerifyCodeUtil.randomCode();
			graphics.setColor(VerifyCodeUtil.COLORS[random.nextInt(VerifyCodeUtil.COLORS.length)]);
			int a = random.nextInt(15);
			int b = random.nextInt(5);
			graphics.drawString(str, i * VerifyCodeUtil.WIDTH / 4 + a, VerifyCodeUtil.HEIGHT - VerifyCodeUtil.HEIGHT / 3 + b);
			code += str;
		}
		graphics.dispose();
		try {
			ImageIO.write(bi, VerifyCodeUtil.IMAGETYPE, os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}

	public static String randomCode() {
		Random random = new Random();
		String code = "";
		while (true) {
			int i = random.nextInt(122);
			if ((i >= 48 && i <= 57) || (i >= 65 && i <= 90) || i >= 97) {
				char c = (char) i;
				code = String.valueOf(c);
				break;
			}
		}
		return code;
	}
}