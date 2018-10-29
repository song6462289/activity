package com.qjdcchina.activity;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

import sun.print.PeekGraphics;

public class LeaveProcessVariable {
	
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	//�������̱���  һ : ����������ʵ��ʱ����
	@Test
	public void test001() {
		String processDefinitionKey = "qjlc002";
		  Map<String, Object> variable = new HashMap<String, Object>();
		  
		  variable.put("key1", "value1");
		  variable.put("key2", 200);
		  ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey,variable);
		  System.out.println(pi.getId());
		  System.out.println(pi.toString());
	}
	
	//�������̱���  �� : �ڰ�������ʱ����
		@Test
		public void test002() {
			String processDefinitionKey = "qjlc002";
			  Map<String, Object> variable = new HashMap<String, Object>();
			  
			  variable.put("key1", "value1");
			  variable.put("key2", 200);
			  ProcessInstance pi = processEngine.getRuntimeService().startProcessInstanceByKey(processDefinitionKey,variable);
			  System.out.println(pi.getId());
			  System.out.println(pi.toString());
		}
		
		
		//�������̱���  ��: ʹ��RuntimeService����
		@Test
		public void test003() {
			String executionId = "1605";//����ʵ��id
			String variableName = "key3" ;
			Object value = "value3" ;
			processEngine.getRuntimeService().setVariable(executionId, variableName, value);
		}
	
		
		//�������̱���  ��: ʹ��RuntimeService����
				@Test
				public void test004() {
					String executionId = "1605";//����ʵ��id
					String variableName = "key3" ;
					Object value = "value3" ;
					processEngine.getRuntimeService().setVariable(executionId, variableName, value);
				}
				
				
				//
				@Test
				public void test005() {
				
					
					
				}
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
