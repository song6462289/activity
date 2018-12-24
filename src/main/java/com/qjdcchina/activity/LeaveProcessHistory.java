package com.qjdcchina.activity;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.NativeProcessDefinitionQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

public class LeaveProcessHistory {
	
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	//查询历史流程实例列表
	@Test
	public void test001() {
		HistoricActivityInstanceQuery query = processEngine.getHistoryService().createHistoricActivityInstanceQuery();
		List<HistoricActivityInstance> list = query.list();
		for (HistoricActivityInstance historicActivityInstance : list) {
			System.out.println(historicActivityInstance.getId());
		}
	}
	
	/**
	 * 查询历史活动数据列表
	 */
	@Test
	public void test002() {
		HistoricActivityInstanceQuery query = processEngine.getHistoryService().createHistoricActivityInstanceQuery();
		query.orderByProcessInstanceId().desc();
		query.orderByHistoricActivityInstanceEndTime().asc();
		List<HistoricActivityInstance> list = query.list();
		for (HistoricActivityInstance historicActivityInstance : list) {
			System.out.println(historicActivityInstance.toString());
			//System.out.println(historicActivityInstance.getActivityId()+"*****"+historicActivityInstance.getActivityName()+"******"+historicActivityInstance.getActivityType());
			
		}
	}
	
	/**
	 * 查询历史任务数据列表
	 */
	@Test
	public void test003() {
		HistoricTaskInstanceQuery query = processEngine.getHistoryService().createHistoricTaskInstanceQuery();
		query.orderByProcessInstanceId().asc();
		query.orderByHistoricTaskInstanceEndTime().desc();
		List<HistoricTaskInstance> list = query.list();
		for (HistoricTaskInstance hi : list) {
			System.out.println(hi.getAssignee()+"****************"+ hi.getName()+"**************"+hi.getStartTime().toLocaleString());
			
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
