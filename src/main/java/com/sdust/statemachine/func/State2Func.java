package com.sdust.statemachine.func;

import com.github.oxo42.stateless4j.delegates.Func2;
import com.sdust.statemachine.enumeration.StateEnum;

public class State2Func implements Func2<String, StateEnum> {
    @Override
    public StateEnum call(String s) {
        // 根据消息中的参数获取当前集团配置
        // 根据不同配置返回不同的状态
        if ("a".equals(s)) {
            return StateEnum.STATE3;
        }
        return null;
    }
}
