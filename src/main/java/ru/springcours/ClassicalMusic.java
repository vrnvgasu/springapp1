package ru.springcours;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype") // по умолчанию задан singleton
public class ClassicalMusic implements Music {
  // ограничем создание объект через new
  private ClassicalMusic() {}

  // добавим фабричный метод
  public static ClassicalMusic getClassicalMusic() {
    System.out.println("Doing factory-method getClassicalMusic");
    return new ClassicalMusic();
  }

  // Будем использовать метод, как init-method. Можем дать любое название
  @PostConstruct
  public void doMyInit() {
    System.out.println("Doing ClassicalMusic initialization");
  }

  // Будем использовать метод, как destroy-method. Можем дать любое название
  @PreDestroy // не работает для скоупа prototype
  public void doMyDestroy() {
    System.out.println("Doing ClassicalMusic destruction ");
  }

  @Override
  public String getSong() {
    return "Hungarian Rhapsody ";
  }
}
