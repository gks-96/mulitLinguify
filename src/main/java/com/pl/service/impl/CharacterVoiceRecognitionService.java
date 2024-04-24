package com.pl.service.impl;

import com.google.api.gax.core.CredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import com.pl.util.GoogleCredentialsLoader;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CharacterVoiceRecognitionService {

//    @Autowired
//    private CredentialsProvider credentialsProvider;
//
//    private SpeechSettings settings = null;
//
//    @PostConstruct
//    public void initialize() throws IOException{
//        settings = SpeechSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
//    }
     public String recognizeVoice(String encodedfile) throws IOException
     {

            System.out.println("encoded file inside recognize Voice  "+ encodedfile);
//            GoogleCredentials credentials = GoogleCredentialsLoader.getCredentials();

            String characterRecognized = null ;
//         try (SpeechClient speechClient = SpeechClient.create(settings))
         try (SpeechClient speechClient = SpeechClient.create())
           {
               System.out.println("client created succesflly" );
               // The path to the audio file to transcribe
               String fileName = "/Users/gurki/Documents/intellij-workspace/punjabiLanguage/src/main/resources/sampleSounds/punjabiAudioSpeech.wav";

               Path path = Paths.get(fileName);
               byte[] data = Files.readAllBytes(path);
               ByteString audioBytes = ByteString.copyFrom(data);
               // Builds the sync recognize request
               RecognitionConfig config =
                       RecognitionConfig.newBuilder()
                                        .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                                        .setSampleRateHertz(44100)
                                        .setLanguageCode("pa-Guru-IN")
                                        .setModel("command_and_search")
                                        .setAudioChannelCount(2)
                                        .build();

               RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

               // Performs speech recognition on the audio file
               RecognizeResponse response = speechClient.recognize(config, audio);
               List<SpeechRecognitionResult> results = response.getResultsList();

               for (SpeechRecognitionResult result : results) {
                   // There can be several alternative transcripts for a given chunk of speech. Just use the
                   // first (most likely) one here.
                   SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
                   characterRecognized = alternative.getTranscript();
                   System.out.println("Transcription " + alternative.toString());
                   System.out.printf("Transcription: %s%n", alternative.getTranscript());
                   break;
               }
           }

         return characterRecognized;
     }
}
