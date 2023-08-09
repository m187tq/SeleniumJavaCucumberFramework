package automationteststore.candidateTestData;

import automationteststore.tableutils.TestDataTableEntryAppender;

import java.util.HashMap;
import java.util.Map;

public class AddAcademicQualificationTestData {

	public static Map<String, String> getTestDataSet(int entryNumber) {
		String entryNo = TestDataTableEntryAppender.getEntryNumberAsStringOrSetToEmptyStringIfZero(entryNumber);
		Map<String, String> addAcademicQualificationTestData = new HashMap<>();
		addAcademicQualificationTestData.put("Subject", "Maths" + entryNo);
		addAcademicQualificationTestData.put("Place of study", "Newcastle Uni" + entryNo);
		addAcademicQualificationTestData.put("Result", "D" + entryNo);
		addAcademicQualificationTestData.put("Qualification type", "Bachelors" + entryNo);
		addAcademicQualificationTestData.put("Start Month", "10");
		addAcademicQualificationTestData.put("Start Year", "2013");
		addAcademicQualificationTestData.put("Finish Month", "12");
		addAcademicQualificationTestData.put("Finish Year", "2015");
		return addAcademicQualificationTestData;
	}

}
