package beangist;

/**
 * Created by Katsiaryna_Skarzhyns on 2/15/2018.
 */
public class Gist {

	private String description;
	private boolean isPublic;
	private GistFile files;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean aPublic) {
		isPublic = aPublic;
	}

	public Object getFiles() {
		return files;
	}

	public void setFiles(GistFile files) {
		this.files = files;
	}
}