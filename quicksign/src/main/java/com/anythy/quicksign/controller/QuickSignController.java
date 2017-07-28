package com.anythy.quicksign.controller;

import com.anythy.quicksign.common.ResponseTool;
import com.anythy.quicksign.common.ResultData;
import com.anythy.quicksign.entity.WXUser;
import com.anythy.quicksign.service.QuickSignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Leach on 0025 2017/7/25.
 */
@RestController()
public class QuickSignController {

    Logger logger = LoggerFactory.getLogger(QuickSignController.class);

    @Autowired
    QuickSignService quickSignService;

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ResultData enter(@ModelAttribute @Valid WXUser wxUser, BindingResult bindingResult){
        logger.info(String.format("{openId,nickName}={%s,%s}", wxUser.getOpenId(), wxUser.getNickName()));
        if(bindingResult.getErrorCount() > 0){
            return ResponseTool.responseParamError();
        }
        try{
            quickSignService.enter(wxUser);
        }catch(Exception e){
            return ResponseTool.responseInnerError();
        }
        return ResponseTool.responseSucess();
    }

    @RequestMapping(value = "/test")
    public boolean test(){
        return true;
    }
}
