package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);

         //When
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        //Then
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";
        ResultSet rs = statement.executeQuery(sqlCheckTable);
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
    }

    @Test
    void testUpdateBestsellers() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();
        Statement statement = dbManager.getConnection().createStatement();
        String sqlAddBookRow = "INSERT INTO books(TITLE, PUBYEAR) VALUES " +
                "(\"Test title\", 2000 )";
        statement.executeUpdate(sqlAddBookRow);
        String selectBookRow = "SELECT * FROM books WHERE TITLE = \"Test title\" " +
                "AND PUBYEAR = 2000";
        ResultSet rs = statement.executeQuery(selectBookRow);
        int bookId = -1;
        if (rs.next()){
            bookId = rs.getInt("BOOK_ID");
        }

        String sqlAddReaderRow = "INSERT INTO readers(FIRSTNAME, LASTNAME, PESELID) " +
                "VALUES(\"Test firstname\", \"Test lastname\", 123123)";
        statement.executeUpdate(sqlAddReaderRow);
        String selectReaderRow = "SELECT * FROM readers WHERE FIRSTNAME = \"Test firstname\" ";
        rs = statement.executeQuery(selectReaderRow);
        int readerId = -1;
        if (rs.next()){
            readerId = rs.getInt("READER_ID");
        }

        String sqlAddRentRow = "INSERT INTO rents(BOOK_ID, READER_ID, RENT_DATE)" +
                "VALUES ( " + bookId + "," + readerId + ",CURDATE())";
        statement.executeUpdate(sqlAddRentRow);
        sqlAddRentRow = "INSERT INTO rents(BOOK_ID, READER_ID, RENT_DATE)" +
                "VALUES ( " + bookId + "," + readerId + ",DATE_ADD(CURDATE(), INTERVAL 10 DAY))";
        statement.executeUpdate(sqlAddRentRow);
        sqlAddRentRow = "INSERT INTO rents(BOOK_ID, READER_ID, RENT_DATE)" +
                "VALUES ( " + bookId + "," + readerId + ",DATE_ADD(CURDATE(), INTERVAL 30 DAY))";
        statement.executeUpdate(sqlAddRentRow);

        //when
        String sqlProcCall = "CALL UpdateBestsellers()";
        statement.executeUpdate(sqlProcCall);

        //then
        rs = statement.executeQuery(selectBookRow);
        int isBestseller = -1;
        if (rs.next()){
            isBestseller = rs.getInt("IS_BESTSELLER");
        }
        assertEquals(1, isBestseller);

        //cleanup
        String deleteRow = "DELETE FROM rents WHERE BOOK_ID = " + bookId;
        statement.executeUpdate(deleteRow);
        deleteRow = "DELETE FROM books WHERE BOOK_ID = " + bookId;
        statement.executeUpdate(deleteRow);
        deleteRow = "DELETE FROM readers WHERE FIRSTNAME = \"Test firstname\" AND " +
                "LASTNAME = \"Test lastname\"";
        statement.executeUpdate(deleteRow);
        rs.close();
        statement.close();
    }

}
