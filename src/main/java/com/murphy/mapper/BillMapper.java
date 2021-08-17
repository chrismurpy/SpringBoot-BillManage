package com.murphy.mapper;

import com.murphy.entity.Bill;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 账单 - mapper
 *
 * @author murphy
 * @since 2021/8/16 9:18 下午
 */
public interface BillMapper extends Mapper<Bill> {

    public List<Bill> select(Bill b);

}
