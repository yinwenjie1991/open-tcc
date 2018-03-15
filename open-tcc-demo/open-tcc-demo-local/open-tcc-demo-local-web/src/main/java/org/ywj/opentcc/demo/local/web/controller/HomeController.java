package org.ywj.opentcc.demo.local.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.ywj.opentcc.demo.local.biz.service.QueryService;
import org.ywj.opentcc.demo.local.dal.entity.TccTbOne;
import org.ywj.opentcc.demo.local.dal.entity.TccTbTwo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-03-11
 */
@Controller
public class HomeController {

    @Autowired
    private QueryService queryService;

    @RequestMapping("/")
    public ModelAndView Home() {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<TccTbOne> tccTbOnes = queryService.queryAllTccTbOne();
//            List<TccTbTwo> tccTbTwos = queryService.queryAllTccTbTwo();
            map.put("tccTbOnes", tccTbOnes);
//            map.put("tccTbTwos", tccTbTwos);
        } catch (Exception e) {
            return new ModelAndView("error");
        }
        return new ModelAndView("index", map);
    }
}
