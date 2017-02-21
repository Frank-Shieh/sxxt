package sxxt.entity;

public class DataInfo {
	int id;
	String dataName;
	String url;
	int uploadId;
	int uploadRole;
	int dataState;
	int downloadTimes;
	String content;
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUploadId() {
		return uploadId;
	}

	public void setUploadId(int uploadId) {
		this.uploadId = uploadId;
	}

	public int getUploadRole() {
		return uploadRole;
	}

	public void setUploadRole(int uploadRole) {
		this.uploadRole = uploadRole;
	}

	public int getDataState() {
		return dataState;
	}

	public void setDataState(int dataState) {
		this.dataState = dataState;
	}

	public int getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}

	@Override
	public String toString() {
		return "DataInfo [id=" + id + ", dataName=" + dataName + ", url=" + url + ", uploadId=" + uploadId
				+ ", uploadRole=" + uploadRole + ", dataState=" + dataState + ", downloadTimes=" + downloadTimes
				+ ", content=" + content + "]";
	}


}
