package practice.basic;

import java.lang.annotation.*;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
@SuppressWarnings("1111")
@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="160101",hhmmss="235959"))
public class Annotation_Practice {
	public static void main(String[] args) {

		Class<Annotation_Practice> cls = Annotation_Practice.class;
		
		TestInfo anno = (TestInfo) cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy()=" + anno.testedBy());
		System.out.println("anno.testDate().yymmdd()=" + anno.testDate().yymmdd());
		System.out.println("aanno.testDate().hhmmss()=" + anno.testDate().hhmmss());
		
		for(String str: anno.testTools())
			System.out.println("testTools="+str);
		System.out.println();
		
		Annotation[] annArr = cls.getAnnotations();
		for(Annotation a : annArr)
			System.out.println(a);
		
		
		

	}

}

@Retention (RetentionPolicy.RUNTIME)
@interface TestInfo{
	int count()			default 1;
	String testedBy();
	String[] testTools() default "Junit";
	TestType testType()	default TestType.FIRST;
	DateTime testDate();
}

@Retention (RetentionPolicy.RUNTIME)
@interface DateTime{
	String yymmdd();
	String hhmmss();
}
enum TestType {FIRST, FINAL }