package beangist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katsiaryna_Skarzhyns on 2/12/2018.
 */
public class Gist {

	private String description;
	private boolean isPublic;
	private GitFile file;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

	public GitFile getFile() {
		return file;
	}

	public void setFile(GitFile file) {
		this.file = file;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
}