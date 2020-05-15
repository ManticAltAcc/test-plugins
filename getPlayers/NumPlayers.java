package net.runelite.client.plugins.getPlayers;


import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import net.runelite.client.ui.overlay.OverlayManager;


import javax.inject.Inject;
import java.util.List;

@Slf4j
@PluginDescriptor(
		name = "Player Amount",
		description = "Shows the number of players locally",
		type = PluginType.UTILITY
)
public class NumPlayers extends Plugin {

	@Inject
	private Client client;

	@Inject
	private NumPlayersOverlay overlay;

	@Inject
	private OverlayManager overlayManager;

	@Override
	public void startUp(){
		overlayManager.add(overlay);
	}

	@Override
	public void shutDown(){
		overlayManager.remove(overlay);
	}

	public int getPlayers(){
		List<Player> players = client.getPlayers();
		int numPlayers = players.size();

		return numPlayers;
	}

}
