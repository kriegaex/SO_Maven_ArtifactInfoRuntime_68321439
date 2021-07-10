package de.scrum_master.stackoverflow.q68321439.application;

import de.scrum_master.stackoverflow.q68321439.annotation.MavenModuleInfo;
import de.scrum_master.stackoverflow.q68321439.library.LibraryClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ModuleInfoTest {
  @Test
  public void test() {
    String groupId = "de.scrum-master.stackoverflow.q68321439";

    MavenModuleInfo libMavenInfo = logAndGetMavenModuleInfo("Library Maven info", LibraryClass.class.getPackage());
    assertEquals(groupId, libMavenInfo.groupId());
    assertEquals("library", libMavenInfo.artifactId());

    MavenModuleInfo appMavenInfo = logAndGetMavenModuleInfo("Application Maven info", Application.class.getPackage());
    assertEquals(groupId, appMavenInfo.groupId());
    assertEquals("application", appMavenInfo.artifactId());
  }

  private MavenModuleInfo logAndGetMavenModuleInfo(String message, Package aPackage) {
    MavenModuleInfo moduleInfo = aPackage.getAnnotation(MavenModuleInfo.class);
    System.out.println(message);
    System.out.println("  " + moduleInfo.groupId());
    System.out.println("  " + moduleInfo.artifactId());
    System.out.println("  " + moduleInfo.version());
    return moduleInfo;
  }
}
