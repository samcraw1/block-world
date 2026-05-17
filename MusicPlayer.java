import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MusicPlayer {

    private Clip clip;

    public MusicPlayer(String filePath) {
        File file = new File(filePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("The specified audio file is not supported.");
        } catch (FileNotFoundException e) {
            System.out.println("The specified audio file was not found.");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource.");
        } catch (IOException e) {
            System.out.println("Something went wrong while trying to play the audio file.");
        }
    }

    public void loadSong(String filePath) {
        if (clip != null) {
            clip.close();
        }
        File file = new File(filePath);
        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {
            clip = AudioSystem.getClip();
            clip.open(audioStream);
        } catch (UnsupportedAudioFileException e) {
            System.out.println("The specified audio file is not supported.");
        } catch (FileNotFoundException e) {
            System.out.println("The specified audio file was not found.");
        } catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource.");
        } catch (IOException e) {
            System.out.println("Something went wrong while trying to play the audio file.");
        }
    }

    public void play()  { clip.start(); }
    public void loop()  { clip.loop(Clip.LOOP_CONTINUOUSLY); }
    public void stop()  { clip.stop(); }
    public void reset() { clip.setMicrosecondPosition(0); }
    public void close() { clip.close(); }
}

