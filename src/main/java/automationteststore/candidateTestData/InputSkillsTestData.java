package automationteststore.candidateTestData;

import automationteststore.employerTestData.EmployerTestData;

import java.util.HashMap;
import java.util.Map;



public class InputSkillsTestData {
	
	public static final String ESSENTIAL_SKILLS = "Essential Skills";
	public static final String DESIRABLE_SKILLS = "Desirable Skills";
	
			public static Map<String, String> getAllDataForPageNumber(int currentInputSkillPageIndex) {
		String currentInputSkillPageIndexAsString = "";
		if (currentInputSkillPageIndex > 1)
			currentInputSkillPageIndexAsString = " " + Integer.toString(currentInputSkillPageIndex);
		Map<String, String> inputSkillsTestData = new HashMap<>();
		inputSkillsTestData.put("Skill Category", EmployerTestData.SKILL_CATEGORY + currentInputSkillPageIndexAsString);
		inputSkillsTestData.put("Essential Skill",
				EmployerTestData.ESSENTIAL_SKILL + currentInputSkillPageIndexAsString);
		inputSkillsTestData.put("Desirable Skill",
				EmployerTestData.DESIRABLE_SKILL + currentInputSkillPageIndexAsString);
		return inputSkillsTestData;
	}

	// need to add bottom method as employer side code uses differing keys.

	public static Map<String, String> getAllGivenSkills(int currentInputSkillPageIndex) {
		String currentInputSkillPageIndexAsString = "";
		if (currentInputSkillPageIndex > 1)
			currentInputSkillPageIndexAsString = " " + Integer.toString(currentInputSkillPageIndex);
		Map<String, String> inputSkillsTestData = new HashMap<>();
		inputSkillsTestData.put("category", EmployerTestData.SKILL_CATEGORY + currentInputSkillPageIndexAsString);
		inputSkillsTestData.put("essential", EmployerTestData.ESSENTIAL_SKILL + currentInputSkillPageIndexAsString);
		inputSkillsTestData.put("desirable", EmployerTestData.DESIRABLE_SKILL + currentInputSkillPageIndexAsString);
		return inputSkillsTestData;
	}
}
