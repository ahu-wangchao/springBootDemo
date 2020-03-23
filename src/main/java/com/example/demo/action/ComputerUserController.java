package com.example.demo.action;

import com.example.demo.entity.ComputerUser;
import com.example.demo.service.ComputerUserService;
import com.example.demo.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: ahu_w
 * @Date: 2019/11/6 13:55
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class ComputerUserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ComputerUserService computerUserService;
    /**
     * @Auther: ahu_w
     * @Date: 2019/11/6 14:12
     * @Description: 
     */
    @ResponseBody
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public Result selectAll() {
        List<ComputerUser> list = computerUserService.selectList();
        return Result.success(list);
    }

    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result add(ComputerUser computerUser){
        setCreateInfo(computerUser);
        computerUserService.add(computerUser);
        logger.info("git版本更新测试代码");
        return Result.success("操作成功！");
    }

    @ResponseBody
    @RequestMapping(value = "getUser/{id}",method = RequestMethod.POST)
    public Result getUser(@PathVariable long id){
        ComputerUser computerUser = computerUserService.selectById(id);
        return Result.success(computerUser);
    }


}
