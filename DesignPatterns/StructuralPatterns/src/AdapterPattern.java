import java.nio.file.AccessDeniedException;


interface MediaPlayer {
  public void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
  public void playVlc(String fileName);

  public void playMP4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
  @Override
  public void playVlc(String fileName) {
    System.out.println("Playing vlc file. Name : " + fileName);
  }

  @Override
  public void playMP4(String fileName) {
    //do nothing
  }
}

class MP4Player implements AdvancedMediaPlayer {

  @Override
  public void playVlc(String fileName) {
    //do nothing
  }

  @Override
  public void playMP4(String fileName) {
    System.out.println("Playing mp4 file. Name : " + fileName);
  }
}

//Create adapter class implementing the MediaPlayer interface.
class MediaAdapter implements MediaPlayer {
  AdvancedMediaPlayer advancedMediaPlayer;

  public MediaAdapter(String audioType) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMediaPlayer = new VlcPlayer();
    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMediaPlayer = new MP4Player();
    }
  }

  @Override
  public void play(String audioType, String fileName) {
    if (audioType.equalsIgnoreCase("vlc")) {
      advancedMediaPlayer.playVlc(fileName);
    } else if (audioType.equalsIgnoreCase("mp4")) {
      advancedMediaPlayer.playMP4(fileName);
    }
  }
}

class AudioPlayer implements MediaPlayer {

  MediaAdapter mediaAdapter;

  @Override
  public void play(String audioType, String fileName) {
    //inbuilt support to play mp3 music files
    if (audioType.equalsIgnoreCase("mp3")) {
      System.out.println("Playing mp3 file. Name: " + fileName);
    } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
      mediaAdapter = new MediaAdapter(audioType);
      mediaAdapter.play(audioType, fileName);
    } else {
      throw new IllegalArgumentException("burkash");
    }
  }
}

public class AdapterPattern {
  public static void main(String[] args) {
    AudioPlayer audioPlayer = new AudioPlayer();
    audioPlayer.play("mp3", "default");
    audioPlayer.play(("Mp4"), "Aideeeee gurciii");
    audioPlayer.play("VlC", "koi slusha vlc e batko");
    audioPlayer.play("chalga", "udriii");

  }
}
