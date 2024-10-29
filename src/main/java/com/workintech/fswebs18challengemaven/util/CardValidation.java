package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Type;

public class CardValidation {
    public static boolean isIdValid(long id){
        return id >= 0;
    }

    public static boolean isValue(Integer value){
        return value >= 0 && value <= 10;
    }

    public static boolean cardIsValid(Card card) {
        if (card == null) {
            return false;
        }

        boolean hasValue = card.getValue() != null;
        boolean hasType = card.getType() != null;

        if (Type.JOKER.equals(card.getType())) {
            return !hasValue && card.getColor() == null;
        }

        return (hasValue && !hasType) || (!hasValue && hasType);
    }




}
