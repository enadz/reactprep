import React, { useState } from "react";
import { View, Text, TextInput } from "react-native";

const Login = () => {
  const [name, setName] = useState(null);
  const [email, setEmail] = useState(null);
  return (
    <View>
      <Text>Login Page</Text>
      <TextInput placeholder="Enter name" value={name} onChangeText={setName} />
      <TextInput
        type="email"
        placeholder="Enter email"
        value={email}
        onChangeText={setEmail}
      />
      <Text>{email}</Text>
      <Text>{name}</Text>
    </View>
  );
};

export default Login;
