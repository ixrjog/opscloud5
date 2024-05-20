package com.baiyi.opscloud.domain.generator.opscloud;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "sys_document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "mount_zone")
    private String mountZone;

    private String icon;

    private Integer seq;

    @Column(name = "document_key")
    private String documentKey;

    /**
     * 文档类型
     */
    @Column(name = "document_type")
    private Integer documentType;

    @Column(name = "is_active")
    private Boolean isActive;

    private String comment;

    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;

    @Column(name = "update_time", insertable = false, updatable = false)
    private Date updateTime;

    /**
     * 文档内容
     */
    private String content;
}