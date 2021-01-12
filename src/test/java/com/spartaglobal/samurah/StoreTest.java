package com.spartaglobal.samurah;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;

public class StoreTest {
//    Store mockStore;
    Store store;


    @BeforeEach
    void createMockStore() {
//        mockStore = Mockito.mock(Store.class);
        store = new Store();
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("Empty or null string doesn't throw exceptions when calling .getCost")
    void testNullString(String emptyNullString) {
//        Mockito.when(mockStore.getCost(emptyNullString)).thenReturn(0);
//        Assertions.assertDoesNotThrow(()->mockStore.getCost(emptyNullString));
        Assertions.assertDoesNotThrow(() -> store.getCost(emptyNullString));
    }

    @Test
    @DisplayName("Does Item Exist in Shop")
    void doesItemExist() {
        String product = "Pasta";
        int cost = 1;

//        Mockito.when(mockStore.addProduct(product, cost)).thenReturn(true);
//        mockStore.addProduct(product, cost);
        store.addProduct(product, cost);

//        Mockito.when(mockStore.doesItemExist(product)).thenReturn(true);

//        Assertions.assertTrue(mockStore.doesItemExist(product));
        Assertions.assertTrue(store.doesItemExist(product));
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("Empty or null string doesn't throw exceptions when calling .doesItemExist")
    void testNullStringItemExist(String emptyNullString) {
//        Mockito.when(mockStore.doesItemExist(emptyNullString)).thenReturn(false);
//        Assertions.assertDoesNotThrow(() -> mockStore.doesItemExist(emptyNullString));
        Assertions.assertDoesNotThrow(() -> store.doesItemExist(emptyNullString));
    }

    @Test
    @DisplayName("Testing Item Added")
    void wasItemAdded() {
//        Mockito.when(mockStore.addProduct("Milk", 100)).thenCallRealMethod();
//        Assertions.assertTrue(mockStore.addProduct("Milk", 100));
        Assertions.assertTrue(store.addProduct("Milk", 100));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, 0})
    @DisplayName("Testing whether items with 0 or negative cost returns false")
    void canItemsHaveZeroOrNegativeCost(int number) {
//        Mockito.when(mockStore.addProduct("Potato", number)).thenReturn(false);
//        mockStore.addProduct("Potato", number);
        store.addProduct("Potato", number);

//        Mockito.when(mockStore.doesItemExist("Potato")).thenReturn(false);

//        Assertions.assertFalse(mockStore.doesItemExist("Potato"));
        Assertions.assertFalse(store.doesItemExist("Potato"));
    }

    // boolean removeProduct(String productName);
    //removes the product from the inventory of the shop (true - if removed, false - if doesn't exist)
    @Test
    @DisplayName("Remove product from the shop ")
    void testRemoveProduct() {
        String productName = "tomatoes";

//        Mockito.when(mockStore.addProduct(productName, 2)).thenReturn(true);
//        mockStore.addProduct(productName, 2);
        store.addProduct(productName, 2);

//        Mockito.when(mockStore.removeProduct(productName)).thenReturn(true);
//        mockStore.removeProduct(productName);
        store.removeProduct(productName);

//        Mockito.when(mockStore.doesItemExist(productName)).thenReturn(true);
//        Assertions.assertTrue(mockStore.doesItemExist(productName));
        Assertions.assertTrue(store.doesItemExist(productName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Test whether Exception is not thrown for removeProduct")
    void testRemoveProductException(String emptyOrNull) {

//        Mockito.when(mockStore.removeProduct(emptyOrNull)).thenReturn(false);
//        Assertions.assertDoesNotThrow(() -> mockStore.removeProduct(emptyOrNull));
        Assertions.assertDoesNotThrow(() -> store.removeProduct(emptyOrNull));

    }

    @Test
    @DisplayName("Adding a product to the shop ")
    void testAddProduct() {
        String productName = "apple";
        int cost = 2;

//        Mockito.when(mockStore.addProduct(productName, cost)).thenReturn(true);
//        mockStore.addProduct(productName, cost);
        store.addProduct(productName, cost);

//        Mockito.when(mockStore.doesItemExist(productName)).thenReturn(true);
//        Assertions.assertTrue(mockStore.doesItemExist(productName));
        Assertions.assertTrue(store.doesItemExist(productName));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Test whether Exception is not thrown for addProduct")
    void testAddProductException(String emptyOrNull) {

//        Mockito.when(mockStore.addProduct(emptyOrNull, 2)).thenReturn(false);
//        Assertions.assertDoesNotThrow(() -> mockStore.addProduct(emptyOrNull, 2));
        Assertions.assertDoesNotThrow(() -> store.addProduct(emptyOrNull, 2));

    }

    @Nested
    @DisplayName("Test to check getCost returns Cost of all items")
    class testingGetCost {

        @Test
        void testGetCost() {
//            Mockito.when(mockStore.addProduct("potato", 2)).thenCallRealMethod();
//            Mockito.when(mockStore.getCost("potato")).thenCallRealMethod();
            store.addProduct("potato", 2);

//            mockStore.addProduct("potato", 2);
//            Assertions.assertEquals(2, mockStore.getCost("potato"));
            Assertions.assertEquals(2, store.getCost("potato"));
        }

        @Test
        void testGetCostMultiple() {
//            Mockito.when(mockStore.addProduct("tomato", 5)).thenReturn(true);
//            Mockito.when(mockStore.addProduct("potato", 16)).thenReturn(true);
//            Mockito.when(mockStore.addProduct("pizza", 30)).thenReturn(true);
//
//            mockStore.addProduct("tomato", 5);
//            mockStore.addProduct("potato", 16);
//            mockStore.addProduct("pizza", 30);
            store.addProduct("tomato", 5);
            store.addProduct("potato", 16);
            store.addProduct("pizza", 30);


            ShoppingListReader fileReader = Mockito.mock(ShoppingListReader.class);
            String[] products = new String[]{"tomato", "potato"};

            Mockito.when(fileReader.getShoppingList()).thenReturn(Arrays.asList(products));
//            Mockito.when(mockStore.getCost(fileReader.getShoppingList())).thenReturn(21);

//            Assertions.assertEquals(21, mockStore.getCost(fileReader.getShoppingList()));
            Assertions.assertEquals(21, store.getCost(fileReader.getShoppingList()));
        }
    }

    @Nested
    @DisplayName("Test Upper Case Strings")
    class testUpperAndLowerCaseStrings {

        @Test
        void testUpperCase() {
//            Mockito.when(mockStore.addProduct("TOMATO", 5)).thenReturn(true);
//            Mockito.when(mockStore.getCost("tomato")).thenReturn(5);

//            mockStore.addProduct("TOMATO", 5);
            store.addProduct("TOMATO", 5);

//            Assertions.assertEquals(5, mockStore.getCost("tomato"));
            Assertions.assertEquals(5, store.getCost("tomato"));
        }

        @Test
        void testLowerCase() {
//            Mockito.when(mockStore.addProduct("tomato", 5)).thenReturn(true);
//            Mockito.when(mockStore.getCost("TOMATO")).thenReturn(5);

//            mockStore.addProduct("tomato", 5);
              store.addProduct("tomato", 5);

//            Assertions.assertEquals(5, mockStore.getCost("TOMATO"));
            Assertions.assertEquals(5, store.getCost("TOMATO"));
        }

        @Test
        void testMixtureOfCases() {
//            Mockito.when(mockStore.addProduct("tOmaTO", 5)).thenReturn(true);
//            Mockito.when(mockStore.getCost("TomAtO")).thenReturn(5);

//            mockStore.addProduct("tOmaTO", 5);
            store.addProduct("tOmaTO", 5);

//            Assertions.assertEquals(5, mockStore.getCost("TomAtO"));
            Assertions.assertEquals(5, store.getCost("TomAtO"));
        }
    }
}
