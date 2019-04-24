package com.sdust.statemachine;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.triggers.TriggerWithParameters1;
import com.sdust.statemachine.configeration.StateCover;
import com.sdust.statemachine.enumeration.EventEnum;
import com.sdust.statemachine.enumeration.StateEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StateMachineApplicationTests {

	@Test
	public void contextLoads() {
		// 获取当前状态
		StateEnum state = StateEnum.STATE1;
		// 创建状态机设置状态机初始状态
		StateMachine<StateEnum, EventEnum> stateMachine = new StateMachine(StateEnum.STATE1, StateCover.config);
		// 将消息类型映射为事件
		EventEnum event = EventEnum.EVENT1;
		// 判断事件是否为pos或者云平台操作订单状态
		if (true){
			// 判断状态机是否可以处理当前事件
			stateMachine.canFire(EventEnum.EVENT2);
			// 如果不能处理，返回错误结果
			// 如果可以处理，pos和云平台的操作类型获取相应的handler
			// 调用handle获取操作结果
		}
		// 将事件、消息作为参数参与状态机状态处理
		stateMachine.fire(new TriggerWithParameters1<>(EventEnum.EVENT1, String.class), "aa");
		stateMachine.fire(new TriggerWithParameters1<>(EventEnum.EVENT4, String.class), "aa");
		System.out.println(stateMachine.getState());
	}

}
