package inputport.datacomm.duplex.buffer.nio;

import inputport.datacomm.duplex.buffer.DuplexBufferGenericClientInputPort;
import inputport.datacomm.duplex.buffer.DuplexClientInputPortSkeleton;
import inputport.datacomm.simplex.buffer.nio.AnNIOSimplexBufferClientInputPortDriver;
import inputport.datacomm.simplex.buffer.nio.SelectionManager;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;


public class AnNIODuplexBufferClientInputPortDriver extends AnNIOSimplexBufferClientInputPortDriver implements NIODuplexBufferClientInputPortDriver{
	DuplexClientInputPortSkeleton duplexSkeleton;
	public AnNIODuplexBufferClientInputPortDriver(SelectionManager theSelectingRunnable,
			String theRemoteHostName, String theRemotePort, String aServerName) {
		super(theSelectingRunnable, theRemoteHostName, theRemotePort, aServerName);		
	}
	@Override
	public void connected(SocketChannel theSocketChannel) {
		super.connected(theSocketChannel);
//		selectionManager.registerReadListener(theSocketChannel, this);
		observableNIOManager.addReadListener(theSocketChannel, this);
		
	}
	@Override
	public void socketChannelRead(SocketChannel theSocketChannel,
			ByteBuffer theMessage) {
		duplexSkeleton.messageReceived(serverName, theMessage);		
	}	

	@Override
	public void setSkeleton(DuplexBufferGenericClientInputPort<SocketChannel> theSkeleton) {
		super.setSkeleton(theSkeleton);
		duplexSkeleton = theSkeleton;
	}

}
