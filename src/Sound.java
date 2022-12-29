import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    final URL[] soundURL = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/game.wav");
        soundURL[1] = getClass().getResource("/menu.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void playMusic(int i) {
        this.setFile(i);
        this.play();
        this.loop();
    }

    public void stop() {
        clip.stop();
    }
}
