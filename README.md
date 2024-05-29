ReadMe File 

APIs Exposed: 

i)  **API To Perform Character Voice Recognition**
When the user submits the request, the request is received at the Character Voice Recognition Controller. The controller sends the request to the service layer. The service layer interacts with different utility classes such as Base 64 Decoder and Language Mapper to decoder the base 64 string and map it to the corresponding language that is recognized by Google ‘s Speech Text API. Afterwards, it makes a call to Google Speech to Text API and extracts the response from it and populate it in the Sound Response DTO which comprises the character, its accuracy and any error message if it exists.
![WriteServiceFlow-Page-2 drawio (1)](https://github.com/gks-96/mulitLinguify/assets/69946546/e73e0168-7059-437f-be59-ed2bab93cbfc)



ii) **API To Perform Character Write Recognition**

The controller forwards the request to the Character Write Recognition Service layer. The service layer interacts with different utility classes such as Base 64 Decoder and Language Mapper to decoder the base 64 string and map it to the corresponding language that is recognized by Google’s Cloud Vision API. Afterwards, it makes a call to Google Speech to Text API and extracts the response from it and populates it in the Write Response DTO which comprises of the character, its accuracy and any error message if it exists.
![WriteServiceFlow-Page-1 drawio](https://github.com/gks-96/mulitLinguify/assets/69946546/c321844e-3ee4-4c22-a1b5-f3c7a00cc44e)


iii) Working Demo


https://github.com/gks-96/mulitLinguify/assets/69946546/4db1a620-7aa8-40ea-8854-2103c02eaae4



https://github.com/gks-96/mulitLinguify/assets/69946546/e4150f73-f23a-484b-8e73-ade8ebd97fc0

