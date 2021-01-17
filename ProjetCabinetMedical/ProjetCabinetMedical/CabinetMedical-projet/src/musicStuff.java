

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class musicStuff {
	private static Clip  clip;
	public static  void playMusic(String musicLocation) {
		
		try {
			File musicPath = new File(musicLocation);
			if(musicPath.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip= AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				
				//JOptionPane.showMessageDialog(null, "trgnwdnfn");

			}else {
				JOptionPane.showMessageDialog(null, "Le fichier du son est perdu...");

			}
			
		}catch(Exception e ) {
			JOptionPane.showMessageDialog(null, "EROOR PLAYING");
		}
	
	
	
	}
	public static  void StopMusic() {
		clip.stop();
	}
	public static Clip getClip() {
		return clip;
	}

}
