package ru.springcours;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  public static void main(String[] args) {
    // подтягиваем из зависимости spring-context
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );

    MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
    System.out.println(musicPlayer.getName());
    System.out.println(musicPlayer.getVolume());

    ClassicalMusic classicalMusic1 = context.getBean("classicalMusic", ClassicalMusic.class);
    ClassicalMusic classicalMusic2 = context.getBean("classicalMusic", ClassicalMusic.class);
    System.out.println(classicalMusic1 == classicalMusic2);

//    Computer computer = context.getBean("computer", Computer.class);
//    System.out.println(computer);

//    MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//    musicPlayer.playMusic();

//    Music music = context.getBean("musicBean", Music.class);
//    System.out.println(music.getSong());
//
//    Music music2 = context.getBean("classicalMusic", Music.class);
//    System.out.println(music2.getSong());

//    // отработаю методы init в начале (doMyInit()) и destroy (doMyDestroy()) в конце из контекста
//     ClassicalMusic classicalMusic = context.getBean("classicalMusicBean", ClassicalMusic.class);

//    // вызовем два раза бин со скоупом singltone / prototype
//    MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//    MusicPlayer secondMusicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
//    // проверим, что 2 переменные ссылаются на один и тот же объект
//    // singltone - true
//    // prototype - false
//    System.out.println(musicPlayer == secondMusicPlayer);


    // обязательно закрывать контекст
    context.close();
  }
}
