package de.scrum_master.stackoverflow.q68321439.application;

import de.scrum_master.stackoverflow.q68321439.library.LibraryClass;

public class Application {
  public static void main(String[] args) {
    new LibraryClass().doSomething();
    System.out.println();
    new LibraryClass().doSomethingJava9();
    System.out.println();
    new LibraryClass().doSomethingClassLoader();
  }
}
