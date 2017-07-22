package com.spring.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ServiceInfoController {

	@Autowired
	private DiscoveryClient client;
	
	@GetMapping(value="/services")
	public List<String> getServices(){
		// this will return all the registered service ids
		List<String> serviceIds=client.getServices();
		
		//fetch the service info details using the service ids
		for(String serviceId:serviceIds){
			List<ServiceInstance> serviceInstances=client.getInstances(serviceId);
			if(!CollectionUtils.isEmpty(serviceInstances)){
				System.out.println(serviceInstances.get(0).getUri());
			}
		}
		
		return serviceIds;
	}
	
}
