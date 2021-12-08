import React from "react";
import { Text, View } from "react-native";
import { addToCart } from "../nameSlice.js";
import { useDispatch} from "react-redux";

const ItemDetails = ({route}) => {
  const dispatch = useDispatch();
  const item = route.params.selectedItem;
  return (
    <View>
      <Text>{item.id}</Text>
      <Text>{item.name}</Text>
      <Text>{item.price}</Text>
      {/*<Button title="Add to Cart" onPress={() => dispatch(addToCart({item}))}/>*/}
    </View>
    
  );
};

export default ItemDetails;
