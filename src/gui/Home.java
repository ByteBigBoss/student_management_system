/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkContrastIJTheme;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.util.Vector;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import model.MySQL;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.StudentBean;
import model.StudentManager;

/**
 *
 * @author sandaruwan
 */
public class Home extends javax.swing.JFrame {

    public static HashMap<String, Integer> cityMap = new HashMap();
    public static HashMap<String, Integer> studentPositionMap = new HashMap();
    public static HashMap<String, Integer> batchMap = new HashMap();
    public static HashMap<String, String> academicOfficerMap = new HashMap();

    public static Boolean DashaboardTab = false;
    public static Boolean StudentsTab = false;
    public static Boolean TeachersTab = false;
    public static Boolean SubjectsTab = false;
    public static Boolean ClasesTab = false;
    public static Boolean CoursesTab = false;
    public static Boolean EnrollmentTab = false;
    public static Boolean AttendanceTab = false;
    public static Boolean PaymentTab = false;
    public static Boolean ReportTab = false;

    public static String FindSelectedStudent = "";
    

    /**
     * Creates new form Dashboard
     */
    public Home() {
        
        initComponents();
        
        DashboardScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Student student = new Student();
        Teacher teacher = new Teacher();
        Subject subject = new Subject();
        Class classes = new Class();
        Course course = new Course();
        Enrollment enrollment = new Enrollment();
        Attendance attendance = new Attendance();
        Payment payment = new Payment();
        Report report = new Report();
        
        contentPanel.add(student, "Students");
        contentPanel.add(teacher, "Teachers");
        contentPanel.add(subject, "Subjects");
        contentPanel.add(classes, "Classes");
        contentPanel.add(course, "Courses");
        contentPanel.add(enrollment, "Enrollments");
        contentPanel.add(attendance, "Attendance");
        contentPanel.add(payment, "Payments");
        contentPanel.add(report, "Reports");
        
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "Dashboard");
              
        
    }
    
    
    public void changeTab() {

        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();

        // Navigate to Dashboard Tab
        if (DashaboardTab == true) {

            jButtonDashboard.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonDashboardIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonDashboard.setForeground(new java.awt.Color(255, 121, 100));
            jButtonDashboardIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Dashboard");

        } else {

            jButtonDashboard.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonDashboardIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonDashboard.setForeground(new java.awt.Color(147, 157, 166));
            jButtonDashboardIcon.setForeground(new java.awt.Color(147, 157, 166));

        }

        // Navigate to Student Tab
        if (StudentsTab == true) {

            jButtonStudent.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonStudentIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonStudent.setForeground(new java.awt.Color(255, 121, 100));
            jButtonStudentIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Students");

        } else {

            jButtonStudent.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonStudentIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonStudent.setForeground(new java.awt.Color(147, 157, 166));
            jButtonStudentIcon.setForeground(new java.awt.Color(147, 157, 166));

        }

        // Navigate to Teachers Tab
        if (TeachersTab == true) {

            jButtonTeacher.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonTeacherIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonTeacher.setForeground(new java.awt.Color(255, 121, 100));
            jButtonTeacherIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Teachers");

        } else {

            jButtonTeacher.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonTeacherIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonTeacher.setForeground(new java.awt.Color(147, 157, 166));
            jButtonTeacherIcon.setForeground(new java.awt.Color(147, 157, 166));

        }

        // Navigate to Subjects Tab
        if (SubjectsTab == true) {

            jButtonSubjects.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonSubjectsIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonSubjects.setForeground(new java.awt.Color(255, 121, 100));
            jButtonSubjectsIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Subjects");

        } else {

            jButtonSubjects.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonSubjectsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonSubjects.setForeground(new java.awt.Color(147, 157, 166));
            jButtonSubjectsIcon.setForeground(new java.awt.Color(147, 157, 166));

        }

        // Navigate to Classes Tab
        if (ClasesTab == true) {

            jButtonClasses.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonClassesIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonClasses.setForeground(new java.awt.Color(255, 121, 100));
            jButtonClassesIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Classes");

        } else {
            jButtonClasses.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonClassesIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonClasses.setForeground(new java.awt.Color(147, 157, 166));
            jButtonClassesIcon.setForeground(new java.awt.Color(147, 157, 166));
        }

        // Navigate to Courses Tab
        if (CoursesTab == true) {

            jButtonCourses.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonCoursesIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonCourses.setForeground(new java.awt.Color(255, 121, 100));
            jButtonCoursesIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Courses");

        } else {
            jButtonCourses.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonCoursesIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonCourses.setForeground(new java.awt.Color(147, 157, 166));
            jButtonCoursesIcon.setForeground(new java.awt.Color(147, 157, 166));
        }

        // Navigate to Enrollment Tab
        if (EnrollmentTab == true) {

            jButtonEnrollments.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonEnrollmentsIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonEnrollments.setForeground(new java.awt.Color(255, 121, 100));
            jButtonEnrollmentsIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Enrollments");

        } else {
            jButtonEnrollments.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonEnrollmentsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonEnrollments.setForeground(new java.awt.Color(147, 157, 166));
            jButtonEnrollmentsIcon.setForeground(new java.awt.Color(147, 157, 166));
        }

        // Navigate to Attendance Tab
        if (AttendanceTab == true) {

            jButtonAttendance.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonAttendanceIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonAttendance.setForeground(new java.awt.Color(255, 121, 100));
            jButtonAttendanceIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Attendance");

        } else {
            jButtonAttendance.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonAttendanceIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonAttendance.setForeground(new java.awt.Color(147, 157, 166));
            jButtonAttendanceIcon.setForeground(new java.awt.Color(147, 157, 166));
        }

        // Navigate to Payment Tab
        if (PaymentTab == true) {

            jButtonPayments.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonPaymentsIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonPayments.setForeground(new java.awt.Color(255, 121, 100));
            jButtonPaymentsIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Payments");

        } else {
            jButtonPayments.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonPaymentsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonPayments.setForeground(new java.awt.Color(147, 157, 166));
            jButtonPaymentsIcon.setForeground(new java.awt.Color(147, 157, 166));
        }

        // Navigate to Reports Tab
        if (ReportTab == true) {

            jButtonReports.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonReportsIcon.setFont(new java.awt.Font("SF Pro Text", 1, 14));
            jButtonReports.setForeground(new java.awt.Color(255, 121, 100));
            jButtonReportsIcon.setForeground(new java.awt.Color(255, 121, 100));

            cardLayout.show(contentPanel, "Reports");

        } else {
            jButtonReports.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonReportsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14));
            jButtonReports.setForeground(new java.awt.Color(147, 157, 166));
            jButtonReportsIcon.setForeground(new java.awt.Color(147, 157, 166));
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RootPanel = new javax.swing.JPanel();
        sideMainPanel = new javax.swing.JPanel();
        imagePanel = new javax.swing.JPanel();
        userImage = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButtonStudentIcon = new javax.swing.JButton();
        jButtonStudent = new javax.swing.JButton();
        jButtonTeacher = new javax.swing.JButton();
        jButtonTeacherIcon = new javax.swing.JButton();
        jButtonSubjects = new javax.swing.JButton();
        jButtonSubjectsIcon = new javax.swing.JButton();
        jButtonClasses = new javax.swing.JButton();
        jButtonClassesIcon = new javax.swing.JButton();
        jButtonCoursesIcon = new javax.swing.JButton();
        jButtonCourses = new javax.swing.JButton();
        jButtonEnrollmentsIcon = new javax.swing.JButton();
        jButtonEnrollments = new javax.swing.JButton();
        jButtonAttendanceIcon = new javax.swing.JButton();
        jButtonAttendance = new javax.swing.JButton();
        jButtonPayments = new javax.swing.JButton();
        jButtonPaymentsIcon = new javax.swing.JButton();
        jButtonReports = new javax.swing.JButton();
        jButtonReportsIcon = new javax.swing.JButton();
        jButtonDashboard = new javax.swing.JButton();
        jButtonDashboardIcon = new javax.swing.JButton();
        navBar = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel306 = new javax.swing.JLabel();
        jLabel307 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel308 = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        DashboardPanel = new javax.swing.JPanel();
        DashboardPanelHeader = new javax.swing.JPanel();
        jLabel262 = new javax.swing.JLabel();
        jLabel263 = new javax.swing.JLabel();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jButton44 = new javax.swing.JButton();
        jButton45 = new javax.swing.JButton();
        jButton46 = new javax.swing.JButton();
        DashboardTabbedPaneRoot1 = new javax.swing.JPanel();
        DashboardScrollPane1 = new javax.swing.JScrollPane();
        DashboardPanelBody1 = new javax.swing.JPanel();
        detailGroup37 = new javax.swing.JPanel();
        jLabel264 = new javax.swing.JLabel();
        jLabel265 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jLabel277 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DashUpcomingExmScrollPane = new javax.swing.JScrollPane();
        jPanel13 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel272 = new javax.swing.JLabel();
        jLabel273 = new javax.swing.JLabel();
        jLabel274 = new javax.swing.JLabel();
        jLabel275 = new javax.swing.JLabel();
        jLabel276 = new javax.swing.JLabel();
        jLabel293 = new javax.swing.JLabel();
        jLabel294 = new javax.swing.JLabel();
        jLabel295 = new javax.swing.JLabel();
        jLabel296 = new javax.swing.JLabel();
        jLabel297 = new javax.swing.JLabel();
        jLabel298 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        detailGroup41 = new javax.swing.JPanel();
        jLabel280 = new javax.swing.JLabel();
        jLabel281 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton38 = new javax.swing.JButton();
        jLabel279 = new javax.swing.JLabel();
        detailGroup42 = new javax.swing.JPanel();
        jLabel282 = new javax.swing.JLabel();
        jLabel283 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton39 = new javax.swing.JButton();
        jLabel286 = new javax.swing.JLabel();
        detailGroup43 = new javax.swing.JPanel();
        jLabel284 = new javax.swing.JLabel();
        jLabel285 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton40 = new javax.swing.JButton();
        jLabel287 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        DashAtendanceAvgScrollPane = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel266 = new javax.swing.JLabel();
        jLabel267 = new javax.swing.JLabel();
        jLabel268 = new javax.swing.JLabel();
        jLabel269 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel245 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel271 = new javax.swing.JLabel();
        jLabel270 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        classCard = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel288 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jButton36 = new javax.swing.JButton();
        jLabel289 = new javax.swing.JLabel();
        jLabel290 = new javax.swing.JLabel();
        jLabel292 = new javax.swing.JLabel();
        jLabel291 = new javax.swing.JLabel();
        jLabel299 = new javax.swing.JLabel();
        jLabel300 = new javax.swing.JLabel();
        jLabel301 = new javax.swing.JLabel();
        jLabel303 = new javax.swing.JLabel();
        jLabel302 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel304 = new javax.swing.JLabel();
        jLabel305 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EduHub");

        userImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        javax.swing.GroupLayout imagePanelLayout = new javax.swing.GroupLayout(imagePanel);
        imagePanel.setLayout(imagePanelLayout);
        imagePanelLayout.setHorizontalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(userImage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        imagePanelLayout.setVerticalGroup(
            imagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagePanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(userImage)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("SF Pro Text", 0, 12)); // NOI18N
        jLabel23.setText("Version");

        jLabel24.setFont(new java.awt.Font("SF Pro Text", 0, 11)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("1.0");

        jButtonStudentIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonStudentIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonStudentIcon.setText("􀫔");
        jButtonStudentIcon.setContentAreaFilled(false);
        jButtonStudentIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonStudentIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStudentIconActionPerformed(evt);
            }
        });

        jButtonStudent.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonStudent.setForeground(new java.awt.Color(147, 157, 166));
        jButtonStudent.setText("Students");
        jButtonStudent.setContentAreaFilled(false);
        jButtonStudent.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStudentActionPerformed(evt);
            }
        });

        jButtonTeacher.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonTeacher.setForeground(new java.awt.Color(147, 157, 166));
        jButtonTeacher.setText("Teachers");
        jButtonTeacher.setContentAreaFilled(false);
        jButtonTeacher.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTeacherActionPerformed(evt);
            }
        });

        jButtonTeacherIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonTeacherIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonTeacherIcon.setText("􁅁");
        jButtonTeacherIcon.setContentAreaFilled(false);
        jButtonTeacherIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonTeacherIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTeacherIconActionPerformed(evt);
            }
        });

        jButtonSubjects.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonSubjects.setForeground(new java.awt.Color(147, 157, 166));
        jButtonSubjects.setText("Subjects");
        jButtonSubjects.setContentAreaFilled(false);
        jButtonSubjects.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonSubjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubjectsActionPerformed(evt);
            }
        });

        jButtonSubjectsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonSubjectsIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonSubjectsIcon.setText("􀬓");
        jButtonSubjectsIcon.setContentAreaFilled(false);
        jButtonSubjectsIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonSubjectsIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubjectsIconActionPerformed(evt);
            }
        });

        jButtonClasses.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonClasses.setForeground(new java.awt.Color(147, 157, 166));
        jButtonClasses.setText("Classes");
        jButtonClasses.setContentAreaFilled(false);
        jButtonClasses.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClassesActionPerformed(evt);
            }
        });

        jButtonClassesIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonClassesIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonClassesIcon.setText("􀟼");
        jButtonClassesIcon.setContentAreaFilled(false);
        jButtonClassesIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonClassesIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClassesIconActionPerformed(evt);
            }
        });

        jButtonCoursesIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonCoursesIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonCoursesIcon.setText("􀉛");
        jButtonCoursesIcon.setContentAreaFilled(false);
        jButtonCoursesIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonCoursesIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCoursesIconActionPerformed(evt);
            }
        });

        jButtonCourses.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonCourses.setForeground(new java.awt.Color(147, 157, 166));
        jButtonCourses.setText("Courses");
        jButtonCourses.setContentAreaFilled(false);
        jButtonCourses.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonCourses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCoursesActionPerformed(evt);
            }
        });

        jButtonEnrollmentsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonEnrollmentsIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonEnrollmentsIcon.setText("􁘋");
        jButtonEnrollmentsIcon.setContentAreaFilled(false);
        jButtonEnrollmentsIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonEnrollmentsIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnrollmentsIconActionPerformed(evt);
            }
        });

        jButtonEnrollments.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonEnrollments.setForeground(new java.awt.Color(147, 157, 166));
        jButtonEnrollments.setText("Enrollments");
        jButtonEnrollments.setContentAreaFilled(false);
        jButtonEnrollments.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonEnrollments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnrollmentsActionPerformed(evt);
            }
        });

        jButtonAttendanceIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonAttendanceIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonAttendanceIcon.setText("􀧞");
        jButtonAttendanceIcon.setContentAreaFilled(false);
        jButtonAttendanceIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonAttendanceIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAttendanceIconActionPerformed(evt);
            }
        });

        jButtonAttendance.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonAttendance.setForeground(new java.awt.Color(147, 157, 166));
        jButtonAttendance.setText("Attendance");
        jButtonAttendance.setContentAreaFilled(false);
        jButtonAttendance.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAttendanceActionPerformed(evt);
            }
        });

        jButtonPayments.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonPayments.setForeground(new java.awt.Color(147, 157, 166));
        jButtonPayments.setText("Payments");
        jButtonPayments.setContentAreaFilled(false);
        jButtonPayments.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaymentsActionPerformed(evt);
            }
        });

        jButtonPaymentsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonPaymentsIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonPaymentsIcon.setText("􀮀");
        jButtonPaymentsIcon.setContentAreaFilled(false);
        jButtonPaymentsIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonPaymentsIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPaymentsIconActionPerformed(evt);
            }
        });

        jButtonReports.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonReports.setForeground(new java.awt.Color(147, 157, 166));
        jButtonReports.setText("Reports");
        jButtonReports.setContentAreaFilled(false);
        jButtonReports.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportsActionPerformed(evt);
            }
        });

        jButtonReportsIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonReportsIcon.setForeground(new java.awt.Color(147, 157, 166));
        jButtonReportsIcon.setText("􀉀");
        jButtonReportsIcon.setContentAreaFilled(false);
        jButtonReportsIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonReportsIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportsIconActionPerformed(evt);
            }
        });

        jButtonDashboard.setFont(new java.awt.Font("SF Pro Text", 1, 14)); // NOI18N
        jButtonDashboard.setForeground(new java.awt.Color(255, 121, 100));
        jButtonDashboard.setText("Dashboard");
        jButtonDashboard.setContentAreaFilled(false);
        jButtonDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButtonDashboard.setMargin(new java.awt.Insets(2, 12, 2, 14));
        jButtonDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDashboardActionPerformed(evt);
            }
        });

        jButtonDashboardIcon.setFont(new java.awt.Font("SF Pro Text", 0, 14)); // NOI18N
        jButtonDashboardIcon.setForeground(new java.awt.Color(255, 121, 100));
        jButtonDashboardIcon.setText("􀎟");
        jButtonDashboardIcon.setContentAreaFilled(false);
        jButtonDashboardIcon.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButtonDashboardIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDashboardIconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sideMainPanelLayout = new javax.swing.GroupLayout(sideMainPanel);
        sideMainPanel.setLayout(sideMainPanelLayout);
        sideMainPanelLayout.setHorizontalGroup(
            sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMainPanelLayout.createSequentialGroup()
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
            .addGroup(sideMainPanelLayout.createSequentialGroup()
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sideMainPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(sideMainPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonTeacherIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSubjectsIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonClassesIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCoursesIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonReportsIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEnrollmentsIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAttendanceIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPaymentsIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonStudentIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonDashboardIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonTeacher)
                            .addComponent(jButtonStudent)
                            .addComponent(jButtonSubjects)
                            .addComponent(jButtonClasses)
                            .addComponent(jButtonCourses)
                            .addComponent(jButtonEnrollments)
                            .addComponent(jButtonAttendance)
                            .addComponent(jButtonPayments)
                            .addComponent(jButtonReports)
                            .addComponent(jButtonDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        sideMainPanelLayout.setVerticalGroup(
            sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideMainPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(imagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDashboardIcon)
                    .addComponent(jButtonDashboard))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStudentIcon)
                    .addComponent(jButtonStudent))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTeacherIcon)
                    .addComponent(jButtonTeacher))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSubjectsIcon)
                    .addComponent(jButtonSubjects))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClassesIcon)
                    .addComponent(jButtonClasses))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCoursesIcon)
                    .addComponent(jButtonCourses))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnrollmentsIcon)
                    .addComponent(jButtonEnrollments))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAttendanceIcon)
                    .addComponent(jButtonAttendance))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPaymentsIcon)
                    .addComponent(jButtonPayments))
                .addGap(28, 28, 28)
                .addGroup(sideMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonReportsIcon)
                    .addComponent(jButtonReports))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(60, 60, 60))
        );

        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel67.setText("12:24");

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/profile.jpg"))); // NOI18N

        jSeparator4.setForeground(new java.awt.Color(65, 77, 87));

        jLabel306.setFont(new java.awt.Font("SF Pro Text", 0, 13)); // NOI18N
        jLabel306.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel306.setText("Nethmina Sandaruwan");

        jLabel307.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel307.setText("PM");

        jLabel308.setFont(new java.awt.Font("Itim", 1, 14)); // NOI18N
        jLabel308.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel308.setText("Your Session: 00:45:23");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(0, 104, Short.MAX_VALUE)
                .addComponent(jLabel308, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel308, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel307)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel306, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel68)
                .addGap(30, 30, 30))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel306, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel307, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contentPanel.setLayout(new java.awt.CardLayout());

        jLabel262.setFont(new java.awt.Font("Raleway Thin", 1, 24)); // NOI18N
        jLabel262.setText("Dashboard");

        jLabel263.setText("Centralized Overview: Empowering Data-Driven Decision Making with an Interactive Dashboard");

        jButton41.setText("Register Student");

        jButton42.setText("Register Teacher");

        jButton43.setText("Register Academic Officer");

        jButton44.setText("Add New Course");

        jButton45.setText("Add New Subject");

        jButton46.setText("Add New Class");

        javax.swing.GroupLayout DashboardPanelHeaderLayout = new javax.swing.GroupLayout(DashboardPanelHeader);
        DashboardPanelHeader.setLayout(DashboardPanelHeaderLayout);
        DashboardPanelHeaderLayout.setHorizontalGroup(
            DashboardPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardPanelHeaderLayout.createSequentialGroup()
                        .addComponent(jButton41)
                        .addGap(18, 18, 18)
                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton43)
                        .addGap(18, 18, 18)
                        .addComponent(jButton44)
                        .addGap(18, 18, 18)
                        .addComponent(jButton45)
                        .addGap(18, 18, 18)
                        .addComponent(jButton46))
                    .addComponent(jLabel263)
                    .addComponent(jLabel262))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DashboardPanelHeaderLayout.setVerticalGroup(
            DashboardPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelHeaderLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel262)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel263, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(DashboardPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton45, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton46, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        detailGroup37.setBackground(new java.awt.Color(43, 48, 55));
        detailGroup37.setPreferredSize(new java.awt.Dimension(280, 99));

        jLabel264.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel264.setText("2,345");

        jLabel265.setBackground(new java.awt.Color(43, 48, 55));
        jLabel265.setFont(new java.awt.Font("Raleway Thin", 1, 14)); // NOI18N
        jLabel265.setForeground(new java.awt.Color(255, 71, 159));
        jLabel265.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel265.setText("Students");
        jLabel265.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 204), 1, true));
        jLabel265.setOpaque(true);
        jLabel265.setSize(new java.awt.Dimension(80, 24));

        jPanel5.setBackground(new java.awt.Color(255, 71, 159));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jButton35.setFont(new java.awt.Font("SF Pro", 0, 18)); // NOI18N
        jButton35.setText("􀅵");
        jButton35.setContentAreaFilled(false);
        jButton35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton35.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jLabel277.setFont(new java.awt.Font("SF Pro", 1, 36)); // NOI18N
        jLabel277.setForeground(new java.awt.Color(255, 71, 159));
        jLabel277.setText("􀫔");

        javax.swing.GroupLayout detailGroup37Layout = new javax.swing.GroupLayout(detailGroup37);
        detailGroup37.setLayout(detailGroup37Layout);
        detailGroup37Layout.setHorizontalGroup(
            detailGroup37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(detailGroup37Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(detailGroup37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailGroup37Layout.createSequentialGroup()
                        .addComponent(jLabel265, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton35)
                        .addGap(12, 12, 12))
                    .addGroup(detailGroup37Layout.createSequentialGroup()
                        .addComponent(jLabel264)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(jLabel277)
                        .addGap(18, 18, 18))))
        );
        detailGroup37Layout.setVerticalGroup(
            detailGroup37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup37Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(detailGroup37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel265, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(detailGroup37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailGroup37Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel264)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup37Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel277)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(43, 48, 55));

        jLabel4.setFont(new java.awt.Font("Raleway Thin", 1, 18)); // NOI18N
        jLabel4.setText("Upcoming Exams and Assignments");

        jLabel5.setFont(new java.awt.Font("Raleway Thin", 0, 14)); // NOI18N
        jLabel5.setText("Admin Insights: Upcoming Exams and Assignments Snapshot");

        jPanel15.setBackground(new java.awt.Color(35, 38, 42));

        jPanel16.setBackground(new java.awt.Color(37, 216, 0));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel272.setFont(new java.awt.Font("Fira Code iScript", 3, 14)); // NOI18N
        jLabel272.setText("Writing Exam 1");

        jLabel273.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel273.setText("2023-08-12");

        jLabel274.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel274.setText("SAD");

        jLabel275.setFont(new java.awt.Font("SF Pro Rounded", 1, 13)); // NOI18N
        jLabel275.setText("Colombo Head Office");

        jLabel276.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel276.setText("09:00 AM TO 12:00 PM");

        jLabel293.setFont(new java.awt.Font("Raleway Thin", 1, 36)); // NOI18N
        jLabel293.setText("3h");

        jLabel294.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel294.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel294.setText("􀎫");

        jLabel295.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel295.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel295.setText("􀹵");

        jLabel296.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel296.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel296.setText("􀉉");

        jLabel297.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel297.setText("Bison");

        jLabel298.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel298.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel298.setText("􁂛");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel274)
                                    .addComponent(jLabel272))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel293))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel294, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel295, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel296, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel273)
                                            .addComponent(jLabel276)))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel275)))
                                .addGap(0, 94, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel298, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel297)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel274)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel272)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel298)
                            .addComponent(jLabel297))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel273)
                            .addComponent(jLabel296))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel276)
                            .addComponent(jLabel295))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel275, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel294))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel293)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel11.setBackground(new java.awt.Color(35, 38, 42));

        jPanel12.setBackground(new java.awt.Color(37, 216, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Fira Code iScript", 3, 14)); // NOI18N
        jLabel6.setText("Writing Exam 1");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel7.setText("2023-08-12");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel8.setText("SAD");

        jLabel9.setFont(new java.awt.Font("SF Pro Rounded", 1, 13)); // NOI18N
        jLabel9.setText("Colombo Head Office");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jLabel10.setText("09:00 AM TO 12:00 PM");

        jLabel11.setFont(new java.awt.Font("Raleway Thin", 1, 36)); // NOI18N
        jLabel11.setText("3h");

        jLabel12.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("􀎫");

        jLabel13.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("􀹵");

        jLabel14.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("􀉉");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Bison");

        jLabel17.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("􁂛");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel10)))
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel9))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel16)))
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(25, 25, 25))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        DashUpcomingExmScrollPane.setViewportView(jPanel13);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(DashUpcomingExmScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(26, 26, 26)
                .addComponent(DashUpcomingExmScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        detailGroup41.setBackground(new java.awt.Color(43, 48, 55));
        detailGroup41.setPreferredSize(new java.awt.Dimension(280, 99));

        jLabel280.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel280.setText("32");

        jLabel281.setBackground(new java.awt.Color(43, 48, 55));
        jLabel281.setFont(new java.awt.Font("Raleway Thin", 1, 14)); // NOI18N
        jLabel281.setForeground(new java.awt.Color(71, 193, 255));
        jLabel281.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel281.setText("Teachers");
        jLabel281.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 255), 1, true));
        jLabel281.setOpaque(true);
        jLabel281.setSize(new java.awt.Dimension(80, 24));

        jPanel6.setBackground(new java.awt.Color(71, 193, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jButton38.setFont(new java.awt.Font("SF Pro", 0, 18)); // NOI18N
        jButton38.setText("􀅵");
        jButton38.setContentAreaFilled(false);
        jButton38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton38.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jLabel279.setFont(new java.awt.Font("SF Pro", 1, 36)); // NOI18N
        jLabel279.setForeground(new java.awt.Color(71, 193, 255));
        jLabel279.setText("􁅁");

        javax.swing.GroupLayout detailGroup41Layout = new javax.swing.GroupLayout(detailGroup41);
        detailGroup41.setLayout(detailGroup41Layout);
        detailGroup41Layout.setHorizontalGroup(
            detailGroup41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(detailGroup41Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(detailGroup41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailGroup41Layout.createSequentialGroup()
                        .addComponent(jLabel281, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(jButton38)
                        .addGap(12, 12, 12))
                    .addGroup(detailGroup41Layout.createSequentialGroup()
                        .addComponent(jLabel280)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel279)
                        .addGap(18, 18, 18))))
        );
        detailGroup41Layout.setVerticalGroup(
            detailGroup41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup41Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(detailGroup41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel281, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(detailGroup41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailGroup41Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel280)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(detailGroup41Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel279)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        detailGroup42.setBackground(new java.awt.Color(43, 48, 55));
        detailGroup42.setPreferredSize(new java.awt.Dimension(280, 99));

        jLabel282.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel282.setText("13");

        jLabel283.setBackground(new java.awt.Color(43, 48, 55));
        jLabel283.setFont(new java.awt.Font("Raleway Thin", 1, 14)); // NOI18N
        jLabel283.setForeground(new java.awt.Color(37, 216, 0));
        jLabel283.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel283.setText("Courses");
        jLabel283.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 204, 0), 1, true));
        jLabel283.setOpaque(true);
        jLabel283.setSize(new java.awt.Dimension(80, 24));

        jPanel7.setBackground(new java.awt.Color(37, 216, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jButton39.setFont(new java.awt.Font("SF Pro", 0, 18)); // NOI18N
        jButton39.setText("􀅵");
        jButton39.setContentAreaFilled(false);
        jButton39.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton39.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jLabel286.setFont(new java.awt.Font("SF Pro", 1, 36)); // NOI18N
        jLabel286.setForeground(new java.awt.Color(37, 216, 0));
        jLabel286.setText("􀉛");

        javax.swing.GroupLayout detailGroup42Layout = new javax.swing.GroupLayout(detailGroup42);
        detailGroup42.setLayout(detailGroup42Layout);
        detailGroup42Layout.setHorizontalGroup(
            detailGroup42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(detailGroup42Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(detailGroup42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup42Layout.createSequentialGroup()
                        .addComponent(jLabel283, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton39)
                        .addGap(12, 12, 12))
                    .addGroup(detailGroup42Layout.createSequentialGroup()
                        .addComponent(jLabel282)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                        .addComponent(jLabel286)
                        .addGap(18, 18, 18))))
        );
        detailGroup42Layout.setVerticalGroup(
            detailGroup42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup42Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(detailGroup42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel283, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(detailGroup42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailGroup42Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel282)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup42Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel286)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        detailGroup43.setBackground(new java.awt.Color(43, 48, 55));
        detailGroup43.setPreferredSize(new java.awt.Dimension(280, 99));

        jLabel284.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel284.setText("53");

        jLabel285.setBackground(new java.awt.Color(43, 48, 55));
        jLabel285.setFont(new java.awt.Font("Raleway Thin", 1, 14)); // NOI18N
        jLabel285.setForeground(new java.awt.Color(177, 144, 255));
        jLabel285.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel285.setText("Subjects");
        jLabel285.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 204), 1, true));
        jLabel285.setOpaque(true);
        jLabel285.setSize(new java.awt.Dimension(80, 24));

        jPanel8.setBackground(new java.awt.Color(126, 71, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jButton40.setFont(new java.awt.Font("SF Pro", 0, 18)); // NOI18N
        jButton40.setText("􀅵");
        jButton40.setContentAreaFilled(false);
        jButton40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton40.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        jLabel287.setFont(new java.awt.Font("SF Pro", 1, 36)); // NOI18N
        jLabel287.setForeground(new java.awt.Color(126, 71, 255));
        jLabel287.setText("􀬓");

        javax.swing.GroupLayout detailGroup43Layout = new javax.swing.GroupLayout(detailGroup43);
        detailGroup43.setLayout(detailGroup43Layout);
        detailGroup43Layout.setHorizontalGroup(
            detailGroup43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(detailGroup43Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(detailGroup43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup43Layout.createSequentialGroup()
                        .addComponent(jLabel285, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton40)
                        .addGap(12, 12, 12))
                    .addGroup(detailGroup43Layout.createSequentialGroup()
                        .addComponent(jLabel284)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                        .addComponent(jLabel287)
                        .addGap(18, 18, 18))))
        );
        detailGroup43Layout.setVerticalGroup(
            detailGroup43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detailGroup43Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(detailGroup43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel285, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(detailGroup43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detailGroup43Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel284)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detailGroup43Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel287)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel10.setBackground(new java.awt.Color(43, 48, 55));

        jLabel15.setFont(new java.awt.Font("Raleway Thin", 1, 18)); // NOI18N
        jLabel15.setText("Attendance");

        jLabel18.setFont(new java.awt.Font("Raleway Thin", 0, 14)); // NOI18N
        jLabel18.setText("A Comprehensive Overview of Average Attendance");

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel19.setText("#C80233");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Members");

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Attended");

        jLabel266.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel266.setText("Average");

        jLabel267.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel267.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel267.setText("480");

        jLabel268.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel268.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel268.setText("393");

        jLabel269.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel269.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel269.setText("81.875%");

        jProgressBar1.setToolTipText("");
        jProgressBar1.setValue(81);

        jLabel245.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel245.setText("2023-07-14");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel267, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel268, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel269, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(jLabel266, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(56, 56, 56))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel245)
                        .addGap(20, 20, 20))))
            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel245))
                .addGap(20, 20, 20)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel39)
                    .addComponent(jLabel266))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel267)
                    .addComponent(jLabel268)
                    .addComponent(jLabel269))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 100, Short.MAX_VALUE))
        );

        DashAtendanceAvgScrollPane.setViewportView(jPanel9);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel15)
                    .addComponent(DashAtendanceAvgScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18)
                .addGap(26, 26, 26)
                .addComponent(DashAtendanceAvgScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel271.setFont(new java.awt.Font("Raleway Thin", 0, 13)); // NOI18N
        jLabel271.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel271.setText("Explore All Scheduled Classes at a Glance");

        jLabel270.setFont(new java.awt.Font("Raleway Thin", 1, 20)); // NOI18N
        jLabel270.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel270.setText("Class Schedules");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel270, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel271, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel270)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel271, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        classCard.setBackground(new java.awt.Color(43, 48, 55));

        jPanel27.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jLabel288.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        jLabel288.setText("#C80233");

        jSeparator8.setForeground(new java.awt.Color(65, 77, 87));

        jButton36.setFont(new java.awt.Font("Raleway Thin", 1, 13)); // NOI18N
        jButton36.setText("Share Link");

        jLabel289.setText("09:00 AM TO 12:00 PM");

        jLabel290.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel290.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel290.setText("􀹵");

        jLabel292.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel292.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel292.setText("􀎫");

        jLabel291.setFont(new java.awt.Font("SF Pro Rounded", 1, 13)); // NOI18N
        jLabel291.setText("Colombo Head Office");

        jLabel299.setText("2023-08-12");

        jLabel300.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel300.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel300.setText("􀉉");

        jLabel301.setFont(new java.awt.Font("Raleway Thin", 1, 36)); // NOI18N
        jLabel301.setText("3h");

        jLabel303.setFont(new java.awt.Font("Fira Code iScript", 3, 14)); // NOI18N
        jLabel303.setText("Bison");

        jLabel302.setFont(new java.awt.Font("Helvetica Neue", 1, 16)); // NOI18N
        jLabel302.setText("SAD");

        jSeparator9.setForeground(new java.awt.Color(65, 77, 87));

        jLabel304.setText("Online");

        jLabel305.setFont(new java.awt.Font("SF Pro", 0, 14)); // NOI18N
        jLabel305.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel305.setText("􀤆");

        javax.swing.GroupLayout classCardLayout = new javax.swing.GroupLayout(classCard);
        classCard.setLayout(classCardLayout);
        classCardLayout.setHorizontalGroup(
            classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator8)
            .addGroup(classCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, classCardLayout.createSequentialGroup()
                        .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(classCardLayout.createSequentialGroup()
                                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel302)
                                    .addComponent(jLabel303))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel301))
                            .addComponent(jButton36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(classCardLayout.createSequentialGroup()
                                .addComponent(jLabel288)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(classCardLayout.createSequentialGroup()
                        .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel305, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel290, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel292, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel300, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(classCardLayout.createSequentialGroup()
                                .addComponent(jLabel289)
                                .addContainerGap(87, Short.MAX_VALUE))
                            .addGroup(classCardLayout.createSequentialGroup()
                                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel291)
                                    .addComponent(jLabel304)
                                    .addComponent(jLabel299))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        classCardLayout.setVerticalGroup(
            classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(classCardLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel288)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(classCardLayout.createSequentialGroup()
                        .addComponent(jLabel302)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel303))
                    .addComponent(jLabel301, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel305)
                    .addComponent(jLabel304))
                .addGap(18, 18, 18)
                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel300)
                    .addComponent(jLabel299))
                .addGap(18, 18, 18)
                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel289)
                    .addComponent(jLabel290))
                .addGap(18, 18, 18)
                .addGroup(classCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel291, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel292))
                .addGap(28, 28, 28)
                .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(classCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(classCard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DashboardPanelBody1Layout = new javax.swing.GroupLayout(DashboardPanelBody1);
        DashboardPanelBody1.setLayout(DashboardPanelBody1Layout);
        DashboardPanelBody1Layout.setHorizontalGroup(
            DashboardPanelBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelBody1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(DashboardPanelBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(DashboardPanelBody1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DashboardPanelBody1Layout.createSequentialGroup()
                        .addComponent(detailGroup37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(detailGroup41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(detailGroup42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(detailGroup43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        DashboardPanelBody1Layout.setVerticalGroup(
            DashboardPanelBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelBody1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(DashboardPanelBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(detailGroup37, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailGroup41, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailGroup42, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailGroup43, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(DashboardPanelBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        DashboardScrollPane1.setViewportView(DashboardPanelBody1);

        javax.swing.GroupLayout DashboardTabbedPaneRoot1Layout = new javax.swing.GroupLayout(DashboardTabbedPaneRoot1);
        DashboardTabbedPaneRoot1.setLayout(DashboardTabbedPaneRoot1Layout);
        DashboardTabbedPaneRoot1Layout.setHorizontalGroup(
            DashboardTabbedPaneRoot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1329, Short.MAX_VALUE)
        );
        DashboardTabbedPaneRoot1Layout.setVerticalGroup(
            DashboardTabbedPaneRoot1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardPanelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addComponent(DashboardTabbedPaneRoot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addComponent(DashboardPanelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(DashboardTabbedPaneRoot1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1349, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(DashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(DashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        contentPanel.add(jPanel1, "Dashboard");

        javax.swing.GroupLayout RootPanelLayout = new javax.swing.GroupLayout(RootPanel);
        RootPanel.setLayout(RootPanelLayout);
        RootPanelLayout.setHorizontalGroup(
            RootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RootPanelLayout.createSequentialGroup()
                .addComponent(sideMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(navBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RootPanelLayout.setVerticalGroup(
            RootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RootPanelLayout.createSequentialGroup()
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(RootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sideMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(RootPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStudentIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStudentIconActionPerformed
        jButtonStudentActionPerformed(evt);
    }//GEN-LAST:event_jButtonStudentIconActionPerformed

    private void jButtonStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStudentActionPerformed

        DashaboardTab = false;
        StudentsTab = true;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = false;
        changeTab();


    }//GEN-LAST:event_jButtonStudentActionPerformed

    private void jButtonTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTeacherActionPerformed

        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = true;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = false;
        changeTab();

    }//GEN-LAST:event_jButtonTeacherActionPerformed

    private void jButtonTeacherIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTeacherIconActionPerformed
        jButtonTeacherActionPerformed(evt);
    }//GEN-LAST:event_jButtonTeacherIconActionPerformed

    private void jButtonSubjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubjectsActionPerformed
        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = true;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = false;
        changeTab();
    }//GEN-LAST:event_jButtonSubjectsActionPerformed

    private void jButtonSubjectsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubjectsIconActionPerformed
        jButtonSubjectsActionPerformed(evt);
    }//GEN-LAST:event_jButtonSubjectsIconActionPerformed

    private void jButtonClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClassesActionPerformed
        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = true;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = false;
        changeTab();
    }//GEN-LAST:event_jButtonClassesActionPerformed

    private void jButtonClassesIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClassesIconActionPerformed
        jButtonClassesActionPerformed(evt);
    }//GEN-LAST:event_jButtonClassesIconActionPerformed

    private void jButtonCoursesIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCoursesIconActionPerformed
        jButtonCoursesActionPerformed(evt);
    }//GEN-LAST:event_jButtonCoursesIconActionPerformed

    private void jButtonCoursesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCoursesActionPerformed

        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = true;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = false;
        changeTab();

    }//GEN-LAST:event_jButtonCoursesActionPerformed

    private void jButtonEnrollmentsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnrollmentsIconActionPerformed
        jButtonEnrollmentsActionPerformed(evt);
    }//GEN-LAST:event_jButtonEnrollmentsIconActionPerformed

    private void jButtonEnrollmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnrollmentsActionPerformed
        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = true;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = false;
        changeTab();
    }//GEN-LAST:event_jButtonEnrollmentsActionPerformed

    private void jButtonAttendanceIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAttendanceIconActionPerformed
        jButtonAttendanceActionPerformed(evt);
    }//GEN-LAST:event_jButtonAttendanceIconActionPerformed

    private void jButtonAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAttendanceActionPerformed
        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = true;
        PaymentTab = false;
        ReportTab = false;
        changeTab();
    }//GEN-LAST:event_jButtonAttendanceActionPerformed

    private void jButtonPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaymentsActionPerformed
        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = true;
        ReportTab = false;
        changeTab();
    }//GEN-LAST:event_jButtonPaymentsActionPerformed

    private void jButtonPaymentsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPaymentsIconActionPerformed
        jButtonPaymentsActionPerformed(evt);
    }//GEN-LAST:event_jButtonPaymentsIconActionPerformed

    private void jButtonReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportsActionPerformed
        DashaboardTab = false;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = true;
        changeTab();
    }//GEN-LAST:event_jButtonReportsActionPerformed

    private void jButtonReportsIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportsIconActionPerformed
        jButtonReportsActionPerformed(evt);
    }//GEN-LAST:event_jButtonReportsIconActionPerformed

    private void jButtonDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDashboardActionPerformed

        DashaboardTab = true;
        StudentsTab = false;
        TeachersTab = false;
        SubjectsTab = false;
        ClasesTab = false;
        CoursesTab = false;
        EnrollmentTab = false;
        AttendanceTab = false;
        PaymentTab = false;
        ReportTab = false;
        changeTab();

    }//GEN-LAST:event_jButtonDashboardActionPerformed

    private void jButtonDashboardIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDashboardIconActionPerformed
        jButtonDashboardActionPerformed(evt);
    }//GEN-LAST:event_jButtonDashboardIconActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton40ActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatGitHubDarkContrastIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane DashAtendanceAvgScrollPane;
    private javax.swing.JScrollPane DashUpcomingExmScrollPane;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JPanel DashboardPanelBody1;
    private javax.swing.JPanel DashboardPanelHeader;
    private javax.swing.JScrollPane DashboardScrollPane1;
    private javax.swing.JPanel DashboardTabbedPaneRoot1;
    private javax.swing.JPanel RootPanel;
    private javax.swing.JPanel classCard;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel detailGroup37;
    private javax.swing.JPanel detailGroup41;
    private javax.swing.JPanel detailGroup42;
    private javax.swing.JPanel detailGroup43;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton45;
    private javax.swing.JButton jButton46;
    private javax.swing.JButton jButtonAttendance;
    private javax.swing.JButton jButtonAttendanceIcon;
    private javax.swing.JButton jButtonClasses;
    private javax.swing.JButton jButtonClassesIcon;
    private javax.swing.JButton jButtonCourses;
    private javax.swing.JButton jButtonCoursesIcon;
    private javax.swing.JButton jButtonDashboard;
    private javax.swing.JButton jButtonDashboardIcon;
    private javax.swing.JButton jButtonEnrollments;
    private javax.swing.JButton jButtonEnrollmentsIcon;
    private javax.swing.JButton jButtonPayments;
    private javax.swing.JButton jButtonPaymentsIcon;
    private javax.swing.JButton jButtonReports;
    private javax.swing.JButton jButtonReportsIcon;
    private javax.swing.JButton jButtonStudent;
    private javax.swing.JButton jButtonStudentIcon;
    private javax.swing.JButton jButtonSubjects;
    private javax.swing.JButton jButtonSubjectsIcon;
    private javax.swing.JButton jButtonTeacher;
    private javax.swing.JButton jButtonTeacherIcon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel245;
    private javax.swing.JLabel jLabel262;
    private javax.swing.JLabel jLabel263;
    private javax.swing.JLabel jLabel264;
    private javax.swing.JLabel jLabel265;
    private javax.swing.JLabel jLabel266;
    private javax.swing.JLabel jLabel267;
    private javax.swing.JLabel jLabel268;
    private javax.swing.JLabel jLabel269;
    private javax.swing.JLabel jLabel270;
    private javax.swing.JLabel jLabel271;
    private javax.swing.JLabel jLabel272;
    private javax.swing.JLabel jLabel273;
    private javax.swing.JLabel jLabel274;
    private javax.swing.JLabel jLabel275;
    private javax.swing.JLabel jLabel276;
    private javax.swing.JLabel jLabel277;
    private javax.swing.JLabel jLabel279;
    private javax.swing.JLabel jLabel280;
    private javax.swing.JLabel jLabel281;
    private javax.swing.JLabel jLabel282;
    private javax.swing.JLabel jLabel283;
    private javax.swing.JLabel jLabel284;
    private javax.swing.JLabel jLabel285;
    private javax.swing.JLabel jLabel286;
    private javax.swing.JLabel jLabel287;
    private javax.swing.JLabel jLabel288;
    private javax.swing.JLabel jLabel289;
    private javax.swing.JLabel jLabel290;
    private javax.swing.JLabel jLabel291;
    private javax.swing.JLabel jLabel292;
    private javax.swing.JLabel jLabel293;
    private javax.swing.JLabel jLabel294;
    private javax.swing.JLabel jLabel295;
    private javax.swing.JLabel jLabel296;
    private javax.swing.JLabel jLabel297;
    private javax.swing.JLabel jLabel298;
    private javax.swing.JLabel jLabel299;
    private javax.swing.JLabel jLabel300;
    private javax.swing.JLabel jLabel301;
    private javax.swing.JLabel jLabel302;
    private javax.swing.JLabel jLabel303;
    private javax.swing.JLabel jLabel304;
    private javax.swing.JLabel jLabel305;
    private javax.swing.JLabel jLabel306;
    private javax.swing.JLabel jLabel307;
    private javax.swing.JLabel jLabel308;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel sideMainPanel;
    private javax.swing.JLabel userImage;
    // End of variables declaration//GEN-END:variables
}
