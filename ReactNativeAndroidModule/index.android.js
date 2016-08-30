/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  NativeModules,
  TouchableHighlight
} from 'react-native';

class ReactNativeAndroidModule extends Component {
  constructor(props) {
    super(props)
    this.state = {
      number : 3
    }
  }

  render() {
    return (
      <View style={styles.container}>
        {this._renderButton("Toast Test", this._showToast)}
        {this._renderButton("Callback Test", this._addOneWithCallback)}
        <Text>{this.state.number}</Text>
      </View>
    )
  }

  _renderButton(text, onPress) {
    return (
         <TouchableHighlight
          underlayColor='grey'
          style={styles.button}
          onPress={onPress}>
          <Text style={styles.buttonText}>{text}</Text>
        </TouchableHighlight>
    )
  }

  _showToast() {
    NativeModules.AndroidNativeModule.makeToast("toast test")
  }

  _addOneWithCallback() {
    NativeModules.AndroidNativeModule.addOne(3, (n) => console.log(n))
  }
}

const styles = StyleSheet.create({
  container: {
  },
  button: {
    height: 42,
    backgroundColor: '#999',
    alignItems: 'center',
    justifyContent: 'center',
    margin: 10,
    borderRadius: 6
  },
  buttonText: {
    color: 'white',
    fontSize: 16
  }
});

AppRegistry.registerComponent('ReactNativeAndroidModule', () => ReactNativeAndroidModule);

if (__DEV__) {
	const XHR = GLOBAL.originalXMLHttpRequest ?
		GLOBAL.originalXMLHttpRequest :
		GLOBAL.XMLHttpRequest

	XMLHttpRequest = XHR
}
