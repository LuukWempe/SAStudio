package com.stedin.HighVoltage.model;

import java.io.File;

import javax.swing.JFileChooser;

public class FileManager{
	
	public static void importIO() {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int returnValue = fc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = new File(fc.getSelectedFile().getAbsolutePath());	
			System.out.println(file.getName());
		}
	}	
}

