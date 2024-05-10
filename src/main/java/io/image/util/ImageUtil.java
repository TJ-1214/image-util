package io.image.util;

public class ImageUtil {

/**
 * 
 * @param data byte arrays
 * @return Format enum
 */
	
	public static Format format(byte[] data) {

		if (data.length >= 2 && data[0] == (byte) 0xFF && data[1] == (byte) 0xD8) {
			return Format.JPEG;
		}
		if (data.length >= 8 && data[0] == (byte) 0x89 && data[1] == (byte) 0x50 && data[2] == (byte) 0x4E
				&& data[3] == (byte) 0x47 && data[4] == (byte) 0x0D && data[5] == (byte) 0x0A && data[6] == (byte) 0x1A
				&& data[7] == (byte) 0x0A) {
			return Format.PNG;
		}

		if (data.length >= 2 && data[0] == 0x42 && data[1] == 0x4D) {
			return Format.BMP;
		}

		if (data.length >= 6 && data[0] == 0x47 && data[1] == 0x49 && data[2] == 0x46 && data[3] == 0x38
				&& data[5] == 0x61 && (data[4] == 0x37 || data[4] == 0x39)) {
			return Format.GIF;
		}

		if (data.length >= 4 && data[0] == 0x49 && data[1] == 0x49 && data[2] == 0x2A && data[3] == 0x00
				|| data[0] == 0x4D && data[1] == 0x4D && data[2] == 0x00 && data[3] == 0x2A) {
			return Format.TIFF;
		}
		return Format.UNKNOWN;
	}
	
}
