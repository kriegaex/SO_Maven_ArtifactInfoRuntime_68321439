package de.scrum_master.stackoverflow.q68321439.library;

import de.scrum_master.stackoverflow.q68321439.annotation.MavenModuleInfo;

public class LibraryClass {
  public void doSomething() {
    StackTraceElement callerStackTraceElement = new Exception().getStackTrace()[1];
    try {
      Class<?> callerClass = Class.forName(callerStackTraceElement.getClassName());
      MavenModuleInfo mavenModuleInfo = callerClass.getPackage().getAnnotation(MavenModuleInfo.class);
      System.out.println(mavenModuleInfo.groupId());
      System.out.println(mavenModuleInfo.artifactId());
      System.out.println(mavenModuleInfo.version());
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public void doSomethingJava9() {
    Class<?> callerClass = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
    MavenModuleInfo mavenModuleInfo = callerClass.getPackage().getAnnotation(MavenModuleInfo.class);
    System.out.println(mavenModuleInfo.groupId());
    System.out.println(mavenModuleInfo.artifactId());
    System.out.println(mavenModuleInfo.version());
  }

  public void doSomethingClassLoader() {
    StackTraceElement callerStackTraceElement = new Exception().getStackTrace()[1];
    try {
      Class<?> callerClass = Class.forName(callerStackTraceElement.getClassName());
      // Cheap way of getting Maven artifact name - TODO: parse
      System.out.println(
        callerClass
          .getClassLoader()
          .getResource(callerStackTraceElement.getClassName().replaceAll("[.]", "/") + ".class")
      );
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

}
