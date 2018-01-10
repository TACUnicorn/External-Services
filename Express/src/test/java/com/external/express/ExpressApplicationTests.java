package com.external.express;

import com.external.express.model.ExpressTmp;
import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExpressApplicationTests {

	@Test
	public void contextLoads() {
		OkHttpClient mOkHttpClient = new OkHttpClient();
		ExpressTmp expressTmp = new ExpressTmp();
		expressTmp.setToUser("Hadoop");
		expressTmp.setToUserPhone("18000000001");
		expressTmp.setFromUser("Phoenix");
		expressTmp.setFromUserPhone("18000000001");
		expressTmp.setSource("Tongji University");
		expressTmp.setDestination("Tongji University, Caoan HighWay");
		System.out.println(expressTmp.toString());

		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),
				expressTmp.toString());
		Request request = new Request.Builder()
				.url("http://localhost:8001/express/deliver")
				.post(requestBody)
				.build();
		Call call = mOkHttpClient.newCall(request);

		try {
			Response response = call.execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
