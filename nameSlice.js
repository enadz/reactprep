import { createSlice, configureStore } from "@reduxjs/toolkit";

const namesSlice = createSlice({
  name: "items",
  initialState: {
    items: [
      { id: 1, name: "Item 1", price: "10 KM" },
      { id: 2, name: "Item 2", price: "20 KM" },
      { id: 3, name: "Item 3", price: "30 KM" },
    ],
    cart: []
  },
  reducers: {
    addToCart: (state, action) => {
      return {
        ...state,
        cart: [...state.cart, ...state.items.filter((item) => item.id === action.payload.id)]
      }
    },
    removeFromCart: (state, action) => {
      return {
        cart: [...state.cart.filter((item) => item.id !== action.payload.id)],
      }
    },
    clearAll: (state) => {
      return {
        ...state,
        cart: []
      }
    }
  },
});

const {removeFromCart, addToCart, clearAll } = namesSlice.actions;

export const store = configureStore({
  reducer: {
    items: namesSlice.reducer,
    cart: namesSlice.reducer
  },
});

export {removeFromCart, addToCart, clearAll };
