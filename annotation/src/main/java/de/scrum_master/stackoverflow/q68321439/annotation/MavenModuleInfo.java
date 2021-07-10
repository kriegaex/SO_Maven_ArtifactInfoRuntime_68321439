package de.scrum_master.stackoverflow.q68321439.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PACKAGE)
public @interface MavenModuleInfo {
  String groupId();
  String artifactId();
  String version();
}
