package com.pl.utilities;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.FileInputStream;
import java.io.IOException;

public class GoogleCredentialsLoader {

    public static GoogleCredentials getCredentials() throws IOException {

        String path="/Users/gurki/Documents/intellij-workspace/punjabiLanguage/src/main/resources/key.json";
        // Load the service account key JSON file
        FileInputStream serviceAccountStream = new FileInputStream(path);

        // Create GoogleCredentials using the service account key
        GoogleCredentials credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);

        return credentials;
    }
}
