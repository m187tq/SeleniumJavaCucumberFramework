package automationteststore.candidateTestData;

import automationteststore.tableutils.TestDataTableEntryAppender;

import java.util.HashMap;
import java.util.Map;


public class ProfessionalOrVocationalTrainingInputTestData {

	public static Map<String, String> getTestDataSet(int entryNumber) {
		String entryNo = TestDataTableEntryAppender.getEntryNumberAsStringOrSetToEmptyStringIfZero(entryNumber);
		Map<String, String> professionalOrVocationalTrainingInputTestData = new HashMap<>();
		professionalOrVocationalTrainingInputTestData.put("Course title", "Maths" + entryNo);
		professionalOrVocationalTrainingInputTestData.put("Training provider", "Newcastle Uni" + entryNo);
		professionalOrVocationalTrainingInputTestData.put("Year obtained", "2015");
		return professionalOrVocationalTrainingInputTestData;
	}

}
