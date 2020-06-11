/**
 *  MicroEmulator
 *  Copyright (C) 2008 Bartek Teodorczyk <barteo@barteo.net>
 *  Copyright (C) 2008 Markus Heberling <markus@heberling.net>
 *
 *  It is licensed under the following two licenses as alternatives:
 *    1. GNU Lesser General Public License (the "LGPL") version 2.1 or any newer version
 *    2. Apache License (the "AL") Version 2.0
 *
 *  You may not use this file except in compliance with at least one of
 *  the above two licenses.
 *
 *  You may obtain a copy of the LGPL at
 *      http://www.gnu.org/licenses/old-licenses/lgpl-2.1.txt
 *
 *  You may obtain a copy of the AL at
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the LGPL or the AL for the specific language governing permissions and
 *  limitations.
 *
 *  @version $Id: IPhoneMutableImage.java 1966 2009-03-11 20:20:15Z tisoft $
 */
package org.microemu.iphone.device;

import javax.microedition.lcdui.Graphics;

import joc.Pointer;
import obc.CGColorSpace;
import obc.CGContext;
import obc.CGImage;

import org.microemu.device.MutableImage;

import straptease.CGImageAlphaInfo;
import straptease.CoreGraphics;
import straptease.CoreGraphicsConstants;

public class IPhoneMutableImage extends MutableImage implements IPhoneImage {

	private Pointer<CGContext> imageContext;
	private Pointer<CGColorSpace> colorSpace;
	private int width;
	private int height;
	private IPhoneDisplayGraphics displayGraphics;

	public IPhoneMutableImage(int width, int height) {
		this.width = width;
		this.height = height;
		colorSpace = CoreGraphics.CGColorSpaceCreateDeviceRGB();
		imageContext = CoreGraphics.CGBitmapContextCreate(null, width, height, 8, width * 4, colorSpace,
				CoreGraphicsConstants.kCGBitmapByteOrder32Little | CGImageAlphaInfo.kCGImageAlphaNoneSkipFirst);
		displayGraphics = new IPhoneDisplayGraphics(imageContext, getWidth(), getHeight(), true);
	}

	@Override
	public int[] getData() {
		throw new UnsupportedOperationException("Currently not supported on iPhone");
	}

	@Override
	public Graphics getGraphics() {
		return displayGraphics;
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	public Pointer<CGImage> getBitmap() {
		displayGraphics.flushRenderQueue();
		return CoreGraphics.CGBitmapContextCreateImage(imageContext);
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void getRGB(int[] argb, int offset, int scanlength, int x, int y, int width, int height) {

		if (width <= 0 || height <= 0)
			return;
		if (x < 0 || y < 0 || x + width > getWidth() || y + height > getHeight())
			throw new IllegalArgumentException("Specified area exceeds bounds of image");
		if ((scanlength < 0 ? -scanlength : scanlength) < width)
			throw new IllegalArgumentException("abs value of scanlength is less than width");
		if (argb == null)
			throw new NullPointerException("null rgbData");
		if (offset < 0 || offset + width > argb.length)
			throw new ArrayIndexOutOfBoundsException();
		if (scanlength < 0) {
			if (offset + scanlength * (height - 1) < 0)
				throw new ArrayIndexOutOfBoundsException();
		} else {
			if (offset + scanlength * (height - 1) + width > argb.length)
				throw new ArrayIndexOutOfBoundsException();
		}

//		throw new UnsupportedOperationException("Currently not supported on iPhone");

		// bitmap.getPixels(argb, offset, scanlength, x, y, width, height);

		/*
		 * for (int i = 0; i < argb.length; i++) { int a = (argb[i] &
		 * 0xFF000000); int b = (argb[i] & 0x00FF0000) >>> 16; int g = (argb[i]
		 * & 0x0000FF00) >>> 8; int r = (argb[i] & 0x000000FF);
		 * 
		 * argb[i] = a | (r << 16) | (g << 8) | b; }
		 */
	}

}
