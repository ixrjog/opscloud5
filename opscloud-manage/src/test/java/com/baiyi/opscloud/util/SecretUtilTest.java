package com.baiyi.opscloud.util;

import com.baiyi.opscloud.BaseUnit;
import com.baiyi.opscloud.common.util.SecretUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Author baiyi
 * @Date 2021/5/11 2:16 下午
 * @Version 1.0
 */
@Slf4j
public class SecretUtilTest extends BaseUnit {

    @Test
    void getSecretStrTest(){
       log.info(SecretUtil.getSecretStr(64));
    }
}
