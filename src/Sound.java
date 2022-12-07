import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

class Sound{

    public void Play(String location){
        try{
            File musicPath = new File(location);
            if(musicPath.exists()){
                AudioInputStream audioInput= AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            }
            else{
                System.out.println("File not found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
