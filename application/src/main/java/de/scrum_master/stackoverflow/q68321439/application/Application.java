package de.scrum_master.stackoverflow.q68321439.application;

public class Application {
 // public static void main(String[] args) {}
  
  //adding common function which will be called by other projects by adding this module jar as the dependency.
  public void mavenModule(){
    MavenModuleInfo moduleInfo = getClass().getPackage().getAnnotation(MavenModuleInfo.class);
    System.out.println(""+moduleInfo.groupId());
    System.out.println(""+moduleInfo.artifactId());
    
  }
  
}
