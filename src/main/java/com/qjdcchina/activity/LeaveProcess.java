package com.qjdcchina.activity;

import java.util.List;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.junit.Test;

public class LeaveProcess {
	
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	//部署流程定义
	@Test
	public void test001() {
		//获得一个部署构建起对象,用于加载流程定义文件
		DeploymentBuilder deployment = processEngine.getRepositoryService().createDeployment();
		
		//加载流程定义文件
		deployment.addClasspathResource("./diagrams/process01.bpmn");
		deployment.addClasspathResource("./diagrams/process01.png");
		
		//部署流程定义
		Deployment deploy = deployment.deploy();
		System.out.println(deploy.getId()+"++++++++++++++++++++++++++++"+deploy.getName());
	}
	
	//查询流程定义列表
	@Test
	public void test002() {
		ProcessDefinitionQuery query = processEngine.getRepositoryService().createProcessDefinitionQuery();
		query.processDefinitionKey("qjlc002");
		query.orderByProcessDefinitionVersion().desc();
		query.listPage(0, 10);
		List<ProcessDefinition> list = query.list();
		for (ProcessDefinition processDefinition : list) {
			System.out.println(processDefinition.getId());
		}
	}
	
	/**
	 * 启动一个流程实例
	 */
	
	@Test
	public void test003() {
		String processInstanceById = "qjlc002:6:1104";
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(processInstanceById);
		System.out.println(processInstance.getId());
	}
	
	/**
	 * 启查询个人列表任务
	 */
	
	@Test
	public void test004() {
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		String assignee = "王五" ;
		query.taskAssignee(assignee);
		List<Task> list = query.list();
		for (Task task : list) {
			System.out.println(task.getId()+"*****************************"+task.getName());
		}
	}
	
	/**
	 * 处理个人任务列表
	 */
	
	@Test
	public void test005() {
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		String taskId = "1402" ;
		processEngine.getTaskService().complete(taskId);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
