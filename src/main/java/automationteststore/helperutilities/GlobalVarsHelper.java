package automationteststore.helperutilities;

public class GlobalVarsHelper {

	private String URL;
	private String responseheaderAuthorisationCode;
	private boolean useAuthcode = false;
	private String candidateUrl;

	private static GlobalVarsHelper ourInstance = new GlobalVarsHelper();

	public static GlobalVarsHelper getInstance() {
		return ourInstance;
	}

	private GlobalVarsHelper() {
	}

	public void setResponseheaderAuthorisationCode(String authCode) {
		this.responseheaderAuthorisationCode = authCode;
	}

	public String getResponseheaderAuthorisationCode() {
		return responseheaderAuthorisationCode;
	}

	public void setURL(String URL) {
		this.URL = URL;
	}

	public String getURL() {
		return URL;
	}
	
	public void setCandidateURL(String URL) {
		candidateUrl = URL;
	}

	public String getCandidateURL() {
		return candidateUrl;
	}

	public void setUseAuthcode(boolean useAuthcode) {
		this.useAuthcode = useAuthcode;
	}

	public boolean isUseAuthcode() {
		return useAuthcode;
	}
}
