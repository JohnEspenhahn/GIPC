package examples.gipc.consensus.synchronous;

import examples.gipc.consensus.ExampleMemberLauncher;
import examples.gipc.consensus.Member1;
import port.trace.consensus.ConsensusTraceUtility;

public class SynchronousProposer1Launcher extends
		ASynchronousProposerAndAcceptorLauncher implements Member1 {

	public SynchronousProposer1Launcher(String aLocalName,
			int aPortNumber) {
		super(aLocalName, aPortNumber);
		// TODO Auto-generated constructor stub
	}
	
	protected void doPropose() {
		proposeValues1();
	}

	public static void main(String[] args) {
		ConsensusTraceUtility.setTracing();
		new SynchronousProposer1Launcher(MY_NAME, MY_PORT_NUMBER)
				.proposeValues();
	}

}
