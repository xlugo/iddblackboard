package mx.upaep.bb.services.utils.file;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.ParamPart;
import com.oreilly.servlet.multipart.Part;

import javax.servlet.http.HttpServletRequest;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class LoadFileService {
    public JsonObject getContent(HttpServletRequest request) {
        JsonObject jsonObjFileData = new JsonObject();
        JsonArray jsonArrayFileData = new JsonArray();
        Part p;
        MultipartParser mp;
        String fileName = "";
        String delim = "";
        int fileLength = 0;
        byte[] filearray = new byte[2999999];

        try {
            mp = new MultipartParser(request, 2999999);
            while ((p = mp.readNextPart()) != null) {
                if (p.isFile()) {
                    FilePart fp = (FilePart)p;
                    fileName = fp.getFileName();
                    if (fileName != null) {
                        fileLength = fp.getInputStream().read(filearray);
                        jsonObjFileData.addProperty("filename", fileName);
                        jsonObjFileData.addProperty("filesize", fileLength);
                    }
                }
                if (p.isParam()) {
                    String paramname = p.getName();
                    ParamPart pp = (ParamPart)p;
                    String paramvalue = new String(pp.getValue());
                    if (paramname.equals("delimiter")) {
                        if (paramvalue.equals("comma")) {
                            delim = ",";
                        }
                        if (paramvalue.equals("tab")) {
                            delim = "\t";
                        }
                        if (paramvalue.equals("colon")) {
                            delim = ":";
                        }
                    }
                }
            }
        } catch (Exception e) { //error

        }
        StringTokenizer strToken = new StringTokenizer(new String(filearray), "\n");
        while (strToken.hasMoreTokens()) {
            String str = strToken.nextToken();
            StringTokenizer item = new StringTokenizer(str, delim);
            String strCourseId = null;
            // if (item.hasMoreTokens()) {
            strCourseId = formated(item.nextToken());//sólo el primer elemento
            if (strCourseId != null && !(strCourseId.trim().isEmpty())) {
                String regex = "\\d{1,3}_\\d{1,3}_[a-zA-Z0-9-]+_\\d{1,3}";
                 if(Pattern.matches(regex, strCourseId)){
                     jsonArrayFileData.add(strCourseId);
                }

            }
            // }
        }//while
        jsonObjFileData.add("coursesid", jsonArrayFileData);

        return jsonObjFileData;
    }

    public String formated(String str) {
        String strTemp = str;
        strTemp = strTemp.trim();
        if (strTemp.startsWith("\"")) {
            strTemp = strTemp.substring(1);
        }
        if (strTemp.endsWith("\"")) {
            strTemp = strTemp.substring(0, strTemp.length() - 1);
        }
        return strTemp;
    }

}
