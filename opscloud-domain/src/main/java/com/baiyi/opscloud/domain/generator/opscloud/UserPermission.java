package com.baiyi.opscloud.domain.generator.opscloud;

import com.baiyi.opscloud.domain.base.BaseBusiness;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_permission")
public class UserPermission implements BaseBusiness.IBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 业务id
     */
    @Column(name = "business_id")
    private Integer businessId;

    /**
     * 业务类型
     */
    @Column(name = "business_type")
    private Integer businessType;

    /**
     * 角色
     */
    @Column(name = "permission_role")
    private String permissionRole;

    /**
     * 等级
     */
    private Integer rate;

    private String content;

    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;

    @Column(name = "update_time", insertable = false, updatable = false)
    private Date updateTime;
}