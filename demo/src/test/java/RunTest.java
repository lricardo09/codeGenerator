
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
import java.util.ArrayList;
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
        tableTest.setAB(666666);
        tableTest.setIOrU("ccc");//un
        tableTest.setName(4);
        tableTest.setMyId(80);//un
        tableTest.setYy("yyyyyyy");
        Integer insert = mapper2.insertOrUpdate(tableTest);
        System.out.println("返回主键值："+tableTest.getMyId());
    }
    @Test
    public void insertBatch(){
        MyTable tableTest = new MyTable();
        MyTable tableTest2 = new MyTable();
        ArrayList<MyTable> list = new ArrayList<>();

        tableTest.setAB(111);
        tableTest.setIOrU("111");//un
        //tableTest.setName(111);
        tableTest.setMyId(111);//un
        tableTest.setYy("111");
        list.add(tableTest);

        tableTest2.setAB(222);
        tableTest2.setIOrU("222");//un
        tableTest2.setName(222);
        tableTest2.setMyId(222);//un
        tableTest2.setYy("222");
        list.add(tableTest2);
        Integer insert = mapper2.insertBatch(list);
        System.out.println("返回主键值："+tableTest.getMyId());
    }
}
