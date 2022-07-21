package ru.springcours;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
  public static void main(String[] args) {
    // подтягиваем из зависимости spring-context
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );

    // указываем имя бина и класс, который будем реализовывать
    TestBean testBean = context.getBean("testBean", TestBean.class);

    System.out.println(testBean.getName());

    // обязательно закрывать контекст
    context.close();
  }
}
