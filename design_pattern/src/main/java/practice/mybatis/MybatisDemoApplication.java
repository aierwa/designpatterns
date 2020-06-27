package practice.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import practice.mybatis.mapper.FooMapper;

/**
 * @author xuxiang
 */
@SpringBootApplication
@MapperScan("practice.mybatis.mapper")
public class MybatisDemoApplication implements ApplicationRunner {
    private FooMapper fooMapper;

    @Autowired
    public void setFooMapper(FooMapper fooMapper) {
        this.fooMapper = fooMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemoApplication.class, args);
    }

    public void run(ApplicationArguments args) throws Exception {
        fooMapper.selectAll().forEach(System.out::println);
    }
}
