package ru.springcours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
public class MusicPlayer {

  //DI значения из ресурса
  @Value("${musicPlayer.name}")
  private String name;
  @Value("${musicPlayer.volume}")
  private int volume;

  private List<Music> musics;

  public String getName() {
    return name;
  }

  public int getVolume() {
    return volume;
  }

  // IoC
//  @Autowired // ищет подходящие бины
  // @Qualifier явно указываем бины при неоднозначности
  public MusicPlayer(List<Music> musics) {
    this.musics = musics;
  }

  public String playMusic() {
    StringBuilder result = new StringBuilder();
    for (Music music: musics) {
      result.append(music).append("/n");
    }
    return result.toString();
  }
}
