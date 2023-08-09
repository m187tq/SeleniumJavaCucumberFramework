package automationteststore.maps;

import automationteststore.employerTestData.CreateAccountTestData;

import java.util.HashMap;
import java.util.Map;


public class PageHeadings {
    private static Map<String, String> pageHeadingMap;

    static {
        pageHeadingMap = new HashMap<>();
        pageHeadingMap.put("Professional and vocational training table", "Professional and vocational training");
        pageHeadingMap.put("Applications", "Your applications");
        pageHeadingMap.put("Task list dashboard", CreateAccountTestData.JOB_TITLE+" application");
        pageHeadingMap.put("Application Pause", "You're applying for a " + CreateAccountTestData.JOB_TITLE+" job");
        pageHeadingMap.put("CV Application Pause", "You're applying for a " + CreateAccountTestData.JOB_TITLE+" job");
        pageHeadingMap.put("CV Input", "Copy and paste the text from your CV");
        pageHeadingMap.put("Cautions question", "Do you have any unspent cautions?");
        pageHeadingMap.put("Cautions declaration", "When do you want to tell us about your unspent cautions?");
        pageHeadingMap.put("Cautions details", "Details of your unspent cautions");
        pageHeadingMap.put("Contact Number", "Contact number");
        pageHeadingMap.put("Safeguarding pause", "What information you might have to tell the employer");
        pageHeadingMap.put("Convictions question", "Do you have any convictions and/or cautions that are not protected?");
        pageHeadingMap.put("Convictions declaration", "When do you want to tell us about your convictions and/or cautions that are not protected?");
        pageHeadingMap.put("Conviction details", "Details of your convictions and/or cautions that are not protected");
        pageHeadingMap.put("Offenders exemptions", "What information you might have to tell the employer");
        pageHeadingMap.put("Additional convictions question", "Do you have any convictions that are not protected?");
        pageHeadingMap.put("Additional convictions declaration", "When do you want to tell us about your convictions that are not protected?");
        pageHeadingMap.put("Additional convictions details", "Details of your convictions that are not protected");
        pageHeadingMap.put("Additional cautions question", "Do you have any cautions, reprimands or final warnings that are not protected?");
        pageHeadingMap.put("Additional cautions declaration", "When to tell us about your cautions, reprimands or final warnings that are not protected");
        pageHeadingMap.put("Additional cautions details", "Details of your cautions, reprimands or final warnings that are not protected");
        pageHeadingMap.put("Equality and Diversity Pause", "Equality and diversity monitoring");
        pageHeadingMap.put("Equality And Diversity Gender At Birth", "Is your gender the same as that assigned at birth?");
        pageHeadingMap.put("Equality And Diversity Gender", "What is your gender?");
        pageHeadingMap.put("Application sent", "Application sent");
        pageHeadingMap.put("sexual orientation",
                "Which of the following options best describes how you think of yourself?");
        pageHeadingMap.put("Equality And Diversity Marital Status","What is your marital status?");
        pageHeadingMap.put("Pregnant or maternity",
                "Are you currently pregnant, on maternity/paternity leave or have you given birth in the last 26 weeks?");
        pageHeadingMap.put("Physical Limitation",
                "Do you have a health condition, neurodiversity or disability which has affected your ability to carry out daily activities for 12 months or more?");
        pageHeadingMap.put("Ethnicity", "What is your ethnic group?");
        pageHeadingMap.put("Disability", "Select which neurodiversity or disability you have");
        pageHeadingMap.put("Religion", "What is your religion?");
        pageHeadingMap.put("Essential Skills Pause",
                "Essential criteria for your " + CreateAccountTestData.JOB_TITLE + " application");
        pageHeadingMap.put("Immigration Status", "What is your immigration status?");
        pageHeadingMap.put("Input Skills", "Criteria");
        pageHeadingMap.put("Candidate Job Advert", CreateAccountTestData.JOB_TITLE);
        pageHeadingMap.put("Job history table", "Job history");
        pageHeadingMap.put("Right To Work", "Are you a British or Irish citizen?");
        pageHeadingMap.put("Right To Work EU National", "Are you an EU, European Economic Area (EEA) or Swiss citizen?");
        pageHeadingMap.put("EU Settlement Scheme", "What is your EU Settlement Scheme status?");
        pageHeadingMap.put("Age range", "What is your age?");
        pageHeadingMap.put("Review your application", "Review your application");
        pageHeadingMap.put("adults",
                "Are you currently bound by any barring decision made by the Disclosure Barring Service (DBS) from working with adults?");
        pageHeadingMap.put("children",
                "Are you currently bound by any barring decision made by the Disclosure Barring Service (DBS) from working with children?");
        pageHeadingMap.put("Interview invite", "Read information about your interview before choosing a date and time");
        pageHeadingMap.put("Choose interview slot", "Choose a date and time for your " + CreateAccountTestData.JOB_TITLE + " job interview");
        pageHeadingMap.put("Special requirement question", "Have you got any special requirements we should be aware of?");
        pageHeadingMap.put("Special requirement details", "What special requirements have you got?");
        pageHeadingMap.put("Decline reason", "Why have you declined the interview?");
        pageHeadingMap.put("Check your answers", "Check your answers");
        pageHeadingMap.put("Save application information question", "Are you sure you want to save this application?");
        pageHeadingMap.put("Saved application information", "Saved application information");
        pageHeadingMap.put("Use saved application question", "Do you want to use your saved information for this application?");
        pageHeadingMap.put("Decline confirmation", "You've declined your interview");
        pageHeadingMap.put("Interview declined confirmation", "You've declined your interview");
        pageHeadingMap.put("Interview acceptance confirmation", "You've confirmed your interview");
        pageHeadingMap.put("Interview Request alternative confirmation", "You've requested a different date and time");
        pageHeadingMap.put("Pre Application Qualification Page", "Do you possess "+ CreateAccountTestData.NAME_OF_QUALIFICATION +" qualification or equivalent?");
        pageHeadingMap.put("Pre Application Licence Page", "Do you possess "+ CreateAccountTestData.NAME_OF_LICENCE +" licence?");
        pageHeadingMap.put("Pre Application Registration Page", "Do you possess "+ CreateAccountTestData.NAME_OF_REGISTRATION +" registration?");
        pageHeadingMap.put("Pre Application PLAB2 Page", "Have you passed PLAB 2?");
        pageHeadingMap.put("Pre Application IQE ORE Page", "Have you passed the International Qualifying Exam (IQE) or Overseas Registration Exam (ORE)?");
        pageHeadingMap.put("Pre Application Employer Advertising Page", "Are you currently employed by the Employer advertising this vacancy?");
        pageHeadingMap.put("Application feedback", "Give feedback");
        pageHeadingMap.put("Fitness to Practise Pause", "Fitness to practise investigations and proceedings");
        pageHeadingMap.put("Fitness to Practise Investigation Question", "Are you currently subject to a fitness to practise investigation or any proceedings by a regulatory or licensing body?");
        pageHeadingMap.put("Fitness to Practise Investigation Details", "Tell us about your fitness to practise case");
        pageHeadingMap.put("Fitness to Practise Healthcare Question", "Do any of these statements apply to your healthcare work history?");
        pageHeadingMap.put("Fitness to Practise Healthcare Details", "Tell us about your case");
        pageHeadingMap.put("Fitness to Practise Restrictions Question", "Have you ever had restrictions placed on your clinical practise as a part of the revalidation process?");
        pageHeadingMap.put("Fitness to Practise Restrictions Details", "Tell us about your restrictions");
        pageHeadingMap.put("Save Application Pause", "Save your details from this application");
        pageHeadingMap.put("Application Completed Confirmation", "Application sent");
        pageHeadingMap.put("View and Download Application", "View your application for " + CreateAccountTestData.JOB_TITLE +"");
        pageHeadingMap.put("Pre Application Questions Pause", "You're about to apply for a "+ CreateAccountTestData.JOB_TITLE+" job");
        pageHeadingMap.put("Have you got any qualifications?", "Have you got any qualifications?");
        pageHeadingMap.put("Tell us your immigration status", "Tell us your immigration status");
    }

    public static String getHeadingForPage(String pageName) {
        String pageHeading = pageHeadingMap.get(pageName);
        return pageHeading != null ? pageHeading : pageName;
    }

}
