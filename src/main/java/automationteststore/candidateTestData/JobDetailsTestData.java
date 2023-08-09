package automationteststore.candidateTestData;

import automationteststore.tableutils.TestDataTableEntryAppender;

import java.util.HashMap;
import java.util.Map;


public class JobDetailsTestData {

	public static Map<String, String> getTestDataSet(int entryNumber) {
		String entryNo = TestDataTableEntryAppender.getEntryNumberAsStringOrSetToEmptyStringIfZero(entryNumber);
		Map<String, String> jobDetailsTestData = new HashMap<>();
		jobDetailsTestData.put("Job Title", "Nurse Practitioner" + entryNo);
		jobDetailsTestData.put("Employer", "National Health Service" + entryNo);
		jobDetailsTestData.put("Key Tasks", "Taking Care of people" + entryNo);
		jobDetailsTestData.put("Start Month", "12");
		jobDetailsTestData.put("Start Year", "2014");
		jobDetailsTestData.put("Finish Month", "12");
		jobDetailsTestData.put("Finish Year", "2015");
		return jobDetailsTestData;
	}
}
