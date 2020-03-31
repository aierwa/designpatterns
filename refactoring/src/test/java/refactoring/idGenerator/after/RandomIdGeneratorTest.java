package refactoring.idGenerator.after;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author xuxiang
 * @Date 2020/3/31
 */
public class RandomIdGeneratorTest {

    @Test
    public void generate() {
        RandomIdGenerator idGenerator = new RandomIdGenerator();
        System.out.println(idGenerator.generate());
        Assert.assertNotNull(idGenerator.generate());
    }
}