package consensus.twoparty.asymmetric;

import inputport.ConnectionRegistrar;
import port.trace.consensus.ProposalAcceptRequestSent;
import port.trace.consensus.ProposalAcceptedNotificationSent;
import port.trace.consensus.ProposalLearnedNotificationReceived;
import consensus.Acceptor;
import consensus.AnAbstractConsensusMechanism;
import consensus.Acceptor;
import consensus.ProposalState;

public class AnAsymmetricTwoPartyProposerConsensusMechanism<StateType> extends
		AnAbstractConsensusMechanism<StateType> implements TwoPartyAssymetricProposerConsensusMechanism<StateType> {
	protected Acceptor<StateType> acceptor;

	public AnAsymmetricTwoPartyProposerConsensusMechanism(ConnectionRegistrar anInputPort, String aName, short aMyId,
			Acceptor<StateType> aPeerProxy) {
		super(anInputPort, aName, aMyId);
		acceptor = aPeerProxy;
	}
	protected Acceptor<StateType> acceptor() {
		return acceptor;
	}
//	@Override
//	protected boolean allowConcurrentProposals() {
//		return false;
//	}
	protected void sendAcceptRequest(float aProposalNumber, StateType aProposal) {
		ProposalAcceptRequestSent.newCase(this, getObjectName(),
				aProposalNumber, aProposal);
		acceptor.accept(aProposalNumber, aProposal);		
	}
	@Override
	protected void propose(float aProposalNumber, StateType aProposal) {
		sendAcceptRequest(aProposalNumber, aProposal);		
	}
	@Override
	public void accepted(float aProposalNumber, StateType aProposal, boolean anAgreement) {
		ProposalLearnedNotificationReceived.newCase(this, getObjectName(),
				aProposalNumber, aProposal);
		if (anAgreement)
			newProposalState(aProposalNumber, aProposal, ProposalState.PROPOSAL_CONSENSUS);	
		else
			newProposalState(aProposalNumber, aProposal, ProposalState.PROPOSAL_REJECTED);	

	}

}
