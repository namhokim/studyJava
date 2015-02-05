package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)	//The annotation is saved in the*.class and can be used by the JVM.
@Target(value = ElementType.METHOD)			//The annotation can be used on methods.
public @interface PersonneName {
	public String name();
}

// Ayoub El Abbassi 's Blog
// How to add Annotations at Runtime to a java class method using Javassist? (Part 1 )
// http://ayoubelabbassi.blogspot.kr/2011/01/how-to-add-annotations-at-runtime-to.html

// Java bytecode
// http://www.ibm.com/developerworks/ibm/library/it-haggar_bytecode/