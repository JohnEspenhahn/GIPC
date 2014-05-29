package sessionport.datacomm.group.object.flexible.example;

import port.sessionserver.ASessionServerLauncher;
import port.sessionserver.relay.RelayerSupportingSessionServerLauncher;
import port.sessionserver.relay.SessionServerRelayerLauncher;
import port.sessionserver.relay.late.LatecomerSessionServerLauncher;
import sessionport.rpc.duplex.example.AnAliceDuplexRPCSessionPort;
import bus.uigen.models.MainClassLaunchingUtility;

public class DemoerOfFlexibleGroupObjectSessionPort {
	public static void main(String args[]) {
		demo();
	}	
	public static void demo() {		
		Class[] classes = {
				LatecomerSessionServerLauncher.class, // can also have relayer
				AnAliceGroupSessionPort.class,
				ABobGroupSessionPort.class,
				ACathyGroupSessionPort.class 
		};
		MainClassLaunchingUtility.interactiveLaunch(classes);
	}	

}
