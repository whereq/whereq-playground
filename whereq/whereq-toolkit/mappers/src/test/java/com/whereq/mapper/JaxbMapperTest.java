package com.whereq.mapper;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.whereq.mapper.JaxbMapper;

/**
 * Sample XML:
 * 
 * <pre>
 * <?xml version="1.0" encoding="UTF-8"?>
 * <mapperTestUser id="1">
 * 	<name>bacon</name>
 * 	<interests>
 * 		<interest>movie</interest>
 * 		<interest>sports</interest>
 * 	</interests>
 * </mapperTestUser>
 * </pre>
 */
public class JaxbMapperTest {

	@Test
	public void objectToXml() {
		MapperTestUser mapperTestUser = new MapperTestUser();
		mapperTestUser.setId(1L);
		mapperTestUser.setName("bacon");

		mapperTestUser.getInterests().add("movie");
		mapperTestUser.getInterests().add("sports");

		String xml = JaxbMapper.toXml(mapperTestUser, "UTF-8");
		System.out.println("Jaxb Object to Xml result:\n" + xml);
		assertXmlByDom4j(xml);
	}

	@Test
	public void xmlToObject() {
		String xml = generateXmlByDom4j();
		MapperTestUser mapperTestUser = JaxbMapper.fromXml(xml, MapperTestUser.class);

		System.out.println("Jaxb Xml to Object result:\n" + mapperTestUser);

		assertThat(mapperTestUser.getId()).isEqualTo(1L);
		assertThat(mapperTestUser.getInterests()).containsOnly("movie", "sports");
	}
	
	@Test
	public void xmlToJson() {
		String xml = generateXmlByDom4j();
		MapperTestUser mapperTestUser = JaxbMapper.fromXml(xml, MapperTestUser.class);

		System.out.println("Jaxb Xml to Object result:\n" + mapperTestUser);

		JsonMapper mapper = JsonMapper.nonDefaultMapper();
		String mapperTestUserString = mapper.toJson(mapperTestUser);
		System.out.println("MapperTestUser:" + mapperTestUserString);
		assertThat(mapperTestUserString).isEqualTo(
				"{\"name\":\"bacon\",\"interests\":[\"movie\",\"sports\"]}");
	}

	/**
	 * Use List object as root node.
	 */
	@Test
	public void toXmlWithListAsRoot() {
		MapperTestUser user1 = new MapperTestUser();
		user1.setId(1L);
		user1.setName("bacon");

		MapperTestUser user2 = new MapperTestUser();
		user2.setId(2L);
		user2.setName("hedy");

		List<MapperTestUser> userList = Lists.newArrayList(user1, user2);

		String xml = JaxbMapper.toXml(userList, "userList", MapperTestUser.class, "UTF-8");
		System.out.println("Jaxb Object List to Xml result:\n" + xml);
	}

	/**
	 * Generate test XML string by using Dom4j.
	 */
	private static String generateXmlByDom4j() {
		Document document = DocumentHelper.createDocument();

		Element root = document.addElement("mapperTestUser").addAttribute("id", "1");

		root.addElement("name").setText("bacon");

		// List<String>
		Element interests = root.addElement("interests");
		interests.addElement("interest").addText("movie");
		interests.addElement("interest").addText("sports");

		return document.asXML();
	}

	/**
	 * Use Dom4j verify XML string.
	 */
	private static void assertXmlByDom4j(String xml) {
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			fail(e.getMessage());
		}
		Element mapperTestUser = doc.getRootElement();
		assertThat(mapperTestUser.attribute("id").getValue()).isEqualTo("1");

		Element interests = (Element) doc.selectSingleNode("//interests");
		assertThat(interests.elements()).hasSize(2);
		assertThat(((Element) interests.elements().get(0)).getText()).isEqualTo("movie");
	}
}
