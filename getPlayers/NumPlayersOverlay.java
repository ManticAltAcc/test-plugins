package net.runelite.client.plugins.getPlayers;

import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;

import javax.inject.Inject;
import java.awt.*;

public class NumPlayersOverlay extends Overlay {
	private NumPlayers plugin;

	private PanelComponent panelComponent = new PanelComponent();

	@Inject
	public NumPlayersOverlay(NumPlayers plugin){
		super(plugin);
		this.plugin = plugin;
		setLayer(OverlayLayer.ALWAYS_ON_TOP);
		setPosition(OverlayPosition.BOTTOM_LEFT);
	}

	@Override
	public Dimension render(Graphics2D graphics){

		panelComponent.getChildren().clear();
		panelComponent.getChildren().add(LineComponent.builder()
				.left("Player count: ")
				.right(Integer.toString(plugin.getPlayers()))
				.build());

		return panelComponent.render(graphics);
	}
}
