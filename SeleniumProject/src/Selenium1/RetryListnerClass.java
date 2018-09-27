package Selenium1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListnerClass implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
			Method testMethod) {

		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		testannotation.setRetryAnalyzer(RetryFailedTestCase.class);
   }

}