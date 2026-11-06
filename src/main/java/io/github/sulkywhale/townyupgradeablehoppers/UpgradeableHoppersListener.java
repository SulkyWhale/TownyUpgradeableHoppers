package io.github.sulkywhale.townyupgradeablehoppers;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.PlayerCache;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.WorldCoord;
import com.palmergames.bukkit.towny.permissions.TownyPerms;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;
import me.angeschossen.upgradeablehoppers.api.events.hopper.HopperItemPickupEvent;
import me.angeschossen.upgradeablehoppers.api.hopper.Hopper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class UpgradeableHoppersListener implements Listener {

    @EventHandler
    public void onHopperItemPickup(HopperItemPickupEvent event) {
        Hopper hopper = event.getHopper();
        Player owner = Bukkit.getPlayer(hopper.getOwner());
        if (owner == null) {
            event.setCancelled(true);
            return;
        }
        WorldCoord worldCoord = WorldCoord.parseWorldCoord(event.getItem().getLocation());
        PlayerCache.TownBlockStatus status = PlayerCacheUtil.fetchTownBlockStatus(owner, worldCoord);
        Resident resident = TownyAPI.getInstance().getResident(owner);
        switch (status) {
            case UNCLAIMED_ZONE:
            case PLOT_OWNER:
            case PLOT_FRIEND:
            case TOWN_ALLY:
            case TOWN_NATION:
            case PLOT_TRUSTED:
            case TOWN_TRUSTED:
                break;
            case NATION_ZONE:
                Town nearestTown = worldCoord.getTownyWorld().getClosestTownWithNationFromCoord(worldCoord, null);
                if (resident == null || !nearestTown.hasNation() || !nearestTown.getNationOrNull().hasResident(resident)) {
                    event.setCancelled(true);
                }
                break;
            case TOWN_RESIDENT:
                if (resident == null || !TownyPerms.hasAssistantTownRank(resident)) {
                    event.setCancelled(true);
                }
                break;
            case TOWN_OWNER:
                if (!worldCoord.hasTownBlock() || worldCoord.getTownBlockOrNull().hasResident() && worldCoord.getTownBlockOrNull().getResidentOrNull() != resident) {
                    event.setCancelled(true);
                }
                break;
            default:
                event.setCancelled(true);
        }
    }
}
