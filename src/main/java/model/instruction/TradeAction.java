package model.instruction;

import lombok.Getter;

public enum TradeAction {
    BUY("B"),
    SELL("S");

    @Getter
    private String text;

    TradeAction(final String text) {
        this.text = text;
    }
}
