package xxl.mathematica.io.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumnName {
  /**
   * 列的名称
   *
   * @return
   */
  String value() default "";

  /**
   * 字段的排列顺序，越大越靠后
   *
   * @return
   */
  int order() default 0;
}
