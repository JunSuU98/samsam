package ji.img.handler;

public class ImgHandlerAdapter {
	private boolean redirect = false;
	private String path = null;
	private String redirectPath = null;

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	// 리다이렉트할 경로 설정 메서드 추가
	public String getRedirectPath() {
        return redirectPath;
	}

	public void setRedirectPath(String redirectPath) {
		this.redirectPath = redirectPath;
	}

}
