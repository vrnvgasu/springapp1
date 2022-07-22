package ru.springcours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

  //DI значения из ресурса
  @Value("${musicPlayer.name}")
  private String name;
  @Value("${musicPlayer.volume}")
  private int volume;

  private Music music1;
  private Music music2;

  public String getName() {
    return name;
  }

  public int getVolume() {
    return volume;
  }

  // IoC
  @Autowired // ищет подходящие бины
  // @Qualifier явно указываем бины при неоднозначности
  public MusicPlayer(@Qualifier("musicBean") Music music1,
                     @Qualifier("classicalMusic") Music music2) {
    this.music1 = music1;
    this.music2 = music2;
  }

  public String playMusic() {
    return music1.getSong() + "; \n" + music2.getSong();
  }
}
