package njust.PO;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Topic entity. @author MyEclipse Persistence Tools
 */

public class Topic implements java.io.Serializable {

	// Fields

	private String topicId;
	private User user;
	private Timestamp publishTime;
	private String topicName;
	private String topicUrl;
	private String wordDescription;
	private Integer like;
	private Integer downloadNum;
	private String type;
	private String picUrl;
	private Integer hate;
	private Set comments = new HashSet(0);
	private Set tags = new HashSet(0);
	private Set privilegetopics = new HashSet(0);

	// Constructors

	/** default constructor */
	public Topic() {
	}

	/** minimal constructor */
	public Topic(String topicId) {
		this.topicId = topicId;
	}

	/** full constructor */
	public Topic(String topicId, User user, Timestamp publishTime,
			String topicName, String topicUrl, String wordDescription,
			Integer like, Integer downloadNum, String type, String picUrl,
			Integer hate, Set comments, Set tags, Set privilegetopics) {
		this.topicId = topicId;
		this.user = user;
		this.publishTime = publishTime;
		this.topicName = topicName;
		this.topicUrl = topicUrl;
		this.wordDescription = wordDescription;
		this.like = like;
		this.downloadNum = downloadNum;
		this.type = type;
		this.picUrl = picUrl;
		this.hate = hate;
		this.comments = comments;
		this.tags = tags;
		this.privilegetopics = privilegetopics;
	}

	// Property accessors

	public String getTopicId() {
		return this.topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public String getTopicName() {
		return this.topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public String getTopicUrl() {
		return this.topicUrl;
	}

	public void setTopicUrl(String topicUrl) {
		this.topicUrl = topicUrl;
	}

	public String getWordDescription() {
		return this.wordDescription;
	}

	public void setWordDescription(String wordDescription) {
		this.wordDescription = wordDescription;
	}

	public Integer getLike() {
		return this.like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Integer getDownloadNum() {
		return this.downloadNum;
	}

	public void setDownloadNum(Integer downloadNum) {
		this.downloadNum = downloadNum;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getHate() {
		return this.hate;
	}

	public void setHate(Integer hate) {
		this.hate = hate;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getTags() {
		return this.tags;
	}

	public void setTags(Set tags) {
		this.tags = tags;
	}

	public Set getPrivilegetopics() {
		return this.privilegetopics;
	}

	public void setPrivilegetopics(Set privilegetopics) {
		this.privilegetopics = privilegetopics;
	}

}