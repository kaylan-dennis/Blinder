import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

Future<dynamic> signup(
    BuildContext context) async {
  final nameController = TextEditingController();
  final surnameController = TextEditingController();
  final ageController = TextEditingController();
  final emailController = TextEditingController();
  final genderController = TextEditingController();
  final preferenceController = TextEditingController();


  return showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text('Signup'),
          content: SingleChildScrollView(
            child: ListBody(
              children: <Widget>[
                TextField(
                  controller: nameController,
                  decoration: const InputDecoration(hintText: 'Name'),
                ),
                TextField(
                  controller: surnameController,
                  decoration: const InputDecoration(hintText: 'Surname'),
                ),
                TextField(
                  controller: ageController,
                  decoration: const InputDecoration(hintText: 'Age'),
                ),
                TextField(
                  controller: emailController,
                  decoration: const InputDecoration(hintText: 'Email'),
                ),
                TextField(
                  controller: genderController,
                  decoration: const InputDecoration(hintText: 'Gender'),
                ),
                TextField(
                  controller: preferenceController,
                  decoration: const InputDecoration(hintText: 'Preference'),
                ),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: const Text('CANCEL'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
            TextButton(
              child: const Text('SUBMIT'),
              onPressed: () async {

              },
            ),
          ],
        );
      });
}