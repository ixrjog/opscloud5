package com.baiyi.opscloud.datasource.zabbix;

import com.baiyi.opscloud.BaseUnit;
import com.baiyi.opscloud.domain.constants.DsAssetTypeConstants;
import com.baiyi.opscloud.common.constants.enums.DsTypeEnum;
import com.baiyi.opscloud.core.factory.AssetProviderFactory;
import com.baiyi.opscloud.core.provider.base.asset.SimpleAssetProvider;
import org.junit.jupiter.api.Test;

/**
 * @Author 修远
 * @Date 2021/6/25 3:54 下午
 * @Since 1.0
 */
public class ZabbixTest extends BaseUnit {

    @Test
    void pullUserTest() {
        SimpleAssetProvider assetProvider = AssetProviderFactory.getProvider(DsTypeEnum.ZABBIX.getName(), DsAssetTypeConstants.ZABBIX_USER.name());
        assert assetProvider != null;
        assetProvider.pullAsset(4);
    }

    @Test
    void pullUserGroupTest() {
        SimpleAssetProvider assetProvider = AssetProviderFactory.getProvider(DsTypeEnum.ZABBIX.getName(), DsAssetTypeConstants.ZABBIX_USER_GROUP.name());
        assert assetProvider != null;
        assetProvider.pullAsset(4);
    }

}
