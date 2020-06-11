/**
 *  MicroEmulator
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
 *  @version $Id: IPhoneAlertUI.java 1897 2009-01-07 14:29:01Z tisoft $
 */
package org.microemu.iphone.device.ui;

import javax.microedition.lcdui.Alert;

import obc.UIAlertView;

import org.microemu.device.ui.AlertUI;
import org.microemu.iphone.MicroEmulator;

public class IPhoneAlertUI extends AbstractUI<Alert> implements AlertUI {
	public IPhoneAlertUI(MicroEmulator microEmulator, Alert alert) {
		super(microEmulator, alert);
	}

	public void setString(String str) {
		// TODO Auto-generated method stub

	}

	public void hideNotify() {
		// TODO Auto-generated method stub

	}

	public void invalidate() {
		// TODO Auto-generated method stub

	}

	public void showNotify() {
			UIAlertView alertView=new UIAlertView().initWithTitle$message$delegate$cancelButtonTitle$otherButtonTitles$(displayable.getTitle(), displayable.getString(), null, "Abbrechen", null);
	
	alertView.show();
	alertView.release();
	
	commandListener.commandAction(Alert.DISMISS_COMMAND, displayable);
	}

}
