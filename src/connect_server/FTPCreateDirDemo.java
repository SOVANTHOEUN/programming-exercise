package connect_server;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

public class FTPCreateDirDemo {
	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if(replies != null && replies.length > 0) {
			for(String aReply : replies) {
				System.out.println("SERVER:: "+aReply);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
        String server = "172.28.200.138";
        int port	= 22;
        String user = "web";
        String pass = "web";
        FTPClient ftpClient = new FTPClient();
        
        try {
//        	FTPSClient ftpClient = new FTPSClient("SSL");
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            }
            // Creates a directory
            String dirToCreate = "/upload123";
            success = ftpClient.makeDirectory(dirToCreate);
            showServerReply(ftpClient);
            if (success) {
                System.out.println("Successfully created directory: " + dirToCreate);
            } else {
                System.out.println("Failed to create directory. See server's reply.");
            }
            // logs out
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (IOException ex) {
            System.out.println("Oops! Something wrong happened");
            ex.printStackTrace();
        }
    }	
}