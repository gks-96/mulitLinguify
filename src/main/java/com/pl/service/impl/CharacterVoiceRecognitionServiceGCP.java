package com.pl.service.impl;

import com.google.cloud.speech.v1.*;
import com.google.protobuf.ByteString;
import com.pl.util.LanguageMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
public class CharacterVoiceRecognitionServiceGCP {

//    @Autowired
//    private CredentialsProvider credentialsProvider;
//
//    private SpeechSettings settings = null;
//
//    @PostConstruct
//    public void initialize() throws IOException{
//        settings = SpeechSettings.newBuilder().setCredentialsProvider(credentialsProvider).build();
//    }
     public String recognizeVoice(String encodedString,String language) throws IOException
     {

//            System.out.println("encoded file inside recognize Voice  "+ encodedString);
//            GoogleCredentials credentials = GoogleCredentialsLoader.getCredentials();

            String characterRecognized = null ;
         String languageCode = LanguageMapper.getLanguage(language);
//         try (SpeechClient speechClient = SpeechClient.create(settings))
         try (SpeechClient speechClient = SpeechClient.create())
           {
               System.out.println("client created succesfully" );
               // The path to the audio file to transcribe
//               String fileName = "/Users/gurki/Documents/intellij-workspace/punjabiLanguage/src/main/resources/sampleSounds/punjabiAudioSpeech.wav";
               byte[] decodedAudio = Base64.getDecoder().decode(encodedString);
               //        String decodedString = new String(decodedBytesCorrectImage);
               //        String decodedString = new String(encodedString);
//               ByteString imgBytes = ByteString.copyFrom(decodedBytesCorrectImage) ;
//               Path path = Paths.get(fileName);
//               byte[] data = Files.readAllBytes(path);
               ByteString audioBytes = ByteString.copyFrom(decodedAudio);
//               System.out.println("audio bytes +" + audioBytes);
               // Builds the sync recognize request
               RecognitionConfig config =
                       RecognitionConfig.newBuilder()
                                        .setEncoding(RecognitionConfig.AudioEncoding.LINEAR16)
                                        .setSampleRateHertz(44100)
                                        .setLanguageCode(languageCode)
                                        .setModel("command_and_search")
                                        .setAudioChannelCount(2)
                                        .build();

               RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

               // Performs speech recognition on the audio file
               RecognizeResponse response = speechClient.recognize(config, audio);
               List<SpeechRecognitionResult> results = response.getResultsList();
               System.out.println("result is " + results.size());
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
