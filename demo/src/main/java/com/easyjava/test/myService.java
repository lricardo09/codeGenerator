package com.easyjava.test;
import com.easyjava.entity.po.FileInfo;
import com.easyjava.entity.query.FileInfoQuery;
import com.easyjava.mapper.FileInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@org.springframework.stereotype.Service
public class myService {
    @Resource
    FileInfoMapper fileInfoMapper;
    public List<FileInfo> select(){
        FileInfoQuery query = new FileInfoQuery();
        query.s
        fileInfoMapper.selectList()
    }
}
