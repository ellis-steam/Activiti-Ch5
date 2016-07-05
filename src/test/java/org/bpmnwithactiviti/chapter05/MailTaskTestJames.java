package org.bpmnwithactiviti.chapter05;



import java.util.HashMap;

import java.util.Map;

import javax.mail.MessagingException;


import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;


public class MailTaskTestJames {
	
	@Rule
	public ActivitiRule activitiRule = new ActivitiRule("activiti.cfg-mem-mail.xml");
	
	@Test
	@Deployment(resources = {"diagrams/testSimpleMail.bpmn20.xml"})
	public void sendMailLocalTest() throws MessagingException{
		
		Map<String, Object> processVariables = new HashMap<String, Object>();
		processVariables.put("name", "Miss Piggy");
		activitiRule.getRuntimeService().startProcessInstanceByKey("simpleEmailProcess", processVariables);
	}
}
