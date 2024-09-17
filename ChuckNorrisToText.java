package chucknorris;

import java.lang.StringBuilder;
import java.util.Scanner;

public class ChuckNorrisToText{

        static StringBuilder text = new StringBuilder();
        static StringBuilder binary = new StringBuilder();

        public void decode() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Input encoded string:");
                String encodedData = scanner.nextLine();
                binary = chunkToBinaryConverter(encodedData);

                if (!binary.isEmpty()) {
                        text = binaryToText(binary);
                        if(!text.isEmpty()){
                                System.out.println("Decoded string:");
                                System.out.println(text + "\n");
                        }

                }



        }

        static StringBuilder chunkToBinaryConverter(String input) {

                String[] chuckData =input.split(" ");

                for (int index = 0; index < chuckData.length; index++) {


                        if (chuckData[index].equals("0")) {
                                index++;
                                binary.append("1".repeat(chuckData[index].length()));

                        } else if (chuckData[index].equals("00")) {
                                index++;
                                binary.append("0".repeat(chuckData[index].length()));

                        }else{
                                System.out.println("Encoded string is not valid.\n");
                                binary.setLength(0);
                                break;
                        }
                }
                return binary;
        }

        static StringBuilder binaryToText(StringBuilder  binary){

                int t = 0;

                try {
                        for (int i = 0; i < binary.length(); i += 7) {
                                t = Integer.parseInt(binary.substring(i, i + 7), 2);
                                text.append((char) t);
                        }
                }catch (StringIndexOutOfBoundsException e){
                        System.out.println("Encoded string is not valid.\n");
                        text.setLength(0);
                }
                return text;
        }






}

