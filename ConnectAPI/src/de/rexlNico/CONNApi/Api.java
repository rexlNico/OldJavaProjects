package de.rexlNico.CONNApi;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Api {

	public static void Connect(String Server){
		ByteArrayDataOutput out = ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(Server);
	}
	
}
