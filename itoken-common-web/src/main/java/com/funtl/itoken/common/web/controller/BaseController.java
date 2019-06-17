package com.funtl.itoken.common.web.controller;

import com.funtl.itoken.common.domain.BaseDomain;
import com.funtl.itoken.common.utils.MapperUtils;
import com.funtl.itoken.common.web.components.datatables.DataTablesResult;
import com.funtl.itoken.common.web.service.BaseClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用 Controller
 * <p>Title: BaseController</p>
 * <p>Description: </p>
 *
 * @author Lusifer
 * @version 1.0.0
 * @date 2018/8/12 14:00
 */
public abstract class BaseController<T extends BaseDomain, S extends BaseClientService> {

    /**
     * 注入业务逻辑层
     */
    @Autowired
    protected S service;

    @ResponseBody
    @RequestMapping(value = "page", method = RequestMethod.GET)
    public DataTablesResult page(HttpServletRequest request) {
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");

        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 10 : Integer.parseInt(strLength);

        String json = service.page(start, length, null);
        DataTablesResult dataTablesResult = null;
        try {
            dataTablesResult = MapperUtils.json2pojo(json, DataTablesResult.class);
            dataTablesResult.setDraw(draw);
            dataTablesResult.setRecordsTotal(dataTablesResult.getCursor().getTotal());
            dataTablesResult.setRecordsFiltered(dataTablesResult.getCursor().getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesResult;
    }
    /**
     * description: t1 提交
     * @Version 1.0 2019/6/17 15:35 by 常继承（jichegn.chang@ucarinc.com）创建
     */
    private String getKey(){
        return "GG";
    }

    /**
     * description: dev1
     * @Version 1.0 2019/6/17 15:26 by 常继承（jichegn.chang@ucarinc.com）创建
     */
    private testDev(String src){
        return src;
    }

    /**
     * description: dev2
     * @Version 1.0 2019/6/17 15:26 by 常继承（jichegn.chang@ucarinc.com）创建
     */
    private testDev2(String src){
        return src;
    }

    /**
     * description: dev3
     * @Version 1.0 2019/6/17 15:26 by 常继承（jichegn.chang@ucarinc.com）创建
     */
    private testDev3(String src){
        return src;
    }
}
