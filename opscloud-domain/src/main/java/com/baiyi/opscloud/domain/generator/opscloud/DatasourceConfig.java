package com.baiyi.opscloud.domain.generator.opscloud;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "datasource_config")
public class DatasourceConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 数据源名称
     */
    private String name;

    /**
     * UUID
     */
    private String uuid;

    /**
     * 数据源类型
     */
    @Column(name = "ds_type")
    private Integer dsType;

    private String version;

    /**
     * 邮箱
     */
    private String kind;

    /**
     * 有效
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * 凭据id
     */
    @Column(name = "credential_id")
    private Integer credentialId;

    /**
     * 数据源地址
     */
    @Column(name = "ds_url")
    private String dsUrl;

    /**
     * 创建时间
     */
    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time", insertable = false, updatable = false)
    private Date updateTime;

    /**
     * 属性(yaml)
     */
    @Column(name = "props_yml")
    private String propsYml;

    private String comment;
}