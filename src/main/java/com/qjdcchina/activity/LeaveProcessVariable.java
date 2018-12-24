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
	//设置流程变量  一 : 在启动流程实例时设置
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
	
	//设置流程变量  二 : 在办理任务时设置
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
		
		
		//设置流程变量  三: 使用RuntimeService设置
		@Test
		public void test003() {
			String executionId = "1605";//流程实例id
			String variableName = "key3" ;
			Object value = "value3" ;
			processEngine.getRuntimeService().setVariable(executionId, variableName, value);
		}
	
		
		//设置流程变量  三: 使用RuntimeService设置
				@Test
				public void test004() {
					String executionId = "1605";//流程实例id
					String variableName = "key3" ;
					Object value = "value3" ;
					processEngine.getRuntimeService().setVariable(executionId, variableName, value);
				}
				
				
				//
				@Test
				public void test005() {
					//测试使用
					
					
					
				}
		
		
		
		


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
