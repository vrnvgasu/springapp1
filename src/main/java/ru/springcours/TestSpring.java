package ru.springcours;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  public static void main(String[] args) {
    // подтягиваем из зависимости spring-context
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );

    // вызовем два раза бин со скоупом singltone / prototype
    MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
    MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
    // проверим, что 2 переменные ссылаются на один и тот же объект
    // singltone - true
    // prototype - false
    System.out.println(musicPlayer == secondMusicPlayer);


    // обязательно закрывать контекст
    context.close();
  }
}
