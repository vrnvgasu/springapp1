package ru.springcours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
//  @Autowired // DI для поля через рефлексию
//  @Qualifier("classicalMusic") // 2 бина отвечают интерфейсу Music. Убираем неоднозначность
//  private Music music;

  private Music music1;
  private Music music2;

  // IoC
  @Autowired // ищет подходящие бины
  // @Qualifier явно указываем бины при неоднозначности
  public MusicPlayer(@Qualifier("musicBean") Music music1,
                     @Qualifier("classicalMusic") Music music2) {
    this.music1 = music1;
    this.music2 = music2;
  }

//  @Autowired // ищет подходящие бины по интерфейсу Music для сеттера
//  public void setMusic(Music music) {
//    this.music = music;
//  }

  public String playMusic() {
    return music1.getSong() + "; \n" + music2.getSong();
  }
}
