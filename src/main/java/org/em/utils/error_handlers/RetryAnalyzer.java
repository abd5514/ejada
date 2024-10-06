package org.em.utils.error_handlers;

import org.em.utils.PropReader;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;




public class RetryAnalyzer implements IRetryAnalyzer {

    private final ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 0);

    private static final int maxTry =getRetryCount() ;

    private static final int DEFAULT_VALUE = 1;

    @Override
    public synchronized boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (count.get() < maxTry) {
                count.set(count.get() + 1);
                result.setStatus(ITestResult.FAILURE);
                Logger.info (("Now going to retry " + result.getMethod().getMethodName()));
                Logger.info (("Retry count is " + count.get ().toString ()));
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
                count.set(0);
                Logger.info (("Reset the retry count for " + result.getMethod().getMethodName()));
            }
        } else {
            System.out.println ("is it sucessss");
            result.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }



    private static int getRetryCount() {
        int number;
        try {
            number = Integer.parseInt(PropReader.readConfig("retry-count"));
            return number;
        } catch (Exception e) {
            return DEFAULT_VALUE;
        }
    }
}