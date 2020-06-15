import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "Flutter Android Interaction Demo",
      theme: new ThemeData(
        primarySwatch:  Colors.deepPurple,
      ),
      home: new MyHomepage(
          title:"Flutter Homepage"),
    );
  }
}

class MyHomepage extends StatefulWidget {

  final String title;
  MyHomepage({
    Key key,
    this.title
  }):super(key:key);

  @override
  _MyHomepageState createState() => _MyHomepageState();
}


const MethodChannel plugin = MethodChannel("android_flutter_plugin1"); // 来自原生MainActivity自定义的CHANNEL

class _MyHomepageState extends State<MyHomepage> {

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: new AppBar(
        title: new Text(widget.title),
      ),

      body: new Center(
        child: new Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            new RaisedButton(
                child: const Text("调用安卓原生界面"),
                onPressed: (){
                  //在安卓的MainActivity中写插件，点击button后调用
                  plugin.invokeMethod("interaction"); // 传值给原生MainActivity
                  print("1111111111111111111");

                })
          ],
        ),
      ),
    );
  }
}



