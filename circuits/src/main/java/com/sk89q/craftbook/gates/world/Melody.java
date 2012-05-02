package com.sk89q.craftbook.gates.world;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;

import com.sk89q.craftbook.bukkit.CircuitsPlugin;
import com.sk89q.craftbook.ic.AbstractIC;
import com.sk89q.craftbook.ic.AbstractICFactory;
import com.sk89q.craftbook.ic.ChipState;
import com.sk89q.craftbook.ic.IC;
import com.sk89q.craftbook.ic.SelfTriggeredIC;
import com.sk89q.jinglenote.JingleNoteComponent;
import com.sk89q.jinglenote.MidiJingleSequencer;

public class Melody extends AbstractIC implements SelfTriggeredIC{

	public Melody(Server server, Sign block) {
		super(server, block);
	}

	@Override
	public String getTitle() {
		return "Melody Player";
	}

	@Override
	public String getSignTitle() {
		return "MELODY";
	}

	@Override
	public boolean isActive() {
		return false;
	}

	@Override
	public void trigger(ChipState chip) {

	}

	@Override
	public void think(ChipState state) {
		try {
			if(state.getInput(0))
			{
				String midiName = getSign().getLine(2);

				MidiJingleSequencer sequencer = new MidiJingleSequencer(
						new File(CircuitsPlugin.getInst().getDataFolder(), midiName));
				for (Player player : getServer().getOnlinePlayers()) {
					JingleNoteComponent.getJingleNoteManager().play(player, sequencer, 0);
					player.sendMessage(ChatColor.YELLOW + "Playing intro.midi...");
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
    public static class Factory extends AbstractICFactory {

        public Factory(Server server) {
            super(server);
        }

        @Override
        public IC create(Sign sign) {
            return new Melody(getServer(), sign);
        }
    }

}
