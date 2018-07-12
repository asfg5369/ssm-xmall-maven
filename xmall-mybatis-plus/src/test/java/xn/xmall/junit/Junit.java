package xn.xmall.junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ssm.pojo.Users;
import com.ssm.service.IUsersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/spring-mybatis.xml" })
public class Junit {
	@Autowired
	private IUsersService iUsersService;
	/*
	 * @Test public void junit1() { Users user =
	 * iUsersService.selectById((long)1); System.out.println(JSON.toJSON(user));
	 * }
	 */
	/*
	 * @Test public void junit2() { Users entity = new Users();
	 * entity.setId((long) 3); entity.setUsername("yang1");
	 * entity.setSalt("salt"); boolean res = iUsersService.insert(entity);
	 * System.out.println(res); }
	 */

	// @Test
	// public void insertBatch() {
	// List<Users> entityList = new ArrayList<>();
	// Users user;
	// for (long i = 1; i <= 3; i++) {
	// user = new Users();
	// user.setId(i + 3);
	// user.setUsername("admin1" + i);
	// user.setSalt("salt1" + i);
	// entityList.add(user);
	// }
	// boolean insertBatch = iUsersService.insertOrUpdateBatch(entityList);
	// Assert.assertTrue(insertBatch);
	// }
	//
	// @Test
	// public void delete(Users user) {
	// boolean res = iUsersService.deleteById((long) 1);
	// Assert.assertTrue(res);
	// }

	// @Test
	// public void selectAll() {
	// EntityWrapper<Users> ew = new EntityWrapper<>();
	// ew.like("username", "a");
	// Page<Users> page = new Page<>(1, 3);
	// Page<Users> selectPage = iUsersService.selectPage(page, ew);
	// System.out.println(JSON.toJSON(selectPage.getRecords()));
	// }

	// @Test
	// public void junit4() {
	// Collection<Long> collection = Arrays.asList((long) 1, (long) 2);
	// List<Users> list = iUsersService.selectBatchIds(collection);
	// System.out.println(JSON.toJSON(list));
	// }
	// @Test
	// public void junit5() {
	// Map<String, Object> map=new HashMap<>();
	// map.put("username", "admin1");
	// map.put("password", "admin");
	// List<String> list=new ArrayList<>();
	// list.add("admin1");
	// list.add("admin");
	// //boolean res = iUsersService.deleteByMap(map);
	// System.out.println(JSON.toJSON(map.get("username")));
	// System.out.println(JSON.toJSON(list.get(1)));
	// }
	// @Test
	// public void selectList(){
	// Wrapper<Users> wrapper = new EntityWrapper<>();
	// List<Users> list = iUsersService.selectList(wrapper);
	// System.out.println(JSON.toJSON(list));
	// }
	// @Test
	// public void selectList() {
	// Wrapper<Users> wrapper = new EntityWrapper<>();
	// int count = iUsersService.selectCount(wrapper);
	// System.out.println(JSON.toJSON(count));
	// }
	// @Test
	// public void selectObjs() {
	// Wrapper<Users> wrapper = new EntityWrapper<>();
	// Page<Users> page = new Page<>(1, 2);
	// Page<Users> selectPage = iUsersService.selectPage(page, wrapper);
	// System.out.println(JSON.toJSON(selectPage));
	// }
	@Test
	public void myBatisPlusSelectAll() {
		Wrapper<Users> wrapper = new EntityWrapper<>();
		List<Users> list = iUsersService.selectList(wrapper);
		System.out.println(JSON.toJSONString(list));
	}

//	@Test
//	public void selectALlDesc() {
//		List<Users> list = iUsersService.selectAllDesc();
//		System.out.println(JSON.toJSON(list));
//	}
}
