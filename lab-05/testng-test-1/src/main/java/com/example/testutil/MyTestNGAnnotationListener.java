package com.example.testutil;

import org.testng.*;

/**
 * The listener interface for receiving MyTestNGAnnotation events.
 * The Listener can be automatically invoked when TestNG tests are run by using ServiceLoader mechanism.
 * You can also add this listener to a TestNG Test class by adding
 * <code>@Listeners({com.amareshp.annotations.MyTestNGAnnotationListener.class})</code>
 * before the test class
 *
 * @see MyTestNGAnnotation
 */
public class MyTestNGAnnotationListener implements IInvokedMethodListener, ITestListener, ISuiteListener {
    
    String name = null;
    String city = null;
    String state = null;
    boolean testSuccess = true;
    
    
    /* (non-Javadoc)
     * @see org.testng.IInvokedMethodListener#beforeInvocation(org.testng.IInvokedMethod, org.testng.ITestResult)
     */
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod() && annotationPresent(method, MyTestNGAnnotation.class) ) {
            System.out.println("This gets invoked before every TestNG Test that has @MyTestNGAnnotation Annotation...");
            System.out.println("Name: " + name + " City: " + city + " State: " + state);
        }
    }

    
    private boolean annotationPresent(IInvokedMethod method, Class clazz) {
        boolean retVal = method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz) ? true : false;
        return retVal;
    }
    
    /* (non-Javadoc)
     * @see org.testng.IInvokedMethodListener#afterInvocation(org.testng.IInvokedMethod, org.testng.ITestResult)
     */
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) {
            if(method.getClass().isAnnotationPresent(MyTestNGAnnotation.class)) {
                System.out.println("This gets invoked after every TestNG Test that has @MyTestNGAnnotation Annotation...");
            }
            if( !testSuccess ) {
                testResult.setStatus(ITestResult.FAILURE);
            }
        }
    }

    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        
    }

    public void onStart(ITestContext context) {
        context.setAttribute("name", "serdar");
        context.setAttribute("city", city);

        for(ITestNGMethod m1 : context.getAllTestMethods()) {
            if(m1.getConstructorOrMethod().getMethod().isAnnotationPresent(MyTestNGAnnotation.class)) {
                //capture metadata information.
                name = m1.getConstructorOrMethod().getMethod().getAnnotation(MyTestNGAnnotation.class).name();
                city = m1.getConstructorOrMethod().getMethod().getAnnotation(MyTestNGAnnotation.class).city();
                state = m1.getConstructorOrMethod().getMethod().getAnnotation(MyTestNGAnnotation.class).state();

            }
        }
        
    }

    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        
    }


    @Override
    public void onStart(ISuite iSuite) {
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }
}