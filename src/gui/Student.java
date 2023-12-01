/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import static gui.Home.FindSelectedStudent;
import static gui.Home.academicOfficerMap;
import static gui.Home.batchMap;
import static gui.Home.cityMap;
import static gui.Home.studentPositionMap;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import model.MySQL;
import model.StudentBean;
import model.StudentManager;

/**
 *
 * @author sandaruwan
 */
public class Student extends javax.swing.JPanel {

    /**
     * Creates new form Student
     */
    public Student() {
        initComponents();
        StudentScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        StudentScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        jRadioButton1.setSelected(true);
        jTextArea1.setText("none");
        jTextArea2.setText("I am in good health, both mentally and physically.");
        jTextArea3.setText("none");

        jComboBox1.setModel(loadCities());
        jComboBox4.setModel(loadStudentPositions());

        jComboBox3.setModel(loadBatches());
        jComboBox6.setModel(loadAcademicOfficers());

        jButton21.setEnabled(false);
        jButton37.setEnabled(false);

        loadStudents(jTable1);
    }

    public void StudentDetailGetter(String task){
                
        String fname = jTextField2.getText();
        String lname = jTextField3.getText();

        String dobDate = String.valueOf(jComboBox78.getSelectedItem());
        String dobMonth = String.valueOf(jComboBox77.getSelectedItem());
        String dobYear = String.valueOf(jComboBox72.getSelectedItem());
        String dob = dobYear + "-" + dobMonth + "-" + dobDate;

        String email = jTextField4.getText();
        String mobile = jTextField6.getText();

        String address = jTextArea30.getText();
        String city = String.valueOf(jComboBox1.getSelectedItem());

        String gender = String.valueOf(buttonGroup1.getSelection().getActionCommand());
        String studentID = jTextField8.getText();
        String studentNIC = jTextField28.getText();

        String enrollDate = String.valueOf(jComboBox112.getSelectedItem());
        String enrollMonth = String.valueOf(jComboBox111.getSelectedItem());
        String enrollYear = String.valueOf(jComboBox90.getSelectedItem());
        String studentEnrollDate = enrollYear + "-" + enrollMonth + "-" + enrollDate;

        String studentBatch = String.valueOf(jComboBox3.getSelectedItem());
        String academicOfficer = String.valueOf(jComboBox6.getSelectedItem());

        String School = jTextField24.getText();
        String expGraduationYear = String.valueOf(jComboBox113.getSelectedItem());

        String academicAchievements = jTextArea1.getText();
        String guardianName = jTextField27.getText();
        String guardianMobile = jTextField26.getText();

        String medicalCondition = jTextArea2.getText();
        String emergencyContactNumber = jTextField29.getText();

        boolean consentForExtracurricularActivities = jCheckBox1.isSelected();
        boolean consentForPromotions = jCheckBox2.isSelected();
        boolean SinhalaLanguage = jCheckBox4.isSelected();
        boolean TamilLanguage = jCheckBox5.isSelected();
        boolean EnglishLanguage = jCheckBox3.isSelected();

        String studentPosition = String.valueOf(jComboBox4.getSelectedItem());
        String otherDetails = jTextArea3.getText();

        model.StudentManager.Controller(fname,
                lname,
                dob,
                email,
                mobile,
                address,
                city,
                gender,
                studentID,
                studentNIC,
                studentEnrollDate,
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
                task
                );
    }
    
    public ComboBoxModel loadCities() {
        //load cities
        Vector<String> cityVector = new Vector<>();

        try {
            ResultSet resultSet = MySQL.execute("SELECT * FROM `city`");

            cityVector.add("Select");

            while (resultSet.next()) {
                cityVector.add(resultSet.getString("city_name"));
                cityMap.put(resultSet.getString("city_name"), resultSet.getInt("city_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DefaultComboBoxModel(cityVector);

    }

    public ComboBoxModel loadStudentPositions() {
        //load student positions
        Vector<String> studentPositionVector = new Vector<>();

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `student_position`");

            studentPositionVector.add("Select");

            while (resultSet.next()) {
                studentPositionVector.add(resultSet.getString("position_name"));
                studentPositionMap.put(resultSet.getString("position_name"), resultSet.getInt("sp_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DefaultComboBoxModel(studentPositionVector);

    }

    public ComboBoxModel loadBatches() {
        //load batchs
        Vector<String> batch = new Vector<>();

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `batch`");

            batch.add("Select");

            while (resultSet.next()) {
                batch.add(resultSet.getString("batch_name"));
                batchMap.put(resultSet.getString("batch_name"), resultSet.getInt("batch_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DefaultComboBoxModel(batch);

    }

    public ComboBoxModel loadAcademicOfficers() {
        //load academic officers
        Vector<String> academicOfficers = new Vector<>();

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `academic_officer`");

            academicOfficers.add("Select");

            while (resultSet.next()) {
                academicOfficers.add(resultSet.getString("fname") + " " + resultSet.getString("lname"));
                academicOfficerMap.put(resultSet.getString("fname") + " " + resultSet.getString("lname"), resultSet.getString("Officer_id"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DefaultComboBoxModel(academicOfficers);

    }

    public int generateNewStudentID() {

        int count = 0;

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `student`");

            while (resultSet.next()) {
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int totalCount = count + 1;

        return totalCount;
    }

    public void loadStudents(JTable TableName) {

        try {

            ResultSet resultSet = MySQL.execute("SELECT * FROM `student` "
                    + "INNER JOIN `gender` ON `student`.`gender_id`=`gender`.`id` "
                    + "INNER JOIN `batch` ON `student`.`batch_batch_id`=`batch`.`batch_id` "
                    + "INNER JOIN `city` ON `student`.`city_city_id`=`city`.`city_id` "
                    + "INNER JOIN `academic_officer` ON `student`.`academic_officer_officer_id`=`academic_officer`.`officer_id`"
                    + "ORDER BY `student_id` ASC");

            DefaultTableModel model = (DefaultTableModel) TableName.getModel();
            model.setRowCount(0);

            while (resultSet.next()) {

                Vector<String> v = new Vector<>();
                v.add(resultSet.getString("student_id"));
                v.add(resultSet.getString("fname") + " " + resultSet.getString("lname"));
                v.add(resultSet.getString("dob"));
                v.add(resultSet.getString("email"));
                v.add(resultSet.getString("mobile"));
                v.add(resultSet.getString("nic"));
                v.add(resultSet.getString("address"));
                v.add(resultSet.getString("enroll_date"));
                v.add(resultSet.getString("shcool"));
                v.add(resultSet.getString("gender.name"));
                v.add(resultSet.getString("batch.batch_name"));
                v.add(resultSet.getString("city.city_name"));
                v.add(resultSet.getString("academic_officer.fname") + " " + resultSet.getString("academic_officer.lname"));

                model.addRow(v);
                TableName.setModel(model);

            }
            jLabel2.setText(String.valueOf(jTable1.getRowCount())+" Student");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillStudentFields(String searchID) {
        HashMap<String, String> map = new HashMap<>();
        map.put(searchID, FindSelectedStudent);

        StudentBean studentObj = StudentManager.SearchStudent(map);

        StudentTabbedPane.setSelectedIndex(0);

        jTextField2.setText(studentObj.getFname());
        jTextField3.setText(studentObj.getLname());

        String convertedDobYear = "";
        String convertedDobMonth = "";
        String convertedDobDay = "";

        String convertedEnrollYear = "";
        String convertedEnrollMonth = "";
        String convertedEnrollDay = "";

        String inputFormat = "yyyy-MM-dd";
        String outputYearFormat = "yyyy";
        String outputMonthFormat = "MMM";
        String outputDayFormat = "d";

        SimpleDateFormat inputDateFormat = new SimpleDateFormat(inputFormat);
        SimpleDateFormat outputDateFormatYear = new SimpleDateFormat(outputYearFormat);
        SimpleDateFormat outputDateFormatMonth = new SimpleDateFormat(outputMonthFormat);
        SimpleDateFormat outputDateFormatDay = new SimpleDateFormat(outputDayFormat);

        try {
            java.util.Date dobDate = inputDateFormat.parse(studentObj.getDob());
            convertedDobYear = outputDateFormatYear.format(dobDate);
            convertedDobMonth = outputDateFormatMonth.format(dobDate);
            convertedDobDay = outputDateFormatDay.format(dobDate);

            java.util.Date enrollDate = inputDateFormat.parse(studentObj.getStudentEnrollDate());
            convertedEnrollYear = outputDateFormatYear.format(enrollDate);
            convertedEnrollMonth = outputDateFormatMonth.format(enrollDate);
            convertedEnrollDay = outputDateFormatDay.format(enrollDate);

        } catch (Exception e) {
            e.printStackTrace();
        }

        jComboBox78.setSelectedItem(convertedDobDay);
        jComboBox77.setSelectedItem(convertedDobMonth);
        jComboBox72.setSelectedItem(convertedDobYear);

        jTextField4.setText(studentObj.getEmail());
        jTextField6.setText(studentObj.getMobile());

        jTextArea30.setText(studentObj.getAddress());
        jComboBox1.setSelectedItem(studentObj.getCity());

        if (studentObj.getGender().equals("Male")) {
            jRadioButton1.setSelected(true);

        } else {
            jRadioButton2.setSelected(true);
        }

        jTextField8.setText(studentObj.getStudentID());
        jTextField28.setText(studentObj.getStudentNIC());

        jComboBox112.setSelectedItem(convertedEnrollDay);
        jComboBox111.setSelectedItem(convertedEnrollMonth);
        jComboBox90.setSelectedItem(convertedEnrollYear);

        jComboBox3.setSelectedItem(studentObj.getStudentBatch());
        jComboBox6.setSelectedItem(studentObj.getAcademicOfficer());

        jTextField24.setText(studentObj.getSchool());
        jComboBox113.setSelectedItem(studentObj.getExpGraduationYear());

        jTextArea1.setText(studentObj.getAcademicAchievements());
        jTextField27.setText(studentObj.getGuardianName());
        jTextField26.setText(studentObj.getGuardianMobile());

        jTextArea2.setText(studentObj.getMedicalCondition());
        jTextField29.setText(studentObj.getEmergencyContactNumber());

        if (studentObj.getConsentForExtracurricularActivities().equals("Consented")) {
            jCheckBox1.setSelected(true);
        } else {
            jCheckBox1.setSelected(false);

        }

        if (studentObj.getConsentForPromotions().equals("Consented")) {
            jCheckBox2.setSelected(true);
        } else {
            jCheckBox2.setSelected(false);

        }

        if (studentObj.getEnglishLanguage().equals("Know")) {
            jCheckBox3.setSelected(true);
        } else {
            jCheckBox3.setSelected(false);

        }

        if (studentObj.getSinhalaLanguage().equals("Know")) {
            jCheckBox4.setSelected(true);
        } else {
            jCheckBox4.setSelected(false);

        }

        if (studentObj.getTamilLanguage().equals("Know")) {
            jCheckBox5.setSelected(true);
        } else {
            jCheckBox5.setSelected(false);

        }

        jComboBox4.setSelectedItem(studentObj.getStudentPosition());
        jTextArea3.setText(studentObj.getOtherDetails());

        jTextField1.setText(studentObj.getStudentID());
    }

    public void resetStudentFields() {
        jTextField2.setText("");
        jTextField2.grabFocus();
        jTextField3.setText("");

        jComboBox78.setSelectedIndex(0);
        jComboBox77.setSelectedIndex(0);
        jComboBox72.setSelectedIndex(0);

        jTextField4.setText("");
        jTextField6.setText("");

        jTextArea30.setText("");
        jComboBox1.setSelectedIndex(0);

        jRadioButton1.setSelected(true);
        jTextField8.setText("");
        jTextField28.setText("");

        jComboBox112.setSelectedIndex(0);
        jComboBox111.setSelectedIndex(0);
        jComboBox90.setSelectedIndex(0);

        jComboBox3.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);

        jTextField24.setText("");
        jComboBox113.setSelectedIndex(0);

        jTextArea1.setText("none");
        jTextField27.setText("");
        jTextField26.setText("");

        jTextArea2.setText("I am in good health, both mentally and physically.");
        jTextField29.setText("");

        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
        jCheckBox3.setSelected(false);

        jComboBox4.setSelectedIndex(0);
        jTextArea3.setText("none");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        StudentPanel = new javax.swing.JPanel();
        StudentPanelHeader = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        StudentTabbedPane = new javax.swing.JTabbedPane();
        StudentTabbedPaneRoot1 = new javax.swing.JPanel();
        StudentScrollPane1 = new javax.swing.JScrollPane();
        StudentPanelBody = new javax.swing.JPanel();
        detailGroup1 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel32 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jComboBox72 = new javax.swing.JComboBox<>();
        jComboBox77 = new javax.swing.JComboBox<>();
        jComboBox78 = new javax.swing.JComboBox<>();
        jScrollPane33 = new javax.swing.JScrollPane();
        jTextArea30 = new javax.swing.JTextArea();
        jButton20 = new javax.swing.JButton();
        detailGroup2 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jComboBox111 = new javax.swing.JComboBox<>();
        jComboBox112 = new javax.swing.JComboBox<>();
        jComboBox90 = new javax.swing.JComboBox<>();
        jComboBox113 = new javax.swing.JComboBox<>();
        detailGroup3 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel75 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        detailGroup4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        StudentTabbedPaneRoot2 = new javax.swing.JPanel();
        StudentScrollPane2 = new javax.swing.JScrollPane();
        StudentPanelBody2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel21.setFont(new java.awt.Font("Raleway Thin", 1, 24)); // NOI18N
        jLabel21.setText("Student Management");

        jLabel22.setText("Optimizing Student Management: Add, Remove, Update, and Search with Ease");

        javax.swing.GroupLayout StudentPanelHeaderLayout = new javax.swing.GroupLayout(StudentPanelHeader);
        StudentPanelHeader.setLayout(StudentPanelHeaderLayout);
        StudentPanelHeaderLayout.setHorizontalGroup(
            StudentPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(StudentPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 879, Short.MAX_VALUE))
        );
        StudentPanelHeaderLayout.setVerticalGroup(
            StudentPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelHeaderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel37.setText("Student ID");

        jLabel27.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel27.setText("Identification Details");

        jRadioButton1.setText("Male");
        jRadioButton1.setActionCommand("1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Female");
        jRadioButton2.setActionCommand("2");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel32.setText("Gender");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Colombo", "Matara", "Galle", "Kurunegala", "Gampaha", "Kandy" }));

        jLabel33.setText("City");

        jLabel31.setText("Address");

        jLabel34.setText("Mobile");

        jLabel30.setText("Email");

        jLabel35.setText("Dat of Birth");

        jLabel28.setText("First Name");

        jLabel29.setText("Last Name");

        jLabel36.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel36.setText("Personal Informations");

        jLabel74.setText("NIC ( optional )");

        jComboBox72.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jComboBox77.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        jComboBox78.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jTextArea30.setColumns(20);
        jTextArea30.setRows(5);
        jScrollPane33.setViewportView(jTextArea30);

        jButton20.setText("Set");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout detailGroup1Layout = new javax.swing.GroupLayout(detailGroup1);
        detailGroup1.setLayout(detailGroup1Layout);
        detailGroup1Layout.setHorizontalGroup(
            detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane33)
                    .addGroup(detailGroup1Layout.createSequentialGroup()
                        .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(detailGroup1Layout.createSequentialGroup()
                                .addComponent(jComboBox78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox77, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox72, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel74)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37)
                                .addGroup(detailGroup1Layout.createSequentialGroup()
                                    .addComponent(jRadioButton1)
                                    .addGap(50, 50, 50)
                                    .addComponent(jRadioButton2))
                                .addComponent(jLabel32)
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel33)
                                .addComponent(jLabel31)
                                .addComponent(jTextField6)
                                .addComponent(jTextField4)
                                .addComponent(jLabel34)
                                .addComponent(jLabel30)
                                .addComponent(jLabel35)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup1Layout.createSequentialGroup()
                                    .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                    .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel29)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jTextField28)
                                .addGroup(detailGroup1Layout.createSequentialGroup()
                                    .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(detailGroup1Layout.createSequentialGroup()
                                            .addComponent(jLabel27)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jTextField8))
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        detailGroup1Layout.setVerticalGroup(
            detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup1Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addGap(30, 30, 30)
                .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox78, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox77, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox72, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(30, 30, 30)
                .addComponent(jLabel27)
                .addGap(20, 20, 20)
                .addComponent(jLabel37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailGroup1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(jLabel74, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jLabel38.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel38.setText("Academic Information");

        jLabel40.setText("Date of enrollment");

        jLabel41.setText("Batch");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bison", "Shark", "Cheetath", "Mamath", "Shaire Horse" }));

        jLabel42.setText("Academic Officer");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sanduni Janashantha", "Nuwan Perera", "Sahan Perera" }));

        jLabel65.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel65.setText("Educational Background");

        jLabel66.setText("School or institution attended");

        jLabel69.setText("Expected graduation Year");

        jLabel70.setText("Academic achievements or honors");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel71.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel71.setText(" Guardian Details ");

        jLabel72.setText("Mobile");

        jLabel73.setText("Name");

        jComboBox111.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));

        jComboBox112.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBox90.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));

        jComboBox113.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        javax.swing.GroupLayout detailGroup2Layout = new javax.swing.GroupLayout(detailGroup2);
        detailGroup2.setLayout(detailGroup2Layout);
        detailGroup2Layout.setHorizontalGroup(
            detailGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup2Layout.createSequentialGroup()
                .addGroup(detailGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup2Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(175, 175, 175))
                    .addComponent(jLabel42)
                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66)
                    .addComponent(jTextField24)
                    .addComponent(jLabel69)
                    .addComponent(jLabel70)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextField26)
                    .addGroup(detailGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel71))
                    .addComponent(jLabel73)
                    .addComponent(jTextField27)
                    .addComponent(jLabel41)
                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox113, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(detailGroup2Layout.createSequentialGroup()
                .addComponent(jComboBox112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox111, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox90, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        detailGroup2Layout.setVerticalGroup(
            detailGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup2Layout.createSequentialGroup()
                .addComponent(jLabel38)
                .addGap(30, 30, 30)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detailGroup2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox112, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox111, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox90, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel41)
                .addGap(12, 12, 12)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel65)
                .addGap(20, 20, 20)
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox113, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel71)
                .addGap(20, 20, 20)
                .addComponent(jLabel73)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel72)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jLabel44.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel44.setText("Consent and Permissions");

        jLabel51.setText("Any relevant medical conditions or allergies");

        jLabel53.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel53.setText("Medical Information");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel75.setText("Emergency medical contact Number");

        jCheckBox1.setText("<html>Consent for participation in extracurricular<br>activities or research projects.</html>");
        jCheckBox1.setIconTextGap(12);

        jCheckBox2.setText("<html>Consent for use of student's image or <br>information for promotional purposes.</html>");
        jCheckBox2.setIconTextGap(12);

        jLabel45.setFont(new java.awt.Font("Raleway Thin", 1, 16)); // NOI18N
        jLabel45.setText("Additional Information");

        jLabel43.setText("Language preferences");

        jCheckBox3.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jCheckBox3.setText("English");
        jCheckBox3.setIconTextGap(12);

        jCheckBox4.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jCheckBox4.setText("Sinhala");
        jCheckBox4.setIconTextGap(12);

        jCheckBox5.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jCheckBox5.setText("Tamil");
        jCheckBox5.setIconTextGap(12);

        jLabel46.setText("Any other details");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel47.setText("Student Position");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Team Leader", "Vice-Team Leader", "Squard Leader", "Student", " " }));

        javax.swing.GroupLayout detailGroup3Layout = new javax.swing.GroupLayout(detailGroup3);
        detailGroup3.setLayout(detailGroup3Layout);
        detailGroup3Layout.setHorizontalGroup(
            detailGroup3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(detailGroup3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47)
                    .addComponent(jLabel46)
                    .addComponent(jCheckBox5)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox3)
                    .addComponent(jLabel43)
                    .addComponent(jLabel45)
                    .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel75)
                    .addComponent(jLabel53)
                    .addComponent(jLabel44)
                    .addComponent(jLabel51)
                    .addComponent(jScrollPane2)
                    .addComponent(jTextField29)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        detailGroup3Layout.setVerticalGroup(
            detailGroup3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup3Layout.createSequentialGroup()
                .addComponent(jLabel53)
                .addGap(30, 30, 30)
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel75)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel44)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel45)
                .addGap(20, 20, 20)
                .addComponent(jLabel43)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox5)
                .addGap(20, 20, 20)
                .addComponent(jLabel47)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jButton1.setText("Add New Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Student Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Remove Student");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("Search Students");
        jTextField1.setToolTipText("Search Students");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel48.setText("Select Student (To Edit Details)");

        javax.swing.GroupLayout detailGroup4Layout = new javax.swing.GroupLayout(detailGroup4);
        detailGroup4.setLayout(detailGroup4Layout);
        detailGroup4Layout.setHorizontalGroup(
            detailGroup4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
            .addGroup(detailGroup4Layout.createSequentialGroup()
                .addComponent(jLabel48)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );
        detailGroup4Layout.setVerticalGroup(
            detailGroup4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup4Layout.createSequentialGroup()
                .addComponent(jLabel48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(224, 224, 224))
        );

        jSeparator1.setForeground(new java.awt.Color(65, 77, 87));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout StudentPanelBodyLayout = new javax.swing.GroupLayout(StudentPanelBody);
        StudentPanelBody.setLayout(StudentPanelBodyLayout);
        StudentPanelBodyLayout.setHorizontalGroup(
            StudentPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelBodyLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(detailGroup1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(detailGroup2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(detailGroup3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(detailGroup4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        StudentPanelBodyLayout.setVerticalGroup(
            StudentPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelBodyLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(StudentPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detailGroup4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(StudentPanelBodyLayout.createSequentialGroup()
                        .addComponent(detailGroup3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(StudentPanelBodyLayout.createSequentialGroup()
                        .addGroup(StudentPanelBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(detailGroup1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(detailGroup2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(StudentPanelBodyLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        StudentScrollPane1.setViewportView(StudentPanelBody);

        javax.swing.GroupLayout StudentTabbedPaneRoot1Layout = new javax.swing.GroupLayout(StudentTabbedPaneRoot1);
        StudentTabbedPaneRoot1.setLayout(StudentTabbedPaneRoot1Layout);
        StudentTabbedPaneRoot1Layout.setHorizontalGroup(
            StudentTabbedPaneRoot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentTabbedPaneRoot1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(StudentScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        StudentTabbedPaneRoot1Layout.setVerticalGroup(
            StudentTabbedPaneRoot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentTabbedPaneRoot1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(StudentScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        StudentTabbedPane.addTab("Edit", StudentTabbedPaneRoot1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "DOB", "Email", "Mobile", "NIC", "Address", "Enrolled Date", "School", "Gender", "Batch", "City", "AO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Raleway Thin", 1, 18)); // NOI18N
        jLabel1.setText("Total Students");

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        jLabel2.setText("05 Students");

        jButton21.setText("Edit");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton37.setText("Cancel");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(" ");

        javax.swing.GroupLayout StudentPanelBody2Layout = new javax.swing.GroupLayout(StudentPanelBody2);
        StudentPanelBody2.setLayout(StudentPanelBody2Layout);
        StudentPanelBody2Layout.setHorizontalGroup(
            StudentPanelBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelBody2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(StudentPanelBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(StudentPanelBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(StudentPanelBody2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jButton37)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton21))
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        StudentPanelBody2Layout.setVerticalGroup(
            StudentPanelBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelBody2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(StudentPanelBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        StudentScrollPane2.setViewportView(StudentPanelBody2);

        javax.swing.GroupLayout StudentTabbedPaneRoot2Layout = new javax.swing.GroupLayout(StudentTabbedPaneRoot2);
        StudentTabbedPaneRoot2.setLayout(StudentTabbedPaneRoot2Layout);
        StudentTabbedPaneRoot2Layout.setHorizontalGroup(
            StudentTabbedPaneRoot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentTabbedPaneRoot2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(StudentScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        StudentTabbedPaneRoot2Layout.setVerticalGroup(
            StudentTabbedPaneRoot2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StudentTabbedPaneRoot2Layout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addComponent(StudentScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        StudentTabbedPane.addTab("View Details", StudentTabbedPaneRoot2);

        javax.swing.GroupLayout StudentPanelLayout = new javax.swing.GroupLayout(StudentPanel);
        StudentPanel.setLayout(StudentPanelLayout);
        StudentPanelLayout.setHorizontalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StudentPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(StudentPanelLayout.createSequentialGroup()
                .addComponent(StudentTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        StudentPanelLayout.setVerticalGroup(
            StudentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StudentPanelLayout.createSequentialGroup()
                .addComponent(StudentPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(StudentTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1349, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(StudentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 951, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(StudentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        jTextField8.setText("STU-" + generateNewStudentID());
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        StudentDetailGetter("Register");

        loadStudents(jTable1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        StudentDetailGetter("Update");
        loadStudents(jTable1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if(jTextField1.getText().equals("Search Students")|jTextField1.getText().equals(null)){

        }else{
            String studentID = jTextField1.getText();

            StudentManager.RemoveStudent(studentID);
            JOptionPane.showMessageDialog(this, "Success", "Success", JOptionPane.INFORMATION_MESSAGE);
            loadStudents(jTable1);
            resetStudentFields();
            jTextField1.setText("");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

        FindSelectedStudent = jTextField1.getText();
        fillStudentFields("studentID");

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.getClickCount() == 1) {

            int selectedRow = jTable1.getSelectedRow();

            String studentID = String.valueOf(jTable1.getValueAt(selectedRow, 0));

            FindSelectedStudent = studentID;

            jLabel3.setText(FindSelectedStudent);

            jButton21.setEnabled(true);
            jButton37.setEnabled(true);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed

        fillStudentFields("studentID");
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        FindSelectedStudent = "";
        jLabel3.setText(" ");
        jButton21.setEnabled(false);
        jButton37.setEnabled(false);
    }//GEN-LAST:event_jButton37ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel StudentPanel;
    private javax.swing.JPanel StudentPanelBody;
    private javax.swing.JPanel StudentPanelBody2;
    private javax.swing.JPanel StudentPanelHeader;
    private javax.swing.JScrollPane StudentScrollPane1;
    private javax.swing.JScrollPane StudentScrollPane2;
    private javax.swing.JTabbedPane StudentTabbedPane;
    private javax.swing.JPanel StudentTabbedPaneRoot1;
    private javax.swing.JPanel StudentTabbedPaneRoot2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel detailGroup1;
    private javax.swing.JPanel detailGroup2;
    private javax.swing.JPanel detailGroup3;
    private javax.swing.JPanel detailGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton37;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox111;
    private javax.swing.JComboBox<String> jComboBox112;
    private javax.swing.JComboBox<String> jComboBox113;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox72;
    private javax.swing.JComboBox<String> jComboBox77;
    private javax.swing.JComboBox<String> jComboBox78;
    private javax.swing.JComboBox<String> jComboBox90;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea30;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
