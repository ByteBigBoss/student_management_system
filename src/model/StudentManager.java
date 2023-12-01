package model;

import gui.Home;
import gui.Student;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class StudentManager {

    StudentManager() {

    }

    public static void Controller(
            String fname,
            String lname,
            String dob,
            String email,
            String mobile,
            String address,
            String city,
            String gender,
            String studentID,
            String studentNIC,
            String studentEnrollDate,
            String studentBatch,
            String academicOfficer,
            String School,
            String expGraduationYear,
            String academicAchievements,
            String guardianName,
            String guardianMobile,
            String medicalCondition,
            String emergencyContactNumber,
            boolean consentForExtracurricularActivities,
            boolean consentForPromotions,
            boolean SinhalaLanguage,
            boolean TamilLanguage,
            boolean EnglishLanguage,
            String studentPosition,
            String otherDetails,
            HashMap<String, Integer> cityMap,
            HashMap<String, Integer> studentPositionMap,
            HashMap<String, Integer> batchMap,
            HashMap<String, String> academicOfficerMap,
            String task
    ) {
        Student Student = new Student();

        String convertedDob = "";
        String convertedStudentEnrollDate = "";

        if (dob != null) {
            String inputFormat = "yyyy-MMM-d";
            String outputFormat = "yyyy-MM-dd";

            SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
            SimpleDateFormat outputDateFormat = new SimpleDateFormat(outputFormat);

            try {
                java.util.Date dobDate = inputDateFormat.parse(dob);
                convertedDob = outputDateFormat.format(dobDate);

                java.util.Date enrollDate = inputDateFormat.parse(studentEnrollDate);
                convertedStudentEnrollDate = outputDateFormat.format(enrollDate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student First Name", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Last Name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (dob.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Date of Birthday", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Email", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (mobile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Mobile Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (address.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Address", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (city.equals("Select")) {
            JOptionPane.showMessageDialog(null, "Please Select City", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select Gender", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (studentID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student ID", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (studentNIC.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student National ID", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (convertedStudentEnrollDate.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Enroll Date", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (studentBatch.equals("Select")) {
            JOptionPane.showMessageDialog(null, "Please Select Batch", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (academicOfficer.equals("Select")) {
            JOptionPane.showMessageDialog(null, "Please Select Academic Officer", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (School.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Previous School or Institute studied", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (expGraduationYear.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Select Expected Graduation Year", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (academicAchievements.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Academic Achievements", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (guardianName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Guardian Name", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (guardianMobile.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Guardian Mobile", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (medicalCondition.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Student Medicale Condition", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (emergencyContactNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Emergency Contact Number", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (!SinhalaLanguage && !TamilLanguage && !EnglishLanguage) {
            JOptionPane.showMessageDialog(null, "Please Select the Languages you prefer", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (studentPosition.equals("Select")) {
            JOptionPane.showMessageDialog(null, "Please Select Student Position", "Warning", JOptionPane.WARNING_MESSAGE);

        } else if (otherDetails.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Enter Other Student Details", "Warning", JOptionPane.WARNING_MESSAGE);

        } else {

            if (task.equals("Register")) {
                RegisterStudent(
                        fname,
                        lname,
                        convertedDob,
                        email,
                        mobile,
                        address,
                        city,
                        gender,
                        studentID,
                        studentNIC,
                        convertedStudentEnrollDate,
                        studentBatch,
                        academicOfficer,
                        School,
                        expGraduationYear,
                        academicAchievements,
                        guardianName,
                        guardianMobile,
                        medicalCondition,
                        emergencyContactNumber,
                        consentForExtracurricularActivities,
                        consentForPromotions,
                        SinhalaLanguage,
                        TamilLanguage,
                        EnglishLanguage,
                        studentPosition,
                        otherDetails,
                        cityMap,
                        studentPositionMap,
                        batchMap,
                        academicOfficerMap,
                        Student
                );
            } else if (task.equals("Update")) {
                UpdateStudent(
                        fname,
                        lname,
                        convertedDob,
                        email,
                        mobile,
                        address,
                        city,
                        gender,
                        studentID,
                        studentNIC,
                        convertedStudentEnrollDate,
                        studentBatch,
                        academicOfficer,
                        School,
                        expGraduationYear,
                        academicAchievements,
                        guardianName,
                        guardianMobile,
                        medicalCondition,
                        emergencyContactNumber,
                        consentForExtracurricularActivities,
                        consentForPromotions,
                        SinhalaLanguage,
                        TamilLanguage,
                        EnglishLanguage,
                        studentPosition,
                        otherDetails,
                        cityMap,
                        studentPositionMap,
                        batchMap,
                        academicOfficerMap,
                        Student
                );
            }

        }

    }

    //register Student
    public static void RegisterStudent(
            String fname,
            String lname,
            String convertedDob,
            String email,
            String mobile,
            String address,
            String city,
            String gender,
            String studentID,
            String studentNIC,
            String convertedStudentEnrollDate,
            String studentBatch,
            String academicOfficer,
            String School,
            String expGraduationYear,
            String academicAchievements,
            String guardianName,
            String guardianMobile,
            String medicalCondition,
            String emergencyContactNumber,
            boolean consentForExtracurricularActivities,
            boolean consentForPromotions,
            boolean SinhalaLanguage,
            boolean TamilLanguage,
            boolean EnglishLanguage,
            String studentPosition,
            String otherDetails,
            HashMap<String, Integer> cityMap,
            HashMap<String, Integer> studentPositionMap,
            HashMap<String, Integer> batchMap,
            HashMap<String, String> academicOfficerMap,
            Student Student
    ) {

        int cityID = cityMap.get(city);
        int batchID = batchMap.get(studentBatch);
        int studentPositionID = studentPositionMap.get(studentPosition);
        String academicOfficerID = academicOfficerMap.get(academicOfficer);

        try {

            MySQL.execute("INSERT INTO `student`"
                    + "(`student_id`,`fname`,`lname`,`dob`,`email`,`mobile`,`nic`,`address`,`enroll_date`,`shcool`,`gender_id`,`batch_batch_id`,`city_city_id`,`academic_officer_officer_id`) "
                    + "VALUES('" + studentID + "','" + fname + "','" + lname + "','" + convertedDob + "','" + email + "','" + mobile + "','" + studentNIC + "','" + address + "','" + convertedStudentEnrollDate + "','" + School + "','" + gender + "','" + batchID + "','" + cityID + "','" + academicOfficerID + "')");

            MySQL.execute("INSERT INTO `student_academic_details`"
                    + "(`expected_graduation_year`,`academic_achievements`,`other_details`,`student_student_id`,`student_position_sp_id`) "
                    + "VALUES('" + expGraduationYear + "','" + academicAchievements + "','" + otherDetails + "','" + studentID + "','" + studentPositionID + "')");

            MySQL.execute("INSERT INTO `student_guardian`"
                    + "(`guardian_name`,`guardian_mobile`,`student_student_id`) "
                    + "VALUES('" + guardianName + "','" + guardianMobile + "','" + studentID + "')");

            if (EnglishLanguage) {
                MySQL.execute("INSERT INTO `student_has_languages`"
                        + "(`student_student_id`,`languages_lang_id`,`language_usage_status_langUsageID`) "
                        + "VALUES('" + studentID + "','1','1')");
            } else {
                MySQL.execute("INSERT INTO `student_has_languages`"
                        + "(`student_student_id`,`languages_lang_id`,`language_usage_status_langUsageID`) "
                        + "VALUES('" + studentID + "','1','2')");
            }

            if (SinhalaLanguage) {
                MySQL.execute("INSERT INTO `student_has_languages`"
                        + "(`student_student_id`,`languages_lang_id`,`language_usage_status_langUsageID`) "
                        + "VALUES('" + studentID + "','2','1')");
            } else {
                MySQL.execute("INSERT INTO `student_has_languages`"
                        + "(`student_student_id`,`languages_lang_id`,`language_usage_status_langUsageID`) "
                        + "VALUES('" + studentID + "','2','2')");
            }

            if (TamilLanguage) {
                MySQL.execute("INSERT INTO `student_has_languages`"
                        + "(`student_student_id`,`languages_lang_id`,`language_usage_status_langUsageID`) "
                        + "VALUES('" + studentID + "','3','1')");
            } else {
                MySQL.execute("INSERT INTO `student_has_languages`"
                        + "(`student_student_id`,`languages_lang_id`,`language_usage_status_langUsageID`) "
                        + "VALUES('" + studentID + "','3','2')");
            }

            String CFEA = "Not Consented";
            String CFP = "Not Consented";

            if (consentForExtracurricularActivities) {
                CFEA = "Consented";
            }

            if (consentForPromotions) {
                CFP = "Consented";
            }

            MySQL.execute("INSERT INTO `student_health`"
                    + "(`medical_condition`,`emergency_contact_number`,`consentForExtracurricularActivities`,`consentForPromotions`,`student_student_id`) "
                    + "VALUES('" + medicalCondition + "','" + emergencyContactNumber + "','" + CFEA + "','" + CFP + "','" + studentID + "')");

            JOptionPane.showMessageDialog(null, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            Student.resetStudentFields();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Update Student
    public static void UpdateStudent(
            String fname,
            String lname,
            String convertedDob,
            String email,
            String mobile,
            String address,
            String city,
            String gender,
            String studentID,
            String studentNIC,
            String convertedStudentEnrollDate,
            String studentBatch,
            String academicOfficer,
            String School,
            String expGraduationYear,
            String academicAchievements,
            String guardianName,
            String guardianMobile,
            String medicalCondition,
            String emergencyContactNumber,
            boolean consentForExtracurricularActivities,
            boolean consentForPromotions,
            boolean SinhalaLanguage,
            boolean TamilLanguage,
            boolean EnglishLanguage,
            String studentPosition,
            String otherDetails,
            HashMap<String, Integer> cityMap,
            HashMap<String, Integer> studentPositionMap,
            HashMap<String, Integer> batchMap,
            HashMap<String, String> academicOfficerMap,
            Student Student
    ) {

        int cityID = cityMap.get(city);
        int batchID = batchMap.get(studentBatch);
        int studentPositionID = studentPositionMap.get(studentPosition);
        String academicOfficerID = academicOfficerMap.get(academicOfficer);

        try {

            MySQL.execute("UPDATE `student` SET "
                    + "`fname`='" + fname + "',`lname`='" + lname + "',`dob`='" + convertedDob + "',`email`='" + email + "',`mobile`='" + mobile + "',`nic`='" + studentNIC + "',`address`='" + address + "',`enroll_date`='" + convertedStudentEnrollDate + "',`shcool`='" + School + "',`gender_id`='" + gender + "',`batch_batch_id`='" + batchID + "',`city_city_id`='" + cityID + "',`academic_officer_officer_id`='" + academicOfficerID + "' "
                    + "WHERE `student_id`='" + studentID + "'");

            MySQL.execute("UPDATE `student_academic_details` SET "
                    + "`expected_graduation_year`='" + expGraduationYear + "',`academic_achievements`='" + academicAchievements + "',`other_details`='" + otherDetails + "',`student_position_sp_id`='" + studentPositionID + "' "
                    + "WHERE `student_student_id`='" + studentID + "'");

            MySQL.execute("UPDATE `student_guardian` SET "
                    + "`guardian_name`='" + guardianName + "',`guardian_mobile`='" + guardianMobile + "' "
                    + "WHERE `student_student_id`='" + studentID + "'");

            //update languages
            if (EnglishLanguage) {
                MySQL.execute("UPDATE`student_has_languages` SET `language_usage_status_langUsageID`='1' WHERE `student_student_id`='" + studentID + "' AND `languages_lang_id`='1'");
            } else {
                MySQL.execute("UPDATE`student_has_languages` SET `language_usage_status_langUsageID`='2' WHERE `student_student_id`='" + studentID + "' AND `languages_lang_id`='1'");
            }

            if (SinhalaLanguage) {
                MySQL.execute("UPDATE`student_has_languages` SET `language_usage_status_langUsageID`='1' WHERE `student_student_id`='" + studentID + "' AND `languages_lang_id`='2'");
            } else {
                MySQL.execute("UPDATE`student_has_languages` SET `language_usage_status_langUsageID`='2' WHERE `student_student_id`='" + studentID + "' AND `languages_lang_id`='2'");
            }

            if (TamilLanguage) {
                MySQL.execute("UPDATE`student_has_languages` SET `language_usage_status_langUsageID`='1' WHERE `student_student_id`='" + studentID + "' AND `languages_lang_id`='3'");
            } else {
                MySQL.execute("UPDATE`student_has_languages` SET `language_usage_status_langUsageID`='2' WHERE `student_student_id`='" + studentID + "' AND `languages_lang_id`='3'");
            }
            //update languages

            String CFEA = "Not Consented";
            String CFP = "Not Consented";

            if (consentForExtracurricularActivities) {
                CFEA = "Consented";
            }

            if (consentForPromotions) {
                CFP = "Consented";
            }

            MySQL.execute("UPDATE `student_health` SET "
                    + "`medical_condition`='" + medicalCondition + "',`emergency_contact_number`='" + emergencyContactNumber + "',`consentForExtracurricularActivities`='" + CFEA + "',`consentForPromotions`='" + CFP + "'"
                    + "WHERE `student_student_id`='" + studentID + "'");

            JOptionPane.showMessageDialog(null, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            Student.resetStudentFields();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void StudentGuardian(StudentBean studentObj, String studentID) {

        try {
            //Student guardian
            ResultSet resultSet = MySQL.execute("SELECT * FROM `student_guardian` WHERE `student_student_id`='" + studentID + "'");

            if (resultSet.next()) {
                studentObj.setGuardianName(resultSet.getString("guardian_name"));
                studentObj.setGuardianMobile(resultSet.getString("guardian_mobile"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void StudentHealth(StudentBean studentObj, String studentID) {

        try {
            //student health
            ResultSet resultSet = MySQL.execute("SELECT * FROM `student_health` WHERE `student_student_id`='" + studentID + "'");

            if (resultSet.next()) {
                studentObj.setMedicalCondition(resultSet.getString("medical_condition"));
                studentObj.setEmergencyContactNumber(resultSet.getString("emergency_contact_number"));
                studentObj.setConsentForExtracurricularActivities(resultSet.getString("consentForExtracurricularActivities"));
                studentObj.setConsentForPromotions(resultSet.getString("consentForPromotions"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void StudentLanguages(StudentBean studentObj, String studentID) {

        String english = "";
        String sinhala = "";
        String tamil = "";

        HashMap<String, String> language = new HashMap<>();

        try {
            //student languages
            ResultSet resultSet = MySQL.execute("SELECT * FROM `student_has_languages` "
                    + "INNER JOIN `languages` ON `student_has_languages`.`languages_lang_id`=`languages`.`lang_id` "
                    + "WHERE `student_student_id`='" + studentID + "'");

            while (resultSet.next()) {

                language.put(resultSet.getString("languages.lang_name"), resultSet.getString("student_has_languages.language_usage_status_langUsageID"));

            }

            if (language.get("English").equals("1")) {
                english = "Know";
            } else {
                english = "none";
            }

            if (language.get("Sinhala").equals("1")) {
                sinhala = "Know";
            } else {
                sinhala = "none";
            }

            if (language.get("Tamil").equals("1")) {
                tamil = "Know";
            } else {
                tamil = "none";
            }

            studentObj.setEnglishLanguage(english);
            studentObj.setSinhalaLanguage(sinhala);
            studentObj.setTamilLanguage(tamil);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void StudentAcademic(StudentBean studentObj, String studentID) {
        ////Student Academic details
        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `student_academic_details` "
                    + "INNER JOIN `student_position` ON `student_academic_details`.`student_position_sp_id`=`student_position`.`sp_id` "
                    + "WHERE `student_student_id`='" + studentID + "'");

            if (resultSet.next()) {
                studentObj.setExpGraduationYear(resultSet.getString("student_academic_details.expected_graduation_year"));
                studentObj.setAcademicAchievements(resultSet.getString("academic_achievements"));
                studentObj.setOtherDetails(resultSet.getString("other_details"));
                studentObj.setStudentPosition(resultSet.getString("student_position.position_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StudentBean SearchStudent(HashMap<String, String> student) {

        StudentBean studentObj = new StudentBean();
        String studentID = "";

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `student` "
                    + "INNER JOIN `gender` ON `student`.`gender_id`=`gender`.`id` "
                    + "INNER JOIN `batch` ON `student`.`batch_batch_id`=`batch`.`batch_id` "
                    + "INNER JOIN `city` ON `student`.`city_city_id`=`city`.`city_id` "
                    + "INNER JOIN `academic_officer` ON `student`.`academic_officer_officer_id`=`academic_officer`.`officer_id`"
                    + "WHERE `student`.`student_id`='" + student.get("studentID") + "' OR `student`.`mobile`='" + student.get("studentID") + "' OR `student`.`email`='" + student.get("studentID") + "'");

            if (resultSet.next()) {

                studentID = resultSet.getString("student.student_id");

                studentObj.setFname(resultSet.getString("student.fname"));
                studentObj.setStudentID(resultSet.getString("student.student_id"));
                studentObj.setLname(resultSet.getString("student.lname"));
                studentObj.setDob(resultSet.getString("student.dob"));
                studentObj.setEmail(resultSet.getString("student.email"));
                studentObj.setMobile(resultSet.getString("student.mobile"));
                studentObj.setStudentNIC(resultSet.getString("student.nic"));
                studentObj.setAddress(resultSet.getString("student.address"));
                studentObj.setStudentEnrollDate(resultSet.getString("student.enroll_date"));
                studentObj.setSchool(resultSet.getString("student.shcool"));
                studentObj.setGender(resultSet.getString("gender.name"));
                studentObj.setStudentBatch(resultSet.getString("batch.batch_name"));
                studentObj.setCity(resultSet.getString("city.city_name"));
                studentObj.setAcademicOfficer(resultSet.getString("academic_officer.fname") + " " + resultSet.getString("academic_officer.lname"));

                StudentAcademic(studentObj, studentID);
                StudentGuardian(studentObj, studentID);
                StudentHealth(studentObj, studentID);
                StudentLanguages(studentObj, studentID);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentObj;
    }
    
    public static void RemoveStudent(String studentID){
        
        try {
            
           ResultSet resultSet =  MySQL.execute("SELECT * FROM `student` WHERE `student_id`='"+studentID+"'");
           ResultSet resultSet2 =  MySQL.execute("SELECT * FROM `student_has_languages` WHERE `student_student_id`='"+studentID+"'");
           
           if(resultSet.next()){
               
               MySQL.execute("DELETE FROM `student_guardian` WHERE `student_student_id`='"+studentID+"'");
               MySQL.execute("DELETE FROM `student_health` WHERE `student_student_id`='"+studentID+"'");
               
               while(resultSet2.next()){
                   MySQL.execute("DELETE FROM `student_has_languages` WHERE `student_student_id`='"+studentID+"'");
               }
               
               MySQL.execute("DELETE FROM `student_academic_details` WHERE `student_student_id`='"+studentID+"'");
               
               MySQL.execute("DELETE FROM `student` WHERE `student`.`student_id`='"+studentID+"'");

               
           }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}
