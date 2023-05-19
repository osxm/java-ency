/**  
* @Title: PerforceTests.java
* @Package com.osxm.je.topic.p4
* @Description: TODO
* @author XM
* @date 2023年5月2日 上午9:39:00
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.p4;

import java.util.List;

import org.junit.Test;

import com.perforce.p4java.core.file.FileSpecBuilder;
import com.perforce.p4java.core.file.FileSpecOpStatus;
import com.perforce.p4java.core.file.IFileSpec;
import com.perforce.p4java.option.server.GetDepotFilesOptions;
import com.perforce.p4java.server.IOptionsServer;
import com.perforce.p4java.server.ServerFactory;

public class PerforceTests {
	String serverUri = "p4java://localhost:1666";

	private String userName = "oscar";

	String password = "123456";

	@Test
	public void listFile() throws Exception {
		IOptionsServer server = ServerFactory.getOptionsServer(serverUri, null);
		server.connect();
		server.setUserName(userName);
		server.login(password);

		List<IFileSpec> fileList = server.getDepotFiles(FileSpecBuilder.makeFileSpecList("//depot/..."),
				new GetDepotFilesOptions());
		for (IFileSpec fileSpec : fileList) {
			if (fileSpec == null) {
				System.err.println("filespec is null");
				continue;
			}
			if (fileSpec.getOpStatus() == FileSpecOpStatus.VALID) {
				System.out.println(fileSpec.getDepotPathString());
			} else {
				System.err.println(fileSpec.getStatusMessage());
			}
		}
		server.disconnect();
	}
}
