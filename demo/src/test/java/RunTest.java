
import com.easyjava.App;
import com.easyjava.entity.po.EmailCode;
import com.easyjava.entity.po.MyTable;

import com.easyjava.mapper.EmailCodeMapper;
import com.easyjava.mapper.MyTableMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class RunTest {
    @Resource
    private EmailCodeMapper mapper;
    @Resource
    private MyTableMapper mapper2;

    @Test
    public void run(){
        EmailCode emailCode = new EmailCode();
        emailCode.setEmail("asdfg");
        emailCode.setCode("r34t4");
        emailCode.setCreateTime(new Date());
        emailCode.setStatus(1);
        mapper.insert(emailCode);
    }
    @Test
    public void run2(){
        MyTable tableTest = new MyTable();
        tableTest.setName(4);
        tableTest.setMyId(3);
        Integer insert = mapper2.insert(tableTest);
        System.out.println("返回主键值："+tableTest.getMyId());
    }
}
