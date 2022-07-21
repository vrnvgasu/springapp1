package ru.springcours;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
//  private Music music;
  private List<Music> musics = new ArrayList<>();
  private String name;
  private int volume;

  public MusicPlayer() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  // IoC
  public MusicPlayer(List<Music> musics) {
    this.musics = musics;
  }

  public void setMusic(List<Music> musics) {
    this.musics = musics;
  }

  public void playMusic() {
    for (Music music: this.musics) {
      System.out.println("Play: " + music.getSong());
    }
  }
}
