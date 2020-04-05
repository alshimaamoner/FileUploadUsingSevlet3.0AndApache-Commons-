package company;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;




//@WebServlet(name = "UploadFileServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                String fileName=content.substring(content.indexOf('=')+1).trim().replace("\"","");
                if(fileName.contains(":/")){
                    Path pathFile= Paths.get(fileName);
                    return pathFile.getFileName().toString();


                }
                else {
                    return fileName;
                }
                //   return content.substring(
                //         content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
// Create path components to save the file
        String path = "C:\\";
        Part filePart = request.getPart("file");
        String fileName = getFileName(filePart);
        PrintWriter out = response.getWriter();
        try {
            filePart.write(path + fileName);
            out.println("New file " + fileName + " created at " + path);
        } catch (FileNotFoundException fne) {
            out.println("Error While Uploading Your File");
        }

    }

}



/*


public class FileUploadHandler extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "C:/uploads";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //process only if its multipart content
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);

                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                }

                //File uploaded successfully
                request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
                request.setAttribute("message", "File Upload Failed due to " + ex);
            }

        }else{
            request.setAttribute("message",
                    "Sorry this Servlet only handles file upload request");
        }

        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }

}
*/