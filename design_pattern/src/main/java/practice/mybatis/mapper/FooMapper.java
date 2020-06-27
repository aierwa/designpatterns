package practice.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import practice.mybatis.dto.MessageDto;

import java.util.List;

/**
 * @author xuxiang
 */
//@Mapper // 可以在启动类上加 @MapperScan("practice.mybatis.mapper") 统一扫描
@Repository // 只是显式的声明一个 bean，以免 spring 提示找不到 bean，不要也行的
public interface FooMapper {
    List<MessageDto> selectAll();
}
