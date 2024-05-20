package com.baiyi.opscloud.domain.generator.opscloud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 数据源实例uuid
     */
    @Column(name = "instance_uuid")
    private String instanceUuid;

    @Column(name = "event_name")
    private String eventName;

    /**
     * 数据源事件id
     */
    @Column(name = "event_id")
    private String eventId;

    /**
     * 数据源事件id描述
     */
    @Column(name = "event_id_desc")
    private String eventIdDesc;

    /**
     * 严重性级别
     */
    private Integer priority;

    /**
     * 最后更改其状态的时间
     */
    @Column(name = "lastchange_time")
    private Date lastchangeTime;

    /**
     * 有效事件
     */
    @Column(name = "is_active")
    private Boolean isActive;

    /**
     * 过期时间
     */
    @Column(name = "expired_time")
    private Date expiredTime;

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
     * 数据源事件信息
     */
    @Column(name = "event_message")
    private String eventMessage;
}