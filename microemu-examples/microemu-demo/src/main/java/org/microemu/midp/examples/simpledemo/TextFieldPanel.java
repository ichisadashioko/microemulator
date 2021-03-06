/**
 *  MicroEmulator
 *  Copyright (C) 2001-2007 Bartek Teodorczyk <barteo@barteo.net>
 *  Copyright (C) 2006-2007 Vlad Skarzhevskyy
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
 *  @version $Id: TextFieldPanel.java 1605 2008-02-25 21:07:14Z barteo $
 */
package org.microemu.midp.examples.simpledemo;

import javax.microedition.lcdui.TextField;

public class TextFieldPanel extends BaseExamplesForm {

	TextField textBoxes[] = { new TextField("Any character", null, 128, TextField.ANY),
			new TextField("Email", null, 128, TextField.EMAILADDR),
			new TextField("Numeric", null, 128, TextField.NUMERIC),
			new TextField("Phone number", null, 128, TextField.PHONENUMBER),
			new TextField("URL", null, 128, TextField.URL),
			new TextField("Decimal", null, 128, TextField.DECIMAL),
			new TextField("Password", null, 128, TextField.PASSWORD), };

	public TextFieldPanel() {
		super("TextField");

		append("Ala ma kota");
		for (int i = 0; i < textBoxes.length; i++) {
			//textBoxes[i].addCommand(backCommand);
			//textBoxes[i].setCommandListener(this);
			append(textBoxes[i]);
		}

	}
}
