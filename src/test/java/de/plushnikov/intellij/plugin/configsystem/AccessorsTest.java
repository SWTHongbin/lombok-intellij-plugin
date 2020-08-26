package de.plushnikov.intellij.plugin.configsystem;

/**
 * Unit tests for IntelliJPlugin for Lombok with activated config system
 */
public class AccessorsTest extends AbstractLombokConfigSystemTestCase {

  protected boolean shouldCompareAnnotations() {
    return true;
  }

  @Override
  protected String getBasePath() {
    return super.getBasePath() + "/configsystem/accessors";
  }

  public void testChain$GetterSetterFieldTest() {
    doTest();
  }

  public void testChain$GetterSetterFieldAnnotationOverwriteTest() {
    doTest();
  }

  public void testChain$GetterSetterClassTest() {
    doTest();
  }

  public void testChain$GetterSetterClassAnnotationOverwriteTest() {
    doTest();
  }

  public void testChain$GetterSetterWithoutAccessorsAnnotationTest() {
    doTest();
  }

  ////////////

  public void testFluent$GetterSetterFieldTest() {
    doTest();
  }

  public void testFluent$GetterSetterFieldAnnotationOverwriteTest() {
    doTest();
  }

  public void testFluent$GetterSetterClassTest() {
    doTest();
  }

  public void testFluent$GetterSetterClassAnnotationOverwriteTest() {
    doTest();
  }

  public void testFluent$GetterSetterWithoutAccessorsAnnotationTest() {
    doTest();
  }

  ////////////

  public void testPrefix$GetterSetterClassTest() {
    doTest();
  }

  public void testPrefix$GetterSetterWithoutAccessorsAnnotationClassTest() {
    doTest();
  }

  ////////////

  public void testSuperbuilder$SuperBuilderWithPrefixes() {
    doTest();
  }
}
