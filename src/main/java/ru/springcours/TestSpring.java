package ru.springcours;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  public static void main(String[] args) {
    // подтягиваем из зависимости spring-context
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );

    // выполним DI music в musicPlayer через контекст
    MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
    musicPlayer.playMusic();

    // обязательно закрывать контекст
    context.close();
  }
}
