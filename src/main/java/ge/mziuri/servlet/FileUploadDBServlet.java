package ge.mziuri.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@MultipartConfig(maxFileSize = 16177215)
public class FileUploadDBServlet extends HttpServlet {
    // database connection settings
    private String dbURL = "jdbc:postgresql://localhost:5432/AppDB";
    private String dbUser = "postgres";
    private String dbPass = "rame";

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        InputStream inputStream = null; // input stream of the upload file

        // obtains the upload file part in this multipart request
        Part filePart = request.getPart("photo");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
        }

        Connection conn = null; // connection to the database
        String message = null;  // message will be sent back to client

        try {
            // connects to the database
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // constructs SQL statement
            String sql = "INSERT INTO contacts (first_name, last_name, photo) values (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);


            if (inputStream != null) {
                // fetches input stream of the upload file for the blob column
                statement.setBlob(3,inputStream);
            }
            statement.executeUpdate();
            statement.close();

            // sends the statement to the database server
            int row = statement.executeUpdate();
            if (row > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (SQLException ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // closes the database connection
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            // sets the message in request scope
            request.setAttribute("Message", message);

            // forwards to the message page
            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
        }
    }
}
