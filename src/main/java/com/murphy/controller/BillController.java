package com.murphy.controller;

import com.github.pagehelper.PageInfo;
import com.murphy.entity.Bill;
import com.murphy.entity.BillType;
import com.murphy.service.BillService;
import com.murphy.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账单 - 控制器
 *
 * @author murphy
 * @since 2021/8/16 9:56 下午
 */
@Controller
@RequestMapping("bill")
public class BillController {

    @Resource
    private BillService billService;
    @Resource
    private TypeService typeService;

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param b
     * @param model
     * @return
     */
    @RequestMapping("list-page")
    public String listPage(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "5") int pageSize,
                           Bill b, Model model) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);

        PageInfo<Bill> page = billService.listPage(b, pageNum, pageSize);
        model.addAttribute("page", page);

        return "/bill/list-page";
    }

    /**
     * 查询
     * @param b
     * @param model
     * @return
     */
    @RequestMapping("list")
    public String list(Bill b, Model model) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);

        List<Bill> bills = billService.list(b);
        model.addAttribute("bills", bills);

        return "/bill/list";
    }

    /**
     * 跳转到添加页面
     * @param model
     * @return
     */
    @RequestMapping("toAdd")
    public String toAdd(Model model) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);
        return "/bill/add";
    }

    /**
     * 添加
     * @param b
     * @return
     */
    @RequestMapping("add")
    public String add(Bill b) {
        billService.add(b);
        return "redirect:/bill/list-page";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        billService.delete(id);
        return "redirect:/bill/list-page";
    }

    /**
     * 跳转到修改
     * @param id
     * @return
     */
    @RequestMapping("toUpdate/{id}")
    public String toUpdate(@PathVariable("id") Long id, Model model) {
        List<BillType> types = typeService.list();
        model.addAttribute("types", types);

        Bill bill = billService.get(id);
        model.addAttribute("bill", bill);

        return "/bill/update";
    }

    /**
     * 修改
     * @param b
     * @return
     */
    @RequestMapping("update")
    public String update(Bill b) {
        billService.update(b);
        return "redirect:/bill/list-page";
    }
}
