package com.sdust.statemachine.configeration;

import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.triggers.TriggerWithParameters1;
import com.sdust.statemachine.action.EntryAction;
import com.sdust.statemachine.enumeration.EventEnum;
import com.sdust.statemachine.enumeration.StateEnum;
import com.sdust.statemachine.func.State2Func;

public class StateCover {
    /**
     * 状态机配置对象
     */
    public static StateMachineConfig<StateEnum,EventEnum> config = new StateMachineConfig();

    static {

        // 单独设置重复使用的trigger
        config.setTriggerParameters(EventEnum.EVENT3, String.class);

        // 从config中获取设置的trigger用于之后的配置
        TriggerWithParameters1<String, StateEnum,EventEnum> trigger =
                (TriggerWithParameters1<String, StateEnum,EventEnum>) config.getTriggerConfiguration(EventEnum.EVENT3);


        // 当前状态为STATE1
        config.configure(StateEnum.STATE1)
                // 事件EVENT1 STATE1 -> STATE2
                .permit(EventEnum.EVENT1, StateEnum.STATE2)
                .permitDynamic(trigger, new State2Func())
                .permit(EventEnum.EVENT2, StateEnum.STATE3);

        // 当前状态为STATE2
        config.configure(StateEnum.STATE2)
                // EVENT1触发变更STATE2调用EntryAction，EntryAction中doit方法入参为string类型的参数
                .onEntryFrom(config.setTriggerParameters(EventEnum.EVENT1, String.class), new EntryAction(), String.class)
                // 事件EVENT4，具体变更为什么状态由State2Func决定，State2Func中call方法入参为string类型的参数
                .permitDynamic(config.setTriggerParameters(EventEnum.EVENT4, String.class), new State2Func())
//                .permitDynamic(config.setTriggerParameters(EventEnum.EVENT3, String.class), new State2Func())
                .permit(EventEnum.EVENT2, StateEnum.STATE3);
                // 忽略EVENT3，否则当前状态STATE2处理EVENT3会抛异常
//                .ignore(EventEnum.EVENT3);
    }
}
