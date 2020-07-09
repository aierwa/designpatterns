package practice.ratelimiter;

import static org.junit.Assert.*;

/**
 * @author xuxiang
 */
public class RateLimiterTest {

    @org.junit.Test
    public void limit() {
        RateLimiter rateLimiter = new RateLimiter();
        for (int i = 0; i < 10; i++) {
            assertTrue(rateLimiter.limit("app-1", "/v1/order"));
        }
        assertFalse(rateLimiter.limit("app-1", "/v1/order"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(rateLimiter.limit("app-1", "/v1/order"));
        assertTrue(rateLimiter.limit("app-1", "/v1/order"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            assertTrue(rateLimiter.limit("app-1", "/v1/order"));
        }
    }
}