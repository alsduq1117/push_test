package com.example.push_test.Service;


import java.util.List;

public class RegisterTopic {
    // These registration tokens come from the client FCM SDKs.
    List<String> registrationTokens = Arrays.asList(
            "YOUR_REGISTRATION_TOKEN_1",
            // ...
            "YOUR_REGISTRATION_TOKEN_n"
    );

    // Subscribe the devices corresponding to the registration tokens to the
// topic.
    TopicManagementResponse response = FirebaseMessaging.getInstance().subscribeToTopic(
            registrationTokens, topic);
// See the TopicManagementResponse reference documentation
// for the contents of response.
System.out.println(response.getSuccessCount() + " tokens were subscribed successfully");
}
