package biomart.beanClass;

import java.sql.Blob;

public class ImageDetails {
	private String p_id;
	private Blob image;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}

}
