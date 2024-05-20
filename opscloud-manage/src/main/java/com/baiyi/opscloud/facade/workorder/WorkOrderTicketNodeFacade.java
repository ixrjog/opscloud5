package com.baiyi.opscloud.facade.workorder;

import com.baiyi.opscloud.domain.generator.opscloud.WorkOrder;
import com.baiyi.opscloud.domain.generator.opscloud.WorkOrderTicket;
import com.baiyi.opscloud.domain.vo.user.UserVO;

/**
 * @Author baiyi
 * @Date 2022/1/14 4:14 PM
 * @Version 1.0
 */
public interface WorkOrderTicketNodeFacade {

    void createWorkflowNodes(WorkOrder workOrder, WorkOrderTicket workOrderTicket);

    void verifyWorkflowNodes(WorkOrder workOrder, WorkOrderTicket workOrderTicket);

    void updateWorkflowNodeAuditUser(int workOrderTicketId, String nodeName, UserVO.User auditUser);

}
