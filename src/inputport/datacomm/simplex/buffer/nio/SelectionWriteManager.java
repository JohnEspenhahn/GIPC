package inputport.datacomm.simplex.buffer.nio;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public interface SelectionWriteManager {

	public abstract WriteBoundedBuffer getBufferedWriteBoundedBuffer(
			WriteCommand bufferedWrite);

	public abstract void putBufferedWrite(WriteCommand bufferedWrite);

	public abstract void processBufferedWrites();

	public abstract boolean registerWriteOpsForBufferedWrites(
			WriteCommand writeBuffer);

	//	@Override
	public abstract boolean makeRequestForWriteBoundedBuffer(
			SocketChannel channel);

	// keep getting concurrent change exception without synchronized
	public abstract void preProcessBufferedWrites();

	public abstract void processChannelBufferedWrites(SelectionKey selectionKey);

	public abstract void processChannelBufferedWrites(
			WriteBoundedBuffer bufferedWriteBoundedBuffer);

	WriteBoundedBuffer get(SocketChannel socketChannel);

}