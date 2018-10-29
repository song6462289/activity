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
	//�������̶���
	@Test
	public void test001() {
		//���һ�����𹹽������,���ڼ������̶����ļ�
		DeploymentBuilder deployment = processEngine.getRepositoryService().createDeployment();
		
		//�������̶����ļ�
		deployment.addClasspathResource("./diagrams/process01.bpmn");
		deployment.addClasspathResource("./diagrams/process01.png");
		
		//�������̶���
		Deployment deploy = deployment.deploy();
		System.out.println(deploy.getId()+"++++++++++++++++++++++++++++"+deploy.getName());
	}
	
	//��ѯ���̶����б�
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
	 * ����һ������ʵ��
	 */
	
	@Test
	public void test003() {
		String processInstanceById = "qjlc002:6:1104";
		ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(processInstanceById);
		System.out.println(processInstance.getId());
	}
	
	/**
	 * ����ѯ�����б�����
	 */
	
	@Test
	public void test004() {
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		String assignee = "����" ;
		query.taskAssignee(assignee);
		List<Task> list = query.list();
		for (Task task : list) {
			System.out.println(task.getId()+"*****************************"+task.getName());
		}
	}
	
	/**
	 * ������������б�
	 */
	
	@Test
	public void test005() {
		TaskQuery query = processEngine.getTaskService().createTaskQuery();
		String taskId = "1402" ;
		processEngine.getTaskService().complete(taskId);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
