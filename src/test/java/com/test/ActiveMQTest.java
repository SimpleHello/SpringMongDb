package com.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.util.DubboReference;
import com.kongtrolink.scloud.core.entity.camera.Camera;
import com.kongtrolink.scloud.core.service.camera.CameraOnvifService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class ActiveMQTest {

	@Autowired
	DubboReference dubboReference;

	@Before
	public void bef() {
		System.out.println("开始单元测试");
	}

	@After
	public void aft() {
		System.out.println("测试结束");
	}

	@Test
	public void checkInit() {

		CameraOnvifService cameraOnvifService = (CameraOnvifService) dubboReference.Sxx("111111cameraOnvifService",
				com.kongtrolink.scloud.core.service.camera.CameraOnvifService.class, "scloudCamera012");
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			if(cameraOnvifService==null){
				System.out.println("-------是 null 了: " );
				return ;
			}else{
				boolean str = cameraOnvifService.ifPTZControlSupport(camera);
				System.out.println("-------success ！支持否: " + str);
			}
			
//			Xxx();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void Xxx() {
		CameraOnvifService cameraOnvifService = (CameraOnvifService) dubboReference.Sxx("cameraOnvifService",
				com.kongtrolink.scloud.core.service.camera.CameraOnvifService.class, "scloudCamera01");
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			boolean str = cameraOnvifService.ifPTZControlSupport(camera);
			System.out.println("-------success ！支持否: " + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
