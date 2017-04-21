/*
 *  Copyright 2011 BetaSteward_at_googlemail.com. All rights reserved.
 * 
 *  Redistribution and use in source and binary forms, with or without modification, are
 *  permitted provided that the following conditions are met:
 * 
 *     1. Redistributions of source code must retain the above copyright notice, this list of
 *        conditions and the following disclaimer.
 * 
 *     2. Redistributions in binary form must reproduce the above copyright notice, this list
 *        of conditions and the following disclaimer in the documentation and/or other materials
 *        provided with the distribution.
 * 
 *  THIS SOFTWARE IS PROVIDED BY BetaSteward_at_googlemail.com ``AS IS'' AND ANY EXPRESS OR IMPLIED
 *  WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 *  FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL BetaSteward_at_googlemail.com OR
 *  CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 *  CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 *  SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 *  ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * 
 *  The views and conclusions contained in the software and documentation are those of the
 *  authors and should not be interpreted as representing official policies, either expressed
 *  or implied, of BetaSteward_at_googlemail.com.
 */

package mage.view;

import mage.cards.Card;
import mage.cards.Cards;
import mage.game.Game;

import java.io.Serializable;

/**
 *
 * @author BetaSteward_at_googlemail.com, nantuko
 */
public class LookedAtView implements Serializable {

    private final String name;
    private final SimpleCardsView cards = new SimpleCardsView();

    public LookedAtView(String name, Cards cards, Game game) {
        this.name = name;
        for (Card card: cards.getCards(game)) {
            this.cards.put(card.getId(), new SimpleCardView(card.getId(), card.getExpansionSetCode(), card.getCardNumber(), card.getUsesVariousArt(), card.getTokenSetCode(), card.getTokenDescriptor()));
        }
    }

    public String getName() {
        return name;
    }

    public SimpleCardsView getCards() {
        return cards;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final LookedAtView that = (LookedAtView) o;

        if (!getName().equals(that.getName())) return false;
        return getCards().equals(that.getCards());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getCards().hashCode();
        return result;
    }
}