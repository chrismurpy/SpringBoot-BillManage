package com.murphy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.murphy.entity.Bill;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest extends TestCase {

    @Resource
    private BillService billService;

    @Test
    public void testList() {
        Bill b = new Bill();
        b.setTitle("费");
        billService.list(b).forEach(bill -> {
            System.out.println(bill.getTitle());
        });
    }

    @Test
    public void testFindPage() {
        Bill b = new Bill();
        b.setTitle("费");

        PageInfo<Bill> page = PageHelper.startPage(1, 1).doSelectPageInfo(() -> {
            billService.list(b);
        });

        page.getList().forEach(bill -> {
            System.out.println(bill.getId() + " - " + bill.getTitle());
        });

        System.out.println("总行数：" + page.getTotal());
        System.out.println("当前页=" + page.getPageNum());
        System.out.println("每页行数=" + page.getPageSize());
        System.out.println("总页数=" + page.getPages());
        System.out.println("起始行数=" + page.getStartRow());

        System.out.println("是第一页=" + page.isIsFirstPage());
        System.out.println("是最后页=" + page.isIsLastPage());

        System.out.println("还有下一页=" + page.isHasNextPage());
        System.out.println("还有上一页=" + page.isHasPreviousPage());
        System.out.println("页码列表" + Arrays.toString(page.getNavigatepageNums()));
    }
}