package com.baiyi.opscloud.facade.leo;

import com.baiyi.opscloud.BaseUnit;
import com.baiyi.opscloud.domain.generator.opscloud.Application;
import com.baiyi.opscloud.domain.generator.opscloud.LeoJob;
import com.baiyi.opscloud.domain.param.leo.LeoJobParam;
import com.baiyi.opscloud.service.application.ApplicationService;
import com.baiyi.opscloud.service.leo.LeoJobService;
import com.google.common.base.Splitter;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author baiyi
 * @Date 2023/2/1 16:01
 * @Version 1.0
 */
@Slf4j
public class LeoJobTest extends BaseUnit {

    @Resource
    private LeoJobService leoJobService;

    @Resource
    private LeoJobFacade jobFacade;

    @Resource
    private ApplicationService applicationService;

    @Test
    public void test() {
        List<LeoJob> leoJobs = leoJobService.queryAll();

        leoJobs.forEach(job -> {
            String destStr = job.getEnvType() == 4 ? "robot-leo-prod" : "robot-leo-non-prod";
            String config = job.getJobConfig().replace("robot-leo-test", destStr);
            LeoJob saveLeoJob = LeoJob.builder()
                    .id(job.getId())
                    .jobConfig(config)
                    .build();
            leoJobService.updateByPrimaryKeySelective(saveLeoJob);
        });

    }

    /**
     * @Operation(summary = "从任务复制任务")
     * @PostMapping(value = "/job/one/clone", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     * public HttpResult<Boolean> cloneOneJob(@RequestBody @Valid LeoJobParam.CloneOneJob cloneOneJob) {
     * jobFacade.cloneOneJob(cloneOneJob);
     * return HttpResult.SUCCESS;
     * }
     */

    private static final String x = """
            ng-pos-access-channel
            ng-pos-polaris-channel
            ng-pos-upsl-channel
            ng-postpay-channel
            ng-qrios-channel
            ng-smile-channel
            ng-sporty-channel
            ng-stanbic-channel
            ng-sterling-channel
            ng-swiftend-channel
            ng-tripsdotcom-channel
            ng-uba-channel
            ng-uba-new-channel
            ng-up-channel
            ng-wajegame-channel
            ng-wgb-channel
            ng-withhold-channel
            ng-wooshpay-channel
            ng-zenith-channel
            paynet-ng-iso-channel
            paynet-server-mock
            paynet-switch-center
            qa-basic-service
            qa-basic-service-init
            taskmanage-consumer-aws
            trade-mng
            tz-airtel-channel
            tz-creditinfo-channel
            tz-fasthub-channel
            tz-halotel-channel
            tz-pos-uba-itex-channel
            tz-selcom-channel
            tz-selcom-electricity-channel
            tz-tigopesa-channel
            agent-bff-product
            airtime-product
            base-biz-mng
            channel-file-service
            channel-item-center
            channel-sms-center
            crm-customer-mng
            finance-switch-distribution
            gh-appsmobile-channel
            gh-ecg-channel
            gh-ghipss-channel
            gh-gtb-channel
            gh-pos-gtb-channel
            gh-pos-uba-itex-channel
            gh-uba-itex-channel
            ke-cellulantt-channel
            ke-creditinfo-channel
            merchant-test
            ng-access-channel
            ng-accessbet-channel
            ng-aedc-channel
            ng-africa365-channel
            ng-airtel-channel
            ng-baxi-channel
            ng-betcorrect-channel
            ng-betking-channel
            ng-betnaija-channel
            ng-betwinner-channel
            ng-blusalt-channel
            ng-buypower-channel
            ng-chowdeck-channel
            ng-coralpay-channel
            ng-credequity-channel
            ng-dispute-channel
            ng-dlocal-channel
            ng-dml-channel
            ng-dojah-channel
            ng-ekedc-channel
            ng-etranzact-channel
            ng-etranzact-inward-channel
            ng-fairmoney-channel
            ng-fcmb-channel
            ng-fdc-channel
            ng-fidelity-channel
            ng-geniex-channel
            ng-globucketdata-channel
            ng-gtb-channel
            ng-habaripay-channel
            ng-hydrogen-channel
            ng-interswitch-channel
            ng-irecharge-channel
            ng-issuer-isw-channel
            ng-jedc-channel
            ng-kedco-channel
            ng-kuda-channel
            ng-kuda-inward-channel
            ng-mfs-channel
            ng-monobvn-channel
            ng-monokyc-channel
            ng-msport-channel
            ng-mtn-channel
            ng-mtnbucket-channel
            ng-nairabet-channel
            ng-new-buypower-channel
            ng-new-fidelity-channel
            ng-new-mtn-channel
            ng-new-onexbet-channel
            ng-nibss-channel
            ng-nibssqr-channel
            ng-ninemobile-channel
            nibss
            out-transfer
            pay-route
            pay-route-dc252
            paystack
            posp-channel
            posp-channel-companion
            posp-channel-encryption
            posp-channel-route
            posp-outway
            query
            self-service
            settlement
            tecno-admin
            tecno-basic-data
            tecno-channel
            tecno-device
            tecno-front
            tecno-m-front
            tecno-mail
            tecno-marketing
            tecno-member
            tecno-message
            tecno-order
            tecno-push
            tecno-query
            tecno-sms
            tecno-validator
            tz-channel
            uganda-channel
            visa-channel
            basic-uid-service
            channel-center
            crm-gateway
            data-center
            flexi-bff-product
            flexi-mng
            flutterwave
            ghana
            ke-channel
            m-aa
            m-customer-management
            m-front
            m-workflow
            ng-channel
            ng-axa-channel
            ng-pos-gtb-channel
            tz-mpesa-channel
            ke-ipay-channel
            """;

    @Test
    void spTest(){
        Iterable<String>  xxxx=  Splitter.on("\n").split(x);
        //System.out.println(xxxx);

        xxxx.forEach(x->{ cloneJobTest(x);
        });

    }


    void cloneJobTest(String appName) {
       // String appName = "ng-parimatch-channel";

        Application application = applicationService.getByName(appName);
        if (application == null) {
            log.warn("appName: {} 不存在！", appName);
            return;
        }
        // dev envType = 1
        List<LeoJob> jobs = leoJobService.queryJobWithSubscribe(application.getId(), 1, "kubernetes-image");
        if (CollectionUtils.isEmpty(jobs)) {
            log.warn("appName: {} 任务为空！", appName);
            return;
        }

        if (jobs.size() > 1) {
            log.warn("appName: {} 任务数 > 1 .", appName);
            return;
        }

        String jC = """
                job:
                  cr:
                    cloud:
                      name: 阿里云-PalmPay主账户
                      uuid: 75cde081a08646e6b8568b3d34f203a3
                    instance:
                      id: cri-koab4h4dfgxosahl
                      name: acr-frankfurt
                      regionId: eu-central-1
                      url: acr-frankfurt.chuanyinet.com
                    type: ACR
                  parameters:
                  - description: null
                    name: registryUrl
                    value: acr-frankfurt.chuanyinet.com
                  tags:
                  - '@Frankfurt'
                """;


        LeoJobParam.CloneOneJob cloneOneJob = LeoJobParam.CloneOneJob.builder()
                .jobId(jobs.getFirst().getId())
                .jobName("${applicationName}-frankfurt-${env}")
                .jobConfig(jC)
                .cloneTag(true)
                .build();
        try {
           LeoJob leoJob = jobFacade.cloneOneJob(cloneOneJob);

           leoJob.setTemplateId(9);
           leoJobService.update(leoJob);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
