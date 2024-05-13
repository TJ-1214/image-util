package org.image.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

import io.image.util.CompressionQuality;
import io.image.util.ImageUtil;

public class CompressionTest {

	
	@Test
	public void compressPNG() throws IOException {
		
		 String path = "/home/tant/Downloads/setup.png";
			File file = new File(path);

			FileInputStream imageRaw = new FileInputStream(file);
			
			
			byte[] rawData = imageRaw.readAllBytes();
			byte[] compressedData = compress(rawData,CompressionQuality.MEDIUM_COMPRESSED);
			
			System.out.println("raw size: "+ rawData.length);
			System.out.println("compressed size: "+ compressedData.length );

			assertTrue(compressedData.length<rawData.length);
		
		
	}
	
	@Test
	public void compressJPG() throws IOException
	{
		 String path = "/home/tant/Downloads/gv_test_1.jpg";
			File file = new File(path);

			FileInputStream imageRaw = new FileInputStream(file);
			
			
			byte[] rawData = imageRaw.readAllBytes();
			byte[] compressedData = compress(rawData);
			
			System.out.println("raw size: "+ rawData.length);
			System.out.println("compressed size: "+ compressedData.length );

			assertTrue(compressedData.length<rawData.length);
		 
	}
	
	@Test
	public void compressGIF() throws IOException
	{
		 String path = "/home/tant/Downloads/test.gif";
			File file = new File(path);

			FileInputStream imageRaw = new FileInputStream(file);
			
			
			byte[] rawData = imageRaw.readAllBytes();
			byte[] compressedData = compress(rawData);
			
			System.out.println("raw size: "+ rawData.length);
			System.out.println("compressed size: "+ compressedData.length );

			assertTrue(compressedData.length<rawData.length);
		 
	}
	
	@Test
	public void compressBMP() throws IOException
	{
		 String path = "/home/tant/Downloads/test.bmp";
			File file = new File(path);

			FileInputStream imageRaw = new FileInputStream(file);
			
			
			byte[] rawData = imageRaw.readAllBytes();
			byte[] compressedData = compress(rawData);
			
			System.out.println("raw size: "+ rawData.length);
			System.out.println("compressed size: "+ compressedData.length );

			assertTrue(compressedData.length<rawData.length);
		 
	}


	private byte[] compress(String path) throws IOException {
		File file = new File(path);

		FileInputStream imageRaw = new FileInputStream(file);

		return ImageUtil.compress(imageRaw.readAllBytes());

	}
	
	private byte[] compress(String path, CompressionQuality quality) throws IOException {
		File file = new File(path);

		FileInputStream imageRaw = new FileInputStream(file);

		return ImageUtil.compress(imageRaw.readAllBytes(),quality);

	}
	
	private byte[] compress(byte[] data) throws IOException {


		return ImageUtil.compress(data);

	}
	private byte[] compress(byte[] data, CompressionQuality quality) throws IOException {


		return ImageUtil.compress(data,quality);

	}
	
	
}
