package com.baiyi.opscloud.domain.generator.opscloud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "work_order_ticket_node")
public class WorkOrderTicketNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 工单票据ID
     */
    @Column(name = "work_order_ticket_id")
    private Integer workOrderTicketId;

    /**
     * 节点名称
     */
    @Column(name = "node_name")
    private String nodeName;

    /**
     * (责任人)用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * (责任人)用户名
     */
    private String username;

    /**
     * 父流程ID
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * ApprovalTypeConstants( AGREE,  //同意\n    CANCEL, //取消\n    REJECT  //拒绝)
     */
    @Column(name = "approval_status")
    private String approvalStatus;

    /**
     * 说明
     */
    private String comment;

    @Column(name = "create_time", insertable = false, updatable = false)
    private Date createTime;

    @Column(name = "update_time", insertable = false, updatable = false)
    private Date updateTime;
}