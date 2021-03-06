package port.trace.serialization.extensible;

import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import inputport.ConnectionManager;
import inputport.rpc.RemoteCall;
import port.trace.rpc.ReceivedCallEndedOld;
import util.trace.TraceableInfo;

public class ExtensibleBufferDeserializationInitiated extends TraceableInfo {	
	public ExtensibleBufferDeserializationInitiated(String aMessage, Object aValueSerializer,			
			Object anInputBuffer, Class aDeserializedClass) {
		super(aMessage, aValueSerializer);
	}
	public static ExtensibleBufferDeserializationInitiated newCase(Object aValueSerializer, 
			String aSource,
			Object anInputBuffer, Class aDeserializedClass) {    	
		String aMessage =
				anInputBuffer + "->" +
				
				aDeserializedClass.getClass().getSimpleName(); 
		ExtensibleBufferDeserializationInitiated retVal = 
				new ExtensibleBufferDeserializationInitiated(aMessage, 
				aValueSerializer,
				anInputBuffer, aDeserializedClass );
    	retVal.announce();
    	return retVal;
	}
}
