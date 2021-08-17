package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.entity.Bill;
import com.murphy.mapper.BillMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账单 - Service
 *
 * @author murphy
 * @since 2021/8/16 9:38 下午
 */
@Service
public class BillService {

    @Resource
    private BillMapper billMapper;

    public List<Bill> list(Bill b) {
        return billMapper.select(b);
    }

    public int add(Bill b) {
        return billMapper.insert(b);
    }

    public Bill get(Long id) {
        return billMapper.selectByPrimaryKey(id);
    }

    public int update(Bill b) {
        return billMapper.updateByPrimaryKey(b);
    }

    public int delete(Long id) {
        return billMapper.deleteByPrimaryKey(id);
    }

    public PageInfo<Bill> listPage(Bill b, int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> {
            billMapper.select(b);
        });
    }
}
