package me.TahaCheji.Mafana.tradeManagers.trade;
import org.bukkit.entity.Player;

public class TradePlayer {

    private final TradeManager tradeManager;

    private Player player = null;

    boolean isSender;


    public TradePlayer(TradeManager _tradeManager, Player _player, TradeManager.Role _role ) {
        this.tradeManager = _tradeManager;
        player = _player;
        isSender = _role == TradeManager.Role.SENDER;
    }

    public Player getPlayer() {
        return player;
    }

    public TradeManager getTradeManager() {
        return tradeManager;
    }
    public boolean isTradeManagerSender() {
        return tradeManager.getTPsender() == this;
    }

    public boolean isSender() {
        return isSender;
    }

}
