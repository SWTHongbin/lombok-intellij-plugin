package de.plushnikov.intellij.plugin.action.generate;

import com.intellij.codeInsight.generation.ClassMember;
import com.intellij.codeInsight.generation.GenerateConstructorHandler;
import com.intellij.codeInsight.generation.PsiFieldMember;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiModifier;

import java.util.ArrayList;

public class LombokGenerateConstructorHandler extends GenerateConstructorHandler {

  @Override
  protected ClassMember[] getAllOriginalMembers(PsiClass aClass) {
    PsiField[] fields = aClass.getFields();
    ArrayList<ClassMember> array = new ArrayList<>();
    for (PsiField field : fields) {
      if (field.hasModifierProperty(PsiModifier.STATIC)) continue;
      if (field.hasModifierProperty(PsiModifier.FINAL) && field.getInitializer() != null) continue;

      array.add(new PsiFieldMember(field));
    }
    return array.toArray(ClassMember.EMPTY_ARRAY);
  }

//  @Override
//  @NotNull
//  protected List<? extends GenerationInfo> generateMemberPrototypes(PsiClass aClass, ClassMember[] members) throws IncorrectOperationException {
//    final PsiClass proxyClass = proxying(aClass, PsiClass.class);
//
//    final List<? extends GenerationInfo> memberPrototypes = super.generateMemberPrototypes(proxyClass, members);
//
//    final List<GenerationInfo> result = new ArrayList<>();
//    for (GenerationInfo memberPrototype : memberPrototypes) {
//      result.add(new PsiGenerationInfo<>(memberPrototype.getPsiMember(), false));
//    }
//    return result;
//  }
//
//  @SuppressWarnings("unchecked")
//  private <T> T proxying(final T target, final Class<T> iface) {
//    return (T) Proxy.newProxyInstance(
//      iface.getClassLoader(),
//      new Class<?>[]{iface},
//      new InvocationHandler() {
//        @Override
//        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//          final Object originalResult = method.invoke(target, args);
//          if (method.getName().equals("findMethodBySignature")) {
//            if (originalResult instanceof LombokLightMethodBuilder) {
//              return null;
//            }
//          }
//          return originalResult;
//        }
//      });
//  }
}
