package com.cloud.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class SentinelCoreDemo {

    public static void main(String[] args) {
        initFlowRules();
        while (true) {
            doSomething();
        }

    }

    private static void doSomething(){
        Entry entry = null;
        try {
            // 定义资源：表示进入doSomething方法时，需要进行限流判断，抛出BlockException异常则触发了限流
            entry = SphU.entry("doSomething");
            /*您的业务逻辑 - 开始*/
            System.out.println("hello world "+System.currentTimeMillis());
            /*您的业务逻辑 - 结束*/
        } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
            System.out.println("block!");
            /*流控逻辑处理 - 结束*/
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    /**
     * 定义规则：定义了资源 HelloWorld 每秒最多只能通过 20 个请求。
     */
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        // 设置需要保护的资源
        rule.setResource("doSomething");
        // 限流阈值类型：1-QPS模式，2-并发线程数模式
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // 是否需要针对调用来源进行限流，默认即不区分
        rule.setLimitApp("default");
        // 调用关系限流策略：0-直接、2-链路、1-关联
        rule.setStrategy(RuleConstant.STRATEGY_CHAIN);
        // Set limit QPS to 20.
        rule.setCount(20);
        // 是否集群模式限流，默认为否
        rule.setClusterMode(false);
        // 流控行为：直接拒绝（默认）/WarmUp/匀速+排队等待
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_DEFAULT);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
