import React from "react";
import { View, Text, Button } from "react-native";
import { removeFromCart, clearAll } from "../nameSlice.js";
import { useDispatch, useSelector } from "react-redux";


const CartScreen = ({ navigation }) => {
    const dispatch = useDispatch();
    const { cart } = useSelector((state) => state.cart);
    return (
      <View>
        <Text>Cart</Text>
        {cart.length>0 ? cart.map((item) => (
            
            <View style={{ padding: 20 }}>
            {/*<Button title="Remove" onPress={() => dispatch(removeFromCart({id: item.id}))} />*/}
              <Text>
                  {item.name}
              </Text>
            </View>
            )
        ):<Text>no items added</Text>}
        <Button title="Clear Cart" onPress={() => dispatch(clearAll())} />
      </View>

    );
  };
  
  export default CartScreen;
  