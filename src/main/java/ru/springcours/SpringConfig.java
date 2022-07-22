package ru.springcours;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration // заменяет файл applicationContext.xml
//@ComponentScan("ru.springcours") //Указываем пакет, который будем сканировать на наличие комментариев
// classpath: - файлы из папки resources
// Указываем файл из которого можем брать значения для DI
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
  // Если не указываем пакет для сканирования (ComponentScan) бинов с аннотациями,
  // то можем задать все бины вручную
  @Bean
  public ClassicalMusic classicalMusic() {
    return ClassicalMusic.getClassicalMusic();
  }

  @Bean
  public RockMusic rockMusic() {
    return new RockMusic ();
  }

  @Bean
  public List<Music> musics() {
    List<Music> musics = new ArrayList<>();
    musics.add(classicalMusic());
    musics.add(rockMusic());
    return musics;
  }

  @Bean
  public MusicPlayer musicPlayer() {
    return new MusicPlayer(musics());
  }

  @Bean
  public Computer computer() {
    return new Computer(musicPlayer());
  }

}
