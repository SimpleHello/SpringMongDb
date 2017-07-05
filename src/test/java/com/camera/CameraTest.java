package com.camera;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kongtrolink.scloud.core.entity.camera.Camera;
import com.kongtrolink.scloud.core.model.camera.CameraImageModel;
import com.kongtrolink.scloud.core.model.camera.CameraSizeModel;
import com.kongtrolink.scloud.core.query.camera.FFmpegOrder;
import com.kongtrolink.scloud.core.query.camera.FFmpegQuery;
import com.kongtrolink.scloud.core.query.camera.OnvifQuery;
import com.kongtrolink.scloud.core.service.camera.CameraOnvifService;
import com.kongtrolink.scloud.core.service.camera.FFmpegService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:conf/applicationContext.xml")
public class CameraTest {
	
	@Autowired
	FFmpegService fFmpegService;

	@Autowired
	CameraOnvifService cameraOnvifService;
	
	@Before
	public void bef() {
		System.out.println("开始单元测试");
	}

	@After
	public void aft() {
		System.out.println("测试结束");
	}

	@Test
	public void rtspToRtmp() {
		FFmpegQuery query = new FFmpegQuery();
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345");
			camera.setId("58c8acd3e138230b3e56c211");
			camera.setIp("10.0.6.105");
			camera.setRtspPort("10088");
			query.setCamera(camera);
			String str = fFmpegService.rtspToRtmp(query);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void transcribeVideo() {
		FFmpegQuery query = new FFmpegQuery();
		FFmpegOrder order = query.getOrder();
		order.setFps("5");
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345");
			camera.setId("1234567890");
			camera.setIp("10.0.6.105");
			camera.setRtspPort("10088");
			query.setCamera(camera);
			query.setTranPath("D://sanmao.mp4");
			String str = fFmpegService.transcribeVideo(query,"1");
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void cutImage() {
		FFmpegQuery query = new FFmpegQuery();
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345");
			camera.setId("1234567890");
			camera.setIp("10.0.6.105");
			camera.setRtspPort("10088");
			query.setCamera(camera);
			query.setCutPath("D://sanmao3.jpg");
			String str = fFmpegService.cutImage(query,"1");
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void omvifSetSystemTime() {
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345");
			camera.setId("1234567890");
			camera.setIp("10.0.6.105");
			camera.setPort("8088");
			boolean str = cameraOnvifService.setSystemTime(camera, "2017-05-27 10:29:13");
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void omvifissupport() {
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			boolean str = cameraOnvifService.ifPTZControlSupport(camera);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void omvifMove() {
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			OnvifQuery query = new OnvifQuery();
			query.setZoomType(-1);
			query.setXtype(0);
			query.setYtype(0);
			query.setFocus(0);
			boolean str = cameraOnvifService.continuousMove(camera, query);
			System.out.println(str+"开始移动");
//			Thread.sleep(3000);
//			boolean str2  = cameraOnvifService.stopContinuousMove(camera);
//			System.out.println("停止移动："+str2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void omvifSize() {
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			List<CameraSizeModel> list = cameraOnvifService.getSizeConfig(camera);
			String strJson21 = JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
			System.out.println(strJson21);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getImageConfig() {
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			CameraImageModel model = new CameraImageModel();
			model.setBrightness(50f);
			boolean list = cameraOnvifService.setImageConfig(camera,model);
			String strJson21 = JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
			System.out.println(strJson21);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void continuousFocusMove() {
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			OnvifQuery query  = new OnvifQuery();
			query.setFocus(1);
			boolean list = cameraOnvifService.continuousFocusMove(camera, query);
			String strJson21 = JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
			System.out.println(strJson21);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void continuousFocusMoveStop() {
		Camera camera = new Camera();
		try {
			camera.setUsername("admin");
			camera.setPassword("12345admin");
			camera.setId("1234567890");
			camera.setIp("10.0.6.151");
			camera.setPort("80");
			OnvifQuery query  = new OnvifQuery();
			query.setFocus(-1);
			boolean list = cameraOnvifService.continuousFocusMoveStop(camera);
			String strJson21 = JSONObject.toJSONString(list, SerializerFeature.WriteMapNullValue);
			System.out.println(strJson21);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
