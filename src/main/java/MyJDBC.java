import java.sql.*;
import java.util.Scanner;

    /*
     * Author: Bregovic Dominik
     * jdbc create-insert-delete
     * Last change: 12.08.2021
     */

    public class MyJDBC {
        private static Connection connection;
        private static Statement state;
        private static PreparedStatement stmt;
        private static ResultSet result;
        private static Scanner scan = new Scanner(System.in);

        public MyJDBC(){
            createRegistrationTable();
        }

        public void createRegistrationTable() {
            String url = "jdbc:mysql://localhost:3306/timetable";
            String username = "Prog2";
            String password = "Prog2";
            String sqlCommand;
            sqlCommand = "CREATE DATABASE IF NOT EXISTS timetable CHARACTER SET utf8 COLLATE utf8_unicode_ci";

            try  {
                connection = DriverManager.getConnection(url, username, password);
                state = connection.createStatement();
                state.executeUpdate(sqlCommand);
                state.execute("USE timetable");

                //createTables();

            } catch (SQLException e) {
                while (e != null){
                    System.out.println("Code = " + e.getErrorCode());
                    System.out.println("Message = " + e.getMessage());
                    System.out.println("State = " + e.getSQLState());
                    e = e.getNextException();
                }
            }
        }
////////////////////////////////////////////////////////////////////////////////


        public void insertIntoScheduleTable(String assistant,String day, String dayOfWeek, String subject, String timeFrom, String timeTo, String room_room_ID) throws SQLException {

            stmt = connection.prepareStatement("INSERT INTO schedule (date_day, week_day, course_name, prof_Id, location)VALUES(?, ?, ?, ?, ?, ?, ?)");

            try {
                stmt.setString(1, assistant);
                stmt.setString(2, day);
                stmt.setString(3, dayOfWeek);
                stmt.setString(4, subject);
                stmt.setString(5, timeFrom);
                stmt.setString(6, timeTo);
                stmt.setString(7, room_room_ID);

                stmt.addBatch();
                stmt.executeBatch();

            } catch (SQLException e) {
            /*throw new SQLException(stmt.getWarnings().getMessage(),
                    stmt.getWarnings().getSQLState(),
                    stmt.getWarnings().getErrorCode());*/

            }
        }


    public static void insertIntoScheduleStudentTable(String subject_id, String stud_id) throws SQLException {

        stmt = connection.prepareStatement("INSERT INTO subject_student (Subject_subject_id, students_student_ID)VALUES(?, ?)");

        try {

            stmt.setString(1, subject_id);
            stmt.setString(2, stud_id);
            stmt.addBatch();
            stmt.executeBatch();

        } catch (SQLException e) {
            throw new SQLException(stmt.getWarnings().getMessage(),
                    stmt.getWarnings().getSQLState(),
                    stmt.getWarnings().getErrorCode());
        }
    }

        ////////////////////////////////////////////////////////////////////////////



        public boolean searchForRecord(String collumn, String tablename, String username){

            try {
                result = state.executeQuery("SELECT " + collumn + " FROM " + tablename);
                while (result.next()) {
                    if (username.contains(result.getString(collumn))) {
                        return true;
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            return false;
        }


        public void retrieveRecords(String tablename){
            try {
                result = state.executeQuery("SELECT * FROM " + tablename);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        public String retrieveID(String columnID, String tablename, String columnName ,  String studentsName){
            try {
                result = state.executeQuery("SELECT * FROM "+ tablename);
                while (result.next()) {
                    if (studentsName.contains(result.getString(columnName))) {
                        return String.valueOf(result.getInt(columnID));
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage()+"result fail");
            }
            return "";
        }
        /////////////////////////////////////////////////

        public static ResultSet getResult() {
            return result;
        }

    }




