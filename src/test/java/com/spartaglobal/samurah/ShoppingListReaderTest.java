package com.spartaglobal.samurah;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mockito.Mockito;

import java.util.Collections;

public class ShoppingListReaderTest {

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("Initialize returns false when fails")
    void initializeIsFalseWhenFails(String filePath) {
        ShoppingListReader shoppingListReader = Mockito.mock(ShoppingListReader.class);
        Mockito.when(shoppingListReader.initialize(filePath)).thenReturn(false);
        Assertions.assertFalse(shoppingListReader.initialize(filePath));
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("getShoppingList returns empty list when initialize fails")
    void getShoppingListReturnsEmptyListWhenInitializeFails(String filePath) {
        ShoppingListReader shoppingListReader = Mockito.mock(ShoppingListReader.class);
        Mockito.when(shoppingListReader.initialize(filePath)).thenReturn(false);
        Mockito.when(shoppingListReader.getShoppingList()).thenReturn(Collections.emptyList());
        assert !shoppingListReader.initialize(filePath);
        Assertions.assertEquals(shoppingListReader.getShoppingList().size(), 0);
    }
}
