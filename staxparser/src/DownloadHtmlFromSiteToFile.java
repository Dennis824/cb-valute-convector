import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;



    class DownloadHtmlFromSiteToFile {
        public static  void main(String[] args) {
            String Date = "02/03/2019";
            int count;
            byte[] buff = new byte[64];
            InputStream is = null;
            OutputStream out = null;
            String urlOndate = "http://www.cbr.ru/scripts/XML_daily.asp?date_req="+Date;
            System.out.println(urlOndate);
            try {
                is = new URL(urlOndate).openStream();
                out = new FileOutputStream("D:/Date.html");

                while ((count = is.read(buff)) != -1) {
                    out.write(buff, 0, count);
                }
            } catch (IOException e){};

            XMLStaxParser.StaxParser();
        }


}
