package ru.springcours;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
  @Autowired // DI для поля через рефлексию
  private Music music;

  public MusicPlayer() {
  }

  // IoC
//  @Autowired // ищет подходящие бины
//  public MusicPlayer(Music music) {
//    this.music = music;
//  }

//  @Autowired // ищет подходящие бины по интерфейсу Music для сеттера
//  public void setMusic(Music music) {
//    this.music = music;
//  }

  public String playMusic() {
    return music.getSong();
  }
}
