package com.sdust.statemachine.action;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.delegates.Action2;
import com.github.oxo42.stateless4j.transitions.Transition;
import com.github.oxo42.stateless4j.triggers.TriggerWithParameters1;
import com.sdust.statemachine.configeration.StateCover;
import com.sdust.statemachine.enumeration.EventEnum;
import com.sdust.statemachine.enumeration.StateEnum;


public class EntryAction implements Action2<String, Transition<StateEnum, EventEnum>> {

    @Override
    public void doIt(String o, Transition o2) {
        // 获取当前的状态
        o2.getDestination();
        // 修改订单状态
        // 获取事件类型
        o2.getTrigger();
        // 根据时间类型获取相应的handler
        // 调用handler处理消息a
        System.out.println(o);
        System.out.println(o2.getDestination());
        System.out.println(o2.getTrigger());
        // 创建状态机设置状态机初始状态
        StateMachine<StateEnum, EventEnum> stateMachine = new StateMachine(StateEnum.STATE1, StateCover.config);
        stateMachine.fire(new TriggerWithParameters1<>(EventEnum.EVENT1, String.class), "aa");
    }
}
