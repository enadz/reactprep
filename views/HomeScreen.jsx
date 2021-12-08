import React from "react";
import { View, Text, Button } from "react-native";
import {addToCart, clearAll } from "../nameSlice.js";
import { useDispatch, useSelector } from "react-redux";
import { TouchableHighlight } from "react-native-gesture-handler";

const Home = ({ navigation }) => {
  const dispatch = useDispatch();

  const { items } = useSelector((state) => state.items);
  const { cart } = useSelector((state) => state.cart);
  return (
    <View>
      <Text>Home page</Text>
      {items.map((item) => {
        return (
          <View style={{ padding: 20 }}>
            <Text style={{fontSize:20, color: "blue"}}
              onPress={() =>navigation.navigate("ItemDetails", { selectedItem: item })}>
                {item.name}
            </Text>
            <Text style={{ price: item.price }}>{item.price}</Text>
            <Button
              title="Add to Cart"
              onPress={() => dispatch(addToCart({ id: item.id }))}
            />
            <Button
              title="Open details"
              onPress={() =>
                navigation.navigate("ItemDetails", { selectedItem: item })
              }
            />
          </View>
        );
      })}
      
      <Button title="Clear Cart" onPress={() => dispatch(clearAll())} />
    </View>
  );
};

export default Home;
