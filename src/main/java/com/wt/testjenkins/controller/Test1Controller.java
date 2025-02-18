package com.wt.testjenkins.controller;

import com.wt.testjenkins.resp.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: Test1Controller
 * Description: TODO
 *
 * @author zjc
 * @date 2025/2/18 14:14
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/test")
@Api(value = "测试接口",description = "测试接口")
public class Test1Controller {

    @GetMapping("/testGet")
    @ApiOperation(value = "测试get接口")
    public BaseResponse testGet() {
        return new BaseResponse(200, "success", "测试get接口");
    }
}
