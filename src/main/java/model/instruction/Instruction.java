package model.instruction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;

/**
 * Describes an instruction sent by various clients in order to buy or sell
 */
@Getter
@Setter
@AllArgsConstructor
public class Instruction {

    // An entity whose shares are to be bought or sold
    private final String entity;

    // Action that Instruction represents (Buy or Sell)
    private final TradeAction action;

    // Date on which the instruction was sent by clients
    private final LocalDate instructionDate;

    // The Date on which the client wished for the instruction to be settled with respect to Instruction Date
    // The only non-final since it can be recalculated from business logic.
    private LocalDate settlementDate;

    private final InstructionDetails details;

    /**
     * Get trade currency
     * @return
     */
    public Currency getCurrency() {
        return getDetails().getCurrency();
    }

    /**
     * Get agreed rates
     * @return
     */
    public BigDecimal getAgreedFx() {
        return getDetails().getAgreedFx();
    }

    /**
     * Get instructed units
     * @return
     */
    public int getUnits() {
        return getDetails().getUnits();
    }

    /**
     * Get per unit price
     * @return
     */
    public BigDecimal getPricePerUnit() {
        return getDetails().getPricePerUnit();
    }

    /**
     * Get the trade amount
     * @return
     */
    public BigDecimal getTradeAmount() {
        return getDetails().getTradeAmount()
                .setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }
}
