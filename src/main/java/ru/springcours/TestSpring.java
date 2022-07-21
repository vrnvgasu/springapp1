package ru.springcours;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  public static void main(String[] args) {
    // подтягиваем из зависимости spring-context
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );

    // указываем имя бина и класс, который будем реализовывать
    Music music = context.getBean("musicBean", Music.class);  // указали общий интерфейс Music

    // выполним DI вручную
    MusicPlayer musicPlayer = new MusicPlayer(music);
    musicPlayer.playMusic();

    // обязательно закрывать контекст
    context.close();
  }
}
