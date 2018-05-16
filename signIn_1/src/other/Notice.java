package other;

public class Notice {
	private String notice_name;
	private String notice_context;
	
	public Notice(String notice_name, String notice_context) {
		super();
		this.notice_name = notice_name;
		this.notice_context = notice_context;
	}

	public String getNotice_name() {
		return notice_name;
	}

	public void setNotice_name(String notice_name) {
		this.notice_name = notice_name;
	}

	public String getNotice_context() {
		return notice_context;
	}

	public void setNotice_context(String notice_context) {
		this.notice_context = notice_context;
	}
	
	
}
