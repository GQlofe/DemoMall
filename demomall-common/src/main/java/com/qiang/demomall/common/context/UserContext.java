package com.qiang.demomall.common.context;

import lombok.Builder;
import lombok.Data;

/**
 * @description 用户请求上下文
 *
 * @author qiang
 * @date 2023-09-09 23:24:45
 */
@Data
@Builder
public class UserContext implements LocalContext{

    /**
     * 用户id
     */
    private Long uid;


}
