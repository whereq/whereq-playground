package com.whereq.mapper;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.common.collect.Lists;

@XmlRootElement
@XmlType(propOrder = { "name", "interests" })
public final class MapperTestUser {
	private Long id = 1L;//0L will be regarded as empty!
	private String name;
	private String password;

	private List<String> interests = Lists.newArrayList();

	public MapperTestUser() {
	}

	public MapperTestUser(String name) {
		this.name = name;
	}

	// Map to XML node.
	@XmlAttribute
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Don't map to XML.
	@XmlTransient
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// Map to List<String>, the generated XML looks like: <interests><interest>movie</interest></interests>
	@XmlElementWrapper(name = "interests")
	@XmlElement(name = "interest")
	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
