package com.murphy.service;

import com.murphy.entity.BillType;
import com.murphy.mapper.TypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账单类型 - Service
 *
 * @author murphy
 * @since 2021/8/16 9:42 下午
 */
@Service
public class TypeService {

    @Resource
    private TypeMapper typeMapper;

    public List<BillType> list() {
        return typeMapper.selectAll();
    }
}
