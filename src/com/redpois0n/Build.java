package com.redpois0n;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

public class Build {

	public static final String infoFile = "files/Info.plist";
	public static final String launcherFile = "files/launcher";

	public static void build(File input, File output, File icon, String mainclass, String appTitle, boolean dockIcon, int minimumVersion) throws Exception {
		File basePath = new File(output.getAbsolutePath() + ".app", "/Contents");

		new File(basePath, "/MacOS").mkdirs();
		new File(basePath, "/Resources").mkdirs();

		File info = new File(basePath, "/Info.plist");
		File launcher = new File(basePath, "/MacOS/launcher");
		File jar = new File(basePath, "/MacOS/" + input.getName());

		File iconFile = new File(basePath + "/Resources/application.icns");

		launcher.createNewFile();

		if (icon.exists()) {
			copyFile(icon, iconFile);
		}
		
		copyLauncher(launcher, input.getName(), appTitle, dockIcon, minimumVersion);
	    
	    copyFile(new File(infoFile), info);
	    copyFile(input, jar);
	    
	    String chmod = "chmod +x " + launcher.getAbsolutePath();
	    Runtime.getRuntime().exec(new String[] { "/bin/bash", "-c", chmod });
	    
	}

	public static void copyFile(File input, File output) throws Exception {
		if (!output.getParentFile().exists()) {
			output.getParentFile().mkdirs();
		}
		FileChannel source = new FileInputStream(input).getChannel();
		FileChannel destination = new FileOutputStream(output).getChannel();
		destination.transferFrom(source, 0L, source.size());

		source.close();

		destination.close();

	}

	public static void copyLauncher(File launcherDest, String jarName, String appTitle, boolean showIcon, int minimumVersion) throws Exception {

		FileReader orig = new FileReader(launcherFile);

		FileWriter dest = new FileWriter(launcherDest.getAbsolutePath());

		BufferedReader br = null;
		PrintWriter pw = null;

		br = new BufferedReader(orig);
		pw = new PrintWriter(dest);

		int nline = 1;
		String line;
		while ((line = br.readLine()) != null) {
			if (nline == 6) {
				pw.println("JAVA_MINOR=" + minimumVersion);
			} else if (nline == 7) {
				pw.println("APP_JAR=\"" + jarName + "\"");
			} else if (nline == 8) {
				pw.println("APP_NAME=\"" + appTitle + "\"");
			} else if ((nline == 47) && showIcon) {
				pw.println("exec $_java $VM_ARGS -Dapple.laf.useScreenMenuBar=true -Dcom.apple.macos.use-file-dialog-packages=true -Dapple.awt.UIElement=true -Xdock:name=\"$APP_NAME\" -cp \".;$DIR;\" -jar \"$DIR/$APP_JAR\"");
			} else {
				pw.println(line);
			}
			nline++;
		}
		br.close();
		pw.close();

	}
}
