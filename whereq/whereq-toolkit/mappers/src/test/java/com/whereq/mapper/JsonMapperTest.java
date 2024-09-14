package com.whereq.mapper;

import static org.assertj.core.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.whereq.mapper.JsonMapper;

/**
 * @author bacon
 */
public class JsonMapperTest {

	private static JsonMapper mapper = JsonMapper.nonDefaultMapper();

	/**
	 * Serialize Object/Collection to Json string.
	 */
	@Test
	public void toJson() throws Exception {
		// MapperTestUser
		MapperTestUser mapperTestUser = new MapperTestUser("bacon");
		String jsonString = mapper.toJson(mapperTestUser);
		System.out.println("MapperTestUser:" + jsonString);
		assertThat(jsonString).isEqualTo("{\"name\":\"bacon\"}");

		// Map
		Map<String, Object> map = Maps.newLinkedHashMap();
		map.put("name", "bacon");
		map.put("age", 30);
		String mapString = mapper.toJson(map);
		System.out.println("Map:" + mapString);
		assertThat(mapString).isEqualTo("{\"name\":\"bacon\",\"age\":30}");

		// List<String>
		List<String> stringList = Lists.newArrayList("bacon", "foo", "bar");
		String listString = mapper.toJson(stringList);
		System.out.println("String List:" + listString);
		assertThat(listString).isEqualTo("[\"bacon\",\"foo\",\"bar\"]");

		// List<MapperTestUser>
		List<MapperTestUser> mapperTestUserList = Lists.newArrayList(new MapperTestUser("bacon"), new MapperTestUser("foo"));
		String mapperTestUserListString = mapper.toJson(mapperTestUserList);
		System.out.println("MapperTestUser List:" + mapperTestUserListString);
		assertThat(mapperTestUserListString).isEqualTo("[{\"name\":\"bacon\"},{\"name\":\"foo\"}]");

		// MapperTestUser[]
		MapperTestUser[] mapperTestUserArray = new MapperTestUser[] { new MapperTestUser("bacon"), new MapperTestUser("foo") };
		String mapperTestUserArrayString = mapper.toJson(mapperTestUserArray);
		System.out.println("Array List:" + mapperTestUserArrayString);
		assertThat(mapperTestUserArrayString).isEqualTo("[{\"name\":\"bacon\"},{\"name\":\"foo\"}]");
	}

	/**
	 * Deserialize from Json string to Object/Collection.
	 */
	@Test
	public void fromJson() throws Exception {
		// MapperTestUser
		String jsonString = "{\"name\":\"bacon\"}";
		MapperTestUser mapperTestUser = mapper.fromJson(jsonString, MapperTestUser.class);
		System.out.println("MapperTestUser:" + mapperTestUser);

		// Map
		String mapString = "{\"name\":\"bacon\",\"age\":30}";
		Map<String, Object> map = mapper.fromJson(mapString, HashMap.class);
		System.out.println("Map:");
		for (Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// List<String>
		String listString = "[\"bacon\",\"foo\",\"bar\"]";
		List<String> stringList = mapper.getMapper().readValue(listString, List.class);
		System.out.println("String List:");
		for (String element : stringList) {
			System.out.println(element);
		}

		// List<MapperTestUser>
		String mapperTestUserListString = "[{\"name\":\"bacon\"},{\"name\":\"foo\"}]";
		List<MapperTestUser> mapperTestUserList = mapper.getMapper().readValue(mapperTestUserListString, new TypeReference<List<MapperTestUser>>() {
		});
		System.out.println("MapperTestUser List:");
		for (MapperTestUser element : mapperTestUserList) {
			System.out.println(element);
		}
	}
	
	/**
	 * Json string to XML string.
	 */
	@Test
	public void jsonToXml() throws Exception {
		// MapperTestUser
		String jsonString = "{\"name\":\"bacon\"}";
		MapperTestUser mapperTestUser = mapper.fromJson(jsonString, MapperTestUser.class);
		System.out.println("MapperTestUser:" + mapperTestUser);

		String xml = JaxbMapper.toXml(mapperTestUser, "UTF-8");
		System.out.println("Jaxb Object to Xml result:\n" + xml);
		String[] strArray = xml.split("\\n");
		StringBuffer sbf = new StringBuffer(64);
		for (int i = 0; i < strArray.length; i++) {
			sbf.append(strArray[i].trim());
		}
		String compareStr = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><mapperTestUser id=\"1\"><name>bacon</name><interests/></mapperTestUser>";
		assertThat(sbf.toString()).isEqualTo(compareStr);
	}

	/**
	 * 
	 */
	@Test
	public void nullAndEmpty() {
		// toJson //

		// Null MapperTestUser
		MapperTestUser nullBean = null;
		String nullBeanString = mapper.toJson(nullBean);
		assertThat(nullBeanString).isEqualTo("null");

		// Empty List
		List<String> emptyList = Lists.newArrayList();
		String emptyListString = mapper.toJson(emptyList);
		assertThat(emptyListString).isEqualTo("[]");

		// fromJson //

		// Null String for MapperTestUser
		MapperTestUser nullBeanResult = mapper.fromJson(null, MapperTestUser.class);
		assertThat(nullBeanResult).isNull();

		nullBeanResult = mapper.fromJson("null", MapperTestUser.class);
		assertThat(nullBeanResult).isNull();

		// Null/Empty String for List
		List nullListResult = mapper.fromJson(null, List.class);
		assertThat(nullListResult).isNull();

		nullListResult = mapper.fromJson("null", List.class);
		assertThat(nullListResult).isNull();

		nullListResult = mapper.fromJson("[]", List.class);
		assertThat(nullListResult).isEmpty();
	}

	/**
	 * Test three types of Binder.
	 */
	@Test
	public void threeTypeBinders() {
		// map all properties
		JsonMapper normalBinder = new JsonMapper();
		MapperTestUser mapperTestUser = new MapperTestUser("bacon");
		assertThat(normalBinder.toJson(mapperTestUser)).isEqualTo(
				"{\"id\":1,\"name\":\"bacon\",\"password\":null,\"interests\":[]}");
	
		// don't map nullValue properties
		JsonMapper nonNullBinder = JsonMapper.nonEmptyMapper();
		assertThat(nonNullBinder.toJson(mapperTestUser)).isEqualTo("{\"id\":1,\"name\":\"bacon\"}");
		
		// don't map unchanged defaultValue and nullValue properties.
		JsonMapper nonDefaultBinder = JsonMapper.nonDefaultMapper();
		assertThat(nonDefaultBinder.toJson(mapperTestUser)).isEqualTo("{\"name\":\"bacon\"}");
	}
}
