package com.osho.common.images;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageResizerScalar {

	private static final int IMG_WIDTH = 200;

	private static final int IMG_HEIGHT = 100;

	public static BufferedImage convertToAnySize(String source) throws Exception
	{
		return ImageIO.read(new File(source));
	}
	
	public static BufferedImage convertWithAspectRatio(String source) throws Exception
	{
		// Fetch the image height and width (I'm hardcoding them here, if you don't know
		// how to get look at creatThumbnail method)
		BufferedImage image = ImageIO.read(new File("c:\\upload\\images\\test.jpg"));
		int imgWidth = image.getWidth();
		int imgHeight = image.getHeight();
		// Original size of the image is 
		int newWidth = 300;
		// Calculating the percentage of image width going to be reduced
		double imgHeightPercentage = (newWidth / (double) imgWidth) * 100;
		// Calculating the height based on the above percentage
		double imgTotalHeight = imgHeight * (imgHeightPercentage / 100);
		int newHeight = (int) Math.round(imgTotalHeight);
		return resizeImage("c:\\upload\\images\\test.jpg", "c:\\upload\\images\\aWater.jpg", newWidth, newHeight);
	}
	

	public static void main(String[] args) throws Exception 
	{
		try {
			BufferedImage originalImage = ImageIO.read(new File("c:\\upload\\images\\test.jpg"));
			int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

			BufferedImage resizeImageJpg = resizeImage(originalImage, type);
			ImageIO.write(resizeImageJpg, "jpg", new File("c:\\upload\\images\\mkyong_jpg.jpg"));

			BufferedImage resizeImagePng = resizeImage(originalImage, type);
			ImageIO.write(resizeImagePng, "png", new File("c:\\upload\\images\\mkyong_png.jpg"));

			BufferedImage resizeImageHintJpg = resizeImageWithHint(originalImage, type);
			ImageIO.write(resizeImageHintJpg, "jpg", new File("c:\\upload\\images\\mkyong_hint_jpg.jpg"));

			BufferedImage resizeImageHintPng = resizeImageWithHint(originalImage, type);
			ImageIO.write(resizeImageHintPng, "png", new File("c:\\upload\\images\\mkyong_hint_png.jpg"));

			imageResizer();

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	private static BufferedImage resizeImage(BufferedImage originalImage, int type) 
	{
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();

		return resizedImage;
	}

	private static BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) 
	{
		BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
		g.dispose();
		g.setComposite(AlphaComposite.Src);

		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		return resizedImage;
	}
	
	public static void createThumbnail(String sourceFile, String destFile,int newWidth, int newHeight) throws Exception
	{
		BufferedImage image = ImageIO.read(new File(sourceFile));
		int width = image.getWidth();
		int height = image.getHeight();

		boolean isTranslucent = image.getType() != Transparency.OPAQUE;

		if (newWidth >= width || newHeight >= height) {
			throw new IllegalArgumentException("newWidth and newHeight cannot be greater than the image dimensions");
		} else if (newWidth <= 0 || newHeight <= 0) {
			throw new IllegalArgumentException("newWidth and newHeight must be greater than 0");
		}

		BufferedImage thumb = image;
		BufferedImage temp = null;
		Graphics2D g2 = null;
		Map map = new HashMap();
		map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		try {
			int previousWidth = width;
			int previousHeight = height;
			do {
				if (width > newWidth) {
					width /= 2;
					if (width < newWidth) {
						width = newWidth;
					}
				}
				if (height > newHeight) {
					height /= 2;
					if (height < newHeight) {
						height = newHeight;
					}
				}
				if (temp == null || isTranslucent) {
					if (g2 != null) {
						// do not need to wrap with finally
						// outer finally block will ensure
						// that resources are properly reclaimed
						g2.dispose();
					}
					temp = createCompatibleImage(image, width, height);
					g2 = temp.createGraphics();
					g2.setRenderingHints(map);
					// g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				}
				g2.drawImage(thumb, 0, 0, width, height, 0, 0, previousWidth, previousHeight, null);
				previousWidth = width;
				previousHeight = height;
				thumb = temp;
			} while (width != newWidth || height != newHeight);
		} finally {
			g2.dispose();
		}
		if (width != thumb.getWidth() || height != thumb.getHeight()) {
			temp = createCompatibleImage(image, width, height);
			g2 = temp.createGraphics();
			try {
				g2.setRenderingHints(map);
				g2.drawImage(thumb, 0, 0, width, height, 0, 0, width, height, null);
			} finally {
				g2.dispose();
			}
			thumb = temp;
		}
		ImageIO.write(thumb, destFile.substring(destFile.lastIndexOf('.') + 1), new FileOutputStream(destFile));
	}
	
	
	 public static BufferedImage createCompatibleImage(BufferedImage image,int width, int height) 
	{
		return isHeadless() ? new BufferedImage(width, height, image.getType())
				: getGraphicsConfiguration().createCompatibleImage(width, height);
	}
	 
	 
	 // Returns the graphics configuration for the primary screen
	 private static GraphicsConfiguration getGraphicsConfiguration() 
	{
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
	}
	 
	 
	 private static boolean isHeadless()
	{
		return GraphicsEnvironment.isHeadless();
	}
	 
	 
	 public static void imageResizer() throws Exception
	{
		// Fetch the image height and width (I'm hardcoding them here, if you don't know
		// how to get look at creatThumbnail method)
		BufferedImage image = ImageIO.read(new File("c:\\upload\\images\\test.jpg"));
		int imgWidth = image.getWidth();
		int imgHeight = image.getHeight();
		// Original size of the image is
		int newWidth = 300;
		// Calculating the percentage of image width going to be reduced
		double imgHeightPercentage = (newWidth / (double) imgWidth) * 100;
		// Calculating the height based on the above percentage
		double imgTotalHeight = imgHeight * (imgHeightPercentage / 100);
		int newHeight = (int) Math.round(imgTotalHeight);
		createThumbnail("c:\\upload\\images\\test.jpg", "c:\\upload\\images\\aWater.jpg", newWidth, newHeight);
	}
	 
	public static BufferedImage resizeImage(String sourceFile, String destFile,int newWidth, int newHeight) throws Exception
	{
		BufferedImage image = ImageIO.read(new File(sourceFile));
		int width = image.getWidth();
		int height = image.getHeight();

		boolean isTranslucent = image.getType() != Transparency.OPAQUE;

		if (newWidth >= width || newHeight >= height) {
			throw new IllegalArgumentException("newWidth and newHeight cannot be greater than the image dimensions");
		} else if (newWidth <= 0 || newHeight <= 0) {
			throw new IllegalArgumentException("newWidth and newHeight must be greater than 0");
		}

		BufferedImage thumb = image;
		BufferedImage temp = null;
		Graphics2D g2 = null;
		Map map = new HashMap();
		map.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		map.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		map.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		try {
			int previousWidth = width;
			int previousHeight = height;
			do {
				if (width > newWidth) {
					width /= 2;
					if (width < newWidth) {
						width = newWidth;
					}
				}
				if (height > newHeight) {
					height /= 2;
					if (height < newHeight) {
						height = newHeight;
					}
				}
				if (temp == null || isTranslucent) {
					if (g2 != null) {
						// do not need to wrap with finally
						// outer finally block will ensure
						// that resources are properly reclaimed
						g2.dispose();
					}
					temp = createCompatibleImage(image, width, height);
					g2 = temp.createGraphics();
					g2.setRenderingHints(map);
					// g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
				}
				g2.drawImage(thumb, 0, 0, width, height, 0, 0, previousWidth, previousHeight, null);
				previousWidth = width;
				previousHeight = height;
				thumb = temp;
			} while (width != newWidth || height != newHeight);
		} finally {
			g2.dispose();
		}
		if (width != thumb.getWidth() || height != thumb.getHeight()) {
			temp = createCompatibleImage(image, width, height);
			g2 = temp.createGraphics();
			try {
				g2.setRenderingHints(map);
				g2.drawImage(thumb, 0, 0, width, height, 0, 0, width, height, null);
			} finally {
				g2.dispose();
			}
			 thumb = temp;
		}
		
		return thumb;
	}
	 

}
