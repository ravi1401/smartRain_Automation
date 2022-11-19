package com.lib;

import org.testng.IMethodInterceptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.IMethodInstance;
import org.testng.ITestContext;
import org.testng.ITestNGListener;
import org.testng.annotations.Test;

public class PriorityInterceptor implements IMethodInterceptor{
	

	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		List<IMethodInstance> result = new ArrayList<IMethodInstance>();
		for (IMethodInstance method : methods) {
			Test testMethod = method.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Test.class);
			Set<String> groups = new HashSet<String>();
			 for (String group : testMethod.groups()) {
			      groups.add(group);
			    }
			if (testMethod.priority() == 1 && groups.contains("regression")) {
				result.add(method);
			}
		}
		return result;
	}

}
