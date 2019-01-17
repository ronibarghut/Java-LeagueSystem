package utils;

import java.io.File;
import java.util.Collection;
import java.util.Map;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Utility {
	static AudioInputStream sound;
	static DataLine.Info info;
	static Clip clip;
	public static void playSound(String fileName) {
		try {
			 sound = AudioSystem.getAudioInputStream(new File(fileName));
			// Load the sound into memory 
			info = new DataLine.Info(Clip.class, sound.getFormat());
		    clip = (Clip) AudioSystem.getLine(info);
			clip.open(sound);
			// play the sound 
			clip.start();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static void StopSound(String fileName) {
		try {
			sound.close();
			clip.close();
			clip.stop();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public static String getResultString(Collection<?> objList, String name) {
		String str = "";
		if(objList != null && objList.size() > 0) {
			for(Object obj: objList) {
				str += (obj + "\n\n");
			}
		}
		else {
			str += "No " + name + " were found in the system";
		}
		return str;
	}
	
	public static String getResultString(Map<?,?> objMap, String name) {
		String str = "";
		if(objMap != null && objMap.size() > 0) {
			for(Object obj: objMap.keySet()) {
				str += (obj + "\n");
				str += (objMap.get(obj) + "\n\n");
			}
		}
		else {
			str += "No " + name + " were found in the system";
		}
		return str;
	}
}
