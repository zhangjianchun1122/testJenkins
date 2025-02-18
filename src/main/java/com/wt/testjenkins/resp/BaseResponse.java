package com.wt.testjenkins.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ClassName: BaseResponse
 * Description: TODO
 *
 * @author zjc
 * @date 2025/2/18 13:44
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class BaseResponse {

    private Integer code;

    private String msg;

    private Object data;
}
